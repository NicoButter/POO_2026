public class Usuario {
    private String nombre, dni;
    private int cuenta;
    public Usuario(String d, String n) {
        nombre = n;
        dni = d;
        cuenta = 0;
    }
    public void conexion(int s) {
        cuenta = cuenta + s;
    }
    public double calculaFacturación() {
        return cuenta * 0.32;
    }
    public void reset() {
        cuenta = 0;
    }
}
