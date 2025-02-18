package com.mycompany.aplicacion_de_conceptos.entidades;

import java.io.Serializable;

public class Facultad implements Serializable{
    private double ID;
    private String nombre;
    private Persona decano;
    
    public Facultad(double ID, String nombre, Persona decano) {
        this.ID = ID;
        this.nombre = nombre;
        this.decano = decano;
    }
    
    public String toString(){
        return "Id :"+ID+"\n"+
                "Nombre :"+nombre+"\n"+
                "Decano : "+decano.toString();
    }
}
