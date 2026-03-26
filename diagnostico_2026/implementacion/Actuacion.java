package diagnostico_2026.implementacion;

public class Actuacion {

    private String nombreBanda;
    private int duracionMinutos;
    private String fecha;       // formato libre, p.ej. "2026-04-03"
    private String horaInicio;  // p.ej. "20:30"
    private Escenario escenario;

    public Actuacion(String nombreBanda, int duracionMinutos, String fecha, String horaInicio, Escenario escenario) {
        this.nombreBanda = nombreBanda;
        this.duracionMinutos = duracionMinutos;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.escenario = escenario;
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

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
