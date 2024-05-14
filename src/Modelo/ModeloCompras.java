
package Modelo;

/**
 *
 * @author arman
 */
public class ModeloCompras {
    private int id;
    private String proveedor;
    private String fecha;
    private double subtotal;
    private double total;

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
    private String vendedor;

  
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

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setTotal(double total) {
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

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotal() {
        return total;
    }
 

   
    
    
}
