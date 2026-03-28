# Teoría - Conceptos POO Aplicados en Ejercicio N°9

## 📚 Tabla de Contenidos

1. [Herencia](#herencia)
2. [Polimorfismo](#polimorfismo)
3. [Encapsulamiento](#encapsulamiento)
4. [Abstracción](#abstracción)
5. [Composición](#composición)
6. [Clase Abstracta vs Interface](#clase-abstracta-vs-interface)
7. [Relación "Es Un/a"](#relación-esuna)
8. [Anti-patrones Evitados](#anti-patrones-evitados)

---

## 🏛️ Herencia

### Concepto
**Herencia** es el mecanismo mediante el cual una clase (subclase/hijo) hereda atributos y métodos de otra clase (superclase/padre).

### En Nuestro Proyecto

```java
// Clase padre (abstracta)
abstract class Figura {
    protected String colorFondo;
    protected String colorBorde;
}

// Clases hijas
class Rectangulo extends Figura { /* hereda colorFondo, colorBorde */ }
class Circunferencia extends Figura { /* hereda colorFondo, colorBorde */ }
class Linea extends Figura { /* hereda colorFondo, colorBorde */ }
```

### Ventajas

| Ventaja | Descripción |
|---------|---|
| **Reutilización de código** | No repetimos `colorFondo` en cada subclase |
| **Jerarquía clara** | "Un Rectángulo es un tipo de Figura" |
| **Mantenimiento** | Cambios en Figura afectan a todas las subclases |
| **Base compartida** | Métodos como `getColorFondo()` se definen una sola vez |

### Jerarquía de Herencia

```
                    Figura (abstracta)
                        △
                        │
            ┌───────────┼───────────┐
            │           │           │
        Rectangulo  Circunferencia  Linea
```

---

## 🎭 Polimorfismo

### Concepto
**Polimorfismo** permite que objetos de diferentes tipos se traten de forma uniforme a través de una interfaz común.

### En Nuestro Proyecto

#### Polimorfismo por Herencia

```java
// Tenemos referencias de tipo Figura
Figura fig1 = new Rectangulo(5, 3, "Rojo", "Negro");
Figura fig2 = new Circunferencia(4, "Azul", "Verde");
Figura fig3 = new Linea(10, "Morado", "Morado");

// Podemos tratar todas igual, pero se comportan diferente
ArrayList<Figura> figuras = new ArrayList<>();
figuras.add(fig1);  // Es un Rectángulo pero lo tratamos como Figura
figuras.add(fig2);  // Es una Circunferencia pero lo tratamos como Figura
figuras.add(fig3);  // Es una Línea pero lo tratamos como Figura
```

#### Late Binding (Vinculación Tardía)

```java
// En tiempo de compilación: sabemos que es una Figura
Figura figura = new Rectangulo(5, 3, "Rojo", "Negro");

// En tiempo de ejecución: se llama el método de Rectángulo
figura.dibujar();  // ✓ Dibuja un rectángulo
figura.dibujar();  // Llama a Rectangulo.dibujar(), NO a Figura.dibujar()
```

#### Polimorfismo en Bucles

```java
// Cada figura dibuja de forma diferente
for (Figura fig : figuras) {
    fig.dibujar();  // Se comporta diferente según el tipo real
}

// Salida esperada:
// Dibuja un rectángulo
// Dibuja una circunferencia
// Dibuja una línea
```

### Tabla Comparativa

| Tipo de Polimorfismo | Ejemplo | Momento |
|---|---|---|
| **Sobrescritura** | Cada clase sobrescribe `dibujar()` | Ejecución |
| **Composición** | Formas diferentes de `superficie()` | Compilación + Ejecución |
| **Enlace Dinámico** | `fig.dibujar()` en bucle | Ejecución |

---

## 🔒 Encapsulamiento

### Concepto
**Encapsulamiento** es ocultar la implementación interna y exposer solo lo necesario.

### En Nuestro Proyecto

```java
// Atributos privados de Pizarra (no se puede acceder directamente)
class Pizarra {
    private List<Figura> figuras;  // ← private
    private String colorFondoPizarra;  // ← private
    
    // Acceso controlado mediante métodos públicos
    public void agregarFigura(Figura figura) { ... }
    public boolean eliminarFigura(int indice) { ... }
}

// Atributos protegidos de Figura (solo para subclases)
abstract class Figura {
    protected String colorFondo;  // ← protected (para subclases)
    protected String colorBorde;  // ← protected
    
    // Acceso controlado
    public void setColorFondo(String color) { ... }
    public String getColorFondo() { ... }
}
```

### Niveles de Acceso

| Modificador | Clase | Paquete | Subclase | Otros |
|---|---|---|---|---|
| `public` | ✓ | ✓ | ✓ | ✓ |
| `protected` | ✓ | ✓ | ✓ | ✗ |
| `package` (sin modificador) | ✓ | ✓ | ✗ | ✗ |
| `private` | ✓ | ✗ | ✗ | ✗ |

### Ventajas

```java
// SIN encapsulamiento (MAL)
pizarra.figuras.clear();  // Alguien puede limpiar la pizarra directamente

// CON encapsulamiento (BIEN)
pizarra.limpiar();  // Método controlado que hace validaciones
```

---

## 💡 Abstracción

### Concepto
**Abstracción** es la capacidad de extraer lo esencial e ignorar detalles específicos.

### En Nuestro Proyecto

#### Abstracción mediante Clase Abstracta

```java
// No importa CÓMO dibuja cada figura
// Solo importa QUE dibuja
abstract class Figura {
    abstract void dibujar();  // Contrato: DEBE implementarse
}

// Cada una dibuja de forma diferente
class Rectangulo extends Figura {
    void dibujar() { /* código ASCII de rectángulo */ }
}

class Circunferencia extends Figura {
    void dibujar() { /* código ASCII de círculo */ }
}
```

#### Niveles de Abstracción

```
NIVEL ALTO:    "Dibujar figuras en una pizarra"
                         △
                         │
NIVEL MEDIO:   "Gestionar una colección de figuras"
                         △
                         │
NIVEL BAJO:    "Implementación específica de cada figura"
```

#### Cliente Solo Ve Nivel Altro

```java
// Usuario del programa ve esto
pizarra.agregarFigura(nuevaFigura);
pizarra.dibujarTodasLasFiguras();

// No ve los detalles de cómo dibujar un círculo,
// un rectángulo o una línea
```

---

## 🔧 Composición

### Concepto
**Composición** es una relación "tiene un/a" entre clases, donde una clase contiene instancias de otras.

### En Nuestro Proyecto

```java
// Pizarra TIENE figuras (relación de composición)
class Pizarra {
    private List<Figura> figuras;  // ← Pizarra contiene figuras
    
    public void agregarFigura(Figura figura) {
        figuras.add(figura);
    }
}

// Uso:
Pizarra pizarra = new Pizarra("Blanco");
pizarra.agregarFigura(new Rectangulo(...));  // Añadimos una figura
```

### Composición vs Herencia

| Aspecto | Herencia | Composición |
|---|---|---|
| **Relación** | "Es un/a" | "Tiene un/a" |
| **Significado** | Especialización | Colaboración |
| **Ejemplo** | Rectángulo ES una Figura | Pizarra TIENE Figuras |
| **Módulos** | Acoplados | Desacoplados |
| **Flexibilidad** | Menos flexible | Más flexible |

### Ejemplo Comparativo

```java
// ❌ MAL: Herencia incorrecta
class Pizarra extends ArrayList<Figura> { }  // Pizarra NO es un ArrayList

// ✓ BIEN: Composición correcta
class Pizarra {
    private ArrayList<Figura> figuras;  // Pizarra CONTIENE un ArrayList
}
```

---

## 🔬 Clase Abstracta vs Interface

### Decisión en Ejercicio N°9

#### Clase Abstracta ✅ (Elegida)

```java
abstract class Figura {
    // ESTADO: Puede tener atributos
    protected String colorFondo;
    protected String colorBorde;
    
    // MÉTODOS ABSTRACTOS: Debe implementarse en subclases
    abstract void dibujar();
    abstract double perimetro();
    
    // MÉTODOS CONCRETOS: Implementación compartida
    public void setColorFondo(String color) {
        this.colorFondo = color;
    }
}
```

**Ventajas:**
- ✓ Compartir atributos (colores)
- ✓ Compartir implementación (getters/setters)
- ✓ Impedir instanciación directa
- ✓ Herencia de un solo nivel de especialización

#### Interface ❌ (No elegida porque)

```java
interface Figura {
    void dibujar();
    double perimetro();
    // ✗ No puedo declarar atributos con valor inicial
    // ✗ No puedo compartir implementación
}
```

**Limitaciones:**
- ✗ Sin estado compartido
- ✗ Sin implementación compartida
- ✗ Requeriría duplicar código en cada clase

### Tabla Comparativa

| Característica | Clase Abstracta | Interface |
|---|---|---|
| **Herencia múltiple** | No (extends) | Sí (implements) |
| **Atributos con estado** | Sí | No (Java 8+) |
| **Métodos concretos** | Sí | Parcialmente (Java 8+) |
| **Métodos abstractos** | Sí | Sí |
| **Constructor** | Sí | No |
| **Modificadores** | Varios | Públicos implícitos |
| **Caso de uso** | Categoría compartida | Contrato puro |

---

## 🔗 Relación "Es Un/a"

### Definición
La herencia SOLO es apropiada cuando existe una relación "es un/a" entre clases.

### En Ejercicio N°9

✅ **VÁLIDAS:**
```
Un Rectángulo ES una Figura
Una Circunferencia ES una Figura
Una Línea ES una Figura
```

✅ **SÍ tiene sentido:**
```
¿Toda instancia de Rectángulo es una instancia de Figura?  → SÍ
¿Todo Rectángulo hereda capacidades de Figura?             → SÍ
¿Un Rectángulo es especialización de Figura?               → SÍ
```

### ❌ Relaciones INVÁLIDAS

```java
// ❌ INCORRECTO
class Pizarra extends ArrayList { }
// "Una Pizarra ES un ArrayList?" → NO
// Solución: Composición (arriba)

// ❌ INCORRECTO
class Motor extends Auto { }
// "Un Motor ES un Auto?" → NO
// Correcto: class Auto { private Motor motor; }

// ❌ INCORRECTO
class Rueda extends Automovil { }
// "Una Rueda ES un Automóvil?" → NO
// Correcto: class Automovil { private Rueda[] ruedas; }
```

---

## ⚠️ Anti-patrones Evitados

### Anti-patrón 1: God Class

```java
// ❌ MAL: Una clase hace demasiado
class Figura {
    void dibujar() { /* TODO */ }
    void calcularPerimetro() { /* TODO */ }
    void calcularSuperficie() { /* TODO */ }
    void crearArchivo() { /* TODO */ }
    void enviarPorEmail() { /* TODO */ }
}

// ✓ BIEN: Responsabilidades divididas
abstract class Figura { /* solo geometría */ }
class GuardadorArchivos { /* guarda figuras */ }
class EnviadorEmail { /* envía datos */ }
```

### Anti-patrón 2: Falta de Abstracción

```java
// ❌ MAL: Objeto sin tipo específico
Figura fig = new Figura();  // ¡¿Qué tipo de figura es?!

// ✓ BIEN: Objeto siempre específico
Figura fig = new Rectangulo(...);
```

### Anti-patrón 3: Violación de Liskov Substitution Principle

```java
// ❌ MAL: Línea dice que tiene superficie pero retorna 0
class Linea extends Figura {
    public double superficie() {
        return 0;  // Engañoso
    }
}

// ✓ BIEN: Retorna -1 para indicar "no aplica"
class Linea extends Figura {
    public double superficie() {
        return -1;  // Claro: no aplica para Línea
    }
}
```

### Anti-patrón 4: Acoplamiento Innecesario

```java
// ❌ MAL: Pizarra directamente accede a internales de Figura
class Pizarra {
    void modificarColor(int idx, String color) {
        figuras.get(idx).colorFondo = color;  // Violación de encapsulamiento
    }
}

// ✓ BIEN: Usa métodos públicos
class Pizarra {
    void modificarColor(int idx, String color) {
        figuras.get(idx).setColorFondo(color);  // Encapsulado
    }
}
```

---

## 📝 Resumen: Conceptos Aplicados

| Concepto | Aplicación | Beneficio |
|---------|---|---|
| **Herencia** | Figura → Rectangulo, Circunferencia, Línea | Código compartido |
| **Polimorfismo** | Cada figura dibuja diferente | Flexibilidad |
| **Encapsulamiento** | private/protected atributos | Control de acceso |
| **Abstracción** | Métodos abstractos | Contratos claros |
| **Composición** | Pizarra contiene Figuras | Flexibilidad de diseño |
| **Relación "es un/a"** | Rectángulo es Figura | Semántica correcta |

---

## 🎓 Conclusión

El Ejercicio N°9 demuestra cómo los cinco pilares de POO trabajan juntos:

1. **Abstracción** define qué pueden hacer las figuras
2. **Herencia** permite compartir código común
3. **Polimorfismo** permite tratarlas uniformemente
4. **Encapsulamiento** oculta detalles de implementación
5. **Composición** agrupa figuras en una pizarra

Todo esto bajo una relación semántica válida ("es un/a") que hace el código mantenible, extensible y fácil de entender.

