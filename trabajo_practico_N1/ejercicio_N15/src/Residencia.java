public class Residencia extends Extrahotelero {
    private int cantHabitaciones;
    private boolean descuentoGremios;
    private boolean tieneCampoDeportivo;

    public Residencia(String nombre, String direccion, String localidad, String gerente, boolean privado, int metrosCuadrados, int cantHabitaciones, boolean descuentoGremios, boolean tieneCampoDeportivo) {
        super(nombre, direccion, localidad, gerente, privado, metrosCuadrados);
        this.cantHabitaciones = cantHabitaciones;
        this.descuentoGremios = descuentoGremios;
        this.tieneCampoDeportivo = tieneCampoDeportivo;
    }

    @Override
    public String toString() {
        return "Residencia - " + super.toString() + " | Habitaciones: " + cantHabitaciones + " | Descuento gremios: " + (descuentoGremios ? "Sí" : "No") + " | Campo deportivo: " + (tieneCampoDeportivo ? "Sí" : "No");
    }
}
