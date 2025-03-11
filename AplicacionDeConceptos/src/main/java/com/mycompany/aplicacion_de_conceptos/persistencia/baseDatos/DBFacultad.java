package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Facultad;

import java.io.IOException;
import java.util.List;

public class DBFacultad implements com.mycompany.aplicacion_de_conceptos.persistencia.CRUD<com.mycompany.aplicacion_de_conceptos.entidades.Facultad> {
    @Override
    public void crear(Facultad objecto) throws IOException, ClassNotFoundException {

    }

    @Override
    public Facultad obtener(String id) {
        return null;
    }

    @Override
    public List<Facultad> obtenerTodos() {
        return List.of();
    }

    @Override
    public void actualizar(Facultad objecto) {

    }

    @Override
    public void eliminar(String id) {

    }
}
