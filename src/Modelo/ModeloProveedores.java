
package Modelo;


public class ModeloProveedores {
    private int id;
    private String Nombre;
    private String direccion;
    private String telefono;
    
    //Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }//Fin del ultimo setter
    
    //getter

    public int getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }//Fin del ultimo getter
    
    
    
}
