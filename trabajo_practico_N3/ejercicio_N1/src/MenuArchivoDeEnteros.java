import java.util.*;
import java.io.*;

public class MenuArchivoDeEnteros {
    private ArchivoDeEnteros archent;
    private Scanner sc;

    public MenuArchivoDeEnteros(ArchivoDeEnteros archent) {
        this.archent = archent;
        this.sc = new Scanner(System.in);
    }

    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ ARCHIVO DE ENTEROS ---");
            System.out.println("1. Almacenar secuencia de enteros");
            System.out.println("2. Recuperar y mostrar datos");
            System.out.println("3. Buscar un entero");
            System.out.println("4. Calcular promedio");
            System.out.println("5. Ordenar archivo");
            System.out.println("6. Agregar más elementos");
            System.out.println("7. Separar pares e impares");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            switch(opcion) {
                case 1:
                    System.out.print("¿Cuántos números querés guardar?: ");
                    int n = sc.nextInt();
                    List<Integer> nums = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Ingrese el número " + (i+1) + ": ");
                        nums.add(sc.nextInt());
                    }
                    try {
                        archent.almacenarSecuencia(nums);
                        System.out.println("Secuencia almacenada.");
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        List<Integer> lista = archent.recuperarSecuencia();
                        System.out.println("Números almacenados: " + lista);
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el número a buscar: ");
                    int buscar = sc.nextInt();
                    try {
                        boolean existe = archent.buscar(buscar);
                        System.out.println(existe ? "El número está en el archivo." : "No está ese número.");
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        double prom = archent.promedio();
                        System.out.println("Promedio: " + prom);
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        archent.ordenar();
                        System.out.println("Archivo ordenado.");
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("¿Cuántos números querés agregar?: ");
                    int m = sc.nextInt();
                    List<Integer> nuevos = new ArrayList<>();
                    for (int i = 0; i < m; i++) {
                        System.out.print("Ingrese el número " + (i+1) + ": ");
                        nuevos.add(sc.nextInt());
                    }
                    try {
                        archent.agregarElementos(nuevos);
                        System.out.println("Elementos agregados.");
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        archent.separarParesImpares("pares.dat", "impares.dat");
                        System.out.println("Separados en pares.dat e impares.dat");
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
