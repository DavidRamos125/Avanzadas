/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.aplicacion_de_conceptos.GUI;

import com.mycompany.aplicacion_de_conceptos.dtos.DTOFacultad;
import com.mycompany.aplicacion_de_conceptos.dtos.DTOPersona;
import com.mycompany.aplicacion_de_conceptos.dtos.DTOProfesor;
import com.mycompany.aplicacion_de_conceptos.dtos.DTOPrograma;
import com.mycompany.aplicacion_de_conceptos.procesos.InscripcionesPersonas;
import com.mycompany.aplicacion_de_conceptos.procesos.ServicioFacultad;
import com.mycompany.aplicacion_de_conceptos.procesos.ServicioPrograma;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author getro
 */
public class IncribirPrograma extends javax.swing.JPanel {

    /**
     * Creates new form Incribir_Persona
     */
    public IncribirPrograma() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Caja_Texto = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        duracion = new javax.swing.JTextField();
        Nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        registro = new javax.swing.JTextField();
        idFacultad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(778, 544));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setPreferredSize(new java.awt.Dimension(778, 544));

        jLabel1.setText("Nombre :");

        jToggleButton1.setLabel("Inscribir");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        duracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duracionActionPerformed(evt);
            }
        });

        jLabel2.setText("Duracion :");

        jLabel4.setText("ID:");

        ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IDKeyTyped(evt);
            }
        });

        jLabel3.setText("Registro :");

        registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroActionPerformed(evt);
            }
        });

        idFacultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFacultadActionPerformed(evt);
            }
        });

        jLabel5.setText("ID de Facultad :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jToggleButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(32, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(ID, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(duracion, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(registro, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(idFacultad, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))))
                .addContainerGap(355, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(duracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1)
                .addContainerGap(373, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void IDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDKeyTyped
        char c = evt.getKeyChar();
        
        if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_IDKeyTyped

    private boolean Revision(JTextField text){
        boolean valor;
        valor = true;
        if(text.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Por favor llenar correctamente los espacios");
            valor = false;
        } 
    return valor;    
    }
    
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        String Id,nombre,Duracion,IdFacultad,Registro;
        boolean vacio = false;
        
        Id = ID.getText();
        double ID_ = Double.parseDouble(Id);
        nombre = Nombre.getText();
        Duracion = duracion.getText();
        double durac = Double.parseDouble(Duracion);
        Registro = registro.getText();
        IdFacultad = idFacultad.getText();
        double IDfacultad = Double.parseDouble(IdFacultad);
        DTOFacultad Facultad = servicioFacultad.obtenerFacultad(Id);
        
        
        vacio = Revision(ID);
        if(vacio == true){
            vacio = Revision(Nombre);
        }
        
        if(vacio == true){
            int respuesta = JOptionPane.showConfirmDialog(this, "Seguro que quieres proceder ?");
            if (respuesta == 0 ){
                DTOPrograma programa = new DTOPrograma(ID_,nombre,durac,Registro,Facultad);
                JOptionPane.showMessageDialog(this , "Se ah inscrito correctamente");
            }else if(respuesta == 1){
                JOptionPane.showMessageDialog(this , "Se ah abortado la inscripcion");
            }else{
                JOptionPane.showMessageDialog(this , "Se ah cancelado la accion");
            }
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void duracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duracionActionPerformed

    private void registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registroActionPerformed

    private void idFacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFacultadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFacultadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Caja_Texto;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField Nombre;
    private javax.swing.JTextField duracion;
    private javax.swing.JTextField idFacultad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField registro;
    // End of variables declaration//GEN-END:variables
    ServicioPrograma servicioPrograma;
    ServicioFacultad servicioFacultad;
}
