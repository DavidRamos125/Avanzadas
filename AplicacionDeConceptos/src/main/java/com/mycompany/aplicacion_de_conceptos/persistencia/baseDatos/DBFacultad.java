package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Facultad;
import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
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
    public void crear(Facultad objecto) {
        String sql = "INSERT INTO Facultad (ID, nombre, decano_id) VALUES (BIGINT, VARCHAR, BIGINT)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setLong(1, objecto.getID());
            pstmt.setString(2, objecto.getNombre());
            if (objecto.getDecano() != null) {
                pstmt.setLong(3, (long) objecto.getDecano().getID()); 
            } else {
                pstmt.setNull(3, Types.BIGINT);
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Facultad obtener(String id) {
        String sql = "SELECT f.*, p.nombres, p.apellidos, p.email FROM Facultad f " +
                     "LEFT JOIN Persona p ON f.decano_id = p.ID WHERE f.ID = BIGINT";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setLong(1, Long.parseLong(id));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Persona decano = (rs.getLong("decano_id") > 0) ? 
                    new Persona(
                        rs.getLong("decano_id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("email")
                    ) : null;

                return new Facultad(
                    rs.getLong("ID"),
                    rs.getString("nombre"),
                    decano 
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
        String sql = "SELECT f.*, p.nombres, p.apellidos, p.email FROM Facultad f " +
                     "LEFT JOIN Persona p ON f.decano_id = p.ID";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Persona decano = (rs.getLong("decano_id") > 0) ? 
                    new Persona(
                        rs.getLong("decano_id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("email")
                    ) : null;

                lista.add(new Facultad(
                    rs.getLong("ID"),
                    rs.getString("nombre"),
                    decano 
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizar(Facultad objecto) {
        String sql = "UPDATE Facultad SET nombre = ?, decano_id = ? WHERE ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, objecto.getNombre());
            if (objecto.getDecano() != null) {
                pstmt.setLong(2, (long) objecto.getDecano().getID());
            } else {
                pstmt.setNull(2, Types.BIGINT);
            }
            pstmt.setLong(3, objecto.getID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM Facultad WHERE ID = BIGINT";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setLong(1, Long.parseLong(id));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}