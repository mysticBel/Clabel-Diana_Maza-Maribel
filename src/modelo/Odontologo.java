package modelo;

public class Odontologo {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer numeroMatricula;


    // CONSTRUCTOR

    public Odontologo(Integer id, String nombre, String apellido, Integer numeroMatricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroMatricula = numeroMatricula;
    }

    public Odontologo(String nombre, String apellido, Integer numeroMatricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroMatricula = numeroMatricula;
    }
    // GETTERS Y SETTERS


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

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numeroMatricula=" + numeroMatricula +
                '}';
    }
}
