package com.mycompany.aplicacion_de_conceptos.procesos;

import com.mycompany.aplicacion_de_conceptos.entidades.Inscripcion;
import com.mycompany.aplicacion_de_conceptos.interfaces.Servicios;
import com.mycompany.aplicacion_de_conceptos.persistencia.PersistenciaCursosInscritos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CursosInscritos implements Servicios{

    private List<Inscripcion> listado ;
    
    public CursosInscritos(){
        listado = new ArrayList<>();
    }

    public void inscribirCurso(Inscripcion inscripcion) {
        listado.add(inscripcion);
        try {
            PersistenciaCursosInscritos.guardarInscripcion(inscripcion);
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public void eliminar(Inscripcion inscripcion) {
        listado.remove(inscripcion);
    }

    public void actualizar(Inscripcion inscripcion) {
    // Recorremos la lista en busca de la inscripción que coincida
    for (int i = 0; i < listado.size(); i++) {
        if (listado.get(i).getEstudiante().getCodigo() == inscripcion.getEstudiante().getCodigo()){
            listado.get(i).setEstudiante(inscripcion.getEstudiante());
            //recordar poner la funcion de actualizar en el archivo binario
            break;
        }
    }
}

    public void guardarInformacion() {
        //falta logica
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cursos Inscritos:\n");
        for (Inscripcion inscripcion : listado) {
            sb.append(inscripcion.toString()).append("\n");
        }
        return sb.toString();
    }

    public void cargarDatos() {
        //falta logica
    }

    //implementacion de servicios
    public String imprimirPosicion(int posicion){
        return listado.get(posicion).toString();
    }
    public int cantidadActual(){
        return listado.size();
    }
    public List<String> imprimirListado(){
        List<String> listaString = new ArrayList<>();
        for(Inscripcion auxiliar:listado){
            listaString.add(auxiliar.toString());
        }
        return listaString;
    }
}
