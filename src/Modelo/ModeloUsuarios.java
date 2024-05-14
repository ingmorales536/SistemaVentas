
package Modelo;


public class ModeloUsuarios {
   private int id;
   private String Nombre;
   private String Usuario;
   private String Password;
   private String Permiso;
   
   
   
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setUsuario(String ApellidoPaterno) {
        this.Usuario = ApellidoPaterno;
    }

    public void setPassword(String ApellidoMaterno) {
        this.Password = ApellidoMaterno;
    }
    
    public void setPermiso(String Permiso) {
        this.Permiso = Permiso;
    }
        //Fin de los setters
        
        //Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public String getPermiso() {
        return Permiso;
    }
    
    
    
}
