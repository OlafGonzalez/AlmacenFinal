/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.io.IOException;
import java.util.Properties;
/**
 *
 * @author Emir
 */
public class Idioma extends Properties{
    private static final long serialVersionUID = 1L;
    public Idioma(String idioma){
        switch(idioma){
	    	case "Español":
                    getProperties("espanol.properties");
                    break;
	    	case "Ingles":
                    getProperties("ingles.properties");
                    break;
                default:
                    getProperties("espanol.properties");
        }
    }
    private void getProperties(String idioma) {
        try {
            //System.out.println(getClass().getResourceAsStream(idioma));
            this.load(getClass().getResourceAsStream(idioma));
        } catch (IOException ex) {
            System.out.println("No existe");
        }
   }
}
