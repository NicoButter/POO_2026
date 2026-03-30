public class Hotel5Estrellas extends Hotel {
    private String gimnasio; // "A" o "B"
    private String nombreRestaurante;
    private int capacidadRestaurante;
    private int cantSalonesConferencia;
    private int cantSuites;
    private int cantLimosinas;

    public Hotel5Estrellas(String nombre, String direccion, String localidad, String gerente, int cantHabitaciones, int numCamas, int cantPisos, String gimnasio, String nombreRestaurante, int capacidadRestaurante, int cantSalonesConferencia, int cantSuites, int cantLimosinas) {
        super(nombre, direccion, localidad, gerente, cantHabitaciones, numCamas, cantPisos);
        this.gimnasio = gimnasio;
        this.nombreRestaurante = nombreRestaurante;
        this.capacidadRestaurante = capacidadRestaurante;
        this.cantSalonesConferencia = cantSalonesConferencia;
        this.cantSuites = cantSuites;
        this.cantLimosinas = cantLimosinas;
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
        // Limosinas
        precio += 15 * cantLimosinas;
        return precio;
    }

    @Override
    public String toString() {
        return "Hotel 5* - " + super.toString() + " | Gimnasio: " + gimnasio + " | Restaurante: " + nombreRestaurante + " (cap: " + capacidadRestaurante + ") | Salones: " + cantSalonesConferencia + " | Suites: " + cantSuites + " | Limosinas: " + cantLimosinas + " | Precio: $" + precioHabitacion;
    }
}
