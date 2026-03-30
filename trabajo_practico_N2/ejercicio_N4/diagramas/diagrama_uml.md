# Diagrama UML — Ejercicio 4

Este diagrama muestra la relación entre las clases y métodos involucrados en la propagación de la excepción desde E.metE() hasta A.main().

```mermaid
classDiagram
    class A {
        +main(String[] args)
    }
    class B {
        +metB()
    }
    class C {
        +metC()
    }
    class D {
        +metD()
    }
    class E {
        +metE()
    }

    A --> B : llama a
    B --> C : llama a
    C --> D : llama a
    D --> E : llama a
```

Este diagrama representa la cadena de llamadas relevante para el análisis de la propagación de excepciones en este ejercicio.