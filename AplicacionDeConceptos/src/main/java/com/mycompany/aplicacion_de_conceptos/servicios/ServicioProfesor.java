package com.mycompany.aplicacion_de_conceptos.servicios;

import com.mycompany.aplicacion_de_conceptos.dtos.DTOProfesor;
import com.mycompany.aplicacion_de_conceptos.entidades.Profesor;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBProfesor;

import java.util.ArrayList;
import java.util.List;

public class ServicioProfesor {
    private CRUD<Profesor> crud;

    public ServicioProfesor() {
        this.crud = new DBProfesor();
    }

    public void inscribir(DTOProfesor profesor) {
        crud.crear(deserializar(profesor));
    }

    public void eliminar(String id) {
        crud.eliminar(id);
    }

    public DTOProfesor obtenerProfesor(String id){
        Profesor profesor = crud.obtener(id);
        return serializar(profesor);
    }
    
    public List<DTOProfesor> obtenerCursos() {
        List<DTOProfesor> listaDto = new ArrayList<>();
        List<Profesor> consulta = crud.obtenerTodos();
        for (Profesor profesor : consulta) {
            listaDto.add(serializar(profesor));
        }
        return listaDto;
    }
    

    public static DTOProfesor serializar(Profesor profesor) {
        return new DTOProfesor(
                profesor.getID(),
                profesor.getNombres(),
                profesor.getApellidos(),
                profesor.getEmail(),
                profesor.getTipoContrato()
        );
    }

    public static Profesor deserializar(DTOProfesor dtoProfesor) {
        return new Profesor(
                dtoProfesor.getId(),
                dtoProfesor.getNombres(),
                dtoProfesor.getApellidos(),
                dtoProfesor.getEmail(),
                dtoProfesor.getTipoContrato()
        );
    }
}
