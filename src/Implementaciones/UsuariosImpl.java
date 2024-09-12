
package Implementaciones;

import ConexionDB.Conexion;
import Modelo.ModeloClientes;
import Modelo.ModeloUsuarios;
import interfaces.InterfaceUsuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;  
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class UsuariosImpl extends Conexion implements  InterfaceUsuarios {

    @Override
    public void Registrar(ModeloUsuarios Usuario) {
        try {
            ConectarBDcloud();
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO usuarios(nombre,usuario,contrasena,permiso) VALUE(?,?,?,?)");
            stmt.setString(1, Usuario.getNombre());
            stmt.setString(2, Usuario.getUsuario());
            stmt.setString(3, Usuario.getPassword());
            stmt.setString(4, Usuario.getPermiso());
            stmt.execute();
            stmt.close(); 
        } catch (SQLException ex) {
            
        }
    }//Fin Metodo Registrar


    @Override
    public void Modificar(ModeloUsuarios Usuario) {
        try{
            ConectarBDcloud();
            PreparedStatement stmt = conexion.prepareStatement("UPDATE usuarios SET nombre = ? , usuario = ? , contrasena = ? , permiso = ? WHERE id = ?");
          
            stmt.setString(1,Usuario.getNombre());
            stmt.setString(2,Usuario.getUsuario());
            stmt.setString(3,Usuario.getPassword());
            stmt.setString(4,Usuario.getPermiso());
            stmt.setInt(5, Usuario.getId());
            stmt.execute();
            stmt.close();  
                        JOptionPane.showMessageDialog(null,
                "<html><body><h3 style='color:green;'>Modificacion Exitoso</h3>"
                + "<p>La modificacion se ha completado exitosamente.</p></body></html>",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            try {
                CerrarConexion();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }//Fin de modificar

    @Override
    public void Eliminar(int Usuario) {
        try{   
            ConectarBDcloud();
            PreparedStatement stmt = this.conexion.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            stmt.setInt(1,Usuario);
            stmt.execute();
            stmt.close();  
            
        }catch(Exception e){
            System.out.println(e);
        }finally{
            try {
                CerrarConexion();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    public List<ModeloUsuarios> listar(String name) throws Exception {
           List<ModeloUsuarios> lista = null;
      try{
          ConectarBDcloud();
          PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM usuarios");
        
          lista= new ArrayList();
          ResultSet ResultadosUsuario = stmt.executeQuery();
          
          //obtener todos los resultados
          while(ResultadosUsuario.next()){
             ModeloUsuarios UsuariosRegistrados = new ModeloUsuarios();
             
             UsuariosRegistrados.setId(ResultadosUsuario.getInt("id"));
             UsuariosRegistrados.setNombre(ResultadosUsuario.getString("nombre"));
             UsuariosRegistrados.setUsuario(ResultadosUsuario.getString("usuario"));
             UsuariosRegistrados.setPassword(ResultadosUsuario.getString("contrasena"));
             UsuariosRegistrados.setPermiso(ResultadosUsuario.getString("permiso"));
             lista.add(UsuariosRegistrados);
             
          }//fin del while
         ResultadosUsuario.close();
         stmt.close();
      }catch(Exception e){
          System.out.println(e);
      }finally{
            try {
                CerrarConexion();
            } catch (SQLException ex) {
               
            }
      }
      return lista;
    }//Fin del metodo list

    @Override
    public ModeloUsuarios getUserById(int userId) throws Exception {
        ModeloUsuarios UsuariosRegistrados = new ModeloUsuarios();
      try{
          ConectarBDcloud();
          PreparedStatement stmt = this.conexion.prepareStatement("SELECT * FROM usuarios WHERE id = ? LIMIT 1;");
          stmt.setInt(1,userId);

          ResultSet ResultadosUsuarios = stmt.executeQuery();
          //obtener todos los resultados
          while(ResultadosUsuarios.next()){
              
            
             UsuariosRegistrados.setId(ResultadosUsuarios.getInt("id"));
             UsuariosRegistrados.setNombre(ResultadosUsuarios.getString("nombre"));
             UsuariosRegistrados.setUsuario(ResultadosUsuarios.getString("usuario"));
             UsuariosRegistrados.setPassword(ResultadosUsuarios.getString("contrasena"));
             UsuariosRegistrados.setPermiso(ResultadosUsuarios.getString("permiso"));
          }//fin del while
          
         ResultadosUsuarios.close();
         stmt.close();
         
      }catch(Exception e){
      
      }finally{
            try {
                CerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ClientesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      return UsuariosRegistrados;
    }
    
}//Fin de la clase
