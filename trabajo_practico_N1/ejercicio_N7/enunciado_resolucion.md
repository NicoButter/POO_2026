# Ejercicio N°7: Análisis de Errores con Herencia y Polimorfismo

## 📋 Enunciado

Dadas las siguientes clases:

```java
public class Uno {
    public int f() {
        return g() + 10;
    }
    public int g() {
        return 2;
    }
}

public class Dos extends Uno {
    public int g() {
        return 50 + k();
    }
    public int k() {
        return 100;
    }
}
```

Y las declaraciones:
```java
Uno a, b;
Dos c, d;
int n, m;
```

**Tarea:** Analizar cada segmento de código indicando si hay errores (de compilación o runtime), justificando la respuesta y señalando los valores finales de `n` y `m` cuando sea posible.

---

## 🔍 Análisis de Segmentos

### 📌 Segmento (a)

```java
a = new Uno();
c = new Dos();
b = c;
m = b.k();
```

#### Estado línea a línea

| Línea | Código | Estado | Notas |
|-------|--------|--------|-------|
| 1 | `a = new Uno();` | ✅ | `a → Uno` |
| 2 | `c = new Dos();` | ✅ | `c → Dos` |
| 3 | `b = c;` | ✅ | `b → Dos` (tipo declarado: Uno) |
| 4 | `m = b.k();` | ❌ ERROR | Método no existe en Uno |

#### ❌ ERROR: **COMPILACIÓN**

**Justificación:**
- `b` está **declarado como tipo `Uno`**
- El compilador **solo conoce el tipo declarado** de `b`, no el tipo real del objeto en tiempo de ejecución
- El método `k()` **NO existe en la clase `Uno`** (solo existe en `Dos`)
- Aunque en runtime `b` apunta a un objeto `Dos`, el compilador rechaza la llamada
- **Mensaje de error:** `cannot find symbol - method k() in class Uno`

**Conclusión:** El código **no compila**. Las líneas posteriores nunca se ejecutan.

---

### 📌 Segmento (b)

```java
a = new Uno();
b = a;
d = new Dos();
n = d.f();
a = d;
d = c;           // ← ERROR aquí
m = d.g() + c.k() + a.f();
d = (Dos)a;
n = m - d.k();
```

#### Estado línea a línea

| Línea | Código | Estado | Cálculo |
|-------|--------|--------|---------|
| 1 | `a = new Uno();` | ✅ | `a → Uno` |
| 2 | `b = a;` | ✅ | `b → Uno` |
| 3 | `d = new Dos();` | ✅ | `d → Dos` |
| 4 | `n = d.f();` | ✅ | `d.f()` llama `g()` de Dos → `50+100 = 150`, retorna `150+10=160`; **`n = 160`** |
| 5 | `a = d;` | ✅ | `a → Dos` (upcasting automático) |
| 6 | `d = c;` | ❌ ERROR | `c` nunca fue inicializado |
| 7+ | (No se ejecutan) | — | — |

#### ❌ ERROR: **COMPILACIÓN**

**Justificación:**
- `c` fue **declarado pero NUNCA inicializado** en este segmento
- En Java, las **variables locales NO tienen valor por defecto**
- El compilador realiza un análisis de "definite assignment" y detecta que `c` podría no tener un valor
- **Mensaje de error:** `variable c might not have been initialized`

**Conclusión:** El código **no compila**. El compilador detiene la compilación en la línea 6.

**Nota especulativa:** Si `c` hubiera sido inicializado (ej: `c = new Dos();`), entonces:
- Línea 4: `n = 160` ✅
- Línea 6: `d = c;` ✅
- Línea 7: `m = d.g() + c.k() + a.f()` = `(50+100) + 100 + (2+10)` = `150 + 100 + 160` = `410`
- Línea 8: `d = (Dos)a;` ✅ (legal porque `a` apunta a un `Dos`)
- Línea 9: `n = m - d.k()` = `410 - 100` = `310`

---

### 📌 Segmento (c)

```java
a = new Uno();
c = new Dos();
b = c;
m = a.g();
d = (Dos)a;      // ← ERROR aquí
n = m - d.k();
```

#### Estado línea a línea

| Línea | Código | Tipo de Verificación | Resultado |
|-------|--------|----------------------|-----------|
| 1 | `a = new Uno();` | — | ✅ `a → Uno` |
| 2 | `c = new Dos();` | — | ✅ `c → Dos` |
| 3 | `b = c;` | — | ✅ `b → Dos` |
| 4 | `m = a.g();` | — | ✅ `a.g()` de Uno → retorna 2; **`m = 2`** |
| 5 | `d = (Dos)a;` | Compilación ✅ Runtime ❌ | **ClassCastException** |
| 6 | `n = m - d.k();` | — | No se ejecuta |

#### ❌ ERROR: **RUNTIME (ClassCastException)**

**Justificación multiparte:**

1. **En tiempo de compilación:** ✅ **VÁLIDO**
   - `Dos` es subclase de `Uno`
   - El cast `(Dos)a` pasa la verificación de tipos estática del compilador
   - No hay error de compilación

2. **En tiempo de ejecución:** ❌ **FALLA**
   - `a` apunta a un objeto **`Uno`** real, no a `Dos`
   - Java verifica en runtime si el objeto actual ES una instancia de `Dos`
   - Como el objeto es **`Uno`**, el cast es ilegal
   - Java lanza: `ClassCastException: class Uno cannot be cast to class Dos`

**Flujo de ejecución:**
```
Líneas 1-4: Ejecución normal
Línea 5: ClassCastException → Programa interrumpido
Línea 6: No se ejecuta (nunca se alcanza)
```

**Conclusión:** El código **compila correctamente**, pero **falla en tiempo de ejecución** con una excepción.

---

## 📊 Resumen Comparativo

| Segmento | Tipo de Error | Línea | Razón | Compila | Ejecuta |
|----------|---|---|---|---|---|
| **(a)** | Compilación | 4 | Método `k()` no existe en tipo `Uno` | ❌ NO | — |
| **(b)** | Compilación | 6 | Variable `c` no inicializada | ❌ NO | — |
| **(c)** | Runtime | 5 | Cast inválido: objeto Uno ≠ Dos | ✅ SÍ | ❌ NO |

---

## 🎓 Conceptos Clave Demostrados

### 1. Vinculación Estática vs Dinámica

```java
Uno b = new Dos();
b.k();  // ❌ Error en compilación
        // Compilador ve b como Uno → k() no existe
        // Aunque en runtime el objeto es Dos
```

**Lección:** El compilador valida contra el **tipo declarado**, no el tipo real del objeto.

### 2. Inicialización de Variables Locales

```java
Uno a;          // Solo declaración
a = new Uno();  // Ahora inicializada

// En un método:
Dos c;
// ... si intentas usar c aquí sin asignación = ERROR
d = c;          // ❌ Error: "variable c might not have been initialized"
```

**Lección:** Las variables locales **DEBEN** inicializarse antes de usarse. Los atributos de clase tienen valores por defecto.

### 3. Dos Fases de Validación en Casts

```java
// Fase 1: Compilación (estática)
d = (Dos)a;     // ✅ Válido: ¿Es Dos subclase de Uno? SÍ

// Fase 2: Ejecución (dinámica)
// ¿El objeto real ES una instancia de Dos? 
// Si a → Uno: ❌ NO → ClassCastException
// Si a → Dos: ✅ SÍ → OK
```

**Lección:** Los casts pasan dos validaciones: una en compilación (tipos) y otra en runtime (instancias reales).

### 4. Polimorfismo en Lectura vs Escritura

```java
// Lectura: upcasting automático ✅
Uno variable = new Dos();

// Escritura: requiere cast explícito
Dos resultado = (Dos) variable;  // Necesita verificación runtime
```

---

## 🔗 Conexión con Conceptos Anteriores

- **Ejercicio 1-2:** Herencia y override de métodos
- **Ejercicio 3:** Constructores y llamadas `super()`
- **Ejercicio 4:** Casting (upcasting y downcasting)
- **Ejercicio 5:** Errores típicos en herencia
- **Ejercicio 6:** Polimorfismo dinámico y vinculación tardía
- **Ejercicio 7:** Integración de todos los conceptos anteriores

