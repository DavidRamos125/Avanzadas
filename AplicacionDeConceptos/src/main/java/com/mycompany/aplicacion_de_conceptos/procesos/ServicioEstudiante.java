package com.mycompany.aplicacion_de_conceptos.procesos;

import com.mycompany.aplicacion_de_conceptos.entidades.Estudiante;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

public class ServicioEstudiante {
    private CRUD<Estudiante> crud;

    public ServicioEstudiante() {
        this.crud = new DBEstudiante();
    }
}
