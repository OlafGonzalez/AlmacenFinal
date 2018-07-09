/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abarrotes;

import Clases.Idioma;
import java.awt.Color;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Emir
 */
public class Menu extends javax.swing.JFrame {
    public String eleccionmenu="Español";
    NuevaCompra x = new NuevaCompra();
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setLocationRelativeTo(null);
        Icon icono=null;
        ImageIcon fondo = new ImageIcon(System.getProperty("user.home")+"/documents/AlmacenFinal/AlmacenFinal/src/fondo.jpeg");
        icono =new ImageIcon(fondo.getImage().getScaledInstance(jlbl_fondo.getWidth(),jlbl_fondo.getHeight(),Image.SCALE_DEFAULT));
        jlbl_fondo.setIcon(icono);
        this.getContentPane().setBackground(new java.awt.Color(33,150,243));
        cambiarIdioma1(eleccionmenu);
    }
    public void cambiarIdioma1(String nombreIdioma){
        Idioma  idioma =new Idioma(nombreIdioma);
        jbtn_al.setText(idioma.getProperty("Almacen"));
        jbtn_c.setText(idioma.getProperty("Compras"));
        jbtn_salir.setText(idioma.getProperty("Salir"));
        jbtn_h.setText(idioma.getProperty("Historial"));
        jbtn_config.setText(idioma.getProperty("Configuracion"));
        this.setTitle(idioma.getProperty("titulo"));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtn_h = new javax.swing.JButton();
        jbtn_salir = new javax.swing.JButton();
        jbtn_al = new javax.swing.JButton();
        jbtn_c = new javax.swing.JButton();
        jlbl_fondo = new javax.swing.JLabel();
        jbtn_config = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(33, 150, 233));

        jbtn_h.setBackground(new java.awt.Color(83, 109, 254));
        jbtn_h.setForeground(new java.awt.Color(240, 240, 240));
        jbtn_h.setText("Historial");
        jbtn_h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_hActionPerformed(evt);
            }
        });

        jbtn_salir.setBackground(new java.awt.Color(83, 109, 254));
        jbtn_salir.setForeground(new java.awt.Color(240, 240, 240));
        jbtn_salir.setText("Salir");
        jbtn_salir.setToolTipText("");
        jbtn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_salirActionPerformed(evt);
            }
        });

        jbtn_al.setBackground(new java.awt.Color(83, 109, 254));
        jbtn_al.setForeground(new java.awt.Color(240, 240, 240));
        jbtn_al.setText("Almacen");
        jbtn_al.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_alActionPerformed(evt);
            }
        });

        jbtn_c.setBackground(new java.awt.Color(83, 109, 254));
        jbtn_c.setForeground(new java.awt.Color(240, 240, 240));
        jbtn_c.setText("Compras");
        jbtn_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_cActionPerformed(evt);
            }
        });

        jbtn_config.setBackground(new java.awt.Color(83, 109, 254));
        jbtn_config.setForeground(new java.awt.Color(240, 240, 240));
        jbtn_config.setText("Configuracion");
        jbtn_config.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_configActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtn_c)
                        .addGap(28, 28, 28)
                        .addComponent(jbtn_al)
                        .addGap(39, 39, 39)
                        .addComponent(jbtn_h)
                        .addGap(18, 18, 18)
                        .addComponent(jbtn_config)
                        .addGap(18, 18, 18)
                        .addComponent(jbtn_salir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jlbl_fondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbl_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_c)
                    .addComponent(jbtn_al)
                    .addComponent(jbtn_h)
                    .addComponent(jbtn_salir)
                    .addComponent(jbtn_config))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_alActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_alActionPerformed
        Almacen j = new Almacen();
        j.setVisible(true);
        j.cambiarIdioma1(eleccionmenu);
        this.setVisible(false);
    }//GEN-LAST:event_jbtn_alActionPerformed

    private void jbtn_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_cActionPerformed

        x.setVisible(true);
        x.cambiarIdioma1(eleccionmenu);
        this.setVisible(false);
    }//GEN-LAST:event_jbtn_cActionPerformed

    private void jbtn_hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_hActionPerformed
        Historial h = new Historial();
        h.cambiarIdioma1(eleccionmenu);
        h.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbtn_hActionPerformed

    private void jbtn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_salirActionPerformed
        System.exit(WIDTH);
    }//GEN-LAST:event_jbtn_salirActionPerformed

    private void jbtn_configActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_configActionPerformed
        Configuracion c = new Configuracion();
        this.setVisible(false);
        c.setVisible(true);
        c.cambiarIdioma1(this.eleccionmenu);
    }//GEN-LAST:event_jbtn_configActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtn_al;
    private javax.swing.JButton jbtn_c;
    private javax.swing.JButton jbtn_config;
    private javax.swing.JButton jbtn_h;
    private javax.swing.JButton jbtn_salir;
    private javax.swing.JLabel jlbl_fondo;
    // End of variables declaration//GEN-END:variables

}
