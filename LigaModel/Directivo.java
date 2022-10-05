package LigaModel;

import java.util.Date;

public class Directivo extends Persona {
    public enum Cartera{PRESIDENTE, VICEPRESIDENTE, SECRETARIO, TESORERO, VOCAL};
    private Cartera puesto;
    private Date fecha_inic;
    private Date feha_fin;

    public Directivo(String nombre, String apellido, String ci, String telf, String email, String direccion, byte genero, Cartera puesto, Date fecha_inic, Date feha_fin) {
        super(nombre, apellido, ci, telf, email, direccion, genero);
        this.puesto = puesto;
        this.fecha_inic = fecha_inic;
        this.feha_fin = feha_fin;
    }

    public Cartera getPuesto() {
        return puesto;
    }

    public void setPuesto(Cartera puesto) {
        this.puesto = puesto;
    }

    public Date getFecha_inic() {
        return fecha_inic;
    }

    public void setFecha_inic(Date fecha_inic) {
        this.fecha_inic = fecha_inic;
    }

    public Date getFeha_fin() {
        return feha_fin;
    }

    public void setFeha_fin(Date feha_fin) {
        this.feha_fin = feha_fin;
    }

    @Override
    public String toString() {
        return "Directivo{" +
                "puesto=" + puesto +
                ", fecha_inic=" + fecha_inic +
                ", feha_fin=" + feha_fin +
                '}';
    }
}
