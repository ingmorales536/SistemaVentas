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



/**
 *
 * @author arman
 */
public class ComprasImpl  extends Conexion implements  InterfaceCompras{

    @Override
    public void Registrar(ModeloCompras producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Modificar(ModeloCompras producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Eliminar(int UserId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ModeloCompras> listar(String name) throws Exception {
       List<ModeloCompras> lista = null;
      try{
          Conectar();
          PreparedStatement stmt = this.conexion.prepareStatement("SELECT * FROM compras");
        
          lista= new ArrayList();
          ResultSet ResultadosCompras = stmt.executeQuery();
          
          //obtener todos los resultados
          while(ResultadosCompras.next()){
              
             ModeloCompras ComprasRegistradas = new ModeloCompras();
             
             ComprasRegistradas.setId(ResultadosCompras.getInt("id"));
             ComprasRegistradas.setFecha(ResultadosCompras.getString("fecha"));
             ComprasRegistradas.setProveedor(ResultadosCompras.getString("proveedor"));
             ComprasRegistradas.setTotal(ResultadosCompras.getDouble("total"));
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
