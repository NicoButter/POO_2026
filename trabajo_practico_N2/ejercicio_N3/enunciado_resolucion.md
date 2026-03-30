# Ejercicio 3 — Excepciones, finally y propagación

## Enunciado

Dado el método metodoC de la clase C, indique:

a) ¿Qué sentencias y en qué orden se ejecutan si se produce la excepción MioException?

b) ¿Qué sentencias y en qué orden se ejecutan si no se produce la excepción MioException?

c) ¿Qué sentencias y en qué orden se ejecutan si se produce la excepción TuException?

```java
public class C {
    public C(){}
    public void metodoC() throws OtraException {
        sentencia_c1;
        try {
            sentencia_c2;
            sentencia_c3;
        } catch (MioException e) {
            sentencia_c4;
        } catch (TuException e) {
            sentencia_c5;
            throw new OtraException();
        } finally {
            sentencia_c6;
        }
    }
}
```
