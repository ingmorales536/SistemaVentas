
package interfaces;

import Modelo.ModeloClientes;
import java.util.List;


public interface InterfaceClientes {
    
    public void Registrar(ModeloClientes cliente);
    public void Modificar(ModeloClientes cliente);
    public void Eliminar(int userId);
    public List<ModeloClientes> listar(String name) throws Exception;
    public ModeloClientes getUserById(int userId) throws Exception;
    
    
    
}
