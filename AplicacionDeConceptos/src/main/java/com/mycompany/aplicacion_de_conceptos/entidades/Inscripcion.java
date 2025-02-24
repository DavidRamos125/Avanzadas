package com.mycompany.aplicacion_de_conceptos.entidades;

import java.io.Serializable;

public class Inscripcion implements Serializable{
        private Curso curso;
        private int año;
        private int semestre;
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
        return "Inscripcion{" + "curso=" + curso + ", a\u00f1o=" + año + ", semestre=" + semestre + ", estudiante=" + estudiante + '}';
    }
    
    
}
