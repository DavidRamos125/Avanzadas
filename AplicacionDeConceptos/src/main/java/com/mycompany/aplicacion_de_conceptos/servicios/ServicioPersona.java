package com.mycompany.aplicacion_de_conceptos.servicios;

import com.mycompany.aplicacion_de_conceptos.dtos.DTOPersona;
import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBPersona;

public class ServicioPersona {
    private CRUD<Persona> crud;

    public ServicioPersona() {
        crud = new DBPersona();
    }

    public void crearPersona(DTOPersona dtoPersona) {
        Persona persona = new Persona(dtoPersona.getId(), dtoPersona.getNombres(), dtoPersona.getApellidos(), dtoPersona.getEmail());
        crud.crear(persona);
    }

    public DTOPersona getPersona(String id) {
        Persona persona = crud.obtener(id);
        DTOPersona dtoPersona = new DTOPersona(persona.getID(), persona.getNombres(), persona.getApellidos(), persona.getEmail());
        return dtoPersona;
    }

    public void eliminarPersona(String id) {
        crud.eliminar(id);
    }
}
