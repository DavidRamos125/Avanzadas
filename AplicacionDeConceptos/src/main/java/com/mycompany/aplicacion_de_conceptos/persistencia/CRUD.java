package com.mycompany.aplicacion_de_conceptos.persistencia;

import com.mycompany.aplicacion_de_conceptos.entidades.Estudiante;

import java.io.IOException;
import java.util.List;

public interface CRUD<T> {
    public void crear(T objecto);
    public T obtener(String id);
    public List<T> obtenerTodos();
    public void actualizar(T objecto);
    public void eliminar(String id);
}