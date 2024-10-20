package src.Modelo;

public class Seguros {
    private String tipo; // Puede ser "Básico" o "Completo"
    private double precio;

    public Seguros(String tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    // Getters y Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Seguro{" +
                "tipo='" + tipo + '\'' +
                ", precio=" + precio + '}';
    }
}
