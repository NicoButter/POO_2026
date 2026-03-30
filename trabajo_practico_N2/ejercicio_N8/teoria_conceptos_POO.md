# Conceptos POO aplicados - Ejercicio 8 TP2

## 1. Encapsulamiento
Cada clase (DataBase, Table, excepciones) tiene atributos privados y métodos públicos para manipularlos, ocultando detalles internos.

## 2. Abstracción
Se modela una base de datos como un objeto con operaciones relevantes (abrir, cerrar, agregar/eliminar/listar tablas), ocultando la implementación interna.

## 3. Composición
La clase DataBase contiene (compone) objetos Table, gestionados en una colección (Hashtable).

## 4. Manejo de Excepciones Personalizadas
Se crean DBException y TableException para manejar errores específicos del dominio, mejorando la robustez y claridad del código.

## 5. Responsabilidad Única
Cada clase tiene una responsabilidad clara: DataBase gestiona tablas, Table representa una tabla, las excepciones informan errores.

## 6. Menú Interactivo y Pruebas
El menú en Main permite probar el ciclo de vida de la base de datos y sus tablas, reforzando la importancia de validar precondiciones antes de operar.

## 7. Uso de Colecciones
Se utiliza Hashtable para almacenar y buscar tablas eficientemente por nombre.

---

**Resumen:**
Este ejercicio integra encapsulamiento, abstracción, manejo de excepciones, composición y colecciones, mostrando cómo modelar un sistema realista y robusto usando POO en Java.