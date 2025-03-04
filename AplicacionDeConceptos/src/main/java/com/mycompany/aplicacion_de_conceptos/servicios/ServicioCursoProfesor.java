package com.mycompany.aplicacion_de_conceptos.servicios;

import com.mycompany.aplicacion_de_conceptos.entidades.CursoProfesor;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

public class ServicioCursoProfesor {
    private CRUD<CursoProfesor> crud;
    public ServicioCursoProfesor(CRUD<CursoProfesor> crud) {
        this.crud = crud;
    }


}
