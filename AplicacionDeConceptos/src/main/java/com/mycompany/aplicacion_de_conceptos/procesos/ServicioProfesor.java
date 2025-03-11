package com.mycompany.aplicacion_de_conceptos.procesos;

import com.mycompany.aplicacion_de_conceptos.entidades.Profesor;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBProfesor;

public class ServicioProfesor {
    private CRUD<Profesor> crud;

    public ServicioProfesor() {
        this.crud = new DBProfesor();
    }
}
