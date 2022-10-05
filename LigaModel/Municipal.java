package LigaModel;

import PrograAvan.Lineal.Lista;

public class Municipal {
    private Integer id_municipal;
    private String nombre;
    private String personeria;
    private String ubicacion;
    private Lista<Directivo> directivos;
    private Lista<Club> afiliados;
    private String contactos;
    private String url;

    public Municipal(String nombre, String personeria, String ubicacion, Lista<Club> afiliados, String contactos, String url) {
        this.nombre = nombre;
        this.personeria = personeria;
        this.ubicacion = ubicacion;
        this.afiliados = afiliados;
        this.contactos = contactos;
        this.url = url;
    }

    public Integer getId_municipal() {
        return id_municipal;
    }

    public void setId_municipal(Integer id_municipal) {
        this.id_municipal = id_municipal;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Lista<Club> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(Lista<Club> afiliados) {
        this.afiliados = afiliados;
    }

    public String getContactos() {
        return contactos;
    }

    public void setContactos(String contactos) {
        this.contactos = contactos;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void afiliar(Club d){
        this.afiliados.insertar(d);
    }
    public void registrar_directivo(Directivo d){
        this.directivos.insertar(d);
    }
}
