package com.mycompany.aplicacion_de_conceptos.persistencia.binarios;

import com.mycompany.aplicacion_de_conceptos.entidades.Inscripcion;
import com.mycompany.aplicacion_de_conceptos.persistencia.CRUD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BinarioCursoInscrito implements CRUD<Inscripcion> {
    @Override
    public void crear(Inscripcion objecto) {

    }

    @Override
    public Inscripcion obtener(String id) {
        return null;
    }

    @Override
    public List<Inscripcion> obtenerTodos() {
        return List.of();
    }

    @Override
    public void actualizar(Inscripcion objecto) {

    }

    @Override
    public void eliminar(String id) {

    }

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
        List<Inscripcion> listaInscripciones = new ArrayList<>();
        try {
            FileInputStream lectura = new FileInputStream(archivo);
            while (lectura.available() > 0) {
                ObjectInputStream objeto = new ObjectInputStream(lectura);
                listaInscripciones.add((Inscripcion) objeto.readObject());
            }
            lectura.close();
        } catch (Exception e) {
            System.out.println("error con la cabecera: " + e);
        }
        return listaInscripciones;

    }

    public static boolean estaGuardado(Inscripcion inscripcion) throws IOException, ClassNotFoundException {
        for(Inscripcion auxiliar : extraerListaObjetos()){
            if(auxiliar.toString().equals(inscripcion.toString())){
                return true;
            }
        }
        return false;
    }

    public static void guardarLista(List<Inscripcion> lista){
        File archivo = new File(FILENAME);
        try {
            FileOutputStream fos = new FileOutputStream(archivo);

            for(Inscripcion auxiliar : lista){
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(auxiliar);
            }
            fos.close();
        } catch (Exception e) {
            System.out.println("error al guardar: " + e);
        }
    }
    
    public static void eliminarInscripcion(Inscripcion inscripcion) throws IOException, ClassNotFoundException {
        List<Inscripcion> inscritos= new ArrayList<>();
        inscritos = extraerListaObjetos();
        
        for(Inscripcion auxiliar : extraerListaObjetos()){
            if(auxiliar.toString().equals(inscripcion.toString())){
                inscritos.remove(auxiliar);
                
            }
        }
        guardarLista(inscritos);
    }

}

