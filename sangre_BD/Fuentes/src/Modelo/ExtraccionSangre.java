
package Modelo;

import java.util.Date;


public class ExtraccionSangre {
    private int id_ex;
    private String id_unidad;
    private int id_donante;
    private int num;
    private Date fecha;
    
    public ExtraccionSangre() {
    }
    
    
    public ExtraccionSangre(String id_unidad, int id_donante, int num, Date fecha) {
        this.id_unidad = id_unidad;
        this.id_donante = id_donante;
        this.num = num;
        this.fecha = fecha;
    }

    public int getId_ex() {
        return id_ex;
    }

    public void setId_ex(int id_ex) {
        this.id_ex = id_ex;
    }

    public String getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(String id_unidad) {
        this.id_unidad = id_unidad;
    }

    public int getId_donante() {
        return id_donante;
    }

    public void setId_donante(int id_donante) {
        this.id_donante = id_donante;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ExtraccionSangre{" + "id_ex=" + id_ex + ", id_unidad=" + id_unidad + ", id_donante=" + id_donante + ", num=" + num + ", fecha=" + fecha + '}';
    }

    

    
    

}
