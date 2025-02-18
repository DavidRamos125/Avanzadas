/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacion_de_conceptos.procesos;
import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
import com.mycompany.aplicacion_de_conceptos.persistencia.PersistenciaPersonas;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Estudiante_MCA
 */
public class InscripcionesPersonas {
    private List<Persona> listado = new ArrayList<>();
    
    public void inscribir(Persona persona){
        listado.add(persona);
        try {
            PersistenciaPersonas.guardarPersona(persona);
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    public void eliminar(Persona persona){
        
    }
    public void actualizar(Persona persona){
        
    }
    public void guardarInformacion(Persona persona) {
        try {
            PersistenciaPersonas.guardarPersona(persona);
            System.out.println("Guardando información del alumno: " + persona.toString());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al guardar la información: " + e.getMessage());
        }
    } 
    public void cargarDatos() {
        try {
            List<Persona> personasGuardadas = PersistenciaPersonas.extraerListaObjetos();
            listado.addAll(personasGuardadas); // Cargar todos los cursos guardados en el archivo a la lista
            System.out.println("Datos cargados: " + personasGuardadas.size() + " personas.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }
}