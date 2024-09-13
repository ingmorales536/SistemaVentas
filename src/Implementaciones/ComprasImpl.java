/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import ConexionDB.Conexion;
import Modelo.ModeloCompras;
import interfaces.InterfaceCompras;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;




public class ComprasImpl  extends Conexion implements  InterfaceCompras{

    @Override
    public void Registrar(ModeloCompras producto) {
       
    }

    @Override
    public void Modificar(ModeloCompras producto) {
           try{
            ConectarBDcloud();
            PreparedStatement stmt = this.conexion.prepareStatement("UPDATE compras SET fecha = ?  ,  proveedor = ? , articulos = ? , total = ? , vendedor = ? WHERE id = ?");
          
            stmt.setString(1,producto.getFecha());
            stmt.setString(2,producto.getProveedor());
            stmt.setString(3,producto.getArticulos());
            stmt.setFloat(4,producto.getTotal());
            stmt.setString(5,producto.getVendedor());
            stmt.setInt(6, producto.getId());
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
    public void Eliminar(int UserId) {
         try{   
             ConectarBDcloud();
            PreparedStatement stmt = this.conexion.prepareStatement("DELETE FROM compras WHERE id = ?");
            stmt.setInt(1,UserId);
            stmt.execute();
            stmt.close();  
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Erro al eliminar Compra", 0);
             System.out.println("Error en eliminar compra: "+e);
        }finally{
            try {
                CerrarConexion();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al Cerrar la conexion BD", "Error en DB-Clientes", 0);
            }
        }
    }

    @Override
    public List<ModeloCompras> listar(String name) throws Exception {
       List<ModeloCompras> lista = null;
      try{
          ConectarBDcloud();
          PreparedStatement stmt = this.conexion.prepareStatement("SELECT * FROM compras");
        
          lista= new ArrayList();
          ResultSet ResultadosCompras = stmt.executeQuery();
          
          //obtener todos los resultados
          while(ResultadosCompras.next()){
              
             ModeloCompras ComprasRegistradas = new ModeloCompras();
             
             ComprasRegistradas.setId(ResultadosCompras.getInt("id"));
             ComprasRegistradas.setFecha(ResultadosCompras.getString("fecha"));
             ComprasRegistradas.setProveedor(ResultadosCompras.getString("proveedor"));
             ComprasRegistradas.setTotal(ResultadosCompras.getFloat("total"));
             ComprasRegistradas.setVendedor(ResultadosCompras.getString("vendedor"));
             lista.add(ComprasRegistradas);
             
          }//fin del while
         ResultadosCompras.close();
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
        
        
        
    }//FIN DE LISTAR

    @Override
    public ModeloCompras getUserById(int userId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
