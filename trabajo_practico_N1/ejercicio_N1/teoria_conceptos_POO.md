# Teoría: Conceptos de Programación Orientada a Objetos (POO)

## 📚 Tabla de Contenidos

1. [Introducción a POO](#introducción-a-poo)
2. [Concepto: Herencia](#concepto-herencia)
3. [Concepto: Encapsulamiento](#concepto-encapsulamiento)
4. [Concepto: Polimorfismo](#concepto-polimorfismo)
5. [Relación con el Ejercicio](#relación-con-el-ejercicio)
6. [Ejemplos Prácticos](#ejemplos-prácticos)
7. [Ventajas de POO](#ventajas-de-poo)

---

## 🎯 Introducción a POO

**Programación Orientada a Objetos (POO)** es un paradigma de programación que organiza el código en torno a **objetos** y **clases**, permitiendo modelar entidades del mundo real con sus características (atributos) y comportamientos (métodos).

### ¿Por qué POO?

- ✅ **Modularidad:** El código está organizado en unidades autónomas (clases)
- ✅ **Reutilización:** El código puede reutilizarse a través de la herencia
- ✅ **Mantenibilidad:** Cambios localizados son más fáciles de implementar
- ✅ **Escalabilidad:** Proyectos grandes son más manejables

### Elementos Fundamentales

```
┌─────────────────────────────────────────┐
│          PROGRAMACIÓN ORIENTADA         │
│           A OBJETOS (POO)               │
├─────────────────────────────────────────┤
│                                         │
│  1. CLASES                              │
│     (Definiciones de estructura)        │
│                                         │
│  2. OBJETOS                             │
│     (Instancias de clases)              │
│                                         │
│  3. ATRIBUTOS                           │
│     (Características de los datos)      │
│                                         │
│  4. MÉTODOS                             │
│     (Comportamientos/funcionalidades)   │
│                                         │
│  5. HERENCIA                            │
│     (Especialización de clases)         │
│                                         │
│  6. POLIMORFISMO                        │
│     (Múltiples formas de comportamiento)│
│                                         │
│  7. ENCAPSULAMIENTO                     │
│     (Control de acceso)                 │
│                                         │
└─────────────────────────────────────────┘
```

---

## 🔗 Concepto: HERENCIA

### ¿Qué es Herencia?

La **herencia** es un mecanismo de POO que permite que una clase (llamada **clase derivada** o **subclase**) **herede** atributos y métodos de otra clase (llamada **clase base** o **superclase**).

### Objetivo

- **Reutilizar código** evitando duplicación
- **Establecer jerarquías** de especialización
- **Crear relaciones "es-un"** entre clases

### Sintaxis Java

```java
// Clase base (superclase)
public class Animal {
    protected String nombre;
    
    public void hacerSonido() {
        System.out.println("El animal hace un sonido");
    }
}

// Clase derivada (subclase) que hereda de Animal
public class Perro extends Animal {
    private String raza;
    
    public void hacerSonido() {
        System.out.println("¡Guau guau!");
    }
}
```

### Características

| Aspecto | Descripción |
|---------|-------------|
| **Palabra clave** | `extends` |
| **Relación** | "es-un" (A es-un B) |
| **Herencia de métodos** | La subclase hereda métodos públicos |
| **Herencia de atributos** | La subclase hereda atributos protected/public |
| **Override** | La subclase puede redefinir métodos |

### ¿Qué se Hereda?

```
┌──────────────────────────────────────┐
│      CLASE PADRE (Superclase)        │
├──────────────────────────────────────┤
│ - atributoPrivado     (private)      │ ❌ NO se hereda
│ # atributoProtegido   (protected)    │ ✅ Se hereda
│ + atributoPublico     (public)       │ ✅ Se hereda
│                                      │
│ + metodoPublico()     (public)       │ ✅ Se hereda
│ # metodoProtegido()   (protected)    │ ✅ Se hereda
│ - metodoPrivado()     (private)      │ ❌ NO se hereda
└──────────────────────────────────────┘
         △
         │ extends
         │
┌──────────────────────────────────────┐
│      CLASE HIJA (Subclase)           │
├──────────────────────────────────────┤
│ Hereda:                              │
│ - Métodos públicos del padre         │
│ - Métodos protegidos del padre       │
│ - Atributos públicos del padre       │
│ - Atributos protegidos del padre     │
│                                      │
│ NO hereda:                           │
│ - Métodos privados                   │
│ - Atributos privados                 │
└──────────────────────────────────────┘
```

### Tipos de Herencia

| Tipo | Descripción | Ejemplo |
|------|-------------|---------|
| **Simple** | Una clase hereda de una sola clase padre | `class B extends A` |
| **Multinivel** | Cadena de herencia A→B→C | `class C extends B` (donde B extends A) |
| **Múltiple** | ⚠️ Java **NO permite** herencia múltiple directa | Se usa con interfaces |

### Ventajas de la Herencia

✅ **Reutilización de código:** No repites el código que ya existe en la clase padre  
✅ **Organización jerárquica:** Las clases se organizan de lo general a lo específico  
✅ **Mantenimiento:** Los cambios en la clase padre se reflejan automáticamente en las subclases  
✅ **Polimorfismo:** Permite usar referencias de la clase padre apuntando a objetos de la subclase

---

## 🔐 Concepto: ENCAPSULAMIENTO

### ¿Qué es Encapsulamiento?

El **encapsulamiento** es el principio de **ocultar los detalles internos de implementación** de una clase, exponiendo solo las funcionalidades necesarias a través de una **interfaz pública**.

### Objetivo

- **Proteger datos:** Los atributos no deben ser modificados directamente
- **Controlar el acceso:** Solo métodos autorizados pueden acceder/modificar datos
- **Flexibilidad:** Cambios internos no afectan el código externo

### Modificadores de Acceso

```
┌────────────┬───────┬────────┬──────────┬─────────┐
│ Modificador│ Misma │ Mismo  │ Subclase │ Otros   │
│            │ Clase │ Paquete│          │         │
├────────────┼───────┼────────┼──────────┼─────────┤
│ private    │  ✅   │   ❌   │    ❌    │   ❌    │
├────────────┼───────┼────────┼──────────┼─────────┤
│ protected  │  ✅   │   ✅   │    ✅    │   ❌    │
├────────────┼───────┼────────┼──────────┼─────────┤
│ public     │  ✅   │   ✅   │    ✅    │   ✅    │
├────────────┼───────┼────────┼──────────┼─────────┤
│ (package)  │  ✅   │   ✅   │    ❌    │   ❌    │
└────────────┴───────┴────────┴──────────┴─────────┘
```

### Ejemplo: Encapsulamiento en Práctica

```java
public class CuentaBancaria {
    // Atributo privado - no accesible directamente
    private double saldo;
    
    // Constructor
    public CuentaBancaria(double saldoInicial) {
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        }
    }
    
    // Getter: método para acceder al saldo
    public double obtenerSaldo() {
        return saldo;
    }
    
    // Setter con validación
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito exitoso");
        } else {
            System.out.println("Cantidad inválida");
        }
    }
}

// Uso:
CuentaBancaria cuenta = new CuentaBancaria(1000);
// cuenta.saldo = -500; // ❌ ERROR - es private
cuenta.depositar(500);  // ✅ CORRECTO - método público con validación
System.out.println(cuenta.obtenerSaldo());
```

### Beneficios del Encapsulamiento

| Beneficio | Explicación |
|-----------|-------------|
| **Validación** | Los setters pueden validar datos antes de asignarlos |
| **Control** | Solo se permite lo que el diseñador autoriza |
| **Cambios internos** | La implementación puede cambiar sin afectar el código externo |
| **Protección** | Los datos sensibles están protegidos |

---

## 🎭 Concepto: POLIMORFISMO

### ¿Qué es Polimorfismo?

El **polimorfismo** (del griego "poli" = muchos, "morphos" = forma) significa que un objeto puede tener **múltiples formas** o comportamientos dependiendo del contexto.

### Objetivo

- Permitir que código genérico trabaje con múltiples tipos
- Simplificar el código reduciendo condicionales
- Mejorar la extensibilidad del programa

### Tipos de Polimorfismo

#### 1. **Polimorfismo de Compilación (Sobrecarga)**

Métodos con el **mismo nombre** pero **diferentes parámetros**:

```java
public class Calculadora {
    // Método 1: suma de dos números
    public int sumar(int a, int b) {
        return a + b;
    }
    
    // Método 2: suma de tres números (mismo nombre, diferente cantidad de parámetros)
    public int sumar(int a, int b, int c) {
        return a + b + c;
    }
    
    // Método 3: suma de decimales (mismo nombre, diferente tipo de parámetro)
    public double sumar(double a, double b) {
        return a + b;
    }
}

// Uso:
Calculadora calc = new Calculadora();
calc.sumar(5, 3);           // ✅ Llama al método 1
calc.sumar(5, 3, 2);        // ✅ Llama al método 2
calc.sumar(5.5, 3.2);       // ✅ Llama al método 3
```

#### 2. **Polimorfismo en Tiempo de Ejecución (Sobrescritura)**

Una **subclase redefine un método** de la superclase:

```java
public class Animal {
    public void hacerSonido() {
        System.out.println("Sonido genérico");
    }
}

public class Gato extends Animal {
    @Override  // Anotación que indica que estamos sobrescribiendo
    public void hacerSonido() {
        System.out.println("¡Miau!");
    }
}

public class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("¡Guau!");
    }
}

// Uso:
Animal animal1 = new Gato();
Animal animal2 = new Perro();
Animal animal3 = new Animal();

animal1.hacerSonido();  // ✅ Imprime: ¡Miau!
animal2.hacerSonido();  // ✅ Imprime: ¡Guau!
animal3.hacerSonido();  // ✅ Imprime: Sonido genérico
```

### Principio de Liskov

> **"Los objetos de una subclase deben poder ser utilizados en lugar de objetos de la superclase"**

Esto es lo que permite el polimorfismo: usar una **referencia de tipo padre** apuntando a **objetos de tipo hijo**:

```java
Animal animal = new Gato();  // ✅ Válido - Gato es-un Animal
// animal es de tipo Animal, pero se comporta como un Gato
```

---

## 🎓 Relación con el Ejercicio

### Jerarquía de Clases

Retomemos la jerarquía del ejercicio:

```
A (Superclase)
└── B (Subclase de A)
    └── C (Subclase de B)
```

### Aplicación de Conceptos

#### 1. **HERENCIA**

- `B extends A` → B hereda `metodoA()` y `atributoA`
- `C extends B` → C hereda `metodoB()`, `metodoA()`, `atributoB`, `atributoA`

**Ventaja:** No repetimos código en B ni en C; lo reutilizamos de A y B.

#### 2. **ENCAPSULAMIENTO**

- Todos los atributos son `private` → protegidos de modificaciones externas
- Solo los métodos son `public` → interfaz controlada
- Si necesitáramos acceso a los atributos, usaríamos getters/setters

```java
// Si quisiéramos acceso al atributoA:
public class A {
    private int atributoA;
    
    public int getAtributoA() {
        return atributoA;  // ✅ Acceso controlado
    }
    
    public void setAtributoA(int valor) {
        if (valor >= 0) {  // ✅ Validación
            this.atributoA = valor;
        }
    }
    
    public void metodoA() { }
}
```

#### 3. **POLIMORFISMO (Potencial)**

Si las clases sobrescribieran métodos:

```java
public class A {
    public void metodo() {
        System.out.println("Comportamiento A");
    }
}

public class B extends A {
    @Override
    public void metodo() {
        System.out.println("Comportamiento B - especializado");
    }
}

// Uso polimórfico:
A obj = new B();
obj.metodo();  // ✅ Imprime: "Comportamiento B - especializado"
               // Polimorfismo: mismo mensaje, comportamiento diferente
```

---

## 💻 Ejemplos Prácticos

### Ejemplo 1: Sistema de Vehículos

```java
// Clase base
public class Vehiculo {
    private String marca;
    
    public Vehiculo(String marca) {
        this.marca = marca;
    }
    
    public void acelerar() {
        System.out.println("El vehículo acelera");
    }
}

// Subclase
public class Auto extends Vehiculo {
    private int puertas;
    
    public Auto(String marca, int puertas) {
        super(marca);  // Llama al constructor del padre
        this.puertas = puertas;
    }
    
    @Override
    public void acelerar() {
        System.out.println("El auto acelera suavemente");
    }
}

// Subclase de Auto (herencia multinivel)
public class Deportivo extends Auto {
    public Deportivo(String marca) {
        super(marca, 2);  // Auto deportivo típicamente tiene 2 puertas
    }
    
    @Override
    public void acelerar() {
        System.out.println("¡El deportivo acelera a máxima velocidad!");
    }
}

// Uso:
Vehiculo v1 = new Vehiculo("Toyota");
Vehiculo v2 = new Auto("Honda", 4);
Vehiculo v3 = new Deportivo("Ferrari");

v1.acelerar();  // El vehículo acelera
v2.acelerar();  // El auto acelera suavemente
v3.acelerar();  // ¡El deportivo acelera a máxima velocidad!
```

### Ejemplo 2: Figuras Geométricas

```java
// Clase base
public class Figura {
    public double calcularArea() {
        return 0;
    }
}

// Subclase: Cuadrado
public class Cuadrado extends Figura {
    private double lado;
    
    public Cuadrado(double lado) {
        this.lado = lado;
    }
    
    @Override
    public double calcularArea() {
        return lado * lado;
    }
}

// Subclase: Círculo
public class Circulo extends Figura {
    private double radio;
    
    public Circulo(double radio) {
        this.radio = radio;
    }
    
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}

// Uso:
ArrayList<Figura> figuras = new ArrayList<>();
figuras.add(new Cuadrado(5));
figuras.add(new Circulo(3));

for (Figura f : figuras) {
    System.out.println("Área: " + f.calcularArea());
}
```

---

## 🌟 Ventajas de POO

### 1. **Reutilización de Código**

```
Sin POO: escribir el mismo código múltiples veces
Con POO: herencia → reutilizar = código más limpio
```

### 2. **Mantenimiento**

```
Cambio en una clase base se propaga automáticamente a las subclases
```

### 3. **Escalabilidad**

```
El código puede crecer sin volverse caótico
Cada clase tiene responsabilidad clara
```

### 4. **Facilidad de Pruebas**

```
Cada clase puede probarse de forma independiente
Mocking y testing más sencillos
```

### 5. **Modeling del Mundo Real**

```
Las clases modelan entidades reales
Más intuitivo para entender el dominio del problema
```

---

## 📊 Comparativa: CON vs SIN POO

### ❌ SIN POO (Procedural)

```java
// Código duplicado, difícil de mantener
void crearAnimal1() {
    System.out.println("Crear Animal 1");
    // ... 20 líneas de código
}

void crearAnimal2() {
    System.out.println("Crear Animal 2");
    // ... 20 líneas IGUALES de código
}

void crearAnimal3() {
    System.out.println("Crear Animal 3");
    // ... 20 líneas IGUALES de código
}
```

### ✅ CON POO

```java
// Código limpio, reutilizable, extensible
public class Animal {
    // ... implementación común
}

public class Perro extends Animal { }
public class Gato extends Animal { }
public class Pajaro extends Animal { }

// Solo crear instancias
Perro perro = new Perro();
Gato gato = new Gato();
Pajaro pajaro = new Pajaro();
```

---

## 🎯 Conclusión

Los conceptos de **Herencia**, **Encapsulamiento** y **Polimorfismo** son los pilares de POO:

| Concepto | Beneficio | En el Ejercicio |
|----------|-----------|-----------------|
| **Herencia** | Reutilización | B y C heredan de A |
| **Encapsulamiento** | Protección | Atributos `private` |
| **Polimorfismo** | Flexibilidad | Potencial para sobrescritura |

**El resultado:** Código **modular**, **reutilizable**, **mantible** y **escalable**.

---

## 📚 Recursos Adicionales

- [Oracle Java Docs - Inheritance](https://docs.oracle.com/javase/tutorial/java/concepts/inheritance.html)
- [Polymorphism in Java](https://www.baeldung.com/java-polymorphism)
- SOLID Principles (próximo tema)
