package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Profesor;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBProfesor implements CRUD<Profesor> {
    private Connection connection;

    public DBProfesor() {
        try {
            this.connection = DBConexion.conectar();
        } catch (SQLException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
        }
    }

    @Override
    public void crear(Profesor objecto) {
        String sqlPersona = "INSERT INTO Persona (ID, nombres, apellidos, email) VALUES (BIGINT, VARCHAR, VARCHAR, VARCHAR)";
        String sqlProfesor = "INSERT INTO Profesor (ID, tipo_contrato) VALUES (BIGINT, VARCHAR)";

        try {
            connection.setAutoCommit(false);
            try (PreparedStatement pstmtPersona = connection.prepareStatement(sqlPersona)) {
                pstmtPersona.setLong(1, objecto.getId());
                pstmtPersona.setString(2, objecto.getNombres());
                pstmtPersona.setString(3, objecto.getApellidos());
                pstmtPersona.setString(4, objecto.getEmail());
                pstmtPersona.executeUpdate();
            }
            try (PreparedStatement pstmtProfesor = connection.prepareStatement(sqlProfesor)) {
                pstmtProfesor.setLong(1, objecto.getId());
                pstmtProfesor.setString(2, objecto.getTipoContrato());
                pstmtProfesor.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Profesor obtener(String id) {
        String sql = "SELECT p.*, pr.tipo_contrato FROM Persona p " +
                     "JOIN Profesor pr ON p.ID = pr.ID WHERE p.ID = BIGINT";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setLong(1, Long.parseLong(id));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Profesor(
                    rs.getLong("ID"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("email"),
                    rs.getString("tipo_contrato")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Profesor> obtenerTodos() {
        List<Profesor> lista = new ArrayList<>();
        String sql = "SELECT p.*, pr.tipo_contrato FROM Persona p " +
                     "JOIN Profesor pr ON p.ID = pr.ID";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Profesor(
                    rs.getLong("ID"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("email"),
                    rs.getString("tipo_contrato")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizar(Profesor objecto) {
        String sqlPersona = "UPDATE Persona SET nombres = VARCHAR, apellidos = VARCHAR, email = VARCHAR WHERE ID = BIGINT";
        String sqlProfesor = "UPDATE Profesor SET tipo_contrato = VARCHAR WHERE ID = BIGINT";

        try {
            connection.setAutoCommit(false);
            try (PreparedStatement pstmtPersona = connection.prepareStatement(sqlPersona)) {
                pstmtPersona.setString(1, objecto.getNombres());
                pstmtPersona.setString(2, objecto.getApellidos());
                pstmtPersona.setString(3, objecto.getEmail());
                pstmtPersona.setLong(4, objecto.getId());
                pstmtPersona.executeUpdate();
            }

            // Actualizar en Profesor
            try (PreparedStatement pstmtProfesor = connection.prepareStatement(sqlProfesor)) {
                pstmtProfesor.setString(1, objecto.getTipoContrato());
                pstmtProfesor.setLong(2, objecto.getId());
                pstmtProfesor.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void eliminar(String id) {
        String sqlProfesor = "DELETE FROM Profesor WHERE ID = BIGINT";
        String sqlPersona = "DELETE FROM Persona WHERE ID = BIGINT";

        try {
            connection.setAutoCommit(false);
            try (PreparedStatement pstmtProfesor = connection.prepareStatement(sqlProfesor)) {
                pstmtProfesor.setLong(1, Long.parseLong(id));
                pstmtProfesor.executeUpdate();
            }
            try (PreparedStatement pstmtPersona = connection.prepareStatement(sqlPersona)) {
                pstmtPersona.setLong(1, Long.parseLong(id));
                pstmtPersona.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}