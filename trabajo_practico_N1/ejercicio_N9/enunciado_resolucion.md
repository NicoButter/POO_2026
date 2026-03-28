# Ejercicio N°9 - CLASE ABSTRACTA FIGURA Y PIZARRA

## 📋 Descripción del Ejercicio

Implementar un sistema de figuras geométricas que permite:
- Dibujar diferentes tipos de figuras (Rectángulo, Circunferencia, Línea)
- Calcular perímetro y superficie de las figuras
- Gestionar una colección de figuras en una "pizarra"
- Manipular propiedades de las figuras (colores)

---

## 🎯 JUSTIFICACIÓN: ¿Por qué CLASE ABSTRACTA?

### Contexto del Problema

Observamos en el diagrama que `Figura` tiene tres tipos específicos de figuras como subclases:
```
                    Figura
                      △
                 ┌────┼────┐
                 v    v    v
            Rectángulo Circunferencia Línea
```

**Evaluación de opciones:**

### ❌ OPCIÓN 1: Clase Simple (RECHAZADA)

```java
class Figura {
    protected String colorFondo;
    protected String colorBorde;
    
    void dibujar() { /* ??? */ }
    double perimetro() { /* ??? */ }
}
```

**Problemas:**
1. ¿Cómo dibuja una "figura genérica"? No existe
2. ¿Cómo se calcula el perímetro sin saber qué tipo de figura es?
3. Rompe el principio de **responsabilidad única**
4. Permite crear instancias sin sentido: `new Figura()`
5. Violaría la semántica de la herencia: "Un Rectángulo ES una Figura" pero "Una Figura genérica" no tiene sentido real

### ❌ OPCIÓN 2: Interface (RECHAZADA)

```java
interface Figura {
    void dibujar();
    double perimetro();
}
```

**Problemas:**
1. **Pérdida de estado**: Las interfaces no pueden tener atributos inicializados
   - `colorFondo` y `colorBorde` se duplicarían en cada subclase
   - Violaría DRY (Don't Repeat Yourself)

2. **Falta de implementación compartida**: Sin lugar para código común
   - Los métodos `getColorFondo()`, `setColorBorde()`, etc., se duplicarían

3. **Interfaces son para contratos de comportamiento**, no para categorías compartidas
   - Figura NO es una "abstracción de comportamiento puro"
   - Figura ES una "categoría de objetos con características comunes"

### ✅ OPCIÓN 3: Clase Abstracta (ELEGIDA)

```java
abstract class Figura {
    // Estado compartido
    protected String colorFondo;
    protected String colorBorde;
    
    // Métodos que DEBEN implementarse
    abstract void dibujar();
    abstract double perimetro();
    
    // Métodos concretos compartidos
    public void setColorFondo(String color) {
        this.colorFondo = color;
    }
}
```

**Ventajas:**

| Característica | Beneficio |
|---|---|
| **Estado compartido** | `colorFondo` y `colorBorde` se definen una sola vez |
| **Métodos concretos** | Getters/setters implementados una vez para todas |
| **No instanciable** | Imposible hacer `new Figura()` - fuerza que sea específica |
| **Herencia correcta** | "Un Rectángulo ES una Figura" → semántica correcta |
| **Métodos abstractos** | Obliga a cada subclase a implementar `dibujar()` y `perimetro()` |
| **Métodos opcionales** | `superficie()` por defecto retorna -1 (no aplica) |

---

## 📊 Decisiones de Diseño

### 1. Miembros abstractos vs concretos

```
MÉTODOS ABSTRACTOS (deben implementarse en subclases):
├── dibujar()        → Cada figura se dibuja diferente
└── perimetro()      → Cada figura calcula perímetro distinto

MÉTODOS CONCRETOS (implementación compartida):
├── setColorFondo()  → Igual para todas
├── setColorBorde()  → Igual para todas
└── toString()       → Formato común para todas
```

### 2. Manejo de superficie()

**Problema:** No todas las figuras tienen superficie
- Rectángulo: SÍ tiene
- Circunferencia: SÍ tiene  
- Línea: NO tiene (es unidimensional)

**Solución:**
```java
public double superficie() {
    return -1;  // Indica "no aplicable"
}
```

- En subclases con superficie: se sobrescribe con la fórmula correcta
- En la Línea: retorna -1
- En la Pizarra: sumamos solo superficies >= 0

### 3. Colores de las Figuras

```java
- colorFondo: Color interior de la figura
- colorBorde: Color del contorno
- Ambos pueden modificarse después de crear la figura
```

---

## 🏗️ Estructura de Clases

### Jerarquía Completa

```
                         Figura (abstracta)
                            △
                      ┌─────┼─────┐
                      │     │     │
                  Rectángulo │  Línea
                             │
                        Circunferencia
```

### Tabla de Responsabilidades

| Clase | Base | Altura/Radio/Long. | dibujar() | perimetro() | superficie() |
|---|---|---|---|---|---|
| **Figura** | - | - | ❌ Abstract | ❌ Abstract | ➖ -1 |
| **Rectángulo** | ✅ | ✅ (altura) | ✅ Cuadro ASCII | 2×(b+h) | b×h |
| **Circunferencia** | - | ✅ (radio) | ✅ Asteriscos | 2πr | πr² |
| **Línea** | - | ✅ (longitud) | ✅ Guiones | longitud | ➖ -1 |

---

## 📦 Clase Pizarra

La pizarra actúa como un **contenedor** que gestiona una colección de figuras.

### Responsabilidades

```java
✓ Agregar figuras
✓ Eliminar figuras  
✓ Limpiar completamente
✓ Calcular superficie total (suma de todas las que aplican)
✓ Calcular perímetro total
✓ Cambiar colores de figuras individuales
✓ Cambiar color de fondo de la pizarra
✓ Dibujar todas las figuras
✓ Mostrar información de todas las figuras
```

### Estructura Interna

```java
class Pizarra {
    private List<Figura> figuras;  // Contenedor polimórfico
    private String colorFondoPizarra;
    
    // 11 métodos públicos para manipulación
}
```

---

## 🎮 Menú Principal

El programa interactivo permite:

```
1. Agregar una figura
   ├── Rectángulo (pide base, altura, colores)
   ├── Circunferencia (pide radio, colores)
   └── Línea (pide longitud, color)

2. Eliminar una figura (por índice)

3. Limpiar la pizarra (con confirmación)

4. Calcular superficie total

5. Calcular perímetro total

6. Cambiar color de una figura
   ├── Color de fondo
   └── Color de borde

7. Cambiar color de fondo de pizarra

8. Dibujar figuras (representación visual ASCII)

9. Mostrar figuras (listado completo)

10. Salir
```

---

## 💡 Conceptos POO Aplicados

### 1. Herencia
```java
class Rectángulo extends Figura { ... }
```
- Las figuras específicas HEREDAN propiedades comunes

### 2. Encapsulamiento
```java
private List<Figura> figuras;  // Private en Pizarra
protected String colorFondo;    // Protected en Figura
```

### 3. Polimorfismo
```java
List<Figura> figuras;  // Contenedor polimórfico
for (Figura fig : figuras) {
    fig.dibujar();  // Cada una dibuja de forma diferente
}
```

### 4. Abstracción
```java
abstract void dibujar();  // Contrato que todas deben cumplir
```

### 5. Composición
```java
class Pizarra {
    private List<Figura> figuras;  // La pizarra TIENE figuras
}
```

---

## 🧪 Ejemplo de Uso

```java
// Crear pizarra
Pizarra pizarra = new Pizarra("Blanco");

// Agregar figuras
Rectangulo rect = new Rectangulo(5, 3, "Rojo", "Negro");
Circunferencia circ = new Circunferencia(4, "Azul", "Verde");
Linea linea = new Linea(10, "Morado", "Morado");

pizarra.agregarFigura(rect);
pizarra.agregarFigura(circ);
pizarra.agregarFigura(linea);

// Consultas
System.out.println("Superficie total: " + pizarra.calcularSuperficieTotal());
System.out.println("Perímetro total: " + pizarra.calcularPerimetroTotal());

// Modificaciones
pizarra.cambiarColorFondo(0, "Rosa");
pizarra.dibujarTodasLasFiguras();

// Gestión
pizarra.eliminarFigura(1);
pizarra.limpiar();
```

---

## 🎓 Conclusión

La elección de **clase abstracta** es la más apropiada porque:

1. ✅ Captura el concepto común (figura = tiene color, perímetro)
2. ✅ Previene instanciación sin sentido
3. ✅ Fuerza contrato de comportamiento (dibujar, perimetro)
4. ✅ Reutiliza código (colores, métodos auxiliares)
5. ✅ Mantiene semántica correcta (es-un/a)
6. ✅ Soporta polimorfismo natural
7. ✅ Flexible para casos especiales (superficie opcional)

