package diagnostico_2026.implementacion;

/**
 * Clase que representa un escenario del festival.
 * 
 * Un escenario es un lugar físico del festival donde las bandas presentan sus actuaciones.
 * Cada escenario tiene un nombre único, una ubicación dentro del festival y una capacidad
 * máxima de público que puede albergar.
 * 
 * Por ejemplo: "Escenario Principal en Zona Norte con capacidad para 50,000 personas"
 * 
 * @author Nicolás Butterfield
 * @version 1.0
 */
public class Escenario {

    /** Nombre identificador del escenario (ej: "Escenario Principal") */
    private String nombre;
    
    /** Ubicación del escenario dentro del festival (ej: "Zona A", "Zona Norte") */
    private String ubicacion;
    
    /** Capacidad máxima de público que puede albergar el escenario */
    private int capacidad;

    /**
     * Crea un escenario vacío. Útil cuando necesitas completar los datos después.
     */
    public Escenario() {}

    /**
     * Crea un escenario solo con el nombre.
     * @param nombre El nombre del escenario
     */
    public Escenario(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Crea un escenario con toda la información.
     * @param nombre    El nombre del escenario
     * @param ubicacion La ubicación del escenario dentro del festival
     * @param capacidad La capacidad máxima de público
     */
    public Escenario(String nombre, String ubicacion, int capacidad) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    /** @return El nombre del escenario */
    public String getNombre() {
        return nombre;
    }

    /** @param nombre El nombre del escenario a establecer */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** @return La ubicación del escenario */
    public String getUbicacion() {
        return ubicacion;
    }

    /** @param ubicacion La ubicación del escenario a establecer */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /** @return La capacidad máxima del escenario */
    public int getCapacidad() {
        return capacidad;
    }

    /** @param capacidad La capacidad del escenario a establecer */
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

    /**
     * Compara dos escenarios por su nombre (sin importar mayúsculas/minúsculas).
     * Dos escenarios son iguales si tienen el mismo nombre.
     * 
     * @param obj El objeto a comparar
     * @return true si tienen el mismo nombre, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Escenario escenario = (Escenario) obj;
        return nombre != null && nombre.equalsIgnoreCase(escenario.nombre);
    }

    /**
     * Genera un código hash basado en el nombre del escenario.
     * Todos los escenarios con el mismo nombre tendrán el mismo hash.
     * 
     * @return El código hash del escenario
     */
    @Override
    public int hashCode() {
        return nombre != null ? nombre.toLowerCase().hashCode() : 0;
    }
}
