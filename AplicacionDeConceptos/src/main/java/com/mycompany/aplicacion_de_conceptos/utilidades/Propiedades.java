package com.mycompany.aplicacion_de_conceptos.utilidades;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propiedades {
    public static String cargarPropiedad(String propiedad) {
        Properties propiedades = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            propiedades.load(input);
            return propiedades.getProperty(propiedad);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
