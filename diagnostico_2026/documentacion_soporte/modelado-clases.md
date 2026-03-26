# Modelado de Clases en POO

> **Material Extracurricular** | Autor: Nicolás Butterfield  
> Este documento forma parte del material complementario diseñado para fortalecer y enriquecer los conceptos teóricos y prácticos impartidos en la materia de Programación Orientada a Objetos.

## ¿Qué es el Modelado de Clases?

El **modelado de clases** es el proceso de diseñar y representar las entidades, sus atributos, métodos y relaciones que formarán parte de un sistema de software orientado a objetos. Es una de las actividades más importantes en el análisis y diseño de software.

## ¿Por qué es importante?

- **Visualiza la estructura**: Permite ver el sistema antes de programarlo
- **Facilita la comunicación**: El equipo puede discutir el diseño usando diagramas
- **Detecta problemas tempranos**: Es más fácil corregir errores en el diseño que en el código
- **Guía la implementación**: Sirve como blueprint para escribir el código

## Proceso de Modelado de Clases

### 1. Identificar las Entidades (Sustantivos)

Lee la descripción del problema y busca los **sustantivos** que representan conceptos importantes.

**Ejemplo - Sistema Lollapalooza:**
> "El festival Lollapalooza necesita gestionar las **bandas** que tocarán en diferentes **escenarios** durante el evento. Cada **actuación** tiene un horario específico y una duración determinada."

**Entidades identificadas:**
- Festival (Lollapalooza)
- Banda
- Escenario
- Actuación

### 2. Identificar Atributos (Características)

Para cada entidad, determina qué información necesitas almacenar.

**Ejemplo:**

| Clase | Atributos |
|-------|-----------|
| Lollapalooza | país, edición, sede, cantidad de días |
| Banda | nombre, integrantes, estilo musical, país de origen, año de formación |
| Escenario | nombre, ubicación, capacidad |
| Actuación | nombre de banda, duración, fecha, hora de inicio |

### 3. Identificar Métodos (Acciones)

Determina qué operaciones puede realizar cada clase. Busca los **verbos** en la descripción.

**Ejemplo:**

| Clase | Métodos principales |
|-------|---------------------|
| Lollapalooza | agregar escenario, agregar actuación, buscar actuaciones |
| Banda | getters, setters, describir información |
| Escenario | getters, comparar con otro escenario |
| Actuación | getters, obtener información completa |

### 4. Identificar Relaciones

Determina cómo se conectan las clases entre sí.

**Tipos de relaciones:**

#### a) Asociación
Una clase usa o conoce a otra.
```
Actuación ──── Escenario
(una actuación ocurre en un escenario)
```

#### b) Composición
Una clase contiene a otra y es responsable de su ciclo de vida.
```
Lollapalooza ◆──── Escenario
(el festival contiene escenarios)
```

#### c) Agregación
Una clase contiene referencias a otra, pero no controla su ciclo de vida.
```
Lollapalooza ◇──── Banda
(el festival conoce las bandas, pero no las "posee")
```

## Diagrama de Clases UML - Ejemplo Lollapalooza

```
┌─────────────────────────────┐
│      LOLLAPALOOZA           │
├─────────────────────────────┤
│ - pais: String              │
│ - edicion: String           │
│ - sede: String              │
│ - cantidadDias: int         │
│ - escenarios: ArrayList     │
│ - actuaciones: ArrayList    │
├─────────────────────────────┤
│ + agregarEscenario()        │
│ + agregarActuacion()        │
│ + buscarActuaciones...()    │
│ + cargarDatosEjemplo()      │
└──────────┬──────────────────┘
           │ gestiona (1:N)
           │
    ┌──────┴────────┬─────────────┐
    │               │             │
    ▼               ▼             ▼
┌─────────┐   ┌──────────┐   ┌──────────┐
│  BANDA  │   │ACTUACION │   │ESCENARIO │
└─────────┘   └──────────┘   └──────────┘
     │            │               ▲
     │ realiza    │ ocurre en     │
     └────────────┴───────────────┘
```

## Ejemplo Completo: Sistema Biblioteca

Vamos a modelar un sistema de biblioteca desde cero.

### Paso 1: Análisis del dominio

**Descripción:**
> "Una biblioteca tiene libros y socios. Los socios pueden tomar prestados libros. Cada préstamo tiene una fecha de préstamo y una fecha de devolución. La biblioteca debe controlar qué libros están disponibles y cuáles están prestados."

### Paso 2: Identificar clases

- **Biblioteca** (gestor principal)
- **Libro** (entidad)
- **Socio** (entidad)
- **Prestamo** (entidad que relaciona Socio y Libro)

### Paso 3: Diseñar las clases

#### Clase Libro (POJO)
```java
public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private int anioPublicacion;
    private boolean disponible;
    
    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }
    
    // Getters y setters
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { 
        this.disponible = disponible; 
    }
    
    @Override
    public String toString() {
        String estado = disponible ? "Disponible" : "Prestado";
        return titulo + " - " + autor + " [" + estado + "]";
    }
}
```

#### Clase Socio (POJO)
```java
public class Socio {
    private String numeroSocio;
    private String nombre;
    private String email;
    private String telefono;
    
    public Socio(String numeroSocio, String nombre, String email) {
        this.numeroSocio = numeroSocio;
        this.nombre = nombre;
        this.email = email;
    }
    
    // Getters
    public String getNumeroSocio() { return numeroSocio; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    
    @Override
    public String toString() {
        return nombre + " (Socio #" + numeroSocio + ")";
    }
}
```

#### Clase Prestamo (POJO con relaciones)
```java
public class Prestamo {
    private Socio socio;
    private Libro libro;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private boolean devuelto;
    
    public Prestamo(Socio socio, Libro libro, String fechaPrestamo) {
        this.socio = socio;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.devuelto = false;
    }
    
    // Getters
    public Socio getSocio() { return socio; }
    public Libro getLibro() { return libro; }
    public String getFechaPrestamo() { return fechaPrestamo; }
    public boolean isDevuelto() { return devuelto; }
    
    public void registrarDevolucion(String fecha) {
        this.fechaDevolucion = fecha;
        this.devuelto = true;
        this.libro.setDisponible(true);
    }
    
    @Override
    public String toString() {
        return socio.getNombre() + " - " + libro.getTitulo() + 
               " [" + fechaPrestamo + "]";
    }
}
```

#### Clase Biblioteca (Gestor)
```java
import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> libros;
    private ArrayList<Socio> socios;
    private ArrayList<Prestamo> prestamos;
    
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.socios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }
    
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("✓ Libro agregado: " + libro.getTitulo());
    }
    
    public void registrarSocio(Socio socio) {
        socios.add(socio);
        System.out.println("✓ Socio registrado: " + socio.getNombre());
    }
    
    public boolean realizarPrestamo(String numeroSocio, String isbn, String fecha) {
        Socio socio = buscarSocio(numeroSocio);
        Libro libro = buscarLibro(isbn);
        
        if (socio == null) {
            System.out.println("✗ Socio no encontrado");
            return false;
        }
        
        if (libro == null) {
            System.out.println("✗ Libro no encontrado");
            return false;
        }
        
        if (!libro.isDisponible()) {
            System.out.println("✗ Libro no disponible");
            return false;
        }
        
        Prestamo prestamo = new Prestamo(socio, libro, fecha);
        prestamos.add(prestamo);
        libro.setDisponible(false);
        System.out.println("✓ Préstamo registrado correctamente");
        return true;
    }
    
    private Socio buscarSocio(String numeroSocio) {
        for (Socio s : socios) {
            if (s.getNumeroSocio().equals(numeroSocio)) {
                return s;
            }
        }
        return null;
    }
    
    private Libro buscarLibro(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }
    
    public ArrayList<Libro> getLibrosDisponibles() {
        ArrayList<Libro> disponibles = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                disponibles.add(libro);
            }
        }
        return disponibles;
    }
}
```

## Principios del Buen Modelado

### 1. Responsabilidad Única (Single Responsibility)
Cada clase debe tener una sola razón para cambiar.
- ✅ `Libro` solo almacena información del libro
- ✅ `Biblioteca` gestiona las operaciones

### 2. Cohesión Alta
Los atributos y métodos de una clase deben estar fuertemente relacionados.
- ✅ `Prestamo` agrupa fecha, socio y libro relacionados al préstamo

### 3. Acoplamiento Bajo
Las clases deben depender lo menos posible de otras clases.
- ✅ `Libro` no conoce a `Biblioteca`
- ✅ `Socio` no conoce a `Prestamo`

### 4. Encapsulación
Ocultar los detalles internos y exponer solo lo necesario.
- ✅ Atributos `private`
- ✅ Acceso mediante getters/setters

## Herramientas para Modelar

- **Papel y lápiz**: Para bocetos rápidos
- **Pizarra**: Para sesiones de diseño en equipo
- **UML en ASCII**: Para documentación en archivos de texto
- **Draw.io**: Herramienta gratuita online
- **Lucidchart**: Herramienta profesional
- **PlantUML**: Genera diagramas desde texto
- **IDEs**: IntelliJ IDEA, Eclipse tienen plugins de UML

## Checklist de Modelado

Antes de empezar a programar, verifica:

- [ ] ¿Identifiqué todas las entidades principales?
- [ ] ¿Cada clase tiene un nombre claro y descriptivo?
- [ ] ¿Los atributos están en la clase correcta?
- [ ] ¿Las relaciones entre clases tienen sentido?
- [ ] ¿Hay una clase gestor que coordine las operaciones?
- [ ] ¿Los POJO solo almacenan datos?
- [ ] ¿La lógica de negocio está en el gestor?
- [ ] ¿Puedo explicar el diagrama a otro compañero?

## Conclusión

El modelado de clases es como hacer un plano antes de construir una casa. Te permite:
- Pensar antes de codear
- Detectar problemas de diseño temprano
- Comunicar ideas con el equipo
- Tener una guía clara para la implementación

**Recuerda:** Un buen modelo no es el más complejo, sino el que resuelve el problema de forma simple y clara.
