
package Modelo;

import Conexion.ConexionSQL;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class ConsultasSolicitud extends ConexionSQL{
    
    public static DefaultTableModel listar(){
        DefaultTableModel modelo = new DefaultTableModel(){
        @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        //no se edite
        modelo.addColumn("id");
        modelo.addColumn("id_solicitante");
        modelo.addColumn("id_unidad");
        modelo.addColumn("motivo_solicitud");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Fecha");
        
        Connection con=conectar();
        PreparedStatement ps=null;
        String sql="SELECT * FROM solicitud";
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
    
    public boolean registrarSolicitud(SolicitudSangre sol){
        PreparedStatement ps = null;
        Connection con=conectar();
        String sql = ("INSERT INTO solicitud(id_solicitante,id_unidad,motivo_solicitud, unidades_sanguineas,fecha_solicitud) VALUES (?,?,?,?,?)");//sentencia_guardar
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,sol.getId_solicitante());
            ps.setString(2,sol.getId_unidad());
            ps.setString(3,sol.getMotivo());
            ps.setInt(4, sol.getNum());
            ps.setDate(5, (Date) sol.getFecha()); 
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
    
    public boolean eliminarSolicitud(int codSolicitud){
        PreparedStatement ps=null;
        Connection con=conectar();
        String sql = ("DELETE FROM solicitud WHERE id_solicitud=? ");//sentencia_eliminar
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,codSolicitud); //
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
