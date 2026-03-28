public class TestEjercicio10 {
    public static void main(String[] args) {
        // Crear algunos programas de radio y televisión
        Radio r1 = new Radio("LA PARADA", "María López", 1001, 60, "08:00", "Radio Uno", "DJ Pepe", 23);
        Radio r2 = new Radio("Mañanas en Vivo", "Juan Pérez", 1002, 120, "09:00", "FM Central", "Música S.A.", 15);

        Television t1 = new Television("Bailando Por Un Sueño", "Carlos Gómez", 2001, 180, "21:00", "Canal 5", 7, 3);
        Television t2 = new Television("Noticiero Central", "Ana Ruiz", 2002, 60, "20:00", "Canal 7", 4, 2);

        Programa[] programas = { r1, r2, t1, t2 };

        System.out.println("=== Espacio disponible para comerciales por programa ===\n");
        for (Programa p : programas) {
            System.out.println(p.getTitulo() + " (" + p.getClass().getSimpleName() + ") - " + p.espacioComercial());
        }

        System.out.println("\n=== Detalle completo de programas ===\n");
        for (Programa p : programas) {
            System.out.println(p);
        }
    }
}
