package com.mycompany.aplicacion_de_conceptos.procesos;

import com.mycompany.aplicacion_de_conceptos.entidades.Curso;
import com.mycompany.aplicacion_de_conceptos.entidades.Facultad;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBFacultad;

public class ServicioFacultad {
    private CRUD<Facultad> crud;

    public ServicioFacultad() {
        this.crud = new DBFacultad();
    }
}
