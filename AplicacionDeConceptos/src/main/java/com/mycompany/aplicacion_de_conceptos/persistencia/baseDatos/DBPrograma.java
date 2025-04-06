package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
import com.mycompany.aplicacion_de_conceptos.entidades.Programa;
import com.mycompany.aplicacion_de_conceptos.entidades.Facultad;
import com.mycompany.aplicacion_de_conceptos.fabricas.FabricaSistema;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBPrograma implements CRUD<Programa> {
    private FabricaSistema fabrica;
    private Connection connection;

    public DBPrograma() {
        this.fabrica = FabricaSistema.getInstancia();
        try {
            this.connection = fabrica.getConexion().conectar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void crear(Programa objecto) {
        String sql = "INSERT INTO Programa (ID, nombre, duracion, registro, facultad_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, objecto.getID());
            pstmt.setString(2, objecto.getNombre());
            pstmt.setDouble(3, objecto.getDuracion());
            pstmt.setString(4, objecto.getRegistro());
            pstmt.setDouble(5, objecto.getFacultad().getID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Programa obtener(String id) {
        String sql = "SELECT p.*, " +
                "f.nombre AS facultad_nombre, f.decano_id, " +
                "per.nombres AS decano_nombres, per.apellidos AS decano_apellidos, per.email AS decano_email " +
                "FROM Programa p " +
                "JOIN Facultad f ON p.facultad_id = f.ID " +
                "JOIN Persona per ON f.decano_id = per.ID " +
                "WHERE p.ID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, Double.parseDouble(id));
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
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

                    return FabricaSistema.obtenerPrograma(
                            rs.getDouble("ID"),
                            rs.getString("nombre"),
                            rs.getInt("duracion"),
                            rs.getString("registro"),
                            facultad
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public List<Programa> obtenerTodos() {
        List<Programa> lista = new ArrayList<>();
        String sql = "SELECT p.*, " +
                "f.nombre AS facultad_nombre, f.decano_id, " +
                "per.nombres AS decano_nombres, per.apellidos AS decano_apellidos, per.email AS decano_email " +
                "FROM Programa p " +
                "JOIN Facultad f ON p.facultad_id = f.ID " +
                "JOIN Persona per ON f.decano_id = per.ID";

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
                        rs.getDouble("ID"),
                        rs.getString("nombre"),
                        rs.getInt("duracion"),
                        rs.getString("registro"),
                        facultad
                );

                lista.add(programa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void actualizar(Programa objecto) {
        String sql = "UPDATE Programa SET nombre = ?, duracion = ?, registro = ?, facultad_id = ? WHERE ID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, objecto.getNombre());
            pstmt.setInt(2, (int) objecto.getDuracion());
            pstmt.setString(3, objecto.getRegistro());
            pstmt.setDouble(4, objecto.getFacultad().getID());
            pstmt.setDouble(5, objecto.getID());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM Programa WHERE ID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, Double.parseDouble(id));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}