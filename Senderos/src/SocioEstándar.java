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

    public String getSeguroContratado() {
        return seguroContratado;
    }

    @Override
    public String toString() {
        return "SocioEstándar{" +
                super.toString() +
                ", nif='" + nif + '\'' +
                ", seguroContratado='" + seguroContratado + '\'' +
                '}';
    }
}
