//primera edicion
package ConexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    
 public Connection conexion= null;
 private final String URL = "jdbc:mysql://localhost:3306/puntoventa"; 
 private final String User = "armando"; 
 private final String Password="12345678";
 
private final String URL_CLOUD = "jdbc:mysql://umr7frgsaus5dsqd:QuFI8nlpFrKwK7wm85gq@bce4nmpxhmia80duyuch-mysql.services.clever-cloud.com:3306/bce4nmpxhmia80duyuch";
private final String User_Cloud = "umr7frgsaus5dsqd";
private final String Password_Cloud = "QuFI8nlpFrKwK7wm85gq";
  
   
   public  Connection Conectar() throws SQLException{   
   try  {
         this.conexion = DriverManager.getConnection(URL, User, Password);
        System.out.println("Conexion Exitosa a la BD");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al conectarse","ERROR-DB",0);
        }
     return conexion;
   
   }//Fin del metodo conectar
   
   
   public Connection ConectarBDcloud() throws SQLException{
       
         try  {
         this.conexion = DriverManager.getConnection(URL_CLOUD, User_Cloud, Password_Cloud);
        System.out.println("Conexion Exitosa a la BD");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al conectarse","ERROR-DB",0);
        }
        return conexion;
   
   }//Fin del metodo conexion a la nube
   
   
   public void CerrarConexion() throws SQLException{
       if(conexion!=null){
           if(!conexion.isClosed()){
               conexion.close();
           }
       
       }
   }//Fin del metodo cerrar conexion
    
}
