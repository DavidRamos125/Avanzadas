package com.mycompany.aplicacion_de_conceptos.persistencia;
import java.sql.Connection;
import java.sql.SQLException;

public interface Conexion {
    Connection conectar()throws SQLException;
    void desconectar();
}
