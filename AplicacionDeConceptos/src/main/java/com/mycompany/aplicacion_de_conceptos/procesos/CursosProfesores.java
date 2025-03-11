package com.mycompany.aplicacion_de_conceptos.procesos;
import com.mycompany.aplicacion_de_conceptos.dtos.DTOCursoProfesor;
import com.mycompany.aplicacion_de_conceptos.entidades.CursoProfesor;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBCursoProfesor;
import com.mycompany.aplicacion_de_conceptos.persistencia.binarios.BinarioCursoProfesor;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursosProfesores implements Servicios{

    private List<CursoProfesor> listado;
    private CRUD<CursoProfesor> crud;

    public CursosProfesores() {
        listado = new ArrayList<>();
        try {
            crud = new DBCursoProfesor();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void inscribir(DTOCursoProfesor cursoProfesor){
        listado.add(deserializar(cursoProfesor));
        try {
           crud.crear(deserializar(cursoProfesor));
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    
    public void guardarInformacion(CursoProfesor cursoProfesor) {
        try {
            crud.crear(cursoProfesor);
            System.out.println("Guardando informacion del curso: " + cursoProfesor.toString());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al guardar la informacion: " + e.getMessage());
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
        List<CursoProfesor> cursosGuardados = crud.obtenerTodos();
        listado.addAll(cursosGuardados); // Cargar todos los cursos guardados en el archivo a la lista
        System.out.println("Datos cargados: " + cursosGuardados.size() + " cursos.");
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
        for(CursoProfesor auxiliar:listado){
            listaString.add(auxiliar.toString());
        }
        return listaString;
    }

    public static CursoProfesor deserializar(DTOCursoProfesor dtoCursoProfesor) {
        return new CursoProfesor(
                ServicioProfesor.deserializar(dtoCursoProfesor.getProfesor()),
                dtoCursoProfesor.getAño(),
                dtoCursoProfesor.getSemestre(),
                ServicioCurso.deserializar(dtoCursoProfesor.getCurso())
        );
    }

    public static DTOCursoProfesor serializar(CursoProfesor cursoProfesor) {
        return new DTOCursoProfesor(
                ServicioProfesor.serializar(cursoProfesor.getProfesor()),
                cursoProfesor.getAño(),
                cursoProfesor.getSemestre(),
                ServicioCurso.serializar(cursoProfesor.getCurso())
        );
    }
}
