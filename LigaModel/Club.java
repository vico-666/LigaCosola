package LigaModel;

import PrograAvan.ArbolRB;
import PrograAvan.Lineal.Lista;


public class Club {
    private Integer id;
    private String nombre;
    private String personeria;
    private Lista<Directivo> directivos;
    private ArbolRB<Integer, Judoka> judokas;
    private Persona entrenador;
    private String ubicacion;
    private String telf;
    private String wapp;
    private String email;
    private String url;

    public Club(String nombre, String personeria, Lista<Directivo> directivos, ArbolRB<Integer, Judoka> judokas, Persona entrenador, String ubicacion, String telf, String wapp, String email, String url) {
        this.nombre = nombre;
        this.personeria = personeria;
        this.directivos = directivos;
        this.judokas = judokas;
        this.entrenador = entrenador;
        this.ubicacion = ubicacion;
        this.telf = telf;
        this.wapp = wapp;
        this.email = email;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPersoneria() {
        return personeria;
    }

    public void setPersoneria(String personeria) {
        this.personeria = personeria;
    }

    public Lista<Directivo> getDirectivos() {
        return directivos;
    }

    public void setDirectivos(Lista<Directivo> directivos) {
        this.directivos = directivos;
    }

    public ArbolRB<Integer, Judoka> getJudokas() {
        return judokas;
    }

    public void setJudokas(ArbolRB<Integer, Judoka> judokas) {
        this.judokas = judokas;
    }

    public Persona getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Persona entrenador) {
        this.entrenador = entrenador;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public String getWapp() {
        return wapp;
    }

    public void setWapp(String wapp) {
        this.wapp = wapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void inscribir(Judoka j){
        Integer m;
        if (judokas.es_vacio()){
            m = 1;
        }
        else{
            m = judokas.get_max() + 1;
        }
        this.judokas.insertar(m, j);
    }

    public void registrar_directivo(Directivo d){
        this.directivos.insertar(d);
    }
    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", personeria='" + personeria + '\'' +
                ", directivos=" + directivos +
                ", judokas=" + judokas +
                ", entrenador=" + entrenador +
                ", ubicacion='" + ubicacion + '\'' +
                ", telf='" + telf + '\'' +
                ", wapp='" + wapp + '\'' +
                ", email='" + email + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
