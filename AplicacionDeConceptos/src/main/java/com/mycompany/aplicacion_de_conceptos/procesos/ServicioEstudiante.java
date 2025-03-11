package com.mycompany.aplicacion_de_conceptos.procesos;

import com.mycompany.aplicacion_de_conceptos.entidades.Estudiante;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBEstudiante;

public class ServicioEstudiante {
    private CRUD<Estudiante> crud;

    public ServicioEstudiante() {
        this.crud = new DBEstudiante();
    }
}
