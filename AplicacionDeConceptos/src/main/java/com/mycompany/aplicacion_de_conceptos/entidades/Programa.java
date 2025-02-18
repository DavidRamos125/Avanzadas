/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacion_de_conceptos.entidades;

/**
 *
 * @author Estudiante_MCA
 */
class Programa {
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
