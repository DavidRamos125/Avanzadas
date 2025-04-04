package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Programa;
import com.mycompany.aplicacion_de_conceptos.entidades.Facultad;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBPrograma implements CRUD<Programa> {
    private Connection connection;

    public DBPrograma() {
        try {
            this.connection = DBConexion.conectar();
        } catch (SQLException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
        }
    }
    
    public void crear(Programa objecto) {
    String sql = "INSERT INTO Programa (ID, nombre, duracion, registro, facultad_id) VALUES (BIGINT, VARCHAR, INT, VARCHAR, BIGINT)";
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
        String sql = "SELECT p.*, f.nombre AS facultad_nombre FROM Programa p " +
                     "JOIN Facultad f ON p.facultad_id = f.ID WHERE p.ID = BIGINT";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Facultad facultad = new Facultad(
                    rs.getDouble("facultad_id"),
                    rs.getString("facultad_nombre"),
                    null
                );

                return new Programa(
                    rs.getDouble("ID"),
                    rs.getString("nombre"),
                    rs.getInt("duracion"),
                    rs.getString("registro"),
                    facultad
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Programa> obtenerTodos() {
        List<Programa> lista = new ArrayList<>();
        String sql = "SELECT p.*, f.nombre AS facultad_nombre FROM Programa p " +
                     "JOIN Facultad f ON p.facultad_id = f.ID";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Facultad facultad = new Facultad(
                    rs.getDouble("facultad_id"),
                    rs.getString("facultad_nombre"),
                    null
                );

                lista.add(new Programa(
                    rs.getDouble("ID"),
                    rs.getString("nombre"),
                    rs.getInt("duracion"),
                    rs.getString("registro"),
                    facultad
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

     @Override
    public void actualizar(Programa objecto) {
        String sql = "UPDATE Programa SET nombre = VARCHAR, duracion = INT, registro = VARCHAR, facultad_id = BIGINT WHERE ID = BIGINT";
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
        String sql = "DELETE FROM Programa WHERE ID = bigint";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}