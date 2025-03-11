package com.mycompany.aplicacion_de_conceptos.procesos;

import com.mycompany.aplicacion_de_conceptos.entidades.Curso;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBCurso;

public class ServicioCurso {
    private CRUD<Curso> crud;

    public ServicioCurso() {
        this.crud = new DBCurso();
    }
}
