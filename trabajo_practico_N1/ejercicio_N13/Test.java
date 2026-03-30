public class Test {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("12345678", "Juan Perez");
        Oferta1Residencial o1 = new Oferta1Residencial(u1);
        o1.conexion(200); // 200s (solo 20 facturables)
        o1.conexion(400); // 400s (220 facturables)
        System.out.println("Residencial: $" + o1.calculaFacturacion());
        o1.reset();

        Usuario u2 = new Usuario("87654321", "Ana Gomez");
        Oferta2Comercial o2 = new Oferta2Comercial(u2, 0.20); // 20% descuento
        o2.conexion(300);
        o2.conexion(500);
        System.out.println("Comercial: $" + o2.calculaFacturacion());
        o2.reset();

        Usuario u3 = new Usuario("11223344", "Luis Lopez");
        Oferta3GranUsuario o3 = new Oferta3GranUsuario(u3);
        o3.conexion(100);
        o3.conexion(400);
        o3.conexion(600); // la más larga
        System.out.println("Gran Usuario: $" + o3.calculaFacturacion());
        o3.reset();
    }
}
