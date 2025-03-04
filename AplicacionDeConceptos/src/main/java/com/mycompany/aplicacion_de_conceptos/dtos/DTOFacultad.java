package com.mycompany.aplicacion_de_conceptos.dtos;

public class DTOFacultad {
    private double id;
    private String nombre;
    private DTOPersona decano;

    // Constructor
    public DTOFacultad(double id, String nombre, DTOPersona decano) {
        this.id = id;
        this.nombre = nombre;
        this.decano = decano;
    }

    // Getters y Setters
    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DTOPersona getDecano() {
        return decano;
    }

    public void setDecano(DTOPersona decano) {
        this.decano = decano;
    }
}
