import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Clase de prueba para demostrar el funcionamiento del sistema
 */
public class PruebaPrograma {
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║     PRUEBA DEL SISTEMA DE FIGURAS GEOMÉTRICAS             ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        // Crear una pizarra
        Pizarra pizarra = new Pizarra("Blanco");
        System.out.println("✓ Pizarra creada con color de fondo: " + pizarra.getColorFondoPizarra());
        System.out.println();
        
        // Crear rectángulo
        System.out.println("--- Creando Rectángulo ---");
        Rectangulo rect = new Rectangulo(8, 5, "Rojo", "Negro");
        System.out.println("Rectángulo: " + rect);
        System.out.println();
        
        // Crear circunferencia
        System.out.println("--- Creando Circunferencia ---");
        Circunferencia circ = new Circunferencia(4, "Azul", "Verde");
        System.out.println("Circunferencia: " + circ);
        System.out.println();
        
        // Crear línea
        System.out.println("--- Creando Línea ---");
        Linea linea = new Linea(12, "Morado", "Morado");
        System.out.println("Línea: " + linea);
        System.out.println();
        
        // Agregar figuras a la pizarra
        System.out.println("--- Agregando figuras a la pizarra ---");
        pizarra.agregarFigura(rect);
        pizarra.agregarFigura(circ);
        pizarra.agregarFigura(linea);
        System.out.println();
        
        // Mostrar todas las figuras
        System.out.println("--- Mostrando todas las figuras ---");
        pizarra.mostrarFiguras();
        
        // Calcular superficies
        System.out.println("--- Cálculo de Superficies ---");
        System.out.println("Superficie Rectángulo: " + String.format("%.2f", rect.superficie()) + " u²");
        System.out.println("Superficie Circunferencia: " + String.format("%.2f", circ.superficie()) + " u²");
        System.out.println("Superficie Línea: " + (linea.superficie() < 0 ? "N/A" : String.format("%.2f", linea.superficie())) + " u²");
        System.out.println("Superficie Total en Pizarra: " + String.format("%.2f", pizarra.calcularSuperficieTotal()) + " u²");
        System.out.println();
        
        // Calcular perímetros
        System.out.println("--- Cálculo de Perímetros ---");
        System.out.println("Perímetro Rectángulo: " + String.format("%.2f", rect.perimetro()) + " u");
        System.out.println("Perímetro Circunferencia: " + String.format("%.2f", circ.perimetro()) + " u");
        System.out.println("Perímetro Línea: " + String.format("%.2f", linea.perimetro()) + " u");
        System.out.println("Perímetro Total en Pizarra: " + String.format("%.2f", pizarra.calcularPerimetroTotal()) + " u");
        System.out.println();
        
        // Cambiar colores
        System.out.println("--- Cambiando colores ---");
        pizarra.cambiarColorFondo(0, "Rosa");
        pizarra.cambiarColorBorde(1, "Rojo");
        pizarra.setColorFondoPizarra("Amarillo");
        System.out.println();
        
        // Mostrar figuras después de cambios
        System.out.println("--- Figuras después de cambios de color ---");
        pizarra.mostrarFiguras();
        
        // Dibujar figuras
        System.out.println("--- Dibujando figuras ---");
        pizarra.dibujarTodasLasFiguras();
        
        // Eliminar una figura
        System.out.println("--- Eliminando la figura 2 (Circunferencia) ---");
        pizarra.eliminarFigura(1);
        System.out.println("Figuras restantes: " + pizarra.cantidadFiguras());
        System.out.println();
        
        // Mostrar figuras finales
        System.out.println("--- Figuras finales en la pizarra ---");
        pizarra.mostrarFiguras();
        
        // Cálculos finales
        System.out.println("--- Cálculos finales ---");
        System.out.println("Superficie Total: " + String.format("%.2f", pizarra.calcularSuperficieTotal()) + " u²");
        System.out.println("Perímetro Total: " + String.format("%.2f", pizarra.calcularPerimetroTotal()) + " u");
        System.out.println();
        
        // Limpiar pizarra
        System.out.println("--- Limpiando la pizarra ---");
        pizarra.limpiar();
        System.out.println("Figuras en pizarra: " + pizarra.cantidadFiguras());
        System.out.println();
        
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║     PRUEBA COMPLETADA EXITOSAMENTE                        ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
    }
}
