# Conceptos POO - Ejercicio N°13

## 📚 Tabla de Contenidos

1. [Resumen de conceptos previos](#resumen-de-conceptos-previos)
2. [Nuevos conceptos aplicados en este ejercicio](#nuevos-conceptos-aplicados-en-este-ejercicio)
3. [Composición y delegación](#composición-y-delegación)
4. [Polimorfismo de comportamiento](#polimorfismo-de-comportamiento)
5. [Ventajas y buenas prácticas](#ventajas-y-buenas-prácticas)

---

## ✅ Resumen de conceptos previos

Este ejercicio reutiliza y profundiza los siguientes conceptos vistos en ejercicios anteriores:

| Concepto         | Ejercicios previos | Ejercicio 13 |
|------------------|-------------------|--------------|
| Encapsulamiento  | ✓                 | ✓            |
| Delegación       | Parcial           | ✓            |
| Composición      | Parcial           | ✓            |
| Polimorfismo     | ✓                 | ✓            |

Para detalles teóricos de herencia, composición y polimorfismo básico, ver los archivos de teoría de ejercicios anteriores.

---

## 🆕 Nuevos conceptos aplicados en este ejercicio

En el Ejercicio 13 se destacan y profundizan los siguientes conceptos:

| Concepto                        | Ejercicios previos | Ejercicio 13 |
|----------------------------------|-------------------|--------------|
| **Clases envoltorio (wrapper)**  | Parcial           | **✓ NUEVO**  |
| **Polimorfismo de comportamiento** | Parcial         | **✓ NUEVO**  |
| **No modificar clase base**      | Parcial           | **✓ NUEVO**  |

- **Clases envoltorio:** Cada oferta se implementa como una clase que contiene un Usuario y redefine los métodos relevantes.
- **Polimorfismo de comportamiento:** Todas las ofertas exponen la misma interfaz de uso.
- **Restricción:** No se modifica la clase base Usuario.

---

## 🏛️ Composición y delegación

La estructura de clases es la siguiente:

```
Oferta1Residencial
Oferta2Comercial
Oferta3GranUsuario
    └── Usuario
```

- Se utiliza **composición** para modelar la relación entre la oferta y el usuario.
- Los métodos de la oferta delegan en el usuario, aplicando la lógica de la oferta.

---

## 🎭 Polimorfismo de comportamiento

- Todas las ofertas implementan los mismos métodos (`conexion`, `calculaFacturacion`, `reset`), permitiendo su uso uniforme.
- El comportamiento varía según la oferta aplicada.

---

## 💡 Ventajas y buenas prácticas

| Concepto         | Aplicación en Ejercicio 13 |
|------------------|---------------------------|
| Encapsulamiento  | Usuario mantiene sus datos privados |
| Delegación       | Lógica de ofertas separada de Usuario |
| Composición      | Ofertas contienen Usuario |
| Polimorfismo     | Uso uniforme de las ofertas |

**Resumen:**
El Ejercicio 13 muestra cómo extender funcionalidad sin modificar la clase base, usando composición, delegación y polimorfismo de comportamiento.
