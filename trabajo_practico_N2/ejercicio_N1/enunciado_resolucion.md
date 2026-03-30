# Ejercicio 1 — Excepciones y Flujo de Ejecución

## Enunciado

La clase A define un método denominado metodoA, indique:

a) ¿Qué sentencias y en qué orden se ejecutan si se produce la excepción MioException?

b) ¿Qué sentencias y en qué orden se ejecutan si no se produce la excepción MioException?

c) ¿Qué sentencias y en qué orden se ejecutan si se produce la excepción TuException?

```java
public class A {
    public A(){}
    public void metodoA() {
        sentencia_1;
        sentencia_2;
        try {
            sentencia_3;
            sentencia_4;
        } catch(MioException e) {
            sentencia_6;
        }
        sentencia_5;
    }
}
```
