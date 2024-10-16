import java.util.Date;

public class Inscripciones {
    private String numeroInscripcion; // Número de inscripción
    private Socios socio; // Socio asociado a la inscripción
    private Excursiones excursión; // Excursión asociada a la inscripción
    private Date fechaInscripcion; // Fecha de la inscripción

    public Inscripciones(String numeroInscripcion, Socios socio, Excursiones excursión, Date fechaInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
        this.socio = socio;
        this.excursión = excursión;
        this.fechaInscripcion = fechaInscripcion;
    }

    // Getters y Setters
    public String getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(String numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public Socios getSocio() {
        return socio;
    }

    public void setSocio(Socios socio) {
        this.socio = socio;
    }

    public Excursiones getExcursion() {
        return excursión;
    }

    public void setExcursion(Excursiones excursión) {
        this.excursión = excursión;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

//    // Método para cancelar la inscripción
//    public boolean cancelarInscripcion(Date fechaExcursion) {
//        if (fechaInscripcion.before(fechaExcursion)) {
//            // Lógica para cancelar la inscripción
//            System.out.println("Inscripción cancelada.");
//            return true;
//        } else {
//            System.out.println("No se puede cancelar la inscripción. Debe hacerse antes de la fecha de la excursión.");
//            return false;
//        }
//    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numeroInscripcion='" + numeroInscripcion + '\'' +
                ", socio=" + socio + // Incluye la representación del socio
                ", excursión=" + excursión + // Incluye la representación de la excursión
                ", fechaInscripcion=" + fechaInscripcion +
                '}';
    }
}
