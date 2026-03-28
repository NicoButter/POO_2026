/**
 * Clase Radio - subclase de Programa
 * Incluye responsable de musicalización y minutos de propaganda disponibles
 */
public class Radio extends Programa {
    private String responsableMusicalizacion;
    private int minutosPropaganda; // minutos de comerciales

    public Radio(String titulo, String director, int codigo, int duracionMinutos, String horaInicio, String emisora, String responsableMusicalizacion, int minutosPropaganda) {
        super(titulo, director, codigo, duracionMinutos, horaInicio, emisora);
        this.responsableMusicalizacion = responsableMusicalizacion;
        this.minutosPropaganda = minutosPropaganda;
    }

    public String getResponsableMusicalizacion() { return responsableMusicalizacion; }
    public int getMinutosPropaganda() { return minutosPropaganda; }

    @Override
    public String espacioComercial() {
        return minutosPropaganda + " minutos de comerciales";
    }

    @Override
    public String toString() {
        return super.toString() + " (responsableMusicalizacion='" + responsableMusicalizacion + "', minutosPropaganda=" + minutosPropaganda + " min)";
    }
}
