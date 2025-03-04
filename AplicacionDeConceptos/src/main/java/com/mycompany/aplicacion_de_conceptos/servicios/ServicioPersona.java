package com.mycompany.aplicacion_de_conceptos.servicios;

import com.mycompany.aplicacion_de_conceptos.dtos.DTOPersona;
import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

public class ServicioPersona {
    private CRUD<Persona> crud;

    public ServicioPersona(CRUD<Persona> crud) {
        this.crud = crud;
    }

    public void crearPersona(DTOPersona dtoPersona) {
        Persona persona = new Persona(dtoPersona.getId(), dtoPersona.getNombres(), dtoPersona.getApellidos(), dtoPersona.getEmail());
        crud.crear(persona);
    }
}
