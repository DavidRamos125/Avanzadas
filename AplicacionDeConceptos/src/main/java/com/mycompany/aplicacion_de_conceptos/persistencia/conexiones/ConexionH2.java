package com.mycompany.aplicacion_de_conceptos.persistencia.conexiones;

import com.mycompany.aplicacion_de_conceptos.persistencia.Conexion;
import com.mycompany.aplicacion_de_conceptos.utilidades.Propiedades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionH2 implements Conexion {

    private static final String URL = Propiedades.cargarPropiedad("bd.URL");
    private static final String USER = Propiedades.cargarPropiedad("bd.USER");
    private static final String PASSWORD = Propiedades.cargarPropiedad("bd.PASSWORD");

    private static ConexionH2 instancia;
    private Connection conexion;

    private ConexionH2() {
    }

    public static ConexionH2 getInstancia() {
        if (instancia == null) {
            instancia = new ConexionH2();
        }
        return instancia;
    }

    @Override
    public Connection conectar() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            try {
                Class.forName("org.h2.Driver");
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión a H2 establecida.");
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver no encontrado.", e);
            }
        }
        return conexion;
    }

    @Override
    public void desconectar() {
        if (conexion != null) {
            try {
                if (!conexion.isClosed()) {
                    conexion.close();
                    System.out.println("Conexión a la base de datos H2 cerrada.");
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        } else {
            System.out.println("No hay conexión activa para cerrar.");
        }
    }
}

