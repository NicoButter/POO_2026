public class Hotel4Estrellas extends Hotel {
    private String gimnasio; // "A" o "B"
    private String nombreRestaurante;
    private int capacidadRestaurante;

    public Hotel4Estrellas(String nombre, String direccion, String localidad, String gerente, int cantHabitaciones, int numCamas, int cantPisos, String gimnasio, String nombreRestaurante, int capacidadRestaurante) {
        super(nombre, direccion, localidad, gerente, cantHabitaciones, numCamas, cantPisos);
        this.gimnasio = gimnasio;
        this.nombreRestaurante = nombreRestaurante;
        this.capacidadRestaurante = capacidadRestaurante;
        this.precioHabitacion = calcularPrecioHabitacion();
    }

    private double calcularPrecioHabitacion() {
        double precio = 50 + getCapacidad();
        // Restaurante
        if (capacidadRestaurante < 30) precio += 10;
        else if (capacidadRestaurante <= 50) precio += 30;
        else precio += 50;
        // Gimnasio
        if ("A".equalsIgnoreCase(gimnasio)) precio += 50;
        else precio += 30;
        return precio;
    }

    @Override
    public String toString() {
        return "Hotel 4* - " + super.toString() + " | Gimnasio: " + gimnasio + " | Restaurante: " + nombreRestaurante + " (cap: " + capacidadRestaurante + ") | Precio: $" + precioHabitacion;
    }
}
