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

    public static DTOPrograma serializar(Programa programa) {
        return new DTOPrograma(
                programa.getID(),
                programa.getNombre(),
                programa.getDuracion(),
                programa.getRegistro(),
                ServicioFacultad.serializar(programa.getFacultad())
        );
    }

    public static Programa deserializar(DTOPrograma dtoPrograma) {
        return new Programa(
                dtoPrograma.getId(),
                dtoPrograma.getNombre(),
                dtoPrograma.getDuracion(),
                dtoPrograma.getRegistro(),
                ServicioFacultad.deserializar(dtoPrograma.getFacultad()) // Conversión de DTOFacultad -> Facultad
        );
    }

}
