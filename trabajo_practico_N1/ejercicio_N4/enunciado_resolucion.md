# Ejercicio N°4: Herencia y Casting - Validez de Sentencias

## 📋 Enunciado General

Teniendo en cuenta la siguiente jerarquía de clases:

```
        Polígono
       /         \
   Triángulo   Cuadrángulo
                  /      \
            Rectángulo   Cuadrado
```

Y las declaraciones:

- `Triangulo t;`
- `Poligono p;`
- `Cuadrangulo c;`
- `Rectangulo r;`
- `Cuadrado cd;`

---

## ❓ Pregunta

Indique cuál de las siguientes sentencias **NO SON VÁLIDAS** y justifique en cada caso:

### Sentencia 1
```java
p = c;
p = r;
```

### Sentencia 2
```java
p = r;
r = p;
```

### Sentencia 3
```java
cd = c;
p.diagonal();  // diagonal es una operación de los cuadrángulos
```

### Sentencia 4
```java
c = t;
t.perímetro();  // perímetro es un método de los polígonos
```

---

## ✅ Resolución

### Sentencia 1: `p = c; p = r;`

**Validez: ✅ VÁLIDAS**

**Justificación:**
- `p = c`: Asignar un `Cuadrángulo` a una variable de tipo `Polígono` es válido. Es un **upcasting** (de subclase a superclase), lo que siempre es seguro en Java.
- `p = r`: Asignar un `Rectángulo` a una variable de tipo `Polígono` es válido. Es también un **upcasting**, que es automático y seguro.

**Conclusión:** Ambas sentencias pueden ejecutarse sin problemas de compilación ni runtime.

---

### Sentencia 2: `p = r; r = p;`

**Validez: ❌ NO VÁLIDA (segunda asignación)**

**Justificación:**
- `p = r`: ✅ Válido (upcasting).
- `r = p`: ❌ **INVÁLIDO** - Esto intentaría hacer un **downcasting** (de superclase a subclase). No es posible asignar una variable de tipo `Polígono` a una variable de tipo `Rectángulo` sin un casting explícito, porque no hay garantía de que el `Polígono` sea específicamente un `Rectángulo`.

```java
// ❌ Error de compilación
r = p;  

// ✅ Forma correcta (si en runtime es un Rectángulo)
r = (Rectangulo) p;
```

**Conclusión:** La segunda asignación causa **error de compilación**.

---

### Sentencia 3: `cd = c; p.diagonal();`

**Validez: ❌ NO VÁLIDAS (ambas)**

**Justificación:**

**Primera parte: `cd = c;`**
- ❌ **INVÁLIDO** - Intentaría asignar un `Cuadrángulo` a una variable de tipo `Cuadrado`. Este es un **downcasting**, porque un `Cuadrángulo` genérico no tiene garantía de ser un `Cuadrado` (podría ser solo un `Cuadrángulo` o un `Rectángulo`).

```java
// ❌ Error de compilación
cd = c;  

// ✅ Forma correcta (con casting explícito)
cd = (Cuadrado) c;  // Pero riesgo en runtime si no es Cuadrado
```

**Segunda parte: `p.diagonal();`**
- ❌ **INVÁLIDO** - La variable `p` es de tipo `Polígono`, pero `diagonal()` es un método definido en la clase `Cuadrángulo`. 
- **Principio fundamental:** La herencia solo funciona "hacia arriba". Una clase heredera tiene acceso a los métodos de su superclase, pero una superclase **no hereda métodos de sus subclases**.
- El compilador no permite llamar a un método de una subclase a través de una referencia de superclase.

```java
// ❌ Error de compilación
p.diagonal();  

// ✅ Formas correctas
Cuadrangulo cuad = (Cuadrangulo) p;
cuad.diagonal();  // Si p es realmente un Cuadrángulo
```

**Conclusión:** Ambas sentencias causan **errores de compilación**.

---

### Sentencia 4: `c = t; t.perímetro();`

**Validez: ❌ NO VÁLIDA (primera asignación)**

**Justificación:**

**Primera parte: `c = t;`**
- ❌ **INVÁLIDO** - Intenta asignar un `Triángulo` a una variable de tipo `Cuadrángulo`. 
- **Razón:** No existe relación de herencia directa entre `Triángulo` y `Cuadrángulo`. Son **clases hermanas** (ambas heredan de `Polígono`, pero no una de la otra).
- No se pueden asignar entre tipos que no tienen relación de herencia.

```java
// ❌ Error de compilación
c = t;  

// ✅ Ambos se pueden asignar a Polígono
Poligono p1 = t;
Poligono p2 = c;
```

**Segunda parte: `t.perímetro();`**
- ✅ **VÁLIDA** - `Triángulo` hereda de `Polígono`, y `perímetro()` es un método definido en `Polígono`. Por lo tanto, es completamente válido llamar a este método.

**Conclusión:** Solo la **primera sentencia es inválida**.

---

## 📊 Tabla Resumen

| Sentencia | Validez | Motivo |
|-----------|---------|--------|
| `p = c;` | ✅ Válida | Upcasting (seguro) |
| `p = r;` | ✅ Válida | Upcasting (seguro) |
| `p = r; r = p;` | ❌ 2ª inválida | Downcasting sin casting explícito |
| `cd = c;` | ❌ Inválida | Downcasting sin casting explícito |
| `p.diagonal();` | ❌ Inválida | Método de subclase desde superclase |
| `c = t;` | ❌ Inválida | Clases hermanas, sin relación de herencia |
| `t.perímetro();` | ✅ Válida | Método heredado de superclase |

