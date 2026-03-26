# Patrón Gestor (Manager Pattern)

> **Material Extracurricular** | Autor: Nicolás Butterfield  
> Este documento forma parte del material complementario diseñado para fortalecer y enriquecer los conceptos teóricos y prácticos impartidos en la materia de Programación Orientada a Objetos.

## ¿Qué es un Gestor?

Un **Gestor** (también llamado **Manager** o **Controller**) es una clase que se encarga de **coordinar y administrar** las operaciones sobre un conjunto de objetos. Actúa como un punto central de control para todas las operaciones del sistema.

## ¿Por qué usar un Gestor?

Imagina que tienes varios objetos (bandas, escenarios, actuaciones) y necesitas:
- Agregarlos
- Buscarlos
- Modificarlos
- Eliminarlos
- Listarlos
- Validar operaciones

Sin un gestor, tendrías que repetir esta lógica en múltiples lugares. El gestor **centraliza** toda esta lógica en un solo lugar.

## Analogía del Mundo Real

Piensa en un **director de orquesta**:
- Los músicos (objetos POJO) tocan sus instrumentos
- El director (gestor) coordina cuándo tocan, a qué volumen, qué ritmo
- El director no toca ningún instrumento, solo **gestiona**

O piensa en un **gerente de tienda**:
- Los productos (POJOs) están en el inventario
- El gerente (gestor) controla el stock, registra ventas, hace pedidos
- Los clientes interactúan con el gerente, no directamente con el inventario

## Responsabilidades de un Gestor

Un gestor típicamente se encarga de:

1. **Almacenar colecciones** de objetos (ArrayList, HashMap, etc.)
2. **Operaciones CRUD** (Create, Read, Update, Delete)
3. **Búsquedas y filtros** sobre las colecciones
4. **Validaciones** antes de realizar operaciones
5. **Lógica de negocio** del dominio
6. **Coordinar relaciones** entre diferentes objetos

## Estructura de un Gestor

```java
import java.util.ArrayList;

public class [Nombre]Gestor {
    // 1. ATRIBUTOS: Colecciones de objetos a gestionar
    private ArrayList<Objeto1> coleccion1;
    private ArrayList<Objeto2> coleccion2;
    
    // 2. CONSTRUCTOR: Inicializa las colecciones
    public [Nombre]Gestor() {
        this.coleccion1 = new ArrayList<>();
        this.coleccion2 = new ArrayList<>();
    }
    
    // 3. MÉTODOS DE AGREGAR (Create)
    public void agregarObjeto1(Objeto1 obj) {
        // Validaciones
        // Agregar a la colección
        // Mensajes de confirmación
    }
    
    // 4. MÉTODOS DE BÚSQUEDA (Read)
    public Objeto1 buscarPor...(String criterio) {
        // Lógica de búsqueda
        // Retornar objeto o null
    }
    
    // 5. MÉTODOS DE MODIFICACIÓN (Update)
    public boolean modificarObjeto1(...) {
        // Buscar objeto
        // Modificar atributos
        // Retornar éxito/fracaso
    }
    
    // 6. MÉTODOS DE ELIMINACIÓN (Delete)
    public boolean eliminarObjeto1(...) {
        // Buscar objeto
        // Eliminar de colección
        // Retornar éxito/fracaso
    }
    
    // 7. MÉTODOS DE LISTADO
    public ArrayList<Objeto1> listarTodos() {
        return new ArrayList<>(coleccion1); // Retornar copia
    }
    
    // 8. MÉTODOS AUXILIARES
    private boolean existeObjeto(...) {
        // Lógica de validación
    }
}
```

## Ejemplo Completo: Gestor de Lollapalooza

### Clase Gestor Principal

```java
import java.util.ArrayList;

/**
 * Gestor principal del festival Lollapalooza.
 * Coordina todas las operaciones relacionadas con escenarios y actuaciones.
 */
public class Lollapalooza {
    // ============ ATRIBUTOS ============
    private String pais;
    private String edicion;
    private String sede;
    private int cantidadDias;
    
    // Colecciones gestionadas
    private ArrayList<Escenario> escenarios;
    private ArrayList<Actuacion> actuaciones;
    
    // ============ CONSTRUCTOR ============
    public Lollapalooza(String pais, String edicion, String sede, int cantidadDias) {
        this.pais = pais;
        this.edicion = edicion;
        this.sede = sede;
        this.cantidadDias = cantidadDias;
        this.escenarios = new ArrayList<>();
        this.actuaciones = new ArrayList<>();
    }
    
    // ============ MÉTODOS DE AGREGAR ============
    
    /**
     * Agrega un escenario al festival.
     * Valida que no exista un escenario con el mismo nombre.
     */
    public void agregarEscenario(Escenario escenario) {
        // Validación: evitar duplicados
        if (existeEscenario(escenario.getNombre())) {
            System.out.println("✗ Ya existe un escenario con ese nombre.");
            return;
        }
        
        escenarios.add(escenario);
        System.out.println("✓ Escenario agregado: " + escenario.getNombre());
    }
    
    /**
     * Agrega una actuación al festival.
     * Valida que el escenario exista y que no haya conflictos de horario.
     */
    public void agregarActuacion(Actuacion actuacion) {
        // Validación 1: El escenario debe existir
        if (!escenarios.contains(actuacion.getEscenario())) {
            System.out.println("✗ El escenario no existe en este festival.");
            return;
        }
        
        // Validación 2: No debe haber conflicto de horarios
        if (hayConflictoHorario(actuacion)) {
            System.out.println("✗ Ya hay una actuación en ese horario.");
            return;
        }
        
        actuaciones.add(actuacion);
        System.out.println("✓ Actuación agregada: " + actuacion.getNombreBanda());
    }
    
    // ============ MÉTODOS DE BÚSQUEDA ============
    
    /**
     * Busca todas las actuaciones de un día específico.
     */
    public ArrayList<Actuacion> getActuacionesPorDia(String fecha) {
        ArrayList<Actuacion> resultado = new ArrayList<>();
        
        for (Actuacion act : actuaciones) {
            if (act.getFecha().equals(fecha)) {
                resultado.add(act);
            }
        }
        
        return resultado;
    }
    
    /**
     * Busca todas las actuaciones de un escenario específico.
     */
    public ArrayList<Actuacion> getActuacionesPorEscenario(String nombreEscenario) {
        ArrayList<Actuacion> resultado = new ArrayList<>();
        
        for (Actuacion act : actuaciones) {
            if (act.getEscenario().getNombre().equalsIgnoreCase(nombreEscenario)) {
                resultado.add(act);
            }
        }
        
        return resultado;
    }
    
    /**
     * Busca una actuación por el nombre de la banda.
     */
    public Actuacion buscarActuacionPorNombreBanda(String nombreBanda) {
        for (Actuacion act : actuaciones) {
            if (act.getNombreBanda().equalsIgnoreCase(nombreBanda)) {
                return act;
            }
        }
        return null; // No encontrada
    }
    
    // ============ MÉTODOS DE LISTADO ============
    
    public ArrayList<Escenario> getEscenarios() {
        return new ArrayList<>(escenarios); // Retorna copia para evitar modificaciones externas
    }
    
    public ArrayList<Actuacion> getActuaciones() {
        return new ArrayList<>(actuaciones);
    }
    
    // ============ MÉTODOS AUXILIARES (PRIVADOS) ============
    
    /**
     * Verifica si ya existe un escenario con el nombre dado.
     */
    private boolean existeEscenario(String nombre) {
        for (Escenario e : escenarios) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Verifica si hay conflicto de horario para una actuación.
     */
    private boolean hayConflictoHorario(Actuacion nueva) {
        for (Actuacion existente : actuaciones) {
            // Mismo escenario y misma fecha
            if (existente.getEscenario().equals(nueva.getEscenario()) &&
                existente.getFecha().equals(nueva.getFecha())) {
                
                // Comparar horarios (simplificado)
                if (existente.getHoraInicio().equals(nueva.getHoraInicio())) {
                    return true; // Conflicto detectado
                }
            }
        }
        return false; // No hay conflicto
    }
    
    // ============ MÉTODOS ESPECIALES ============
    
    /**
     * Carga datos de ejemplo para demostración.
     * Este método es típico en gestores para facilitar pruebas.
     */
    public void cargarDatosEjemplo() {
        // Crear escenarios
        Escenario e1 = new Escenario("Principal", "Zona Norte", 50000);
        Escenario e2 = new Escenario("Alternativo", "Zona Este", 20000);
        
        agregarEscenario(e1);
        agregarEscenario(e2);
        
        // Crear actuaciones
        Actuacion a1 = new Actuacion("Foo Fighters", 90, "2026-03-28", "20:00", e1);
        Actuacion a2 = new Actuacion("The Strokes", 75, "2026-03-28", "22:00", e2);
        
        agregarActuacion(a1);
        agregarActuacion(a2);
        
        System.out.println("✓ Datos de ejemplo cargados exitosamente.");
    }
    
    // ============ GETTERS ============
    
    public String getPais() { return pais; }
    public String getEdicion() { return edicion; }
    public String getSede() { return sede; }
    public int getCantidadDias() { return cantidadDias; }
    
    @Override
    public String toString() {
        return pais + " - Edición " + edicion + " en " + sede;
    }
}
```

## Otro Ejemplo: Gestor de Estudiantes

```java
import java.util.ArrayList;
import java.util.HashMap;

public class GestorEstudiantes {
    private ArrayList<Estudiante> estudiantes;
    private HashMap<String, Estudiante> porLegajo; // Búsqueda rápida por legajo
    
    public GestorEstudiantes() {
        this.estudiantes = new ArrayList<>();
        this.porLegajo = new HashMap<>();
    }
    
    public boolean inscribirEstudiante(Estudiante estudiante) {
        // Validación: el legajo no debe existir
        if (porLegajo.containsKey(estudiante.getLegajo())) {
            System.out.println("✗ Ya existe un estudiante con ese legajo.");
            return false;
        }
        
        estudiantes.add(estudiante);
        porLegajo.put(estudiante.getLegajo(), estudiante);
        System.out.println("✓ Estudiante inscrito: " + estudiante.getNombre());
        return true;
    }
    
    public Estudiante buscarPorLegajo(String legajo) {
        return porLegajo.get(legajo); // Búsqueda O(1) usando HashMap
    }
    
    public ArrayList<Estudiante> buscarPorCarrera(String carrera) {
        ArrayList<Estudiante> resultado = new ArrayList<>();
        for (Estudiante e : estudiantes) {
            if (e.getCarrera().equalsIgnoreCase(carrera)) {
                resultado.add(e);
            }
        }
        return resultado;
    }
    
    public double calcularPromedioGeneral() {
        if (estudiantes.isEmpty()) return 0.0;
        
        double suma = 0;
        for (Estudiante e : estudiantes) {
            suma += e.getPromedio();
        }
        return suma / estudiantes.size();
    }
    
    public void generarReporte() {
        System.out.println("=== REPORTE DE ESTUDIANTES ===");
        System.out.println("Total: " + estudiantes.size());
        System.out.println("Promedio general: " + calcularPromedioGeneral());
        System.out.println("\nDetalle:");
        for (Estudiante e : estudiantes) {
            System.out.println("  " + e);
        }
    }
}
```

## Ventajas del Patrón Gestor

✅ **Centralización**: Toda la lógica en un solo lugar  
✅ **Reutilización**: Los métodos se pueden usar desde cualquier parte  
✅ **Mantenibilidad**: Fácil encontrar y modificar la lógica  
✅ **Testeo**: Puedes probar el gestor de forma aislada  
✅ **Validación consistente**: Las reglas se aplican siempre de la misma forma  
✅ **Ocultamiento**: Los detalles de implementación están encapsulados  

## Diferencias: Gestor vs POJO

| Aspecto | POJO | Gestor |
|---------|------|--------|
| **Propósito** | Almacenar datos | Gestionar operaciones |
| **Atributos** | Datos del dominio | Colecciones de objetos |
| **Métodos** | Getters/setters simples | Lógica de negocio compleja |
| **Dependencias** | Ninguna o mínimas | Depende de los POJOs |
| **Estado** | Estado de un objeto | Estado de muchos objetos |
| **Ejemplo** | `Banda`, `Escenario` | `Lollapalooza`, `GestorEstudiantes` |

## Interacción: Main → Gestor → POJOs

```java
public class Main {
    public static void main(String[] args) {
        // 1. Crear el gestor
        Lollapalooza festival = new Lollapalooza("Argentina", "2026", "Buenos Aires", 3);
        
        // 2. Crear objetos POJO
        Escenario escenario = new Escenario("Principal", "Zona Norte", 50000);
        
        // 3. El gestor coordina las operaciones
        festival.agregarEscenario(escenario);
        
        // 4. El gestor maneja búsquedas
        ArrayList<Escenario> escenarios = festival.getEscenarios();
        
        // 5. El gestor aplica lógica de negocio
        festival.cargarDatosEjemplo();
    }
}
```

**Flujo de datos:**
```
Main (interfaz usuario)
    ↓
Gestor (lógica de negocio)
    ↓
POJOs (datos)
```

## Buenas Prácticas

1. **Un gestor por dominio**: `GestorBiblioteca`, `GestorEstudiantes`, `Lollapalooza`
2. **Nombres descriptivos**: Usa `Gestor` o el nombre del sistema como sufijo
3. **Validar siempre**: Verifica condiciones antes de modificar colecciones
4. **Métodos privados auxiliares**: Usa métodos privados para lógica interna
5. **Retornar copias**: No expongas las colecciones internas directamente
6. **Mensajes claros**: Informa al usuario qué está pasando
7. **Un constructor**: Inicializa todas las colecciones en el constructor

## Errores Comunes

❌ **Poner lógica de negocio en POJOs**
```java
// MAL: Banda no debería conocer al festival
public class Banda {
    public void agregarAlFestival(Lollapalooza festival) {
        festival.agregarBanda(this);
    }
}
```

✅ **La lógica debe estar en el gestor**
```java
// BIEN: El gestor gestiona
Lollapalooza festival = new Lollapalooza(...);
Banda banda = new Banda(...);
festival.agregarBanda(banda); // El gestor controla
```

## Conclusión

El patrón Gestor es fundamental en POO para mantener el código organizado y mantenible. Piensa en el gestor como el **cerebro del sistema**: los objetos POJO son como células que almacenan información, pero el gestor es quien coordina y toma decisiones.

**Regla de oro:** Si tienes que hacer operaciones sobre varios objetos del mismo tipo, necesitas un gestor.
