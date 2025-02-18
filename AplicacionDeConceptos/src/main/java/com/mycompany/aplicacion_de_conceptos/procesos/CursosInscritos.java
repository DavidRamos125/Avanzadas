/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacion_de_conceptos.procesos;
import com.mycompany.aplicacion_de_conceptos.entidades.Inscripcion;
import java.util.ArrayList;
import java.util.List;

public class CursosInscritos {
    private List<Inscripcion> listado = new ArrayList<>();
    
    public void inscribirCurso(Inscripcion inscripcion){
        listado.add(inscripcion);
    }
    
    public void  eliminar(Inscripcion inscripcion){
        listado.remove(inscripcion);
    }
    
    public void actualizar(Inscripcion inscripcion){
        //falta logica
    }
    
    public void guardarInformacion(){
        //falta logica
    }
    
     @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Cursos Inscritos:\n");
        for (Inscripcion inscripcion : listado) {
            sb.append(inscripcion.toString()).append("\n");
        }
        return sb.toString();
    }
    
    public void cargarDatos(){
        //falta logica
    }
}
