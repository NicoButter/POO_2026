# Conceptos POO - Ejercicio N°6

## 📑 Tabla de Contenidos

1. **Conceptos Nuevos en Este Ejercicio**
2. **Variables de Referencia: Inicialización e Inicialización por Defecto**
3. **NullPointerException (NPE)**
4. **Polimorfismo Dinámico (Vinculación Tardía)**
5. **Traza Manualizada en Herencia**
6. **Métodos `super` en Cadena**
7. **Errores de Compilación vs Runtime**
8. **Referencia a Conceptos Anteriores**

---

## ⭐ Conceptos Nuevos en Este Ejercicio

Este ejercicio combina **todos los conceptos anteriores** en un análisis práctico completo:

| Concepto | Ej. 1-5 | Ej. 6 |
|----------|---------|-------|
| Herencia | ✅ | ✅ |
| Override | ✅ | ✅ |
| Constructores | ✅ | ✅ |
| Casting | ✅ | ✅ |
| Polimorfismo | Básico | ✅ **NEW: Profundo** |
| NullPointerException | ❌ | ✅ **NEW** |
| Inicialización de variables | ❌ | ✅ **NEW** |
| Traza de ejecución | ❌ | ✅ **NEW** |
| Cadena de llamadas `super` | ❌ | ✅ **NEW** |

---

## 🎯 Variables de Referencia: Inicialización e Inicialización por Defecto

### Inicialización por Defecto en Java

En Java, **las variables no inicializadas explícitamente tienen valores por defecto**:

```java
public class Ejemplo {
    int numero;           // Atributo: int = 0
    boolean flag;         // Atributo: boolean = false
    String texto;         // Atributo: String = null
    AA objeto;            // Atributo: AA = null
}

public static void main(String[] args) {
    int num;              // Variable local: SIN INICIALIZAR (error si se usa)
    String str;           // Variable local: SIN INICIALIZAR (error si se usa)
    AA obj;               // Variable local: SIN INICIALIZAR (error si se usa)
}
```

**Regla importante:** Las **variables locales NO tienen valor por defecto** y generan error de compilación si se usan sin inicializar.

### Excepciones

En el ejercicio, si las variables estuvieran **declaradas como atributos de clase**, tendrían valores por defecto:

```java
public class Prueba {
    AA p;  // = null (atributo de clase)
    BB q;  // = null (atributo de clase)
    CC r;  // = null (atributo de clase)
    int M; // = 0 (atributo de clase)
}
```

Pero en el contexto de un `main()` o método, son **variables locales sin inicializar**.

---

## ⚠️ NullPointerException (NPE)

### ¿Qué es NullPointerException?

Una **excepción de runtime** que se lanza cuando intentas:
1. Llamar un método en una referencia `null`
2. Acceder a un atributo de una referencia `null`
3. Usar un operador en una referencia `null`

### Ejemplo

```java
String str = null;

// ❌ Todas causan NPE
str.length();           // Llamar método en null
System.out.println(str.charAt(0));  // Acceder a método

AA obj = null;
obj.g();               // Llamar método en null
```

### Características de NPE

```
Tipo:        Excepción de Runtime (no error de compilación)
Detección:   En ejecución
Causa común: Variables no inicializadas
Prevención:  Inicializar con new o verificar antes de usar
```

### Verificación previa

```java
AA obj = null;

// ❌ Causa NPE
obj.g();

// ✅ Forma segura
if (obj != null) {
    obj.g();
}

// ✅ Forma moderna (Java 8+)
if (obj != null && obj.g() > 0) {
    // codigo
}
```

---

## 🔄 Polimorfismo Dinámico (Vinculación Tardía)

### Definición

**Polimorfismo** es la capacidad de un objeto de tomar muchas formas. El método que se ejecuta se determina por el **tipo real del objeto EN TIEMPO DE EJECUCIÓN**, no por el tipo de la variable.

```java
AA p = new BB();  // p apunta a un BB

p.g();  // ¿Cuál g() se ejecuta?
        // Respuesta: BB.g() (el tipo real del objeto)
        // NO AA.g() (el tipo de la variable)
```

### Vinculación Temprana vs Tardía

**Vinculación Temprana (Early Binding)** - Tiempo de compilación:
```java
int suma = 5 + 3;  // Compilador sabe el resultado: 8
```

**Vinculación Tardía (Late Binding)** - Tiempo de ejecución:
```java
AA p = new BB();
int resultado = p.g();  // Compilador no sabe cuál g()
                        // En runtime, ejecuta BB.g()
```

### Ejemplo Completo

```java
class AA {
    public int g() { return 5; }
}

class BB extends AA {
    @Override
    public int g() { return 3; }
}

class CC extends BB {
    @Override
    public int g() { return super.g();  // = 3
    }
}

// Uso
AA p = new CC();         // p apunta a CC

// Vinculación tardía
int resultado = p.g();   // Ejecuta CC.g() = 3
                         // Aunque el tipo de p es AA
```

### Por qué es importante

Permite escribir código flexible que funciona con cualquier subclase:

```java
public void procesarFormas(AA forma) {
    System.out.println(forma.g());  // Funciona con BB, CC, o cualquier subclase
}

procesarFormas(new BB());  // Imprime 3
procesarFormas(new CC());  // Imprime 3
```

---

## 🔍 Traza Manualizada en Herencia

### Qué es una Traza

Una **traza** es un registro paso a paso de la ejecución de un programa, mostrando:
- Cada línea ejecutada
- El estado de las variables
- Los valores retornados
- Errores que ocurren

### Ejemplo de Traza

```java
p = new BB();       // Línea 1: p apunta a BB
M = p.g();          // Línea 2: Ejecuta BB.g() = 3, M = 3
q = p;              // Línea 3: q apunta a BB
M = M + p.h() ;     // Línea 4: Ejecuta BB.h() que llama BB.g() = 3
                    //         M = 3 + 3 = 6
```

### Notación de Traza

| Línea | Código | Acción | Estado |
|-------|--------|--------|--------|
| 1 | `p = new BB();` | Crear BB, asignar a p | `p → BB` |
| 2 | `M = p.g();` | Ejecutar BB.g(), retorna 3 | `M = 3` |
| 3 | `q = p;` | Asignar p a q | `q → BB` |
| 4 | `M = M + p.h();` | BB.h() → BB.g() = 3; M = 3+3 | `M = 6` |

---

## 🔗 Métodos `super` en Cadena

### Cadena de Llamadas `super`

Cuando usas `super`, accedes a la clase padre **inmediata**. Esto puede crear cadenas:

```java
class AA {
    public int g() { return 5; }
}

class BB extends AA {
    public int g() { return 3; }
    public int h() { return g(); }  // Llama a BB.g() (por polimorfismo)
}

class CC extends BB {
    public int g() { return super.g(); }   // Accede a BB.g() = 3
    public int h() { return super.h() + 1; } // Accede a BB.h()
}
```

### Traza de `super.h()` en CC

```java
CC objeto = new CC();
objeto.h();

// Traza:
// 1. CC.h() es ejecutado
// 2. Dentro: super.h() → accede a BB.h()
// 3. BB.h() retorna g()
// 4. Pero ¿cuál g()? Por polimorfismo: CC.g() (porque objeto es CC)
// 5. CC.g() retorna super.g() = BB.g() = 3
// 6. BB.h() retorna 3
// 7. CC.h() retorna 3 + 1 = 4
```

### Diagrama de Flujo

```
CC.h()
  ↓
super.h() → BB.h()
  ↓
g() → CC.g() (polimorfismo)
  ↓
super.g() → BB.g() = 3
  ↓
BB.h() retorna 3
  ↓
CC.h() retorna 3 + 1 = 4
```

---

## 🚨 Errores de Compilación vs Runtime

### Error de Compilación

**Detección:** Cuando compilas el código con `javac`

**Causas comunes:**
- Sintaxis incorrecta: `public int g();` con punto y coma
- Variables no declaradas
- Tipos incompatibles
- Métodos no existen

**Resultado:** El programa **nunca se ejecuta**

```java
// ❌ Error de compilación
public int g(); {
    return 5;
}
// Error: '.class' expected - El compilador no entiende esta sintaxis
```

### Error de Runtime

**Detección:** Cuando ejecutas el programa compilado con `java`

**Causas comunes:**
- NullPointerException
- ArrayIndexOutOfBoundsException
- ClassCastException
- Excepciones lanzadas por el código

**Resultado:** El programa se ejecuta pero **se detiene inesperadamente**

```java
AA p = null;
p.g();  // ❌ Compila bien, pero en runtime: NullPointerException
```

### Tabla Comparativa

| Aspecto | Compilación | Runtime |
|---------|-------------|---------|
| Cuándo ocurre | Al hacer `javac` | Al hacer `java` |
| Prevención | Revisar sintaxis | Revisar lógica |
| Mensaje | Error (no ejecuta) | Excepción (se detiene) |
| Ejemplo | Sintaxis incorrecta | NPE, ArrayIndexOutOfBounds |

---

## 🔙 Referencia a Conceptos Anteriores

### Herencia (Ejercicio 1-2)
- Conceptos básicos de superclase y subclase
- Override de métodos

### Constructores (Ejercicio 3)
- `super()` en constructores

### Casting (Ejercicio 4)
- Upcasting y downcasting
- Polimorfismo en asignación

### Errores en herencia (Ejercicio 5)
- `super` incorrecto
- Errores de compilación

### Estos Conceptos Aplicados (Ejercicio 6)
- Polimorfismo dinámico (vinculación tardía)
- Inicialización de variables
- NullPointerException
- Traza manual de ejecución
- Cadenas de llamadas `super`

