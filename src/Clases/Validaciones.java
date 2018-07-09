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
     
      public static boolean vacio(JTextField txtNum1, JTextField txtNum2){
        if((txtNum1.getText().isEmpty()) || (txtNum2.getText().isEmpty())){
            JOptionPane.showMessageDialog(null,"No dejar campos vacios!!","Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        return true;
        }
    }
      
    public void limite_caracteres(java.awt.event.KeyEvent e, JTextField t){
        if (t.getText().length()==10){
            e.consume();
        }
    }
  
    public static boolean cero(JTextField t){
        double a,b;
        a=Double.parseDouble(t.getText());
        if(a==0){
            JOptionPane.showMessageDialog(null,"No se puede dividir entre 0!","Error!",JOptionPane.ERROR_MESSAGE);
            t.setText("");
            return false;
        }
        return true;
    }
    public void signo(java.awt.event.KeyEvent evt, JTextField txtnum1){
        char a= evt.getKeyChar();
        boolean valid=false;
        if(a=='-'){
        Object component= evt.getComponent();
         if(component instanceof JTextField){
         JTextField tf=(JTextField) component;
            valid=tf.getText().isEmpty();
            }
        }
        else if(a>='.'){
            valid=true;
        }
        else if(a>= '0' && a<='9'){
            valid=true;
        }
        if(!valid){
            evt.consume();
        }   
    }
    public void s(JTextField txtnum1, JTextField txtnum2){
        if(txtnum1.getText()=="-" && txtnum2.getText()=="-"){
            JOptionPane.showMessageDialog(null,"Error, debe ingresar numeros!","Error!",JOptionPane.ERROR_MESSAGE);
        }
}
    public void Signomenos(java.awt.event.KeyEvent evt, JTextField field){
         if(evt.getKeyChar()== '-'){
            evt.consume();
        }
        if(evt.getKeyChar()=='.' && field.getText().contains(".")){
            evt.consume();
        }
        if(!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar()!= '.' && evt.getKeyChar()!='-'){
        evt.consume();
    }
    }
    
}
