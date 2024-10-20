package src.Test;

// src/test/java/Controlador/ControladorSenderosTest.java


import src.Controlador.ControladorSenderos;
import src.Modelo.Excursiones;
import src.Vista.VistaSenderos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControladorSenderosTest {

    private ControladorSenderos controlador;
    private VistaSenderos vista;

    @BeforeEach
    void setUp() {
        vista = new VistaSenderos() {
            // Sobrescribir métodos de entrada para evitar la interacción real con Scanner
            @Override
            public String obtenerInput(String mensaje) {
                // Devuelve valores simulados, puedes ajustarlos según sea necesario
                if (mensaje.contains("código")) {
                    return "EXC123";
                } else if (mensaje.contains("descripción")) {
                    return "Excursión a la montaña";
                } else if (mensaje.contains("fecha")) {
                    return "20/10/2024"; // Fecha en formato dd/MM/yyyy
                } else if (mensaje.contains("días")) {
                    return "3";
                } else if (mensaje.contains("precio")) {
                    return "100.0";
                }
                return "";
            }
        };

        controlador = new ControladorSenderos();
        controlador.vista = vista; // Asignar vista simulada al controlador
        controlador.excursiones = new ArrayList<>(); // Asegurarnos de que la lista de excursiones está inicializada
    }

    @Test
    void testAñadirExcursion() throws Exception {
        // Llamar al método para añadir una excursión
        controlador.AñadirExcursion();

        // Verificar que la excursión ha sido añadida
        assertEquals(1, controlador.excursiones.size(), "Debería haber una excursión añadida.");

        // Verificar los detalles de la excursión añadida
        Excursiones excursion = controlador.excursiones.get(0);
        assertEquals("EXC123", excursion.getCodExcursion(), "El código de la excursión debería ser EXC123");
        assertEquals("Excursión a la montaña", excursion.getDescripcion(), "La descripción debería ser 'Excursión a la montaña'");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaEsperada = sdf.parse("20/10/2024");
        assertEquals(fechaEsperada, excursion.getFecha(), "La fecha debería ser 20/10/2024");
        assertEquals(3, excursion.getNumDias(), "El número de días debería ser 3");
        assertEquals(100.0, excursion.getPrecioInscripcion(), "El precio de inscripción debería ser 100.0");
    }
}

