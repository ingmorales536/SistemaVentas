
package interfaces;

import Modelo.ModeloProductos;
import java.util.List;

public interface InterfaceProductos {
    
    public void Registrar(ModeloProductos producto);
    public void Modificar(ModeloProductos producto);
    public void Eliminar(int UserId);
    public List<ModeloProductos> listar(String name) throws Exception;
    public ModeloProductos getUserById(int userId) throws Exception;
    
}
