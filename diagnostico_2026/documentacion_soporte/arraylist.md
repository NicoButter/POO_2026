# ArrayList en Java

> **Material Extracurricular** | Autor: Nicolás Butterfield  
> Este documento forma parte del material complementario diseñado para fortalecer y enriquecer los conceptos teóricos y prácticos impartidos en la materia de Programación Orientada a Objetos.

## ¿Qué es ArrayList?

`ArrayList` es una **estructura de datos dinámica** que forma parte del Java Collections Framework. Permite almacenar una colección de elementos de forma ordenada, con **tamaño variable** (crece automáticamente según sea necesario).

## ¿De dónde viene?

`ArrayList` fue introducido en **Java 1.2 (1998)** como parte del **Java Collections Framework**, que estandarizó las estructuras de datos en Java.

**Ubicación en el API:**
```
java.util.ArrayList
```

**Jerarquía:**
```
java.lang.Object
    ↑
java.util.AbstractCollection<E>
    ↑
java.util.AbstractList<E>
    ↑
java.util.ArrayList<E>
```

**Implementa las interfaces:**
- `List<E>` - Lista ordenada de elementos
- `Collection<E>` - Colección genérica
- `Iterable<E>` - Puede ser recorrida con bucles
- `Cloneable` - Puede ser clonada
- `Serializable` - Puede ser serializada

## ArrayList vs Array tradicional

| Característica | Array tradicional | ArrayList |
|----------------|-------------------|-----------|
| **Tamaño** | Fijo (se define al crear) | Dinámico (crece automáticamente) |
| **Sintaxis** | `String[] arr = new String[5]` | `ArrayList<String> list = new ArrayList<>()` |
| **Agregar elemento** | `arr[0] = "valor"` | `list.add("valor")` |
| **Obtener tamaño** | `arr.length` | `list.size()` |
| **Tipo de datos** | Primitivos y objetos | Solo objetos (usa wrappers para primitivos) |
| **Métodos** | Pocos (solo longitud) | Muchos (add, remove, contains, etc.) |
| **Rendimiento** | Más rápido (acceso directo) | Ligeramente más lento (overhead de métodos) |
| **Flexibilidad** | Baja | Alta |

### Ejemplo comparativo:

```java
// Array tradicional
String[] bandas = new String[3];
bandas[0] = "Foo Fighters";
bandas[1] = "The Strokes";
bandas[2] = "Arctic Monkeys";
// Si quiero agregar más, tengo que crear un array nuevo más grande

// ArrayList
ArrayList<String> bandasList = new ArrayList<>();
bandasList.add("Foo Fighters");
bandasList.add("The Strokes");
bandasList.add("Arctic Monkeys");
bandasList.add("Radiohead"); // ¡No hay problema! Se expande automáticamente
```

## ¿Cómo se usa ArrayList?

### 1. Importar la clase

```java
import java.util.ArrayList;
```

### 2. Crear un ArrayList

```java
// Forma moderna (Java 7+) - con tipos genéricos
ArrayList<String> nombres = new ArrayList<>();

// Forma explícita
ArrayList<Integer> numeros = new ArrayList<Integer>();

// Con objetos personalizados
ArrayList<Banda> bandas = new ArrayList<>();
ArrayList<Escenario> escenarios = new ArrayList<>();
```

### 3. Tipos genéricos

ArrayList usa **generics** (`<T>`) para especificar el tipo de elementos:

```java
ArrayList<String>      // Solo acepta Strings
ArrayList<Integer>     // Solo acepta Integer (no int primitivo)
ArrayList<Double>      // Solo acepta Double (no double primitivo)
ArrayList<Banda>       // Solo acepta objetos de tipo Banda
ArrayList<Object>      // Acepta cualquier objeto
```

**Nota sobre primitivos:**
```java
// ❌ NO se puede hacer esto:
ArrayList<int> numeros;

// ✅ Se debe usar la clase Wrapper:
ArrayList<Integer> numeros = new ArrayList<>();
numeros.add(5);        // Autoboxing: int → Integer automáticamente
int valor = numeros.get(0); // Unboxing: Integer → int automáticamente
```

## Métodos más usados de ArrayList

### Métodos de Agregar (Create)

#### `add(E elemento)`
Agrega un elemento al final de la lista.
```java
ArrayList<String> bandas = new ArrayList<>();
bandas.add("Foo Fighters");    // [Foo Fighters]
bandas.add("The Strokes");     // [Foo Fighters, The Strokes]
bandas.add("Arctic Monkeys");  // [Foo Fighters, The Strokes, Arctic Monkeys]
```

#### `add(int index, E elemento)`
Inserta un elemento en una posición específica.
```java
ArrayList<String> bandas = new ArrayList<>();
bandas.add("Foo Fighters");
bandas.add("Arctic Monkeys");
bandas.add(1, "The Strokes"); // Inserta en posición 1
// Resultado: [Foo Fighters, The Strokes, Arctic Monkeys]
```

#### `addAll(Collection<? extends E> c)`
Agrega todos los elementos de otra colección.
```java
ArrayList<String> bandas1 = new ArrayList<>();
bandas1.add("Foo Fighters");
bandas1.add("The Strokes");

ArrayList<String> bandas2 = new ArrayList<>();
bandas2.add("Radiohead");

bandas1.addAll(bandas2); // [Foo Fighters, The Strokes, Radiohead]
```

### Métodos de Acceso (Read)

#### `get(int index)`
Obtiene el elemento en la posición indicada (índice comienza en 0).
```java
ArrayList<String> bandas = new ArrayList<>();
bandas.add("Foo Fighters");
bandas.add("The Strokes");

String primera = bandas.get(0);  // "Foo Fighters"
String segunda = bandas.get(1);  // "The Strokes"
```

#### `size()`
Retorna la cantidad de elementos en la lista.
```java
ArrayList<String> bandas = new ArrayList<>();
bandas.add("Foo Fighters");
bandas.add("The Strokes");

int cantidad = bandas.size();  // 2
```

#### `isEmpty()`
Verifica si la lista está vacía.
```java
ArrayList<String> bandas = new ArrayList<>();
boolean vacia = bandas.isEmpty();  // true

bandas.add("Foo Fighters");
vacia = bandas.isEmpty();  // false
```

#### `contains(Object o)`
Verifica si un elemento existe en la lista.
```java
ArrayList<String> bandas = new ArrayList<>();
bandas.add("Foo Fighters");
bandas.add("The Strokes");

boolean existe = bandas.contains("Foo Fighters");  // true
boolean existe2 = bandas.contains("Radiohead");    // false
```

#### `indexOf(Object o)`
Retorna el índice de la primera ocurrencia de un elemento (-1 si no existe).
```java
ArrayList<String> bandas = new ArrayList<>();
bandas.add("Foo Fighters");
bandas.add("The Strokes");
bandas.add("Foo Fighters");

int indice = bandas.indexOf("Foo Fighters");  // 0 (primera ocurrencia)
int indice2 = bandas.indexOf("Radiohead");    // -1 (no existe)
```

### Métodos de Modificación (Update)

#### `set(int index, E elemento)`
Reemplaza el elemento en la posición especificada.
```java
ArrayList<String> bandas = new ArrayList<>();
bandas.add("Foo Fighters");
bandas.add("The Strokes");

bandas.set(1, "Arctic Monkeys"); // Reemplaza "The Strokes"
// Resultado: [Foo Fighters, Arctic Monkeys]
```

### Métodos de Eliminación (Delete)

#### `remove(int index)`
Elimina el elemento en la posición especificada.
```java
ArrayList<String> bandas = new ArrayList<>();
bandas.add("Foo Fighters");
bandas.add("The Strokes");
bandas.add("Arctic Monkeys");

bandas.remove(1);  // Elimina "The Strokes"
// Resultado: [Foo Fighters, Arctic Monkeys]
```

#### `remove(Object o)`
Elimina la primera ocurrencia del objeto especificado.
```java
ArrayList<String> bandas = new ArrayList<>();
bandas.add("Foo Fighters");
bandas.add("The Strokes");

boolean eliminado = bandas.remove("The Strokes");  // true
// Resultado: [Foo Fighters]
```

#### `clear()`
Elimina todos los elementos de la lista.
```java
ArrayList<String> bandas = new ArrayList<>();
bandas.add("Foo Fighters");
bandas.add("The Strokes");

bandas.clear();
System.out.println(bandas.size());  // 0
```

### Métodos de Iteración

#### Bucle for tradicional
```java
ArrayList<String> bandas = new ArrayList<>();
bandas.add("Foo Fighters");
bandas.add("The Strokes");
bandas.add("Arctic Monkeys");

for (int i = 0; i < bandas.size(); i++) {
    String banda = bandas.get(i);
    System.out.println(banda);
}
```

#### Bucle for-each (recomendado)
```java
for (String banda : bandas) {
    System.out.println(banda);
}
```

#### forEach con lambda (Java 8+)
```java
bandas.forEach(banda -> System.out.println(banda));
```

## Ejemplos prácticos con objetos personalizados

### Ejemplo 1: ArrayList de Escenarios

```java
import java.util.ArrayList;

public class EjemploEscenarios {
    public static void main(String[] args) {
        // Crear ArrayList de escenarios
        ArrayList<Escenario> escenarios = new ArrayList<>();
        
        // Agregar escenarios
        escenarios.add(new Escenario("Principal", "Zona Norte", 50000));
        escenarios.add(new Escenario("Alternativo", "Zona Este", 20000));
        escenarios.add(new Escenario("Electrónico", "Zona Sur", 15000));
        
        // Obtener cantidad
        System.out.println("Total de escenarios: " + escenarios.size());
        
        // Acceder a un elemento específico
        Escenario primero = escenarios.get(0);
        System.out.println("Primer escenario: " + primero.getNombre());
        
        // Recorrer todos los escenarios
        System.out.println("\n=== LISTA DE ESCENARIOS ===");
        for (Escenario e : escenarios) {
            System.out.println(e);
        }
        
        // Buscar un escenario por nombre
        String nombreBuscado = "Alternativo";
        Escenario encontrado = null;
        for (Escenario e : escenarios) {
            if (e.getNombre().equalsIgnoreCase(nombreBuscado)) {
                encontrado = e;
                break;
            }
        }
        
        if (encontrado != null) {
            System.out.println("\n✓ Escenario encontrado: " + encontrado);
        } else {
            System.out.println("\n✗ Escenario no encontrado");
        }
        
        // Eliminar un escenario
        escenarios.remove(1); // Elimina "Alternativo"
        System.out.println("\nEscenarios después de eliminar: " + escenarios.size());
    }
}
```

### Ejemplo 2: Buscar y filtrar en ArrayList

```java
import java.util.ArrayList;

public class EjemploFiltrado {
    
    /**
     * Retorna todas las actuaciones de un día específico.
     */
    public ArrayList<Actuacion> getActuacionesPorDia(
            ArrayList<Actuacion> actuaciones, String fecha) {
        
        ArrayList<Actuacion> resultado = new ArrayList<>();
        
        for (Actuacion act : actuaciones) {
            if (act.getFecha().equals(fecha)) {
                resultado.add(act);
            }
        }
        
        return resultado;
    }
    
    /**
     * Retorna escenarios con capacidad mayor a un mínimo.
     */
    public ArrayList<Escenario> getEscenariosGrandes(
            ArrayList<Escenario> escenarios, int capacidadMinima) {
        
        ArrayList<Escenario> grandes = new ArrayList<>();
        
        for (Escenario e : escenarios) {
            if (e.getCapacidad() >= capacidadMinima) {
                grandes.add(e);
            }
        }
        
        return grandes;
    }
    
    /**
     * Cuenta cuántas bandas son de un país específico.
     */
    public int contarBandasPorPais(
            ArrayList<Banda> bandas, String pais) {
        
        int contador = 0;
        
        for (Banda b : bandas) {
            if (b.getPaisOrigen().equalsIgnoreCase(pais)) {
                contador++;
            }
        }
        
        return contador;
    }
}
```

### Ejemplo 3: ArrayList en un Gestor

```java
import java.util.ArrayList;

public class Lollapalooza {
    // ArrayList como atributos de la clase
    private ArrayList<Escenario> escenarios;
    private ArrayList<Actuacion> actuaciones;
    
    public Lollapalooza() {
        // IMPORTANTE: Siempre inicializar en el constructor
        this.escenarios = new ArrayList<>();
        this.actuaciones = new ArrayList<>();
    }
    
    public void agregarEscenario(Escenario escenario) {
        // Usar método add()
        escenarios.add(escenario);
    }
    
    public void agregarActuacion(Actuacion actuacion) {
        actuaciones.add(actuacion);
    }
    
    public ArrayList<Escenario> getEscenarios() {
        // Buena práctica: retornar una copia
        return new ArrayList<>(escenarios);
    }
    
    public int getCantidadEscenarios() {
        // Usar método size()
        return escenarios.size();
    }
    
    public Escenario buscarEscenario(String nombre) {
        // Iterar con for-each
        for (Escenario e : escenarios) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e; // Encontrado
            }
        }
        return null; // No encontrado
    }
    
    public void listarEscenarios() {
        if (escenarios.isEmpty()) {
            System.out.println("No hay escenarios registrados.");
            return;
        }
        
        System.out.println("=== ESCENARIOS ===");
        for (int i = 0; i < escenarios.size(); i++) {
            System.out.println((i + 1) + ". " + escenarios.get(i));
        }
    }
}
```

## Otros métodos útiles

### `toArray()`
Convierte ArrayList a array tradicional.
```java
ArrayList<String> bandas = new ArrayList<>();
bandas.add("Foo Fighters");
bandas.add("The Strokes");

String[] array = bandas.toArray(new String[0]);
```

### `subList(int fromIndex, int toIndex)`
Retorna una porción de la lista.
```java
ArrayList<Integer> numeros = new ArrayList<>();
numeros.add(1);
numeros.add(2);
numeros.add(3);
numeros.add(4);

List<Integer> porcion = numeros.subList(1, 3); // [2, 3]
```

### `sort(Comparator<? super E> c)`
Ordena los elementos (Java 8+).
```java
ArrayList<String> bandas = new ArrayList<>();
bandas.add("The Strokes");
bandas.add("Arctic Monkeys");
bandas.add("Foo Fighters");

bandas.sort((a, b) -> a.compareTo(b)); // Orden alfabético
// Resultado: [Arctic Monkeys, Foo Fighters, The Strokes]
```

## Rendimiento (Complejidad)

| Operación | Complejidad | Explicación |
|-----------|-------------|-------------|
| `add(elemento)` | O(1) amortizado | Agregar al final es muy rápido |
| `add(index, elemento)` | O(n) | Debe desplazar elementos |
| `get(index)` | O(1) | Acceso directo por índice |
| `set(index, elemento)` | O(1) | Reemplazo directo |
| `remove(index)` | O(n) | Debe reorganizar elementos |
| `contains(elemento)` | O(n) | Debe buscar en toda la lista |
| `size()` | O(1) | Mantiene contador interno |
| `isEmpty()` | O(1) | Solo verifica el tamaño |

## Errores comunes

### 1. No inicializar el ArrayList
```java
// ❌ MAL - NullPointerException
ArrayList<String> bandas;
bandas.add("Foo Fighters"); // ERROR!

// ✅ BIEN
ArrayList<String> bandas = new ArrayList<>();
bandas.add("Foo Fighters");
```

### 2. IndexOutOfBoundsException
```java
ArrayList<String> bandas = new ArrayList<>();
bandas.add("Foo Fighters");

String x = bandas.get(5); // ERROR! Solo hay 1 elemento (índice 0)
```

### 3. Modificar mientras se itera
```java
// ❌ MAL - ConcurrentModificationException
for (String banda : bandas) {
    bandas.remove(banda); // ERROR!
}

// ✅ BIEN - usar Iterator o for tradicional al revés
for (int i = bandas.size() - 1; i >= 0; i--) {
    bandas.remove(i);
}
```

### 4. Comparar objetos sin equals()
```java
Escenario e1 = new Escenario("Principal", "Zona Norte", 50000);
Escenario e2 = new Escenario("Principal", "Zona Norte", 50000);

// contains() usa equals()
ArrayList<Escenario> lista = new ArrayList<>();
lista.add(e1);
boolean existe = lista.contains(e2); // Requiere equals() implementado
```

## Cuándo usar ArrayList

✅ **Usar ArrayList cuando:**
- Necesitas tamaño dinámico
- Haces muchas lecturas (`get()`)
- Agregas elementos al final
- Necesitas métodos de colecciones (contains, indexOf, etc.)

❌ **NO usar ArrayList cuando:**
- Conoces el tamaño exacto y no cambiará (usa array tradicional)
- Haces muchas inserciones/eliminaciones en medio (usa LinkedList)
- Necesitas datos primitivos en grandes cantidades (usa array primitivo para rendimiento)

## Conclusión

`ArrayList` es una de las estructuras de datos más usadas en Java por su flexibilidad y facilidad de uso. Es fundamental dominarla para trabajar con colecciones de objetos de forma eficiente.

**Recuerda:**
- Siempre inicializar: `new ArrayList<>()`
- Usar tipos genéricos: `ArrayList<Tipo>`
- Los índices empiezan en 0
- `size()` para saber cuántos elementos hay
- `get(i)` para acceder a elemento en posición i
- `add()` para agregar elementos
- `remove()` para eliminar elementos
