package com.mycompany.aplicacion_de_conceptos.persistencia;

import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaPersonas {

    private static final String FILENAME = "Personas.dat";

    public static void guardarPersona(Persona persona) throws IOException, ClassNotFoundException {

        File archivo = new File(FILENAME);
        if (!estaGuardado(persona)) {
            try {
                FileOutputStream fos = new FileOutputStream(archivo, true);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(persona);
                oos.close();
                fos.close();
            } catch (Exception e) {
                System.out.println("error al guardar: " + e);
            }
        } else {
            System.out.println("el persona ya esta inscrito");
        }

    }

    public static List<Persona> extraerListaObjetos() throws IOException, ClassNotFoundException {
        File archivo = new File(FILENAME);
        List<Persona> listaPersonas = new ArrayList<>();
        try {
            FileInputStream lectura = new FileInputStream(archivo);
            while (lectura.available() > 0) {
                ObjectInputStream objeto = new ObjectInputStream(lectura);
                listaPersonas.add((Persona) objeto.readObject());
            }
            lectura.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        return listaPersonas;

    }

    public static boolean estaGuardado(Persona persona) throws IOException, ClassNotFoundException {
        for(Persona auxiliar : extraerListaObjetos()){
            if(auxiliar.toString().equals(persona.toString())){
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
                Persona auxiliar = (Persona) ois.readObject();
                System.out.println(auxiliar.toString());
            }
        } catch (Exception e) {
            System.out.println("error al leer: " + e);
        }
    }

}