package com.mycompany.aplicacion_de_conceptos.dtos;

public class DTOEstudiante extends DTOPersona {
    private double codigo;
    private DTOPrograma programa;
    private boolean activo;
    private double promedio;

    // Constructor
    public DTOEstudiante(double id, String nombres, String apellidos, String email, double codigo, DTOPrograma programa, boolean activo, double promedio) {
        super(id, nombres, apellidos, email);
        this.codigo = codigo;
        this.programa = programa;
        this.activo = activo;
        this.promedio = promedio;
    }

    // Getters y Setters
    public double getCodigo() {
        return codigo;
    }

    public void setCodigo(double codigo) {
        this.codigo = codigo;
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

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
}
