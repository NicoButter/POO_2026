import java.util.*;
import java.io.*;

public class MenuArchivoPersonas {
    private ArchivoPersonas archPers;
    private Scanner sc;

    public MenuArchivoPersonas(ArchivoPersonas archPers) {
        this.archPers = archPers;
        this.sc = new Scanner(System.in);
    }

    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ ARCHIVO DE PERSONAS ---");
            System.out.println("1. Almacenar personas");
            System.out.println("2. Recuperar y mostrar personas");
            System.out.println("3. Buscar persona por DNI");
            System.out.println("4. Calcular altura promedio");
            System.out.println("5. Generar archivo de personas con altura > 1.60");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion) {
                case 1:
                    System.out.print("¿Cuántas personas querés guardar?: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    List<Persona> personas = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("DNI: ");
                        int dni = sc.nextInt();
                        System.out.print("Altura: ");
                        double altura = sc.nextDouble();
                        sc.nextLine();
                        personas.add(new Persona(nombre, dni, altura));
                    }
                    try {
                        archPers.almacenarPersonas(personas);
                        System.out.println("Personas almacenadas.");
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        List<Persona> lista = archPers.recuperarPersonas();
                        System.out.println("Personas almacenadas:");
                        for (Persona p : lista) {
                            System.out.println(p);
                        }
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Ingrese DNI a buscar: ");
                    int dniBuscar = sc.nextInt();
                    sc.nextLine();
                    try {
                        Persona encontrada = archPers.buscarPorDni(dniBuscar);
                        if (encontrada != null) {
                            System.out.println("Persona encontrada: " + encontrada);
                        } else {
                            System.out.println("No se encontró persona con ese DNI.");
                        }
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        double promedio = archPers.alturaPromedio();
                        System.out.printf("Altura promedio: %.2f\n", promedio);
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        archPers.generarArchivoAlturaMayorA(1.60, "auxiliar.dat");
                        System.out.println("Archivo 'auxiliar.dat' generado con personas de altura > 1.60 m.");
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Chau!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while(opcion != 0);
    }
}
