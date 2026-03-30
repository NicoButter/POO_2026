public class Oferta2Comercial {
    private Usuario usuario;
    private double descuento; // Ej: 0.15 para 15%
    public Oferta2Comercial(Usuario usuario, double descuento) {
        this.usuario = usuario;
        this.descuento = descuento;
    }
    public void conexion(int s) {
        usuario.conexion(s);
    }
    public double calculaFacturacion() {
        return usuario.calculaFacturación() * (1 - descuento);
    }
    public void reset() {
        usuario.reset();
    }
}
