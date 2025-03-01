package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Inscripcion;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

import java.util.List;

public class DBCursoInscrito implements CRUD<Inscripcion> {
    @Override
    public void crear(Inscripcion objecto) {

    }

    @Override
    public Inscripcion obtener(String id) {
        return null;
    }

    @Override
    public List<Inscripcion> obtenerTodos() {
        return List.of();
    }

    @Override
    public void actualizar(Inscripcion objecto) {

    }

    @Override
    public void eliminar(String id) {

    }
}
