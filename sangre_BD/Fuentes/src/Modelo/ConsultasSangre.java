
package Modelo;

import Conexion.ConexionSQL;
import java.sql.*;


public class ConsultasSangre extends ConexionSQL{
    
    //conocer el id de la sangre segun su abo y rh
   public int idSangre(String grupo,String rh){//id de la sangre
        int busqueda_id=-100;//en caso dee error
        PreparedStatement ps=null;
        ResultSet rs;
        Connection conexion = null;
        try {
            conexion = ConexionSQL.conectar();
            String sentencia_buscar = ("SELECT id_sangre FROM sangre WHERE grupo_abo ='"+grupo+"' AND factor_rh = '" + rh + "'");
            ps = conexion.prepareStatement(sentencia_buscar);
            rs = ps.executeQuery();
            if(rs.next()){
                busqueda_id = rs.getInt("id_sangre");

            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_id;
    }
    
}
