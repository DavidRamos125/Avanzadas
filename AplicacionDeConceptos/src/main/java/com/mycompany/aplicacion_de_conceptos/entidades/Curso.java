package com.mycompany.aplicacion_de_conceptos.entidades;

public class Curso {
    private int ID;
    private Programa programa;
    private boolean activo;
    
    public String toString(){
        return "ID :"+ID+"\n"+
                "Estado :"+activo+"\n"+
                "Programa :"+programa.toString();
    }
}
