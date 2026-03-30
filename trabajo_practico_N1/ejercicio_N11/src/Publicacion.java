/**
 * Clase abstracta Publicacion - base para publicaciones impresas y gráficas
 */
public abstract class Publicacion {
    protected int codigo;
    protected String titulo;
    protected String responsableDireccion;

    public Publicacion(int codigo, String titulo, String responsableDireccion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.responsableDireccion = responsableDireccion;
    }

    public int getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public String getResponsableDireccion() { return responsableDireccion; }

    public abstract String detalle();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[codigo=" + codigo + ", titulo='" + titulo + "', responsable='" + responsableDireccion + "']";
    }
}
