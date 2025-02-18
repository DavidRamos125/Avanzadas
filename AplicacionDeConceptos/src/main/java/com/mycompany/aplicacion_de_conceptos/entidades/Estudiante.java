/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacion_de_conceptos.entidades;

/**
 *
 * @author Estudiante_MCA
 */
public class Estudiante {
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
