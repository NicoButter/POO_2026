package diagnostico_2026.implementacion;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Lollapalooza festival;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        boolean salir = false;

        System.out.println("==============================================");
        System.out.println("  BIENVENIDO AL GESTOR DE LOLLAPALOOZA 2026");
        System.out.println("==============================================\n");

        // Crear festival
        crearFestival();

        while (!salir) {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            int opcion = leerEntero();
            System.out.println();

            switch (opcion) {
                case 1:
                    agregarEscenario();
                    break;
                case 2:
                    agregarActuacion();
                    break;
                case 3:
                    buscarActuacionesPorDia();
                    break;
                case 4:
                    buscarActuacionesPorEscenario();
                    break;
                case 5:
                    buscarActuacionesPorBanda();
                    break;
                case 6:
                    mostrarTodasActuaciones();
                    break;
                case 7:
                    mostrarEscenarios();
                    break;
                case 8:
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.\n");
            }
        }
        scanner.close();
    }

    private static void crearFestival() {
        System.out.print("Ingrese el país del festival: ");
        String pais = scanner.nextLine();

        System.out.print("Ingrese la edición (ej: 2026): ");
        String edicion = scanner.nextLine();

        System.out.print("Ingrese el lugar: ");
        String lugar = scanner.nextLine();

        System.out.print("Ingrese la cantidad de días: ");
        int dias = leerEntero();

        festival = new Lollapalooza(pais, edicion, lugar, dias);
        System.out.println("Festival creado: " + pais + " - Edición " + edicion + "\n");
    }

    private static void mostrarMenu() {
        System.out.println("=== MENÚ PRINCIPAL ===");
        System.out.println("1. Agregar escenario");
        System.out.println("2. Agregar actuación");
        System.out.println("3. Buscar actuaciones por día");
        System.out.println("4. Buscar actuaciones por escenario");
        System.out.println("5. Buscar actuaciones por banda");
        System.out.println("6. Ver todas las actuaciones");
        System.out.println("7. Ver escenarios del festival");
        System.out.println("8. Salir");
        System.out.println("======================\n");
    }

    private static void agregarEscenario() {
        System.out.print("Ingrese el nombre del escenario: ");
        String nombreEscenario = scanner.nextLine();

        System.out.print("Ingrese la ubicación (ej: Zona A, Sur): ");
        String ubicacion = scanner.nextLine();

        System.out.print("Ingrese la capacidad (personas): ");
        int capacidad = leerEntero();

        Escenario escenario = new Escenario(nombreEscenario, ubicacion, capacidad);
        festival.agregarEscenario(escenario);
        System.out.println("✓ Escenario '" + nombreEscenario + "' agregado exitosamente.\n");
    }

    private static void agregarActuacion() {
        System.out.print("Ingrese el nombre de la banda: ");
        String nombreBanda = scanner.nextLine();

        System.out.print("Ingrese la duración en minutos: ");
        int duracion = leerEntero();

        System.out.print("Ingrese la fecha (ej: 2026-04-03): ");
        String fecha = scanner.nextLine();

        System.out.print("Ingrese la hora de inicio (ej: 20:30): ");
        String horaInicio = scanner.nextLine();

        // Mostrar escenarios disponibles
        ArrayList<Escenario> escenarios = festival.getEscenarios();
        if (escenarios.isEmpty()) {
            System.out.println("No hay escenarios registrados. Agregue uno primero.\n");
            return;
        }

        System.out.println("\nEscenarios disponibles:");
        for (int i = 0; i < escenarios.size(); i++) {
            System.out.println((i + 1) + ". " + escenarios.get(i).getNombre());
        }
        System.out.print("Seleccione el número del escenario: ");
        int seleccion = leerEntero() - 1;

        if (seleccion < 0 || seleccion >= escenarios.size()) {
            System.out.println("Selección inválida.\n");
            return;
        }

        Escenario escenarioSeleccionado = escenarios.get(seleccion);
        Actuacion actuacion = new Actuacion(nombreBanda, duracion, fecha, horaInicio, escenarioSeleccionado);
        festival.agregarActuacion(actuacion);
        System.out.println("✓ Actuación de '" + nombreBanda + "' agregada exitosamente.\n");
    }

    private static void buscarActuacionesPorDia() {
        System.out.print("Ingrese la fecha a buscar (ej: 2026-04-03): ");
        String fecha = scanner.nextLine();

        ArrayList<Actuacion> resultados = festival.getActuacionesPorDia(fecha);

        if (resultados.isEmpty()) {
            System.out.println("No hay actuaciones registradas para la fecha: " + fecha + "\n");
        } else {
            System.out.println("=== Actuaciones del " + fecha + " ===");
            for (Actuacion a : resultados) {
                System.out.println("  • " + a.getNombreBanda() + " - " + a.getHoraInicio() +
                        " (" + a.getDuracionMinutos() + " min) - Escenario: " + a.getEscenario());
            }
            System.out.println();
        }
    }

    private static void buscarActuacionesPorEscenario() {
        ArrayList<Escenario> escenarios = festival.getEscenarios();
        if (escenarios.isEmpty()) {
            System.out.println("No hay escenarios registrados.\n");
            return;
        }

        System.out.println("Escenarios disponibles:");
        for (int i = 0; i < escenarios.size(); i++) {
            System.out.println((i + 1) + ". " + escenarios.get(i).getNombre());
        }
        System.out.print("Seleccione el número del escenario: ");
        int seleccion = leerEntero() - 1;

        if (seleccion < 0 || seleccion >= escenarios.size()) {
            System.out.println("Selección inválida.\n");
            return;
        }

        Escenario escenarioSeleccionado = escenarios.get(seleccion);
        ArrayList<Actuacion> resultados = festival.getActuacionesPorEscenario(escenarioSeleccionado);

        if (resultados.isEmpty()) {
            System.out.println("No hay actuaciones registradas para el escenario: " + escenarioSeleccionado.getNombre() + "\n");
        } else {
            System.out.println("=== Actuaciones en " + escenarioSeleccionado.getNombre() + " ===");
            for (Actuacion a : resultados) {
                System.out.println("  • " + a.getNombreBanda() + " - " + a.getFecha() + " a " +
                        a.getHoraInicio() + " (" + a.getDuracionMinutos() + " min)");
            }
            System.out.println();
        }
    }

    private static void buscarActuacionesPorBanda() {
        System.out.print("Ingrese el nombre de la banda a buscar: ");
        String nombre = scanner.nextLine();

        ArrayList<Actuacion> resultados = festival.buscarActuacionPorNombreBanda(nombre);

        if (resultados.isEmpty()) {
            System.out.println("No hay actuaciones registradas para: " + nombre + "\n");
        } else {
            System.out.println("=== Actuaciones de " + nombre + " ===");
            for (Actuacion a : resultados) {
                System.out.println("  • " + a.getFecha() + " a " + a.getHoraInicio() +
                        " - Escenario: " + a.getEscenario() + " (" + a.getDuracionMinutos() + " min)");
            }
            System.out.println();
        }
    }

    private static void mostrarTodasActuaciones() {
        ArrayList<Actuacion> todas = festival.getActuaciones();

        if (todas.isEmpty()) {
            System.out.println("No hay actuaciones registradas aún.\n");
        } else {
            System.out.println("=== TODAS LAS ACTUACIONES ===");
            for (int i = 0; i < todas.size(); i++) {
                Actuacion a = todas.get(i);
                String nombreEscenario = a.getEscenario() != null ? a.getEscenario().getNombre() : "N/A";
                System.out.println((i + 1) + ". " + a.getNombreBanda() + " - " + a.getFecha() +
                        " a " + a.getHoraInicio() + " - Escenario: " + nombreEscenario +
                        " (" + a.getDuracionMinutos() + " min)");
            }
            System.out.println();
        }
    }

    private static void mostrarEscenarios() {
        ArrayList<Escenario> escenarios = festival.getEscenarios();

        if (escenarios.isEmpty()) {
            System.out.println("No hay escenarios registrados aún.\n");
        } else {
            System.out.println("=== ESCENARIOS DEL FESTIVAL ===");
            for (int i = 0; i < escenarios.size(); i++) {
                Escenario e = escenarios.get(i);
                System.out.println((i + 1) + ". " + e.getNombre() + " - " + e.getUbicacion() +
                        " (Capacidad: " + e.getCapacidad() + ")");
            }
            System.out.println();
        }
    }

    private static int leerEntero() {
        int valor = 0;
        try {
            valor = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un número válido.");
            valor = leerEntero();
        }
        return valor;
    }
}
