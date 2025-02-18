/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacion_de_conceptos.entidades;

import java.io.Serializable;

/**
 *
 * @author Estudiante_MCA
 */
public class Profesor extends Persona implements Serializable{
   private String TipoContrato;
   
   public Profesor(double ID, String nombres,String apellidos, String email, String TipoContrato){
       super(ID, nombres, apellidos, email);
       this.TipoContrato = TipoContrato;
   }
   
   public String toString(){
       return super.toString() + ", tipo de contrato: " + TipoContrato;
   }
}