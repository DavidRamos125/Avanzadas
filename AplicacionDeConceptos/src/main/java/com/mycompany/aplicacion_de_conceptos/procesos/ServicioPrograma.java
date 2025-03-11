package com.mycompany.aplicacion_de_conceptos.procesos;

import com.mycompany.aplicacion_de_conceptos.dtos.DTOPrograma;
import com.mycompany.aplicacion_de_conceptos.entidades.Programa;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBPrograma;

import java.util.List;

public class ServicioPrograma {
    private CRUD<Programa> crud;

    public ServicioPrograma() {
        this.crud = new DBPrograma();
    }

    public List<DTOPrograma> obtenerTodos(){
        return List.of();
    }
}
