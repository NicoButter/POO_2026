import java.util.Date;

public class ArchivoBinario extends Archivo {
    public ArchivoBinario(String nombre, String extension, int tamanio, Date fechaUltimaModificacion, boolean permisoLectura, boolean permisoEscritura) {
        super(nombre, extension, tamanio, fechaUltimaModificacion, permisoLectura, permisoEscritura);
    }
}
