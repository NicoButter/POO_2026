/**
 * Clase Línea - Subclase de Figura
 * 
 * Una línea ES una figura con:
 * - Longitud definida
 * - Perímetro que se puede calcular (la longitud de la línea)
 * - NO tiene superficie (una línea es unidimensional)
 */
class Linea extends Figura {
    
    private double longitud;
    
    /**
     * Constructor de Línea
     */
    public Linea(double longitud, String colorFondo, String colorBorde) {
        super(colorFondo, colorBorde);
        this.longitud = longitud;
    }
    
    /**
     * Dibuja una línea usando guiones
     */
    @Override
    void dibujar() {
        System.out.println("─".repeat((int)longitud));
    }
    
    /**
     * Calcula el "perímetro" de la línea (que es su longitud)
     * Para una línea, el perímetro ES la longitud
     */
    @Override
    double perimetro() {
        return longitud;
    }
    
    /**
     * Una línea NO tiene superficie (es unidimensional)
     * Retorna -1 para indicar que no aplica
     */
    @Override
    public double superficie() {
        return -1;  // No aplica para una línea
    }
    
    // Getters y Setters
    public double getLongitud() {
        return longitud;
    }
    
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    
    @Override
    public String toString() {
        String sup = superficie() < 0 ? "N/A" : String.format("%.2f", superficie());
        return super.toString() + " [Longitud: " + longitud + 
               ", Perímetro: " + String.format("%.2f", perimetro()) + 
               ", Superficie: " + sup + "]";
    }
}
