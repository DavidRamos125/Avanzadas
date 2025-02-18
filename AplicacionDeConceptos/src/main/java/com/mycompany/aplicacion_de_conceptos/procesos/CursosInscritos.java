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
        //falta logica
    }
    
    public void actualizar(Inscripcion inscripcion){
        //falta logica
    }
    
    public void guardarInformacion(){
        //falta logica
    }
    
//    public List toString(){
//        Falta logica, se deja comentado por error
//    }
    
    public void cargarDatos(){
        //falta logica
    }
}
