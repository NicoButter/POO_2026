# Ejercicio N°3: Constructores en Herencia - Análisis de Salidas

## 📋 Enunciado General

Se proporciona el siguiente programa de prueba:

```java
public class Prueba {
    public static void main(String[] args) {
        Hija x;
        x = new Hija();
        System.out.println("Atributo j de X: " + x.getJ());
        System.out.println("Atributo i de X: " + x.getI());
    }
}
```

Se analizan **4 variantes diferentes** de las clases `Base` e `Hija`, observando cómo cambia el comportamiento de los constructores en distintas situaciones.

---

## 🔍 Variante 3.1: Clase Base y Clase Derivada Tienen Constructores

### Código

```java
public class Base {
    private int i;
    public Base() {
        i = 100;
    }
    public int getI() {
        return i;
    }
}

public class Hija extends Base {
    private int j;
    public Hija() {
        j = 120;
    }
    public int getJ() {
        return j;
    }
}
```

### Análisis de Ejecución

**Paso 1:** Se crea `new Hija()`

```
new Hija()
    ↓
Hija() { ... }
    ↓
¿Hay super() explícito? NO
    ↓
Java agrega automáticamente: super()
    ↓
Invoca: Base() 
    ↓
Base() { i = 100; }
    ↓
Control retorna a Hija()
    ↓
Hija() { j = 120; }
```

**Paso 2:** Se asigna a variable `x`

```
x = new Hija()
    └─ x.i = 100 (heredado de Base, inicializado en Base())
    └─ x.j = 120 (propio de Hija, inicializado en Hija())
```

**Paso 3:** Se ejecutan los getters

```java
x.getJ()  // retorna 120
x.getI()  // retorna 100
```

### Salida

```
Atributo j de X: 120
Atributo i de X: 100
```

### ✅ Estado de Compilación

**COMPILA EXITOSAMENTE** ✅

---

## 🔍 Variante 3.2: Clase Derivada NO Tiene Constructor

### Código

```java
public class Base {
    private int i;
    public Base() {
        i = 100;
    }
    public int getI() {
        return i;
    }
}

public class Hija extends Base {
    private int j;
    public int getJ() {
        return j;
    }
}
```

### Análisis de Ejecución

**Paso 1:** Se crea `new Hija()`

```
new Hija()
    ↓
¿Hija tiene constructor explícito? NO
    ↓
Java genera automáticamente: public Hija() { super(); }
    ↓
Se invoca: super()
    ↓
Base() { i = 100; }
    ↓
Control retorna a Hija() implícito
```

**Paso 2:** Estado del objeto

```
x.i = 100 (heredado, inicializado en Base())
x.j = ?   (NO inicializado - valor por defecto: 0)
```

**Explicación de `j`:**
- `j` es `private int` y no fue inicializado explícitamente
- En Java, los atributos de tipo primitivo (`int`) se inicializan automáticamente a `0`
- Por lo tanto, `j` tiene valor `0`

**Paso 3:** Se ejecutan los getters

```java
x.getJ()  // retorna 0 (valor por defecto de int)
x.getI()  // retorna 100
```

### Salida

```
Atributo j de X: 0
Atributo i de X: 100
```

### ✅ Estado de Compilación

**COMPILA EXITOSAMENTE** ✅

**Conclusión:** Aunque `j` no se inicialice explícitamente, Java garantiza que sea `0`.

---

## 🔍 Variante 3.3: Clase Base NO Tiene Constructor Sin Argumentos

### Código

```java
public class Base {
    private int i;
    public Base(int n) {
        i = n;
    }
    public int getI() {
        return i;
    }
}

public class Hija extends Base {
    private int j;
    public Hija() {
        j = 120;
    }
    public int getJ() {
        return j;
    }
}
```

### Análisis de Compilación

**Paso 1:** Se intenta compilar

```
Compilador analiza: public class Hija extends Base
    ↓
¿Hija tiene constructor explícito? SÍ: Hija()
    ↓
En el constructor Hija(), ¿hay super() explícito? NO
    ↓
Compilador intenta agregar automáticamente: super()
    ↓
¿Base() existe en Base? NO (solo existe Base(int n))
    ↓
❌ ERROR DE COMPILACIÓN
```

### ❌ Error de Compilación

```
error: constructor Base in class Base cannot be applied to given types;
  required: int
  found: no arguments
  reason: actual and formal argument lists differ in length
```

### Error en la Línea

```java
public Hija() {  // ← AQUÍ

    j = 120;
}
```

### Explicación

- Cuando Java intenta agregar automáticamente `super()`, pero la clase padre **NO tiene** un constructor sin argumentos, la compilación **falla**
- Es necesario invocar explícitamente `super(valor)` con los argumentos requeridos

### ✅ Solución

```java
public class Hija extends Base {
    private int j;
    public Hija() {
        super(100);  // ← Invocar explícitamente con argumento
        j = 120;
    }
    public int getJ() {
        return j;
    }
}
```

**Con esta corrección, el programa compila y produce:**

```
Atributo j de X: 120
Atributo i de X: 100
```

---

## 🔍 Variante 3.4: Clase Base Tiene Constructor con Argumentos (SOLUCIÓN)

### Código

```java
public class Base {
    private int i;
    public Base(int n) {
        i = n;
    }
    public int getI() {
        return i;
    }
}

public class Hija extends Base {
    private int j;
    public Hija() {
        super(110);  // ← Invoca explícitamente con argumento
        j = 120;
    }
    public int getJ() {
        return j;
    }
}
```

### Análisis de Ejecución

**Paso 1:** Se crea `new Hija()`

```
new Hija()
    ↓
Hija() {
    super(110);  // ← Invoca Base(110)
    j = 120;
}
    ↓
Base(int n) { i = n; }
    ↓
i = 110
    ↓
Control retorna a Hija()
    ↓
j = 120
```

**Paso 2:** Estado del objeto

```
x.i = 110 (heredado, inicializado con super(110))
x.j = 120 (propio de Hija)
```

**Paso 3:** Se ejecutan los getters

```java
x.getJ()  // retorna 120
x.getI()  // retorna 110
```

### Salida

```
Atributo j de X: 120
Atributo i de X: 110
```

### ✅ Estado de Compilación

**COMPILA EXITOSAMENTE** ✅

---

## 📊 Tabla Comparativa de Variantes

```
┌──────────────────────┬─────────┬─────────┬──────────────────┬────────────┐
│ Variante             │ Compila │ x.getJ()│ x.getI()         │ Razón      │
├──────────────────────┼─────────┼─────────┼──────────────────┼────────────┤
│ 3.1: Ambos con       │   ✅    │   120   │  100             │ super()    │
│      constructores   │         │         │  automático      │            │
├──────────────────────┼─────────┼─────────┼──────────────────┼────────────┤
│ 3.2: Hija sin        │   ✅    │    0    │  100             │ Constructor│
│      constructor     │         │         │  implícito de    │            │
│                      │         │         │  Hija + super()  │            │
├──────────────────────┼─────────┼─────────┼──────────────────┼────────────┤
│ 3.3: Base sin        │   ❌    │   ---   │  ---             │ super()    │
│      constructor()   │         │         │  automático falla│            │
├──────────────────────┼─────────┼─────────┼──────────────────┼────────────┤
│ 3.4: super()         │   ✅    │   120   │  110             │ super(110) │
│      explícito       │         │         │  explícito       │            │
└──────────────────────┴─────────┴─────────┴──────────────────┴────────────┘
```

---

## 🎯 Conclusiones Principales

### ✅ Conclusión 1: Constructor Implícito de Hija

**Cuando `Hija` NO define constructor explícito, Java crea automáticamente:**

```java
public Hija() {
    super();
}
```

Esto es equivalente a 3.2.

### ✅ Conclusión 2: `super()` Automático

**Cuando NO hay `super()` explícito en el constructor de `Hija`, Java agrega automáticamente:**

```java
public Hija() {
    super();  // ← Automático (solo si Base() existe)
    j = 120;
}
```

### ❌ Conclusión 3: Error Cuando no Existe Constructor Sin Parámetros

**Si la clase padre solo tiene constructores CON parámetros:**

```java
// Base(int n) existe, pero Base() NO
// Resultado: COMPILACIÓN ERROR
public Hija() {
    // super() automático falla → j = 120;
}
```

**Solución obligatoria:**

```java
public Hija() {
    super(110);  // ← EXPLÍCITO con parámetros
    j = 120;
}
```

### ✅ Conclusión 4: Valores por Defecto de Atributos

**En Java, los atributos NO inicializados explícitamente tienen valores por defecto:**

```
int  → 0
long → 0L
double → 0.0
boolean → false
Object → null
```

Ejemplo en 3.2: `int j` sin inicialización → valor `0`

### ✅ Conclusión 5: Cadena de Constructores

**La cadena de constructores SIEMPRE sigue el patrón:**

```
Constructor más específico (Hija)
    ↓
    super() → Constructor papá (Base)
    ↓
    Constructor papá se completa
    ↓
    Control retorna a constructor hijo
    ↓
    Constructor hijo se completa
```

**Aplicación en cada variante:**

| Variante | Cadena |
|----------|--------|
| 3.1 | `Hija()` → `super()` automático → `Base()` |
| 3.2 | `Hija()` implícito → `super()` automático → `Base()` |
| 3.3 | ❌ `super()` automático falla |
| 3.4 | `Hija()` → `super(110)` explícito → `Base(110)` |

---

## 🔑 Reglas Clave a Recordar

### Regla 1: Toda clase hereda constructores
> Todo constructor de una subclase DEBE invocar un constructor de la superclase (explícita o implícitamente).

### Regla 2: `super()` es automático
> Si NO escribes `super()` explícitamente, Java lo agrega automáticamente (solo si existe constructor sin parámetros).

### Regla 3: Constructor sin parámetros requerido
> Si la clase padre SOLO tiene constructores CON parámetros, DEBES invocar `super(args)` explícitamente.

### Regla 4: Inicialización en cadena
> Los atributos se inicializan "de arriba hacia abajo" (desde Object hasta la clase más específica).

### Regla 5: Valores por defecto
> Todos los atributos primitivos se inicializan a valores por defecto (0, false, etc.) incluso sin inicialización explícita.

---

## 💡 Errores Comunes

### ❌ Error 1: Olvidar `super()` cuando es obligatorio

```java
// Padece cuando Base(int n) es el ÚNICO constructor
public Hija() {  // ❌ COMPILACIÓN ERROR
    j = 120;
}

// ✅ CORRECTO
public Hija() {
    super(100);
    j = 120;
}
```

### ❌ Error 2: Confundir valores por defecto

```java
public class Hija extends Base {
    private int j;  // ← ¿Cuánto vale j?
    
    public int getJ() {
        return j;  // En 3.2: retorna 0 (no undefined)
    }
}
```

### ❌ Error 3: Olvidar que `int` tiene valor por defecto

```java
// En 3.2:
int j;  // ← NO está "sin inicializar"
        // ← Tiene valor por defecto: 0
        // ← NO es null ni undefined
```

---

## 📚 Resumen de Salidas

```
VARIANTE 3.1 → Compila ✅ → j=120, i=100
VARIANTE 3.2 → Compila ✅ → j=0,   i=100
VARIANTE 3.3 → Error ❌   → (no compila)
VARIANTE 3.4 → Compila ✅ → j=120, i=110
```
