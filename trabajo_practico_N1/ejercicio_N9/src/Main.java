import java.util.Scanner;

/**
 * Clase Main - Menú Principal
 * 
 * Proporciona un menú interactivo para manipular la pizarra y sus figuras.
 */
public class Main {
    
    private static Pizarra pizarra;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        pizarra = new Pizarra("Blanco");
        
        int opcion;
        do {
            mostrarMenuPrincipal();
            System.out.print("Selecciona una opción: ");
            opcion = leerEntero();
            
            switch (opcion) {
                case 1:
                    agregarFigura();
                    break;
                case 2:
                    eliminarFigura();
                    break;
                case 3:
                    limpiarPizarra();
                    break;
                case 4:
                    calcularSuperficie();
                    break;
                case 5:
                    calcularPerimetro();
                    break;
                case 6:
                    cambiarColor();
                    break;
                case 7:
                    cambiarColorFondoPizarra();
                    break;
                case 8:
                    dibujarFiguras();
                    break;
                case 9:
                    mostrarFiguras();
                    break;
                case 10:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("✗ Opción inválida");
            }
            System.out.println();
        } while (opcion != 10);
        
        scanner.close();
    }
    
    /**
     * Muestra el menú principal
     */
    private static void mostrarMenuPrincipal() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         MENÚ PRINCIPAL - PIZARRA      ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1. Agregar una figura                  ║");
        System.out.println("║ 2. Eliminar una figura                 ║");
        System.out.println("║ 3. Limpiar la pizarra                  ║");
        System.out.println("║ 4. Calcular superficie total           ║");
        System.out.println("║ 5. Calcular perímetro total            ║");
        System.out.println("║ 6. Cambiar color de una figura         ║");
        System.out.println("║ 7. Cambiar color de fondo de pizarra   ║");
        System.out.println("║ 8. Dibujar figuras                     ║");
        System.out.println("║ 9. Mostrar figuras                     ║");
        System.out.println("║ 10. Salir                              ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
    
    /**
     * Submenú para agregar una figura
     */
    private static void agregarFigura() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║      AGREGAR UNA FIGURA                ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║ 1. Rectángulo                          ║");
        System.out.println("║ 2. Circunferencia                      ║");
        System.out.println("║ 3. Línea                               ║");
        System.out.println("║ 4. Cancelar                            ║");
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.print("Selecciona el tipo de figura: ");
        int tipo = leerEntero();
        
        switch (tipo) {
            case 1:
                agregarRectangulo();
                break;
            case 2:
                agregarCircunferencia();
                break;
            case 3:
                agregarLinea();
                break;
            case 4:
                System.out.println("Cancelado");
                break;
            default:
                System.out.println("✗ Opción inválida");
        }
    }
    
    /**
     * Agrega un rectángulo a la pizarra
     */
    private static void agregarRectangulo() {
        System.out.print("Ingresa la base: ");
        double base = leerDouble();
        System.out.print("Ingresa la altura: ");
        double altura = leerDouble();
        System.out.print("Ingresa el color de fondo (ej: Rojo, Azul): ");
        scanner.nextLine();
        String colorFondo = scanner.nextLine();
        System.out.print("Ingresa el color de borde (ej: Negro, Verde): ");
        String colorBorde = scanner.nextLine();
        
        Rectangulo rect = new Rectangulo(base, altura, colorFondo, colorBorde);
        pizarra.agregarFigura(rect);
    }
    
    /**
     * Agrega una circunferencia a la pizarra
     */
    private static void agregarCircunferencia() {
        System.out.print("Ingresa el radio: ");
        double radio = leerDouble();
        System.out.print("Ingresa el color de fondo (ej: Amarillo, Naranja): ");
        scanner.nextLine();
        String colorFondo = scanner.nextLine();
        System.out.print("Ingresa el color de borde (ej: Negro, Blanco): ");
        String colorBorde = scanner.nextLine();
        
        Circunferencia circ = new Circunferencia(radio, colorFondo, colorBorde);
        pizarra.agregarFigura(circ);
    }
    
    /**
     * Agrega una línea a la pizarra
     */
    private static void agregarLinea() {
        System.out.print("Ingresa la longitud: ");
        double longitud = leerDouble();
        System.out.print("Ingresa el color (ej: Morado, Gris): ");
        scanner.nextLine();
        String color = scanner.nextLine();
        
        Linea linea = new Linea(longitud, color, color);
        pizarra.agregarFigura(linea);
    }
    
    /**
     * Elimina una figura de la pizarra
     */
    private static void eliminarFigura() {
        pizarra.mostrarFiguras();
        if (pizarra.cantidadFiguras() == 0) return;
        
        System.out.print("Ingresa el número de la figura a eliminar: ");
        int indice = leerEntero() - 1;
        pizarra.eliminarFigura(indice);
    }
    
    /**
     * Limpia la pizarra
     */
    private static void limpiarPizarra() {
        System.out.print("¿Estás seguro? (s/n): ");
        scanner.nextLine();
        String respuesta = scanner.nextLine().toLowerCase();
        if (respuesta.equals("s")) {
            pizarra.limpiar();
        }
    }
    
    /**
     * Calcula y muestra la superficie total
     */
    private static void calcularSuperficie() {
        if (pizarra.cantidadFiguras() == 0) {
            System.out.println("La pizarra está vacía");
            return;
        }
        
        double superficieTotal = pizarra.calcularSuperficieTotal();
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║     CÁLCULO DE SUPERFICIE TOTAL        ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ Figuras en la pizarra: " + pizarra.cantidadFiguras());
        System.out.println("║ Superficie total: " + String.format("%.2f", superficieTotal) + " u²");
        System.out.println("╚════════════════════════════════════════╝");
    }
    
    /**
     * Calcula y muestra el perímetro total
     */
    private static void calcularPerimetro() {
        if (pizarra.cantidadFiguras() == 0) {
            System.out.println("La pizarra está vacía");
            return;
        }
        
        double perimetroTotal = pizarra.calcularPerimetroTotal();
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║     CÁLCULO DE PERÍMETRO TOTAL         ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ Figuras en la pizarra: " + pizarra.cantidadFiguras());
        System.out.println("║ Perímetro total: " + String.format("%.2f", perimetroTotal) + " u");
        System.out.println("╚════════════════════════════════════════╝");
    }
    
    /**
     * Cambia el color de una figura
     */
    private static void cambiarColor() {
        pizarra.mostrarFiguras();
        if (pizarra.cantidadFiguras() == 0) return;
        
        System.out.print("Ingresa el número de la figura: ");
        int indice = leerEntero() - 1;
        
        if (indice < 0 || indice >= pizarra.cantidadFiguras()) {
            System.out.println("✗ Índice inválido");
            return;
        }
        
        System.out.println("\n1. Cambiar color de fondo");
        System.out.println("2. Cambiar color de borde");
        System.out.print("Selecciona: ");
        int opcion = leerEntero();
        
        System.out.print("Ingresa el nuevo color: ");
        scanner.nextLine();
        String color = scanner.nextLine();
        
        if (opcion == 1) {
            pizarra.cambiarColorFondo(indice, color);
        } else if (opcion == 2) {
            pizarra.cambiarColorBorde(indice, color);
        }
    }
    
    /**
     * Cambia el color de fondo de la pizarra
     */
    private static void cambiarColorFondoPizarra() {
        System.out.print("Ingresa el nuevo color de fondo: ");
        scanner.nextLine();
        String color = scanner.nextLine();
        pizarra.setColorFondoPizarra(color);
    }
    
    /**
     * Dibuja todas las figuras
     */
    private static void dibujarFiguras() {
        pizarra.dibujarTodasLasFiguras();
    }
    
    /**
     * Muestra todas las figuras
     */
    private static void mostrarFiguras() {
        pizarra.mostrarFiguras();
    }
    
    /**
     * Lee un entero del scanner
     */
    private static int leerEntero() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }
    
    /**
     * Lee un double del scanner
     */
    private static double leerDouble() {
        try {
            return scanner.nextDouble();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }
}
