/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abarrotes;

import Base_Datos.Conexion;
import com.barcodelib.barcode.QRCode;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.corba.se.pept.transport.Selector;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//Hi

/**
 *
 *
 */
public class Historial extends javax.swing.JFrame {
 Conexion con = new Conexion();
    PreparedStatement st=null;
    ResultSet res, idPConsec=null, kk=null;
    /**
     * Creates new form Historial
     */
    int udm=0,resol=72,rot=0;
    float mi=0.000f,md=0.000f,ms=0.000f,min=0.000f,tam=5.000f;
    public Historial() {
        initComponents();
        this.agregarOyente();
        articulos();
    }
    
    public void articulos(){
       DefaultTableModel articulos = new DefaultTableModel();
        ResultSet rs = con.getTable("select * from Articulo");
        articulos.setColumnIdentifiers(new Object[]{"ID","Nombre","Precio","Categoria","Stock Minimo","Stock Actual"});
        try {
            while(rs.next()){
                articulos.addRow(new Object[]{rs.getString("idArticulo"),rs.getString("nombre"),rs.getString("precio"),rs.getString("categoria"),rs.getString("StockMini"),rs.getString("Stock")});
            }
            jt_historial.setModel(articulos);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void generarQR(String dato){
        try{
            QRCode c= new QRCode();
            c.setData(dato);
            c.setDataMode(QRCode.MODE_BYTE);
            c.setUOM(udm);
            c.setLeftMargin(mi);
            c.setRightMargin(md);
            c.setTopMargin(ms);
            c.setBottomMargin(min);
            c.setResolution(resol);
            c.setRotate(rot);
            c.setModuleSize(tam);
            
            String archivo=System.getProperty("user.home")+"/documents/AlmacenFInal/AlmacenFinal/src/qrhistorial.jpeg";
            c.renderBarcode(archivo);
            //Desktop d= Desktop.getDesktop();
            //d.open(new File(archivo));
            ImageIcon imagen=new ImageIcon("src/qrhistorial.jpeg");
        jlbl_icono.setBounds(150,110,170,154);
        Icon icono=new ImageIcon(imagen.getImage().getScaledInstance(jlbl_icono.getWidth(),jlbl_icono.getHeight(),Image.SCALE_DEFAULT));
        jlbl_icono.setIcon(icono);
        this.repaint();
        }catch(Exception e){
            
        }
    }
    private void agregarOyente() {
        jC_fecha.getDayChooser().addPropertyChangeListener(
                new java.beans.PropertyChangeListener() {

                    @Override
                    public void propertyChange(java.beans.PropertyChangeEvent evt) {
                        if (evt.getPropertyName().compareTo("day") == 0) {
                            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd-MM-yyyy");
                            jT_fecha.setText(formatoDeFecha.format(jC_fecha.getDate()));
                        }
                    }
                });
    }
    public void pdf(){
        String ruta="C:\\Users\\FLAKO\\Documents\\Almacen clone\\AlmacenFinal\\";
        String ruta2="C:\\Users\\FLAKO\\Documents\\Almacen clone\\AlmacenFinal\\AlmacenFinalarchivo.pdf";
        String valor="bss";
        /*Codigo hora actual*/
        DateFormat df=new SimpleDateFormat("MM/dd/yyyy:HH:mm:ss");
        //String reportDate = df.format(today);
        //System.out.println("Report Date: "+reportDate);
        try{
            FileOutputStream archivo = new FileOutputStream(ruta+"AlmacenFinalarchivo.pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc,archivo);
            doc.open();
            doc.add(new Paragraph(valor+"\n\n"));
            
            PdfPTable table = new PdfPTable(jt_historial.getColumnCount());
            PdfPCell columnHeader;
       
            for (int column = 0; column <jt_historial.getColumnCount(); column++) {
                columnHeader = new PdfPCell(new Phrase(new Phrase(jt_historial.getColumnName(column))));
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(columnHeader);
            
            }
            table.setHeaderRows(1);
            for (int row = 0; row <jt_historial.getRowCount(); row++) {
                for (int column = 0; column < jt_historial.getColumnCount(); column++) {
                    table.addCell(jt_historial.getValueAt(row, column).toString());
                    
                }
            }
           doc.add(table);
            
            doc.close();
            JOptionPane.showMessageDialog(null,"PDF generado correctamente");
            Desktop d= Desktop.getDesktop();
            d.open(new File(ruta2));
        }catch(Exception e){
            System.out.println("ERROR"+e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jIF_5 = new javax.swing.JInternalFrame();
        jr_vg = new javax.swing.JRadioButton();
        jr_pmv = new javax.swing.JRadioButton();
        jr_g = new javax.swing.JRadioButton();
        jlbl_tipo = new javax.swing.JLabel();
        jC_fecha = new com.toedter.calendar.JCalendar();
        jbtn_cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_historial = new javax.swing.JTable();
        jT_fecha = new javax.swing.JTextField();
        jlbl_icono = new javax.swing.JLabel();
        jbtn_gen = new javax.swing.JButton();
        jbtn_pdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jIF_5.setBackground(new java.awt.Color(8, 188, 212));
        jIF_5.setTitle("Historial");
        jIF_5.setVisible(true);

        jr_vg.setText("Ventas Generales");

        jr_pmv.setText("Producto más vendido");

        jr_g.setText("Ganancias");

        jlbl_tipo.setText("Tipo:");

        jC_fecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jC_fechaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jC_fechaMouseEntered(evt);
            }
        });

        jbtn_cancelar.setBackground(new java.awt.Color(205, 220, 57));
        jbtn_cancelar.setText("Cancelar");
        jbtn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_cancelarActionPerformed(evt);
            }
        });

        jt_historial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jt_historial);

        jT_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_fechaActionPerformed(evt);
            }
        });

        jbtn_gen.setText("QR");
        jbtn_gen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_genActionPerformed(evt);
            }
        });

        jbtn_pdf.setText("PDF");
        jbtn_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_pdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jIF_5Layout = new javax.swing.GroupLayout(jIF_5.getContentPane());
        jIF_5.getContentPane().setLayout(jIF_5Layout);
        jIF_5Layout.setHorizontalGroup(
            jIF_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jIF_5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jIF_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jIF_5Layout.createSequentialGroup()
                        .addComponent(jlbl_tipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jIF_5Layout.createSequentialGroup()
                        .addGroup(jIF_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jIF_5Layout.createSequentialGroup()
                                .addComponent(jr_g)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jT_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jIF_5Layout.createSequentialGroup()
                                .addGroup(jIF_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jr_pmv)
                                    .addComponent(jr_vg))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtn_cancelar)))
                        .addGap(47, 47, 47)))
                .addComponent(jC_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
            .addGroup(jIF_5Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jIF_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jIF_5Layout.createSequentialGroup()
                        .addComponent(jlbl_icono, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jIF_5Layout.createSequentialGroup()
                        .addComponent(jbtn_gen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtn_pdf)
                        .addGap(39, 39, 39))))
        );
        jIF_5Layout.setVerticalGroup(
            jIF_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jIF_5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jIF_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jC_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jIF_5Layout.createSequentialGroup()
                        .addGroup(jIF_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jIF_5Layout.createSequentialGroup()
                                .addComponent(jlbl_tipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jr_vg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jr_pmv))
                            .addComponent(jbtn_cancelar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jr_g))
                    .addComponent(jT_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jIF_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jIF_5Layout.createSequentialGroup()
                        .addGroup(jIF_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtn_gen)
                            .addComponent(jbtn_pdf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(jlbl_icono, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))
                    .addGroup(jIF_5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jIF_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jIF_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_cancelarActionPerformed
        Menu m= new Menu();
        this.setVisible(false);
        m.setVisible(true);
    }//GEN-LAST:event_jbtn_cancelarActionPerformed

    private void jC_fechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jC_fechaMouseClicked
        
    }//GEN-LAST:event_jC_fechaMouseClicked

    private void jC_fechaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jC_fechaMouseEntered
    
    }//GEN-LAST:event_jC_fechaMouseEntered

    private void jT_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_fechaActionPerformed
        
        
    }//GEN-LAST:event_jT_fechaActionPerformed

    private void jbtn_genActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_genActionPerformed
        String campo= jT_fecha.getText();
        generarQR(campo);
    }//GEN-LAST:event_jbtn_genActionPerformed

    private void jbtn_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_pdfActionPerformed
        pdf();
    }//GEN-LAST:event_jbtn_pdfActionPerformed

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
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Historial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar jC_fecha;
    private javax.swing.JInternalFrame jIF_5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jT_fecha;
    private javax.swing.JButton jbtn_cancelar;
    private javax.swing.JButton jbtn_gen;
    private javax.swing.JButton jbtn_pdf;
    private javax.swing.JLabel jlbl_icono;
    private javax.swing.JLabel jlbl_tipo;
    private javax.swing.JRadioButton jr_g;
    private javax.swing.JRadioButton jr_pmv;
    private javax.swing.JRadioButton jr_vg;
    private javax.swing.JTable jt_historial;
    // End of variables declaration//GEN-END:variables
}
