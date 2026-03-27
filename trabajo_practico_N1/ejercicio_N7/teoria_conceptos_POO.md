# Conceptos POO - Ejercicio N°7

## 📑 Tabla de Contenidos

1. **Conceptos Nuevos en Este Ejercicio**
2. **Vinculación Estática vs Dinámica**
3. **Variables de Referencia: Inicialización**
4. **Validación de Tipos en Casts**
5. **Errores de Compilación vs Runtime**
6. **Polimorfismo: Profundización**
7. **Integración de Conceptos**

---

## ⭐ Conceptos Nuevos en Este Ejercicio

Este ejercicio integra **todos los conceptos anteriores** en análisis práctico profundo:

| Concepto | Ej. 1-6 | Ej. 7 |
|----------|---------|-------|
| Herencia | ✅ | ✅ **Aplicado** |
| Override | ✅ | ✅ **Aplicado** |
| Casting | ✅ | ✅ **Profundo** |
| Polimorfismo | ✅ | ✅ **Análisis Completo** |
| Vinculación estática | ❌ | ✅ **NEW** |
| Inicialización de variables | ✅ | ✅ **Análisis profundo** |
| Validación de casts | ✅ | ✅ **Dos fases** |
| Errores compilación vs runtime | ✅ | ✅ **Comparativas** |

---

## 🔄 Vinculación Estática vs Dinámica

### Definición

**Vinculación (Binding)** es el proceso de resolver a **QUÉ método se llama** cuando ejecutas una instrucción.

#### Vinculación Estática (Compilación)

El compilador decide en tiempo de compilación **qué métodos existen** basado en el **tipo declarado** de la variable.

```java
Uno variable = new Dos();

// Compilador ve: "variable de tipo Uno"
// Búsqueda en clase Uno:
variable.f();    // ✅ Existe en Uno
variable.g();    // ✅ Existe en Uno
variable.k();    // ❌ NO existe en Uno → ERROR
```

#### Vinculación Dinámica (Ejecución)

En ejecución, el JVM llama el método de la **clase real del objeto** (polimorfismo).

```java
Uno variable = new Dos();

// En tiempo de ejecución: "variable apunta a un Dos"
// Búsqueda del método en la clase real (Dos):
variable.f();    // Ejecuta Uno.f(), que llama g()
                 // ¿Cuál g()? Dos.g() (polimorfismo)
```

### Tabla Comparativa

| Aspecto | Vinculación Estática | Vinculación Dinámica |
|---------|---|---|
| **Cuando ocurre** | Compilación | Ejecución |
| **Base** | Tipo declarado de variable | Tipo real del objeto |
| **Métodos válidos** | Los del tipo declarado | Los de la clase actual |
| **Ejemplos** | Variable a variable, método a método | Polimorfismo, override |
| **Errores** | `cannot find symbol` | `ClassCastException`, `NullPointerException` |

---

## 🎯 Variables de Referencia: Inicialización

### Reglas de Inicialización en Java

#### Atributos de Clase (No inicializados explícitamente)

```java
public class Ejemplo {
    int numero;              // = 0
    boolean flag;            // = false
    String texto;            // = null
    MiClase objeto;          // = null
}
```

**Regla:** Los atributos de clase tienen **valores por defecto**.

#### Variables Locales (En métodos)

```java
public void metodo() {
    int numero;              // ❌ SIN VALOR
    boolean flag;            // ❌ SIN VALOR
    String texto;            // ❌ SIN VALOR
    
    // Intentar usar:
    System.out.println(numero);  // ❌ ERROR DE COMPILACIÓN
}
```

**Regla:** Las variables locales **NO tienen valor por defecto** y causan error de compilación si se usan sin inicializar.

### Análisis de Flujo (Flow Analysis)

Java usa análisis de flujo para determinar si una variable fue inicializada:

```java
public void ejemplo(boolean condicion) {
    int valor;
    
    if (condicion) {
        valor = 5;  // Inicializado en una rama
    }
    
    System.out.println(valor);  // ❌ ERROR
    // Razón: En la rama else, valor no se inicializa
}
```

Solución:

```java
public void ejemplo(boolean condicion) {
    int valor = 0;  // Inicialización garantizada
    
    if (condicion) {
        valor = 5;
    }
    
    System.out.println(valor);  // ✅ OK
}
```

---

## 🔐 Validación de Tipos en Casts

### Dos Fases del Cast

```java
Dos resultado = (Dos) variable;
```

#### Fase 1: Compilación (Estática)

```
¿Es Dos una clase o subclase de Uno?

if (Dos es subclase de declaredType(variable)) {
    ✅ Compilación acepta
} else {
    ❌ Error: incompatible types
}
```

#### Fase 2: Ejecución (Dinámica)

```
¿El objeto al que apunta variable es realmente una instancia de Dos?

if (actualType(object) instanceof Dos) {
    ✅ Cast exitoso
} else {
    ❌ ClassCastException
}
```

### Ejemplo Completo

```java
class A { }
class B extends A { }
class C { }

// Escenario 1: Mismo tipo
A variable1 = new B();
B resultado1 = (B) variable1;  // ✅ Compila y ejecuta
                               // Compilación: ¿B extends A? SÍ
                               // Ejecución: ¿variable1 es B? SÍ

// Escenario 2: Tipo incorrecto
A variable2 = new A();
B resultado2 = (B) variable2;  // ✅ Compila, ❌ ClassCastException en ejecución
                               // Compilación: ¿B extends A? SÍ
                               // Ejecución: ¿variable2 es B? NO → Exception

// Escenario 3: Tipos no relacionados
C variable3 = new C();
B resultado3 = (B) variable3;  // ❌ Error de compilación
                               // Compilación: ¿B extends/es C? NO
```

---

## 🚨 Errores de Compilación vs Runtime

### Error de Compilación

**Detección:** Durante `javac` (compilación)

**Causas comunes:**
- Sintaxis incorrecta
- Métodos no existen en el tipo declarado
- Variables no inicializadas (análisis de flujo)
- Tipos incompatibles sin cast

**Resultado:** El archivo `.class` NO se genera

```java
// ❌ ERROR DE COMPILACIÓN
Uno referencia = new Uno();
referencia.k();  // k() no existe en Uno
                 // Error: cannot find symbol - method k()
```

### Error de Runtime

**Detección:** Durante `java` (ejecución)

**Causas comunes:**
- ClassCastException
- NullPointerException
- ArrayIndexOutOfBoundsException

**Resultado:** El programa se ejecuta pero falla con excepción

```java
// ✅ COMPILA, ❌ ERROR DE EJECUCIÓN
Uno referencia = new Uno();
Dos resultado = (Dos) referencia;  // ClassCastException
```

### Matriz de Decisión

```
┌─────────────────────────────────────────────────────────────┐
│             ¿CUÁNDO FALLA?                                  │
├─────────────────────────────────────────────────────────────┤
│ 1. ¿Método existe en tipo declarado?                        │
│    NO  → Error de COMPILACIÓN                              │
│    SÍ  → Continúa paso 2                                   │
├─────────────────────────────────────────────────────────────┤
│ 2. ¿Variables inicializadas?                                │
│    NO  → Error de COMPILACIÓN                              │
│    SÍ  → Continúa paso 3                                   │
├─────────────────────────────────────────────────────────────┤
│ 3. ¿Cast válido para tipo declarado?                        │
│    NO  → Error de COMPILACIÓN                              │
│    SÍ  → Continúa paso 4                                   │
├─────────────────────────────────────────────────────────────┤
│ 4. ¿Objeto real ES instancia del tipo esperado?             │
│    NO  → Error de RUNTIME (ClassCastException)             │
│    SÍ  → ✅ ÉXITO                                          │
└─────────────────────────────────────────────────────────────┘
```

---

## 🔍 Polimorfismo: Profundización

### La Clave del Polimorfismo

```java
public class Principal {
    public void procesar(Uno objeto) {
        objeto.g();  // ¿Cuál g() se ejecuta?
    }
}

// Opción A: g() de Uno
Nueva instancia = new Uno();
principal.procesar(instancia);

// Opción B: g() de Dos (OVERRIDE)
Nueva instancia = new Dos();
principal.procesar(instancia);
// Resultado: Ejecuta Dos.g()
```

**La magia del polimorfismo:** El método que se ejecuta depende del **tipo real del objeto**, no del tipo de la referencia.

### Casos que NO son Polimorfismo

```java
// ❌ NO es polimorfismo - error de compilación
Uno referencia = new Dos();
referencia.k();  // k() no está en Uno

// Solución: Cast explícito después de verificar
if (referencia instanceof Dos) {
    Dos real = (Dos) referencia;
    real.k();  // ✅ Ahora SÍ funciona
}
```

---

## 🎯 Integración de Conceptos

### Flujo de Decisión Completo

Al analizar código con herencia, sigue este orden:

1. **¿Compila?** (Validariones estáticas)
   - ¿Existen los métodos en los tipos declarados?
   - ¿Las variables están inicializadas?
   - ¿Los casts son válidos para los tipos?

2. **¿Ejecuta?** (Validaciones dinámicas)
   - ¿Las referencias son null?
   - ¿Los casts son válidos para los objetos reales?
   - ¿Qué métodos se llaman por polimorfismo?

3. **¿Qué resultado?**
   - Calcular valores finales
   - Interpretar excepciones

### Ejercicios de Autoverificación

Para cada segmento, pregúntate:

- [ ] ¿Todos los métodos existenen los tipos declarados?
- [ ] ¿Todas las variables están inicializadas?
- [ ] ¿Los casts son válidos en compilación?
- [ ] ¿Este código siquiera compila?
- [ ] Si compila, ¿ejecuta sin excepciones?
- [ ] ¿Qué valores finales tienen n y m?

---

## 📚 Referencia a Ejercicios Anteriores

| Ejercicio | Concepto Principal | Se Usa en Ej. 7 |
|-----------|---|---|
| 1-2 | Herencia y Override | ✅ Core |
| 3 | Constructores | ✅ Indirecto |
| 4 | Casting | ✅ Profundo |
| 5 | Errores en Herencia | ✅ Análisis |
| 6 | Polimorfismo Dinámico | ✅ Fundamental |
| **7** | **Integración Completa** | ✅ Todo junto |

