package com.mycompany.aplicacion_de_conceptos.dtos;

public class DTOCursoInscrito {
    private DTOCurso curso;
    private int año;
    private int semestre;
    private DTOEstudiante estudiante;

    // Constructor
    public DTOCursoInscrito(DTOCurso curso, int año, int semestre, DTOEstudiante estudiante) {
        this.curso = curso;
        this.año = año;
        this.semestre = semestre;
        this.estudiante = estudiante;
    }

    // Getters y Setters
    public DTOCurso getCurso() {
        return curso;
    }

    public void setCurso(DTOCurso curso) {
        this.curso = curso;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public DTOEstudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(DTOEstudiante estudiante) {
        this.estudiante = estudiante;
    }
}
