# Conceptos POO - TP2 Ejercicio N°3

## 📚 Tabla de Contenidos

1. [Resumen de conceptos previos](#resumen-de-conceptos-previos)
2. [Nuevos conceptos aplicados en este ejercicio](#nuevos-conceptos-aplicados-en-este-ejercicio)
3. [Bloque finally y propagación](#bloque-finally-y-propagación)
4. [Ventajas y buenas prácticas](#ventajas-y-buenas-prácticas)

---

## ✅ Resumen de conceptos previos

Este ejercicio profundiza en:

| Concepto         | Ejercicios previos | TP2 Ejercicio 3 |
|------------------|-------------------|-----------------|
| Excepciones      | ✓                 | ✓               |
| Flujo de control | ✓                 | ✓               |
| finally         | Parcial           | ✓               |
| Propagación      | ✓                 | ✓               |

---

## 🆕 Nuevos conceptos aplicados en este ejercicio

- **Bloque finally:** Siempre se ejecuta, ocurra o no una excepción.
- **Propagación de excepciones:** Uso de throw dentro de catch.
- **Múltiples catch:** Manejo diferenciado según el tipo de excepción.

---

## 🏛️ Bloque finally y propagación

- Si ocurre MioException en sentencia_c2 o sentencia_c3: se ejecuta catch(MioException), luego finally.
- Si ocurre TuException: se ejecuta catch(TuException), luego finally, luego se propaga OtraException.
- Si no ocurre ninguna excepción: se ejecutan todas las sentencias y finally.

---

## 💡 Ventajas y buenas prácticas

- El bloque finally es útil para liberar recursos o ejecutar código que debe correr siempre.
- Es importante entender el orden de ejecución cuando hay múltiples catch y finally.
