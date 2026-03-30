# Ejercicio 13 — Ofertas para Usuarios de Servicio Telemático

## Enunciado

En un sistema Java que gestiona los usuarios de un servicio telemático se utiliza una clase Usuario:

```java
class Usuario {
    private String nombre, dni;
    private int cuenta;
    Usuario (String d, String n) { nombre = n; dni = d; cuenta = 0; }
    void conexion (int s) { cuenta = cuenta + s; }
    double calculaFacturación() { return cuenta * 0.32; }
    void reset() { cuenta = 0; }
}
```

El departamento de marketing ha diseñado un conjunto de ofertas no acumulables para los diferentes tipos de usuario con las siguientes condiciones:

- **Oferta1 (usuarios residenciales):** No se contabilizan los tres primeros minutos de cada conexión del cliente.
- **Oferta2 (usuarios comerciales):** Se aplica un tanto por ciento de descuento sobre el importe facturable total. Este tanto por ciento se negocia por separado con cada cliente, pero una vez fijado no es modificable.
- **Oferta3 (grandes usuarios):** No se contabiliza la conexión más larga de cada periodo de facturación.

Elaborar las clases necesarias para resolver las nuevas necesidades del sistema considerando que no podemos modificar la clase USUARIO.
