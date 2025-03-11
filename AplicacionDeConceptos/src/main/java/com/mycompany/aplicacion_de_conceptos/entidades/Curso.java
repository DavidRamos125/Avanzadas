package com.mycompany.aplicacion_de_conceptos.entidades;

import java.io.Serializable;

public class Curso implements Serializable{
    private double ID;
    private String nombre;
    private Programa programa;
    private boolean activo;
    
    public Curso(double ID,String nombre ,Programa programa, boolean activo) {
        this.ID = ID;
        this.nombre=nombre;
        this.programa = programa;
        this.activo = activo;
    }

    public double getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public Programa getPrograma() {
        return programa;
    }

    public boolean isActivo() {
        return activo;
    }
    
    public String toString(){
        return "ID :"+ID+"\n"+
                "Estado :"+activo+"\n"+
                "Programa :"+(programa != null ? programa.toString() : "No asignado");
    }
}
