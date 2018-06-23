/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Emir
 */
public class CM {
    Connection con;
    public void conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/Almacen","root","");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void productos()throws SQLException{
        conectar();
        Statement st=con.createStatement();//Abrir una consulta
        ResultSet rs=st.executeQuery("Select *FROM articulo");
    }
    public ResultSet getTable(String consulta){
        //sConnection con;
        Statement sta;
        ResultSet datos = null;
        try {
        sta=con.createStatement();
        datos=sta.executeQuery(consulta);
            }
        catch(Exception e){System.out.print(e.toString());}{
                return datos;
                
        }
}
}
