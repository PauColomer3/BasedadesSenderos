package src.Modelo;

public class SocioEstándar extends Socios {
    private String nif;
    private String seguroContratado;

    public SocioEstándar(String numeroSocio, String nombre, String nif, String seguroContratado) {
        super(numeroSocio, nombre);
        this.nif = nif;
        this.seguroContratado = seguroContratado;
    }

    public String getNif() {
        return nif;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getSeguroContratado() {
        return seguroContratado;
    }

    public void setSeguroContratado(String seguroContratado) {
        this.seguroContratado = seguroContratado;
    }

    @Override
    public String toString() {
        return "Modelo.SocioEstándar{" +
                super.toString() +
                ", nif='" + nif + '\'' +
                ", seguroContratado='" + seguroContratado + '\'' +
                '}';
    }
}
