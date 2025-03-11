package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Estudiante;
import com.mycompany.aplicacion_de_conceptos.entidades.Programa;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;


public class DBEstudiante implements CRUD<Estudiante> {
    private Connection connection;

    public DBEstudiante() {
        try {
            this.connection = DBConexion.conectar();
        }catch (SQLException ex) {
            System.out.println("error en la conexion: " + ex.getMessage());
        }

    }

    @Override
    public void crear(Estudiante objecto) {
        String sql = "INSERT INTO Estudiante (ID, codigo, programa_id, activo, promedio) VALUES (BIGINT, BIGINT, BIGINT, BOOLEAN, DOUBLE)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, objecto.getID());
            pstmt.setDouble(2, objecto.getCodigo());
            pstmt.setDouble(3, objecto.getPrograma().getID());
            pstmt.setBoolean(4, objecto.isActivo());
            pstmt.setDouble(5, objecto.getPromedio());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override 
    public Estudiante obtener(String id) {
        String sql = "SELECT e.*, p.nombre AS programa_nombre, p.duracion, p.registro FROM Estudiante e " +
                     "JOIN Programa p ON e.programa_id = p.ID WHERE e.ID = BIGINT";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Programa programa = new Programa(
                    rs.getDouble("programa_id"),
                    rs.getString("programa_nombre"),
                    rs.getInt("duracion"),
                    rs.getString("registro")
                );

                return new Estudiante(
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Estudiante> obtenerTodos() {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT e.*, p.nombre AS programa_nombre, p.duracion, p.registro FROM Estudiante e " +
                     "JOIN Programa p ON e.programa_id = p.ID";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Programa programa = new Programa(
                    rs.getDouble("programa_id"),
                    rs.getString("programa_nombre"),
                    rs.getInt("duracion"),
                    rs.getString("registro")
                );
                lista.add(new Estudiante(
                    rs.getDouble("ID"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("email"),
                    rs.getDouble("codigo"),
                    programa,
                    rs.getBoolean("activo"),
                    rs.getDouble("promedio")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizar(Estudiante objecto) {
        String sql = "UPDATE Estudiante SET codigo = BIGINT, programa_id = BIGINT, activo = BOOLEAN, promedio = DOUBLE WHERE ID = BIGINT";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, objecto.getCodigo());
            pstmt.setDouble(2, objecto.getPrograma().getId());
            pstmt.setBoolean(3, objecto.isActivo());
            pstmt.setDouble(4, objecto.getPromedio());
            pstmt.setDouble(5, objecto.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM Estudiante WHERE ID = BIGINT";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setLong(1, Long.parseLong(id));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}