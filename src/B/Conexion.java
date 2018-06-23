/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_Datos;

import java.sql.*;
/**
 *
 * @author Olaf G. Cortés
 */
public class Conexion {
    ResultSet rs;
    Statement stat;
    public String bd = "Almacen";
    public String login = "root";
    public String password = "";
    public String url = "jdbc:mysql://localhost/"+bd;


Connection conn = null;

   public Conexion()
   {
      try{
             Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection(url,login,password);
             if (conn!=null)
             {
                //JOptionPane.showMessageDialog(null,"Conexión a base de datos "+bd+" exitosa");
                 System.out.print("conexion...ok");
             }
      }catch(SQLException ex)
      {
         System.out.println(ex);
      }
      catch(ClassNotFoundException e)
      {
         System.out.println(e);
      }
   }

   public Connection obtenerConexion()
   {
      return conn;
   }

   public void desconectar(){
      conn = null;
   }
   public ResultSet ejecutar2(){
            return rs;
	}
   public Statement ejecutarStatement()
   {

        return stat;
   }
   
   public  ResultSet getTable(String consulta){
   Connection con = obtenerConexion();
   Statement stat;
   ResultSet datos= null;
   try{
       stat =con.createStatement();
       datos=stat.executeQuery(consulta);
   }
   catch(Exception e){System.out.print(e.toString());}
   return datos;
  }       
}
