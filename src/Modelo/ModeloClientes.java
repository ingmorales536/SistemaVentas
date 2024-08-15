
package Modelo;


public class ModeloClientes {
   private int id;
   private String Nombre;
   private String ApellidoPaterno;
   private String ApellidoMaterno;
   private String telefono;
   private String direccion;
   private String descuento;

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

   
   //setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }//fin del ultimo setter
    
    
    //getter
    public int getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }//Fin del ultimo getter
    
    
}
