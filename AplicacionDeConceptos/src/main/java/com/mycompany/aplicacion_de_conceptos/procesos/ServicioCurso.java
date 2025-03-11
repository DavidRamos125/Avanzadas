package com.mycompany.aplicacion_de_conceptos.procesos;

import com.mycompany.aplicacion_de_conceptos.dtos.DTOCurso;
import com.mycompany.aplicacion_de_conceptos.entidades.Curso;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBCurso;

public class ServicioCurso {
    private CRUD<Curso> crud;

    public ServicioCurso() {
        this.crud = new DBCurso();
    }

    public static DTOCurso serializar(Curso curso) {
        return new DTOCurso(
                curso.getID(),
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
