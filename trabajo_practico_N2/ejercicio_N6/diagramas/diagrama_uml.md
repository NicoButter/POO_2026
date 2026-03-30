# Diagrama UML — Ejercicio 6

Este diagrama representa la estructura de clases para el sistema de archivos, incluyendo el manejo de errores.

```mermaid
classDiagram
    class Archivo {
        -String nombre
        -String extension
        -int tamanio
        -Date fechaUltimaModificacion
        -boolean permisoLectura
        -boolean permisoEscritura
        +getters/setters
    }
    class ArchivoBinario {
    }
    class ArchivoTexto {
    }
    class SistemaDeArchivo {
        -String idDiscoDuro
        -int capacidad
        -Vector<Archivo> archivos
        +agregarArchivo(Archivo f)
        +eliminarArchivo(String id)
        +listarArchivo()
    }
    class InterfazGrafica {
        +static mostrar(Archivo f) throws Error1, Error2
        +static mensajeError(String s)
    }
    class Error1 extends Exception {
    }
    class Error2 extends Exception {
    }

    Archivo <|-- ArchivoBinario
    Archivo <|-- ArchivoTexto
    SistemaDeArchivo o-- Archivo
    SistemaDeArchivo ..> InterfazGrafica : usa
    InterfazGrafica ..> Error1
    InterfazGrafica ..> Error2
```

- `Archivo` es la clase base para archivos de cualquier tipo.
- `ArchivoBinario` y `ArchivoTexto` heredan de `Archivo`.
- `SistemaDeArchivo` gestiona una colección de archivos y utiliza `InterfazGrafica` para mostrarlos.
- `Error1` y `Error2` son excepciones personalizadas para el manejo de errores en la interfaz gráfica.
