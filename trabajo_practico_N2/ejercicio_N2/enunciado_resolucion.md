# Ejercicio 2 — Excepciones y Propagación

## Enunciado

Considere el siguiente código:

```java
public class B {
    public void metodoB() {
        sentencia_1;
        try {
            sentencia_2;
            sentencia_3;
        } catch (MioException e) {
            sentencia_4;
        }
        sentencia_5;
    }
}
```

Responda:

a) ¿Qué ocurre si en sentencia_2 se lanza una excepción MioException?

b) ¿Qué ocurre si en sentencia_3 se lanza una excepción MioException?

c) ¿Qué ocurre si en sentencia_2 se lanza una excepción distinta de MioException?

Explique el flujo de ejecución en cada caso.
