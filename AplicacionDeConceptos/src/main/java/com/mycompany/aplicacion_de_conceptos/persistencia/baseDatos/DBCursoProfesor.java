package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.CursoProfesor;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

import java.util.List;

public class DBCursoProfesor implements CRUD<CursoProfesor> {
    @Override
    public void crear(CursoProfesor objecto) {

    }

    @Override
    public CursoProfesor obtener(String id) {
        return null;
    }

    @Override
    public List<CursoProfesor> obtenerTodos() {
        return List.of();
    }

    @Override
    public void actualizar(CursoProfesor objecto) {

    }

    @Override
    public void eliminar(String id) {

    }
}
