# Conceptos POO - Ejercicio N°2

## 📑 Tabla de Contenidos

1. **Conceptos Nuevos en Este Ejercicio**
2. **Constructores en Jerarquías de Herencia**
3. **Sobrescritura (Override) de Métodos**
4. **Visibilidad: Métodos Private y Herencia**
5. **Shadowing (Sombreamiento de Atributos)**
6. **Polimorfismo en Acción**
7. **Referencia a Conceptos del Ejercicio 1**

---

## ⭐ Conceptos Nuevos en Este Ejercicio

Este ejercicio profundiza en conceptos que el **Ejercicio 1 no abordó en detalle**:

| Concepto | Ejercicio 1 | Ejercicio 2 |
|----------|------------|-----------|
| Herencia Básica | ✅ (introducida) | ✅ (profundizada) |
| Encapsulamiento | ✅ (access modifiers) | ✅ (private methods) |
| Polimorfismo (general) | ✅ (concepto general) | ✅ **Override específico** |
| Constructores | ❌ (no explorados) | ✅ **NEW: Super y cadena** |
| Override de métodos | ❌ (no explorados) | ✅ **NEW: Sobrescritura** |
| Métodos private | ❌ (no explorados) | ✅ **NEW: No heredables** |
| Shadowing | ❌ (no explorados) | ✅ **NEW: Variable shadowing** |

**→ Para teoría de Herencia, Encapsulamiento y Polimorfismo general, ver `teoria_conceptos_POO.md` del Ejercicio 1**

---

## 🏗️ Constructores en Jerarquías de Herencia

### ¿Qué es `super()`?

`super()` es una **referencia implícita al constructor de la clase padre**. Permite invocar explícitamente el constructor de la superclase.

```java
public class A {
    private int atributoA;
    
    public A() {
        this.atributoA = 5;
        System.out.println("Constructor A ejecutado");
    }
}

public class B extends A {
    private int atributoB;
    
    public B() {
        super();  // ← Invoca explícitamente el constructor de A
        this.atributoB = 2;
        System.out.println("Constructor B ejecutado");
    }
}
```

### Cadena de Inicialización: El Flujo Completo

Cuando se crea un objeto `B`:

```
new B()
        ↓
B() { super(); ... }
        ↓
    (invoca super())
        ↓
A() { this.atributoA = 5; }
        ↓
    (A() finaliza, atributoA = 5)
        ↓
    (control retorna a B())
        ↓
B() { this.atributoB = 2; }
        ↓
    (B() finaliza, atributoB = 2)
        ↓
Objeto B completamente inicializado
```

### Con Herencia Multinivel (A → B → C)

```
new C()
        ↓
C() { super(); ... }
        ↓
    (invoca super())
        ↓
B() { super(); ... }
        ↓
    (invoca super())
        ↓
A() { this.atributoA = 5; }
        ↓
    (A() retorna)
        ↓
B() { this.atributoB = 2; } 
        ↓
    (B() retorna)
        ↓
C() { this.atributoC = 0; this.atributoB = 7; }
        ↓
Objeto C completamente inicializado
```

### ¿Qué pasa si NO invoco `super()`?

**Java automáticamente invoca el constructor sin parámetros de la clase padre**.

```java
public class B extends A {
    public B() {
        // super();  ← Aunque no lo escribas explícitamente, Java lo hace
        this.atributoB = 2;
    }
}
// Java automáticamente convierte esto en:
// public B() {
//     super();  ← Agregado automáticamente
//     this.atributoB = 2;
// }
```

**IMPORTANTE:** Si la clase padre NO tiene un constructor sin parámetros, DEBES invocar `super(...)` con los parámetros correspondientes:

```java
public class A {
    public A(String nombre) {  // ← Constructor CON parámetros
        System.out.println("Nombre: " + nombre);
    }
}

public class B extends A {
    public B() {
        super("Miclase");  // ← OBLIGATORIO: indicar parámetros
    }
}

public class B extends A {
    public B() {
        // ERROR: A() no existe (A solo tiene A(String))
    }
}
```

---

## 🔄 Sobrescritura (Override) de Métodos

### ¿Qué es Override?

**Override** es cuando una clase hija **redefine un método de la clase padre** con la misma firma (nombre y parámetros), pero diferente implementación.

```java
// Clase Padre
public class A {
    public void metodoA() {
        System.out.println("Método A");
    }
}

// Clase Hija
public class B extends A {
    @Override  // ← Anotación (opcional pero recomendada)
    public void metodoA() {
        System.out.println("Método redefinido en B");
    }
}
```

### Polimorfismo en Tiempo de Ejecución

```java
A objA = new A();
objA.metodoA();  // Salida: "Método A"

B objB = new B();
objB.metodoA();  // Salida: "Método redefinido en B"

// Polimorfismo: referencia de tipo A, objeto de tipo B
A ref = new B();
ref.metodoA();  // Salida: "Método redefinido en B" ← Polimorfismo!
                // Se ejecuta la versión de B, no la de A
```

### Reglas del Override

| Característica | Regla |
|---|---|
| **Nombre del método** | Debe ser exactamente igual |
| **Parámetros** | Deben ser exactamente iguales (número, tipos, orden) |
| **Return type** | Debe ser el mismo o compatible (covariance) |
| **Modificador de acceso** | No puede ser más restrictivo que en la clase padre |
| **Excepciones** | No puede lanzar nuevas excepciones checked |

**DIFERENCIA: Override vs Overload**

```
Override: Mismo método en clase padre e hija (polimorfismo)
   - Mismo nombre, mismos parámetros
   - Clase hija redefine el método del padre
   
Overload: Múltiples métodos con el mismo nombre (polimorfismo estático)
   - Mismo nombre, DIFERENTES parámetros
   - En la MISMA clase o entre clases
```

**Ejemplo:**

```java
public class Calculadora {
    // Overload: múltiples métodos sumar en la MISMA clase
    public int sumar(int a, int b) {
        return a + b;
    }
    
    public double sumar(double a, double b) {
        return a + b;
    }
}
```

### Cómo Verificar Override

La anotación `@Override` ayuda a detectar errores:

```java
public class B extends A {
    @Override
    public void metodoA() {  // ✅ Correcto
        System.out.println("Override");
    }
    
    @Override
    public void metodoBBBB() {  // ❌ ERROR: no existe en A
                                 // Compilador detecta el error
    }
}
```

### Invocar el Método Original con `super`

A veces es útil invocar la versión de la clase padre:

```java
public class B extends A {
    @Override
    public void metodoA() {
        super.metodoA();  // ← Invoca la versión de A
        System.out.println("Método redefinido en B");
    }
}

B objB = new B();
objB.metodoA();
// Salida:
// "Método A"                           ← super.metodoA()
// "Método redefinido en B"            ← El resto del método
```

---

## 🔒 Visibilidad: Métodos Private y Herencia

### ¿Qué Significa `private`?

`private` = **solo accesible dentro de la MISMA clase**. NO es heredable.

```java
public class B {
    private void metodoP() {
        System.out.println("Método privado");
    }
}

public class C extends B {
    public void usarMetodoP() {
        metodoP();  // ❌ ERROR: metodoP() is not visible
                    // ERROR: has private access in B
    }
}

C objC = new C();
objC.metodoP();  // ❌ ERROR: no visible desde fuera
```

### Tabla de Visibilidad en Herencia

```
┌─────────────────────┬────────┬─────────┬───────────┬─────────────┐
│ Modificador         │ Clase  │ Paquete │ Subclase  │ Todo el App │
├─────────────────────┼────────┼─────────┼───────────┼─────────────┤
│ private             │   ✅   │   ❌    │    ❌     │     ❌      │
├─────────────────────┼────────┼─────────┼───────────┼─────────────┤
│ (default/package)   │   ✅   │   ✅    │    ❌*    │     ❌      │
├─────────────────────┼────────┼─────────┼───────────┼─────────────┤
│ protected           │   ✅   │   ✅    │    ✅     │     ❌      │
├─────────────────────┼────────┼─────────┼───────────┼─────────────┤
│ public              │   ✅   │   ✅    │    ✅     │     ✅      │
└─────────────────────┴────────┴─────────┴───────────┴─────────────┘

* Default/package: solo si la subclase está en el MISMO paquete
```

### Caso de Estudio: `metodoP()` en el Ejercicio 2

```java
public class B {
    private void metodoP() {
        System.out.println("Método privado");
    }
}
```

```
¿Quién puede acceder a metodoP()?
├─ B (su clase) → ✅ SÍ
├─ C (subclase de B) → ❌ NO (private no se hereda)
├─ A (superclase de B) → ❌ NO (A y B no tienen relación)
└─ Cualquier otra clase → ❌ NO
```

---

## 👥 Shadowing (Sombreamiento de Atributos)

### ¿Qué es Shadowing?

**Shadowing** ocurre cuando una clase define un atributo con el **mismo nombre que un atributo heredado**. El atributo de la subclase **sombrea** (oculta) al del padre.

```java
public class B {
    private int atributoB = 2;  // ← atributoB de B
}

public class C extends B {
    private int atributoB = 7;  // ← atributoB de C (SOMBREA el de B)
}

C objC = new C();
objC.atributoB;  // ← ¿Cuál es? ¿El 2 de B o el 7 de C?
```

### Ambos Existen, pero Uno Sombrea al Otro

```
Objeto C en Memoria:
┌────────────────────────────────┐
│ Original:                      │
│ ├─ atributoB (heredado de B): 2│  ← Existe pero SOMBREADO
│ Propio de C:                   │
│ └─ atributoB (definido en C): 7│  ← Este "GANA"
└────────────────────────────────┘

Cuando accedes a objC.atributoB → Devuelve 7 (el de C)
```

### Accediendo al Atributo Sombreado

```java
public class C extends B {
    private int atributoB = 7;  // Sombrea el de B
    
    public void mostrarAmbos() {
        System.out.println(this.atributoB);       // 7 (el de C)
        System.out.println(super.atributoB);      // ❌ ERROR: super no aplica para atributos
                                                   // (super es para métodos, no para atributos)
    }
}
```

**Problema:** No hay forma de acceder directamente al atributo sombreado de B.

### ¿Cuándo Ocurre Shadowing?

| Situación | Resultado |
|-----------|-----------|
| `B objB = new B()` | objB.atributoB = 2 (el de B) |
| `C objC = new C()` | objC.atributoB = 7 (el de C, sombrea) |
| `B ref = new C()` | ref.atributoB = 2 (sigue siendo el de B, aunque referencie un C) |

```java
B ref = new C();
System.out.println(ref.atributoB);  // 2 (tipo de referencia es B, así accede al de B)
                                     // NO polimorfismo para atributos
                                     // (el polimorfismo solo aplica a métodos)
```

### Anti-patrón: Evitar Shadowing

**NO RECOMENDADO:** Redefinir atributos heredados

```java
// ❌ MAL: Shadowing
public class B {
    protected int valor = 2;
}

public class C extends B {
    private int valor = 7;  // ← Sombrea el de B
}

// ✅ BIEN: Usar diferentes nombres
public class C extends B {
    private int valorC = 7;  // Nombre distinto
}
```

---

## 🎯 Polimorfismo en Acción

### Polimorfismo = "Muchas Formas"

El **polimorfismo** permite que una referencia de tipo padre apunte a objetos de tipo hijo, ejecutando el método apropiado del hijo en tiempo de ejecución.

### Ejemplo: Ejercicio 2

```java
// Sin Polimorfismo: necesitarías múltiples variables
A objA = new A();
B objB = new B();
C objC = new C();

objA.metodoA();  // Salida: "Método A"
objB.metodoA();  // Salida: "Método redefinido en B"
objC.metodoA();  // Salida: "Método redefinido en B"

// Con Polimorfismo: usar referencias del padre
A ref1 = new A();
A ref2 = new B();
A ref3 = new C();

ref1.metodoA();  // Salida: "Método A"
ref2.metodoA();  // Salida: "Método redefinido en B"  ← Polimorfismo!
ref3.metodoA();  // Salida: "Método redefinido en B"  ← Polimorfismo!
```

### Búsqueda de Métodos en Tiempo de Ejecución

```
ref2.metodoA()  (ref2 tiene tipo A pero referencia un objeto B)
        ↓
¿Dónde busca el método?
        ↓
1. Primero en la clase del OBJETO (B) → ¿metodoA() existe en B?
        ↓
SI → Ejecuta B.metodoA() ← "Método redefinido en B"
NO → Busca en superclase A → ¿metodoA existe en A?
        ↓
SI → Ejecuta A.metodoA()
NO → Busca en superclase de A... (y así sucesivamente)
```

### Ventajas del Polimorfismo

```java
// Procesar múltiples tipos sin condicionales
public void procesarObjetos(A[] objetos) {
    for (A objeto : objetos) {
        objeto.metodoA();  // ← Cada uno ejecuta su versión
                           // Sin if (objeto instanceof B) ...
    }
}

// Uso:
A[] misObjetos = {new A(), new B(), new C()};
procesarObjetos(misObjetos);

// Salida:
// "Método A"
// "Método redefinido en B"
// "Método redefinido en B"
```

### Polimorfismo vs Atributos

**IMPORTANTE:** El polimorfismo SOLO aplica a MÉTODOS, NO a atributos.

```java
public class A {
    public int valor = 1;
}

public class B extends A {
    public int valor = 2;  // Sombrea el de A
}

A ref = new B();
System.out.println(ref.valor);  // 1 (de A, NO polimorfismo)
                                 // Usa el tipo de la referencia (A), no del objeto (B)

B obj = new B();
System.out.println(obj.valor);  // 2 (de B)
```

---

## 🔗 Referencia: Conceptos del Ejercicio 1

Para información sobre estos conceptos, consulta `teoria_conceptos_POO.md` del Ejercicio 1:

- **Herencia Básica**: Concepto general, jerarquías simples, palabra clave `extends`
- **Encapsulamiento**: Access modifiers (`public`, `private`), getters/setters, principios de ocultación
- **Polimorfismo General**: Concepto general, ventajas, cuando usarlo

---

## 📋 Comparativa: Ejercicio 1 vs Ejercicio 2

```
EJERCICIO 1 (Lollapalooza)         | EJERCICIO 2 (A-B-C)
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
Simple herencia lineal              | Herencia multinivel
Enfoque en separación de concepto   | Enfoque en mecanismos internos
Métodos públicos principalmente     | Métodos private explorados
Sin constructores explícitos        | Cadena de constructores explícita
Polimorfismo implícito              | Polimorfismo y override explícitos
Sin shadowing                       | Shadowing de atributos ilustrado
```

---

## 💡 Resumen de Conceptos Nuevos

### Constructores
- `super()` invoca el constructor del padre
- Cadena automática en herencia multinivel
- Inicialización de arriba hacia abajo (A → B → C)

### Sobrescritura (Override)
- Redefinición de métodos heredados
- Mismo nombre y parámetros, diferente implementación
- Polimorfismo en tiempo de ejecución
- Anotación `@Override` recomiendada

### Visibilidad Private
- `private` NO se hereda
- No accesible desde subclases
- Encapsulación total

### Shadowing
- Atributos con el mismo nombre en padre e hijo
- El del hijo "oculta" al del padre
- Ambos existen, pero el hijo domina la búsqueda

### Polimorfismo en Acción
- Referencias del padre apuntando a objetos del hijo
- Búsqueda de métodos en tiempo de ejecución
- NO aplica a atributos (búsqueda estática)

---

## ❓ Preguntas de Autoevaluación

1. **¿Qué diferencia hay entre `super()` en el constructor y `super.método()`?**
   - `super()` invoca el constructor del padre
   - `super.método()` invoca el método del padre desde un override

2. **¿Por qué `private` no es heredable?**
   - Porque `private` significa acceso solo dentro de la clase
   - La encapsulación requiere que ciertos detalles sean internos

3. **¿Cuál es la diferencia entre shadowing y override?**
   - Shadowing: atributos con el mismo nombre en padre e hijo
   - Override: métodos redefinidos en hijo, ejecutando el del hijo

4. **¿Qué método se ejecuta al llamar `ref.metodoA()` donde `ref` tiene tipo `A` pero referencia un objeto `B`?**
   - El método de B (polimorfismo: se busca en el tipo del OBJETO, no de la referencia)

---

## 📚 Recursos Complementarios

Para profundizar en estos temas, considera estudiar:
- Principio DRY (Don't Repeat Yourself) - aplicable a shadowing
- Principio de Sustitución de Liskov (LSP) - reglas del polimorfismo
- Encapsulación y modificadores de acceso - tabla de visibilidad
- Constructor Chaining - patrón en Java
