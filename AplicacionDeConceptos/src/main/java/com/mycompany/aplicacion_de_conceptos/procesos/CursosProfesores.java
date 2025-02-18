/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacion_de_conceptos.procesos;
import com.mycompany.aplicacion_de_conceptos.entidades.CursoProfesor;
import com.mycompany.aplicacion_de_conceptos.persistencia.PersistenciaCursosProfesores;
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
        try {
            PersistenciaCursosProfesores.guardarCursoProfesor(cursoProfesor);
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    
    public void guardarInformacion(CursoProfesor cursoProfesor) {
        try {
            PersistenciaCursosProfesores.guardarCursoProfesor(cursoProfesor);
            System.out.println("Guardando información del curso: " + cursoProfesor.toString());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al guardar la información: " + e.getMessage());
        }
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Cursos Inscritos del profesor:\n");
        for (CursoProfesor cursoProfesor : listado) {
            sb.append(cursoProfesor.toString()).append("\n");
        }
        return sb.toString();
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
