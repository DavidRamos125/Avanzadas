/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacion_de_conceptos.procesos;
import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
import com.mycompany.aplicacion_de_conceptos.persistencia.binarios.BinarioPersona;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Estudiante_MCA
 */
public class InscripcionesPersonas {
    private List<Persona> listado = new ArrayList<>();
    private BinarioPersona binario = new BinarioPersona();
    
    public void inscribir(Persona persona){
        listado.add(persona);
        try {
            binario.crear(persona);
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
            binario.crear(persona);
            System.out.println("Guardando informacion del alumno: " + persona.toString());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al guardar la informacion: " + e.getMessage());
        }
    } 
    public void cargarDatos() {
            List<Persona> personasGuardadas = binario.obtenerTodos();
            listado.addAll(personasGuardadas); // Cargar todos los cursos guardados en el archivo a la lista
            System.out.println("Datos cargados: " + personasGuardadas.size() + " personas.");
    }
}