package src.Modelo;

public class SocioInfantil extends Socios {
    private String numeroSocioPadreOMadre;

    public SocioInfantil(String numeroSocio, String nombre, String numeroSocioPadreOMadre) {
        super(numeroSocio, nombre);
        this.numeroSocioPadreOMadre = numeroSocioPadreOMadre;
    }

    public String getNumeroSocioPadreOMadre() {
        return numeroSocioPadreOMadre;
    }

    public double calcularDescuentoCuota(double cuotaMensual) {
        return cuotaMensual * 0.50; // Descuento del 50%
    }

    @Override
    public String toString() {
        return "Modelo.SocioInfantil{" +
                super.toString() +
                ", numeroSocioPadreOMadre='" + numeroSocioPadreOMadre + '\'' +
                '}';
    }
}
