# GUÍA DE USUARIO - Sistema de Figuras Geométricas

## 🎯 Introducción Rápida

Este es un programa interactivo que permite:
- ✓ Crear diferentes tipos de figuras geométricas
- ✓ Manipular sus propiedades (tamaño, color)
- ✓ Calcular automáticamente perímetros y áreas
- ✓ Gestionar una colección de figuras ("pizarra")
- ✓ Visualizar las figuras de forma gráfica

## 🚀 Inicio Rápido (4 pasos)

### Paso 1: Abre una terminal

```bash
cd /home/lordcommander/proyectos_2024/POO_2026/trabajo_practico_N1/ejercicio_N9
```

### Paso 2: Compila el código

```bash
javac src/*.java
```

### Paso 3: Ejecuta el programa interactivo

```bash
java -cp src Main
```

### Paso 4: ¡Disfruta!

```
╔════════════════════════════════════════╗
║         MENÚ PRINCIPAL - PIZARRA      ║
╠════════════════════════════════════════╣
║ 1. Agregar una figura                  ║
║ 2. Eliminar una figura                 ║
│ ... [más opciones]
```

---

## 📚 Guía Completa de Opciones del Menú

### Opción 1: Agregar una Figura

**¿Qué hace?** Crea una nueva figura y la agrega a la pizarra.

**Pasos:**
1. Selecciona el tipo (1=Rectángulo, 2=Circunferencia, 3=Línea)
2. Ingresa los parámetros solicitados:

#### Para Rectángulo:
```
Ingresa la base: 5
Ingresa la altura: 3
Ingresa el color de fondo (ej: Rojo, Azul): Rojo
Ingresa el color de borde (ej: Negro, Verde): Negro
```

#### Para Circunferencia:
```
Ingresa el radio: 4
Ingresa el color de fondo (ej: Amarillo, Naranja): Amarillo
Ingresa el color de borde (ej: Negro, Blanco): Negro
```

#### Para Línea:
```
Ingresa la longitud: 10
Ingresa el color (ej: Morado, Gris): Morado
```

**Ejemplo de salida:**
```
✓ Figura agregada: Rectángulo [Fondo: Rojo, Borde: Negro] 
           [Base: 5.0, Altura: 3.0, Perímetro: 16.00, Superficie: 15.00]
```

---

### Opción 2: Eliminar una Figura

**¿Qué hace?** Remueve una figura específica de la pizarra.

**Pasos:**
1. El programa muestra todas las figuras con números
2. Ingresa el número de la figura a eliminar
3. Confirmación

**Ejemplo:**
```
========== FIGURAS EN LA PIZARRA ==========
1. Rectángulo [Fondo: Rojo, Borde: Negro] [Base: 5.0, ...]
2. Circunferencia [Fondo: Azul, Borde: Verde] [Radio: 4.0, ...]
3. Línea [Fondo: Morado, Borde: Morado] [Longitud: 10.0, ...]
==========================================

Ingresa el número de la figura a eliminar: 2
✓ Figura eliminada: Circunferencia [...]
```

---

### Opción 3: Limpiar la Pizarra

**¿Qué hace?** Borra TODAS las figuras (con confirmación).

**Pasos:**
1. El programa pide confirmación (s/n)
2. Ingresa "s" para sí, "n" para no

**Ejemplo:**
```
¿Estás seguro? (s/n): s
✓ Pizarra limpiada
```

---

### Opción 4: Calcular Superficie Total

**¿Qué hace?** Muestra la suma de las áreas de todas las figuras que tienen superficie.

**Nota importantes:**
- Rectángulo: SÍ tiene superficie
- Circunferencia: SÍ tiene superficie
- Línea: NO tiene superficie

**Ejemplo de salida:**
```
╔════════════════════════════════════════╗
║     CÁLCULO DE SUPERFICIE TOTAL        ║
╠════════════════════════════════════════╣
║ Figuras en la pizarra: 3
║ Superficie total: 90.27 u²
╚════════════════════════════════════════╝
```

---

### Opción 5: Calcular Perímetro Total

**¿Qué hace?** Muestra la suma de los perímetros de todas las figuras.

**Nota:** Todas las figuras tienen perímetro.

**Ejemplo de salida:**
```
╔════════════════════════════════════════╗
║     CÁLCULO DE PERÍMETRO TOTAL         ║
╠════════════════════════════════════════╣
║ Figuras en la pizarra: 3
║ Perímetro total: 63.13 u
╚════════════════════════════════════════╝
```

---

### Opción 6: Cambiar Color de una Figura

**¿Qué hace?** Modifica el color de fondo o borde de una figura específica.

**Pasos:**
1. El programa lista todas las figuras
2. Selecciona el número de la figura
3. Elige si cambias color de fondo (1) o borde (2)
4. Ingresa el nuevo color

**Ejemplo:**
```
========== FIGURAS EN LA PIZARRA ==========
1. Rectángulo [Fondo: Rojo, Borde: Negro] [...]
2. Circunferencia [Fondo: Azul, Borde: Verde] [...]
==========================================

Ingresa el número de la figura: 1

1. Cambiar color de fondo
2. Cambiar color de borde
Selecciona: 1
Ingresa el nuevo color: Rosa
✓ Color de fondo cambiado a: Rosa
```

---

### Opción 7: Cambiar Color de Fondo de Pizarra

**¿Qué hace?** Define el color de fondo de la pizarra (no de las figuras).

**Ejemplo:**
```
Ingresa el nuevo color de fondo: Amarillo
✓ Color de fondo de la pizarra cambiado a: Amarillo
```

---

### Opción 8: Dibujar Figuras

**¿Qué hace?** Muestra representación visual ASCII de todas las figuras.

**Ejemplo de salida:**
```
========== PIZARRA [Fondo: Amarillo] ==========

--- Figura 1 ---
┌─────────────┐
│             │
│             │
│             │
│             │
└─────────────┘

--- Figura 2 ---
   *****   
  *** ***  
 **     ** 
 **     ** 
 *       * 
 **     ** 
 **     ** 
  *** ***  
   *****   

--- Figura 3 ---
──────────

=============================================
```

---

### Opción 9: Mostrar Figuras

**¿Qué hace?** Lista todas las figuras con sus propiedades completas.

**Ejemplo de salida:**
```
========== FIGURAS EN LA PIZARRA ==========
1. Rectángulo [Fondo: Rosa, Borde: Negro] 
   [Base: 5.0, Altura: 3.0, Perímetro: 16.00, Superficie: 15.00]
2. Circunferencia [Fondo: Azul, Borde: Rojo] 
   [Radio: 4.0, Perímetro: 25.13, Superficie: 50.27]
3. Línea [Fondo: Morado, Borde: Morado] 
   [Longitud: 10.0, Perímetro: 10.00, Superficie: N/A]
==========================================
```

---

### Opción 10: Salir

**¿Qué hace?** Termina el programa.

```
¡Hasta luego!
```

---

## 📐 Fórmulas Utilizadas

### Rectángulo
- **Perímetro:** P = 2 × (base + altura)
- **Superficie:** S = base × altura

### Circunferencia
- **Perímetro:** P = 2π × radio
- **Superficie:** S = π × radio²
- **Valor de π:** 3.14159...

### Línea
- **Perímetro:** P = longitud
- **Superficie:** No aplica (N/A)

---

## 💡 Consejos Útiles

### Consejo 1: Organiza tus colores
Usa nombres de colores comunes:
```
Rojos: Rojo, Rojo Oscuro, Rosa, Magenta
Azules: Azul, Azul Oscuro, Azul Cielo, Índigo
Verdes: Verde, Verde Oscuro, Verde Claro, Cian
Neutros: Negro, Blanco, Gris
Otros: Amarillo, Naranja, Morado, Marrón
```

### Consejo 2: Verifica los resultados
Antes de eliminar, usa "Mostrar figuras" para ver lo que tienes.

### Consejo 3: Prueba las visualizaciones
El dibujo ASCII es útil para verificar que creaste correctamente.

### Consejo 4: Haz pruebas
Agrega varias figuras y prueba todas las funcionalidades.

---

## 🔧 Prueba Automática

Si prefieres no interactuar, puedes ejecutar la prueba automática:

```bash
java -cp src PruebaPrograma
```

Esta ejecutará una serie de operaciones y mostrará los resultados sin necesidad de entrada del usuario.

---

## ❓ Preguntas Frecuentes

### ¿Puedo crear figuras con colores personalizados?
Sí, el programa acepta cualquier nombre de color como string.

### ¿Qué pasa si ingreso un número inválido?
El programa mostrará un mensaje de error: "✗ Índice inválido"

### ¿Puedo tener figuras duplicadas?
Sí, puedes agregar dos rectángulos idénticos si lo deseas.

### ¿Se guardan los datos?
No. Los datos solo existen durante la sesión. Se pierden al cerrar.

### ¿Cuántas figuras puedo agregar?
Teóricamente ilimitadas (limitado por memoria del sistema).

### ¿Qué unidades usan los números?
Unidades abstractas (u para longitud, u² para área). No metros ni centímetros.

---

## 🎓 Ejemplo Completo de Sesión

```
Selecciona una opción: 1
[Submenú: Agregar una figura]
Selecciona el tipo de figura: 1  [Rectángulo]
Ingresa la base: 10
Ingresa la altura: 5
Ingresa el color de fondo: Rojo
Ingresa el color de borde: Negro
✓ Figura agregada: Rectángulo [Fondo: Rojo, Borde: Negro] 
                   [Base: 10.0, Altura: 5.0, Perímetro: 30.00, Superficie: 50.00]

Selecciona una opción: 1
[Submenú: Agregar una figura]
Selecciona el tipo de figura: 2  [Circunferencia]
Ingresa el radio: 3
Ingresa el color de fondo: Azul
Ingresa el color de borde: Verde
✓ Figura agregada: Circunferencia [Fondo: Azul, Borde: Verde] 
                   [Radio: 3.0, Perímetro: 18.85, Superficie: 28.27]

Selecciona una opción: 9  [Mostrar figuras]
========== FIGURAS EN LA PIZARRA ==========
1. Rectángulo [Fondo: Rojo, Borde: Negro] [Base: 10.0, Altura: 5.0, ...]
2. Circunferencia [Fondo: Azul, Borde: Verde] [Radio: 3.0, ...]
==========================================

Selecciona una opción: 4  [Calcular superficie]
╔════════════════════════════════════════╗
║     CÁLCULO DE SUPERFICIE TOTAL        ║
╠════════════════════════════════════════╣
║ Figuras en la pizarra: 2
║ Superficie total: 78.27 u²
╚════════════════════════════════════════╝

Selecciona una opción: 10  [Salir]
¡Hasta luego!
```

---

## 📞 Soporte Técnico

Si encuentras problemas:

1. **Asegúrate de compilar:** `javac src/*.java`
2. **Verifica la ruta:** Estés en el directorio correcto
3. **Comprueba la entrada:** Revisa que ingreses los datos correctamente
4. **Lee los errores:** El programa indica qué salió mal

---

## 🎊 ¡Diviértete!

Este programa es una demostración práctica de Programación Orientada a Objetos.
Experimenta, crea figuras interesantes, ¡y aprende jugando!

