package LigaModel;

public class Persona {
    private Integer id;
    private String nombre;
    private String apellido;
    private String ci;
    private byte genero;
    private String telf;
    private String email;
    private String direccion;

    public Persona(String nombre, String apellido, String ci, String telf, String email, String direccion, byte genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
        this.telf = telf;
        this.email = email;
        this.direccion = direccion;
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", ci='" + ci + '\'' +
                ", telf='" + telf + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
