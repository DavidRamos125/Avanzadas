package com.mycompany.aplicacion_de_conceptos.persistencia;

import com.mycompany.aplicacion_de_conceptos.procesos.CursoProfesor;
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
        List<CursoProfesor> listaCursoProfesors = new ArrayList<>();
        try {
            FileInputStream lectura = new FileInputStream(archivo);
            while (lectura.available() > 0) {
                ObjectInputStream objeto = new ObjectInputStream(lectura);
                listaCursoProfesors.add((CursoProfesor) objeto.readObject());
            }
            lectura.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        return listaCursoProfesors;

    }

    public static boolean estaGuardado(CursoProfesor cursoProfesor) throws IOException, ClassNotFoundException {
        for(CursoProfesor auxiliar : extraerListaObjetos()){
            if(auxiliar.toString().equals(cursoProfesor.toString())){
                return true;
            }
        }
        return false;
    }

    public static void LeerArchivo() {
        File archivo = new File(FILENAME);
        try {
            FileInputStream fis = new FileInputStream(archivo);
            while (fis.available() > 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                CursoProfesor auxiliar = (CursoProfesor) ois.readObject();
                System.out.println(auxiliar.toString());
            }
        } catch (Exception e) {
            System.out.println("error al leer: " + e);
        }
    }

}

