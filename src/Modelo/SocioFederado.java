package src.Modelo;

public class SocioFederado extends Socios {
    private String nif;
    private String federacion;

    public SocioFederado(String numeroSocio, String nombre, String nif, String federacion) {
        super(numeroSocio, nombre);
        this.nif = nif;
        this.federacion = federacion;
    }

    public String getNif() {
        return nif;
    }

    public String getFederacion() {
        return federacion;
    }

    public double calcularDescuentoCuota(double cuotaMensual) {
        return cuotaMensual * 0.95; // Descuento del 5%
    }

    public double calcularDescuentoExcursion(double precioExcursion) {
        return precioExcursion * 0.90; // Descuento del 10%
    }

    @Override
    public String toString() {
        return "Modelo.SocioFederado{" +
                super.toString() +
                ", nif='" + nif + '\'' +
                ", federacion='" + federacion + '\'' +
                '}';
    }
}

