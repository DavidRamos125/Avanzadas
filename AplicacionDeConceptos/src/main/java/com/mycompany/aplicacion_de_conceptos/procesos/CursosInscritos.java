package com.mycompany.aplicacion_de_conceptos.procesos;

import com.mycompany.aplicacion_de_conceptos.dtos.DTOCursoInscrito;
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

    public void inscribirCurso(DTOCursoInscrito inscripcion) {
        listado.add(deserializar(inscripcion));
        try {
            crud.crear(deserializar(inscripcion));
        } catch (ClassNotFoundException e) {
            System.out.println("Error" + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminar(DTOCursoInscrito inscripcion) {
        Inscripcion inscrito = deserializar(inscripcion);
        listado.remove(inscrito);
        String id = String.valueOf(
                inscrito.getEstudiante().getID() +","
                        + inscrito.getCurso().getID() +","
                        + inscrito.getAño() +","
                        + inscrito.getSemestre());
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

    public static DTOCursoInscrito serializar(Inscripcion inscripcion) {
        return new DTOCursoInscrito(
                ServicioCurso.serializar(inscripcion.getCurso()),
                inscripcion.getAño(),
                inscripcion.getSemestre(),
                ServicioEstudiante.serializar(inscripcion.getEstudiante())
        );
    }

    public static Inscripcion deserializar(DTOCursoInscrito dtoCursoInscrito) {
        return new Inscripcion(
                ServicioCurso.deserializar(dtoCursoInscrito.getCurso()),
                dtoCursoInscrito.getAño(),
                dtoCursoInscrito.getSemestre(),
                ServicioEstudiante.deserializar(dtoCursoInscrito.getEstudiante())
        );
    }
}
