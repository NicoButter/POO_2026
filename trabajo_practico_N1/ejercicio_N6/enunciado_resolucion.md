# Ejercicio N°6: Traza de Código con Herencia y Polimorfismo

## 📋 Enunciado General

Dada la siguiente definición de clases:

```java
public class AA {
    public AA(){}
    public int g() {
        return 5;
    }
}

public class BB extends AA {
    public BB(){super();}
    public int g() {
        return 3;
    }
    public int h() {
        return g();
    }
}

public class CC extends BB {
    public CC(){super();}
    public int g(); {  // ❌ ERROR DE SINTAXIS
        return super.g();
    }
    public int h() {
        return super.h()+1;
    }
}
```

Y las declaraciones:
```java
AA p; 
BB q; 
CC r; 
int M;
```

### Tarea

Realice la traza para cada segmento de código:
- **(a)**, **(b)**, **(c)**

Si encuentra una sentencia errónea, indique si el error es en **tiempo de ejecución** o de **compilación**. 

Además, indique el valor de **M** hasta la última sentencia válida.

---

## 🐛 Error Identificado

### Error en la Clase CC

```java
public int g(); {  // ❌ ERROR DE COMPILACIÓN
    return super.g();
}
```

**Problema:** Hay un **punto y coma (;) antes de las llaves**.

**Forma correcta:**

```java
public int g() {  // ✅ Correcto
    return super.g();
}
```

**Tipo de error:** **ERROR DE COMPILACIÓN**

El compilador de Java no permite esta sintaxis. La presencia del punto y coma convierte `g()` en una declaración de método abstracto incompleta.

---

## 📊 Diagrama de Clases

```
         AA
         ├─ g(): 5
         └─ constructor()
          ▲
          │ hereda
          │
         BB
         ├─ g(): 3
         ├─ h(): g() = 3
         └─ constructor()
          ▲
          │ hereda
          │
         CC
         ├─ g(): super.g() = 3
         ├─ h(): super.h() + 1 = 4
         └─ constructor()
```

---

## 🔴 Resolución Corregida del Código

Para que el código sea válido, debe ser:

```java
public class AA {
    public AA(){}
    public int g() {
        return 5;
    }
}

public class BB extends AA {
    public BB(){super();}
    public int g() {
        return 3;
    }
    public int h() {
        return g();
    }
}

public class CC extends BB {
    public CC(){super();}
    public int g() {  // ✅ Sin punto y coma
        return super.g();  // Retorna 3 (g() de BB)
    }
    public int h() {
        return super.h()+1;  // super.h() de BB retorna 3, +1 = 4
    }
}

// Declaraciones
AA p; 
BB q; 
CC r; 
int M;
```

---

## ✅ Traza de Ejecución (Código Corregido)

### Segmento (a)

```java
p = q;
q = r;
M = p.g();
M = M + p.h();
M = q.h();
```

#### Análisis línea por línea:

**Línea 1: `p = q;`**
- Asignación: `p = null` (q no ha sido inicializado)
- ✅ Válido
- Estado: `p = null`

**Línea 2: `q = r;`**
- Asignación: `q = null` (r no ha sido inicializado)
- ✅ Válido
- Estado: `q = null`

**Línea 3: `M = p.g();`**
- `p = null`
- Intentar llamar a un método en `null`
- ❌ **ERROR EN RUNTIME: NullPointerException**
- Ejecución se detiene

#### Resultado Segmento (a):
| State | Valor |
|-------|-------|
| M (última asignación válida) | **No asignado** |
| Error | **NullPointerException en tiempo de ejecución** |

---

### Segmento (b)

```java
p = q;
M = r.g();
q = r;
M = M + q.h();
```

#### Análisis línea por línea:

**Línea 1: `p = q;`**
- `q = null`
- Asignación: `p = null`
- ✅ Válido
- Estado: `p = null`

**Línea 2: `M = r.g();`**
- `r = null`
- Intentar llamar a un método en `null`
- ❌ **ERROR EN RUNTIME: NullPointerException**
- Ejecución se detiene

#### Resultado Segmento (b):
| State | Valor |
|-------|-------|
| M (última asignación válida) | **No asignado** |
| Error | **NullPointerException en tiempo de ejecución** |

---

### Segmento (c)

```java
p = q;
M = q.g() + p.g() + r.g();
q = r;
r = null;
```

#### Análisis línea por línea:

**Línea 1: `p = q;`**
- `q = null`
- Asignación: `p = null`
- ✅ Válido
- Estado: `p = null`

**Línea 2: `M = q.g() + p.g() + r.g();`**
- `q = null` → llamar a `q.g()` 
- ❌ **ERROR EN RUNTIME: NullPointerException**
- Ejecución se detiene antes de hacer la suma

#### Resultado Segmento (c):
| State | Valor |
|-------|-------|
| M (última asignación válida) | **No asignado** |
| Error | **NullPointerException en tiempo de ejecución** |

---

## 🎯 Análisis Alternativo (Si las variables estuvieran inicializadas)

Para comprender mejor cómo funcionarían los métodos, supongamos que las variables **sí** estuvieran inicializadas:

### Supuesto Alternativo:

```java
AA p = new BB();  // p apunta a objeto BB
BB q = new CC();  // q apunta a objeto CC
CC r = new CC();  // r apunta a objeto CC
int M;
```

#### Segmento (a) - Simulado:

```java
p = q;              // p ahora apunta a CC (upcasting)
q = r;              // q apunta a CC
M = p.g();          // Polimorfismo: p es CC, por eso llama a CC.g()
                    // CC.g() → super.g() (BB.g()) → 3
                    // M = 3

M = M + p.h();      // p es CC, por eso llama a CC.h()
                    // CC.h() → super.h() (BB.h()) + 1 
                    // BB.h() → g() ... pero espera, ¿cuál g()?
                    // Polimorfismo: se llama CC.g() = 3
                    // CC.h() = 3 + 1 = 4
                    // M = 3 + 4 = 7

M = q.h();          // q es CC, por eso llama a CC.h()
                    // CC.h() = 4
                    // M = 4
```

---

## 📊 Tabla Comparativa de Resultados

| Segmento | Línea Problemática | Tipo Error | Última M | Estado Final |
|----------|-------------------|-----------|----------|--------------|
| (a) | `M = p.g();` | Runtime (NPE) | No asignado | NPE |
| (b) | `M = r.g();` | Runtime (NPE) | No asignado | NPE |
| (c) | `M = q.g() + ...` | Runtime (NPE) | No asignado | NPE |

---

## 🔍 Explicación del Comportamiento

### ¿Por qué todos causan NullPointerException?

Java no inicializa automáticamente las variables de referencia. Por defecto, son `null`:

```java
AA p;    // p = null (por defecto)
BB q;    // q = null (por defecto)
CC r;    // r = null (por defecto)
```

Cuando intentas llamar a un método en una variable `null`, obtienes **NullPointerException**.

### Resolución correcta (necesitaría inicialización)

```java
AA p = new BB();  // p apunta a una instancia de BB
BB q = new CC();  // q apunta a una instancia de CC
CC r = new CC();  // r apunta a una instancia de CC

// Ahora sí se pueden ejecutar las líneas sin NPE
```

---

## 🔗 Resumen de Errores

| Error | Tipo | Descripción |
|-------|------|-------------|
| Punto y coma en `int g();` | Compilación | Sintaxis inválida |
| Llamar métodos en `null` | Runtime | NullPointerException |

---

## 💡 Lecciones Clave

1. **Las variables de referencia son `null` por defecto** → inicializar con `new`
2. **No puedes llamar métodos en `null`** → verificar antes con `if (var != null)`
3. **La sintaxis es crítica**: cada carácter cuenta (el punto y coma antes de las llaves es un error)
4. **Polimorfismo en acción**: El método llamado depende del tipo real del objeto, no del tipo de la variable
5. **`super` tiene limitaciones**: Solo accede a la clase padre inmediata

