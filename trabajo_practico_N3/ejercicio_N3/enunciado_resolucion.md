# Resolución - Ejercicio 3 TP3

## a. Definir el registro para almacenar una Persona (Nombre, DNI, Altura)

- El registro Persona tiene:
  - Nombre: String (máx 40 caracteres, almacenado como 40 bytes)
  - DNI: int (4 bytes)
  - Altura: double (8 bytes)
- Tamaño total del registro: 40 + 4 + 8 = **52 bytes**

## b. Genere el archivo de acceso aleatorio con el nombre: “datos.dat” y almacene los datos de los objetos Persona

- Se utiliza la clase `ArchivoPersonas` para crear y escribir los objetos Persona en el archivo binario "datos.dat".
- Cada persona se escribe usando el método `escribir` de la clase `Persona`.

## c. Recupere los datos almacenados en “datos.dat” y muéstrelos por pantalla

- Se utiliza el método `recuperarPersonas` de la clase `ArchivoPersonas` para leer todos los registros y mostrarlos por pantalla.

---

## Ejemplo de uso

```java
ArchivoPersonas archPers = new ArchivoPersonas("datos.dat");
List<Persona> personas = Arrays.asList(
    new Persona("Dra. Casas Sandra", 12345678, 1.65),
    new Persona("Lic. Herrera Franco", 23456789, 1.80)
);
archPers.almacenarPersonas(personas);
List<Persona> recuperadas = archPers.recuperarPersonas();
for (Persona p : recuperadas) {
    System.out.println(p);
}
```

---

Este ejercicio refuerza el manejo de archivos binarios, el diseño de registros fijos y la modularidad en POO.