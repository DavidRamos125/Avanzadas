package com.mycompany.aplicacion_de_conceptos.servicios;
import com.mycompany.aplicacion_de_conceptos.dtos.DTOCursoProfesor;
import com.mycompany.aplicacion_de_conceptos.entidades.CursoProfesor;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBCursoProfesor;

import java.util.ArrayList;
import java.util.List;

public class ServicioCursoProfesor {

    private CRUD<CursoProfesor> crud;

    public ServicioCursoProfesor() {
        crud = new DBCursoProfesor();
    }
    
    public void inscribir(DTOCursoProfesor cursoProfesor){
        crud.crear(deserializar(cursoProfesor));
    }
    
    public void guardarInformacion(CursoProfesor cursoProfesor) {
        crud.crear(cursoProfesor);
        System.out.println("Guardando informacion del curso: " + cursoProfesor.toString());
    }

    public List<DTOCursoProfesor> obtenerCursoProfesores() {
        List<DTOCursoProfesor> DTOcursoProfesores = new ArrayList<>();
        List<CursoProfesor> cursoProfesores = crud.obtenerTodos();
        for (CursoProfesor c : cursoProfesores) {
            DTOcursoProfesores.add(serializar(c));
        }
        return DTOcursoProfesores;
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
