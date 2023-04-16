
package Modelo;

import Conexion.ConexionSQL;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class ConsultasUnidadS extends ConexionSQL{
    
    //Metodo que retorna una tabla con los datos de la Base de datos
    public static DefaultTableModel listar(){
        DefaultTableModel modelo = new DefaultTableModel(){
        @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        modelo.addColumn("id_Unidad");
        modelo.addColumn("id_Sangre");
        modelo.addColumn("Num. Unidades");
        Connection con=conectar();
        PreparedStatement ps=null;
        String sql="SELECT * FROM unidad_sanguinea";
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
                modelo.addRow(filas);
            }
            
        } catch (SQLException e) {
            System.out.println("Error de listado: "+e.getMessage());
        }finally{
            ps=null;
            rs=null;
            
        }
        return modelo;
    }

    
    //Metodo para saber cuantas unidades de sangre hay disponible
    
    public int verificaVolumen(String idUni){//id de la sangre
        int busqueda_vol=-100;
        PreparedStatement ps=null;
        ResultSet rs;
        Connection conexion = null;
        try {
            conexion = ConexionSQL.conectar();
            String sentencia_buscar = ("SELECT cantidad_unidades_sanguineas FROM unidad_sanguinea WHERE id_unidad ='"+idUni+"'");
            ps = conexion.prepareStatement(sentencia_buscar);
            rs = ps.executeQuery();
            //validadmos y traemos el resultado
            if(rs.next()){
                busqueda_vol = rs.getInt("cantidad_unidades_sanguineas");

            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_vol;
    }
    
    
    //Metodo para saber el id de la unidad a partir del id de sangre
    
    public String idUnidad(int idSangre){//id de la sangre
        String busqueda_vol="NULL";
        PreparedStatement ps=null;
        ResultSet rs;
        Connection conexion = null;
        try {
            conexion = ConexionSQL.conectar();
            String sentencia_buscar = ("SELECT id_unidad FROM unidad_sanguinea WHERE id_sangre ='"+idSangre+"'");
            ps = conexion.prepareStatement(sentencia_buscar);
            rs = ps.executeQuery();
            //validadmos y traemos el resultado
            if(rs.next()){
                busqueda_vol = rs.getString("id_unidad");

            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_vol;
    }
    
    
    //Metodo para añadir unidades
    public void añadir(String idUni, int cantAdicional){//persona/ id de la familia a colocar
        Connection conexion=conectar();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql = "UPDATE unidad_sanguinea set cantidad_unidades_sanguineas=? WHERE id_unidad=?";
            ps = conexion.prepareStatement(sql);
            float nuevoValor= verificaVolumen(idUni)+cantAdicional;
            ps.setFloat(1, nuevoValor);
            
            ps.setString(2, idUni);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //Metodo para disminuir unidades
    public void disminuir(String idUni, int cantMenos){//persona/ id de la familia a colocar
        Connection conexion=conectar();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql = "UPDATE unidad_sanguinea set cantidad_unidades_sanguineas=? WHERE id_unidad=?";
            ps = conexion.prepareStatement(sql);
            float nuevoValor= verificaVolumen(idUni)-cantMenos;
            ps.setFloat(1, nuevoValor);
            
            ps.setString(2, idUni);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    /*
    //metodo que trae el codigo de la sangre a partir de su tipo y RH
    public int idSangre(String grupo,String rh){//id de la sangre
        int busqueda_id=-100;//en caso dee error
        PreparedStatement ps=null;
        ResultSet rs;
        Connection conexion = null;
        try {
            conexion = ConexionSQL.conectar();
            String sentencia_buscar = ("SELECT id_sangre FROM sangre WHERE grupo_sangre ='"+grupo+"' AND rh_sangre = '" + rh + "'");
            ps = conexion.prepareStatement(sentencia_buscar);
            rs = ps.executeQuery();
            //validadmos y traemos el resultado
            if(rs.next()){
                busqueda_id = rs.getInt("id_sangre");

            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_id;
    }
    */
}
