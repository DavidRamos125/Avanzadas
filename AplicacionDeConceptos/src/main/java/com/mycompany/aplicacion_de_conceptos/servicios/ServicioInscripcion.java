package com.mycompany.aplicacion_de_conceptos.servicios;

import com.mycompany.aplicacion_de_conceptos.dtos.DTOCursoInscrito;
import com.mycompany.aplicacion_de_conceptos.entidades.Inscripcion;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBCursoInscrito;

import java.util.ArrayList;
import java.util.List;

public class ServicioInscripcion {
    private CRUD<Inscripcion> crud;

    public ServicioInscripcion() {
        this.crud = new DBCursoInscrito();
    }

    public void guardarInformacion(DTOCursoInscrito dto) {
        if (dto == null) {
            throw new IllegalArgumentException("El DTO de inscripción no puede ser nulo.");
        }
        Inscripcion inscripcion = deserializar(dto);
        crud.crear(inscripcion);
    }

    public List<DTOCursoInscrito> obtenerInscripcionesPorEstudiante(String idEstudiante) {
        List<DTOCursoInscrito> dtos = new ArrayList<>();
        List<Inscripcion> inscripciones = crud.obtenerTodos();
        for (Inscripcion inscripcion : inscripciones) {
            int id = (int) inscripcion.getEstudiante().getID();
            if (idEstudiante.equals(Integer.toString(id))) {
                dtos.add(serializar(inscripcion));
            }
        }
        return dtos;
    }

    public void eliminar(DTOCursoInscrito inscripcion) {
        if (inscripcion == null) {
            throw new IllegalArgumentException("La inscripción no puede ser nula.");
        }

        String id = String.format(
                "%.0f,%.0f,%d,%d",
                inscripcion.getEstudiante().getCodigo(),
                inscripcion.getCurso().getId(),
                inscripcion.getAño(),
                inscripcion.getSemestre()
        );

        crud.eliminar(id);
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
