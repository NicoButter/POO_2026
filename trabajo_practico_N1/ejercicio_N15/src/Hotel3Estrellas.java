public class Hotel3Estrellas extends Hotel {
    public Hotel3Estrellas(String nombre, String direccion, String localidad, String gerente, int cantHabitaciones, int numCamas, int cantPisos) {
        super(nombre, direccion, localidad, gerente, cantHabitaciones, numCamas, cantPisos);
        this.precioHabitacion = 50 + getCapacidad();
    }

    @Override
    public String toString() {
        return "Hotel 3* - " + super.toString() + " | Precio: $" + precioHabitacion;
    }
}
