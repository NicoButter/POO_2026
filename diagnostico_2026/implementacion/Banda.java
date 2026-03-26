package diagnostico_2026.implementacion;

public class Banda {

    private String nombre;
    private String integrantes;       // Ej: "Liam Gallagher, Noel Gallagher..."
    private String estiloMusical;     // Rock, Pop, Indie, Electrónica, etc.
    private String paisOrigen;
    private int anioFormacion;

    public Banda() {}

    public Banda(String nombre, String integrantes, String estiloMusical) {
        this.nombre = nombre;
        this.integrantes = integrantes;
        this.estiloMusical = estiloMusical;
    }

    public Banda(String nombre, String integrantes, String estiloMusical, String paisOrigen, int anioFormacion) {
        this.nombre = nombre;
        this.integrantes = integrantes;
        this.estiloMusical = estiloMusical;
        this.paisOrigen = paisOrigen;
        this.anioFormacion = anioFormacion;
    }

    // Getters y Setters + toString()
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(String integrantes) {
        this.integrantes = integrantes;
    }

    public String getEstiloMusical() {
        return estiloMusical;
    }

    public void setEstiloMusical(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public int getAnioFormacion() {
        return anioFormacion;
    }

    public void setAnioFormacion(int anioFormacion) {
        this.anioFormacion = anioFormacion;
    }

    @Override
    public String toString() {
        return "Banda{" +
            "nombre='" + nombre + '\'' +
            ", integrantes='" + integrantes + '\'' +
            ", estiloMusical='" + estiloMusical + '\'' +
            ", paisOrigen='" + paisOrigen + '\'' +
            ", anioFormacion=" + anioFormacion +
            '}';
    }
}