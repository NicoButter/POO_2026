import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataBase db = null;
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ BASE DE DATOS ---");
            System.out.println("1. Crear Base de Datos");
            System.out.println("2. Abrir Base de Datos");
            System.out.println("3. Cerrar Base de Datos");
            System.out.println("4. Agregar Tabla");
            System.out.println("5. Eliminar Tabla");
            System.out.println("6. Listar Tablas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int op = sc.nextInt();
            sc.nextLine();
            try {
                switch (op) {
                    case 1:
                        System.out.print("Ingrese nombre de la base de datos: ");
                        String nombre = sc.nextLine();
                        db = new DataBase(nombre);
                        System.out.println("Base de datos creada.");
                        break;
                    case 2:
                        if (db == null) {
                            System.out.println("Primero cree una base de datos.");
                        } else {
                            db.open();
                            System.out.println("Base de datos abierta.");
                        }
                        break;
                    case 3:
                        if (db == null) {
                            System.out.println("Primero cree una base de datos.");
                        } else {
                            db.close();
                            System.out.println("Base de datos cerrada.");
                        }
                        break;
                    case 4:
                        if (db == null) {
                            System.out.println("Primero cree una base de datos.");
                        } else {
                            System.out.print("Ingrese nombre de la tabla: ");
                            String tname = sc.nextLine();
                            db.createTable(new Table(tname));
                            System.out.println("Tabla agregada.");
                        }
                        break;
                    case 5:
                        if (db == null) {
                            System.out.println("Primero cree una base de datos.");
                        } else {
                            System.out.print("Ingrese nombre de la tabla a eliminar: ");
                            String tname = sc.nextLine();
                            db.removeTable(tname);
                            System.out.println("Tabla eliminada.");
                        }
                        break;
                    case 6:
                        if (db == null) {
                            System.out.println("Primero cree una base de datos.");
                        } else {
                            db.listTables();
                        }
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (DBException | TableException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}
