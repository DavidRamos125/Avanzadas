package com.mycompany.aplicacion_de_conceptos.persistencia;

import com.mycompany.aplicacion_de_conceptos.entidades.CursoProfesor;
import com.mycompany.aplicacion_de_conceptos.entidades.Inscripcion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaCursosProfesores {

    private static final String FILENAME = "CursosProfesores.dat";

    public static void guardarCursoProfesor(CursoProfesor cursoProfesor) throws IOException, ClassNotFoundException {

        File archivo = new File(FILENAME);
        if (!estaGuardado(cursoProfesor)) {
            try {
                FileOutputStream fos = new FileOutputStream(archivo, true);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(cursoProfesor);
                oos.close();
                fos.close();
            } catch (Exception e) {
                System.out.println("error al guardar: " + e);
            }
        } else {
            System.out.println("el cursoProfesor ya esta inscrito");
        }

    }

    public static List<CursoProfesor> extraerListaObjetos() throws IOException, ClassNotFoundException {
        File archivo = new File(FILENAME);
        List<CursoProfesor> listaCursoProfesores = new ArrayList<>();
        try {
            FileInputStream lectura = new FileInputStream(archivo);
            while (lectura.available() > 0) {
                ObjectInputStream objeto = new ObjectInputStream(lectura);
                listaCursoProfesores.add((CursoProfesor) objeto.readObject());
            }
            lectura.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        return listaCursoProfesores;

    }

    public static boolean estaGuardado(CursoProfesor cursoProfesor) throws IOException, ClassNotFoundException {
        for (CursoProfesor auxiliar : extraerListaObjetos()) {
            if (auxiliar.toString().equals(cursoProfesor.toString())) {
                return true;
            }
        }
        return false;
    }

    public static void guardarLista(List<CursoProfesor> lista) {
        File archivo = new File(FILENAME);
        try {
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (CursoProfesor auxiliar : lista) {
                oos.writeObject(auxiliar);
            }
            oos.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("error al guardar: " + e);
        }
    }

    public static void eliminarCursoProfesor(CursoProfesor inscripcion) throws IOException, ClassNotFoundException {
        List<CursoProfesor> cursoProfesores = new ArrayList<>();
        cursoProfesores = extraerListaObjetos();

        for (CursoProfesor auxiliar : extraerListaObjetos()) {
            if (auxiliar.toString().equals(inscripcion.toString())) {
                cursoProfesores.remove(auxiliar);

            }
        }
        guardarLista(cursoProfesores);
    }

}

