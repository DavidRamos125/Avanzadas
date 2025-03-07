package com.mycompany.aplicacion_de_conceptos.entidades;

import java.io.Serializable;

public class Curso implements Serializable{
    private int ID;
    private String nombre;
    private Programa programa;
    private boolean activo;
    
    public Curso(int ID,String nombre ,Programa programa, boolean activo) {
        this.ID = ID;
        this.nombre=nombre;
        this.programa = programa;
        this.activo = activo;
    }
    
    public String toString(){
        return "ID :"+ID+"\n"+
                "Estado :"+activo+"\n"+
                "Programa :"+programa.toString();
    }
}
