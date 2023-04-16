
package Modelo;

import Conexion.ConexionSQL;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class ConsultasExtraccion extends ConexionSQL{
    
    public static DefaultTableModel listar(){
        DefaultTableModel modelo = new DefaultTableModel(){
        @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        modelo.addColumn("id");
        modelo.addColumn("id_unidad");
        modelo.addColumn("id_donante");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Fecha");
        
        Connection con=conectar();
        PreparedStatement ps=null;
        String sql="SELECT * FROM extraccion";
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
    
    public boolean registrarExtraccion(ExtraccionSangre ext){
        PreparedStatement ps = null;
        Connection con=conectar();
        String sql = ("INSERT INTO extraccion(id_unidad,id_donante, unidad_sanguinea_extraccion,fecha_extraccion) VALUES (?,?,?,?)");//sentencia_guardar
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,ext.getId_unidad());
            ps.setInt(2,ext.getId_donante());
            ps.setInt(3, ext.getNum());
            ps.setDate(4, (Date) ext.getFecha()); 
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
    
    public boolean eliminarExtraccion(int codExtraccion){
        PreparedStatement ps=null;
        Connection con=conectar();
        String sql = ("DELETE FROM extraccion WHERE id_extraccion=? ");//sentencia_eliminar
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,codExtraccion); //
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
    
    

    
}
