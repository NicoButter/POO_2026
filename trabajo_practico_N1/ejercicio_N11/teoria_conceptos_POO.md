
# Conceptos POO - Ejercicio N°11

## 📚 Tabla de Contenidos

1. [Resumen de conceptos previos](#resumen-de-conceptos-previos)
2. [Nuevos conceptos aplicados en este ejercicio](#nuevos-conceptos-aplicados-en-este-ejercicio)
3. [Jerarquía de clases y abstracción](#jerarquía-de-clases-y-abstracción)
4. [Polimorfismo y uso de métodos abstractos](#polimorfismo-y-uso-de-métodos-abstractos)
5. [Ventajas y buenas prácticas](#ventajas-y-buenas-prácticas)

---

## ✅ Resumen de conceptos previos

Este ejercicio reutiliza y profundiza los siguientes conceptos vistos en ejercicios anteriores:

| Concepto         | Ejercicios previos | Ejercicio 11 |
|------------------|-------------------|--------------|
| Herencia         | ✓                 | ✓            |
| Encapsulamiento  | ✓                 | ✓            |
| Polimorfismo     | ✓                 | ✓            |
| Abstracción      | ✓                 | ✓            |

Para detalles teóricos de herencia, encapsulamiento y polimorfismo básico, ver los archivos de teoría de ejercicios anteriores.

---

## 🆕 Nuevos conceptos aplicados en este ejercicio

En el Ejercicio 11 se destacan y profundizan los siguientes conceptos:

| Concepto                        | Ejercicios previos | Ejercicio 11 |
|----------------------------------|-------------------|--------------|
| **Clase abstracta**              | Parcial           | **✓ NUEVO**  |
| **Método abstracto**             | Parcial           | **✓ NUEVO**  |
| **Jerarquía de herencia profunda** | Parcial         | **✓ NUEVO**  |
| **Especialización múltiple**     | Parcial           | **✓ NUEVO**  |

- **Clase abstracta:** `Publicacion` y `Escrita` no pueden instanciarse directamente, solo sirven como base para otras clases.
- **Método abstracto:** Se define el método abstracto `detalle()` que obliga a las subclases a implementar su propia versión.
- **Jerarquía profunda:** Hay más de dos niveles de herencia (`Publicacion` → `Escrita` → `Diario`/`Revista`).
- **Especialización múltiple:** Se modelan distintos tipos de publicaciones escritas, cada una con atributos y comportamientos propios.

---

## 🏛️ Jerarquía de clases y abstracción

La estructura de clases es la siguiente:

```
Publicacion (abstracta)
   │
   └── Escrita (abstracta)
		   │
		   ├── Diario
		   └── Revista
```

- Se utiliza **abstracción** para definir comportamientos generales y obligar a las subclases a implementar detalles específicos.
- El uso de **protected** y **private** asegura el encapsulamiento de los atributos.

---

## 🎭 Polimorfismo y uso de métodos abstractos

- Gracias al polimorfismo, es posible manipular listas de `Publicacion` y llamar a `detalle()` sin importar el tipo concreto (Diario o Revista).
- El método abstracto `detalle()` permite que cada subclase defina su propia representación detallada.

**Ejemplo:**

```java
ArrayList<Publicacion> publicaciones = new ArrayList<>();
publicaciones.add(new Diario(...));
publicaciones.add(new Revista(...));
for (Publicacion pub : publicaciones) {
	System.out.println(pub.detalle()); // Polimorfismo en acción
}
```

---

## 💡 Ventajas y buenas prácticas

| Concepto         | Aplicación en Ejercicio 11 |
|------------------|---------------------------|
| Herencia         | Reutilización de código y jerarquía clara |
| Encapsulamiento  | Atributos protegidos y privados |
| Abstracción      | Clases y métodos abstractos |
| Polimorfismo     | Uso de referencias generales y métodos sobrescritos |

**Resumen:**
El Ejercicio 11 profundiza en el uso de clases y métodos abstractos, jerarquías de herencia más complejas y polimorfismo, consolidando los pilares de la POO y mostrando cómo modelar sistemas extensibles y mantenibles.