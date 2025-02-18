/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacion_de_conceptos.procesos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante_MCA
 */
public class CursosProfesores {
    private List<CursoProfesor> listado = new ArrayList<>();
    
    public void inscribir(CursoProfesor cursoProfesor){
        listado.add(cursoProfesor);
    }
    
    public void guardarInformacion(CursoProfesor cursoProfesor){
        System.out.println("Guardando información del curso: "+cursoProfesor.toString());
    }
    
    public List<String> toStringList(){
        List<String> result = new ArrayList<>(){
        for(CursoProfesor cursoProfesor : listado){
            result.add(cursoProfesor.toString());
        }  
        return result;
        }
    }
    
    public void cargarDatos(){
        System.out.println("Cargando datos");
    }
}
