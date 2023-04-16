
package Modelo;


public class Solicitante {
    private int id_solicitante;
    private int id_entidad;
    private String nombre;
    private String apellido_materno;
    private String apellido_paterno;
    private String telefono;
    private String correo;

    public Solicitante() {
    }

    public Solicitante(int id_entidad, String nombre, String apellido_paterno, String apellido_materno,  String telefono, String correo) {
        this.id_entidad = id_entidad;
        this.nombre = nombre;
        this.apellido_materno = apellido_materno;
        this.apellido_paterno = apellido_paterno;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId_solicitante() {
        return id_solicitante;
    }

    public void setId_solicitante(int id_solicitante) {
        this.id_solicitante = id_solicitante;
    }

    

    public int getId_entidad() {
        return id_entidad;
    }

    public void setId_entidad(int id_entidad) {
        this.id_entidad = id_entidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    

    

    @Override
    public String toString() {
        return nombre ;
    }
    
    
}
