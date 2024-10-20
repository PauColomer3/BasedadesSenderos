package src.Modelo;

public class SeguroCompleto extends Seguros {

    public SeguroCompleto(double precio) {
        super("Completo", precio); // Asigna el tipo "Completo" y el precio recibido
    }

    @Override
    public String toString() {
        return "Modelo.SeguroCompleto{" +
                super.toString() + // Incluye la representación de la clase padre
                '}';
    }
}
