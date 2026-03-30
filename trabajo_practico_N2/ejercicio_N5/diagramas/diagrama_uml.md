# Diagrama UML — Ejercicio 5

Este diagrama muestra ejemplos de clases y métodos donde pueden ocurrir excepciones implícitas y explícitas.

```mermaid
classDiagram
    class EjemploImplicito {
        +void nullPointer()
        +void arrayIndex()
        +void divisionPorCero()
    }
    class EjemploExplicito {
        +void argumentoInvalido(int edad)
        +void errorIO(File archivo)
        +void saldoInsuficiente(double saldo, double monto)
    }
    class SaldoInsuficienteException
    EjemploExplicito --> SaldoInsuficienteException : lanza
```

- Los métodos de `EjemploImplicito` pueden lanzar excepciones implícitas.
- Los métodos de `EjemploExplicito` pueden lanzar excepciones explícitas, incluyendo una excepción personalizada.
