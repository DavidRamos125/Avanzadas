package com.mycompany.aplicacion_de_conceptos.dtos;

public class DTOCurso {
    private int id;
    private String nombre;
    private DTOPrograma programa;
    private boolean activo;

    // Constructor
    public DTOCurso(int id, String nombre, DTOPrograma programa, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.programa = programa;
        this.activo = activo;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DTOPrograma getPrograma() {
        return programa;
    }

    public void setPrograma(DTOPrograma programa) {
        this.programa = programa;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
