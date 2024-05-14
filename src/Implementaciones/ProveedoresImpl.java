
package Implementaciones;

import ConexionDB.Conexion;
import Modelo.ModeloProveedores;
import interfaces.InterfaceProveedores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Armando
 */
public class ProveedoresImpl  extends Conexion implements InterfaceProveedores{

    @Override
    public void Registrar(ModeloProveedores proveedor) {
      try{
            
            Conectar();
            PreparedStatement stmt = this.conexion.prepareStatement("INSERT INTO proveedores(nombre, direccion,telefono) VALUES (?, ?, ?)");
          
            stmt.setString(1,proveedor.getNombre());
            stmt.setString(2,proveedor.getDireccion());
            stmt.setString(3,proveedor.getTelefono());
            stmt.execute();
            stmt.close();  

                        JOptionPane.showMessageDialog(null,
                "<html><body><h3 style='color:green;'>Registro Exitoso</h3>"
                + "<p>El registro se ha completado exitosamente.</p></body></html>",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            
        }finally{
            try {
                CerrarConexion();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al Cerrar la conexion BD", "Error en DB-Clientes", 0);
            }
        }
    }

    @Override
    public void Modificar(ModeloProveedores proveedor) {
           try{
            Conectar();
            PreparedStatement stmt = this.conexion.prepareStatement("UPDATE proveedores SET nombre = ?  ,  direccion = ? , telefono = ? WHERE id = ?");
          
            stmt.setString(1,proveedor.getNombre());
            stmt.setString(2,proveedor.getDireccion());
            stmt.setString(3,proveedor.getTelefono());
            stmt.setInt(4, proveedor.getId());
            stmt.execute();
            stmt.close();  
                        JOptionPane.showMessageDialog(null,
                "<html><body><h3 style='color:green;'>Modificacion Exitoso</h3>"
                + "<p>La modificacion se ha completado exitosamente.</p></body></html>",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            
        }finally{
            try {
                CerrarConexion();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al Cerrar la conexion BD", "Error en DB-Clientes", 0);
            }
        }
    }

    @Override
    public void Eliminar(int userId) {
         try{   
            Conectar();
            PreparedStatement stmt = this.conexion.prepareStatement("DELETE FROM proveedores WHERE id = ?");
            stmt.setInt(1,userId);
            stmt.execute();
            stmt.close();  
            
        }catch(Exception e){
             System.out.println(e);
        }finally{
            try {
                CerrarConexion();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al Cerrar la conexion BD", "Error en DB-Clientes", 0);
            }
        }
    }

    @Override
    public List<ModeloProveedores> listar(String name) {
       List<ModeloProveedores> lista = null;
      try{
          Conectar();
          PreparedStatement stmt = this.conexion.prepareStatement("SELECT * FROM proveedores");
        
          lista= new ArrayList();
          ResultSet ResultadosProveedores= stmt.executeQuery();
          
          //obtener todos los resultados
          while(ResultadosProveedores.next()){
              
             ModeloProveedores ProveedoresRegistrados = new ModeloProveedores();
             
             ProveedoresRegistrados.setId(ResultadosProveedores.getInt("id"));
             ProveedoresRegistrados.setNombre(ResultadosProveedores.getString("nombre"));
             ProveedoresRegistrados.setDireccion(ResultadosProveedores.getString("direccion"));
             ProveedoresRegistrados.setTelefono(ResultadosProveedores.getString("telefono"));
             lista.add(ProveedoresRegistrados);
             
          }//fin del while
         ResultadosProveedores.close();
         stmt.close();
      }catch(Exception e){
      
      }finally{
            try {
                CerrarConexion();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
      }
      return lista;
    }

    @Override
    public ModeloProveedores getUserById(int userId) throws Exception {
          ModeloProveedores ProveedoresRegistrados = new ModeloProveedores();
      try{
          Conectar();
          PreparedStatement stmt = this.conexion.prepareStatement("SELECT * FROM proveedores WHERE id = ? LIMIT 1;");
          stmt.setInt(1,userId);

          ResultSet ResultadosProveedores = stmt.executeQuery();
          //obtener todos los resultados
          while(ResultadosProveedores.next()){
              
            
             ProveedoresRegistrados.setId(ResultadosProveedores.getInt("id"));
             ProveedoresRegistrados.setNombre(ResultadosProveedores.getString("nombre"));
             ProveedoresRegistrados.setDireccion(ResultadosProveedores.getString("direccion"));
             ProveedoresRegistrados.setTelefono(ResultadosProveedores.getString("telefono"));
           
          }//fin del while
          
         ResultadosProveedores.close();
         stmt.close();
         
      }catch(Exception e){
      
      }finally{
            try {
                CerrarConexion();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
      }
      return ProveedoresRegistrados;
    }
    
}
