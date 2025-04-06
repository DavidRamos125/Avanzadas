package com.mycompany.aplicacion_de_conceptos.fabricas;

import com.mycompany.aplicacion_de_conceptos.entidades.*;
import com.mycompany.aplicacion_de_conceptos.persistencia.Conexion;
import com.mycompany.aplicacion_de_conceptos.persistencia.conexiones.ConexionH2;
import com.mycompany.aplicacion_de_conceptos.persistencia.conexiones.ConexionMysql;
import com.mycompany.aplicacion_de_conceptos.utilidades.Propiedades;

public class FabricaSistema {
    private static FabricaSistema instancia;
    private Conexion conexion;

    private FabricaSistema() {
        this.conexion = crearConexion();
    }
    public static FabricaSistema getInstancia() {
        if (instancia == null) {
            instancia = new FabricaSistema();
        }
        return instancia;
    }

    public Conexion getConexion() {
        return conexion;
    }

    private Conexion crearConexion() {
        String tipoConexion = Propiedades.cargarPropiedad("conexion.tipo");
        switch (tipoConexion.toUpperCase()) {
            case "H2":
                return ConexionH2.getInstancia();
            case "MYSQL":
                return ConexionMysql.getInstancia();
            default:
                throw new IllegalArgumentException("Tipo de conexión no soportado: " + tipoConexion);
        }
    }


    public static Estudiante obtenerEstudiante(
            double ID,
            String nombres,
            String apellidos,
            String email,
            double codigo,
            Programa programa,
            boolean activo,
            double promedio
    ) {
        return new Estudiante(ID, nombres, apellidos, email, codigo, programa, activo, promedio);
    }

    public static Facultad obtenerFacultad(
            double ID,
            String nombre,
            Persona decano
    ) {
        return new Facultad(ID, nombre, decano);
    }

    public static Programa obtenerPrograma(
            double ID,
            String nombre,
            double duracion,
            String registro,
            Facultad facultad
    ) {
        return new Programa(ID, nombre, duracion, registro, facultad);
    }

    public static Curso obtenerCurso(
            double ID,
            String nombre,
            Programa programa,
            boolean activo
    ) {
        return new Curso(ID, nombre, programa, activo);
    }

    public static CursoProfesor obtenerCursoProfesor(
            Profesor profesor,
            Integer año,
            Integer semestre,
            Curso curso
    ) {
        return new CursoProfesor(profesor, año, semestre, curso);
    }

    public static Persona obtenerPersona(
            double ID,
            String nombres,
            String apellidos,
            String email
    ) {
        return new Persona(ID, nombres, apellidos, email);
    }

    public static Profesor obtenerProfesor(
            double ID,
            String nombres,
            String apellidos,
            String email,
            String tipoContrato
    ) {
        return new Profesor(ID, nombres, apellidos, email, tipoContrato);
    }

    public static Inscripcion obtenerInscripcion(
            Curso curso,
            int año,
            int semestre,
            Estudiante estudiante
    ) {
        return new Inscripcion(curso, año, semestre, estudiante);
    }
}
