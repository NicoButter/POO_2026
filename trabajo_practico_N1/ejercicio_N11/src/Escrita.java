/**
 * Clase Escrita - publicaciones escritas (base para Diario y Revista)
 */
public abstract class Escrita extends Publicacion {
    protected String editor;
    protected int paginas;
    protected double precio;
    protected int anioPublicacion;

    public Escrita(int codigo, String titulo, String responsableDireccion, String editor, int paginas, double precio, int anioPublicacion) {
        super(codigo, titulo, responsableDireccion);
        this.editor = editor;
        this.paginas = paginas;
        this.precio = precio;
        this.anioPublicacion = anioPublicacion;
    }

    public String getEditor() { return editor; }
    public int getPaginas() { return paginas; }
    public double getPrecio() { return precio; }
    public int getAnioPublicacion() { return anioPublicacion; }

    @Override
    public String detalle() {
        return toString() + " (editor='" + editor + "', paginas=" + paginas + ", precio=" + precio + ", anio=" + anioPublicacion + ")";
    }
}
