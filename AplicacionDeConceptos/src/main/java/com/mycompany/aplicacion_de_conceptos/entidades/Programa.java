package com.mycompany.aplicacion_de_conceptos.entidades;

import java.io.Serializable;


public class Programa implements Serializable{
    private double ID;
    private String nombre;
    private double duracion;
    private String registro;
    private Facultad facultad;
    
    public Programa(double ID, String nombre, double duracion, String registro, Facultad facultad) {
        this.ID = ID;
        this.nombre = nombre;
        this.duracion = duracion;
        this.registro = registro;
        this.facultad = facultad;
    }
    
    public String toString(){
        return "Id :"+ID+"\n"+
                "Nombre :"+nombre+"\n"+
                "Duracion :"+duracion+"\n"+
                "Regitro :"+registro+"\n"+
                "Facultad :"+facultad.toString();
    }
}
