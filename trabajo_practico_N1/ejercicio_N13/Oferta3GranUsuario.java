import java.util.ArrayList;
import java.util.List;

public class Oferta3GranUsuario {
    private Usuario usuario;
    private List<Integer> conexiones = new ArrayList<>();
    public Oferta3GranUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void conexion(int s) {
        conexiones.add(s);
        usuario.conexion(s);
    }
    public double calculaFacturacion() {
        if (conexiones.isEmpty()) return 0;
        int max = conexiones.stream().max(Integer::compareTo).orElse(0);
        usuario.conexion(-max); // Descontar la más larga
        double fact = usuario.calculaFacturación();
        usuario.conexion(max); // Restaurar estado
        return fact;
    }
    public void reset() {
        usuario.reset();
        conexiones.clear();
    }
}
