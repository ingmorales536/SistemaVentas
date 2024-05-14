
package interfaces;

import Modelo.ModeloCompras;
import java.util.List;

/**
 *
 * @author arman
 */
public interface InterfaceCompras {
    public void Registrar(ModeloCompras producto);
    public void Modificar(ModeloCompras producto);
    public void Eliminar(int UserId);
    public List<ModeloCompras> listar(String name) throws Exception;
    public ModeloCompras getUserById(int userId) throws Exception;
    
}
