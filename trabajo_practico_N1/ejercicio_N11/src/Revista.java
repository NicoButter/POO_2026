/**
 * Clase Revista - publicación periódica mensual
 */
public class Revista extends Escrita {
    private int mesPublicacion; // 1-12
    private int numero;
    private String tituloNotaTapa;

    public Revista(int codigo, String titulo, String responsableDireccion, String editor, int paginas, double precio, int anioPublicacion,
                   int mesPublicacion, int numero, String tituloNotaTapa) {
        super(codigo, titulo, responsableDireccion, editor, paginas, precio, anioPublicacion);
        this.mesPublicacion = mesPublicacion;
        this.numero = numero;
        this.tituloNotaTapa = tituloNotaTapa;
    }

    public int getMesPublicacion() { return mesPublicacion; }
    public int getNumero() { return numero; }
    public String getTituloNotaTapa() { return tituloNotaTapa; }

    @Override
    public String detalle() {
        return super.detalle() + " [Revista: mes=" + mesPublicacion + ", numero=" + numero + ", notaTapa='" + tituloNotaTapa + "']";
    }
}
