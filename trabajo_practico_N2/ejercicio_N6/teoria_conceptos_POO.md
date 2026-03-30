# Teoría y conceptos POO — Ejercicio 6

Este ejercicio integra conceptos fundamentales de la Programación Orientada a Objetos:

- **Herencia:** Las clases `ArchivoBinario` y `ArchivoTexto` heredan de la clase base `Archivo`.
- **Encapsulamiento:** Los atributos de las clases son privados y se accede a ellos mediante métodos públicos (getters/setters).
- **Polimorfismo:** El sistema puede manejar archivos de distintos tipos a través de referencias a la clase base `Archivo`.
- **Composición:** `SistemaDeArchivo` contiene una colección de archivos.
- **Manejo de excepciones:** Se definen excepciones personalizadas (`Error1`, `Error2`) para controlar situaciones específicas durante la visualización de archivos.
- **Uso de colecciones:** Se utiliza la clase `Vector` de `java.util` para almacenar los archivos.

Este diseño permite una gestión flexible y segura de archivos, facilitando la extensión y el mantenimiento del sistema.