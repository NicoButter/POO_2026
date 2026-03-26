# Clase POJO (Plain Old Java Object)

> **Material Extracurricular** | Autor: Nicolás Butterfield  
> Este documento forma parte del material complementario diseñado para fortalecer y enriquecer los conceptos teóricos y prácticos impartidos en la materia de Programación Orientada a Objetos.

## ¿Qué es una clase POJO?

POJO es el acrónimo de **Plain Old Java Object** (Objeto Java Simple y Corriente). Es un término que se utiliza para describir una clase Java simple que no está atada a ningún framework específico y que sigue convenciones básicas de Java.

### Características de una clase POJO:

1. **No hereda de clases especiales**: No extiende de ninguna clase específica de un framework
2. **No implementa interfaces especiales**: No implementa interfaces de frameworks (excepto `Serializable` que es opcional)
3. **No usa anotaciones especiales**: Aunque puede tenerlas, no depende de ellas para funcionar
4. **Tiene atributos privados**: Los datos se encapsulan con modificador `private`
5. **Tiene constructor**: Al menos un constructor (puede ser el por defecto)
6. **Tiene getters y setters**: Métodos públicos para acceder y modificar los atributos
7. **Puede tener métodos auxiliares**: Como `toString()`, `equals()`, `hashCode()`

## ¿Para qué se usan las clases POJO?

Las clases POJO se utilizan principalmente para:

- **Representar entidades o modelos de datos**: Por ejemplo, un Usuario, un Producto, una Banda
- **Transferir datos entre capas**: Entre la base de datos y la lógica de negocio
- **Encapsular información**: Agrupar datos relacionados en una sola estructura
- **Facilitar el mantenimiento**: Al ser simples, son fáciles de entender y modificar

## Ejemplos de clases POJO

### Ejemplo 1: POJO básico - Banda

```java
/**
 * Clase POJO que representa una banda musical.
 * Contiene solo datos y métodos básicos de acceso.
 */
public class Banda {
    // Atributos privados (encapsulación)
    private String nombre;
    private String estilo;
    private String paisOrigen;
    private int anioFormacion;
    
    // Constructor vacío (opcional pero recomendado)
    public Banda() {
    }
    
    // Constructor con parámetros
    public Banda(String nombre, String estilo, String paisOrigen, int anioFormacion) {
        this.nombre = nombre;
        this.estilo = estilo;
        this.paisOrigen = paisOrigen;
        this.anioFormacion = anioFormacion;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEstilo() {
        return estilo;
    }
    
    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
    
    public String getPaisOrigen() {
        return paisOrigen;
    }
    
    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
    
    public int getAnioFormacion() {
        return anioFormacion;
    }
    
    public void setAnioFormacion(int anioFormacion) {
        this.anioFormacion = anioFormacion;
    }
    
    // Método auxiliar toString()
    @Override
    public String toString() {
        return nombre + " (" + estilo + ") - " + paisOrigen + " [" + anioFormacion + "]";
    }
}
```

### Ejemplo 2: POJO con equals() y hashCode() - Escenario

```java
/**
 * Clase POJO que representa un escenario de un festival.
 * Incluye métodos equals() y hashCode() para comparaciones.
 */
public class Escenario {
    private String nombre;
    private String ubicacion;
    private int capacidad;
    
    // Constructor
    public Escenario(String nombre, String ubicacion, int capacidad) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public String getUbicacion() {
        return ubicacion;
    }
    
    public int getCapacidad() {
        return capacidad;
    }
    
    // equals() - compara por nombre (case-insensitive)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Escenario otro = (Escenario) obj;
        return nombre.equalsIgnoreCase(otro.nombre);
    }
    
    // hashCode() - debe ser consistente con equals()
    @Override
    public int hashCode() {
        return nombre.toLowerCase().hashCode();
    }
    
    @Override
    public String toString() {
        return nombre + " - " + ubicacion + " (Capacidad: " + capacidad + ")";
    }
}
```

### Ejemplo 3: POJO con relaciones - Actuacion

```java
/**
 * Clase POJO que representa una actuación en un festival.
 * Contiene una referencia a otro objeto (Escenario).
 */
public class Actuacion {
    private String nombreBanda;
    private int duracionMinutos;
    private String fecha;
    private String horaInicio;
    private Escenario escenario; // Relación con otra clase POJO
    
    // Constructor
    public Actuacion(String nombreBanda, int duracionMinutos, String fecha, 
                     String horaInicio, Escenario escenario) {
        this.nombreBanda = nombreBanda;
        this.duracionMinutos = duracionMinutos;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.escenario = escenario;
    }
    
    // Getters
    public String getNombreBanda() {
        return nombreBanda;
    }
    
    public int getDuracionMinutos() {
        return duracionMinutos;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public String getHoraInicio() {
        return horaInicio;
    }
    
    public Escenario getEscenario() {
        return escenario;
    }
    
    @Override
    public String toString() {
        return nombreBanda + " - " + fecha + " " + horaInicio + 
               " (" + duracionMinutos + " min) en " + escenario.getNombre();
    }
}
```

## ¿Qué NO es un POJO?

### Ejemplo de clase que NO es POJO:

```java
// Esta clase NO es POJO porque:
// 1. Extiende de una clase específica de framework
// 2. Depende de anotaciones para funcionar
// 3. Tiene lógica de negocio compleja

@Entity
@Table(name = "bandas")
public class BandaEntity extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    // Lógica de negocio mezclada (no debería estar aquí en un POJO puro)
    public void validarYGuardar() {
        if (this.nombre == null || this.nombre.isEmpty()) {
            throw new ValidationException("Nombre requerido");
        }
        EntityManager.persist(this);
    }
}
```

## Ventajas de usar clases POJO

✅ **Simplicidad**: Son fáciles de entender y mantener  
✅ **Reutilización**: Pueden usarse en cualquier parte del código  
✅ **Testeo**: Son fáciles de probar (no dependen de frameworks)  
✅ **Portabilidad**: Pueden moverse entre diferentes aplicaciones  
✅ **Bajo acoplamiento**: No dependen de librerías externas  

## Buenas prácticas

1. **Encapsular siempre**: Usar `private` para atributos
2. **Nombrar claramente**: Los getters/setters deben seguir convención JavaBeans
3. **Inmutabilidad opcional**: Si los datos no cambian, considerar hacer la clase inmutable (sin setters)
4. **Validación mínima**: Los POJO generalmente no validan, eso lo hace el gestor
5. **toString() útil**: Implementar toString() para facilitar debugging

## Conclusión

Las clases POJO son la base de la programación orientada a objetos en Java. Representan datos de forma simple y limpia, siguiendo el principio de **responsabilidad única**: solo se encargan de almacenar y proporcionar acceso a los datos, sin lógica de negocio compleja.

En nuestro proyecto Lollapalooza, las clases `Banda`, `Escenario` y `Actuacion` son ejemplos perfectos de POJOs que representan entidades del dominio del festival.
