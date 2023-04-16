
package Modelo;

import Conexion.ConexionSQL;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


public class ConsultasDonante extends ConexionSQL{
    
    public static DefaultTableModel listar(){
        
        DefaultTableModel modelo = new DefaultTableModel(){
        @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        modelo.addColumn("id");
        modelo.addColumn("Empresa");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido1");
        modelo.addColumn("Apellido2");
        modelo.addColumn("Telefono");
        modelo.addColumn("Correo");
        
        Connection con=conectar();
        PreparedStatement ps=null;
        String sql="SELECT * FROM donante";
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
    
    public boolean registrarDonante(Donante donante){
        PreparedStatement ps=null;
        Connection con=conectar();
        String sql = ("INSERT INTO donante(id_entidad,nombre_donante,apellido_paterno_donante,apellido_materno_donante,telefono_donante,correo_donante) VALUES (?,?,?,?,?,?)");//sentencia_guardar
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,donante.getId_entidad());
            ps.setString(2,donante.getNombre());//timestamp
            ps.setString(3,donante.getApellido_paterno());
            ps.setString(4,donante.getApellido_materno()); 
            ps.setString(5,donante.getTelefono());
            ps.setString(6,donante.getCorreo()); 
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
    
    public boolean eliminarDonante(int codDonante){
        PreparedStatement ps=null;
        Connection con=conectar();
        String sql = ("DELETE FROM donante WHERE id_donante=? ");//sentencia_eliminar
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,codDonante); //
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
    
    public void comboDonante(DefaultComboBoxModel donantes){
        PreparedStatement ps=null;
        Connection con=conectar();
        ResultSet rs;
        String sql = ("SELECT nombre_donante FROM donante");
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                donantes.addElement(rs.getString("nombre_donante"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    //Metodo para editar datos de un donante
    /*
    public void editaDonate(int idDon, Donante donante){
        Connection conexion=conectar();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql = "UPDATE donante set nombre_d=?,fecha_naci=?,dni_d=?,edad_d=?,telf_d=?,correo_d=? WHERE id_donante=?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, donante.getNombre());
            ps.setString(2, donante.getFechaNac());
            ps.setString(3, donante.getDNI());
            ps.setInt(4, donante.getEdad());
            ps.setString(5, donante.getTelefono());
            ps.setString(6, donante.getCorreo());
            ps.setInt(7, idDon);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //Método para buscar cliente
    public Donante buscar(int id){
        Connection con=conectar();
        PreparedStatement ps=null;
        ResultSet rs=null;
        Donante d = new Donante();
        String sql = "select * from donante where id_donante=?";
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                d.setNombre(rs.getString(2));
                d.setFechaNac(rs.getString(3));
                d.setDNI(rs.getString(4));
                d.setEdad(rs.getInt(5));
                d.setTelefono(rs.getString(6));
                d.setCorreo(rs.getString(7));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return d;
    }
/*/
    
    //metodo que trae el codigo del donante a partir de su nombre
    public int idDonante(String nombre_d){//id de la sangre
        int busqueda_id=-100;//en caso dee error
        PreparedStatement ps=null;
        ResultSet rs;
        Connection conexion = null;
        try {
            conexion = ConexionSQL.conectar();
            String sentencia_buscar = ("SELECT id_donante FROM donante WHERE nombre_donante ='"+nombre_d+"'");
            ps = conexion.prepareStatement(sentencia_buscar);
            rs = ps.executeQuery();
            //validadmos y traemos el resultado
            if(rs.next()){
                busqueda_id = rs.getInt("id_donante");

            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_id;
    }
    
}
