public class Oferta1Residencial {
    private Usuario usuario;
    public Oferta1Residencial(Usuario usuario) {
        this.usuario = usuario;
    }
    public void conexion(int s) {
        int segundosFacturables = Math.max(0, s - 180); // 3 minutos = 180 segundos
        usuario.conexion(segundosFacturables);
    }
    public double calculaFacturacion() {
        return usuario.calculaFacturación();
    }
    public void reset() {
        usuario.reset();
    }
}
