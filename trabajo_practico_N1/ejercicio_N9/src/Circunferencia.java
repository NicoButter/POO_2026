/**
 * Clase Circunferencia - Subclase de Figura
 * 
 * Una circunferencia ES una figura con:
 * - Radio definido
 * - Superficie (área del círculo) que se puede calcular
 * - Perímetro (longitud de la circunferencia) que se puede calcular
 */
class Circunferencia extends Figura {
    
    private double radio;
    
    /**
     * Constructor de Circunferencia
     */
    public Circunferencia(double radio, String colorFondo, String colorBorde) {
        super(colorFondo, colorBorde);
        this.radio = radio;
    }
    
    /**
     * Dibuja una circunferencia usando caracteres ASCII
     */
    @Override
    void dibujar() {
        int r = (int)radio;
        for (int y = -r; y <= r; y++) {
            for (int x = -r; x <= r; x++) {
                double dist = Math.sqrt(x * x + y * y);
                if (Math.abs(dist - radio) < 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Calcula el perímetro (longitud) de la circunferencia
     * Fórmula: P = 2 * π * radio
     */
    @Override
    double perimetro() {
        return 2 * Math.PI * radio;
    }
    
    /**
     * Calcula la superficie (área) de la circunferencia
     * Fórmula: S = π * radio²
     */
    @Override
    public double superficie() {
        return Math.PI * radio * radio;
    }
    
    // Getters y Setters
    public double getRadio() {
        return radio;
    }
    
    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    @Override
    public String toString() {
        return super.toString() + " [Radio: " + radio + 
               ", Perímetro: " + String.format("%.2f", perimetro()) + 
               ", Superficie: " + String.format("%.2f", superficie()) + "]";
    }
}
