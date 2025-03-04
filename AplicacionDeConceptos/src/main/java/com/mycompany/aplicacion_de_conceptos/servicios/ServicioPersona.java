package com.mycompany.aplicacion_de_conceptos.servicios;

import com.mycompany.aplicacion_de_conceptos.dtos.DTOPersona;
import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBPersona;
import com.mycompany.aplicacion_de_conceptos.persistencia.binarios.BinarioPersona;

import java.io.IOException;

public class ServicioPersona {
    private CRUD<Persona> crud;

    public ServicioPersona() {
        crud = new BinarioPersona();
    }

    public void crearPersona(DTOPersona dtoPersona) throws IOException, ClassNotFoundException {
        Persona persona = new Persona(dtoPersona.getId(), dtoPersona.getNombres(), dtoPersona.getApellidos(), dtoPersona.getEmail());
        try {
            crud.crear(persona);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public DTOPersona getPersona(String id) {
        Persona persona = crud.obtener(id);
        DTOPersona dtoPersona = new DTOPersona(persona.getID(), persona.getNombres(), persona.getApellidos(), persona.getEmail());
        return dtoPersona;
    }

    public void eliminarPersona(String id) {
        crud.eliminar(id);
    }

    public void actualizarPersona(DTOPersona dtoPersona) {
        Persona persona = new Persona(dtoPersona.getId(), dtoPersona.getNombres(), dtoPersona.getApellidos(), dtoPersona.getEmail());
        crud.actualizar(persona);
    }
}
