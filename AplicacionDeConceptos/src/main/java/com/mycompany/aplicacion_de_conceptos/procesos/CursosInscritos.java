package com.mycompany.aplicacion_de_conceptos.procesos;

import com.mycompany.aplicacion_de_conceptos.entidades.Inscripcion;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBCursoInscrito;
import com.mycompany.aplicacion_de_conceptos.persistencia.binarios.BinarioCursoInscrito;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursosInscritos implements Servicios{

    private List<Inscripcion> listado ;
    private CRUD<Inscripcion> crud;
    
    public CursosInscritos(){
        this.listado = new ArrayList<>();
        try {
            this.crud = new DBCursoInscrito();
        } catch (SQLException e) {
            System.out.println("error " + e.getMessage());
        }

    }

    public void inscribirCurso(Inscripcion inscripcion) {
        listado.add(inscripcion);
        try {
            crud.crear(inscripcion);
        } catch (ClassNotFoundException e) {
            System.out.println("Error" + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminar(Inscripcion inscripcion) {
        listado.remove(inscripcion);
        String id = String.valueOf(inscripcion.getEstudiante().getID() +","+ inscripcion.getCurso().getID() +","+ inscripcion.getAño() +","+ inscripcion.getSemestre());
        crud.eliminar(id);
    }

    public void actualizar(Inscripcion inscripcion) {
    for (int i = 0; i < listado.size(); i++) {
        if (listado.get(i).getEstudiante().getCodigo() == inscripcion.getEstudiante().getCodigo()){
            listado.get(i).setEstudiante(inscripcion.getEstudiante());
            crud.actualizar(inscripcion);
            break;
        }
    }
}

    public void guardarInformacion(Inscripcion inscripcion) {
        try {
            crud.crear(inscripcion);
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

    public void cargarDatos()  {
        listado = crud.obtenerTodos();
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
