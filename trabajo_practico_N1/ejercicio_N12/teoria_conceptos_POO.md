# Conceptos POO - Ejercicio N°12

## 📚 Tabla de Contenidos

1. [Resumen de conceptos previos](#resumen-de-conceptos-previos)
2. [Nuevos conceptos aplicados en este ejercicio](#nuevos-conceptos-aplicados-en-este-ejercicio)
3. [Jerarquía de clases y composición](#jerarquía-de-clases-y-composición)
4. [Polimorfismo y sobreescritura de métodos](#polimorfismo-y-sobreescritura-de-métodos)
5. [Ventajas y buenas prácticas](#ventajas-y-buenas-prácticas)

---

## ✅ Resumen de conceptos previos

Este ejercicio reutiliza y profundiza los siguientes conceptos vistos en ejercicios anteriores:

| Concepto         | Ejercicios previos | Ejercicio 12 |
|------------------|-------------------|--------------|
| Herencia         | ✓                 | ✓            |
| Encapsulamiento  | ✓                 | ✓            |
| Polimorfismo     | ✓                 | ✓            |
| Abstracción      | ✓                 | ✓            |
| Composición      | ✓                 | ✓            |

Para detalles teóricos de herencia, encapsulamiento y polimorfismo básico, ver los archivos de teoría de ejercicios anteriores.

---

## 🆕 Nuevos conceptos aplicados en este ejercicio

En el Ejercicio 12 se destacan y profundizan los siguientes conceptos:

| Concepto                        | Ejercicios previos | Ejercicio 12 |
|----------------------------------|-------------------|--------------|
| **Composición de objetos**       | Parcial           | **✓ NUEVO**  |
| **Sobreescritura avanzada**      | Parcial           | **✓ NUEVO**  |
| **Especialización múltiple**     | Parcial           | **✓ NUEVO**  |
| **Cálculo polimórfico**          | Parcial           | **✓ NUEVO**  |

- **Composición:** Un alquiler contiene referencias a objetos de tipo Amarre y Barco.
- **Sobreescritura avanzada:** Cada tipo de barco redefine el cálculo de su módulo.
- **Especialización múltiple:** Se modelan distintos tipos de barcos con atributos y comportamientos propios.
- **Cálculo polimórfico:** El costo del alquiler se calcula de forma polimórfica según el tipo de barco.

---

## 🏛️ Jerarquía de clases y composición

La estructura de clases es la siguiente:

```
Puerto
  └── Amarre[]
         └── Alquiler
                ├── Cliente (nombre, DNI)
                ├── Fecha inicio/fin
                ├── Barco (abstracto)
                        ├── Velero
                        ├── Deportivo
                        └── Yate
```

- Se utiliza **composición** para modelar la relación entre Puerto, Amarre y Alquiler.
- El uso de **herencia** permite especializar los distintos tipos de barcos.
- El método `getModulo()` es polimórfico y se redefine en cada subclase.

---

## 🎭 Polimorfismo y sobreescritura de métodos

- Gracias al polimorfismo, el cálculo del costo de alquiler es uniforme para cualquier tipo de barco.
- Cada subclase de Barco redefine el método `getModulo()` según sus atributos.

**Ejemplo:**

```java
Barco barco = new Velero(...);
Alquiler alquiler = new Alquiler(..., barco);
double costo = alquiler.calcularCosto();
```

---

## 💡 Ventajas y buenas prácticas

| Concepto         | Aplicación en Ejercicio 12 |
|------------------|---------------------------|
| Herencia         | Reutilización de código y jerarquía clara |
| Encapsulamiento  | Atributos protegidos y privados |
| Abstracción      | Clases y métodos abstractos |
| Polimorfismo     | Uso de referencias generales y métodos sobrescritos |
| Composición      | Objetos contienen referencias a otros |

**Resumen:**
El Ejercicio 12 consolida el uso de herencia, composición y polimorfismo, mostrando cómo modelar sistemas extensibles y mantenibles con cálculos polimórficos y relaciones entre objetos.
