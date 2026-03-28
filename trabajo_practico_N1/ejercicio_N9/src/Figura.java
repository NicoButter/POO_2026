/**
 * Clase abstracta Figura
 * 
 * Justificación de la elección:
 * ============================
 * Se utilizó una CLASE ABSTRACTA porque:
 * 
 * 1. TIENE ESTADO: Las figuras comparten atributos comunes (colorFondo, colorBorde)
 *    - Las interfaces no pueden tener atributos con estado
 * 
 * 2. IMPLEMENTACIÓN COMÚN: Todos los métodos relacionados con colores pueden 
 *    implementarse de manera idéntica en todas las subclases
 * 
 * 3. MÉTODOS ABSTRACTOS: Algunos métodos (dibujar, perimetro) DEBEN ser 
 *    implementados obligatoriamente por cada subclase porque la lógica es diferente
 * 
 * 4. SUPERFICIF OPCIONAL: No todas las figuras tienen superficie (ej: Línea)
 *    - Solución: hacer superficie() no abstracto con una implementación por defecto
 *    - O declararlo abstracto pero solo implementarlo en quien tiene sentido
 * 
 * 5. NO ES INTERFACE porque:
 *    - Figura NO es un "contrato puro de comportamiento"
 *    - Figura ES una "categoría de objetos" con características compartidas
 *    - Las figuras comparten responsabilidades reales (gestión de colores)
 * 
 * NO ES CLASE SIMPLE porque:
 *    - Figura no puede ser instanciada directamente
 *    - Una "figura genérica" sin tipo específico no tiene sentido
 */
abstract class Figura {
    
    // Atributos comunes a todas las figuras
    protected String colorFondo;
    protected String colorBorde;
    
    /**
     * Constructor de Figura
     */
    public Figura(String colorFondo, String colorBorde) {
        this.colorFondo = colorFondo;
        this.colorBorde = colorBorde;
    }
    
    // ==================== MÉTODOS ABSTRACTOS ====================
    
    /**
     * Dibuja la figura. Cada subclase implementa su propio dibujo.
     */
    abstract void dibujar();
    
    /**
     * Calcula el perímetro de la figura.
     * OBLIGATORIO para todas las figuras.
     * @return el perímetro de la figura
     */
    abstract double perimetro();
    
    /**
     * Calcula la superficie de la figura.
     * NO TODAS las figuras tienen superficie (ej: Línea).
     * Por eso NO es abstracto. Retorna -1 si no aplica.
     * @return la superficie de la figura, o -1 si no aplica
     */
    public double superficie() {
        return -1;  // -1 indica que no aplica para esta figura
    }
    
    // ==================== MÉTODOS CONCRETOS ====================
    
    /**
     * Establece el color de fondo
     */
    public void setColorFondo(String color) {
        this.colorFondo = color;
    }
    
    /**
     * Establece el color de borde
     */
    public void setColorBorde(String color) {
        this.colorBorde = color;
    }
    
    /**
     * Obtiene el color de fondo
     */
    public String getColorFondo() {
        return colorFondo;
    }
    
    /**
     * Obtiene el color de borde
     */
    public String getColorBorde() {
        return colorBorde;
    }
    
    /**
     * Retorna una representación en String de la figura
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + 
               " [Fondo: " + colorFondo + ", Borde: " + colorBorde + "]";
    }
}
