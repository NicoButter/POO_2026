# Conceptos POO - TP2 Ejercicio N°2

## 📚 Tabla de Contenidos

1. [Resumen de conceptos previos](#resumen-de-conceptos-previos)
2. [Nuevos conceptos aplicados en este ejercicio](#nuevos-conceptos-aplicados-en-este-ejercicio)
3. [Propagación y captura de excepciones](#propagación-y-captura-de-excepciones)
4. [Ventajas y buenas prácticas](#ventajas-y-buenas-prácticas)

---

## ✅ Resumen de conceptos previos

Este ejercicio profundiza en:

| Concepto         | Ejercicios previos | TP2 Ejercicio 2 |
|------------------|-------------------|-----------------|
| Excepciones      | ✓                 | ✓               |
| Flujo de control | ✓                 | ✓               |
| Propagación      | Parcial           | ✓               |

---

## 🆕 Nuevos conceptos aplicados en este ejercicio

- **Propagación de excepciones:** Qué ocurre cuando una excepción no es capturada por el catch.
- **Captura selectiva:** Solo se captura MioException, otras excepciones se propagan.

---

## 🏛️ Propagación y captura de excepciones

- Si en sentencia_2 o sentencia_3 se lanza MioException, se ejecuta sentencia_4 y luego sentencia_5.
- Si se lanza una excepción distinta, el método termina abruptamente y sentencia_4 ni sentencia_5 se ejecutan.

---

## 💡 Ventajas y buenas prácticas

- Capturar solo las excepciones que se pueden manejar.
- Permitir que otras excepciones se propaguen para ser manejadas en otro nivel o informar errores graves.
