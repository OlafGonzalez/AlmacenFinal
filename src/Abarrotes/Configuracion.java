/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abarrotes;

import Clases.Idioma;

/**
 *
 * @author Emir
 */
public class Configuracion extends javax.swing.JFrame {
    private String eleccion="Español";
    Menu m = new Menu();
    /**
     * Creates new form Configuracion
     */
    public Configuracion() {
        initComponents();
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(new java.awt.Color(33,150,243));
        cambiarIdioma1(eleccion);
    }
    public void cambiarIdioma1(String nombreIdioma){
        Idioma  idioma =new Idioma(nombreIdioma);
        jbtn_español.setText(idioma.getProperty("Español"));
        jbtn_ingles.setText(idioma.getProperty("Ingles"));
        lbl_selec.setText(idioma.getProperty("sub1"));
        this.setTitle(idioma.getProperty("titulo1"));
        jbnt_regresar.setText(idioma.getProperty("Regresar"));
        m.eleccionmenu=nombreIdioma;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_selec = new javax.swing.JLabel();
        jbtn_español = new javax.swing.JButton();
        jbtn_ingles = new javax.swing.JButton();
        jbnt_regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_selec.setForeground(new java.awt.Color(240, 240, 240));
        lbl_selec.setText("Seleccione un idioma:");

        jbtn_español.setBackground(new java.awt.Color(83, 109, 254));
        jbtn_español.setForeground(new java.awt.Color(240, 240, 240));
        jbtn_español.setText("Español");
        jbtn_español.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_españolActionPerformed(evt);
            }
        });

        jbtn_ingles.setBackground(new java.awt.Color(83, 109, 254));
        jbtn_ingles.setForeground(new java.awt.Color(240, 240, 240));
        jbtn_ingles.setText("Inglés");
        jbtn_ingles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_inglesActionPerformed(evt);
            }
        });

        jbnt_regresar.setBackground(new java.awt.Color(83, 109, 254));
        jbnt_regresar.setForeground(new java.awt.Color(240, 240, 240));
        jbnt_regresar.setText("Regresar");
        jbnt_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbnt_regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_selec)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbnt_regresar)
                            .addComponent(jbtn_ingles)
                            .addComponent(jbtn_español))
                        .addGap(5, 5, 5)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_selec)
                .addGap(18, 18, 18)
                .addComponent(jbtn_español)
                .addGap(18, 18, 18)
                .addComponent(jbtn_ingles)
                .addGap(18, 18, 18)
                .addComponent(jbnt_regresar)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_españolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_españolActionPerformed
        cambiarIdioma1("Español");
        this.eleccion="Español";
        m.cambiarIdioma1(eleccion);
        //m.eleccionmenu="Español";
    }//GEN-LAST:event_jbtn_españolActionPerformed

    private void jbtn_inglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_inglesActionPerformed
        cambiarIdioma1("Ingles");
        this.eleccion="Ingles";
        //m.eleccionmenu="Ingles";
        m.cambiarIdioma1(eleccion);
    }//GEN-LAST:event_jbtn_inglesActionPerformed

    private void jbnt_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbnt_regresarActionPerformed
        this.setVisible(false);
        //m.eleccion=this.eleccion;
        m.setVisible(true);
        m.cambiarIdioma1(m.eleccionmenu);
    }//GEN-LAST:event_jbnt_regresarActionPerformed

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
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbnt_regresar;
    private javax.swing.JButton jbtn_español;
    private javax.swing.JButton jbtn_ingles;
    private javax.swing.JLabel lbl_selec;
    // End of variables declaration//GEN-END:variables
//private Idioma idioma;
}
