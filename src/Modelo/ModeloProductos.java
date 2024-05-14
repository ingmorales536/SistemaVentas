
package Modelo;


public class ModeloProductos {
    private int id;
    private String Codigo;
    private String Descripcion;
    private double PrecioUnitario;
    private double PrecioVenta;
    private int Cantidad;
    
    //Setter

    public void setId(int id) {
        this.id = id;
    }
    
    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setPrecioUnitario(double PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public void setPrecioVenta(double PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }//Fin del ultimo setter
    
    //Getter

    public int getId() {
        return id;
    }
    
    public String getCodigo() {
       return Codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public double getPrecioUnitario() {
        return PrecioUnitario;
    }

    public double getPrecioVenta() {
        return PrecioVenta;
    }

    public int getCantidad() {
        return Cantidad;
    }//Fin del ultimo getter
    
    
    
}
