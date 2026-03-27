package diagnostico_2026.implementacion;

/**
 * Clase que representa una banda musical que participa en el festival.
 * 
 * Esta es una clase modelo (POJO) que almacena información detallada sobre 
 * una banda musical: su nombre, integrantes, género musical, país de origen 
 * y año de formación.
 * 
 * Nota: En esta implementación, la clase Banda es auxiliar. Sin embargo, 
 * en una versión más completa del sistema, podría vincularse directamente 
 * con las actuaciones para reutilizar la información de la banda.
 * 
 * @author Nicolás Butterfield
 * @version 1.0
 */
public class Banda {

    /** Nombre de la banda */
    private String nombre;
    
    /** Lista de integrantes de la banda. Ej: "Liam Gallagher, Noel Gallagher" */
    private String integrantes;
    
    /** Género o estilo musical de la banda. Ej: Rock, Pop, Indie, Electrónica, etc. */
    private String estiloMusical;
    
    /** País de origen de la banda */
    private String paisOrigen;
    
    /** Año en que se formó la banda */
    private int anioFormacion;

    /**
     * Crea una banda sin información inicial (constructor vacío).
     * Útil cuando necesitas crear un objeto y luego completar sus datos con setters.
     */
    public Banda() {}

    /**
     * Crea una nueva banda con la información básica.
     * 
     * @param nombre          Nombre de la banda
     * @param integrantes     Integrantes de la banda
     * @param estiloMusical   Estilo/género musical
     */
    public Banda(String nombre, String integrantes, String estiloMusical) {
        this.nombre = nombre;
        this.integrantes = integrantes;
        this.estiloMusical = estiloMusical;
    }

    /**
     * Crea una nueva banda con información completa.
     * 
     * @param nombre          Nombre de la banda
     * @param integrantes     Integrantes de la banda
     * @param estiloMusical   Estilo/género musical
     * @param paisOrigen      País de origen de la banda
     * @param anioFormacion   Año en que se formó la banda
     */
    public Banda(String nombre, String integrantes, String estiloMusical, String paisOrigen, int anioFormacion) {
        this.nombre = nombre;
        this.integrantes = integrantes;
        this.estiloMusical = estiloMusical;
        this.paisOrigen = paisOrigen;
        this.anioFormacion = anioFormacion;
    }

    /** @return El nombre de la banda */
    public String getNombre() {
        return nombre;
    }

    /** @param nombre El nombre de la banda a establecer */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** @return Los integrantes de la banda */
    public String getIntegrantes() {
        return integrantes;
    }

    /** @param integrantes Los integrantes de la banda a establecer */
    public void setIntegrantes(String integrantes) {
        this.integrantes = integrantes;
    }

    /** @return El estilo musical de la banda */
    public String getEstiloMusical() {
        return estiloMusical;
    }

    /** @param estiloMusical El estilo musical a establecer */
    public void setEstiloMusical(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    /** @return El país de origen de la banda */
    public String getPaisOrigen() {
        return paisOrigen;
    }

    /** @param paisOrigen El país de origen a establecer */
    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    /** @return El año de formación de la banda */
    public int getAnioFormacion() {
        return anioFormacion;
    }

    /** @param anioFormacion El año de formación a establecer */
    public void setAnioFormacion(int anioFormacion) {
        this.anioFormacion = anioFormacion;
    }

    /**
     * Representación en texto de la banda con todos sus atributos.
     * Formato: Banda{nombre='...', integrantes='...', estiloMusical='...', paisOrigen='...', anioFormacion=XXXX}
     * 
     * @return String con información completa de la banda
     */
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