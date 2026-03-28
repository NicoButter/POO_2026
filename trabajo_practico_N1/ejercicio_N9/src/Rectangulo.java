/**
 * Clase Rectángulo - Subclase de Figura
 * 
 * Un rectángulo ES una figura con:
 * - Base y altura definidas
 * - Superficie que se puede calcular
 * - Perímetro que se puede calcular
 */
class Rectangulo extends Figura {
    
    private double base;
    private double altura;
    
    /**
     * Constructor de Rectángulo
     */
    public Rectangulo(double base, double altura, String colorFondo, String colorBorde) {
        super(colorFondo, colorBorde);
        this.base = base;
        this.altura = altura;
    }
    
    /**
     * Dibuja un rectángulo usando asteriscos
     */
    @Override
    void dibujar() {
        System.out.println("┌" + "─".repeat((int)base * 2 - 2) + "┐");
        for (int i = 0; i < (int)altura - 1; i++) {
            System.out.println("│" + " ".repeat((int)base * 2 - 2) + "│");
        }
        System.out.println("└" + "─".repeat((int)base * 2 - 2) + "┘");
    }
    
    /**
     * Calcula el perímetro del rectángulo
     * Fórmula: P = 2 * (base + altura)
     */
    @Override
    double perimetro() {
        return 2 * (base + altura);
    }
    
    /**
     * Calcula la superficie del rectángulo
     * Fórmula: S = base * altura
     */
    @Override
    public double superficie() {
        return base * altura;
    }
    
    // Getters y Setters
    public double getBase() {
        return base;
    }
    
    public void setBase(double base) {
        this.base = base;
    }
    
    public double getAltura() {
        return altura;
    }
    
    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    @Override
    public String toString() {
        return super.toString() + " [Base: " + base + ", Altura: " + altura + 
               ", Perímetro: " + String.format("%.2f", perimetro()) + 
               ", Superficie: " + String.format("%.2f", superficie()) + "]";
    }
}
