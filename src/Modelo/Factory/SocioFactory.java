package src.Modelo.Factory;

import src.Modelo.*;

public class SocioFactory {
    public static Socios crearSocio(String tipo, String numeroSocio, String nombre, String nif, String extra) {
        switch (tipo.toLowerCase()) {
            case "estándar":
                return new SocioEstándar(numeroSocio, nombre, nif, extra);
            case "federado":
                return new SocioFederado(numeroSocio, nombre, nif, extra);
            case "infantil":
                return new SocioInfantil(numeroSocio, nombre, extra);
            default:
                throw new IllegalArgumentException("Tipo de socio no válido.");
        }
    }
}
