package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

import java.util.List;

public class DBPersona implements CRUD<Persona> {
    @Override
    public void crear(Persona objecto) {

    }

    @Override
    public Persona obtener(String id) {
        return null;
    }

    @Override
    public List<Persona> obtenerTodos() {
        return List.of();
    }

    @Override
    public void actualizar(Persona objecto) {

    }

    @Override
    public void eliminar(String id) {

    }
}
