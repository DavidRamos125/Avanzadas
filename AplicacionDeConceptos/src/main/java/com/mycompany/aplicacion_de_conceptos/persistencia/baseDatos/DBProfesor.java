package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Profesor;
import com.mycompany.aplicacion_de_conceptos.fabricas.FabricaSistema;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBProfesor implements CRUD<Profesor> {
    private FabricaSistema fabrica;
    private Connection connection;

    public DBProfesor() {
        this.fabrica = FabricaSistema.getInstancia();
        try {
            this.connection = fabrica.getConexion().conectar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void crear(Profesor objecto) {
        String sqlPersona = "INSERT INTO Persona (ID, nombres, apellidos, email) VALUES (?, ?, ?, ?)";
        String sqlProfesor = "INSERT INTO Profesor (ID, tipo_contrato) VALUES (?, ?)";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement pstmtPersona = connection.prepareStatement(sqlPersona)) {
                pstmtPersona.setDouble(1, objecto.getId());
                pstmtPersona.setString(2, objecto.getNombres());
                pstmtPersona.setString(3, objecto.getApellidos());
                pstmtPersona.setString(4, objecto.getEmail());
                pstmtPersona.executeUpdate();
            }

            try (PreparedStatement pstmtProfesor = connection.prepareStatement(sqlProfesor)) {
                pstmtProfesor.setDouble(1, objecto.getId());
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
                "JOIN Profesor pr ON p.ID = pr.ID WHERE p.ID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, Double.parseDouble(id));
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return FabricaSistema.obtenerProfesor(
                            rs.getDouble("ID"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getString("email"),
                            rs.getString("tipo_contrato")
                    );
                }
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
                Profesor profesor = FabricaSistema.obtenerProfesor(
                        rs.getDouble("ID"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        rs.getString("tipo_contrato")
                );
                lista.add(profesor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }


    @Override
    public void actualizar(Profesor objecto) {
        String sqlPersona = "UPDATE Persona SET nombres = ?, apellidos = ?, email = ? WHERE ID = ?";
        String sqlProfesor = "UPDATE Profesor SET tipo_contrato = ? WHERE ID = ?";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement pstmtPersona = connection.prepareStatement(sqlPersona)) {
                pstmtPersona.setString(1, objecto.getNombres());
                pstmtPersona.setString(2, objecto.getApellidos());
                pstmtPersona.setString(3, objecto.getEmail());
                pstmtPersona.setDouble(4, objecto.getId());
                pstmtPersona.executeUpdate();
            }

            try (PreparedStatement pstmtProfesor = connection.prepareStatement(sqlProfesor)) {
                pstmtProfesor.setString(1, objecto.getTipoContrato());
                pstmtProfesor.setDouble(2, objecto.getId());
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
        String sqlProfesor = "DELETE FROM Profesor WHERE ID = ?";
        String sqlPersona = "DELETE FROM Persona WHERE ID = ?";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement pstmtProfesor = connection.prepareStatement(sqlProfesor)) {
                pstmtProfesor.setDouble(1, Double.parseDouble(id));
                pstmtProfesor.executeUpdate();
            }

            try (PreparedStatement pstmtPersona = connection.prepareStatement(sqlPersona)) {
                pstmtPersona.setDouble(1, Double.parseDouble(id));
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