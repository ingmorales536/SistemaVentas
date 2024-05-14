
package interfaces;

import Modelo.ModeloUsuarios;
import java.util.List;


public interface InterfaceUsuarios {
    public void Registrar(ModeloUsuarios usuario);
    public void Modificar(ModeloUsuarios usuario);
    public void Eliminar(int usuario);
    public List<ModeloUsuarios> listar(String name) throws Exception;
       public ModeloUsuarios getUserById(int userId) throws Exception;
}
