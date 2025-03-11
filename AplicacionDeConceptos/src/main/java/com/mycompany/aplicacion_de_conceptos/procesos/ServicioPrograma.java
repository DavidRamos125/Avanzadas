package com.mycompany.aplicacion_de_conceptos.procesos;

import com.mycompany.aplicacion_de_conceptos.dtos.DTOPrograma;
import com.mycompany.aplicacion_de_conceptos.entidades.Programa;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBPrograma;

import java.util.ArrayList;
import java.util.List;

public class ServicioPrograma {
    private CRUD<Programa> crud;

    public ServicioPrograma() {
        this.crud = new DBPrograma();
    }

    public void insertarPrograma(DTOPrograma programa){
        try {
            crud.crear(deserializar(programa));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void eliminarPrograma(String id){
        crud.eliminar(id);
    }

    public DTOPrograma obtenerPrograma(String id){
        return serializar(crud.obtener(id));
    }

    public List<DTOPrograma> obtenerProgramas(){
        List<Programa> programas= crud.obtenerTodos();
        List<DTOPrograma> dtoProgramas= new ArrayList<>();
        for(Programa programa: programas){
            dtoProgramas.add(serializar(programa));
        }
        return dtoProgramas;
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
