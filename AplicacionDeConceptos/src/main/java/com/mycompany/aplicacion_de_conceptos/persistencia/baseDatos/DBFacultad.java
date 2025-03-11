package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Facultad;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBFacultad implements CRUD<Facultad> {
    private Connection connection;

    public DBFacultad() {
        try {
            this.connection = DBConexion.conectar();
        } catch (SQLException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
        }
    }

    @Override
    public void crear(Facultad facultad) {
        String sql = "INSERT INTO Facultad (ID, nombre) VALUES (BIGINT, VARCHAR)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, facultad.getID());
            pstmt.setString(2, facultad.getNombre());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Facultad obtener(String id) {
        String sql = "SELECT * FROM Facultad WHERE ID = BIGINT";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, Double.parseDouble(id));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Facultad(
                    rs.getDouble("ID"),
                    rs.getString("nombre"),
                    null
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Facultad> obtenerTodos() {
        List<Facultad> lista = new ArrayList<>();
        String sql = "SELECT * FROM Facultad";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Facultad(
                    rs.getDouble("ID"),
                    rs.getString("nombre"),
                    null
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizar(Facultad facultad) {
        String sql = "UPDATE Facultad SET nombre = VARCHAR WHERE ID = BIGINT";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, facultad.getNombre());
            pstmt.setDouble(2, facultad.getID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM Facultad WHERE ID = BIGINT";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, Double.parseDouble(id));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}