package diagnostico_2026.implementacion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Main - Interfaz de usuario y control de flujo.
 * 
 * RESPONSABILIDADES:
 * - Mostrar menús y capturar entrada del usuario (Scanner)
 * - CREAR objetos de dominio (new Escenario, new Actuacion)
 * - Controlar el flujo de navegación de la aplicación
 * - Mostrar resultados al usuario
 * 
 * Delegación a Lollapalooza:
 * - Gestionar objetos en colecciones
 * - Validar reglas de negocio
 * - Realizar búsquedas y consultas
 * 
 * Separación de responsabilidades:
 * - Main: Creación de objetos, presentación e interacción con usuario
 * - Lollapalooza: Gestión y validación de objetos de dominio
 * - Escenario/Actuacion: Modelo de dominio puro (data only)
 * 
 * PRINCIPIO CLAVE: 
 * Main crea los objetos (new Escenario, new Actuacion).
 * Main delega a Lollapalooza la gestión de esos objetos.
 * 
 * @author Nicolás Butterfield
 * @version 3.0 - Refactorizado según principios OOP: creación de objetos en Main
 */
public class Main {

    private static Lollapalooza festival;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        boolean salir = false;

        System.out.println("==============================================");
        System.out.println("  BIENVENIDO AL GESTOR DE LOLLAPALOOZA 2026");
        System.out.println("==============================================\n");

        // Crear festival y configurarlo
        crearFestival();

        // Preguntar si desea cargar datos de ejemplo
        cargarDatosDeEjemplo();

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

    /**
     * Solicita al usuario los datos básicos del festival y lo configura.
     * Esta operación es la primera que ocurre al iniciar la aplicación.
     * 
     * Datos solicitados:
     * - País donde se realiza el festival
     * - Edición o año
     * - Sede/recinto
     * - Cantidad de días
     */
    private static void crearFestival() {
        System.out.print("Ingrese el país del festival: ");
        String pais = scanner.nextLine();

        System.out.print("Ingrese la edición (ej: 2026): ");
        String edicion = scanner.nextLine();

        System.out.print("Ingrese la sede/recinto del festival (ej: Hipódromo de San Isidro): ");
        String sede = scanner.nextLine();

        System.out.print("Ingrese la cantidad de días: ");
        int dias = leerEntero();

        // Crear instancia de festival y configurar sus datos básicos
        festival = new Lollapalooza();
        festival.configurarFestival(pais, edicion, sede, dias);
        System.out.println("Festival creado: " + pais + " - Edición " + edicion + "\n");
    }

    /**
     * Pregunta al usuario si desea cargar datos de ejemplo (escenarios y actuaciones).
     * Main es responsable de CREAR los objetos.
     * Lollapalooza solo los agrega a sus colecciones.
     * 
     * Si el usuario acepta, se cargan:
     * - 4 escenarios predefinidos
     * - 10 actuaciones en 3 días (2026-03-28 a 2026-03-30)
     */
    private static void cargarDatosDeEjemplo() {
        System.out.print("¿Desea cargar datos de ejemplo para probar el sistema? (S/N): ");
        String respuesta = scanner.nextLine().trim().toUpperCase();
        
        if (respuesta.equals("S") || respuesta.equals("SI")) {
            // CREACIÓN: Main crea todos los escenarios
            Escenario e1 = new Escenario("Escenario Principal", "Zona Norte", 50000);
            Escenario e2 = new Escenario("Escenario Alternativo", "Zona Este", 20000);
            Escenario e3 = new Escenario("Escenario Electrónico", "Zona Sur", 15000);
            Escenario e4 = new Escenario("Escenario Acústico", "Zona Oeste", 5000);
            
            // DELEGACIÓN: Lollapalooza agrega los escenarios
            festival.agregarEscenario(e1);
            festival.agregarEscenario(e2);
            festival.agregarEscenario(e3);
            festival.agregarEscenario(e4);
            
            // CREACIÓN Y DELEGACIÓN: Main crea y luego Lollapalooza agrega cada actuación
            // Día 1 (2026-03-28)
            festival.agregarActuacion(new Actuacion("Foo Fighters", 90, "2026-03-28", "21:00", e1));
            festival.agregarActuacion(new Actuacion("Arctic Monkeys", 75, "2026-03-28", "19:00", e2));
            festival.agregarActuacion(new Actuacion("Daft Punk", 120, "2026-03-28", "22:30", e3));
            festival.agregarActuacion(new Actuacion("Ed Sheeran", 60, "2026-03-28", "18:00", e4));
            
            // Día 2 (2026-03-29)
            festival.agregarActuacion(new Actuacion("Billie Eilish", 85, "2026-03-29", "20:30", e1));
            festival.agregarActuacion(new Actuacion("The Strokes", 80, "2026-03-29", "19:30", e2));
            festival.agregarActuacion(new Actuacion("Calvin Harris", 90, "2026-03-29", "23:00", e3));
            
            // Día 3 (2026-03-30)
            festival.agregarActuacion(new Actuacion("Metallica", 120, "2026-03-30", "21:30", e1));
            festival.agregarActuacion(new Actuacion("Tame Impala", 75, "2026-03-30", "19:00", e2));
            festival.agregarActuacion(new Actuacion("Bon Iver", 70, "2026-03-30", "17:30", e4));
            
            System.out.println("✓ Datos de ejemplo cargados exitosamente.");
            System.out.println("  - 4 escenarios agregados");
            System.out.println("  - 10 actuaciones agregadas en 3 días (2026-03-28 a 2026-03-30)\n");
        } else {
            System.out.println("Sistema iniciado sin datos. Use el menú para agregar información.\n");
        }
    }

    /**
     * Muestra el menú principal con todas las opciones disponibles.
     * El menú incluye 8 opciones: agregar escenario, agregar actuación, búsquedas, consultas y salir.
     */
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

    /**
     * Opción 1: Agregar escenario
     * Main CREA el objeto Escenario y lo delega a Lollapalooza para que lo gestione
     */
    private static void agregarEscenario() {
        System.out.print("Ingrese el nombre del escenario: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la ubicación (ej: Zona A, Sur): ");
        String ubicacion = scanner.nextLine();

        System.out.print("Ingrese la capacidad (personas): ");
        int capacidad = leerEntero();

        // CREACIÓN: Main crea el objeto Escenario
        Escenario nuevoEscenario = new Escenario(nombre, ubicacion, capacidad);
        
        // DELEGACIÓN: Lollapalooza valida y agrega el objeto
        boolean exito = festival.agregarEscenario(nuevoEscenario);
        
        if (exito) {
            System.out.println("✓ Escenario '" + nombre + "' agregado exitosamente.\n");
        } else {
            System.out.println("✗ No se pudo agregar el escenario (puede que ya exista).\n");
        }
    }

    /**
     * Opción 2: Agregar actuación
     * Main CREA el objeto Actuacion y lo delega a Lollapalooza para que lo gestione
     */
    private static void agregarActuacion() {
        System.out.print("Ingrese el nombre de la banda: ");
        String nombreBanda = scanner.nextLine();

        System.out.print("Ingrese la duración en minutos: ");
        int duracion = leerEntero();

        System.out.print("Ingrese la fecha (ej: 2026-04-03): ");
        String fecha = scanner.nextLine();

        System.out.print("Ingrese la hora de inicio (ej: 20:30): ");
        String horaInicio = scanner.nextLine();

        // Seleccionar escenario usando método auxiliar
        Escenario escenarioSeleccionado = seleccionarEscenario();
        if (escenarioSeleccionado == null) {
            return; // No hay escenarios o selección cancelada
        }

        // CREACIÓN: Main crea el objeto Actuacion
        Actuacion nuevaActuacion = new Actuacion(nombreBanda, duracion, fecha, 
                                                   horaInicio, escenarioSeleccionado);
        
        // DELEGACIÓN: Lollapalooza valida y agrega la actuación
        boolean exito = festival.agregarActuacion(nuevaActuacion);
        
        if (exito) {
            System.out.println("✓ Actuación de '" + nombreBanda + "' agregada exitosamente.\n");
        } else {
            System.out.println("✗ No se pudo agregar la actuación (verifique los datos).\n");
        }
    }

    /**
     * Opción 3: Buscar actuaciones por día
     */
    private static void buscarActuacionesPorDia() {
        System.out.print("Ingrese la fecha a buscar (ej: 2026-04-03): ");
        String fecha = scanner.nextLine();

        ArrayList<Actuacion> resultados = festival.obtenerActuacionesPorDia(fecha);
        mostrarActuaciones(resultados, "Actuaciones del " + fecha, 
                          "No hay actuaciones registradas para la fecha: " + fecha);
    }

    /**
     * Opción 4: Buscar actuaciones por escenario
     */
    private static void buscarActuacionesPorEscenario() {
        Escenario escenarioSeleccionado = seleccionarEscenario();
        if (escenarioSeleccionado == null) {
            return; // No hay escenarios o selección cancelada
        }

        ArrayList<Actuacion> resultados = festival.obtenerActuacionesPorEscenario(escenarioSeleccionado);
        mostrarActuaciones(resultados, "Actuaciones en " + escenarioSeleccionado.getNombre(),
                          "No hay actuaciones registradas para este escenario.");
    }

    /**
     * Opción 5: Buscar actuaciones por banda
     */
    private static void buscarActuacionesPorBanda() {
        System.out.print("Ingrese el nombre de la banda a buscar: ");
        String nombre = scanner.nextLine();

        ArrayList<Actuacion> resultados = festival.buscarActuacionesPorBanda(nombre);
        mostrarActuaciones(resultados, "Actuaciones de " + nombre,
                          "No hay actuaciones registradas para: " + nombre);
    }

    /**
     * Opción 6: Mostrar todas las actuaciones
     */
    private static void mostrarTodasActuaciones() {
        ArrayList<Actuacion> todas = festival.obtenerTodasActuaciones();
        mostrarActuacionesNumeradas(todas, "TODAS LAS ACTUACIONES",
                                   "No hay actuaciones registradas aún.");
    }

    /**
     * Opción 7: Muestra todos los escenarios registrados en el festival.
     * Utiliza numeración para identificar cada escenario.
     * Si no hay escenarios, muestra un mensaje informativo.
     */
    private static void mostrarEscenarios() {
        ArrayList<Escenario> escenarios = festival.obtenerTodosEscenarios();
        
        if (escenarios.isEmpty()) {
            System.out.println("No hay escenarios registrados aún.\n");
        } else {
            System.out.println("=== ESCENARIOS DEL FESTIVAL ===");
            for (int i = 0; i < escenarios.size(); i++) {
                System.out.println((i + 1) + ". " + escenarios.get(i));
            }
            System.out.println();
        }
    }

    // ==================== MÉTODOS AUXILIARES DE PRESENTACIÓN ====================

    /**
     * Muestra una lista numerada de strings
     * Reutilizable para mostrar cualquier tipo de lista de nombres
     */
    private static void mostrarListaNumerada(ArrayList<String> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }

    /**
     * Muestra una lista de actuaciones con formato consistente
     * Maneja tanto el caso vacío como el caso con resultados
     * 
     * @param actuaciones Lista de actuaciones a mostrar
     * @param titulo Título de la sección (ej: "Actuaciones del 2026-03-28")
     * @param mensajeVacio Mensaje a mostrar si la lista está vacía
     */
    private static void mostrarActuaciones(ArrayList<Actuacion> actuaciones, 
                                           String titulo, String mensajeVacio) {
        if (actuaciones.isEmpty()) {
            System.out.println(mensajeVacio + "\n");
        } else {
            System.out.println("=== " + titulo + " ===");
            for (Actuacion a : actuaciones) {
                System.out.println("  • " + a);
            }
            System.out.println();
        }
    }

    /**
     * Muestra actuaciones con numeración (para listas completas)
     */
    private static void mostrarActuacionesNumeradas(ArrayList<Actuacion> actuaciones,
                                                    String titulo, String mensajeVacio) {
        if (actuaciones.isEmpty()) {
            System.out.println(mensajeVacio + "\n");
        } else {
            System.out.println("=== " + titulo + " ===");
            for (int i = 0; i < actuaciones.size(); i++) {
                System.out.println((i + 1) + ". " + actuaciones.get(i));
            }
            System.out.println();
        }
    }

    /**
     * Muestra escenarios disponibles y permite al usuario seleccionar uno.
     * Retorna el objeto Escenario seleccionado directamente.
     * 
     * @return El objeto Escenario seleccionado, o null si no hay escenarios o selección inválida
     */
    private static Escenario seleccionarEscenario() {
        ArrayList<Escenario> todosEscenarios = festival.obtenerTodosEscenarios();
        
        if (todosEscenarios.isEmpty()) {
            System.out.println("No hay escenarios registrados. Agregue uno primero.\n");
            return null;
        }

        System.out.println("\nEscenarios disponibles:");
        for (int i = 0; i < todosEscenarios.size(); i++) {
            System.out.println((i + 1) + ". " + todosEscenarios.get(i));
        }
        System.out.print("Seleccione el número del escenario: ");
        
        int seleccion = leerEntero() - 1;
        
        // Validar que la selección sea válida
        if (seleccion < 0 || seleccion >= todosEscenarios.size()) {
            System.out.println("Selección inválida.\n");
            return null;
        }
        
        return todosEscenarios.get(seleccion);
    }

    /**
     * Lee un número entero desde la entrada del usuario con manejo de errores.
     * Si el usuario ingresa texto inválido, solicita reintentar recursivamente.
     * 
     * @return El número entero ingresado por el usuario
     */
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
