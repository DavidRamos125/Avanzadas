package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
import com.mycompany.aplicacion_de_conceptos.fabricas.FabricaSistema;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class DBPersona implements CRUD<Persona> {
    private FabricaSistema fabrica;
    private Connection connection;

    public DBPersona() {
        this.fabrica = FabricaSistema.getInstancia();
        try {
            this.connection = fabrica.getConexion().conectar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void crear(Persona objecto) {
        String sql = "INSERT INTO Persona (ID, nombres, apellidos, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, objecto.getID());
            statement.setString(2, objecto.getNombre());
            statement.setString(3, objecto.getApellido());
            statement.setString(4, objecto.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Persona obtener(String id) {
        String sql = "SELECT * FROM Persona WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, Double.parseDouble(id)); // o setLong si usas long
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return new Persona(
                            rs.getDouble("id"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getString("email")
                    );
                }
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

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(FabricaSistema.obtenerPersona(
                        rs.getDouble("ID"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("email")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void actualizar(Persona persona) {
        String sql = "UPDATE Persona SET nombres = ?, apellidos = ?, email = ? WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getApellido());
            statement.setString(3, persona.getEmail());
            statement.setDouble(4, persona.getID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM Persona WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, Double.parseDouble(id));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}