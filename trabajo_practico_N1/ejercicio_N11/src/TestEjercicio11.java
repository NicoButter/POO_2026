public class TestEjercicio11 {
    public static void main(String[] args) {
        Diario d1 = new Diario(1001, "El Pueblo", "Juan Perez", "Editorial Pueblo", 24, 50.0, 2026, false, 10.0, 12, 8);
        Diario d2 = new Diario(1002, "La Mañana", "Ana Gomez", "Ma Editores", 32, 60.0, 2025, true, 8.5, 24, 9);

        Revista r1 = new Revista(2001, "Tecnología Hoy", "Laura Ruiz", "TecnoMedia", 120, 350.0, 2026, 3, 42, "Inteligencia Artificial");
        Revista r2 = new Revista(2002, "Moda y Estilo", "Mariana Lopez", "Glamour SA", 90, 280.0, 2024, 11, 158, "Tendencias Oto");

        System.out.println("=== Prueba Ejercicio 11: Publicaciones ===");
        System.out.println(d1.detalle());
        System.out.println(d2.detalle());
        System.out.println(r1.detalle());
        System.out.println(r2.detalle());
    }
}
