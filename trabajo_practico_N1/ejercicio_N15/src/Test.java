public class Test {
    public static void main(String[] args) {
        SistemaAlojamientos sistema = new SistemaAlojamientos();

        sistema.agregarAlojamiento(new Hotel3Estrellas("Hotel Sol", "Av. Siempre Viva 123", "Bariloche", "Ana Perez", 30, 60, 3));
        sistema.agregarAlojamiento(new Hotel4Estrellas("Hotel Lago", "Calle 1", "Bariloche", "Luis Gomez", 40, 80, 4, "A", "Restó Lago", 55));
        sistema.agregarAlojamiento(new Hotel5Estrellas("Hotel Premium", "Ruta 40", "El Calafate", "Maria Ruiz", 50, 120, 5, "B", "Gourmet", 25, 2, 10, 5));
        sistema.agregarAlojamiento(new Camping("Camping Sur", "Ruta 3", "Bariloche", "Pedro Lopez", false, 2000, 100, 10, true));
        sistema.agregarAlojamiento(new Residencia("Residencia Norte", "Calle 2", "El Calafate", "Sofia Diaz", true, 1500, 20, true, false));

        System.out.println("--- Todos los alojamientos ---");
        for (Alojamiento a : sistema.getTodos()) {
            System.out.println(a);
        }

        System.out.println("\n--- Hoteles en Bariloche ---");
        for (Hotel h : sistema.getHotelesPorLocalidad("Bariloche")) {
            System.out.println(h);
        }

        System.out.println("\n--- Campings en Bariloche ---");
        for (Camping c : sistema.getCampingsPorLocalidad("Bariloche")) {
            System.out.println(c);
        }
    }
}
