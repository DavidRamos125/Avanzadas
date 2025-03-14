/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.aplicacion_de_conceptos.GUI;

import com.mycompany.aplicacion_de_conceptos.dtos.DTOEstudiante;
import com.mycompany.aplicacion_de_conceptos.dtos.DTOPersona;
import com.mycompany.aplicacion_de_conceptos.dtos.DTOProfesor;
import com.mycompany.aplicacion_de_conceptos.dtos.DTOPrograma;
import com.mycompany.aplicacion_de_conceptos.procesos.ServicioEstudiante;
import com.mycompany.aplicacion_de_conceptos.procesos.ServicioPrograma;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author getro
 */
public class IncribirEstudiante extends javax.swing.JPanel {

    /**
     * Creates new form Incribir_Persona
     */
    public IncribirEstudiante() {
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
        Apellidos = new javax.swing.JTextField();
        Nombres = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        programa = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        activo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        promedio = new javax.swing.JTextField();
        actualizarPrograma = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(778, 544));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setPreferredSize(new java.awt.Dimension(778, 544));

        jLabel1.setText("Nombres :");

        jToggleButton1.setLabel("Inscribir");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        Apellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApellidosActionPerformed(evt);
            }
        });

        jLabel2.setText("Apellidos :");

        jLabel3.setText("Email :");

        jLabel4.setText("ID:");

        ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IDKeyTyped(evt);
            }
        });

        jLabel5.setText("Codigo  :");

        jLabel6.setText("Programa :");

        jLabel7.setText("Activo :");

        activo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Desactivo", " " }));

        jLabel8.setText("Promedio :");

        actualizarPrograma.setText("Actualizar");
        actualizarPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarProgramaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jToggleButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Nombres, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(ID, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(Apellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(Email, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(codigo)
                            .addComponent(programa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(activo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(promedio))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actualizarPrograma)
                .addContainerGap(302, Short.MAX_VALUE))
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
                    .addComponent(Nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(programa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(actualizarPrograma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(activo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(promedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1)
                .addContainerGap(288, Short.MAX_VALUE))
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
        String Id,nombre,apellido,email,program,codig,promed,activ;
        boolean vacio = false,activBoolean;
        
        
        Id = ID.getText();
        double ID_ = Double.parseDouble(Id);
        nombre = Nombres.getText();
        apellido = Apellidos.getText();
        email = Email.getText();
        codig = codigo.getText();
        double codig_ = Double.parseDouble(codig);
        promed = promedio.getText();
        double promed_ = Double.parseDouble(promed);
        program = programa.getSelectedItem().toString();
        DTOPrograma programaSeleccionado = null;
        
        if(listaPrograma != null){
           for (DTOPrograma item : listaPrograma) {
            if(item.getNombre() == program){
                    programaSeleccionado = item;
                }
            } 
        }
        activ = activo.getSelectedItem().toString();
        
        if(activ == "Activo"){
            activBoolean = true;
        }else{
            activBoolean = false;
        }
        
        vacio = Revision(ID);
        if(vacio == true){
            vacio = Revision(Nombres);
            if(vacio == true){
                vacio = Revision(Apellidos);
                if(vacio == true){
                    vacio = Revision(Email);
                }
            }
        }
        
        if(vacio == true){
            int respuesta = JOptionPane.showConfirmDialog(this, "Seguro que quieres proceder ?");
            if (respuesta == 0 ){
                DTOEstudiante persona = new DTOEstudiante(ID_,nombre,apellido,email,codig_,programaSeleccionado,activBoolean,promed_);
                servicioEstudiante.InscribirEstudiante(persona);
                JOptionPane.showMessageDialog(this , "Se ah inscrito correctamente");
            }else if(respuesta == 1){
                JOptionPane.showMessageDialog(this , "Se ah abortado la inscripcion");
            }else{
                JOptionPane.showMessageDialog(this , "Se ah cancelado la accion");
            }
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void ApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApellidosActionPerformed

    private void actualizarProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarProgramaActionPerformed
        listaPrograma = servicioPrograma.obtenerProgramas();
        programa.removeAllItems();
        for (DTOPrograma item : listaPrograma) {
            programa.addItem(item.getNombre());
        }
    }//GEN-LAST:event_actualizarProgramaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apellidos;
    private javax.swing.JTextField Caja_Texto;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField Nombres;
    private javax.swing.JComboBox<String> activo;
    private javax.swing.JButton actualizarPrograma;
    private javax.swing.JTextField codigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JComboBox<String> programa;
    private javax.swing.JTextField promedio;
    // End of variables declaration//GEN-END:variables
    List<DTOPrograma> listaPrograma;
    ServicioPrograma servicioPrograma;
    ServicioEstudiante servicioEstudiante;
}
