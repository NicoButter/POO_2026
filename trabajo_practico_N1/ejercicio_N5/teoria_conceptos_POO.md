# Conceptos POO - Ejercicio N°5

## 📑 Tabla de Contenidos

1. **Conceptos Nuevos en Este Ejercicio**
2. **Inner Classes vs Inherited Classes**
3. **La Palabra Clave `super` en Profundidad**
4. **Errores Comunes en Jerarquías de Herencia**
5. **Recursión Infinita en Métodos**
6. **Patrones Anti-Pattern en Herencia**
7. **Referencia a Conceptos Anteriores**

---

## ⭐ Conceptos Nuevos en Este Ejercicio

Este ejercicio introduce **errores comunes y anti-patterns** en diseño de herencia:

| Concepto | Ej. 1-3 | Ej. 4 | Ej. 5 |
|----------|---------|-------|-------|
| Herencia válida | ✅ | ✅ | ✅ **NEW: Casos inválidos** |
| Inner classes | ❌ | ❌ | ✅ **NEW** |
| `super` correcto | ✅ | ✅ | ✅ **NEW: Usos incorrectos** |
| Errores de compilación | ❌ | ❌ | ✅ **NEW** |
| Recursión infinita | ❌ | ❌ | ✅ **NEW** |
| Anti-patterns | ❌ | ❌ | ✅ **NEW** |

**→ Para Override y herencia válida, ver Ejercicio 2-4**

---

## 💻 Inner Classes vs Inherited Classes

### Inner Classes (Clases Anidadas)

**Definición:** Una clase definida dentro de otra clase.

```java
public class Externa {
    public class Interna {  // ← Inner class
        // codigo
    }
}
```

**Características:**

1. **Pertenecen a la clase exterior**
   ```java
   public class Uno {
       public class Dos {
           // Dos es PARTE DE Uno, no heredera
       }
   }
   ```

2. **Tienen acceso especial a la clase externa**
   ```java
   public class Uno {
       private int x = 100;
       
       public class Dos {
           void metodo() {
               System.out.println(x);  // ✅ Acceso a privados de Uno
           }
       }
   }
   ```

3. **Instanciación compleja**
   ```java
   Uno uno = new Uno();
   Uno.Dos dos = uno.new Dos();  // Necesita instancia de Uno
   ```

4. **Tipos de inner classes:**
   - **Member inner class:** Como en el ejemplo anterior
   - **Local inner class:** Definida dentro de un método
   - **Anonymous inner class:** Sin nombre

---

### Inherited Classes (Herencia)

**Definición:** Una clase que hereda de otra mediante `extends`.

```java
public class Padre {
    // codigo
}

public class Hijo extends Padre {  // ← Herencia
    // Hijo hereda de Padre
}
```

**Características:**

1. **Son independientes**
   ```java
   public class Uno { }
   
   public class Dos extends Uno { }  // Dos es una clase aparte que hereda de Uno
   ```

2. **Herencia de métodos y atributos**
   ```java
   public class Dos extends Uno {
       void metodo() {
           // Acceso a métodos heredados de Uno
       }
   }
   ```

3. **Instanciación simple**
   ```java
   Dos dos = new Dos();  // Sin dependencias
   ```

---

### ¿Cuándo usar cada una?

| Situación | Inner Class | Inherited Class |
|-----------|-------------|-----------------|
| Estructura lógica independiente | ❌ | ✅ |
| Es una variación de la clase padre | ❌ | ✅ |
| Necesita acceso a privados del padre | ✅ | (❌) |
| Tarea auxiliar, no reutilizable | ✅ | ❌ |
| Interfaz gráfica (Swing) | ✅ | ❌ |
| API pública | ❌ | ✅ |

---

## 🔗 La Palabra Clave `super` en Profundidad

### ¿Qué es `super`?

`super` es una referencia a la **clase padre inmediata**. Permite acceder a métodos y construcciones de la superclase.

```java
public class Uno {
    public int f() { return 10; }
}

public class Dos extends Uno {
    public int f() { 
        return super.f() + 5;  // ← super se refiere a Uno
    }
}
```

### Límites de `super`

**Regla Fundamental:** `super` siempre se refiere a la superclase **directa**.

```java
public class A { 
    public int x() { return 1; }
}

public class B extends A { 
    public int x() { return 2; }
}

public class C extends B {
    public int x() {
        return super.x();      // ← Accede a B.x(), NO A.x()
    }
}
```

### ¿Qué pasa cuando `super` no tiene sentido?

```java
public class Uno extends Object {  // Implícito: extends Object
    public int k() {
        return super.f() + 10;  // ❌ ERROR: Object no tiene f()
    }
}
```

**Error:** `Object` (la superclase de `Uno`) no tiene método `f()`. Esto causa **error de compilación**.

---

## 🚫 Errores Comunes en Jerarquías de Herencia

### Error 1: Mezclar Inner Classes con Herencia

```java
// ❌ MAL: Confuso y problemático
public class Uno {
    public class Dos extends Uno {  // Dos está dentro de Uno y hereda de Uno
        // ¿Quién es el padre? ¿La clase Uno o la instancia uno?
    }
}

// ✅ BIEN: Claro
public class Uno {
    // codigo
}

public class Dos extends Uno {  // Dos es una clase aparte
    // codigo
}
```

**Problema:** Ambigüedad en la estructura y difícil de mantener.

---

### Error 2: Llamar a `super` sin superclase válida

```java
// ❌ MAL
public class Uno {
    public int f() { return super.f(); }  // Uno extiende Object, que no tiene f()
}

// ✅ BIEN
public class Uno {
    public int f() { return 10; }  // No llama a super si no es necesario
}
```

---

### Error 3: Ciclos de llamadas entre métodos

```java
// ❌ MAL: Recursión infinita
public class Uno {
    public int f() { return k(); }          // f() llama a k()
    public int k() { return f() + 10; }     // k() llama a f()
                                            // f() → k() → f() → k() → ...
}

// ✅ BIEN: Base de recursión
public class Uno {
    public int f() { return 100; }      // Base: retorna un valor
    public int k() { return f() + 10; } // k() solo llama a f()
}
```

---

### Error 4: Confundir jerarquía de clases con anidación

```java
// ❌ CONFUSO
public class Uno {
    public class Dos extends Uno {
        public class Tres extends Dos {
            // ¿Estructura?
        }
    }
}

// ✅ CLARO
public class Uno { }
public class Dos extends Uno { }
public class Tres extends Dos { }
```

---

## 🔄 Recursión Infinita en Métodos

### Definición

Recursión infinita ocurre cuando un método se llama a sí mismo (directa o indirectamente) sin una **condición de salida** o con una condición que nunca se cumple.

### Ejemplo en nuestro código

```java
public int f() { return k(); }
public int k() { return super.f() + 10; }
```

**Flujo de ejecución (si compilara):**

```
f() → k() → super.f() (que es f() porque k() hereda) → k() → ...
```

**Resultado:** `StackOverflowError`

### Recursión válida vs Inválida

**❌ Inválida (sin base)**

```java
public int factorial(int n) {
    return n * factorial(n - 1);  // Siempre se llama a sí mismo
}
```

**✅ Válida (con base)**

```java
public int factorial(int n) {
    if (n <= 1) return 1;           // ← Base: condición de salida
    return n * factorial(n - 1);    // ← Llamada recursiva
}
```

---

## ⚠️ Patrones Anti-Pattern en Herencia

### Anti-Pattern 1: Jerarquía de herencia demasiado profunda

```java
// ❌ Difícil de entender
Class A extends Object
Class B extends A
Class C extends B
Class D extends C
Class E extends D
Class F extends E
// ... 10 niveles más
```

**Mejor:** Mantener jerarquías planas (máximo 3-4 niveles).

### Anti-Pattern 2: Herencia múltiple (no existe en Java, pero en otros lenguajes)

```java
// ❌ Ambiguo en lenguajes con herencia múltiple
public class C extends A, B {
    // ¿Quién es super? ¿A o B?
}
```

### Anti-Pattern 3: God Superclass

```java
// ❌ La superclase hace demasiado
public class EntidadUniversal {
    // 500 líneas de código
    // Métodos para TODO
}

public class Usuario extends EntidadUniversal { }
public class Producto extends EntidadUniversal { }
```

**Mejor:** Divir responsabilidades.

### Anti-Pattern 4: Violación del Principio Liskov

```java
// ❌ Violar expectativas
public class Pajaro {
    public void volar() { /* vuela */ }
}

public class Pinguino extends Pajaro {
    public void volar() {
        throw new UnsupportedOperationException("Los pingüinos no vuelan");
    }
}
```

**Mejor:** No heredar si no tiene sentido semántico.

---

## 🔙 Referencia a Conceptos Anteriores

### Herencia (Ejercicio 1)
- Conceptos básicos de superclase y subclase
- La palabra clave `extends`

### Override y `private` (Ejercicio 2)
- Override permite cambiar métodos heredados
- `private` no se hereda

### Constructores (Ejercicio 3)
- `super()` en constructores
- Orden de inicialización

### Casting (Ejercicio 4)
- Upcasting y downcasting
- Visibilidad de métodos según el tipo de variable

### Estos Conceptos Aplicados (Ejercicio 5)
- Errores en la utilizacion de `super`
- Estructura incorrecta de clases
- Recursión infinita
- Cómo evitar anti-patterns

