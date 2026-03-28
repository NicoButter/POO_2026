# Ejercicio 10 - Empresa de Multimedios Audiovisuales

## a) Clases necesarias

Se propone la siguiente jerarquía de clases:

- `Programa` (clase abstracta)
  - Atributos comunes: `titulo`, `director`, `codigo`, `duracionMinutos`, `horaInicio`, `emisora`.
  - Método abstracto: `espacioComercial()` que retorna una descripción del espacio disponible para comerciales.

- `Radio` (extiende `Programa`)
  - Atributos: `responsableMusicalizacion` (String), `minutosPropaganda` (int).
  - Implementa `espacioComercial()` devolviendo la cantidad de minutos de propaganda.

- `Television` (extiende `Programa`)
  - Atributos: `comercialesPorTanda` (int), `numeroTandas` (int).
  - Método `totalComerciales()` que devuelve `comercialesPorTanda * numeroTandas`.
  - Implementa `espacioComercial()` devolviendo la cantidad de comerciales totales y su desglose.

### Justificación
- `Programa` se modela como clase abstracta porque tiene estado compartido y no debería instanciarse directamente.
- `Radio` y `Television` heredan la información común y añaden las propiedades específicas para medir el espacio publicitario.

## b) Diagrama de clases (ASCII)

```
                   Programa (abstract)
   ┌───────────────┬───────────────┬────────────────┐
   │ - titulo      │ - director    │ - codigo       │
   │ - duracionMin │ - horaInicio  │ - emisora      │
   │ + espacioComercial() (abstract)           │
   └───────────────┴───────────────┴────────────────┘
                 /                     \
                /                       \
               /                         \
          Radio                         Television
   ┌─────────────────┐           ┌────────────────────────┐
   │ - responsableMus│           │ - comercialesPorTanda  │
   │ - minutosPropag │           │ - numeroTandas         │
   │ + espacioComercial()         │ + totalComerciales()   │
   └─────────────────┘           └────────────────────────┘
```

## c) Clase Test

Se incluye una clase `TestEjercicio10` que instancia programas de radio y televisión y muestra el espacio disponible para los comerciales de cada uno. Además, imprime el detalle completo de cada programa.

Ejemplo de salida:

```
=== Espacio disponible para comerciales por programa ===
LA PARADA (Radio) - 23 minutos de comerciales
Mañanas en Vivo (Radio) - 15 minutos de comerciales
Bailando Por Un Sueño (Television) - 21 comerciales (7 por tanda × 3 tandas)
Noticiero Central (Television) - 8 comerciales (4 por tanda × 2 tandas)

=== Detalle completo de programas ===
Radio[codigo=1001, titulo='LA PARADA', director='María López', duracion=60 min, inicio=08:00, emisora='Radio Uno'] (responsableMusicalizacion='DJ Pepe', minutosPropaganda=23 min)
...
```


# Archivos incluidos
- `src/Programa.java`
- `src/Radio.java`
- `src/Television.java`
- `src/TestEjercicio10.java`

# Cómo compilar y ejecutar

```bash
cd trabajo_practico_N1/ejercicio_N10
javac src/*.java
java -cp src TestEjercicio10
```
