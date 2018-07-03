/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

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
      public void AgregarCV(){
          
      }
      
      
      
}
