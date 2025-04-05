package com.mycompany.aplicacion_de_conceptos.fabricas;

import com.mycompany.aplicacion_de_conceptos.persistencia.Conexion;
import com.mycompany.aplicacion_de_conceptos.persistencia.conexiones.ConexionH2;
import com.mycompany.aplicacion_de_conceptos.persistencia.conexiones.ConexionMysql;
import com.mycompany.aplicacion_de_conceptos.utilidades.Propiedades;

public class FabricaSistema {
    private static FabricaSistema instancia;
    private Conexion conexion;

    private FabricaSistema() {
        this.conexion = crearConexion();
    }
    public static FabricaSistema getInstancia() {
        if (instancia == null) {
            instancia = new FabricaSistema();
        }
        return instancia;
    }

    public Conexion getConexion() {
        return conexion;
    }

    private Conexion crearConexion() {
        String tipoConexion = Propiedades.cargarPropiedad("conexion.tipo");
        switch (tipoConexion) {
            case "H2":
                return ConexionH2.getInstancia();
            case "MYSQL":
                return ConexionMysql.getInstancia();
            default:
                throw new IllegalArgumentException("Tipo de conexión no soportado: " + tipoConexion);
        }
    }
}
