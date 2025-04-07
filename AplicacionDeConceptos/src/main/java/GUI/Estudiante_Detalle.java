/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;
import com.mycompany.aplicacion_de_conceptos.dtos.DTOCurso;
import com.mycompany.aplicacion_de_conceptos.dtos.DTOCursoInscrito;
import com.mycompany.aplicacion_de_conceptos.dtos.DTOEstudiante;
import com.mycompany.aplicacion_de_conceptos.dtos.DTOProfesor;
import com.mycompany.aplicacion_de_conceptos.fabricas.FabricaExterior;
import com.mycompany.aplicacion_de_conceptos.servicios.ServicioCurso;
import com.mycompany.aplicacion_de_conceptos.servicios.ServicioEstudiante;
import com.mycompany.aplicacion_de_conceptos.servicios.ServicioInscripcion;
import com.mycompany.aplicacion_de_conceptos.servicios.ServicioProfesor;

import javax.swing.*;
import java.util.List;
/**
 *
 * @author getro
 */
public class Estudiante_Detalle extends javax.swing.JInternalFrame implements Observador {

    /**
     * Creates new form Estudiante_Detalle
     */
    public Estudiante_Detalle() {
        initComponents();
        this.servicioCurso = FabricaExterior.obtenerServicioCurso();
        this.servicioEstudiante = FabricaExterior.obtenerServicioEstudiante();
        this.servicioInscripcion = FabricaExterior.obtenerServicioInscripcion();
        this.servicioProfesor = FabricaExterior.obtenerServicioProfesor();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        periodo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        historial_Cursos = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        codigo_curso = new javax.swing.JTextField();
        nombre_curso = new javax.swing.JTextField();
        ano = new javax.swing.JTextField();
        Docente = new javax.swing.JTextField();
        buscar_curso = new javax.swing.JButton();
        Inscribir_curso = new javax.swing.JButton();
        periodo_A = new javax.swing.JRadioButton();
        periodo_B = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        cursos = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        docentes = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );

        jLabel1.setText("Codigo :");

        jLabel2.setText("Estudiante :");

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(historial_Cursos, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(historial_Cursos, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Historial Cursos", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Inscripcion"));
        jPanel3.setToolTipText("Inscripcion");

        jLabel3.setText("Codigo del curso :");

        jLabel4.setText("Nombre :");

        jLabel5.setText("Año : ");

        jLabel6.setText("Periodo :");

        jLabel7.setText("ID del docente :");

        codigo_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigo_cursoActionPerformed(evt);
            }
        });

        buscar_curso.setText("Buscar");
        buscar_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_cursoActionPerformed(evt);
            }
        });

        Inscribir_curso.setText("Inscribir");
        Inscribir_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inscribir_cursoActionPerformed(evt);
            }
        });

        periodo.add(periodo_A);
        periodo_A.setText("Periodo A");

        periodo.add(periodo_B);
        periodo_B.setText("Periodo B");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Inscribir_curso)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(codigo_curso)
                            .addComponent(Docente, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(ano, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(nombre_curso, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscar_curso))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(periodo_A)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(periodo_B)))
                .addContainerGap(278, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(codigo_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buscar_curso)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nombre_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(periodo_A)
                    .addComponent(periodo_B))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(Docente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Inscribir_curso)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inscribir Curso", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cursos, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cursos, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cursos", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(docentes, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(docentes, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Docentes", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Buscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void mostrarDocentesYCursos(List<DTOProfesor> profesores, List<DTOCurso> cursos, JTextField docentes, JTextField cursosField) {
        StringBuilder textoDocentes = new StringBuilder();
        for (DTOProfesor profesor : profesores) {
            textoDocentes.append("ID: ").append((int)profesor.getId()).append(", Nombre: ").append(profesor.getNombres()).append("\n");
        }

        StringBuilder textoCursos = new StringBuilder();
        for (DTOCurso curso : cursos) {
            textoCursos.append("ID: ").append(curso.getId()).append(", Nombre: ").append(curso.getNombre()).append("\n");
        }

        docentes.setText(textoDocentes.toString());
        cursosField.setText(textoCursos.toString());
    }
    
    public void mostrarCursosInscritos(List<DTOCursoInscrito> cursos){
        StringBuilder textoCursos = new StringBuilder();
        for(DTOCursoInscrito curso : cursos){
            textoCursos.append("ID: ").append(curso.getCurso().getId()).append(", Nombre: ").append(curso.getCurso().getNombre()).append("\n");
        }
        historial_Cursos.setText(textoCursos.toString());
    }
    
    @Override
    public void actualizar(String tipoEntidad, String accion, Object dato) {
        List<DTOCurso> Cursos = servicioCurso.obtenerCursos();
        List<DTOProfesor> Profesores = servicioProfesor.obtenerProfesores();
        docentes.setText("");
        cursos.setText("");
        mostrarDocentesYCursos(Profesores, Cursos, docentes, cursos);
    }
     
    private static Estudiante_Detalle instancia;

   
    
    public static Estudiante_Detalle getInstancia() {
        if (instancia == null) {
            instancia = new Estudiante_Detalle();
        }
        return instancia;
    }
    
    
    
    private void codigo_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigo_cursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigo_cursoActionPerformed

    private void buscar_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_cursoActionPerformed
        DTOCurso curso = servicioCurso.obtenerCurso(codigo_curso.getText());
        nombre_curso.setText(curso.getNombre());
    }//GEN-LAST:event_buscar_cursoActionPerformed

    private void Inscribir_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inscribir_cursoActionPerformed
        int Periodo = 0;
        if(periodo_A.isSelected()){
            Periodo = 1;
        }else if(periodo_B.isSelected()){
            Periodo = 2;
        }
        DTOCursoInscrito cursoins = FabricaExterior.obtenerCursoInscritoDTO(servicioCurso.obtenerCurso(codigo_curso.getText())
                                                , Integer.valueOf(ano.getText()), 
                                                Periodo, servicioEstudiante.obtenerEstudiante(id.getText()));
        List<DTOCursoInscrito> Cursos = servicioInscripcion.obtenerInscripcionesPorEstudiante(title);
        mostrarCursosInscritos(Cursos);
    }//GEN-LAST:event_Inscribir_cursoActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        DTOEstudiante estudiante = servicioEstudiante.obtenerEstudiante(id.getText());
        nombre.setText(estudiante.getNombres());
        
        List<DTOCursoInscrito> Cursos = servicioInscripcion.obtenerInscripcionesPorEstudiante(title);
        mostrarCursosInscritos(Cursos);
    }//GEN-LAST:event_BuscarActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JTextField Docente;
    private javax.swing.JButton Inscribir_curso;
    private javax.swing.JTextField ano;
    private javax.swing.JButton buscar_curso;
    private javax.swing.JTextField codigo_curso;
    private javax.swing.JTextField cursos;
    private javax.swing.JTextField docentes;
    private javax.swing.JTextField historial_Cursos;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField nombre_curso;
    private javax.swing.ButtonGroup periodo;
    private javax.swing.JRadioButton periodo_A;
    private javax.swing.JRadioButton periodo_B;
    // End of variables declaration//GEN-END:variables
    ServicioCurso servicioCurso;
    ServicioProfesor servicioProfesor;
    ServicioEstudiante servicioEstudiante;
    ServicioInscripcion servicioInscripcion;
}
