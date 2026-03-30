# Conceptos POO - Ejercicio N°15

## 📚 Tabla de Contenidos

1. [Resumen de conceptos previos](#resumen-de-conceptos-previos)
2. [Nuevos conceptos aplicados en este ejercicio](#nuevos-conceptos-aplicados-en-este-ejercicio)
3. [Jerarquía de clases y composición](#jerarquía-de-clases-y-composición)
4. [Polimorfismo y consultas](#polimorfismo-y-consultas)
5. [Ventajas y buenas prácticas](#ventajas-y-buenas-prácticas)

---

## ✅ Resumen de conceptos previos

Este ejercicio reutiliza y profundiza los siguientes conceptos vistos en ejercicios anteriores:

| Concepto         | Ejercicios previos | Ejercicio 15 |
|------------------|-------------------|--------------|
| Herencia         | ✓                 | ✓            |
| Encapsulamiento  | ✓                 | ✓            |
| Polimorfismo     | ✓                 | ✓            |
| Abstracción      | ✓                 | ✓            |
| Composición      | ✓                 | ✓            |

Para detalles teóricos de herencia, composición y polimorfismo básico, ver los archivos de teoría de ejercicios anteriores.

---

## 🆕 Nuevos conceptos aplicados en este ejercicio

En el Ejercicio 15 se destacan y profundizan los siguientes conceptos:

| Concepto                        | Ejercicios previos | Ejercicio 15 |
|----------------------------------|-------------------|--------------|
| **Jerarquía múltiple**           | Parcial           | **✓ NUEVO**  |
| **Consultas polimórficas**       | Parcial           | **✓ NUEVO**  |
| **Cálculo de precios avanzado**  | Parcial           | **✓ NUEVO**  |

- **Jerarquía múltiple:** Se modelan varias ramas de herencia para hoteles y extrahoteleros.
- **Consultas polimórficas:** Se consulta por tipo y localidad usando polimorfismo.
- **Cálculo de precios avanzado:** El precio de habitación depende de múltiples factores y se calcula en métodos especializados.

---

## 🏛️ Jerarquía de clases y composición

La estructura de clases es la siguiente:

```
Alojamiento (abstracto)
  ├── Hotel (abstracto)
  │     ├── Hotel3Estrellas
  │     ├── Hotel4Estrellas
  │     └── Hotel5Estrellas
  └── Extrahotelero (abstracto)
        ├── Camping
        └── Residencia
```

- Se utiliza **herencia** para modelar la jerarquía de alojamientos.
- El método `calcularPrecioHabitacion()` se redefine en cada subclase de hotel.
- Se usa **composición** para atributos complejos (ej: gerente, restaurante, gimnasio).

---

## 🎭 Polimorfismo y consultas

- Gracias al polimorfismo, se pueden recorrer listas de alojamientos y filtrar por tipo/localidad.
- Cada subclase implementa su propia lógica de cálculo y atributos.

---

## 💡 Ventajas y buenas prácticas

| Concepto         | Aplicación en Ejercicio 15 |
|------------------|---------------------------|
| Herencia         | Jerarquía clara y extensible |
| Encapsulamiento  | Atributos protegidos y privados |
| Abstracción      | Métodos abstractos y generales |
| Polimorfismo     | Consultas y cálculos uniformes |
| Composición      | Objetos complejos como atributos |

**Resumen:**
El Ejercicio 15 consolida el uso de herencia, composición y polimorfismo, mostrando cómo modelar sistemas extensibles y consultas avanzadas sobre jerarquías de objetos.
