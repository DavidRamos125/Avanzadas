package com.mycompany.aplicacion_de_conceptos;

import GUI.Principal;
import com.mycompany.aplicacion_de_conceptos.dtos.*;

import java.io.IOException;

/**
 *  Fabian David Ramos Acosta    160004327
 *  Tian David Castro Parra     160004333
 *  Maria Camila Galeano Arenas 160004641      
 * 
 */
public class Aplicacion_de_Conceptos {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        DTOPersona decano1 = new DTOPersona(1, "Carlos", "Ramirez", "carlos.ramirez@example.com");
        DTOPersona decano2 = new DTOPersona(2, "Lucia", "Martinez", "lucia.martinez@example.com");

        DTOFacultad facultad1 = new DTOFacultad(1, "Ingenierias", decano1);
        DTOFacultad facultad2 = new DTOFacultad(2, "Ciencias Economicas", decano2);

        DTOPrograma programa1 = new DTOPrograma(1, "Ingenieria de Sistemas", 10, "REG123", facultad1);
        DTOPrograma programa2 = new DTOPrograma(2, "Administracion de Empresas", 8, "REG456", facultad2);

        DTOEstudiante estudiante1 = new DTOEstudiante(1, "Juan", "Perez", "juan.perez@example.com", 12345, programa1, true, 4.5);
        DTOEstudiante estudiante2 = new DTOEstudiante(2, "Maria", "Gonzalez", "maria.gonzalez@example.com", 54321, programa2, true, 3.8);

        DTOCurso curso1 = new DTOCurso(1, "Programacion Orientada a Objetos", programa1, true);
        DTOCurso curso2 = new DTOCurso(2, "Contabilidad Financiera", programa2, true);

        DTOProfesor profesor1 = new DTOProfesor(1, "Laura", "Fernandez", "laura.fernandez@example.com", "Tiempo Completo");
        DTOProfesor profesor2 = new DTOProfesor(2, "Carlos", "Lopez", "carlos.lopez@example.com", "Medio Tiempo");

        DTOCursoInscrito inscripcion1 = new DTOCursoInscrito(curso1, 2025, 1, estudiante1);
        DTOCursoInscrito inscripcion2 = new DTOCursoInscrito(curso2, 2025, 1, estudiante2);

        DTOCursoProfesor cursoProfesor1 = new DTOCursoProfesor(profesor1, 2025, 1, curso1);
        DTOCursoProfesor cursoProfesor2 = new DTOCursoProfesor(profesor2, 2025, 1, curso2);




        Principal principal = new Principal();
        principal.setVisible(true);


    }
}
