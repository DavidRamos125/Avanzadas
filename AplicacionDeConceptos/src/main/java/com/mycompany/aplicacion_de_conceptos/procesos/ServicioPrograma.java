package com.mycompany.aplicacion_de_conceptos.procesos;

import com.mycompany.aplicacion_de_conceptos.entidades.Programa;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;
import com.mycompany.aplicacion_de_conceptos.persistencia.baseDatos.DBPrograma;

public class ServicioPrograma {
    private CRUD<Programa> crud;

    public ServicioPrograma() {
        this.crud = new DBPrograma();
    }
}
