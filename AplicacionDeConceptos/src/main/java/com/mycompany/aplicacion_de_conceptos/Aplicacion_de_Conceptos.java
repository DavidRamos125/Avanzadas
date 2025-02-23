package com.mycompany.aplicacion_de_conceptos;

import com.mycompany.aplicacion_de_conceptos.entidades.*;
import com.mycompany.aplicacion_de_conceptos.procesos.*;
/**
 *  Fabian David Ramos Acota    160004327
 *  Tian David Castro Parra     160004333
 *  Maria Camila Galeano Arenas 160004641      
 * 
 */
public class Aplicacion_de_Conceptos {

    public static void main(String[] args) {

        Persona decano1 = new Persona(1, "Carlos", "Ramírez", "carlos.ramirez@example.com");
        Persona decano2 = new Persona(2, "Lucía", "Martínez", "lucia.martinez@example.com");

        Facultad facultad1 = new Facultad(1, "Ingenierías", decano1);
        Facultad facultad2 = new Facultad(2, "Ciencias Económicas", decano2);

        Programa programa1 = new Programa(1, "Ingeniería de Sistemas", 10, "REG123", facultad1);
        Programa programa2 = new Programa(2, "Administración de Empresas", 8, "REG456", facultad2);

        Estudiante estudiante1 = new Estudiante(1, "Juan", "Pérez", "juan.perez@example.com", 12345, programa1, true, 4.5);
        Estudiante estudiante2 = new Estudiante(2, "María", "González", "maria.gonzalez@example.com", 54321, programa2, true, 3.8);

        Curso curso1 = new Curso(1, "Programación Orientada a Objetos", programa1, true);
        Curso curso2 = new Curso(2, "Contabilidad Financiera", programa2, true);

        Profesor profesor1 = new Profesor(1, "Laura", "Fernández", "laura.fernandez@example.com", "Tiempo Completo");
        Profesor profesor2 = new Profesor(2, "Carlos", "López", "carlos.lopez@example.com", "Medio Tiempo");

        Inscripcion inscripcion1 = new Inscripcion(curso1, 2025, 1, estudiante1);
        Inscripcion inscripcion2 = new Inscripcion(curso2, 2025, 1, estudiante2);

        CursoProfesor cursoProfesor1 = new CursoProfesor(profesor1, 2025, 1, curso1);
        CursoProfesor cursoProfesor2 = new CursoProfesor(profesor2, 2025, 1, curso2);

        CursosInscritos cursosInscritos = new CursosInscritos();
        CursosProfesores cursosProfesores = new CursosProfesores();
        InscripcionesPersonas inscripcionesPersonas = new InscripcionesPersonas();



    }
}
