public class Amarre {
    private int posicion;
    private Alquiler alquiler;

    public Amarre(int posicion) {
        this.posicion = posicion;
    }

    public int getPosicion() { return posicion; }
    public Alquiler getAlquiler() { return alquiler; }
    public void setAlquiler(Alquiler alquiler) { this.alquiler = alquiler; }
}
