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
}
