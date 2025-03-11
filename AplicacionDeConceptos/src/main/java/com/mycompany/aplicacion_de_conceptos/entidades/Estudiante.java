 package com.mycompany.aplicacion_de_conceptos.entidades;

import java.io.Serializable;

public class Estudiante extends Persona implements Serializable {
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
    
        public double getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + "\n" +
               "Programa: " + (programa != null ? programa.toString() : "No asignado") + "\n" +
               "Estado: " + (activo ? "Activo" : "Inactivo") + "\n" +
               "Promedio: " + promedio;
    }

    public double getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
