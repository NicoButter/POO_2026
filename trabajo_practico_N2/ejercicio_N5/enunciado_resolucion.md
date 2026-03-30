# Ejercicio 5 — Ejemplos de excepciones implícitas y explícitas

## Enunciado

5. Proporcionar 3 ejemplos de fallos que ocasionen excepciones implícitas y 3 ejemplos de excepciones explícitas.

## Respuestas

### Excepciones implícitas (lanzadas automáticamente por la JVM)
1. **NullPointerException**
   - Acceder a un método o atributo de una referencia nula.
   - Ejemplo:
     ```java
     String s = null;
     s.length(); // Lanza NullPointerException
     ```
2. **ArrayIndexOutOfBoundsException**
   - Acceder a un índice fuera de los límites de un array.
   - Ejemplo:
     ```java
     int[] arr = new int[3];
     int x = arr[5]; // Lanza ArrayIndexOutOfBoundsException
     ```
3. **ArithmeticException**
   - División por cero con enteros.
   - Ejemplo:
     ```java
     int a = 10 / 0; // Lanza ArithmeticException
     ```

### Excepciones explícitas (lanzadas intencionalmente por el programador)
1. **throw new IllegalArgumentException()**
   - Cuando un argumento recibido no cumple una condición esperada.
   - Ejemplo:
     ```java
     void setEdad(int edad) {
         if (edad < 0) throw new IllegalArgumentException("Edad negativa");
     }
     ```
2. **throw new IOException()**
   - Al detectar un error de entrada/salida en una operación personalizada.
   - Ejemplo:
     ```java
     if (!archivo.exists()) throw new IOException("Archivo no encontrado");
     ```
3. **throw new CustomException()**
   - Lanzar una excepción definida por el usuario para un caso de negocio.
   - Ejemplo:
     ```java
     if (saldo < monto) throw new SaldoInsuficienteException();
     ```
