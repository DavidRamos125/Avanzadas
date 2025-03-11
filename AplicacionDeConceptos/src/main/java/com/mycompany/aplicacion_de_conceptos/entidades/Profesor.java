package com.mycompany.aplicacion_de_conceptos.entidades;

import java.io.Serializable;

public class Profesor extends Persona implements Serializable{
   private String TipoContrato;
   
   public Profesor(double ID, String nombres,String apellidos, String email, String TipoContrato){
       super(ID, nombres, apellidos, email);
       this.TipoContrato = TipoContrato;
   }

    public String getTipoContrato() {
        return TipoContrato;
    }

    public String toString(){
       return super.toString() + ", tipo de contrato: " + TipoContrato;
   }

    public long getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}