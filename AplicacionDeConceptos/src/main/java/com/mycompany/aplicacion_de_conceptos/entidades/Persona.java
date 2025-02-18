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
    double ID;
    String nombres;
    String apellidos;
    String email;
    
    
    public String toStrong(){
        return "Nombres :"+nombres+"\n"+
                "Apellidos :"+apellidos+"\n"+
                "Email :"+email;
    }
}
