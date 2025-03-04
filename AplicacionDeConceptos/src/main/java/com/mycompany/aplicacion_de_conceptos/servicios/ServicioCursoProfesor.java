package com.mycompany.aplicacion_de_conceptos.servicios;

import com.mycompany.aplicacion_de_conceptos.entidades.CursoProfesor;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBCursoProfesor;

public class ServicioCursoProfesor {
    private CRUD<CursoProfesor> crud;

    public ServicioCursoProfesor() {
        this.crud = new DBCursoProfesor();
    }


}
