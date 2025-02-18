/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacion_de_conceptos.procesos.CursoProfesor;

import com.mycompany.aplicacion_de_conceptos.persistencia.PersistenciaCursosProfesores.PersistenciaCursosProfesores;
import java.io.IOException;
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
    
    public void guardarInformacion(CursoProfesor cursoProfesor) {
        try {
            PersistenciaCursosProfesores.guardarCursoProfesor(cursoProfesor);
            System.out.println("Guardando información del curso: " + cursoProfesor.toString());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al guardar la información: " + e.getMessage());
        }
    }
    
    public List<String> toStringList() {
        List<String> result = new ArrayList<>();
        for (CursoProfesor cursoProfesor : listado) {
            result.add(cursoProfesor.toString());
        }  
        return result;
    }

    public void cargarDatos() {
        try {
            List<CursoProfesor> cursosGuardados = PersistenciaCursosProfesores.extraerListaObjetos();
            listado.addAll(cursosGuardados); // Cargar todos los cursos guardados en el archivo a la lista
            System.out.println("Datos cargados: " + cursosGuardados.size() + " cursos.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }
}
