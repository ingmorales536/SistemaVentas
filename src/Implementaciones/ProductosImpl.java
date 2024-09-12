
package Implementaciones;

import ConexionDB.Conexion;
import Modelo.ModeloClientes;
import Modelo.ModeloProductos;
import interfaces.InterfaceProductos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProductosImpl  extends Conexion implements  InterfaceProductos {

    @Override
    public void Registrar(ModeloProductos producto) {
         try{
            
            ConectarBDcloud();
            PreparedStatement stmt = this.conexion.prepareStatement("INSERT INTO productos(codigo,descripcion,preciounitario,precioventa,cantidad) VALUES (?, ?, ?, ?, ?)");
          
            stmt.setString(1,producto.getCodigo());
            stmt.setString(2,producto.getDescripcion());
            stmt.setDouble(3,producto.getPrecioUnitario());
            stmt.setDouble(4,producto.getPrecioVenta());
            stmt.setInt(5,producto.getCantidad());
            stmt.execute();
            stmt.close();  

                        JOptionPane.showMessageDialog(null,"<html><body><h3 style='color:green;'>Registro Exitoso</h3>" + "<p>El registro se ha completado exitosamente.</p></body></html>","Éxito",
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
    public void Modificar(ModeloProductos producto) {
        try{
            ConectarBDcloud();
            PreparedStatement stmt = this.conexion.prepareStatement("UPDATE productos SET codigo = ? , descripcion = ? , preciounitario = ? , precioventa = ?, cantidad = ? WHERE id = ?");
          
            stmt.setString(1,producto.getCodigo());
            stmt.setString(2,producto.getDescripcion());
            stmt.setDouble(3,producto.getPrecioUnitario());
            stmt.setDouble(4,producto.getPrecioVenta());
            stmt.setInt(5,producto.getCantidad());
            stmt.setInt(6, producto.getId());
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
    public void Eliminar(int UserId) {
          try{   
            ConectarBDcloud();
            PreparedStatement stmt = this.conexion.prepareStatement("DELETE FROM productos WHERE id = ?");
            stmt.setInt(1,UserId);
            stmt.execute();
            stmt.close();  
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Erro al eliminar Producto", 0);
        }finally{
            try {
                CerrarConexion();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al Cerrar la conexion BD", "Error en DB-Clientes", 0);
            }
        }
    }
    
    @Override
    public List<ModeloProductos> listar(String name) throws Exception {
              List<ModeloProductos> lista = null;
      try{
          ConectarBDcloud();
          PreparedStatement stmt = this.conexion.prepareStatement("SELECT * FROM productos");
        
          lista= new ArrayList();
          ResultSet ResultadosProductos = stmt.executeQuery();
          
          //obtener todos los resultados
          while(ResultadosProductos.next()){
              
             ModeloProductos ProductosRegistrados = new ModeloProductos();
             
             ProductosRegistrados.setId(ResultadosProductos.getInt("id"));
             ProductosRegistrados.setCodigo(ResultadosProductos.getString("codigo"));
             ProductosRegistrados.setDescripcion(ResultadosProductos.getString("descripcion"));
             ProductosRegistrados.setPrecioUnitario(ResultadosProductos.getDouble("preciounitario"));
             ProductosRegistrados.setPrecioVenta(ResultadosProductos.getDouble("precioventa"));
             ProductosRegistrados.setCantidad(ResultadosProductos.getInt("cantidad"));
             lista.add(ProductosRegistrados);
             
          }//fin del while
         ResultadosProductos.close();
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
    public ModeloProductos getUserById(int userId) throws Exception {
      ModeloProductos ProductosRegistrados = new ModeloProductos();
      try{
          ConectarBDcloud();
          PreparedStatement stmt = this.conexion.prepareStatement("SELECT * FROM productos WHERE id = ? LIMIT 1;");
          stmt.setInt(1,userId);

          ResultSet ResultadosProductos = stmt.executeQuery();
          //obtener todos los resultados
          while(ResultadosProductos.next()){
              
            
             ProductosRegistrados.setId(ResultadosProductos.getInt("id"));
             ProductosRegistrados.setCodigo(ResultadosProductos.getString("codigo"));
             ProductosRegistrados.setDescripcion(ResultadosProductos.getString("descripcion"));
             ProductosRegistrados.setPrecioUnitario(ResultadosProductos.getDouble("preciounitario"));
             ProductosRegistrados.setPrecioVenta(ResultadosProductos.getDouble("precioventa"));
             ProductosRegistrados.setCantidad(ResultadosProductos.getInt("cantidad"));
          }//fin del while
          
         ResultadosProductos.close();
         stmt.close();
         
      }catch(Exception e){
      
      }finally{
            try {
                CerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ClientesImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      return ProductosRegistrados;
    }
    
}
