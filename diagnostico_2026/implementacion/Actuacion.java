package diagnostico_2026.implementacion;

/**
 * Clase que representa una actuación de una banda en el festival Lollapalooza.
 * 
 * Una actuación es el evento concreto de una banda tocando en un escenario específico,
 * en una fecha y hora determinada. Contiene toda la información necesaria para saber
 * cuándo, dónde y por cuánto tiempo toca una banda.
 * 
 * Por ejemplo: "Foo Fighters tocando en el Escenario Principal el 28/03/2026 a las 21:00 por 90 minutos"
 * 
 * @author Nicolás Butterfield
 * @version 1.0
 * @see Escenario
 */
public class Actuacion {

    /** Nombre de la banda que está actuando */
    private String nombreBanda;
    
    /** Duración de la presentación en minutos */
    private int duracionMinutos;
    
    /** Fecha de la actuación en formato "YYYY-MM-DD" (ej: "2026-04-03") */
    private String fecha;
    
    /** Hora de inicio en formato "HH:MM" (ej: "20:30") */
    private String horaInicio;
    
    /** Referencia al escenario donde ocurre esta actuación */
    private Escenario escenario;

    /**
     * Crea una nueva actuación con todos los datos necesarios.
     * 
     * @param nombreBanda    El nombre de la banda que actúa
     * @param duracionMinutos La duración de la presentación en minutos
     * @param fecha          La fecha en formato "YYYY-MM-DD"
     * @param horaInicio     La hora de inicio en formato "HH:MM"
     * @param escenario      El escenario donde ocurre la actuación
     */
    public Actuacion(String nombreBanda, int duracionMinutos, String fecha, String horaInicio, Escenario escenario) {
        this.nombreBanda = nombreBanda;
        this.duracionMinutos = duracionMinutos;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.escenario = escenario;
    }

    /**
     * Obtiene el nombre de la banda que toca.
     * @return El nombre de la banda
     */
    public String getNombreBanda() {
        return nombreBanda;
    }

    /**
     * Obtiene la duración de la presentación.
     * @return Duración en minutos
     */
    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    /**
     * Obtiene la fecha de la actuación.
     * @return Fecha en formato "YYYY-MM-DD"
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Obtiene la hora de inicio de la actuación.
     * @return Hora en formato "HH:MM"
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     * Obtiene el escenario donde ocurre esta actuación.
     * @return El objeto Escenario asignado a esta actuación
     */
    public Escenario getEscenario() {
        return escenario;
    }

    @Override
    public String toString() {
        return "Actuacion{" +
                "nombreBanda='" + nombreBanda + '\'' +
                ", duracionMinutos=" + duracionMinutos +
                ", fecha='" + fecha + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", escenario=" + (escenario != null ? escenario.getNombre() : "N/A") +
                '}';
    }
}
