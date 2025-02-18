package com.mycompany.aplicacion_de_conceptos.procesos;

import com.mycompany.aplicacion_de_conceptos.entidades.Inscripcion;
import com.mycompany.aplicacion_de_conceptos.persistencia.PersistenciaCursosInscritos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CursosInscritos {

    private List<Inscripcion> listado ;
    
    public CursosInscritos(){
        listado = new ArrayList<>();
    }

    public void inscribirCurso(Inscripcion inscripcion) {
        listado.add(inscripcion);
        try {
            PersistenciaCursosInscritos.guardarInscripcion(inscripcion);
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error" + e.getMessage());
        }

    }

    public void eliminar(Inscripcion inscripcion) {
        listado.remove(inscripcion);
    }

    public void actualizar(Inscripcion inscripcion) {
        //falta logica
    }

    public void guardarInformacion() {
        //falta logica
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cursos Inscritos:\n");
        for (Inscripcion inscripcion : listado) {
            sb.append(inscripcion.toString()).append("\n");
        }
        return sb.toString();
    }

    public void cargarDatos() {
        //falta logica
    }
}
