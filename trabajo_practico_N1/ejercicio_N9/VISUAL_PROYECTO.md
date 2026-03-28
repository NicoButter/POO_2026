# 📊 VISUAL DEL PROYECTO - Ejercicio N°9

## 🏗️ Arquitectura del Sistema

```
┌─────────────────────────────────────────────────────────────┐
│                       USUÁRIO DEL SISTEMA                   │
│                      (Interactúa vía menú)                  │
└──────────────────────┬──────────────────────────────────────┘
                       │
                       ↓
         ┌─────────────────────────────┐
         │       PROGRAMA MAIN          │
         │   (Menu Interactivo + I/O)   │
         └──────────────┬────────────────┘
                        │
                        ↓
         ┌──────────────────────────────┐
         │       CLASE PIZARRA          │
         │  Gestiona colección de       │
         │  figuras, cálculos, etc.     │
         └──────────────┬───────────────┘
                        │
                        ↓
         ┌──────────────────────────────────────┐
         │    CLASE ABSTRACTA FIGURA            │
         │ (Define interfaz común)              │
         │  - colorFondo                        │
         │  - colorBorde                        │
         │  - dibujar() [abstracto]             │
         │  - perimetro() [abstracto]           │
         │  - superficie()                      │
         └────────────────────┬─────────────────┘
                              │
         ┌────────────────────┼─────────────────┐
         │                    │                 │
         ↓                    ↓                 ↓
    ┌─────────────┐  ┌─────────────────┐  ┌────────┐
    │ Rectangulo  │  │ Circunferencia  │  │ Linea  │
    ├─────────────┤  ├─────────────────┤  ├────────┤
    │ -base       │  │ -radio          │  │ -long  │
    │ -altura     │  │                 │  │        │
    │ +dibujar()  │  │ +dibujar()      │  │ +dibu( │
    │ +perim()    │  │ +perim()        │  │ +perim │
    │ +superf()   │  │ +superf()       │  │ -superf
    └─────────────┘  └─────────────────┘  └────────┘
```

---

## 🔄 Flujo de Ejecución

```
INICIO DEL PROGRAMA
        │
        ↓
   ┌─────────────────────────┐
   │  Crear Pizarra          │
   │  (color blanco)          │
   └──────────┬──────────────┘
              │
              ↓
   ┌─────────────────────────────────┐
   │  MOSTRAR MENÚ PRINCIPAL          │
   │  1. Agregar figura               │
   │  2. Eliminar figura              │
   │  ... (10 opciones)               │
   └──────────┬──────────────────────┘
              │
              ↓
       ¿Opción? → SWITCH
        │
        ├─→ [1] AGREGAR
        │   ├─→ ¿Qué tipo?
        │   │   ├─→ Rectángulo
        │   │   ├─→ Circunferencia
        │   │   └─→ Línea
        │   └─→ Agregar a Pizarra
        │
        ├─→ [2] ELIMINAR
        │   └─→ Eliminar de Pizarra
        │
        ├─→ [3] LIMPIAR
        │   └─→ Vaciar Pizarra
        │
        ├─→ [4] CALCULAR SUPERFICIE
        │   ├─→ Iterar figuras
        │   └─→ Sumar superficies
        │
        ├─→ [5] CALCULAR PERÍMETRO
        │   ├─→ Iterar figuras
        │   └─→ Sumar perímetros
        │
        ├─→ [6] CAMBIAR COLOR
        │   ├─→ Modificar figura
        │   └─→ Actualizar en Pizarra
        │
        ├─→ [7] CAMBIAR FONDO PIZARRA
        │   └─→ Cambiar colorFondoPizarra
        │
        ├─→ [8] DIBUJAR
        │   └─→ Mostrar ASCII art
        │
        ├─→ [9] MOSTRAR FIGURAS
        │   └─→ Listar todas con detalles
        │
        └─→ [10] SALIR
            └─→ FIN PROGRAMA

¿Repetir? → SÍ → Volver a MENÚ PRINCIPAL
          → NO → FIN
```

---

## 📋 Jerarquía de Clases

```
        ┌──────────────────────────────┐
        │  java.lang.Object            │
        └────────────────┬─────────────┘
                         │
            ┌────────────┴────────────┐
            │                         │
            ↓                         ↓
    ┌───────────────┐        ┌─────────────────┐
    │Figura(ABSTRACT)        │Pizarra          │
    │               │        │                 │
    │+ colorFondo   │        │- figuras: List  │
    │+ colorBorde   │        │- color: String  │
    │               │        │                 │
    │# dibujar()    │        │+ agregar()      │
    │# perimetro()  │        │+ eliminar()     │
    │+ superficie() │        │+ calcular()     │
    │+ get/setColor │        │+ cambiarColor() │
    └────────┬──────┘        └─────────────────┘
             │
   ┌─────────┼──────────┐
   │         │          │
   ↓         ↓          ↓
 ┌───────┐┌────────┐┌──────────┐
 │Rect.. ││Circun..││Linea     │
 │       ││        ││          │
 │-base  ││-radio  ││-longitud │
 │-altura││        ││          │
 └───────┘└────────┘└──────────┘
```

---

## 🔐 Visibilidad de Miembros

```
┌─────────────────────────────────────┐
│        FIGURA (Clase Abstracta)      │
├─────────────────────────────────────┤
│ Protected (para subclases):          │
│  • colorFondo                        │
│  • colorBorde                        │
│                                      │
│ Public (para todos):                 │
│  • getColorFondo()                   │
│  • setColorFondo(String)             │
│  • getColorBorde()                   │
│  • setColorBorde(String)             │
│  • toString()                        │
│                                      │
│ Abstract (debe implementarse):       │
│  • dibujar()                         │
│  • perimetro()                       │
│                                      │
│ Concreto (implementación común):     │
│  • superficie() → retorna -1         │
└─────────────────────────────────────┘
        △
        │ extends
   ┌────┴─────┐
   │           │
   ↓           ↓
Rectángulo  Circunferencia  Línea
```

---

## 💾 Contenedor Polimórfico

```
PIZARRA
┌─────────────────────────────────────────┐
│  List<Figura> figuras                   │
│                                         │
│  ┌──────────────────────────────────┐   │
│  │ [0] → Rectángulo                 │   │
│  │       Real type: Rectangulo      │   │
│  │       Static type: Figura        │   │
│  ├──────────────────────────────────┤   │
│  │ [1] → Circunferencia             │   │
│  │       Real type: Circunferencia  │   │
│  │       Static type: Figura        │   │
│  ├──────────────────────────────────┤   │
│  │ [2] → Línea                      │   │
│  │       Real type: Linea           │   │
│  │       Static type: Figura        │   │
│  └──────────────────────────────────┘   │
│                                         │
│ OPERACIONES (Polimorfismo):            │
│                                         │
│ for (Figura fig : figuras) {            │
│   fig.dibujar();    // Cada una dibuja  │
│   fig.perimetro();  // diferente        │
│ }                                       │
└─────────────────────────────────────────┘
```

---

## 📐 Cálculos Matemáticos

```
RECTÁNGULO
┌─────────────────────────────┐
│        ▲ altura             │
│        │                    │
│   ┌────┴─────────────────┐  │
│   │                      │  │  ← base
│   └──────────────────────┘  │
│                             │
│ Perímetro = 2(b + h)        │
│ Superficie = b × h          │
└─────────────────────────────┘

CIRCUNFERENCIA
    ╱─────╲
   ╱       ╲      radio = r
  ╱    •    ╲     
 ╱   ╱ │ ╲   ╲    Perímetro = 2πr
│   │  r  │   │   Superficie = πr²
 ╲   ╲ │ ╱   ╱    
  ╲    •    ╱     
   ╲       ╱      
    ╲─────╱       

LÍNEA
─────────────────
    longitud = L

Perímetro = L
Superficie = N/A
```

---

## 🎨 Atributos de Figuras

```
TODA FIGURA TIENE:
├─ Propiedades de Dibujo
│  ├─ colorFondo: "Rojo"
│  └─ colorBorde: "Negro"
│
├─ Métodos Geométricos
│  ├─ perimetro() → double
│  ├─ superficie() → double (o -1 si N/A)
│  └─ dibujar() → void (ASCII art)
│
└─ Métodos de Utilidad
   ├─ setColorFondo(String)
   ├─ setColorBorde(String)
   ├─ getColorFondo() → String
   ├─ getColorBorde() → String
   └─ toString() → String
```

---

## 🔄 Ciclo de Vida de una Figura

```
1. CREACIÓN
   new Rectángulo(5, 3, "Rojo", "Negro")
        ↓
   Constructor invocado
        ↓
   Atributos inicializados
        ↓
   Objeto listo

2. AGREGACIÓN A PIZARRA
   pizarra.agregarFigura(rectángulo)
        ↓
   Se añade a la lista
        ↓
   Disponible en pizarra

3. MANIPULACIÓN
   pizarra.cambiarColorFondo(0, "Rosa")
        ↓
   Se accede a la figura por índice
        ↓
   Se invoca setColorFondo()
        ↓
   Color actualizado

4. CÁLCULOS
   pizarra.calcularSuperficieTotal()
        ↓
   Itera sobre todas las figuras
        ↓
   Invoca superficie() en cada una
        ↓
   Las subclases retornan sus valores
        ↓
   Se suman todos

5. ELIMINACIÓN
   pizarra.eliminarFigura(0)
        ↓
   Se remueve de la lista
        ↓
   Objeto elegible para garbage collection
```

---

## 📊 Métodos de Pizarra

```
PIZARRA
├─ GESTIÓN DE FIGURAS
│  ├─ agregarFigura(Figura)
│  ├─ eliminarFigura(int) → boolean
│  ├─ limpiar()
│  └─ cantidadFiguras() → int
│
├─ CONSULTAS GEOMÉTRICAS
│  ├─ calcularSuperficieTotal() → double
│  └─ calcularPerimetroTotal() → double
│
├─ MODIFICACIONES
│  ├─ cambiarColorFondo(int, String) → boolean
│  ├─ cambiarColorBorde(int, String) → boolean
│  └─ setColorFondoPizarra(String)
│
├─ VISUALIZACIÓN
│  ├─ dibujarTodasLasFiguras()
│  ├─ mostrarFiguras()
│  └─ obtenerFigura(int) → Figura
│
└─ ACCESO
   ├─ getColorFondoPizarra() → String
   └─ getFiguras() → List<Figura>
```

---

## 💡 Relaciones POO

```
HERENCIA ("es un/a")
┌──────────────────────┐
│ Un Rectángulo        │
│ ES una Figura        │
│                      │
│ Rectángulo extends   │
│ Figura               │
└──────────────────────┘

COMPOSICIÓN ("tiene un/a")
┌──────────────────────┐
│ Una Pizarra          │
│ TIENE Figuras        │
│                      │
│ Pizarra contains     │
│ List<Figura>         │
└──────────────────────┘

POLIMORFISMO (mismo nombre, diferente acción)
┌──────────────────────┐
│ Todas ejecutan:       │
│ figura.dibujar()      │
│                       │
│ Pero cada una dibuja  │
│ diferente             │
└──────────────────────┘
```

---

## 📈 Complejidad

```
OPERACIONES:                COMPLEJIDAD:
├─ agregarFigura()          O(1)     [add a list]
├─ eliminarFigura(idx)      O(n)     [remove from list]
├─ calcularSuperficie()     O(n)     [iterate all]
├─ calcularPerimetro()      O(n)     [iterate all]
├─ cambiarColor()           O(1)     [direct access]
└─ dibujarTodasLasFiguras() O(n·m)   [n figuras, m chars]
```

---

## 🎭 Polimorfismo en Acción

```
Código:
    for (Figura f : lista) {
        f.dibujar();
    }

Ejecución:
    Iteración 1: f apunta a Rectangulo
                 → Rectangulo.dibujar() (cuadro ASCII)
    
    Iteración 2: f apunta a Circunferencia
                 → Circunferencia.dibujar() (círculo ASCII)
    
    Iteración 3: f apunta a Linea
                 → Linea.dibujar() (línea ASCII)

RESULTADO: Diferentes comportamientos, mismo código.
```

---

*Documentación Visual - Ejercicio N°9*

