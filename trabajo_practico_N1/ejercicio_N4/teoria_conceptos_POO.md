# Conceptos POO - Ejercicio N°4

## 📑 Tabla de Contenidos

1. **Conceptos Nuevos en Este Ejercicio**
2. **Upcasting vs Downcasting**
3. **Asignabilidad de Tipos en Herencia**
4. **Resolución de Visibilidad de Métodos**
5. **Relaciones entre Clases (Herencia directa vs Hermanas)**
6. **Casting Explícito y Verificación en Runtime**
7. **Referencia a Conceptos Anteriores**

---

## ⭐ Conceptos Nuevos en Este Ejercicio

Este ejercicio profundiza en **polimorfismo y casting**, combinando conceptos de herencia vistos anteriormente:

| Concepto | Ej. 1 | Ej. 2 | Ej. 3 | Ej. 4 |
|----------|-------|-------|-------|-------|
| Herencia | ✅ | ✅ | ✅ | ✅ **NEW: Análisis profundo** |
| Upcasting | ❌ | ❌ | ❌ | ✅ **NEW** |
| Downcasting | ❌ | ❌ | ❌ | ✅ **NEW** |
| Polimorfismo | ❌ | ❌ | ❌ | ✅ **NEW** |
| Relaciones entre clases | ❌ | ❌ | ❌ | ✅ **NEW** |
| Visibilidad en jerarquías | ✅ | ✅ | ✅ | ✅ **NEW: Análisis completo** |

**→ Para Constructores en herencia, ver Ejercicio 3**

**→ Para Override y `private`, ver Ejercicio 2**

**→ Para Herencia básica, ver Ejercicio 1**

---

## 🔄 Upcasting vs Downcasting

### Upcasting (Subclase → Superclase)

**Definición:** Asignar una referencia de una subclase a una variable de superclase.

```java
Rectangulo r = new Rectangulo();
Poligono p = r;  // ✅ Upcasting válido y seguro
```

**Características:**
- ✅ Siempre es **seguro** en tiempo de compilación
- ✅ Es **automático** (no requiere casting explícito)
- ✅ No hay riesgo de errores en runtime
- **Razón:** Todo `Rectángulo` **es un** `Polígono` por definición

**Ejemplo más complejo:**

```java
Cuadrado cd = new Cuadrado();
Rectangulo r = cd;     // ✅ Upcasting a padre directo
Cuadrangulo c = cd;    // ✅ Upcasting a padre indirecto
Poligono p = cd;       // ✅ Upcasting a padre lejano
```

---

### Downcasting (Superclase → Subclase)

**Definición:** Intentar asignar una referencia de superclase a una variable de subclase.

```java
Poligono p = new Rectangulo();  // Primero upcasting
Rectangulo r = p;  // ❌ Downcasting sin casting explícito = ERROR de compilación
```

**Por qué es problemático:**

```java
Poligono p = new Triangulo();   // p apunta a un Triángulo
Rectangulo r = (Rectangulo) p; // ❌ Compila, pero ClassCastException en runtime
```

**Características:**
- ❌ **Requiere casting explícito** para compilar
- ⚠️ Puede causar **ClassCastException en runtime**
- 🔍 Requiere verificación del programador
- **Razón:** Un `Polígono` genérico podría ser cualquier subclase, no necesariamente un `Rectángulo`

**Downcasting seguro (con verificación):**

```java
Poligono p = new Rectangulo();

// Forma segura: verificar tipo primero
if (p instanceof Rectangulo) {
    Rectangulo r = (Rectangulo) p;  // ✅ Seguro
    r.diagonal();
}
```

---

## 🎯 Asignabilidad de Tipos en Herencia

### Regla General

```
Clase A es ASIGNABLE a variable de tipo B si:
1. A ES UN B (directamente o heredando)
2. Está permitida la relación A → B
```

### Tabla de Asignabilidad

Dada la jerarquía:

```
        Polígono
       /         \
   Triángulo   Cuadrángulo
                  /      \
            Rectángulo   Cuadrado
```

| De tipo → A Tipo | Válido? | Razón |
|------------------|---------|-------|
| `Rectangulo → Poligono` | ✅ | Upcasting directo |
| `Cuadrado → Rectangulo` | ✅ | Upcasting directo |
| `Cuadrado → Poligono` | ✅ | Upcasting indirecto (a través de Cuadrángulo y Rectángulo) |
| `Poligono → Rectangulo` | ❌ | Downcasting (sin casting explícito) |
| `Triangulo → Cuadrangulo` | ❌ | Clases hermanas (sin relación) |
| `Cuadrángulo → Cuadrado` | ❌ | Downcasting (un Cuadrángulo podría no ser Cuadrado) |

---

## 📍 Resolución de Visibilidad de Métodos

### Principio Fundamental

**El tipo de la variable determina qué métodos son visibles en tiempo de compilación.**

```java
Poligono p = new Rectangulo();

p.perimetro();   // ✅ Válido (definido en Polígono)
p.diagonal();    // ❌ Error (diagonal es de Cuadrángulo, no visible)
```

### Diferentes Escenarios

**Escenario 1: Llamar método de la superclase**

```java
Rectangulo r = new Rectangulo();
r.perimetro();  // ✅ Válido (heredado de Polígono)
```

**Escenario 2: Llamar método de la misma clase**

```java
Rectangulo r = new Rectangulo();
r.diagonal();   // ✅ Válido (definido en Cuadrángulo, padre directo)
```

**Escenario 3: Llamar método de una subclase desde superclase**

```java
Poligono p = new Rectangulo();
p.diagonal();   // ❌ Error de compilación (diagonal no visible en Polígono)
```

### ¿Qué sucede en Runtime?

Incluso si compilara, Java usa **late binding (vinculación tardía)**:

```java
Poligono p = new Rectangulo();

// Si esto compilara, llamaría a la implementación de Rectangulo
// Pero compilador no permite porque diagonal() no está en Polígono
```

---

## 👥 Relaciones entre Clases

### Relación 1: Herencia Directa (Padre-Hijo)

```
    Padre
      ↑
      │ hereda de
      │
    Hijo
```

```java
Padre p = new Hijo();    // ✅ Upcasting válido
Hijo h = new Padre();    // ❌ Error (Padre no es Hijo)
```

### Relación 2: Herencia Indirecta (Abuelo-Nieto)

```
   Abuelo
      ↑
      │
    Padre
      ↑
      │
    Nieto
```

```java
Abuelo a = new Nieto();  // ✅ Upcasting válido
Padre p = new Nieto();   // ✅ Upcasting válido
```

### Relación 3: Clases Hermanas (Sin relación)

```
      Padre
     /      \
    │        │
   Hijo1   Hijo2
```

```java
Hijo1 h1 = new Hijo2();  // ❌ Error (no hay relación)
Padre p1 = new Hijo1();
Padre p2 = new Hijo2();
// p1 y p2 comparten superclase pero no son asignables entre sí
```

---

## 🔗 Casting Explícito y Verificación en Runtime

### Sintaxis del Casting Explícito

```java
VariableSubclase = (Subclase) variableSuperclase;
```

### ClassCastException

Si intentas hacer downcasting a un tipo incorrecto:

```java
Object obj = "Hola";  // obj apunta a un String
Integer num = (Integer) obj;  // ❌ ClassCastException en runtime
```

### Verificación Segura con `instanceof`

```java
Poligono p = new Cuadrado();

// ❌ Riesgoso
Rectangulo r = (Rectangulo) p;  // Compila, pero ¿y si no es Rectángulo?

// ✅ Seguro
if (p instanceof Cuadrado) {
    Cuadrado cd = (Cuadrado) p;
    System.out.println("Es un Cuadrado");
}
```

### Pattern Matching (Java 16+)

```java
Poligono p = new Cuadrado();

if (p instanceof Cuadrado cd) {
    System.out.println("Es un Cuadrado y ya puede usarse: " + cd);
}
```

---

## 🔙 Referencia a Conceptos Anteriores

### Herencia (Ejercicio 1)
- Superclase vs Subclase
- Jerarquía de clases
- Heredar métodos y atributos

### Métodos `private` y Override (Ejercicio 2)
- Métodos `private` no se heredan
- Override permite cambiar comportamiento en subclases
- Polimorfismo en tiempo de ejecución

### Constructores en Herencia (Ejercicio 3)
- `super()` en constructores
- Inicialización de atributos en cadena
- Orden de ejecución de constructores

### Estos Conceptos Aplicados (Ejercicio 4)
- Las asignaciones solo funcionan en la dirección correcta de herencia
- La visibilidad de métodos depende del tipo de la variable
- Las relaciones entre clases determinan qué operaciones son posibles

