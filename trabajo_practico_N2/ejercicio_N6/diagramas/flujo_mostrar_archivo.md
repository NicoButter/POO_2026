# Diagrama de flujo — InterfazGrafica.mostrar(Archivo f)

Este diagrama muestra el flujo de control del método mostrar() de InterfazGrafica, que puede lanzar Error1 o Error2 según el tipo de archivo o el nombre.

```mermaid
flowchart TD
    A[Inicio: mostrar archivo] --> B{¿Archivo es binario?}
    B -- Sí --> C[Lanzar Error1]
    B -- No --> D{¿Nombre contiene "error2"?}
    D -- Sí --> E[Lanzar Error2]
    D -- No --> F[Mostrar archivo por pantalla]
    F --> G[Fin]
    C --> G
    E --> G
```

- Si el archivo es binario, se lanza Error1.
- Si el nombre contiene "error2", se lanza Error2.
- Si no ocurre ninguna excepción, el archivo se muestra normalmente.
