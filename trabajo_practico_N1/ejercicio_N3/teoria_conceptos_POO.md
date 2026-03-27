# Conceptos POO - Ejercicio N°3

## 📑 Tabla de Contenidos

1. **Conceptos Nuevos en Este Ejercicio**
2. **Cadena de Constructores (Constructor Chaining)**
3. **Super() Automático vs Explícito**
4. **Valores por Defecto de Atributos Java**
5. **Errores de Compilación Comunes en Constructores**
6. **Inicialización de Atributos en Herencia**
7. **Referencia a Conceptos Anteriores**

---

## ⭐ Conceptos Nuevos en Este Ejercicio

Este ejercicio se enfoca en **mecanismos internos de constructores** que los Ejercicios 1 y 2 no profundizaron:

| Concepto | Ej. 1 | Ej. 2 | Ej. 3 |
|----------|-------|-------|-------|
| Herencia | ✅ | ✅ | ✅ |
| Constructores | ❌ | ✅ (intro) | ✅ **NEW: Profundo** |
| `super()` automático | ❌ | ❌ | ✅ **NEW** |
| Valores por defecto | ❌ | ❌ | ✅ **NEW** |
| Errores de compilación de constructores | ❌ | ❌ | ✅ **NEW** |
| Inicialización en cadena | ❌ | ✅ (básico) | ✅ **NEW: Detallado** |

**→ Para Override de métodos, `private`, Shadowing, ver Ejercicio 2**

**→ Para Encapsulamiento básico, ver Ejercicio 1**

---

## 🏗️ Cadena de Constructores (Constructor Chaining)

### ¿Qué es Constructor Chaining?

**Constructor Chaining** es el proceso automático por el cual los constructores de una jerarquía de herencia se invocan en orden, desde el más general (Object) hasta el más específico.

### Flujo Completo con Herencia Multinivel

Cuando ejecutas `new C()` en una jerarquía `A → B → C`:

```
┌─────────────────────────────────────────┐
│ PUNTO 1: Se invoca new C()              │
│ (constructor de la clase más específica)│
└──────────────┬──────────────────────────┘
               │
               ↓
┌─────────────────────────────────────────┐
│ PUNTO 2: Control pasa a C()             │
│ ¿Hay super() explícito?                 │
│ - SI: Invocar super(args)               │
│ - NO: Java agrega super() automático    │
└──────────────┬──────────────────────────┘
               │
               ↓
┌─────────────────────────────────────────┐
│ PUNTO 3: super() invoca B()             │
│ ¿Hay super() explícito en B()?          │
│ - SI: Invocar super(args)               │
│ - NO: Java agrega super() automático    │
└──────────────┬──────────────────────────┘
               │
               ↓
┌─────────────────────────────────────────┐
│ PUNTO 4: super() en B invoca A()        │
│ ¿Hay super() explícito en A()?          │
│ - SI: Invocar super(args)               │
│ - NO: Java agrega super() automático    │
└──────────────┬──────────────────────────┘
               │
               ↓
┌─────────────────────────────────────────┐
│ PUNTO 5: super() en A invoca Object()   │
│ (clase raíz de todas las clases Java)   │
└──────────────┬──────────────────────────┘
               │
               ↓
┌─────────────────────────────────────────┐
│ PUNTO 6: Object() se ejecuta            │
│ (inicialización del respectivamente     │
└──────────────┬──────────────────────────┘
               │
               ↓ (Control retorna)
┌─────────────────────────────────────────┐
│ PUNTO 7: A() se completa                │
│ (resto del constructor de A)           │
└──────────────┬──────────────────────────┘
               │
               ↓ (Control retorna)
┌─────────────────────────────────────────┐
│ PUNTO 8: B() se completa                │
│ (resto del constructor de B)           │
└──────────────┬──────────────────────────┘
               │
               ↓ (Control retorna)
┌─────────────────────────────────────────┐
│ PUNTO 9: C() se completa                │
│ (resto del constructor de C)           │
│ Objeto completamente inicializado       │
└─────────────────────────────────────────┘
```

### Ejemplo Práctico con Código

```java
public class A {
    public A() {
        System.out.println("1. A() ejecutado");
    }
}

public class B extends A {
    public B() {
        System.out.println("2. B() - ANTES de super - no existe");
        super();  // Invoca A()
        System.out.println("3. B() - DESPUÉS de super");
    }
}

public class C extends B {
    public C() {
        System.out.println("4. C() - ANTES de super - no existe");
        super();  // Invoca B()
        System.out.println("5. C() - DESPUÉS de super");
    }
}

// Ejecución:
new C();

// Salida:
// 4. C() - ANTES de super
// 2. B() - ANTES de super
// 1. A() ejecutado
// 3. B() - DESPUÉS de super
// 5. C() - DESPUÉS de super
```

**Análisis de la salida:**

```
new C() invoca:
    ↓
    C() → "4. C() - ANTES de super"
    ↓
    super() → B()
    ↓
    B() → "2. B() - ANTES de super"
    ↓
    super() → A()
    ↓
    A() → "1. A() ejecutado"
    ↓
    Retorna a B() → "3. B() - DESPUÉS de super"
    ↓
    Retorna a C() → "5. C() - DESPUÉS de super"
```

---

## 🔄 Super() Automático vs Explícito

### ¿Cuándo se Agrega `super()` Automático?

Java **automáticamente** agrega `super()` en estas condiciones:

1. **NO hay `super()` explícito** en el constructor
2. **Y existe** un constructor sin parámetros en la clase padre

```java
// VARIANTE 3.1 Y 3.2
public class Base {
    public Base() {  // ← Constructor sin parámetros EXISTE
        i = 100;
    }
}

public class Hija extends Base {
    public Hija() {
        // Java agrega automáticamente: super();
        j = 120;
    }
}
```

### ¿Cuándo se Produce Error?

Java **NO puede** agregar `super()` automático si:

1. NO hay `super()` explícito
2. **Y NO existe** constructor sin parámetros en la clase padre

```java
// VARIANTE 3.3
public class Base {
    public Base(int n) {  // ← Solo constructor CON parámetros
        i = n;           // ← Constructor sin parámetros NO EXISTE
    }
}

public class Hija extends Base {
    public Hija() {
        // Java intenta agregar: super() ← ¡FALLA!
        //                             ↓
        //                   Base() NO EXISTE
        //                   ❌ COMPILACIÓN ERROR
        j = 120;
    }
}
```

### Comparativa: Automático vs Explícito

| Situación | Código | Super | Resultado |
|-----------|--------|-------|-----------|
| Base() existe | `Hija() { j=120; }` | Automático: `super()` | ✅ Compila |
| Base(int) solo | `Hija() { j=120; }` | Automático: intenta `super()` | ❌ Error |
| Base(int) solo | `Hija() { super(10); j=120; }` | Explícito: `super(10)` | ✅ Compila |

---

## 💾 Valores por Defecto de Atributos Java

### ¿Por Qué Importa en Herencia?

En el Ejercicio 3.2, `j` **no se inicializa explícitamente**, pero aún así tiene un valor definido. Esto es porque Java garantiza valores por defecto.

### Tabla de Valores por Defecto

```
┌──────────────┬─────────────────────┬──────────────────────┐
│ Tipo         │ Valor por Defecto   │ Equivalente          │
├──────────────┼─────────────────────┼──────────────────────┤
│ byte         │ 0                   │ (byte) 0             │
├──────────────┼─────────────────────┼──────────────────────┤
│ short        │ 0                   │ (short) 0            │
├──────────────┼─────────────────────┼──────────────────────┤
│ int          │ 0                   │                      │
├──────────────┼─────────────────────┼──────────────────────┤
│ long         │ 0L                  │ 0L                   │
├──────────────┼─────────────────────┼──────────────────────┤
│ float        │ 0.0f                │ 0.0f                 │
├──────────────┼─────────────────────┼──────────────────────┤
│ double       │ 0.0 (0.0d)          │                      │
├──────────────┼─────────────────────┼──────────────────────┤
│ boolean      │ false               │                      │
├──────────────┼─────────────────────┼──────────────────────┤
│ char         │ '\u0000'            │ (carácter nulo)      │
├──────────────┼─────────────────────┼──────────────────────┤
│ Object       │ null                │ (referencia nula)    │
│ (String,etc) │                     │                      │
└──────────────┴─────────────────────┴──────────────────────┘
```

### Diferencia: Atributos vs Variables Locales

**Atributos de clase: siempre tienen valor por defecto**

```java
public class Hija extends Base {
    private int j;  // ← Atributo: siempre inicializado a 0
    
    public int getJ() {
        return j;   // ← Siempre retorna 0 si no se asignó otro valor
    }
}
```

**Variables locales en métodos: NO tienen valor por defecto**

```java
public class Ejemplo {
    public void metodo() {
        int x;          // ← Variable local
        System.out.println(x);  // ❌ ERROR: x no está inicializada
    }
}
```

### Aplicación en Ejercicio 3.2

```java
public class Hija extends Base {
    private int j;  // ← Atributo primitivo (int)
    
    public Hija() {
        // j no se asigna explícitamente
        // Pero Java garantiza: j = 0
    }
    
    public int getJ() {
        return j;   // Retorna 0
    }
}

// Ejecución en Prueba:
Hija x = new Hija();
System.out.println("Atributo j de X: " + x.getJ());
// Salida: "Atributo j de X: 0"
```

---

## ❌ Errores de Compilación Comunes

### Error 1: Constructor Sin Parámetros No Existe

```java
public class Base {
    public Base(int n) {
        i = n;
    }
    // Base() NO EXISTE
}

public class Hija extends Base {
    public Hija() {
        // ❌ ERROR: super() automático busca Base()
        j = 120;
    }
}
```

**Mensaje del compilador:**
```
error: constructor Base in class Base cannot be applied to given types;
  required: int
  found: no arguments
```

**Solución:**

```java
public class Hija extends Base {
    public Hija() {
        super(100);  // ← Explícito con argumento
        j = 120;
    }
}
```

### Error 2: Olvidar `super()` Cuando es Obligatorio

```java
public class Base {
    public Base(int n, String s) {
        // Constructor solo con parámetros
    }
}

public class Hija extends Base {
    public Hija(int value) {
        // ❌ ERROR: ¿Cómo invocar Base?
        // No hay Constructor sin parámetros
    }
}
```

**Solución:**

```java
public class Hija extends Base {
    public Hija(int value) {
        super(value, "nombre");  // ← Invoke con argumentos requeridos
    }
}
```

### Error 3: `super()` Debe ser la Primera Línea

```java
public class Hija extends Base {
    public Hija() {
        j = 120;        // ❌ ERROR: Línea antes de super()
        super();        // NO puede estar aquí
    }
}
```

**Solución:**

```java
public class Hija extends Base {
    public Hija() {
        super();        // ✅ Debe ser primera línea
        j = 120;
    }
}
```

---

## 🔌 Inicialización de Atributos en Herencia

### Orden de Inicialización Completo

Cuando se crea un objeto con herencia, los atributos se inicializan en este orden:

**1. Valores por defecto** (en tiempo de declaración)

```java
public class Base {
    private int i;      // ← Inicializado a 0 (por defecto)
}

public class Hija extends Base {
    private int j;      // ← Inicializado a 0 (por defecto)
}
```

**2. Bloques inicializadores estáticos** (solo una vez, al cargar la clase)

```java
public class Base {
    static {
        System.out.println("Bloque estático de Base");
    }
}
```

**3. Inicializadores de instancia** (antes del constructor)

```java
public class Hija extends Base {
    private int j;
    
    {
        // Bloque inicializador (no estático)
        // Se ejecuta ANTES del constructor
        System.out.println("Inicializador de Hija");
    }
    
    public Hija() {
        // Constructor
    }
}
```

**4. Constructor** (desde padre hasta hijo)

```java
Base() → Hija()
```

### Ejemplo Completo

```java
public class Base {
    private int i = 50;  // Inicialización en declaración
    
    static {
        System.out.println("1. Bloque estático Base");
    }
    
    {
        System.out.println("2. Inicializador Base");
    }
    
    public Base() {
        System.out.println("3. Constructor Base, i=" + i);
        i = 100;
    }
}

public class Hija extends Base {
    private int j = 60;  // Inicialización en declaración
    
    static {
        System.out.println("0.1 Bloque estático Hija");
    }
    
    {
        System.out.println("4. Inicializador Hija");
    }
    
    public Hija() {
        super();
        System.out.println("5. Constructor Hija, j=" + j);
        j = 120;
    }
}

// Ejecución:
new Hija();

// Salida (primer llamado de la clase):
// 0. Bloque estático Base
// 0.1 Bloque estático Hija
// (Bloques estáticos ocurren UNA SOLA VEZ al cargar clases)
//
// 2. Inicializador Base
// 3. Constructor Base, i=100
// 4. Inicializador Hija
// 5. Constructor Hija, j=120
```

### Aplicación en Ejercicio 3

**Variante 3.1/3.4 (Ambos con constructores):**

```
┌─────────────────────────────────────┐
│ 1. Valores por defecto              │
│    Base: i = 0                      │
│    Hija: j = 0                      │
├─────────────────────────────────────┤
│ 2. Constructor Base()               │
│    i = 100 (o 110 en variante 3.4) │
├─────────────────────────────────────┤
│ 3. Constructor Hija()               │
│    j = 120                          │
└─────────────────────────────────────┘
```

---

## 🔗 Referencia: Conceptos de Ejercicios Anteriores

Para información sobre estos conceptos, consulta los documentos de los Ejercicios 1 y 2:

- **Herencia**: Ejercicio 1
- **Override de Métodos**: Ejercicio 2
- **Visibilidad Private**: Ejercicio 2
- **Encapsulamiento**: Tanto Ejercicio 1 como 2

---

## 📋 Comparativa: Variantes 3.1 a 3.4

```
╔════════════════════════════════════════════════════════════════════════╗
║ VARIANTE 3.1: Ambos con constructores                                  ║
╠════════════════════════════════════════════════════════════════════════╣
║ Base: Base()          ← Existe                                         ║
║ Hija: Hija()          ← Existe (super() automático de Java)            ║
║ Salida: j=120, i=100                                                   ║
║ ✅ COMPILA                                                             ║
╚════════════════════════════════════════════════════════════════════════╝

╔════════════════════════════════════════════════════════════════════════╗
║ VARIANTE 3.2: Hija sin constructor explícito                           ║
╠════════════════════════════════════════════════════════════════════════╣
║ Base: Base()          ← Existe                                         ║
║ Hija: Hija()          ← Implicito (Java lo crea)                       ║
║ Salida: j=0, i=100                                                     ║
║ ✅ COMPILA                                                             ║
╚════════════════════════════════════════════════════════════════════════╝

╔════════════════════════════════════════════════════════════════════════╗
║ VARIANTE 3.3: Base sin constructor sin parámetros                      ║
╠════════════════════════════════════════════════════════════════════════╣
║ Base: Base(int n)     ← Existe (solo con parámetros)                   ║
║ Hija: Hija()          ← Intenta super() → FALLA                        ║
║ Salida: N/A                                                            ║
║ ❌ NO COMPILA                                                          ║
╚════════════════════════════════════════════════════════════════════════╝

╔════════════════════════════════════════════════════════════════════════╗
║ VARIANTE 3.4: super() explícito con argumento                          ║
╠════════════════════════════════════════════════════════════════════════╣
║ Base: Base(int n)     ← Existe (solo con parámetros)                   ║
║ Hija: Hija()          ← super(110) explícito                           ║
║ Salida: j=120, i=110                                                   ║
║ ✅ COMPILA                                                             ║
╚════════════════════════════════════════════════════════════════════════╝
```

---

## 💡 Resumen de Conceptos Nuevos

### Constructor Chaining
- Cadena automática desde clase más específica hasta Object
- `super()` invoca el constructor del padre
- Orden: padre primero, luego hijo

### Super() Automático
- Java agrega automáticamente si NO existe explícitamente
- SOLO si existe constructor sin parámetros en el padre
- Si no exis apunta ERROR de compilación

### Valores por Defecto
- Todos los atributos primitivos tienen valor por defecto (0, false, etc.)
- Garant Java, independientemente de inicialización explícita
- NO aplica a variables locales

### Inicialización Completa
1. Valores por defecto declaración
2. Bloques estáticos (una vez)
3. inicializadores (instancia)
4. Constructor

---

## ❓ Preguntas de Autoevaluación

1. **¿Por qué la Variante 3.3 produce error de compilación?**
   - Porque Base() no existe (solo Base(int))
   - Java intenta agregar super() automático pero falla

2. **¿Cuál es el valor de `j` en la Variante 3.2?**
   - 0 (valor por defecto de int en Java)
   - No se inicializa explícit, pero se garantiza 0

3. **¿Cuál es la diferencia entre `super()` y `super(110)`?**
   - `super()` invoca constructor sin parámetros
   - `super(110)` invoca constructor con parámetro int

4. **¿Qué pasa si no incluyes `super()` explícitamente cuando es obligatorio?**
   - ERROR DE COMPILACIÓN
   - "constructor Base in class Base cannot be applied to given types"

---

## 📚 Recursos Complementarios

Para profundizar:
- Constructor Overloading (Multiple constructores en la misma clase)
- Bloque inicializador vs Constructor
- Principio de DRY aplicado a constructores
- Comparación: Java vs otros lenguajes en herencia de constructores
