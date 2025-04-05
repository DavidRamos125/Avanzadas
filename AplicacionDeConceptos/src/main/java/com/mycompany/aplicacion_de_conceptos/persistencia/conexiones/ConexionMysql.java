package com.mycompany.aplicacion_de_conceptos.persistencia.conexiones;

import com.mycompany.aplicacion_de_conceptos.persistencia.Conexion;
import com.mycompany.aplicacion_de_conceptos.utilidades.Propiedades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMysql implements Conexion {

    private static final String URL = Propiedades.cargarPropiedad("bd.URL");
    private static final String USER = Propiedades.cargarPropiedad("bd.USER");
    private static final String PASSWORD = Propiedades.cargarPropiedad("bd.PASSWORD");

    private static ConexionMysql instancia;
    private Connection connection;

    private ConexionMysql() {}

    public static ConexionMysql getInstancia() {
        if (instancia == null) {
            instancia = new ConexionMysql();
        }
        return instancia;
    }

    @Override
    public Connection conectar() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión a la base de datos MySQL establecida.");
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver de MySQL no encontrado.", e);
            }
        }
        return connection;
    }

    @Override
    public void desconectar() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión a la base de datos MySQL cerrada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

