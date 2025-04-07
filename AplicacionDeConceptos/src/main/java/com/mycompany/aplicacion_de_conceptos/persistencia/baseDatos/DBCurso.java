package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Curso;
import com.mycompany.aplicacion_de_conceptos.entidades.Facultad;
import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
import com.mycompany.aplicacion_de_conceptos.entidades.Programa;
import com.mycompany.aplicacion_de_conceptos.fabricas.FabricaSistema;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBCurso implements CRUD<Curso> {
    private FabricaSistema fabrica;
    private Connection connection;

    public DBCurso() {
        this.fabrica = FabricaSistema.getInstancia();
        try {
            this.connection = fabrica.getConexion().conectar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void crear(Curso curso) {
        String sql = "INSERT INTO Curso (ID, nombre, programa_id, activo) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, curso.getID());
            pstmt.setString(2, curso.getNombre());
            pstmt.setDouble(3, curso.getPrograma().getID());
            pstmt.setBoolean(4, curso.isActivo());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Aquí puedes usar logger si prefieres
        }
    }

    @Override
    public Curso obtener(String id) {
        String sql = "SELECT c.ID AS curso_id, c.nombre AS curso_nombre, c.activo, " +
                "p.ID AS prog_id, p.nombre AS prog_nombre, p.duracion, p.registro, " +
                "f.ID AS fac_id, f.nombre AS fac_nombre, " +
                "dec.ID AS decano_id, dec.nombres AS decano_nombres, dec.apellidos AS decano_apellidos, dec.email AS decano_email " +
                "FROM Curso c " +
                "JOIN Programa p ON c.programa_id = p.ID " +
                "JOIN Facultad f ON p.facultad_id = f.ID " +
                "JOIN Persona dec ON f.decano_id = dec.ID " +
                "WHERE c.ID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, Double.parseDouble(id)); // O usa setInt si ID es entero
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Persona decano = new Persona(
                        rs.getDouble("decano_id"),
                        rs.getString("decano_nombres"),
                        rs.getString("decano_apellidos"),
                        rs.getString("decano_email")
                );

                Facultad facultad = new Facultad(
                        rs.getDouble("fac_id"),
                        rs.getString("fac_nombre"),
                        decano
                );

                Programa programa = new Programa(
                        rs.getDouble("prog_id"),
                        rs.getString("prog_nombre"),
                        rs.getDouble("duracion"),
                        rs.getString("registro"),
                        facultad
                );

                return new Curso(
                        rs.getDouble("curso_id"),
                        rs.getString("curso_nombre"),
                        programa,
                        rs.getBoolean("activo")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Curso> obtenerTodos() {
        List<Curso> lista = new ArrayList<>();
        String sql = """
        SELECT c.ID AS curso_id, c.nombre AS curso_nombre, c.activo,
               p.ID AS programa_id, p.nombre AS programa_nombre, 
               p.duracion, p.registro,
               f.ID AS facultad_id, f.nombre AS facultad_nombre,
               dec.ID AS decano_id, dec.nombres AS decano_nombres, 
               dec.apellidos AS decano_apellidos, dec.email AS decano_email
        FROM Curso c
        JOIN Programa p ON c.programa_id = p.ID
        JOIN Facultad f ON p.facultad_id = f.ID
        JOIN Persona dec ON f.decano_id = dec.ID
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
                        rs.getDouble("facultad_id"),
                        rs.getString("facultad_nombre"),
                        decano
                );

                Programa programa = FabricaSistema.obtenerPrograma(
                        rs.getDouble("programa_id"),
                        rs.getString("programa_nombre"),
                        rs.getDouble("duracion"),
                        rs.getString("registro"),
                        facultad
                );

                Curso curso = FabricaSistema.obtenerCurso(
                        rs.getDouble("curso_id"),
                        rs.getString("curso_nombre"),
                        programa,
                        rs.getBoolean("activo")
                );

                lista.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void actualizar(Curso curso) {
        String sql = "UPDATE Curso SET nombre = ?, programa_id = ?, activo = ? WHERE ID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, curso.getNombre());
            pstmt.setDouble(2, curso.getPrograma().getID());
            pstmt.setBoolean(3, curso.isActivo());
            pstmt.setDouble(4, curso.getID());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM Curso WHERE ID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, Double.parseDouble(id));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}