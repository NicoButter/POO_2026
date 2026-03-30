# Resolución - Ejercicio 2 TP3

## a. ¿Qué tamaño tiene un registro escuela?

Cada registro tiene 4 campos de tipo `int` (N° de escuela, cantidad de alumnos, cantidad de docentes, cantidad de cursos).

- Cada `int` ocupa 4 bytes en Java.
- Total por registro: $4 \times 4 = 16$ bytes.

**Respuesta:** Un registro escuela ocupa **16 bytes**.

---

## b. ¿En qué byte debe posicionarse el puntero del archivo si se pretende obtener datos de la 10ma escuela?

- Los registros se numeran desde 0 (la primera escuela está en la posición 0).
- Para la 10ma escuela (posición 9):

$\text{byte} = 9 \times 16 = 144$

**Respuesta:** El puntero debe posicionarse en el **byte 144**.

---

## c. ¿Qué tamaño tiene el archivo?

- Hay 101 registros.
- Tamaño total: $101 \times 16 = 1616$ bytes.

**Respuesta:** El archivo ocupa **1616 bytes**.

---

## d. Si el puntero está posicionado en el byte 39 ¿A qué datos se pueden acceder?

- División entera: $39 \div 16 = 2$ (resto 7)
- El puntero está dentro del **tercer registro** (índice 2), pero no alineado al inicio de un campo.
- Si se intenta leer un campo, se obtendrán datos corruptos (no alineados).

**Respuesta:** Se accede a datos del **tercer registro**, pero no a un campo válido (posición incorrecta).

---

## e. Si quisiera acceder al último registro ¿A qué byte debería posicionar el puntero?

- Último registro: posición 100 (ya que se empieza en 0)
- Byte: $100 \times 16 = 1600$

**Respuesta:** El puntero debe posicionarse en el **byte 1600** para acceder al último registro.

---

## Resumen
Este ejercicio refuerza el manejo de archivos de acceso aleatorio, el cálculo de offsets y la importancia de la alineación de registros en archivos binarios.
