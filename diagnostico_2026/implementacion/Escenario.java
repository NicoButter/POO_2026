package diagnostico_2026.implementacion;

public class Escenario {

    private String nombre;
    private String ubicacion;      // Ej: "Zona A", "Sur", etc.
    private int capacidad;         // Capacidad de público

    public Escenario() {}

    public Escenario(String nombre) {
        this.nombre = nombre;
    }

    public Escenario(String nombre, String ubicacion, int capacidad) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Escenario{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Escenario escenario = (Escenario) obj;
        return nombre != null && nombre.equalsIgnoreCase(escenario.nombre);
    }

    @Override
    public int hashCode() {
        return nombre != null ? nombre.toLowerCase().hashCode() : 0;
    }
}
