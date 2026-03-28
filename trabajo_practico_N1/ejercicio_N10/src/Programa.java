/**
 * Clase abstracta Programa - base para programas de radio y televisión
 * Atributos comunes: título, director responsable, código único,
 * duración en minutos, hora de inicio (String) y nombre de emisora.
 */
public abstract class Programa {
    protected String titulo;
    protected String director;
    protected int codigo; // identificador único
    protected int duracionMinutos;
    protected String horaInicio; // formato simple, p.ej. "20:30"
    protected String emisora;

    public Programa(String titulo, String director, int codigo, int duracionMinutos, String horaInicio, String emisora) {
        this.titulo = titulo;
        this.director = director;
        this.codigo = codigo;
        this.duracionMinutos = duracionMinutos;
        this.horaInicio = horaInicio;
        this.emisora = emisora;
    }

    public String getTitulo() { return titulo; }
    public String getDirector() { return director; }
    public int getCodigo() { return codigo; }
    public int getDuracionMinutos() { return duracionMinutos; }
    public String getHoraInicio() { return horaInicio; }
    public String getEmisora() { return emisora; }

    // Método que devuelve una descripción del espacio disponible para comerciales
    // Implementado por subclases (radio/televisión)
    public abstract String espacioComercial();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[codigo=" + codigo + ", titulo='" + titulo + "', director='" + director + "', duracion=" + duracionMinutos + " min, inicio=" + horaInicio + ", emisora='" + emisora + "']";
    }
}
