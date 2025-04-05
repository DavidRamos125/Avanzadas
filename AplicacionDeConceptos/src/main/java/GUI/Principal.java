/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author getro
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        Estudiante = new javax.swing.JMenu();
        Basico_Estidiante = new javax.swing.JMenuItem();
        Detalle_Estudiante = new javax.swing.JMenuItem();
        Cursos = new javax.swing.JMenu();
        Basico_Curso = new javax.swing.JMenuItem();
        Docente = new javax.swing.JMenu();
        Basico_Docente = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1126, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        Estudiante.setText("Estudiante");

        Basico_Estidiante.setText("Basico");
        Basico_Estidiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Basico_EstidianteActionPerformed(evt);
            }
        });
        Estudiante.add(Basico_Estidiante);

        Detalle_Estudiante.setText("Detalle");
        Detalle_Estudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Detalle_EstudianteActionPerformed(evt);
            }
        });
        Estudiante.add(Detalle_Estudiante);

        jMenuBar1.add(Estudiante);

        Cursos.setText("Cursos");

        Basico_Curso.setText("Basico");
        Basico_Curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Basico_CursoActionPerformed(evt);
            }
        });
        Cursos.add(Basico_Curso);

        jMenuBar1.add(Cursos);

        Docente.setText("Docente");

        Basico_Docente.setText("Basico");
        Basico_Docente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Basico_DocenteActionPerformed(evt);
            }
        });
        Docente.add(Basico_Docente);

        jMenuBar1.add(Docente);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Basico_EstidianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Basico_EstidianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Basico_EstidianteActionPerformed

    private void Detalle_EstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Detalle_EstudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Detalle_EstudianteActionPerformed

    private void Basico_CursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Basico_CursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Basico_CursoActionPerformed

    private void Basico_DocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Basico_DocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Basico_DocenteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Basico_Curso;
    private javax.swing.JMenuItem Basico_Docente;
    private javax.swing.JMenuItem Basico_Estidiante;
    private javax.swing.JMenu Cursos;
    private javax.swing.JMenuItem Detalle_Estudiante;
    private javax.swing.JMenu Docente;
    private javax.swing.JMenu Estudiante;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
