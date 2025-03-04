package com.mycompany.aplicacion_de_conceptos.persistencia;

import java.io.IOException;
import java.util.List;

public interface CRUD<T> {
    public void crear(T objecto) throws IOException, ClassNotFoundException;
    public T obtener(String id);
    public List<T> obtenerTodos();
    public void actualizar(T objecto);
    public void eliminar(String id);
}