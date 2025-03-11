package com.mycompany.aplicacion_de_conceptos.procesos;

import com.mycompany.aplicacion_de_conceptos.dtos.DTOFacultad;
import com.mycompany.aplicacion_de_conceptos.entidades.Facultad;
import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBFacultad;

public class ServicioFacultad {
    private CRUD<Facultad> crud;

    public ServicioFacultad() {
        this.crud = new DBFacultad();
    }

    public static Facultad deserializar(DTOFacultad dtoFacultad) {
        return new Facultad(
                dtoFacultad.getId(),
                dtoFacultad.getNombre(),
                InscripcionesPersonas.deserializar(dtoFacultad.getDecano())
        );
    }

    public static DTOFacultad serializar(Facultad facultad) {
        return new DTOFacultad(
                facultad.getID(),
                facultad.getNombre(),
                InscripcionesPersonas.serializar(facultad.getDecano())
        );
    }
}
