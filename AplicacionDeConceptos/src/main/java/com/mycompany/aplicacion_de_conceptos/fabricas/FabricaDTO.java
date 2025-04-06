package com.mycompany.aplicacion_de_conceptos.fabricas;

import com.mycompany.aplicacion_de_conceptos.dtos.*;

public class FabricaDTO {
    public static DTOPersona obtenerPersonaDTO(double id, String nombres, String apellidos, String email) {
        return new DTOPersona(id, nombres, apellidos, email);
    }

    public static DTOProfesor obtenerProfesorDTO(double id, String nombres, String apellidos, String email, String tipoContrato) {
        return new DTOProfesor(id, nombres, apellidos, email, tipoContrato);
    }

    public static DTOEstudiante obtenerEstudianteDTO(
            double id,
            String nombres,
            String apellidos,
            String email,
            double codigo,
            DTOPrograma programa,
            boolean activo,
            double promedio
    ) {
        return new DTOEstudiante(id, nombres, apellidos, email, codigo, programa, activo, promedio);
    }

    public static DTOFacultad obtenerFacultadDTO(double id, String nombre, DTOPersona decano) {
        return new DTOFacultad(id, nombre, decano);
    }

    public static DTOPrograma obtenerProgramaDTO(
            double id,
            String nombre,
            double duracion,
            String registro,
            DTOFacultad facultad
    ) {
        return new DTOPrograma(id, nombre, duracion, registro, facultad);
    }

    public static DTOCurso obtenerCursoDTO(
            int id,
            String nombre,
            DTOPrograma programa,
            boolean activo
    ) {
        return new DTOCurso(id, nombre, programa, activo);
    }

    public static DTOCursoInscrito obtenerCursoInscritoDTO(
            DTOCurso curso,
            int año,
            int semestre,
            DTOEstudiante estudiante
    ) {
        return new DTOCursoInscrito(curso, año, semestre, estudiante);
    }

    public static DTOCursoProfesor obtenerCursoProfesorDTO(
            DTOProfesor profesor,
            Integer año,
            Integer semestre,
            DTOCurso curso
    ) {
        return new DTOCursoProfesor(profesor, año, semestre, curso);
    }
}
