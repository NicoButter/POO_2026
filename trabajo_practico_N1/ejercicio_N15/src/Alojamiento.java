public abstract class Alojamiento {
    protected String nombre;
    protected String direccion;
    protected String localidad;
    protected String gerente;

    public Alojamiento(String nombre, String direccion, String localidad, String gerente) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.gerente = gerente;
    }

    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getLocalidad() { return localidad; }
    public String getGerente() { return gerente; }

    @Override
    public String toString() {
        return nombre + " | " + direccion + " | " + localidad + " | Gerente: " + gerente;
    }
}
