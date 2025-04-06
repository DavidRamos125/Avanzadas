package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Estudiante;
import com.mycompany.aplicacion_de_conceptos.entidades.Facultad;
import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
import com.mycompany.aplicacion_de_conceptos.entidades.Programa;
import com.mycompany.aplicacion_de_conceptos.fabricas.FabricaSistema;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;


public class DBEstudiante implements CRUD<Estudiante> {
    private FabricaSistema fabrica;
    private Connection connection;

    public DBEstudiante() {
        this.fabrica = FabricaSistema.getInstancia();
        try {
            this.connection = fabrica.getConexion().conectar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void crear(Estudiante objeto) {
        String sql = "INSERT INTO Estudiante (ID, codigo, programa_id, activo, promedio) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, objeto.getID());
            pstmt.setDouble(2, objeto.getCodigo());
            pstmt.setDouble(3, objeto.getPrograma().getID());
            pstmt.setBoolean(4, objeto.isActivo());
            pstmt.setDouble(5, objeto.getPromedio());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Estudiante obtener(String id) {
        String sql = "SELECT " +
                "p.ID, p.nombres, p.apellidos, p.email, " +
                "e.codigo, e.activo, e.promedio, " +
                "prog.ID AS prog_id, prog.nombre AS prog_nombre, prog.duracion, prog.registro, " +
                "fac.ID AS fac_id, fac.nombre AS fac_nombre, " +
                "dec.ID AS decano_id, dec.nombres AS decano_nombres, dec.apellidos AS decano_apellidos, dec.email AS decano_email " +
                "FROM Estudiante e " +
                "JOIN Persona p ON e.ID = p.ID " +
                "JOIN Programa prog ON e.programa_id = prog.ID " +
                "JOIN Facultad fac ON prog.facultad_id = fac.ID " +
                "JOIN Persona dec ON fac.decano_id = dec.ID " +
                "WHERE e.ID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, Double.parseDouble(id));

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    Persona decano = FabricaSistema.obtenerPersona(
                            rs.getDouble("decano_id"),
                            rs.getString("decano_nombres"),
                            rs.getString("decano_apellidos"),
                            rs.getString("decano_email")
                    );

                    Facultad facultad = FabricaSistema.obtenerFacultad(
                            rs.getDouble("fac_id"),
                            rs.getString("fac_nombre"),
                            decano
                    );

                    Programa programa = FabricaSistema.obtenerPrograma(
                            rs.getDouble("prog_id"),
                            rs.getString("prog_nombre"),
                            rs.getDouble("duracion"),
                            rs.getString("registro"),
                            facultad
                    );

                    return FabricaSistema.obtenerEstudiante(
                            rs.getDouble("ID"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getString("email"),
                            rs.getDouble("codigo"),
                            programa,
                            rs.getBoolean("activo"),
                            rs.getDouble("promedio")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Estudiante> obtenerTodos() {
        List<Estudiante> lista = new ArrayList<>();

        String sql = """
        SELECT 
            per.ID, per.nombres, per.apellidos, per.email,
            e.codigo, e.activo, e.promedio,
            prog.ID AS prog_id, prog.nombre AS prog_nombre, prog.duracion, prog.registro,
            fac.ID AS fac_id, fac.nombre AS fac_nombre,
            dec.ID AS decano_id, dec.nombres AS decano_nombres, dec.apellidos AS decano_apellidos, dec.email AS decano_email
        FROM Estudiante e
        JOIN Persona per ON e.ID = per.ID
        JOIN Programa prog ON e.programa_id = prog.ID
        JOIN Facultad fac ON prog.facultad_id = fac.ID
        JOIN Persona dec ON fac.decano_id = dec.ID
    """;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {

                Persona decano = FabricaSistema.obtenerPersona(
                        rs.getDouble("decano_id"),
                        rs.getString("decano_nombres"),
                        rs.getString("decano_apellidos"),
                        rs.getString("decano_email")
                );

                Facultad facultad = FabricaSistema.obtenerFacultad(
                        rs.getDouble("fac_id"),
                        rs.getString("fac_nombre"),
                        decano
                );

                Programa programa = FabricaSistema.obtenerPrograma(
                        rs.getDouble("prog_id"),
                        rs.getString("prog_nombre"),
                        rs.getDouble("duracion"),
                        rs.getString("registro"),
                        facultad
                );

                Estudiante estudiante = FabricaSistema.obtenerEstudiante(
                        rs.getDouble("ID"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        rs.getDouble("codigo"),
                        programa,
                        rs.getBoolean("activo"),
                        rs.getDouble("promedio")
                );

                lista.add(estudiante);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }


    @Override
    public void actualizar(Estudiante estudiante) {
        String sqlPersona = "UPDATE Persona SET nombres = ?, apellidos = ?, email = ? WHERE ID = ?";
        String sqlEstudiante = "UPDATE Estudiante SET codigo = ?, programa_id = ?, activo = ?, promedio = ? WHERE ID = ?";
        try {
            connection.setAutoCommit(false); // Inicia transacción

            try (PreparedStatement pstmtPersona = connection.prepareStatement(sqlPersona)) {
                pstmtPersona.setString(1, estudiante.getNombres());
                pstmtPersona.setString(2, estudiante.getApellidos());
                pstmtPersona.setString(3, estudiante.getEmail());
                pstmtPersona.setDouble(4, estudiante.getID());
                pstmtPersona.executeUpdate();
            }

            try (PreparedStatement pstmtEstudiante = connection.prepareStatement(sqlEstudiante)) {
                pstmtEstudiante.setDouble(1, estudiante.getCodigo());
                pstmtEstudiante.setDouble(2, estudiante.getPrograma().getID());
                pstmtEstudiante.setBoolean(3, estudiante.isActivo());
                pstmtEstudiante.setDouble(4, estudiante.getPromedio());
                pstmtEstudiante.setDouble(5, estudiante.getID());
                pstmtEstudiante.executeUpdate();
            }
            connection.commit(); // Confirma los cambios si todo sale bien
        } catch (SQLException e) {
            try {
                connection.rollback(); // Revierte los cambios si hay error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true); // Restablece auto-commit
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void eliminar(String id) {
        String sqlEstudiante = "DELETE FROM Estudiante WHERE ID = ?";
        String sqlPersona = "DELETE FROM Persona WHERE ID = ?";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement pstmtEst = connection.prepareStatement(sqlEstudiante)) {
                pstmtEst.setDouble(1, Double.parseDouble(id));
                pstmtEst.executeUpdate();
            }
            try (PreparedStatement pstmtPer = connection.prepareStatement(sqlPersona)) {
                pstmtPer.setDouble(1, Double.parseDouble(id));
                pstmtPer.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}