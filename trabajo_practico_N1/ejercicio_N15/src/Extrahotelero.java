public abstract class Extrahotelero extends Alojamiento {
    protected boolean privado;
    protected int metrosCuadrados;

    public Extrahotelero(String nombre, String direccion, String localidad, String gerente, boolean privado, int metrosCuadrados) {
        super(nombre, direccion, localidad, gerente);
        this.privado = privado;
        this.metrosCuadrados = metrosCuadrados;
    }
}
