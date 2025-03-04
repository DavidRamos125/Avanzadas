package com.mycompany.aplicacion_de_conceptos.dtos;

public class DTOCursoProfesor {
    private DTOProfesor profesor;
    private Integer año;
    private Integer semestre;
    private DTOCurso curso;

    // Constructor
    public DTOCursoProfesor(DTOProfesor profesor, Integer año, Integer semestre, DTOCurso curso) {
        this.profesor = profesor;
        this.año = año;
        this.semestre = semestre;
        this.curso = curso;
    }

    // Getters y Setters
    public DTOProfesor getProfesor() {
        return profesor;
    }

    public void setProfesor(DTOProfesor profesor) {
        this.profesor = profesor;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public DTOCurso getCurso() {
        return curso;
    }

    public void setCurso(DTOCurso curso) {
        this.curso = curso;
    }
}
