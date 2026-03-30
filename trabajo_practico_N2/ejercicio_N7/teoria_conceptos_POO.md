# Teoría y conceptos POO aplicados

- **Encapsulamiento:** Cada clase gestiona su propio estado y operaciones. Los atributos son privados y se accede a ellos mediante métodos públicos.
- **Abstracción:** Se modela la impresora y el documento como entidades con atributos y comportamientos relevantes.
- **Excepciones personalizadas:** Se utiliza una excepción específica (`PrinterException`) para manejar errores propios del dominio de la impresora.
- **Relación de uso:** La clase `Printer` utiliza a `Document` para realizar la impresión.
- **Modularidad:** El código está organizado en clases separadas para facilitar el mantenimiento y la comprensión.
