package com.mycompany.aplicacion_de_conceptos.entidades;

import java.io.Serializable;

public class Inscripcion implements Serializable{
        private Curso curso;
        private int año;
        private int semestre;

    public Curso getCurso() {
        return curso;
    }

    public int getAño() {
        return año;
    }

    public int getSemestre() {
        return semestre;
    }
        private Estudiante estudiante;
    
    public Inscripcion(Curso curso, int año, int semestre, Estudiante estudiante) {
        this.curso = curso;
        this.año = año;
        this.semestre = semestre;
        this.estudiante = estudiante;
    }
    
    public Estudiante getEstudiante(){
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }     

    @Override
    public String toString() {
        return "Inscripcion{" + "curso=" + curso + ", ano=" + año + ", semestre=" + semestre + ", estudiante=" + estudiante + '}';
    }
    
    
}
