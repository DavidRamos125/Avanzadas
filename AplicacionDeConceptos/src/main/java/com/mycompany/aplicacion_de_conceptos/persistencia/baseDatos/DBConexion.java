package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.utilidades.Propiedades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConexion {
    private static final String URL = Propiedades.cargarPropiedad("bd.URL");
    private static final String USER = Propiedades.cargarPropiedad("bd.USER");
    private static final String PASSWORD = Propiedades.cargarPropiedad("bd.PASSWORD");
    private Connection connection;

    public static Connection conectar() throws SQLException {
        Connection con = null;
        try {
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver no encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
        return con;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
