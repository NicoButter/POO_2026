import java.util.Date;

public class ArchivoTexto extends Archivo {
    public ArchivoTexto(String nombre, String extension, int tamanio, Date fechaUltimaModificacion, boolean permisoLectura, boolean permisoEscritura) {
        super(nombre, extension, tamanio, fechaUltimaModificacion, permisoLectura, permisoEscritura);
    }
}
