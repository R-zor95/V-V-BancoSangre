
package Main;

import Conexion.ConexionSQL;
import Controlador.ControladorSistema;
import Datos.Repositorio;
import Modelo.Usuario;
import Vista.frmSistema;

public class main {
    public static void main(String[] args) {
        

        
        Repositorio.usuarios.agregar(new Usuario("user", "123"));
        Repositorio.usuarios.agregar(new Usuario("a", "123"));
        ConexionSQL.conectar();
        ControladorSistema controlador = new ControladorSistema( Repositorio.usuarios, new frmSistema() );
        controlador.iniciar();
    }
}
