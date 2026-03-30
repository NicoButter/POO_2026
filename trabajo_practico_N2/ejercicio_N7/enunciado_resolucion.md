# Ejercicio N7 - Resolución

## Enunciado
La impresora es un periférico que puede fallar (cuando se ordena la impresión de un documento) ante las siguientes condiciones:
- fuera de línea
- no conectada
- falta papel
- falta tinta

La clase Printer tiene las siguientes operaciones básicas:
- cargarTinta(double)
- cargarPapel(int)
- conectar()
- desconectar()
- on_line()
- of_line()
- print(Document) // esta operación puede fallar si falta papel o tinta o no está conectada o está fuera de línea.

La clase Document (cantidad de hojas) representa el documento a imprimir.
La clase PrinterException representa todas las posibles excepciones de la clase Printer.

## Resolución
Se implementaron las clases `Printer`, `Document` y `PrinterException` siguiendo el enunciado. El programa principal permite interactuar con la impresora mediante un menú, gestionando la carga de tinta, papel, conexión, estado en línea y la impresión de documentos. Se manejan todas las condiciones de error solicitadas mediante la excepción personalizada.

## Consideraciones
- Una carga de tinta permite imprimir 125 hojas.
- Si la cantidad de tinta o papel es insuficiente para imprimir todo el documento, se imprimen las hojas posibles y se lanza una excepción indicando cuántas hojas quedaron sin imprimir.
- Si la impresora no está conectada o en línea, o no hay tinta/papel, se lanza la excepción sin imprimir nada.
- El usuario puede cargar más de una carga de tinta.

## Ejecución
Compilar todos los archivos Java en la carpeta `src` y ejecutar la clase `Main`.

## Diagrama UML
Ver archivo `diagrama_uml.md`.
