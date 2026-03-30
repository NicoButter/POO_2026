import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Puerto puerto = new Puerto(3);

        Barco velero = new Velero("VEL123", 8.5, 2015, 2);
        Barco deportivo = new Deportivo("DEP456", 10.0, 2018, 300);
        Barco yate = new Yate("YAT789", 15.0, 2020, 500, 4);

        Amarre amarre1 = puerto.getAmarre(1);
        Amarre amarre2 = puerto.getAmarre(2);
        Amarre amarre3 = puerto.getAmarre(3);

        Alquiler alquiler1 = new Alquiler("Juan Perez", "12345678", LocalDate.of(2026, 3, 1), LocalDate.of(2026, 3, 10), amarre1, velero);
        Alquiler alquiler2 = new Alquiler("Ana Gomez", "87654321", LocalDate.of(2026, 3, 5), LocalDate.of(2026, 3, 12), amarre2, deportivo);
        Alquiler alquiler3 = new Alquiler("Luis Lopez", "11223344", LocalDate.of(2026, 3, 15), LocalDate.of(2026, 3, 20), amarre3, yate);

        amarre1.setAlquiler(alquiler1);
        amarre2.setAlquiler(alquiler2);
        amarre3.setAlquiler(alquiler3);

        System.out.println("Costo alquiler velero: $" + alquiler1.calcularCosto());
        System.out.println("Costo alquiler deportivo: $" + alquiler2.calcularCosto());
        System.out.println("Costo alquiler yate: $" + alquiler3.calcularCosto());
    }
}
