
package Modelo;


public class Sangre {
    private int id_s;
    private String abo;
    private String rh;

    public Sangre() {
    }

    public Sangre(int id_s, String abo, String rh) {
        this.id_s = id_s;
        this.abo = abo;
        this.rh = rh;
    }

    public int getId_s() {
        return id_s;
    }

    public void setId_s(int id_s) {
        this.id_s = id_s;
    }

    public String getAbo() {
        return abo;
    }

    public void setAbo(String abo) {
        this.abo = abo;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    @Override
    public String toString() {
        return "Sangre{" + "id_s=" + id_s + ", abo=" + abo + ", rh=" + rh + '}';
    }
    
    
}
