package com.mycompany.aplicacion_de_conceptos;

import com.mycompany.aplicacion_de_conceptos.GUI.GIU_Principal;
import com.mycompany.aplicacion_de_conceptos.entidades.*;
import com.mycompany.aplicacion_de_conceptos.procesos.*;

import java.io.IOException;

/**
 *  Fabian David Ramos Acosta    160004327
 *  Tian David Castro Parra     160004333
 *  Maria Camila Galeano Arenas 160004641      
 * 
 */
public class Aplicacion_de_Conceptos {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Persona decano1 = new Persona(1, "Carlos", "Ramirez", "carlos.ramirez@example.com");
        Persona decano2 = new Persona(2, "Lucia", "Martinez", "lucia.martinez@example.com");

        Facultad facultad1 = new Facultad(1, "Ingenierias", decano1);
        Facultad facultad2 = new Facultad(2, "Ciencias Economicas", decano2);

        Programa programa1 = new Programa(1, "Ingenieria de Sistemas", 10, "REG123", facultad1);
        Programa programa2 = new Programa(2, "Administracion de Empresas", 8, "REG456", facultad2);

        Estudiante estudiante1 = new Estudiante(1, "Juan", "Perez", "juan.perez@example.com", 12345, programa1, true, 4.5);
        Estudiante estudiante2 = new Estudiante(2, "Maria", "Gonzalez", "maria.gonzalez@example.com", 54321, programa2, true, 3.8);

        Curso curso1 = new Curso(1, "Programacion Orientada a Objetos", programa1, true);
        Curso curso2 = new Curso(2, "Contabilidad Financiera", programa2, true);

        Profesor profesor1 = new Profesor(1, "Laura", "Fernandez", "laura.fernandez@example.com", "Tiempo Completo");
        Profesor profesor2 = new Profesor(2, "Carlos", "Lopez", "carlos.lopez@example.com", "Medio Tiempo");

        Inscripcion inscripcion1 = new Inscripcion(curso1, 2025, 1, estudiante1);
        Inscripcion inscripcion2 = new Inscripcion(curso2, 2025, 1, estudiante2);

        CursoProfesor cursoProfesor1 = new CursoProfesor(profesor1, 2025, 1, curso1);
        CursoProfesor cursoProfesor2 = new CursoProfesor(profesor2, 2025, 1, curso2);

        CursosInscritos cursosInscritos = new CursosInscritos();
        CursosProfesores cursosProfesores = new CursosProfesores();
        InscripcionesPersonas inscripcionesPersonas = new InscripcionesPersonas();

        cursosInscritos.cargarDatos();
        cursosProfesores.cargarDatos();
        inscripcionesPersonas.cargarDatos();

        cursosProfesores.inscribir(cursoProfesor1);
        cursosInscritos.inscribirCurso(inscripcion1);
        inscripcionesPersonas.inscribir(profesor1);
        inscripcionesPersonas.inscribir(estudiante2);

        
        cursosInscritos.eliminar(inscripcion2);
        inscripcionesPersonas.eliminar(estudiante1);

        cursosInscritos.actualizar(inscripcion1);
        inscripcionesPersonas.actualizar(estudiante2);

        System.out.println("\n---------------------------\n");
        System.out.println(cursosInscritos.toString());
        System.out.println("\n---------------------------\n");
        System.out.println(cursosProfesores.toString());
        System.out.println("\n---------------------------\n");

        cursosInscritos.guardarInformacion(inscripcion1);
        cursosProfesores.guardarInformacion(cursoProfesor1);
        inscripcionesPersonas.guardarInformacion(estudiante1);

        GIU_Principal principal = new GIU_Principal();
        principal.setVisible(true);


    }
}
