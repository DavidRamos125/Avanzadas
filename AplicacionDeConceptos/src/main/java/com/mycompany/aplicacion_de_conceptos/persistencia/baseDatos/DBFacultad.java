package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Facultad;
import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
import com.mycompany.aplicacion_de_conceptos.fabricas.FabricaSistema;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBFacultad implements CRUD<Facultad> {
    private FabricaSistema fabrica;
    private Connection connection;

    public DBFacultad() {
        this.fabrica = FabricaSistema.getInstancia();
        try {
            this.connection = fabrica.getConexion().conectar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void crear(Facultad facultad) {
        String sql = "INSERT INTO Facultad (ID, nombre, decano_id) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, facultad.getID());
            pstmt.setString(2, facultad.getNombre());
            pstmt.setDouble(3, facultad.getDecano().getID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Facultad obtener(String id) {
        String sql = "SELECT f.ID, f.nombre, f.decano_id, p.nombres, p.apellidos, p.email " +
                "FROM Facultad f " +
                "LEFT JOIN Persona p ON f.decano_id = p.ID " +
                "WHERE f.ID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, Double.parseDouble(id));
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Persona decano = null;
                    if (rs.getObject("decano_id") != null) {
                        decano = FabricaSistema.obtenerPersona(
                                rs.getDouble("decano_id"),
                                rs.getString("nombres"),
                                rs.getString("apellidos"),
                                rs.getString("email")
                        );
                    }

                    return new Facultad(
                            rs.getDouble("ID"),
                            rs.getString("nombre"),
                            decano
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Facultad> obtenerTodos() {
        List<Facultad> lista = new ArrayList<>();
        String sql = "SELECT f.ID, f.nombre, f.decano_id, p.nombres, p.apellidos, p.email " +
                "FROM Facultad f " +
                "LEFT JOIN Persona p ON f.decano_id = p.ID";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Persona decano = null;
                if (rs.getObject("decano_id") != null) {
                    decano = FabricaSistema.obtenerPersona(
                            rs.getDouble("decano_id"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getString("email")
                    );
                }

                lista.add(new Facultad(
                        rs.getDouble("ID"),
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
    public void actualizar(Facultad facultad) {
        String sql = "UPDATE Facultad SET nombre = ?, decano_id = ? WHERE ID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, facultad.getNombre());

            if (facultad.getDecano() != null) {
                pstmt.setDouble(2, facultad.getDecano().getID());
            } else {
                pstmt.setNull(2, java.sql.Types.BIGINT);
            }

            pstmt.setDouble(3, facultad.getID());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM Facultad WHERE ID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, Double.parseDouble(id));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}