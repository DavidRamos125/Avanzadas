package com.mycompany.aplicacion_de_conceptos.entidades;

import java.io.Serializable;

public class Estudiante extends Persona implements Serializable{
    private double codigo;
    private Programa programa;
    private boolean activo;
    private double promedio;
    private Persona persona;

    public Programa getPrograma() {
        return programa;
    }

    public boolean isActivo() {
        return activo;
    }

    public double getPromedio() {
        return promedio;
    }

    public Persona getPersona() {
        return persona;
    }

    public Estudiante(double ID, String nombres, String apellidos, String email, double codigo, Programa programa, boolean activo, double promedio) {
        super(ID, nombres, apellidos, email);
        this.codigo = codigo;
        this.programa = programa;
        this.activo = activo;
        this.promedio = promedio;
    }
    
    public String toString(){
        return "Codigo :"+codigo+"\n"+
                "Programa :"+programa.toString()+"\n"+
                "Estado :"+activo+"\n"+
                "Promedio :"+promedio;
    }
    
    public double getCodigo(){
        return codigo;
    }
}
