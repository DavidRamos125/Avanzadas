package com.mycompany.aplicacion_de_conceptos.persistencia.binarios;

import com.mycompany.aplicacion_de_conceptos.entidades.Persona;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinarioPersona implements CRUD<Persona> {
    private static final String FILENAME = "Personas.dat";

    @Override
    public void crear(Persona persona) throws IOException, ClassNotFoundException {
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

    @Override
    public Persona obtener(String id) {

        List<Persona> personas = new ArrayList<>();
        personas = obtenerTodos();

        for (Persona auxiliar : obtenerTodos()) {
            if (auxiliar.getID() == Double.parseDouble(id)) {
                return auxiliar;
            }
        }
        return null;
    }

    @Override
    public List<Persona> obtenerTodos() {

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

    @Override
    public void actualizar(Persona persona) {
        List<Persona> personas = new ArrayList<>();
        personas = obtenerTodos();

        for (Persona auxiliar : personas) {
            if (auxiliar.getID() == persona.getID()) {
                personas.remove(auxiliar);
                personas.add(persona);
                break;
            }
        }
        guardarLista(personas);
    }

    @Override
    public void eliminar(String id) {
        List<Persona> personas = new ArrayList<>();
        personas = obtenerTodos();

        for (Persona auxiliar : personas) {
            if (auxiliar.getID() == Double.parseDouble(id)) {
                personas.remove(auxiliar);
                break;
            }
        }
        guardarLista(personas);
    }


    public boolean estaGuardado(Persona persona) throws IOException, ClassNotFoundException {
        for (Persona auxiliar : obtenerTodos()) {
            if (auxiliar.toString().equals(persona.toString())) {
                return true;
            }
        }
        return false;
    }

    public static void guardarLista(List<Persona> lista) {
        File archivo = new File(FILENAME);
        try {
            FileOutputStream fos = new FileOutputStream(archivo);

            for (Persona auxiliar : lista) {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(auxiliar);
            }

            fos.close();
        } catch (Exception e) {
            System.out.println("error al guardar: " + e);
        }
    }

}