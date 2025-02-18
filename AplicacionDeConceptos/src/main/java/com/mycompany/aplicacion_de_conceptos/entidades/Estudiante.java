package com.mycompany.aplicacion_de_conceptos.entidades;

import java.io.Serializable;

public class Estudiante implements Serializable{
    private double codigo;
    private Programa programa;
    private boolean activo;
    private double promedio;
    
    public Estudiante(double codigo, Programa programa, boolean activo, double promedio) {
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
}
