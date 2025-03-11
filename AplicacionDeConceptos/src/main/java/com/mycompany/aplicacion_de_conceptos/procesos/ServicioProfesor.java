package com.mycompany.aplicacion_de_conceptos.procesos;

import com.mycompany.aplicacion_de_conceptos.dtos.DTOProfesor;
import com.mycompany.aplicacion_de_conceptos.entidades.Profesor;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBProfesor;

public class ServicioProfesor {
    private CRUD<Profesor> crud;

    public ServicioProfesor() {
        this.crud = new DBProfesor();
    }

    public void inscribir(DTOProfesor profesor) {
        try {
            crud.crear(deserializar(profesor));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void eliminar(String id) {
        crud.eliminar(id);
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
