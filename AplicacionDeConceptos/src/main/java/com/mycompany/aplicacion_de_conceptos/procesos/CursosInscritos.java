package com.mycompany.aplicacion_de_conceptos.procesos;

import com.mycompany.aplicacion_de_conceptos.entidades.Inscripcion;
import com.mycompany.aplicacion_de_conceptos.persistencia.binarios.BinarioCursoInscrito;

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
            BinarioCursoInscrito.guardarInscripcion(inscripcion);
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public void eliminar(Inscripcion inscripcion) {
        listado.remove(inscripcion);
        BinarioCursoInscrito.guardarLista(listado);
    }

    public void actualizar(Inscripcion inscripcion) {
    // Recorremos la lista en busca de la inscripción que coincida
    for (int i = 0; i < listado.size(); i++) {
        if (listado.get(i).getEstudiante().getCodigo() == inscripcion.getEstudiante().getCodigo()){
            listado.get(i).setEstudiante(inscripcion.getEstudiante());
            BinarioCursoInscrito.guardarLista(listado);
            break;
        }
    }
}

    public void guardarInformacion(Inscripcion inscripcion) {
        try {
            BinarioCursoInscrito.guardarInscripcion(inscripcion);
            System.out.println("Guardando informacion de la inscripcion: " + inscripcion.toString());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al guardar la informacion: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cursos Inscritos:\n");
        for (Inscripcion inscripcion : listado) {
            sb.append(inscripcion.toString()).append("-----------\n");
        }
        sb.append("--------\n");
        return sb.toString();
    }

    public void cargarDatos() throws IOException, ClassNotFoundException {

        listado = BinarioCursoInscrito.extraerListaObjetos();
    }

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
