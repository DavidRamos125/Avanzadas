package com.mycompany.aplicacion_de_conceptos.servicios;

import com.mycompany.aplicacion_de_conceptos.dtos.DTOCurso;
import com.mycompany.aplicacion_de_conceptos.entidades.Curso;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBCurso;

import java.util.ArrayList;
import java.util.List;

public class ServicioCurso {
    private CRUD<Curso> crud;

    public ServicioCurso() {
        this.crud = new DBCurso();
    }

    public void crearCurso(DTOCurso curso) {
        try {
            crud.crear(deserializar(curso));
        }catch(Exception e) {
            System.out.println("error crando curso: "+ e.getMessage());
        }
    }

    public DTOCurso obtenerCurso(String id) {
        Curso curso = crud.obtener(id);
        return serializar(curso);
    }

    public void actualizarCurso(DTOCurso curso) {
        crud.actualizar(deserializar(curso));
    }

    public List<DTOCurso> obtenerCursos() {
        List<DTOCurso> listaDto = new ArrayList<>();
        List<Curso> consulta = crud.obtenerTodos();
        for (Curso curso : consulta) {
            listaDto.add(serializar(curso));
        }
        return listaDto;
    }

    public void eliminarCurso(String id) {
        crud.eliminar(id);
    }

    public static DTOCurso serializar(Curso curso) {
        return new DTOCurso(
                (int) curso.getID(),
                curso.getNombre(),
                ServicioPrograma.serializar(curso.getPrograma()),
                curso.isActivo()
        );
    }

    public static Curso deserializar(DTOCurso dtoCurso) {
        return new Curso(
                dtoCurso.getId(),
                dtoCurso.getNombre(),
                ServicioPrograma.deserializar(dtoCurso.getPrograma()),
                dtoCurso.isActivo()
        );
    }

}
