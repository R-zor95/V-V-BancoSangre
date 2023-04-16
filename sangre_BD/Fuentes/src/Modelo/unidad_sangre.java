
package Modelo;


public class unidad_sangre {
    private String id_unidad;
    private int id_sangre;
    private int cantidad;

    public unidad_sangre() {
    }

    public unidad_sangre(String id_unidad, int id_sangre, int cantidad) {
        this.id_unidad = id_unidad;
        this.id_sangre = id_sangre;
        this.cantidad = cantidad;
    }

    public String getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(String id_unidad) {
        this.id_unidad = id_unidad;
    }

    public int getId_sangre() {
        return id_sangre;
    }

    public void setId_sangre(int id_sangre) {
        this.id_sangre = id_sangre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "unidad_sangre{" + "id_unidad=" + id_unidad + ", id_sangre=" + id_sangre + ", cantidad=" + cantidad + '}';
    }

    
}


