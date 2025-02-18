package com.mycompany.aplicacion_de_conceptos.entidades;

import java.io.Serializable;

public class Persona implements Serializable{
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
