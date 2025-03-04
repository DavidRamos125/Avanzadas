package com.mycompany.aplicacion_de_conceptos.dtos;

public class DTOPrograma {
    private double id;
    private String nombre;
    private double duracion;
    private String registro;
    private DTOFacultad facultad;

    // Constructor
    public DTOPrograma(double id, String nombre, double duracion, String registro, DTOFacultad facultad) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.registro = registro;
        this.facultad = facultad;
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

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public DTOFacultad getFacultad() {
        return facultad;
    }

    public void setFacultad(DTOFacultad facultad) {
        this.facultad = facultad;
    }
}
