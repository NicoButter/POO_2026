public class Camping extends Extrahotelero {
    private int capMaxCarpas;
    private int cantBanos;
    private boolean tieneRestaurante;

    public Camping(String nombre, String direccion, String localidad, String gerente, boolean privado, int metrosCuadrados, int capMaxCarpas, int cantBanos, boolean tieneRestaurante) {
        super(nombre, direccion, localidad, gerente, privado, metrosCuadrados);
        this.capMaxCarpas = capMaxCarpas;
        this.cantBanos = cantBanos;
        this.tieneRestaurante = tieneRestaurante;
    }

    @Override
    public String toString() {
        return "Camping - " + super.toString() + " | Carpas: " + capMaxCarpas + " | Baños: " + cantBanos + " | Restaurante: " + (tieneRestaurante ? "Sí" : "No");
    }
}
