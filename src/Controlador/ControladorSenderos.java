package src.Controlador;

import src.Modelo.*;
import src.Vista.VistaSenderos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ControladorSenderos {

    Scanner scanner = new Scanner(System.in);
    public VistaSenderos vista;
    public ArrayList<Excursiones> excursiones;
    private ArrayList<SocioEstándar> socioEstandars;
    private ArrayList<SocioFederado> socioFederados;
    private ArrayList<SocioInfantil> socioInfantils;
    private ArrayList<Inscripciones> inscripciones;

    public ControladorSenderos() {
        vista = new VistaSenderos();
        excursiones = new ArrayList<>();
        socioEstandars = new ArrayList<>();
        socioFederados = new ArrayList<>();
        socioInfantils = new ArrayList<>();
        inscripciones = new ArrayList<>();
    }

    public void iniciar() {
        boolean continuar = true;
        while (continuar) {
            vista.mostrarMenu();
            int opcion = vista.obtenerOpcion();

            switch (opcion) {
                case 1:
                    AñadirExcursion();
                    break;
                case 2:
                    mostrarExcursiones();
                    break;
                case 3:
                    añadirSocioEstandar();
                    break;
                case 4:
                    modificarSeguroSocioEstandar();
                    break;
                case 5:
                    añadirSociofederado();
                    break;
                case 6:
                    añadirSocioInfantil();
                    break;
                case 7:
                    eliminarSocio();
                    break;
                case 8:
                    mostrarSociosPorTipo();
                    break;
                case 9:
                    mostrarFacturaMensual();
                    break;
                case 10:
                    añadirInscripcion();
                    break;
                case 11:
                    eliminiarInscripcion();
                    break;
                case 12:
                    mostrarInscripciones();
                    break;
                default:
                    continuar = false;
                    break;
            }
        }
        vista.cerrarScanner();
    }

    public void AñadirExcursion() {
        String codExcursion = vista.obtenerInput("Ingrese el código de la Excursion:");
        String descripcion = vista.obtenerInput("Ingrese la descripción de la Excursion:");
        Date fecha = null;

        while (fecha == null) {
            String fechaStr = vista.obtenerInput("Ingrese la fecha de la Excursion (formato dd/MM/yyyy):");
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                fecha = sdf.parse(fechaStr);
            } catch (ParseException e) {
                vista.mostrarMensaje("Formato de fecha incorrecto. Use dd/MM/yyyy.");
            }
        }

        int numDias = Integer.parseInt(vista.obtenerInput("Ingrese el número de días de la Excursion:"));
        float precioInscripcion = Float.parseFloat(vista.obtenerInput("Ingrese el precio de inscripción de la Excursion:"));

        // Crear la nueva excursión
        Excursiones nuevaExcursion = new Excursiones(codExcursion, descripcion, fecha, numDias, precioInscripcion);
        excursiones.add(nuevaExcursion);
        vista.mostrarMensaje("Excursión añadida correctamente.");
    }

    private void mostrarExcursiones() {
        if (excursiones.isEmpty()) {
            vista.mostrarMensaje("No hay excursiones disponibles.");
        } else {
            for (Excursiones excursion : excursiones) {
                vista.mostrarMensaje(excursion.toString());
            }
        }
    }

    void añadirSocioEstandar(){
        System.out.println("Introduce el número del socio:");
        String numeroSocio = scanner.nextLine();
        System.out.println("Introduce el nombre del socio:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese su NIF");
        String nif = scanner.nextLine();
        System.out.println("Ingrese el tipo de seguro contratado");
        String seguroContratado = scanner.nextLine();


        SocioEstándar nuevoSocioEstandar = new SocioEstándar(numeroSocio, nombre, nif, seguroContratado);

        socioEstandars.add(nuevoSocioEstandar);
        System.out.println("Socio Estandar añadido correctamente");
    }
    void añadirSociofederado(){
        System.out.println("Introduce el número del socio:");
        String numeroSocio = scanner.nextLine();
        System.out.println("Introduce el nombre del socio:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese su NIF");
        String nif = scanner.nextLine();
        System.out.println("Ingrese la federacion");
        String federacion = scanner.nextLine();


        SocioFederado nuevoSocioFederado = new SocioFederado(numeroSocio, nombre, nif, federacion);

        socioFederados.add(nuevoSocioFederado);
        System.out.println("Socio Estandar añadido correctamente");
    }
    void añadirSocioInfantil(){
        System.out.println("Introduce el número del socio:");
        String numeroSocio = scanner.nextLine();
        System.out.println("Introduce el nombre del socio:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el numeor del Socio Padre/Madre");
        String numeroSocioPadreOMadre = scanner.nextLine();


        SocioInfantil nuevoSocioInfantil = new SocioInfantil(numeroSocio, nombre, numeroSocioPadreOMadre);

        socioInfantils.add(nuevoSocioInfantil);
        System.out.println("Socio Infantil añadido correctamente");
    }
    void eliminarSocio() {
        System.out.println("Ingrese el número de socio a eliminar:");
        String numeroSocio = scanner.nextLine();

        boolean eliminado = false;

        // Buscar en la lista de socios estándar
        for (int i = 0; i < socioEstandars.size(); i++) {
            if (socioEstandars.get(i).getNumeroSocio().equals(numeroSocio)) {
                socioEstandars.remove(i);
                eliminado = true;
                System.out.println("Socio Estándar eliminado correctamente.");
                break;
            }
        }

        // Si no se eliminó de la lista de socios estándar, buscar en socios federados
        if (!eliminado) {
            for (int i = 0; i < socioFederados.size(); i++) {
                if (socioFederados.get(i).getNumeroSocio().equals(numeroSocio)) {
                    socioFederados.remove(i);
                    eliminado = true;
                    System.out.println("Socio Federado eliminado correctamente.");
                    break;
                }
            }
        }

        // Si no se eliminó de la lista de socios federados, buscar en socios infantiles
        if (!eliminado) {
            for (int i = 0; i < socioInfantils.size(); i++) {
                if (socioInfantils.get(i).getNumeroSocio().equals(numeroSocio)) {
                    socioInfantils.remove(i);
                    eliminado = true;
                    System.out.println("Socio Infantil eliminado correctamente.");
                    break;
                }
            }
        }

        // Si no se encontró el socio en ninguna lista
        if (!eliminado) {
            System.out.println("No se encontró un socio con el número: " + numeroSocio);
        }
    }
    void modificarSeguroSocioEstandar() {
        System.out.println("Introduce el número del socio estándar cuyo seguro deseas modificar:");
        String numeroSocio = scanner.nextLine();

        SocioEstándar socioAmodificar = null;

        // Buscar el socio en la lista de socios estándar
        for (SocioEstándar socio : socioEstandars) {
            if (socio.getNumeroSocio().equals(numeroSocio)) {
                socioAmodificar = socio;
                break;
            }
        }

        // Si se encuentra el socio
        if (socioAmodificar != null) {
            System.out.println("Introduce el nuevo tipo de seguro para el socio " + socioAmodificar.getNombre() + ":");
            String nuevoSeguro = scanner.nextLine();

            // Modificar el tipo de seguro
            socioAmodificar.setSeguroContratado(nuevoSeguro);
            System.out.println("El tipo de seguro ha sido modificado correctamente.");
        } else {
            System.out.println("No se encontró un socio estándar con el número: " + numeroSocio);
        }
    }
    void mostrarSociosPorTipo() {
        System.out.println("Seleccione el tipo de socio que desea mostrar:");
        System.out.println("1. Socios Estándar");
        System.out.println("2. Socios Federados");
        System.out.println("3. Socios Infantiles");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (opcion) {
            case 1:
                System.out.println("Socios Estándar:");
                if (socioEstandars.isEmpty()) {
                    System.out.println("No hay socios estándar registrados.");
                } else {
                    for (SocioEstándar socio : socioEstandars) {
                        System.out.println(socio);
                    }
                }
                break;

            case 2:
                System.out.println("Socios Federados:");
                if (socioFederados.isEmpty()) {
                    System.out.println("No hay socios federados registrados.");
                } else {
                    for (SocioFederado socio : socioFederados) {
                        System.out.println(socio);
                    }
                }
                break;

            case 3:
                System.out.println("Socios Infantiles:");
                if (socioInfantils.isEmpty()) {
                    System.out.println("No hay socios infantiles registrados.");
                } else {
                    for (SocioInfantil socio : socioInfantils) {
                        System.out.println(socio);
                    }
                }
                break;

            default:
                System.out.println("Opción no válida.");
        }
    }

    void añadirInscripcion() {
        System.out.println("Introduce el número de inscripción:");
        String numeroInscripcion = scanner.nextLine();

        // Pregunta por el socio
        System.out.println("Introduce el número del socio:");
        String numeroSocio = scanner.nextLine();
        Socios socio = buscarSocioPorNumero(numeroSocio); // Método para buscar el socio

        if (socio == null) {
            System.out.println("No se encontró el socio.");
            return;
        }

        // Pregunta por la excursión
        System.out.println("Introduce el código de la excursión:");
        String codExcursion = scanner.nextLine();
        Excursiones excursion = buscarExcursionPorCodigo(codExcursion); // Método para buscar la excursión

        if (excursion == null) {
            System.out.println("No se encontró la excursión.");
            return;
        }

        // Obtener la fecha de inscripción
        System.out.println("Introduce la fecha de inscripción (formato dd/MM/yyyy):");
        String fechaStr = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInscripcion = null;

        try {
            fechaInscripcion = sdf.parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto. No se puede añadir la inscripción.");
            return;
        }

        // Crear la nueva inscripción
        Inscripciones nuevaInscripcion = new Inscripciones(numeroInscripcion, socio, excursion, fechaInscripcion);

        // Añadir la inscripción a la lista
        inscripciones.add(nuevaInscripcion);
        System.out.println("Inscripción añadida correctamente.");
    }
    Socios buscarSocioPorNumero(String numeroSocio) {
        for (SocioEstándar socio : socioEstandars) {
            if (socio.getNumeroSocio().equals(numeroSocio)) {
                return socio;
            }
        }
        for (SocioFederado socio : socioFederados) {
            if (socio.getNumeroSocio().equals(numeroSocio)) {
                return socio;
            }
        }
        for (SocioInfantil socio : socioInfantils) {
            if (socio.getNumeroSocio().equals(numeroSocio)) {
                return socio;
            }
        }
        return null; // No encontrado
    }
    Excursiones buscarExcursionPorCodigo(String codExcursion) {
        for (Excursiones excursion : excursiones) {
            if (excursion.getCodExcursion().equals(codExcursion)) {
                return excursion;
            }
        }
        return null; // No encontrado
    }

    void eliminiarInscripcion(){
        System.out.println("Ingrese el número de la Inscripcion a eliminar:");
        String numeroInscripcion = scanner.nextLine();

        boolean eliminado = false;
        for (int i = 0; i < inscripciones.size(); i++) {
            if (inscripciones.get(i).getNumeroInscripcion().equals(numeroInscripcion)) {
                inscripciones.remove(i);
                eliminado = true;
                System.out.println("La inscripción ha sido eliminado correctamente.");
                break;
            }
        }
        if (!eliminado){
            System.out.println("Inscripción no encontrada");
        }
    }
    void mostrarInscripciones() {
        System.out.println("¿Deseas filtrar por socio? (sí/no)");
        String filtrarPorSocio = scanner.nextLine();

        String numeroSocio = null;
        if (filtrarPorSocio.equalsIgnoreCase("sí")) {
            System.out.println("Introduce el número del socio:");
            numeroSocio = scanner.nextLine();
        }

        System.out.println("¿Deseas filtrar por fecha? (sí/no)");
        String filtrarPorFecha = scanner.nextLine();

        Date fechaFiltro = null;
        if (filtrarPorFecha.equalsIgnoreCase("sí")) {
            System.out.println("Introduce la fecha de inscripción (formato dd/MM/yyyy):");
            String fechaStr = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                fechaFiltro = sdf.parse(fechaStr);
            } catch (ParseException e) {
                System.out.println("Formato de fecha incorrecto. Usando null para filtrar.");
            }
        }

        // Mostrar las inscripciones con los filtros aplicados
        boolean hayInscripciones = false;
        for (Inscripciones inscripcion : inscripciones) {
            boolean mostrar = true;

            if (numeroSocio != null && !inscripcion.getSocio().getNumeroSocio().equals(numeroSocio)) {
                mostrar = false;
            }

            if (fechaFiltro != null && !inscripcion.getFechaInscripcion().equals(fechaFiltro)) {
                mostrar = false;
            }

            if (mostrar) {
                System.out.println(inscripcion);
                hayInscripciones = true; // Hay al menos una inscripción que cumple los criterios
            }
        }

        if (!hayInscripciones) {
            System.out.println("No se encontraron inscripciones que cumplan los criterios.");
        }
    }
    void mostrarFacturaMensual() {
        // Recorremos cada tipo de socio
        System.out.println("Generando facturas mensuales por socio...");

        // Facturación para los Socios Estándar
        System.out.println("\nFacturas para Socios Estándar:");
        for (SocioEstándar socio : socioEstandars) {
            float total = 0;
            for (Inscripciones inscripcion : inscripciones) {
                if (inscripcion.getSocio().equals(socio)) {
                    total += inscripcion.getExcursion().getPrecioInscripcion(); // Precio completo para estándar
                }
            }
            System.out.println("Socio: " + socio.getNombre() + " | Total a pagar: " + total + "€");
        }

        // Facturación para los Socios Federados (con descuento)
        System.out.println("\nFacturas para Socios Federados:");
        for (SocioFederado socio : socioFederados) {
            float total = 0;
            for (Inscripciones inscripcion : inscripciones) {
                if (inscripcion.getSocio().equals(socio)) {
                    float precioConDescuento = inscripcion.getExcursion().getPrecioInscripcion() * 0.8f; // 20% de descuento
                    total += precioConDescuento;
                }
            }
            System.out.println("Socio: " + socio.getNombre() + " | Total a pagar (con descuento): " + total + "€");
        }

        // Facturación para los Socios Infantiles (tarifa reducida o gratuita)
        System.out.println("\nFacturas para Socios Infantiles:");
        for (SocioInfantil socio : socioInfantils) {
            float total = 0;
            for (Inscripciones inscripcion : inscripciones) {
                if (inscripcion.getSocio().equals(socio)) {
                    total += inscripcion.getExcursion().getPrecioInscripcion() * 0.5f; // 50% de descuento
                }
            }
            System.out.println("Socio: " + socio.getNombre() + " | Total a pagar (tarifa reducida): " + total + "€");
        }
    }
}
