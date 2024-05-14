
package interfaces;

import Modelo.ModeloProveedores;
import java.util.List;


public interface InterfaceProveedores {
    public void Registrar(ModeloProveedores proveedor);
    public void Modificar(ModeloProveedores proveedor);
    public void Eliminar(int UserId);
    public List<ModeloProveedores> listar(String name) throws Exception;
    public ModeloProveedores getUserById(int userId) throws Exception;
}
