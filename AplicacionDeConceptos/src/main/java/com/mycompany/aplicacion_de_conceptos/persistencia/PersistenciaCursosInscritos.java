package com.mycompany.aplicacion_de_conceptos.persistencia;

import com.mycompany.aplicacion_de_conceptos.entidades.Inscripcion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaCursosInscritos {

    private static final String FILENAME = "CursosInscritos.dat";

    public static void guardarInscripcion(Inscripcion inscripcion) throws IOException, ClassNotFoundException {

        File archivo = new File(FILENAME);
        if (!estaGuardado(inscripcion)) {
            try {
                FileOutputStream fos = new FileOutputStream(archivo, true);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(inscripcion);
                oos.close();
                fos.close();
            } catch (Exception e) {
                System.out.println("error al guardar: " + e);
            }
        } else {
            System.out.println("el inscripcion ya esta inscrito");
        }

    }

    public static List<Inscripcion> extraerListaObjetos() throws IOException, ClassNotFoundException {
        File archivo = new File(FILENAME);
        List<Inscripcion> listaInscripcions = new ArrayList<>();
        try {
            FileInputStream lectura = new FileInputStream(archivo);
            while (lectura.available() > 0) {
                ObjectInputStream objeto = new ObjectInputStream(lectura);
                listaInscripcions.add((Inscripcion) objeto.readObject());
            }
            lectura.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        return listaInscripcions;

    }

    public static boolean estaGuardado(Inscripcion inscripcion) throws IOException, ClassNotFoundException {
        for(Inscripcion auxiliar : extraerListaObjetos()){
            if(auxiliar.toString().equals(inscripcion.toString())){
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
                Inscripcion auxiliar = (Inscripcion) ois.readObject();
                System.out.println(auxiliar.toString());
            }
        } catch (Exception e) {
            System.out.println("error al leer: " + e);
        }
    }

}

