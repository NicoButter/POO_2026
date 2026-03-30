import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler {
    private String nombreCliente;
    private String dniCliente;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Amarre amarre;
    private Barco barco;

    public Alquiler(String nombreCliente, String dniCliente, LocalDate fechaInicio, LocalDate fechaFin, Amarre amarre, Barco barco) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.amarre = amarre;
        this.barco = barco;
    }

    public double calcularCosto() {
        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin) + 1;
        double modulo = barco.getModulo();
        return dias * modulo * 2;
    }

    // Getters opcionales
    public String getNombreCliente() { return nombreCliente; }
    public String getDniCliente() { return dniCliente; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public Amarre getAmarre() { return amarre; }
    public Barco getBarco() { return barco; }
}
