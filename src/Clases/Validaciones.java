/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.barcodelib.barcode.QRCode;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Olaf G. Cortés
 */
public class Validaciones {
    
    public void validarCar(java.awt.event.KeyEvent evt, JTextField LOLField){
        char caracter = evt.getKeyChar();
        if (LOLField.getText().length() == 30)
        {
                JOptionPane.showMessageDialog(null,"solo letras");
                evt.setKeyChar('\0');
                evt.consume();
        }
        if (evt.getKeyChar() >= 33 && evt.getKeyChar() <= 64)
            {
                evt.consume();
                JOptionPane.showMessageDialog(null,"solo letras");
                System.out.println("Solo letras");
            }
        if (evt.getKeyChar() >= 91 && evt.getKeyChar() <= 96)
            {
                evt.consume();
                JOptionPane.showMessageDialog(null,"solo letras");       
                System.out.println("Solo letras");
           }
        if (evt.getKeyChar() >= 123 && evt.getKeyChar() <=161)
            {
                
                evt.consume();
            }
    }
   
      public void validar_num(java.awt.event.KeyEvent evt, JTextField ElField) {                                 
        // TODO add your handling code here:
        if (evt.getKeyChar() ==32)
            {
                evt.consume();
                JOptionPane.showMessageDialog(null,"no espacio");
                System.out.println("No espacios");
            }

        int num = evt.getKeyChar();
        if (ElField.getText().length() == 8)
        {
           evt.setKeyChar('\0');
        }
        if (evt.getKeyChar() >= 58 && evt.getKeyChar() <= 168)
            {
                evt.consume();
                JOptionPane.showMessageDialog(null,"solo numeros");
                System.out.println("Solo numeros");
                //return;
            }
        if (evt.getKeyChar() >= 33 && evt.getKeyChar() <= 47)
            {
                evt.consume();
                JOptionPane.showMessageDialog(null,"solo numeros");
                System.out.println("Solo numeros");
                //return;
            }
        
    
    
}
       public static void generarQR(String dato){
    int udm=0,resol=72,rot=0;
    float mi=0.000f,md=0.000f,ms=0.000f,min=0.000f,tam=5.000f;
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
            
            String archivo=System.getProperty("user.home")+"/documents/Almacen clone/AlmacenFinal/src/qrhistorial.jpeg";
            c.renderBarcode(archivo);
            //Desktop d= Desktop.getDesktop();
            //d.open(new File(archivo));
            ImageIcon imagen=new ImageIcon(System.getProperty("user.home")+"src/qrhistorial.jpeg");
            
        }catch(Exception e){
            System.out.println("Error en: "+e);
        }
    }
     
      
      
}
