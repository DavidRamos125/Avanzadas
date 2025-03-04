package com.mycompany.aplicacion_de_conceptos.servicios;

import com.mycompany.aplicacion_de_conceptos.dtos.DTOPersona;
import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBPersona;

public class ServicioPersona {
    private CRUD<Persona> crud;

    public ServicioPersona() {

    }

    public void crearPersona(DTOPersona dtoPersona) {
        Persona persona = new Persona(dtoPersona.getId(), dtoPersona.getNombres(), dtoPersona.getApellidos(), dtoPersona.getEmail());
        crud = new DBPersona();
        crud.crear(persona);
        crud = new DBPersona();
        crud.crear(persona);
    }
}
