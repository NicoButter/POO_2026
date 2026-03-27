# Ejercicio N°2: Herencia, Constructores y Polimorfismo

## 📋 Enunciado

Dada la siguiente **jerarquía de herencia**:

```java
public class A {
    private int atributoA;
    public A() { 
        this.atributoA = 5; 
    }
    public void metodoA() { 
        System.out.println("Método A"); 
    }
}

public class B extends A {
    private int atributoB;
    public B() { 
        super(); 
        this.atributoB = 2; 
    }
    public void metodoA() { 
        System.out.println("Método redefinido en B"); 
    }
    public void metodoB() { 
        System.out.println("Método B"); 
    }
    private void metodoP() { 
        System.out.println("Método privado"); 
    }
}

public class C extends B {
    private int atributoC;
    private int atributoB;
    public C() { 
        super(); 
        this.atributoC = 0; 
        this.atributoB = 7; 
    }
    public void metodoC() { 
        System.out.println("Método C"); 
    }
}
```

---

## 🔗 Diagrama de Herencia

```
        ┌──────────────────────────────────┐
        │           CLASE A                │
        ├──────────────────────────────────┤
        │ - atributoA: int = 5             │
        ├──────────────────────────────────┤
        │ + A()              (constructor) │
        │ + metodoA(): void                │
        └──────────────────────────────────┘
                        △
                        │ extends
                        │
        ┌──────────────────────────────────┐
        │           CLASE B                │
        ├──────────────────────────────────┤
        │ - atributoB: int = 2             │
        ├──────────────────────────────────┤
        │ + B()              (constructor) │
        │ + metodoA(): void  (override)    │
        │ + metodoB(): void                │
        │ - metodoP(): void  (private)     │
        └──────────────────────────────────┘
                        △
                        │ extends
                        │
        ┌──────────────────────────────────┐
        │           CLASE C                │
        ├──────────────────────────────────┤
        │ - atributoC: int = 0             │
        │ - atributoB: int = 7 (shadow)    │
        ├──────────────────────────────────┤
        │ + C()              (constructor) │
        │ + metodoC(): void                │
        └──────────────────────────────────┘
```

---

## 🎯 Preguntas y Respuestas

### a) ¿Qué ocurre cuando `metodoA()` es invocado por una instancia de la clase **A**?

**Respuesta:**

Se ejecuta el método `metodoA()` definido en la clase `A`.

```java
A objA = new A();
objA.metodoA();  
// Salida: "Método A"
```

**Explicación:**
- La clase `A` tiene definido `metodoA()` que imprime "Método A"
- No hay sobrescritura en la cadena de herencia
- Se ejecuta el método original de `A`

---

### b) ¿Qué ocurre cuando un objeto de la clase **B** invoca al `metodoA()`?

**Respuesta:**

Se ejecuta el método `metodoA()` **sobrescrito en B**, NO el de `A`.

```java
B objB = new B();
objB.metodoA();  
// Salida: "Método redefinido en B"
```

**Explicación:**
- `B extends A` → hereda `metodoA()` de `A`
- `B` **sobrescribe** (override) el método `metodoA()` con su propia implementación
- Polimorfismo en tiempo de ejecución: la versión de `B` es la que se ejecuta
- El método original de `A` es **ocultado** por el nuevo de `B`

---

### c) ¿Qué ocurre cuando se le envía el mensaje `metodoA()` a un objeto de la clase **C**?

**Respuesta:**

Se ejecuta el método `metodoA()` **sobrescrito en B** (heredado por C).

```java
C objC = new C();
objC.metodoA();  
// Salida: "Método redefinido en B"
```

**Explicación:**
- `C extends B` → hereda `metodoA()` de `B`
- `B` ya había sobrescrito `metodoA()` de `A`
- `C` NO sobrescribe `metodoA()`, por lo que hereda la versión de `B`
- Polimorfismo: la versión más especializada disponible es la de `B`

**Cadena de resolución:**
```
C.metodoA() → No existe en C
           → Heredado de B.metodoA() → Existe y es la versión sobrescrita
           → Ejecuta: "Método redefinido en B"
```

---

### d) ¿Qué sucede cuando un objeto de la clase **C** ó **A** invocan al `metodoP()` de la clase **B**?

**Respuesta:**

**❌ ERROR DE COMPILACIÓN** - No se puede acceder a `metodoP()` desde fuera de `B`.

```java
A objA = new A();
objA.metodoP();  // ❌ COMPILACIÓN ERROR
                 // error: metodoP() has private access in B

B objB = new B();
objB.metodoP();  // ❌ COMPILACIÓN ERROR
                 // error: metodoP() has private access in B

C objC = new C();
objC.metodoP();  // ❌ COMPILACIÓN ERROR
                 // error: metodoP() has private access in B
```

**Explicación:**
- `metodoP()` está declarado como `private` en la clase `B`
- Los métodos `private` **NO se heredan** y **NO son accesibles** desde fuera de la clase
- Incluso aunque `C` herede de `B`, no puede acceder a `metodoP()`
- Incluso `B` mismo acepta acceder desde dentro, pero no desde el exterior

**Analogía:**
```
private = puerta cerrada con llave
         Solo la clase que la define puede usarla
         Las subclases NO heredan llaves
```

---

### e) ¿Qué valor tiene la propiedad `atributoB` de un objeto de la clase **B**?

**Respuesta:**

**`atributoB = 2`**

```java
B objB = new B();
// objB.atributoB == 2  (no se puede acceder directamente, es private)
```

**Explicación:**
- `B` define su propio atributo `atributoB`
- En el constructor de `B`: `this.atributoB = 2;`
- El atributo se inicializa a `2`

---

### f) ¿Qué valor tiene `atributoB` en un objeto de la clase **C**?

**Respuesta:**

**`atributoB = 7`** (el atributo de `C`, NO el heredado de `B`)

```java
C objC = new C();
// objC tiene DOS atributos llamados "atributoB":
//   1. atributoB heredado de B (valor: 2, pero no es accesible)
//   2. atributoB definido en C (valor: 7) ← Este "gana"
```

**Explicación:**
- `C` **define su propio atributo `atributoB`** (line: `private int atributoB;`)
- `C` **hereda `atributoB` de B** (valor `2`)
- Cuando `C` crea su propio `atributoB`, se produce **shadowing** (sombreamiento)
- El atributo de `C` **oculta/sombrea** el atributo heredado de `B`
- En el constructor de `C`: `this.atributoB = 7;` → Asigna a **su propio atributo**
- El `atributoB` de `B` sigue existiendo en memoria (con valor `2`), pero no es accesible directamente

**Visualización en Memoria:**

```
Objeto C:
┌─────────────────────────────────────┐
│ atributoA (inherited from A): 5     │  ← Heredado
│ atributoB (inherited from B): 2     │  ← Heredado, sombreado
│ atributoC (defined in C): 0         │  ← Propio de C
│ atributoB (defined in C): 7         │  ← Propio de C, SOMBREA el de B
└─────────────────────────────────────┘
```

---

### g) ¿Qué valor tiene `atributoB` en un objeto de la clase **A**?

**Respuesta:**

**No tiene** - La clase `A` NO define `atributoB`.

```java
A objA = new A();
// objA.atributoB → ❌ COMPILACIÓN ERROR
//                    error: cannot find symbol - atributoB
```

**Explicación:**
- `A` solo define `atributoA`
- `atributoB` es definido en `B` (subclase de `A`)
- La herencia es **hacia abajo** (de padre a hijo), no hacia arriba
- `A` no hereda de `B`, por lo tanto no tiene `atributoB`

---

### h) ¿Qué valor tiene `atributoA` en un objeto de la clase **C**?

**Respuesta:**

**`atributoA = 5`** (heredado de `A`)

```java
C objC = new C();
// objC.atributoA == 5  (heredado de A a través de B)
```

**Explicación:**
- Cadena de herencia: `C -> B -> A`
- `C` hereda de `B`, y `B` hereda de `A`
- `A` define: `atributoA = 5` (en su constructor)
- `C` hereda este atributo indirectamente
- En la cadena de constructores:
  1. `C()` llama `super()` → `B()`
  2. `B()` llama `super()` → `A()`
  3. `A()` inicializa `atributoA = 5`
  4. Control retorna a `B()`, luego a `C()`
  5. `atributoA` mantiene el valor `5`

---

### i) ¿Qué valor tiene `atributoA` de un objeto de la clase **B**?

**Respuesta:**

**`atributoA = 5`** (heredado de `A`)

```java
B objB = new B();
// objB.atributoA == 5  (heredado de A)
```

**Explicación:**
- `B extends A` → hereda `atributoA` de `A`
- `A` define el constructor: `this.atributoA = 5;`
- `B` llama `super()` en su constructor → invoca el constructor de `A`
- El constructor de `A` inicializa `atributoA = 5`
- `atributoA` mantiene este valor en toda la cadena

---

## 📊 Tabla Resumen de Valores

```
┌────────────┬──────────┬──────────┬──────────┐
│ Atributo   │ Objeto A │ Objeto B │ Objeto C │
├────────────┼──────────┼──────────┼──────────┤
│ atributoA  │    5     │    5     │    5     │
├────────────┼──────────┼──────────┼──────────┤
│ atributoB  │   N/A    │    2     │    7*    │
│            │          │          │(shadowed)│
├────────────┼──────────┼──────────┼──────────┤
│ atributoC  │   N/A    │   N/A    │    0     │
└────────────┴──────────┴──────────┴──────────┘

* En C hay 2 atributoB: el heredado de B (valor 2) y el propio de C (valor 7)
  El de C sombrea al heredado, por lo que objC.atributoB hace referencia al valor 7
```

---

## 🎯 Tabla Resumen de Métodos

```
┌─────────────┬──────────┬──────────┬──────────┐
│ Método      │ Objeto A │ Objeto B │ Objeto C │
├─────────────┼──────────┼──────────┼──────────┤
│ metodoA()   │    A()   │ B() [🔴] │ B() [🔴] │
│             │ "[Mét A]"│"[Redefined]"        │
├─────────────┼──────────┼──────────┼──────────┤
│ metodoB()   │   ❌     │    B()   │    B()   │
├─────────────┼──────────┼──────────┼──────────┤
│ metodoC()   │   ❌     │   ❌     │    C()   │
├─────────────┼──────────┼──────────┼──────────┤
│ metodoP()   │  ❌ (no existe; private) │
└─────────────┴──────────┴──────────┴──────────┘

🔴 = Sobrescrito (Override)
❌ = No accesible
```

---

## 📚 Conceptos Clave Aplicados

### 1. **Herencia Multinivel**
```
A (padre) ← B (hijo de A) ← C (hijo de B)
```

### 2. **Sobrescritura (Override)**
- `B` sobrescribe `metodoA()` de `A`
- `C` hereda la versión sobrescrita de `B`
- **Polimorfismo en tiempo de ejecución**

### 3. **Visibilidad y Encapsulamiento**
- `metodoP()` es `private` → no es heredable ni accesible desde fuera
- Los atributos `private` no son accesibles directamente

### 4. **Cadena de Constructores (`super()`)**
```
C() → super() → B() → super() → A()
```
Inicialización "de arriba hacia abajo", ejecución "de abajo hacia arriba"

### 5. **Shadowing (Sombreamiento)**
- `C` define `atributoB` que sombrea el heredado de `B`
- Ambos existen, pero el de `C` "gana" en la búsqueda de nombres

---

## 💡 Lecciones Importantes

✅ **Los métodos sobrescritos pueden cambiar completamente el comportamiento heredado**

✅ **`private` = no heredable**

✅ **La cadena de constructores es importante: `super()` invoca al constructor del padre**

✅ **Shadowing puede causar confusión: evitar redefinir atributos ya existentes en la clase padre**

✅ **El polimorfismo busca el método en la clase más especializada primero**
