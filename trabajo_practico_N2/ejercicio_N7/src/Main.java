import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ IMPRESORA ---");
            System.out.println("1. Cargar tinta");
            System.out.println("2. Cargar papel");
            System.out.println("3. Conectar");
            System.out.println("4. Desconectar");
            System.out.println("5. Poner en línea");
            System.out.println("6. Poner fuera de línea");
            System.out.println("7. Imprimir documento");
            System.out.println("8. Estado de la impresora");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Ingrese cantidad de cargas de tinta a agregar: ");
                    double tinta = sc.nextDouble();
                    printer.cargarTinta(tinta);
                    System.out.println("Tinta cargada.");
                    break;
                case 2:
                    System.out.print("Ingrese cantidad de hojas a agregar: ");
                    int hojas = sc.nextInt();
                    printer.cargarPapel(hojas);
                    System.out.println("Papel cargado.");
                    break;
                case 3:
                    printer.conectar();
                    System.out.println("Impresora conectada.");
                    break;
                case 4:
                    printer.desconectar();
                    System.out.println("Impresora desconectada.");
                    break;
                case 5:
                    printer.on_line();
                    System.out.println("Impresora en línea.");
                    break;
                case 6:
                    printer.of_line();
                    System.out.println("Impresora fuera de línea.");
                    break;
                case 7:
                    System.out.print("Ingrese cantidad de hojas del documento: ");
                    int cant = sc.nextInt();
                    Document doc = new Document(cant);
                    try {
                        printer.print(doc);
                        System.out.println("Documento impreso correctamente.");
                    } catch (PrinterException e) {
                        System.out.println("Error: " + e.getMessage());
                        if (doc.getCantidadHojas() > 0) {
                            System.out.println("Hojas restantes sin imprimir: " + doc.getCantidadHojas());
                        }
                    }
                    break;
                case 8:
                    System.out.println("Tinta disponible: " + printer.getTinta());
                    System.out.println("Papel disponible: " + printer.getPapel());
                    System.out.println("Conectada: " + printer.isConectada());
                    System.out.println("En línea: " + printer.isEnLinea());
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
        System.out.println("Programa finalizado.");
    }
}
