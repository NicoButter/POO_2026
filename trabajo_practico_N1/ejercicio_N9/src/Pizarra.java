import java.util.ArrayList;
import java.util.List;

/**
 * Clase Pizarra
 * 
 * Una pizarra es un contenedor que gestiona un conjunto de figuras.
 * Proporciona operaciones para:
 * - Agregar y eliminar figuras
 * - Limpiar toda la pizarra
 * - Calcular propiedades agregadas (superficie total, perímetro total)
 * - Modificar propiedades de figuras individuales
 * - Cambiar el color de fondo de la pizarra
 */
class Pizarra {
    
    private List<Figura> figuras;
    private String colorFondoPizarra;
    
    /**
     * Constructor de Pizarra
     */
    public Pizarra(String colorFondoPizarra) {
        this.figuras = new ArrayList<>();
        this.colorFondoPizarra = colorFondoPizarra;
    }
    
    /**
     * Agrega una figura a la pizarra
     */
    public void agregarFigura(Figura figura) {
        figuras.add(figura);
        System.out.println("✓ Figura agregada: " + figura);
    }
    
    /**
     * Elimina una figura de la pizarra por índice
     */
    public boolean eliminarFigura(int indice) {
        if (indice >= 0 && indice < figuras.size()) {
            Figura eliminada = figuras.remove(indice);
            System.out.println("✓ Figura eliminada: " + eliminada);
            return true;
        } else {
            System.out.println("✗ Índice inválido");
            return false;
        }
    }
    
    /**
     * Limpia toda la pizarra (elimina todas las figuras)
     */
    public void limpiar() {
        figuras.clear();
        System.out.println("✓ Pizarra limpiada");
    }
    
    /**
     * Obtiene el número de figuras en la pizarra
     */
    public int cantidadFiguras() {
        return figuras.size();
    }
    
    /**
     * Calcula la superficie total de todas las figuras
     * (solo suma figuras que tienen superficie)
     */
    public double calcularSuperficieTotal() {
        double superficieTotal = 0;
        for (Figura fig : figuras) {
            double sup = fig.superficie();
            if (sup >= 0) {  // Solo sumar si la figura tiene superficie
                superficieTotal += sup;
            }
        }
        return superficieTotal;
    }
    
    /**
     * Calcula el perímetro total de todas las figuras
     */
    public double calcularPerimetroTotal() {
        double perimetroTotal = 0;
        for (Figura fig : figuras) {
            perimetroTotal += fig.perimetro();
        }
        return perimetroTotal;
    }
    
    /**
     * Cambia el color de fondo de una figura específica
     */
    public boolean cambiarColorFondo(int indice, String color) {
        if (indice >= 0 && indice < figuras.size()) {
            figuras.get(indice).setColorFondo(color);
            System.out.println("✓ Color de fondo cambiado a: " + color);
            return true;
        } else {
            System.out.println("✗ Índice inválido");
            return false;
        }
    }
    
    /**
     * Cambia el color de borde de una figura específica
     */
    public boolean cambiarColorBorde(int indice, String color) {
        if (indice >= 0 && indice < figuras.size()) {
            figuras.get(indice).setColorBorde(color);
            System.out.println("✓ Color de borde cambiado a: " + color);
            return true;
        } else {
            System.out.println("✗ Índice inválido");
            return false;
        }
    }
    
    /**
     * Cambia el color de fondo de la pizarra
     */
    public void setColorFondoPizarra(String color) {
        this.colorFondoPizarra = color;
        System.out.println("✓ Color de fondo de la pizarra cambiado a: " + color);
    }
    
    /**
     * Obtiene el color de fondo de la pizarra
     */
    public String getColorFondoPizarra() {
        return colorFondoPizarra;
    }
    
    /**
     * Dibuja todas las figuras en la pizarra
     */
    public void dibujarTodasLasFiguras() {
        if (figuras.isEmpty()) {
            System.out.println("La pizarra está vacía");
            return;
        }
        System.out.println("\n========== PIZARRA [Fondo: " + colorFondoPizarra + "] ==========");
        for (int i = 0; i < figuras.size(); i++) {
            System.out.println("\n--- Figura " + (i + 1) + " ---");
            figuras.get(i).dibujar();
        }
        System.out.println("\n=============================================\n");
    }
    
    /**
     * Muestra todas las figuras en la pizarra
     */
    public void mostrarFiguras() {
        if (figuras.isEmpty()) {
            System.out.println("La pizarra está vacía");
            return;
        }
        System.out.println("\n========== FIGURAS EN LA PIZARRA ==========");
        for (int i = 0; i < figuras.size(); i++) {
            System.out.println((i + 1) + ". " + figuras.get(i));
        }
        System.out.println("==========================================\n");
    }
    
    /**
     * Obtiene una figura por índice
     */
    public Figura obtenerFigura(int indice) {
        if (indice >= 0 && indice < figuras.size()) {
            return figuras.get(indice);
        }
        return null;
    }
    
    /**
     * Retorna las figuras de la pizarra
     */
    public List<Figura> getFiguras() {
        return new ArrayList<>(figuras);
    }
}
