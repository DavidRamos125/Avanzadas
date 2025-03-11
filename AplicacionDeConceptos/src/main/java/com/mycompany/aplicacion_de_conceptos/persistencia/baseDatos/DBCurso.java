package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Curso;

import java.io.IOException;
import java.util.List;

public class DBCurso implements com.mycompany.aplicacion_de_conceptos.persistencia.CRUD<com.mycompany.aplicacion_de_conceptos.entidades.Curso> {
    @Override
    public void crear(Curso objecto) throws IOException, ClassNotFoundException {

    }

    @Override
    public Curso obtener(String id) {
        return null;
    }

    @Override
    public List<Curso> obtenerTodos() {
        return List.of();
    }

    @Override
    public void actualizar(Curso objecto) {

    }

    @Override
    public void eliminar(String id) {

    }
}
