package com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos;

import com.mycompany.aplicacion_de_conceptos.entidades.Programa;

import java.io.IOException;
import java.util.List;

public class DBPrograma implements com.mycompany.aplicacion_de_conceptos.persistencia.CRUD<com.mycompany.aplicacion_de_conceptos.entidades.Programa> {
    @Override
    public void crear(Programa objecto) throws IOException, ClassNotFoundException {

    }

    @Override
    public Programa obtener(String id) {
        return null;
    }

    @Override
    public List<Programa> obtenerTodos() {
        return List.of();
    }

    @Override
    public void actualizar(Programa objecto) {

    }

    @Override
    public void eliminar(String id) {

    }
}
