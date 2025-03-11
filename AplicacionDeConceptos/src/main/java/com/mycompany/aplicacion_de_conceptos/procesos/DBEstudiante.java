package com.mycompany.aplicacion_de_conceptos.procesos;

import com.mycompany.aplicacion_de_conceptos.entidades.Estudiante;

import java.io.IOException;
import java.util.List;

public class DBEstudiante implements com.mycompany.aplicacion_de_conceptos.persistencia.CRUD<com.mycompany.aplicacion_de_conceptos.entidades.Estudiante> {
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
