package com.mycompany.aplicacion_de_conceptos.procesos;
import com.mycompany.aplicacion_de_conceptos.entidades.CursoProfesor;
import com.mycompany.aplicacion_de_conceptos.persistencia.binarios.BinarioCursoProfesor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CursosProfesores implements Servicios{

    private List<CursoProfesor> listado = new ArrayList<>();
    
    public void inscribir(CursoProfesor cursoProfesor){
        listado.add(cursoProfesor);
        try {
            BinarioCursoProfesor.guardarCursoProfesor(cursoProfesor);
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    
    public void guardarInformacion(CursoProfesor cursoProfesor) {
        try {
            BinarioCursoProfesor.guardarCursoProfesor(cursoProfesor);
            System.out.println("Guardando informacion del curso: " + cursoProfesor.toString());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al guardar la informacion: " + e.getMessage());
        }
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Cursos Inscritos del profesor:\n");
        for (CursoProfesor cursoProfesor : listado) {
            sb.append(cursoProfesor.toString()).append("\n");
        }
        return sb.toString();
    }

    public void cargarDatos() {
        try {
            List<CursoProfesor> cursosGuardados = BinarioCursoProfesor.extraerListaObjetos();
            listado.addAll(cursosGuardados); // Cargar todos los cursos guardados en el archivo a la lista
            System.out.println("Datos cargados: " + cursosGuardados.size() + " cursos.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }

    //implementacion de servicios
    public String imprimirPosicion(int posicion){
        return listado.get(posicion).toString();
    }
    public int cantidadActual(){
        return listado.size();
    }
    public List<String> imprimirListado(){
        List<String> listaString = new ArrayList<>();
        for(CursoProfesor auxiliar:listado){
            listaString.add(auxiliar.toString());
        }
        return listaString;
    }
}
