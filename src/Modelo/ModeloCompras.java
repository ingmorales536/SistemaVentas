
package Modelo;

/**
 *
 * @author arman
 */
public class ModeloCompras {
    private int id;
    private String proveedor;
    private String fecha;
    private String vendedor;
    private float total;

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
  
    
    
    

    public String getArticulos() {
        return articulos;
    }

    public void setArticulos(String articulos) {
        this.articulos = articulos;
    }
    private String articulos;

    public String getVendedor() {
        return vendedor;
    }

  
  
    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

  
    public void setTotal(float total) {
        this.total = total;
    }
    
    
    //Getters
    public int getId() {
        return id;
    }

    public String getProveedor() {
        return proveedor;
    }

    public String getFecha() {
        return fecha;
    }

   

    public float getTotal() {
        return total;
    }
 

   
    
    
}
