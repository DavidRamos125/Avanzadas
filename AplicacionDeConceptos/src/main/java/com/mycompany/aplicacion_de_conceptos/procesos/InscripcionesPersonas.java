package com.mycompany.aplicacion_de_conceptos.procesos;
import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBPersona;
import com.mycompany.aplicacion_de_conceptos.persistencia.binarios.BinarioPersona;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InscripcionesPersonas {
    private List<Persona> listado = new ArrayList<>();
    private CRUD<Persona> crud= new DBPersona();
    
    public void inscribir(Persona persona){
        listado.add(persona);
        try {
            crud.crear(persona);
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    public void eliminar(Persona persona){
        if(listado.contains(persona)){
            listado.remove(persona);
            BinarioPersona.guardarLista(listado);
        }
    }
    public void actualizar(Persona persona){
        for(int i=0; i<listado.size(); i++){
            if(listado.get(i).getID() == persona.getID()){
                listado.set(i, persona);
                BinarioPersona.guardarLista(listado);
            }
        }
    }
    public void guardarInformacion(Persona persona) {
        try {
            crud.crear(persona);
            System.out.println("Guardando informacion del alumno: " + persona.toString());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al guardar la informacion: " + e.getMessage());
        }
    } 
    public void cargarDatos() {
            List<Persona> personasGuardadas = crud.obtenerTodos();
            listado.addAll(personasGuardadas); // Cargar todos los cursos guardados en el archivo a la lista
            System.out.println("Datos cargados: " + personasGuardadas.size() + " personas.");
    }
}