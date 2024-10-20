package src.Modelo;

public class SeguroBasico extends Seguros {

    public SeguroBasico(double precio) {
        super("Básico", precio); // Asigna el tipo "Básico" y el precio recibido
    }

    @Override
    public String toString() {
        return "Modelo.SeguroBasico{" +
                super.toString() + // Incluye la representación de la clase padre
                '}';
    }
}
