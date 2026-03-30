# Diagrama de flujo — listarArchivo()

Este diagrama muestra el flujo de control del método listarArchivo() de SistemaDeArchivo, incluyendo el manejo de las excepciones Error1 y Error2.

```mermaid
flowchart TD
    A[Inicio: recorrer archivos] --> B{¿Hay más archivos?}
    B -- Sí --> C[Obtener siguiente archivo]
    C --> D[Llamar a InterfazGrafica.mostrar(f)]
    D --> E{¿Excepción?}
    E -- No --> B
    E -- Error1 --> F[Mostrar mensaje de Error1]
    F --> B
    E -- Error2 --> G[Mostrar mensaje de Error2]
    G --> H[Fin: detener listado]
    B -- No --> H[Fin]
```

- Si ocurre Error1, se muestra el mensaje y se continúa con el siguiente archivo.
- Si ocurre Error2, se muestra el mensaje y se detiene el proceso de listado.
