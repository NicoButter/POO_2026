import java.util.Date;

public abstract class Archivo {
    private String nombre;
    private String extension;
    private int tamanio;
    private Date fechaUltimaModificacion;
    private boolean permisoLectura;
    private boolean permisoEscritura;

    public Archivo(String nombre, String extension, int tamanio, Date fechaUltimaModificacion, boolean permisoLectura, boolean permisoEscritura) {
        this.nombre = nombre;
        this.extension = extension;
        this.tamanio = tamanio;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.permisoLectura = permisoLectura;
        this.permisoEscritura = permisoEscritura;
    }

    public String getNombre() { return nombre; }
    public String getExtension() { return extension; }
    public int getTamanio() { return tamanio; }
    public Date getFechaUltimaModificacion() { return fechaUltimaModificacion; }
    public boolean isPermisoLectura() { return permisoLectura; }
    public boolean isPermisoEscritura() { return permisoEscritura; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setExtension(String extension) { this.extension = extension; }
    public void setTamanio(int tamanio) { this.tamanio = tamanio; }
    public void setFechaUltimaModificacion(Date fechaUltimaModificacion) { this.fechaUltimaModificacion = fechaUltimaModificacion; }
    public void setPermisoLectura(boolean permisoLectura) { this.permisoLectura = permisoLectura; }
    public void setPermisoEscritura(boolean permisoEscritura) { this.permisoEscritura = permisoEscritura; }

    @Override
    public String toString() {
        return nombre + "." + extension + " (" + tamanio + " bytes, modificado: " + fechaUltimaModificacion + ", R:" + permisoLectura + ", W:" + permisoEscritura + ")";
    }
}
