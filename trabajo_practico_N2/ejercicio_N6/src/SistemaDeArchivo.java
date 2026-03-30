import java.util.Vector;

public class SistemaDeArchivo {
    private String idDiscoDuro;
    private int capacidad;
    private Vector<Archivo> archivos;

    public SistemaDeArchivo(String idDiscoDuro, int capacidad) {
        this.idDiscoDuro = idDiscoDuro;
        this.capacidad = capacidad;
        this.archivos = new Vector<>();
    }

    public void agregarArchivo(Archivo f) {
        archivos.add(f);
    }

    public boolean eliminarArchivo(String nombre) {
        return archivos.removeIf(f -> f.getNombre().equals(nombre));
    }

    public void listarArchivo() {
        for (Archivo f : archivos) {
            try {
                InterfazGrafica.mostrar(f);
            } catch (Error1 e1) {
                InterfazGrafica.mensajeError(e1.getMessage());
                // Continúa mostrando los siguientes archivos
            } catch (Error2 e2) {
                InterfazGrafica.mensajeError(e2.getMessage());
                break; // Detiene la ejecución
            }
        }
    }
}
