package com.mycompany.aplicacion_de_conceptos.entidades;

import com.mycompany.aplicacion_de_conceptos.entidades.Profesor;
import com.mycompany.aplicacion_de_conceptos.entidades.Curso;
/**
 *
 * @author Estudiante_MCA
 */
public class CursoProfesor {
    private Profesor profesor;
    private Integer año;
    private Integer semestre;
    private Curso curso;
    
    public CursoProfesor(Profesor profesor, Integer año, Integer semestre, Curso curso){
        this.profesor = profesor;
        this.año = año;
        this.semestre = semestre;
        this.curso = curso;
    }
    public String toString(){
        return "Profesor: "+profesor+"\n"+
               "Año: "+año+"\n"+
               "Semestre:"+semestre+"\n"+
               "Curso: "+curso;
    }
}
