package com.mycompany.aplicacion_de_conceptos.servicios;

import com.mycompany.aplicacion_de_conceptos.entidades.Inscripcion;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBCursoInscrito;
import com.mycompany.aplicacion_de_conceptos.persistencia.binarios.BinarioCursoInscrito;

public class ServicioInscripcion {
    private CRUD<Inscripcion> crud;

    public ServicioInscripcion() {
        this.crud = new BinarioCursoInscrito();
    }

}
