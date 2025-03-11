package com.mycompany.aplicacion_de_conceptos.entidades;

import java.io.Serializable;


public class Programa implements Serializable{
    private long ID;
    private String nombre;
    private double duracion;
    private String registro;
    private Facultad facultad;

    public long getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDuracion() {
        return duracion;
    }

    public String getRegistro() {
        return registro;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public Programa(long ID, String nombre, double duracion, String registro, Facultad facultad) {
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
                "Facultad :"+(facultad != null ? facultad.toString() : "No asignada");
    }

    public long getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
