# Conceptos POO - TP2 Ejercicio N°1

## 📚 Tabla de Contenidos

1. [Resumen de conceptos previos](#resumen-de-conceptos-previos)
2. [Nuevos conceptos aplicados en este ejercicio](#nuevos-conceptos-aplicados-en-este-ejercicio)
3. [Manejo de excepciones y flujo](#manejo-de-excepciones-y-flujo)
4. [Ventajas y buenas prácticas](#ventajas-y-buenas-prácticas)

---

## ✅ Resumen de conceptos previos

Este ejercicio reutiliza y profundiza los siguientes conceptos vistos en ejercicios anteriores:

| Concepto         | Ejercicios previos | TP2 Ejercicio 1 |
|------------------|-------------------|-----------------|
| Excepciones      | Parcial           | ✓               |
| Flujo de control | ✓                 | ✓               |

---

## 🆕 Nuevos conceptos aplicados en este ejercicio

En este ejercicio se destacan:

- **Manejo de excepciones específicas** (`catch(MioException e)`).
- **Análisis de flujo de ejecución según el tipo de excepción**.

---

## 🏛️ Manejo de excepciones y flujo

- Si ocurre una excepción de tipo `MioException` en `sentencia_3` o `sentencia_4`, se salta al bloque `catch` y se ejecuta `sentencia_6`, luego continúa con `sentencia_5`.
- Si no ocurre ninguna excepción, se ejecutan todas las sentencias en orden.
- Si ocurre una excepción distinta (por ejemplo, `TuException`), el método termina abruptamente y no se ejecuta ni el `catch` ni `sentencia_5`.

---

## 💡 Ventajas y buenas prácticas

- El manejo de excepciones permite controlar errores de forma estructurada.
- Es importante capturar solo las excepciones que se pueden manejar correctamente.
- El análisis de flujo ayuda a entender el comportamiento del programa ante errores.
