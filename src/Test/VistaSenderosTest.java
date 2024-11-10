package src.Test;// src/test/java/Vista/VistaSenderosTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Vista.VistaSenderos;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
class VistaSenderosTest {

    private VistaSenderos vista;

    @BeforeEach
    void setUp() {
        // inicializar la vista antes de cada prueba
        vista = new VistaSenderos() {
            // sustituir funcion input para introducir manualmente
            @Override
            public String obtenerInput(String mensaje) {
                // esto devuelve los valores segun el mensaje, mas adelante se prueba con asserts
                if (mensaje.contains("código")) {
                    return "EXC123";
                } else if (mensaje.contains("descripción")) {
                    return "Excursión a la montaña";
                } else if (mensaje.contains("fecha")) {
                    return "20/10/2024"; //  formato dd/MM/yyyy
                } else if (mensaje.contains("días")) {
                    return "3";
                } else if (mensaje.contains("precio")) {
                    return "100.0";
                }
                return "";
            }
        };
    }

    @Test
    void testObtenerInput() {
        // comprobar que el input recibe la entrada correcta para cada mensaje
        assertEquals("EXC123", vista.obtenerInput("Introduce el código de la excursión: "));
        assertEquals("Excursión a la montaña", vista.obtenerInput("Introduce la descripción de la excursión: "));
        assertEquals("20/10/2024", vista.obtenerInput("Introduce la fecha (dd/MM/yyyy): "));
        assertEquals("3", vista.obtenerInput("Introduce el número de días: "));
        assertEquals("100.0", vista.obtenerInput("Introduce el precio de inscripción: "));
    }

    @Test
    void testMostrarMensaje() {
        // el output stream sirve para retener lo que enseña la consola
        // simulamos la salida para comprobar que sea el mensaje esperrrado
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String mensaje = "¡Excursión añadida con éxito!";
        vista.mostrarMensaje(mensaje);

        // comprobar que el mensaje esperado y el transmitido es el mimso
        assertEquals(mensaje + System.lineSeparator(), outputStream.toString());

        // volver el output original
        System.setOut(originalOut);
    }
}