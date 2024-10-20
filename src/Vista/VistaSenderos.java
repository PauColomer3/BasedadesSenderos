package src.Vista;

import java.util.Scanner;

public class VistaSenderos {
    private Scanner scanner;

    public VistaSenderos() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("Bienvenido a la Base de Senderos");
        System.out.println("Seleccione una opción");
        System.out.println("1. Añadir Excursión");
        System.out.println("2. Mostrar Excursiones");
        System.out.println("3. Añadir Socio Estándar");
        System.out.println("4. Modificar tipo de seguro de un socio estándar");
        System.out.println("5. Añadir Socio Federado.");
        System.out.println("6. Añadir Socio Infantil.");
        System.out.println("7. Eliminar Socio.");
        System.out.println("8. Mostrar Socios");
        System.out.println("9. Mostrar factura mensual por socios");
        System.out.println("10. Añadir inscripciones");
        System.out.println("11. Eliminar inscripciones");
        System.out.println("12. Mostrar inscripciones");
    }

    public int obtenerOpcion() {
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        return opcion;
    }

    public String obtenerInput(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
