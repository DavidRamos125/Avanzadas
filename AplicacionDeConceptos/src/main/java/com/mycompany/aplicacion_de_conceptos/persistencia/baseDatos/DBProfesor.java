package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Profesor;

import java.io.IOException;
import java.util.List;

public class DBProfesor implements com.mycompany.aplicacion_de_conceptos.persistencia.CRUD<com.mycompany.aplicacion_de_conceptos.entidades.Profesor> {
    @Override
    public void crear(Profesor objecto) throws IOException, ClassNotFoundException {

    }

    @Override
    public Profesor obtener(String id) {
        return null;
    }

    @Override
    public List<Profesor> obtenerTodos() {
        return List.of();
    }

    @Override
    public void actualizar(Profesor objecto) {

    }

    @Override
    public void eliminar(String id) {

    }
}
