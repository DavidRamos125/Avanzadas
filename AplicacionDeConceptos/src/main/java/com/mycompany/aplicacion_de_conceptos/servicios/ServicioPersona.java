package com.mycompany.aplicacion_de_conceptos.servicios;
import com.mycompany.aplicacion_de_conceptos.dtos.DTOPersona;
import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBPersona;

import java.util.ArrayList;
import java.util.List;

public class ServicioPersona {
    private CRUD<Persona> crud= new DBPersona();
    
    public void inscribir(DTOPersona persona){
        crud.crear(deserializar(persona));
    }
    public void eliminar(String id){
        crud.eliminar(id);
    }

    public void actualizar(DTOPersona persona){
        Persona aActualizar = deserializar(persona);
    }

    public DTOPersona obtener(String id){
        return serializar(crud.obtener(id));
    }

    public List<DTOPersona> obtenerPersonas(){
        List<Persona> lista = crud.obtenerTodos();
        List<DTOPersona> personas = new ArrayList<>();
        for(Persona persona: lista){
            personas.add(serializar(persona));
        }
        return personas;
    }


    public void guardarInformacion(DTOPersona persona) {
        crud.crear(deserializar(persona));
        System.out.println("Guardando informacion del alumno: " + persona.toString());
    }

    public static Persona deserializar(DTOPersona dto) {
        return new Persona(dto.getId(), dto.getNombres(), dto.getApellidos(), dto.getEmail());
    }

    public static DTOPersona serializar(Persona persona) {
        return new DTOPersona(persona.getID(), persona.getNombres(), persona.getApellidos(), persona.getEmail());
    }


}