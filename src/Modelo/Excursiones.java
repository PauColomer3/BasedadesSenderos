package src.Modelo;

import java.util.Date;

public class Excursiones {

    private String codExcursion;
    private String descripcion;
    private Date fecha;
    private int numDias;
    private float precioInscripcion;

    // Constructors
    public Excursiones(String codExcursion, String descripcion,
                       Date fecha, int numDias, float precioInscripcion){
        this.codExcursion = codExcursion;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.numDias = numDias;
        this.precioInscripcion = precioInscripcion;
    }
    // Getters i Setters

    public String getCodExcursion(){
        return codExcursion;
    }
    public void setCodExcursion(String codExcursion) {
        this.codExcursion = codExcursion;
    }

    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha(){
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumDias() {
        return numDias;
    }
    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }

    public float getPrecioInscripcion() {
        return precioInscripcion;
    }

    public void setPrecioInscripcion(float precioInscripcion) {
        this.precioInscripcion = precioInscripcion;
    }
    @Override
    public String toString() {
        return "src.Modelo.Excursiones{" +
                "codExcursion='" + codExcursion + '\'' + ", descripcion='" + descripcion + '\'' + ", fecha=" + fecha +
                ", numDias=" + numDias + ", precioInscripcion=" + precioInscripcion + '}';
    }
}
