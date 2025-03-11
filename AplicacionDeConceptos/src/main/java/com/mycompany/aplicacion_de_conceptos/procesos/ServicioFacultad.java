package com.mycompany.aplicacion_de_conceptos.procesos;

import com.mycompany.aplicacion_de_conceptos.dtos.DTOFacultad;
import com.mycompany.aplicacion_de_conceptos.entidades.Facultad;
import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBFacultad;

import java.util.ArrayList;
import java.util.List;

public class ServicioFacultad {
    private CRUD<Facultad> crud;

    public ServicioFacultad() {
        this.crud = new DBFacultad();
    }

    public void añadirFacultad(DTOFacultad facultad) {
        try {
            crud.crear(deserializar(facultad));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarFacultad(String id) {
        crud.eliminar(id);
    }

    public DTOFacultad obtenerFacultad(String id) {
        DTOFacultad facultad = serializar(crud.obtener(id));
        return facultad;
    }

    public List<DTOFacultad> obtenerFacultades() {
        List<Facultad> facultades = crud.obtenerTodos();
        List<DTOFacultad> dtoFacultades = new ArrayList<>();
        for (Facultad facultad : facultades) {
            dtoFacultades.add(serializar(facultad));
        }
        return dtoFacultades;
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
