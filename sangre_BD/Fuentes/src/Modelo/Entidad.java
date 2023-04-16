
package Modelo;


public class Entidad {
    private int id_entidad;
    private String nombre_e;
    private String RUC;
    private String razon_social;

    public Entidad() {
    }

    public Entidad(String nombre_e, String RUC, String razon_social) {
        this.nombre_e = nombre_e;
        this.RUC = RUC;
        this.razon_social = razon_social;
    }

    public int getId_entidad() {
        return id_entidad;
    }

    public void setId_entidad(int id_entidad) {
        this.id_entidad = id_entidad;
    }

    public String getNombre_e() {
        return nombre_e;
    }

    public void setNombre_e(String nombre_e) {
        this.nombre_e = nombre_e;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    @Override
    public String toString() {
        return "Entidad{" + "id_entidad=" + id_entidad + ", nombre_e=" + nombre_e + ", RUC=" + RUC + ", razon_social=" + razon_social + '}';
    }
    
    
    
}
