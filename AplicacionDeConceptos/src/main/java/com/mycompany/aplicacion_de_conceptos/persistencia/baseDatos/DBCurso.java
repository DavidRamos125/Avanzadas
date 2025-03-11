package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Curso;
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
    public void crear(Curso curso) {
        String sql = "INSERT INTO Curso (ID, nombre, programa_id, activo) VALUES (BIGINT, VARCHAR, BIGINT, BOOLEAN)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, curso.getID());
            pstmt.setString(2, curso.getNombre());
            pstmt.setDouble(3, curso.getPrograma().getID());  
            pstmt.setBoolean(4, curso.isActivo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Curso obtener(String id) {
        String sql = "SELECT * FROM Curso WHERE ID = BIGINT";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, Double.parseDouble(id));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Curso(
                    rs.getDouble("ID"),
                    rs.getString("nombre"),
                    null,
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
        String sql = "SELECT * FROM Curso";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Curso(
                    (int) rs.getDouble("ID"),
                    rs.getString("nombre"),
                    null,
                    rs.getBoolean("activo")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizar(Curso curso) {
        String sql = "UPDATE Curso SET nombre = VARCHAR, programa_id = BIGINT, activo = BOOLEAN WHERE ID = BIGINT";

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
        String sql = "DELETE FROM Curso WHERE ID = BIGINT";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, Double.parseDouble(id));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}