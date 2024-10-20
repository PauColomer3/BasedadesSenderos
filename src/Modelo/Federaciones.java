package src.Modelo;

public class Federaciones {
    private String codigo; // Código alfanumérico de la federación
    private String nombre;  // Nombre de la federación
    //asasas
    public Federaciones(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Federacion{" +
                "codigo='" + codigo + '\'' + ", nombre='" + nombre + '\'' + '}';
    }
}

