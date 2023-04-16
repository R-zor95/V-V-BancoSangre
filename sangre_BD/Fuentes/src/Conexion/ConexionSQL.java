
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionSQL {
    
    public  static Connection conectar(){
        String conexion="jdbc:sqlserver://localhost:1433;"
                + "database=BancoSangre;"
                + "user=sa;"
                + "password=123;";
        try {
            Connection con=DriverManager.getConnection(conexion);
            System.out.println("Conexion exitosa");
            return con;
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return null;
        }
 
        
    }
    
}
