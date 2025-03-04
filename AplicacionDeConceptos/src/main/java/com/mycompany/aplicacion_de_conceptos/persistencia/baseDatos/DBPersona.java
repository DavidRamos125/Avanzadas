package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class DBPersona implements CRUD<Persona> {
    private Connection connection;

    public DBPersona() throws SQLException {
        this.connection = DBConexion.conectar();
    }

    @Override
    public void crear(Persona objecto) {
        String sql = "INSERT INTO Persona (id, nombre, apellido, email) VALUES (BIGINT, VARCHAR, VARCHAR, VARCHAR)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, objecto.getID());
            statement.setString(2, objecto.getNombres());
            statement.setString(3, objecto.getApellidos());
            statement.setString(4, objecto.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Persona obtener(String id) {
        String sql = "SELECT * FROM Persona WHERE id = BIGINT";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Persona> obtenerTodos() {
        List<Persona> lista = new ArrayList<>();
        String sql = "SELECT * FROM Persona";
        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizar(Persona objecto) {
        String sql = "UPDATE Persona SET nombre = VARCHAR, apellido = VARCHAR, email = VARCHAR WHERE id = BIGINT";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, objecto.getNombres());
            statement.setString(2, objecto.getApellidos());
            statement.setString(3, objecto.getEmail());
            statement.setDouble(4, objecto.getID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM Persona WHERE id = BIGINT";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}