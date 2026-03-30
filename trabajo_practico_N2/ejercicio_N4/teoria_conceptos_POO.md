# Teoría y conceptos POO — Ejercicio 4

Este ejercicio profundiza en el mecanismo de propagación de excepciones en Java y el uso del método `printStackTrace()`. Los conceptos clave son:

- **Propagación de excepciones:** Cuando una excepción no es atrapada en un método, se propaga hacia el método llamador, y así sucesivamente, hasta que es atrapada o el programa finaliza.
- **Stack trace:** Es la lista de métodos que estaban en ejecución cuando ocurrió la excepción, desde el punto de lanzamiento hasta el punto de captura.
- **Importancia del stack trace:** Permite identificar rápidamente dónde se originó el error y cómo llegó hasta el punto de captura, facilitando el debugging.
- **Buenas prácticas:** Capturar excepciones en el nivel adecuado y analizar el stack trace para corregir errores de lógica o diseño.

Este ejercicio refuerza la comprensión de cómo fluye la ejecución y el manejo de errores en programas orientados a objetos.
