
package Modelo;

import java.util.Date;


public class SolicitudSangre {
    private int id_so;
    private String id_unidad;
    private int id_solicitante;
    private String motivo;
    private int num;
    private Date fecha;
    
    public SolicitudSangre() {
    }

    public SolicitudSangre(String id_unidad, int id_solicitante, String motivo, int num, Date fecha) {
        this.id_unidad = id_unidad;
        this.id_solicitante = id_solicitante;
        this.motivo = motivo;
        this.num = num;
        this.fecha = fecha;
    }

    

    public int getId_so() {
        return id_so;
    }

    public void setId_so(int id_so) {
        this.id_so = id_so;
    }

    public int getId_solicitante() {
        return id_solicitante;
    }

    public void setId_solicitante(int id_solicitante) {
        this.id_solicitante = id_solicitante;
    }

    

    public String getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(String id_unidad) {
        this.id_unidad = id_unidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
        return "SolicitudSangre{" + "id_so=" + id_so + ", id_unidad=" + id_unidad + ", id_solicitante=" + id_solicitante + ", motivo=" + motivo + ", num=" + num + ", fecha=" + fecha + '}';
    }

    

    
    

    
    

}
