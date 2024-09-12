
package Implementaciones;


import ConexionDB.Conexion;
import Modelo.ModeloClientes;
import interfaces.InterfaceClientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ClientesImpl extends Conexion implements  InterfaceClientes{

    @Override
    public void Registrar(ModeloClientes cliente) {
        try{
            
             ConectarBDcloud();
            PreparedStatement stmt = this.conexion.prepareStatement("INSERT INTO clientes(nombre, apellidopaterno, apellidomaterno, telefono, direccion, descuento) VALUES (?, ?, ?, ?, ?, ?)");
          
            stmt.setString(1,cliente.getNombre());
            stmt.setString(2,cliente.getApellidoPaterno());
            stmt.setString(3,cliente.getApellidoMaterno());
            stmt.setString(4,cliente.getTelefono());
            stmt.setString(5,cliente.getDireccion());
            stmt.setString(6,cliente.getDescuento());
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
    }//Fin de la sobreescritura Registrar

    
    
    @Override
    public void Modificar(ModeloClientes cliente) {
        try{
             ConectarBDcloud();
            PreparedStatement stmt = this.conexion.prepareStatement("UPDATE clientes SET nombre = ? , apellidopaterno = ? , apellidomaterno = ? , telefono = ?, direccion = ? , descuento = ? WHERE id = ?");
          
            stmt.setString(1,cliente.getNombre());
            stmt.setString(2,cliente.getApellidoPaterno());
            stmt.setString(3,cliente.getApellidoMaterno());
            stmt.setString(4,cliente.getTelefono());
            stmt.setString(5,cliente.getDireccion());
            stmt.setString(6,cliente.getDescuento());
            stmt.setInt(7, cliente.getId());
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
             ConectarBDcloud();
            PreparedStatement stmt = this.conexion.prepareStatement("DELETE FROM clientes WHERE id = ?");
            stmt.setInt(1,userId);
            stmt.execute();
            stmt.close();  
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Erro al eliminar Cliente", 0);
        }finally{
            try {
                CerrarConexion();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al Cerrar la conexion BD", "Error en DB-Clientes", 0);
            }
        }

    }//Fin de la sobreescritura Eliminar


    
    @Override
    public List<ModeloClientes> listar(String name) throws Exception {
        List<ModeloClientes> lista = null;
      try{
           ConectarBDcloud();
          PreparedStatement stmt = this.conexion.prepareStatement("SELECT * FROM clientes");
        
          lista= new ArrayList();
          ResultSet ResultadosClientes = stmt.executeQuery();
          
          //obtener todos los resultados
          while(ResultadosClientes.next()){
              
             ModeloClientes ClientesRegistrados = new ModeloClientes();
             
             ClientesRegistrados.setId(ResultadosClientes.getInt("id"));
             ClientesRegistrados.setNombre(ResultadosClientes.getString("nombre"));
             ClientesRegistrados.setApellidoPaterno(ResultadosClientes.getString("apellidopaterno"));
             ClientesRegistrados.setApellidoMaterno(ResultadosClientes.getString("apellidomaterno"));
             ClientesRegistrados.setTelefono(ResultadosClientes.getString("telefono"));
             ClientesRegistrados.setDireccion(ResultadosClientes.getString("direccion"));
             ClientesRegistrados.setDescuento(ResultadosClientes.getString("descuento"));
             lista.add(ClientesRegistrados);
             
          }//fin del while
         ResultadosClientes.close();
         stmt.close();
      }catch(Exception e){
      
      }finally{
            try {
                CerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ClientesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      return lista;
    }

    @Override
    public ModeloClientes getUserById(int userId) throws Exception {
       ModeloClientes ClientesRegistrados = new ModeloClientes();
      try{
           ConectarBDcloud();
          PreparedStatement stmt = this.conexion.prepareStatement("SELECT * FROM clientes WHERE id = ? LIMIT 1;");
          stmt.setInt(1,userId);

          ResultSet ResultadosClientes = stmt.executeQuery();
          //obtener todos los resultados
          while(ResultadosClientes.next()){
              
            
             ClientesRegistrados.setId(ResultadosClientes.getInt("id"));
             ClientesRegistrados.setNombre(ResultadosClientes.getString("nombre"));
             ClientesRegistrados.setApellidoPaterno(ResultadosClientes.getString("apellidopaterno"));
             ClientesRegistrados.setApellidoMaterno(ResultadosClientes.getString("apellidomaterno"));
             ClientesRegistrados.setTelefono(ResultadosClientes.getString("telefono"));
             ClientesRegistrados.setDireccion(ResultadosClientes.getString("direccion"));
             ClientesRegistrados.setDescuento(ResultadosClientes.getString("descuento"));
          }//fin del while
          
         ResultadosClientes.close();
         stmt.close();
         
      }catch(Exception e){
      
      }finally{
            try {
                CerrarConexion();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
      }
      return ClientesRegistrados;
    }
    
}
