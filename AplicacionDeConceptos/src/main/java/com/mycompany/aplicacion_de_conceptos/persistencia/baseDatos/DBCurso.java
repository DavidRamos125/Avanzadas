package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Curso;
import com.mycompany.aplicacion_de_conceptos.entidades.Programa;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBCurso implements CRUD<Curso> {
    private Connection connection;

    public DBCurso() {
        try {
            this.connection = DBConexion.conectar();
        } catch (SQLException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
        }
    }
    
    @Override
    public void crear(Curso objecto) {
        String sql = "INSERT INTO Curso (ID, nombre, programa_id, activo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setLong(1, objecto.getID());
            pstmt.setString(2, objecto.getNombre());
            pstmt.setLong(3, (long) objecto.getPrograma().getID());
            pstmt.setBoolean(4, objecto.isActivo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Curso obtener(String id) {
        String sql = "SELECT c.*, p.nombre AS programa_nombre, p.duracion, p.registro FROM Curso c " +
                     "JOIN Programa p ON c.programa_id = p.ID WHERE c.ID = BIGINT";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setLong(1, Long.parseLong(id));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Programa programa = new Programa(
                    rs.getLong("programa_id"),
                    rs.getString("programa_nombre"),
                    rs.getInt("duracion"),
                    rs.getString("registro")
                );

                return new Curso(
                    (int) rs.getLong("ID"),
                    rs.getString("nombre"),
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
        String sql = "SELECT c.*, p.nombre AS programa_nombre, p.duracion, p.registro FROM Curso c " +
                     "JOIN Programa p ON c.programa_id = p.ID";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Programa programa = new Programa(
                    rs.getLong("programa_id"),
                    rs.getString("programa_nombre"),
                    rs.getInt("duracion"),
                    rs.getString("registro")
                );

                lista.add(new Curso(
                    (int) rs.getLong("ID"),
                    rs.getString("nombre"),
                    programa,
                    rs.getBoolean("activo")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizar(Curso objecto) {
        String sql = "UPDATE Curso SET nombre = VARCHAR, programa_id = BIGINT, activo = BOOOLEAN WHERE ID = BIGINT";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, objecto.getNombre());
            pstmt.setLong(2, (long) objecto.getPrograma().getID());
            pstmt.setBoolean(3, objecto.isActivo());
            pstmt.setLong(4, objecto.getID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM Curso WHERE ID = BIGINT";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setLong(1, Long.parseLong(id));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}