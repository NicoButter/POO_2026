public abstract class Hotel extends Alojamiento {
    protected int cantHabitaciones;
    protected int numCamas;
    protected int cantPisos;
    protected double precioHabitacion;

    public Hotel(String nombre, String direccion, String localidad, String gerente, int cantHabitaciones, int numCamas, int cantPisos) {
        super(nombre, direccion, localidad, gerente);
        this.cantHabitaciones = cantHabitaciones;
        this.numCamas = numCamas;
        this.cantPisos = cantPisos;
    }

    public int getCapacidad() {
        return numCamas;
    }

    public double getPrecioHabitacion() {
        return precioHabitacion;
    }
}
