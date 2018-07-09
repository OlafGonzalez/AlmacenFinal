/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abarrotes;

import Base_Datos.Conexion;
import Clases.Idioma;
import Clases.Validaciones;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.corba.se.pept.transport.Selector;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Image;
import java.util.Set;


//Hi

/**
 *
 *
 */
public class Historial extends javax.swing.JFrame {
 Conexion con = new Conexion();
 public String h="Español";
         Menu m= new Menu();
    PreparedStatement st=null;
    ResultSet res, idPConsec=null, kk=null,rs;
    Calendar fecha = new GregorianCalendar();
    String Consulta,Tipo;
    Object colum = new Object();
    Object result = new Object();
     int ano = fecha.get(Calendar.YEAR);
     int mes = fecha.get(Calendar.MONTH);
     int dia = fecha.get(Calendar.DAY_OF_MONTH);
     int mes2 = mes+2;
     Validaciones val = new Validaciones();
    /**
     * Creates new form Historial
     */
  
    public Historial() {
        initComponents();
        this.agregarOyente();
        setLocationRelativeTo(null);
        jT_fecha.setVisible(true);
        this.getContentPane().setBackground(new java.awt.Color(0,188,212));
    }
    public void cambiarIdioma1(String nombreIdioma){
        Idioma  idioma =new Idioma(nombreIdioma);
        jlbl_select.setText(idioma.getProperty("sub4"));
        jbtn_cancelar.setText(idioma.getProperty("Cancelar"));
        h=nombreIdioma;
    }

    private void agregarOyente() {
        jC_fecha.getDayChooser().addPropertyChangeListener(
                new java.beans.PropertyChangeListener() {

                    @Override
                    public void propertyChange(java.beans.PropertyChangeEvent evt) {
                        if (evt.getPropertyName().compareTo("day") == 0) {
                            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
                            jT_fecha.setText(formatoDeFecha.format(jC_fecha.getDate()));
                            //ejecuta consulta 
                           
                        }
                    }
                });
    }
    
    
    public void pdf(){
        Error e = new Error();
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
            Paragraph pe = new Paragraph("Registros Abarrotes");
            pe.setAlignment(1);
            doc.add(pe);
            Paragraph ti = new Paragraph("Articulos en Stock");
            ti.setAlignment(1);
            doc.add(ti);
            String LOGO= "C:\\Users\\FLAKO\\Documents\\Almacen clone\\AlmacenFinal\\logo.png";
            String SHOP="C:\\Users\\FLAKO\\Documents\\Almacen clone\\AlmacenFinal\\shop-icon_34368.png";  
            Date now = new Date(System.currentTimeMillis());
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
            Paragraph a = new Paragraph ("Fecha creación: "+date.format(now)+"                                                                                  Hora:"+hour.format(now));
            Image logo= Image.getInstance(LOGO);
            logo.setAbsolutePosition(510f, 740f);
            logo.scaleAbsoluteWidth(90.0f);
            logo.scaleAbsoluteHeight(80.0f);
            doc.add(logo);
            val.generarQR("Desarrollado por:\nMendoza Suarez Emir Edmundo\nGonzalez Cortes Olaf\n Universidad Politecnica de Pachuca");
            Image ejqr= Image.getInstance(System.getProperty("user.home")+"/documents/Almacen clone/AlmacenFinal/src/qrhistorial.jpeg");
            ejqr.setAbsolutePosition(490f, 20f);
            ejqr.scaleAbsoluteWidth(90.0f);
            ejqr.scaleAbsoluteHeight(80.0f);
            doc.add(ejqr);
            Image shop= Image.getInstance(SHOP);
            shop.setAbsolutePosition(10f, 740f);
            shop.scaleAbsoluteWidth(90.0f);
            shop.scaleAbsoluteHeight(80.0f);
            doc.add(shop);
            Paragraph espacios = new Paragraph("\n\n\n\n\n\n");
            doc.add(espacios);
            
       
            
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
            doc.add(espacios);
            doc.add(a);
            doc.close();
            JOptionPane.showMessageDialog(null,"PDF generado correctamente");
            Desktop d= Desktop.getDesktop();
            d.open(new File(ruta2));
        }catch(Exception ex){
            System.out.println("ERROR"+ex);
            e.cambiarIdioma1(h);
            e.setVisible(true);
            this.setVisible(false);
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

        jbtn_pdf = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_historial = new javax.swing.JTable();
        jC_fecha = new com.toedter.calendar.JCalendar();
        jbtn_cancelar = new javax.swing.JButton();
        jcmb_Tipo = new javax.swing.JComboBox<>();
        jT_fecha = new javax.swing.JTextField();
        jlbl_select = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Historial");

        jbtn_pdf.setBackground(new java.awt.Color(205, 220, 57));
        jbtn_pdf.setText("PDF");
        jbtn_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_pdfActionPerformed(evt);
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

        jcmb_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo", "Ventas Generales", "Compras Generales", "Producto mas Vendido", "Ventas Diarias", "Ventas Mensuales", " " }));
        jcmb_Tipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmb_TipoItemStateChanged(evt);
            }
        });
        jcmb_Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmb_TipoActionPerformed(evt);
            }
        });
        jcmb_Tipo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jcmb_TipoPropertyChange(evt);
            }
        });

        jT_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_fechaActionPerformed(evt);
            }
        });
        jT_fecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jT_fechaPropertyChange(evt);
            }
        });

        jlbl_select.setText("Seleccione un tipo de historial:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jbtn_cancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlbl_select)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcmb_Tipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(59, 59, 59)
                                .addComponent(jT_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(62, 62, 62)
                .addComponent(jC_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jbtn_pdf)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jlbl_select)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jT_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcmb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(jbtn_cancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jC_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_pdf))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_cancelarActionPerformed
        m.cambiarIdioma1(h);
        m.eleccionmenu=h;
        this.setVisible(false);
        m.setVisible(true);
    }//GEN-LAST:event_jbtn_cancelarActionPerformed

    private void jC_fechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jC_fechaMouseClicked
        
    }//GEN-LAST:event_jC_fechaMouseClicked

    private void jC_fechaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jC_fechaMouseEntered
    
    }//GEN-LAST:event_jC_fechaMouseEntered

    private void jT_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_fechaActionPerformed
        
        
    }//GEN-LAST:event_jT_fechaActionPerformed

    private void jbtn_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_pdfActionPerformed
        pdf();
    }//GEN-LAST:event_jbtn_pdfActionPerformed

    private void jT_fechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jT_fechaPropertyChange
              
    }//GEN-LAST:event_jT_fechaPropertyChange

    private void jcmb_TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmb_TipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmb_TipoActionPerformed

    private void jcmb_TipoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jcmb_TipoPropertyChange
    }//GEN-LAST:event_jcmb_TipoPropertyChange

    private void jcmb_TipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmb_TipoItemStateChanged

    switch(jcmb_Tipo.getSelectedItem().toString()){
       
        case "Ventas Generales":
         Tipo = "Ventas Generales";
         Consulta = "select nombre,precioVenta,cantidad,fecha from articulo, DetalleV where articulo.idArticulo=DetalleV.idArticulo and fecha like '"+jT_fecha.getText()+"';";
         Consultas(Consulta, jT_fecha);
         System.out.println(Consulta);
            break;
        case "Compras Generales":
         Tipo = "Compras Generales";
         Consulta = "select nombre,precioCompra,cantidad,fecha from articulo, DetalleC where articulo.idArticulo=DetalleC.idArticulo and fecha like '"+jT_fecha.getText()+"';";
            Consultas(Consulta, jT_fecha);
         System.out.println(Consulta);
            break;
        case "Producto mas Vendido":
            Tipo = "Producto mas Vendido";
            Consulta = "select nombre,sum(Cantidad),fecha from DetalleV, Articulo where DetalleV.idArticulo=Articulo.idArticulo and fecha like'"+jT_fecha.getText()+"' group by nombre limit 1;";
            System.out.println(Consulta);
            Consultas(Consulta, jT_fecha);
            break;
        case "Ventas Diarias":
            Tipo = "Ventas Diarias";
            Consulta = "select count(a.idVenta) as Ventas, sum(total) as Total from Venta as a,DetalleV as b where a.idVenta=b.idVenta and fecha like '"+jT_fecha.getText()+"';";
            Consultas(Consulta, jT_fecha);
            break;
        case "Ventas Mensuales":
            Tipo = "Ventas Mensuales";
            Consulta = "select count(a.idVenta) as Ventas, sum(total) as Total from Venta as a,DetalleV as b where a.idVenta=b.idVenta and fecha <= '"+jT_fecha.getText()+"' or fecha >= '"+ano+"-0"+mes2+"-0"+dia+"';";
            System.out.println(Consulta);
            Consultas(Consulta, jT_fecha);
            break;
         
    }
    }//GEN-LAST:event_jcmb_TipoItemStateChanged

    public void Consultas(String Consulta,JTextField fecha){
        DefaultTableModel articulos = new DefaultTableModel();
        switch(Tipo){
            
        case "Ventas Generales":
        rs = con.getTable(Consulta);
        articulos.setColumnIdentifiers(new Object []{"nombre","precio","cantidad","fecha"});
        try {
            while(rs.next()){
                articulos.addRow(new Object[]{rs.getString("nombre"),rs.getString("precioVenta"),rs.getString("cantidad"),rs.getString("fecha")});
            }
            jt_historial.setModel(articulos);
        } catch (Exception e) {
            System.out.println(e);
        }
                break;
                
        case "Compras Generales":
        rs = con.getTable(Consulta);
        articulos.setColumnIdentifiers(new Object []{"nombre","precio","cantidad","fecha"});
        try {
            while(rs.next()){
                articulos.addRow(new Object[]{rs.getString("nombre"),rs.getString("precioCompra"),rs.getString("cantidad"),rs.getString("fecha")});
            }
            jt_historial.setModel(articulos);
        } catch (Exception e) {
            System.out.println(e);
        }
            break;
            
        case "Producto mas Vendido":
            rs = con.getTable(Consulta);
            articulos.setColumnIdentifiers(new Object[]{"nombre","cantidad","fecha"});
            try {
                while (rs.next()) {                    
                    articulos.addRow(new Object[]{rs.getString("nombre"),rs.getString("SUM(Cantidad)"),rs.getString("fecha")});
                }
                jt_historial.setModel(articulos);
            } catch (Exception e) {
                System.out.println(e);
            }
            break;
        case "Ventas Diarias":
            rs= con.getTable(Consulta);
            articulos.setColumnIdentifiers(new Object[]{"Ventas","Total"});
            try {
                while (rs.next()) {                    
                    articulos.addRow(new Object[]{rs.getString("Ventas"),rs.getString("Total")});
                }
                jt_historial.setModel(articulos);
            } catch (Exception e) {
            }
            break;
        case "Ventas Mensuales":
          rs= con.getTable(Consulta);
            articulos.setColumnIdentifiers(new Object[]{"Ventas","Total"});
            try {
                while (rs.next()) {                    
                    articulos.addRow(new Object[]{rs.getString("Ventas"),rs.getString("Total")});
                }
                jt_historial.setModel(articulos);
            } catch (Exception e) {
            }  
            break;
            
        }
        
    }
   
  
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jT_fecha;
    private javax.swing.JButton jbtn_cancelar;
    private javax.swing.JButton jbtn_pdf;
    private javax.swing.JComboBox<String> jcmb_Tipo;
    private javax.swing.JLabel jlbl_select;
    private javax.swing.JTable jt_historial;
    // End of variables declaration//GEN-END:variables
}
