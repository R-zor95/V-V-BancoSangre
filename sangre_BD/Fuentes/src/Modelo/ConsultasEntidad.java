
package Modelo;

import Conexion.ConexionSQL;
import static Conexion.ConexionSQL.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ConsultasEntidad extends ConexionSQL{
    public static DefaultTableModel listar(){
        
        DefaultTableModel modelo = new DefaultTableModel(){
        @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        modelo.addColumn("RUC");
        modelo.addColumn("Razon Social");
        
        Connection con=conectar();
        PreparedStatement ps=null;
        String sql="SELECT * FROM entidad";
        ResultSet rs;
        
        try {
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            while (rs.next()) {//llenar cada fila
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);//llenamos filas
            }
            
        } catch (SQLException e) {
            System.out.println("Error de listado: "+e.getMessage());
        }finally{
            ps=null;
            rs=null;
            
        }
        return modelo;
    }
    
    public boolean registrarEntidad(Entidad entidad){
        PreparedStatement ps=null;
        Connection con=conectar();
        String sql = ("INSERT INTO entidad(nombre_entidad, ruc, razon_social) VALUES (?,?,?)");//sentencia_guardar
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,entidad.getNombre_e());
            ps.setString(2,entidad.getRUC());//timestamp
            ps.setString(3,entidad.getRazon_social());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminarEntidad(int codEntidad){
        PreparedStatement ps=null;
        Connection con=conectar();
        String sql = ("DELETE FROM entidad WHERE id_entidad=? ");//sentencia_eliminar
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,codEntidad); //
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    public void comboEntidades(DefaultComboBoxModel entidades){
        PreparedStatement ps=null;
        Connection con=conectar();
        ResultSet rs;
        String sql = ("SELECT nombre_entidad FROM entidad");
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                entidades.addElement(rs.getString("nombre_entidad"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    
    //metodo que trae el codigo de la entidad a partir de su nombre
    public int idEntidad(String nombre_e){//id de la sangre
        int busqueda_id=-100;//en caso dee error
        PreparedStatement ps=null;
        ResultSet rs;
        Connection conexion = null;
        try {
            conexion = ConexionSQL.conectar();
            String sentencia_buscar = ("SELECT id_entidad FROM entidad WHERE nombre_entidad ='"+nombre_e+"'");
            ps = conexion.prepareStatement(sentencia_buscar);
            rs = ps.executeQuery();
            //validadmos y traemos el resultado
            if(rs.next()){
                busqueda_id = rs.getInt("id_entidad");

            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_id;
    }
}
