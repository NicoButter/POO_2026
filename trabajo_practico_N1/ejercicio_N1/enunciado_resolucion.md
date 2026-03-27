# Ejercicio N°1: Jerarquía de Herencia en Java

## 📋 Enunciado

Dada la siguiente **jerarquía de herencia**:

```java
public class A {
    private int atributoA;
    public void metodoA()
    { }
}

public class B extends A {
    private int atributoB;
    public void metodoB()
    { }
}

public class C extends B {
    private int atributoC;
    public void metodoC()
    { }
}
```

---

## 🔗 Diagrama de Herencia

```
        ┌─────────────────────────────────────┐
        │           CLASE A                   │
        ├─────────────────────────────────────┤
        │ - atributoA: int                    │
        ├─────────────────────────────────────┤
        │ + metodoA(): void                   │
        └─────────────────────────────────────┘
                        △
                        │ extends
                        │
        ┌─────────────────────────────────────┐
        │           CLASE B                   │
        ├─────────────────────────────────────┤
        │ - atributoB: int                    │
        ├─────────────────────────────────────┤
        │ + metodoB(): void                   │
        └─────────────────────────────────────┘
                        △
                        │ extends
                        │
        ┌─────────────────────────────────────┐
        │           CLASE C                   │
        ├─────────────────────────────────────┤
        │ - atributoC: int                    │
        ├─────────────────────────────────────┤
        │ + metodoC(): void                   │
        └─────────────────────────────────────┘
```

**Jerarquía:** `A` (padre) ← `B` (hijo de A) ← `C` (hijo de B)

---

## 🎯 Preguntas y Respuestas

### a) ¿Qué mensajes se pueden enviar a un objeto de la clase **A**?

**Respuesta:**

Un objeto de la clase `A` puede recibir los siguientes mensajes (métodos públicos):

| Método | Descripción |
|--------|-------------|
| `metodoA()` | Método definido en la clase `A` |

```java
A objA = new A();
objA.metodoA();  // ✅ Válido - pertenece a A
```

**Resumen:** Solo `metodoA()` está disponible para objetos de clase `A`.

---

### b) ¿Qué mensajes se pueden enviar a un objeto de la clase **B**?

**Respuesta:**

Un objeto de la clase `B` hereda todos los métodos públicos de su padre (`A`) y agrega los propios:

| Método | Origen | Descripción |
|--------|--------|-------------|
| `metodoA()` | Clase A (heredado) | Método heredado de la clase `A` |
| `metodoB()` | Clase B | Método definido en la clase `B` |

```java
B objB = new B();
objB.metodoA();  // ✅ Válido - heredado de A
objB.metodoB();  // ✅ Válido - pertenece a B
```

**Resumen:** Un objeto de `B` puede recibir **2 mensajes**: `metodoA()` (heredado) + `metodoB()` (propio).

---

### c) ¿Qué mensajes se pueden enviar a un objeto de la clase **C**?

**Respuesta:**

Un objeto de la clase `C` hereda todos los métodos públicos de sus ancestros (`A` y `B`) y agrega los propios:

| Método | Origen | Descripción |
|--------|--------|-------------|
| `metodoA()` | Clase A (heredado) | Método heredado de `A` a través de `B` |
| `metodoB()` | Clase B (heredado) | Método heredado de la clase `B` |
| `metodoC()` | Clase C | Método definido en la clase `C` |

```java
C objC = new C();
objC.metodoA();  // ✅ Válido - heredado de A (a través de B)
objC.metodoB();  // ✅ Válido - heredado de B
objC.metodoC();  // ✅ Válido - pertenece a C
```

**Resumen:** Un objeto de `C` puede recibir **3 mensajes**: `metodoA()` + `metodoB()` (heredados) + `metodoC()` (propio).

---

### d) ¿Qué atributos describen a un objeto de la clase **A**?

**Respuesta:**

Un objeto de la clase `A` tiene los siguientes atributos:

| Atributo | Tipo | Visibilidad | Descripción |
|----------|------|-------------|-------------|
| `atributoA` | `int` | `private` | Atributo definido en `A` |

```java
A objA = new A();
// objA tiene internamente: atributoA (private)
```

**Resumen:** Un objeto de `A` está descrito por **1 atributo**: `atributoA`.

> ⚠️ **Nota:** El atributo es `private`, por lo que no es accesible directamente desde fuera de la clase.

---

### e) ¿Qué atributos describen a un objeto de la clase **B**?

**Respuesta:**

Un objeto de la clase `B` hereda todos los atributos de su padre `A` y agrega los propios:

| Atributo | Tipo | Origen | Visibilidad | Descripción |
|----------|------|--------|-------------|-------------|
| `atributoA` | `int` | Clase A (heredado) | `private` | Heredado de `A` |
| `atributoB` | `int` | Clase B | `private` | Definido en `B` |

```java
B objB = new B();
// objB tiene internamente:
//   - atributoA (private, heredado de A)
//   - atributoB (private, propio de B)
```

**Resumen:** Un objeto de `B` está descrito por **2 atributos**: `atributoA` (heredado) + `atributoB` (propio).

> 📌 **Importante:** Aunque `atributoA` es heredado, la clase `B` es responsable de su inicialización (generalmente en el constructor mediante `super()`).

---

### f) ¿Qué atributos describen a un objeto de la clase **C**?

**Respuesta:**

Un objeto de la clase `C` hereda todos los atributos de sus ancestros (`A` y `B`) y agrega los propios:

| Atributo | Tipo | Origen | Visibilidad | Descripción |
|----------|------|--------|-------------|-------------|
| `atributoA` | `int` | Clase A (heredado) | `private` | Heredado de `A` a través de `B` |
| `atributoB` | `int` | Clase B (heredado) | `private` | Heredado de `B` |
| `atributoC` | `int` | Clase C | `private` | Definido en `C` |

```java
C objC = new C();
// objC tiene internamente:
//   - atributoA (private, heredado de A)
//   - atributoB (private, heredado de B)
//   - atributoC (private, propio de C)
```

**Resumen:** Un objeto de `C` está descrito por **3 atributos**: `atributoA` + `atributoB` (heredados) + `atributoC` (propio).

---

## 📊 Tabla Comparativa General

```
┌─────────────────┬──────────────┬──────────────┬──────────────┐
│                 │   Clase A    │   Clase B    │   Clase C    │
├─────────────────┼──────────────┼──────────────┼──────────────┤
│ Métodos         │ metodoA()    │ metodoA()    │ metodoA()    │
│                 │              │ metodoB()    │ metodoB()    │
│                 │              │              │ metodoC()    │
├─────────────────┼──────────────┼──────────────┼──────────────┤
│ Atributos       │ atributoA    │ atributoA    │ atributoA    │
│                 │              │ atributoB    │ atributoB    │
│                 │              │              │ atributoC    │
├─────────────────┼──────────────┼──────────────┼──────────────┤
│ Total Métodos   │      1       │      2       │      3       │
├─────────────────┼──────────────┼──────────────┼──────────────┤
│ Total Atributos │      1       │      2       │      3       │
└─────────────────┴──────────────┴──────────────┴──────────────┘
```

---

## 🔑 Conceptos Clave

### ✅ Herencia
- **B extiende A:** B **hereda** todos los métodos y atributos públicos de A
- **C extiende B:** C **hereda** todos los métodos y atributos de B (y transitivamente de A)

### ✅ Encapsulamiento
- Los atributos son `private`: no son accesibles desde fuera de la clase
- Solo se accede a través de métodos `public` (getters/setters) si los hubiera

### ✅ Polimorfismo (Principio)
- Un objeto de clase `C` **es también** de clase `B` y de clase `A`
- Puede recibir cualquier mensaje que espere `A`, `B` o `C`

---

## 💡 Ejemplo de Uso

```java
// Instanciación
A objA = new A();
B objB = new B();
C objC = new C();

// Objetos de A pueden hacer:
objA.metodoA();  // ✅

// Objetos de B pueden hacer:
objB.metodoA();  // ✅ (heredado)
objB.metodoB();  // ✅ (propio)

// Objetos de C pueden hacer:
objC.metodoA();  // ✅ (heredado)
objC.metodoB();  // ✅ (heredado)
objC.metodoC();  // ✅ (propio)

// Polimorfismo:
A ref = new C();  // Referencia de tipo A apunta a objeto de tipo C
ref.metodoA();    // ✅ Válido - metodoA existe en C
// ref.metodoC(); // ❌ ERROR - A no conoce metodoC
```

---

## 📝 Conclusión

La jerarquía de herencia permite que:
- **Cada clase herede** el comportamiento (métodos) y estado (atributos) de su padre
- **Cada clase agregue** su propio comportamiento específico
- **El código sea reutilizable** y mantenible mediante la especialización progresiva
