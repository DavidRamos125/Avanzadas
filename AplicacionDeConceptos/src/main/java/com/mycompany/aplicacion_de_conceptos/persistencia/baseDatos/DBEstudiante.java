package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Estudiante;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

import java.io.IOException;
import java.util.List;

public class DBEstudiante implements CRUD<Estudiante> {
    @Override
    public void crear(Estudiante objecto) throws IOException, ClassNotFoundException {

    }

    @Override
    public Estudiante obtener(String id) {
        return null;
    }

    @Override
    public List<Estudiante> obtenerTodos() {
        return List.of();
    }

    @Override
    public void actualizar(Estudiante objecto) {

    }

    @Override
    public void eliminar(String id) {

    }
}
