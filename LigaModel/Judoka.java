package LigaModel;

import java.util.Date;


public class Judoka extends Persona {
    public enum Kyu{BLANCO, AMARILLO, NARANJA, VERDE, AZUL, CAFE, NEGRO};
    private String categoria;
    private double peso_actual;
    private Date fecha_nac;
    private Kyu grado;
    private Date fecha_ult_grado;

    public Judoka(String nombre, String apellido, String ci, String telf, String email, String direccion, byte genero, String categoria, double peso_actual, Date fecha_nac, Kyu grado, Date fecha_ult_grado) {
        super(nombre, apellido, ci, telf, email, direccion, genero);
        this.categoria = categoria;
        this.peso_actual = peso_actual;
        this.fecha_nac = fecha_nac;
        this.grado = grado;
        this.fecha_ult_grado = fecha_ult_grado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPeso_actual() {
        return peso_actual;
    }

    public void setPeso_actual(double peso_actual) {
        this.peso_actual = peso_actual;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public Kyu getGrado() {
        return grado;
    }

    public void setGrado(Kyu grado) {
        this.grado = grado;
    }

    public Date getFecha_ult_grado() {
        return fecha_ult_grado;
    }

    public void setFecha_ult_grado(Date fecha_ult_grado) {
        this.fecha_ult_grado = fecha_ult_grado;
    }

    @Override
    public String toString() {
        return "Judoka{" +
                "categoria='" + categoria + '\'' +
                ", peso_actual=" + peso_actual +
                ", fecha_nac=" + fecha_nac +
                ", grado=" + grado +
                ", fecha_ult_grado=" + fecha_ult_grado +
                '}';
    }
}
