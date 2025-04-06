package com.mycompany.aplicacion_de_conceptos.servicios;

import com.mycompany.aplicacion_de_conceptos.dtos.DTOEstudiante;
import com.mycompany.aplicacion_de_conceptos.entidades.Estudiante;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBEstudiante;

public class ServicioEstudiante {
    private CRUD<Estudiante> crud;

    public ServicioEstudiante() {
        this.crud = new DBEstudiante();
    }

    public void InscribirEstudiante(DTOEstudiante estudiante) {
        try {
            crud.crear(this.deserializar(estudiante));
        }catch (Exception e) {
            System.out.println("error: "+e.getMessage());
        }
    }

    public void eliminarEstudiante(String id) {
        crud.eliminar(id);
    }

    public DTOEstudiante obtenerEstudiante(String id) {
        Estudiante estudiante = crud.obtener(id);
        return serializar(estudiante);
    }
    
    public static DTOEstudiante serializar(Estudiante estudiante) {
        return new DTOEstudiante(
                estudiante.getID(),
                estudiante.getNombres(),
                estudiante.getApellidos(),
                estudiante.getEmail(),
                estudiante.getCodigo(),
                ServicioPrograma.serializar(estudiante.getPrograma()), // Conversión del programa
                estudiante.isActivo(),
                estudiante.getPromedio()
        );
    }

    public static Estudiante deserializar(DTOEstudiante dtoEstudiante) {
        return new Estudiante(
                dtoEstudiante.getId(),
                dtoEstudiante.getNombres(),
                dtoEstudiante.getApellidos(),
                dtoEstudiante.getEmail(),
                dtoEstudiante.getCodigo(),
                ServicioPrograma.deserializar(dtoEstudiante.getPrograma()),
                dtoEstudiante.isActivo(),
                dtoEstudiante.getPromedio()
        );
    }
}
