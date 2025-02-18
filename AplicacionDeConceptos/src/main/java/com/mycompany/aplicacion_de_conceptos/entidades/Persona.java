/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacion_de_conceptos.entidades;

/**
 *
 * @author Estudiante_MCA
 */
public class Persona {
    private double ID;
    private String nombres;
    private String apellidos;
    private String email;
    
 public Persona(double ID, String nombres, String apellidos, String email) {
    this.ID = ID;
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.email = email;
    }
    
    public String toString(){
        return "Nombres :"+nombres+"\n"+
                "Apellidos :"+apellidos+"\n"+
                "Email :"+email;
    }
}
