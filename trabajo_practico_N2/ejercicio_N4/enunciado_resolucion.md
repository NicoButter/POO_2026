# Ejercicio 4 — printStackTrace() y propagación de excepciones

## Enunciado

En el método `metE` de la clase `E` se produce una excepción. Al atrapar la excepción se ejecuta el método `printStackTrace()`. ¿Qué salida tiene el método si:

a) la excepción es atrapada en `D.metD()`
b) la excepción es atrapada en `C.metC()`
c) la excepción es atrapada en `B.metB()`
d) la excepción es atrapada en `A.main()`

## Respuestas

Cuando se ejecuta `printStackTrace()`, se imprime la traza de llamadas de métodos desde el punto donde se lanzó la excepción hasta el punto donde fue atrapada. La traza muestra el recorrido de la excepción por la pila de llamadas.

Supongamos que la excepción se lanza en `E.metE()` y la cadena de llamadas es:

    A.main() → B.metB() → C.metC() → D.metD() → E.metE()

La traza de la excepción será similar a:

```
Exception in thread "main" NombreDeLaExcepcion: mensaje
    at E.metE(E.java:XX)
    at D.metD(D.java:YY)
    at C.metC(C.java:ZZ)
    at B.metB(B.java:WW)
    at A.main(A.java:VV)
```

Dependiendo de dónde se atrape la excepción, la traza mostrará hasta ese método:

### a) Si la excepción es atrapada en `D.metD()`

La traza será:
```
Exception in thread "main" NombreDeLaExcepcion: mensaje
    at E.metE(E.java:XX)
    at D.metD(D.java:YY)
```

### b) Si la excepción es atrapada en `C.metC()`

La traza será:
```
Exception in thread "main" NombreDeLaExcepcion: mensaje
    at E.metE(E.java:XX)
    at D.metD(D.java:YY)
    at C.metC(C.java:ZZ)
```

### c) Si la excepción es atrapada en `B.metB()`

La traza será:
```
Exception in thread "main" NombreDeLaExcepcion: mensaje
    at E.metE(E.java:XX)
    at D.metD(D.java:YY)
    at C.metC(C.java:ZZ)
    at B.metB(B.java:WW)
```

### d) Si la excepción es atrapada en `A.main()`

La traza será:
```
Exception in thread "main" NombreDeLaExcepcion: mensaje
    at E.metE(E.java:XX)
    at D.metD(D.java:YY)
    at C.metC(C.java:ZZ)
    at B.metB(B.java:WW)
    at A.main(A.java:VV)
```

Donde `XX`, `YY`, `ZZ`, `WW`, `VV` son los números de línea correspondientes en cada archivo fuente.

**Conclusión:**
- Cuanto más arriba en la cadena de llamadas se atrape la excepción, más larga será la traza mostrada por `printStackTrace()`, ya que incluye todos los métodos desde el origen hasta el punto de captura.
