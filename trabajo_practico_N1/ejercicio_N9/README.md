# README - Ejercicio N°9: Sistema de Figuras Geométricas

## 📂 Estructura del Proyecto

```
ejercicio_N9/
├── src/
│   ├── Figura.java           (clase abstracta)
│   ├── Rectangulo.java       (subclase)
│   ├── Circunferencia.java   (subclase)
│   ├── Linea.java            (subclase)
│   ├── Pizarra.java          (contenedor de figuras)
│   ├── Main.java             (programa principal con menú)
│   └── PruebaPrograma.java   (prueba automática)
├── enunciado_resolucion.md   (documentación completa)
├── teoria_conceptos_POO.md   (conceptos POO aplicados)
├── GUIA_USUARIO.md           (manual de usuario)
├── RESUMEN_FINAL.md          (resumen del proyecto)
└── README.md                 (este archivo)
```

## 🚀 Cómo Compilar y Ejecutar

### 1. Navegar a la carpeta del proyecto

```bash
cd /home/lordcommander/proyectos_2024/POO_2026/trabajo_practico_N1/ejercicio_N9
```

### 2. Compilar todos los archivos

```bash
javac src/*.java
```

### 3. Ejecutar el programa interactivo

```bash
java -cp src Main
```

### 4. O ejecutar la prueba automática

```bash
java -cp src PruebaPrograma
```

## 📝 Funcionalidades del Programa

### Menú Principal

El programa presenta un menú interactivo con las siguientes opciones:

1. **Agregar una figura** - Crea y agrega una nueva figura (Rectángulo, Circunferencia o Línea)
2. **Eliminar una figura** - Remueve una figura específica por su número
3. **Limpiar la pizarra** - Elimina todas las figuras (con confirmación)
4. **Calcular superficie total** - Suma la superficie de todas las figuras
5. **Calcular perímetro total** - Suma el perímetro de todas las figuras
6. **Cambiar color de una figura** - Modifica el color de fondo o borde
7. **Cambiar color de fondo de pizarra** - Define el color de la pizarra
8. **Dibujar figuras** - Muestra representación ASCII de las figuras
9. **Mostrar figuras** - Lista todas las figuras con sus propiedades
10. **Salir** - Termina el programa

## 📐 Figuras Soportadas

### Rectángulo
- **Atributos:** Base, Altura
- **Perímetro:** P = 2 × (base + altura)
- **Superficie:** S = base × altura
- **Dibujo:** Representación ASCII con bordes

### Circunferencia
- **Atributos:** Radio
- **Perímetro:** P = 2π × radio
- **Superficie:** S = π × radio²
- **Dibujo:** Círculo ASCII con asteriscos

### Línea
- **Atributos:** Longitud
- **Perímetro:** = Longitud
- **Superficie:** No aplica (retorna -1)
- **Dibujo:** Línea de guiones

## 🎨 Propiedades Comunes

Todas las figuras tienen:
- **Color de fondo:** Color interior
- **Color de borde:** Color del contorno

Pueden ser modificados en cualquier momento desde el menú.

## 💾 Archivos Importantes

| Archivo | Descripción |
|---------|---|
| `Figura.java` | Clase abstracta base - Define la interfaz común |
| `Rectangulo.java` | Implementación de un rectángulo |
| `Circunferencia.java` | Implementación de un círculo |
| `Linea.java` | Implementación de una línea |
| `Pizarra.java` | Contenedor que gestiona figuras |
| `Main.java` | Programa principal con menú interactivo |
| `PruebaPrograma.java` | Prueba automática no interactiva |
| `enunciado_resolucion.md` | Documentación teórica y justificación |
| `teoria_conceptos_POO.md` | Conceptos POO explicados |
| `GUIA_USUARIO.md` | Manual detallado de usuario |
| `RESUMEN_FINAL.md` | Resumen completo del proyecto |

## 🧪 Ejemplo de Sesión

```
╔════════════════════════════════════════╗
║         MENÚ PRINCIPAL - PIZARRA      ║
╠════════════════════════════════════════╣
║ 1. Agregar una figura                  ║
║ 2. Eliminar una figura                 ║
│ ...
Selecciona una opción: 1

╔═══════════════════════════════════════╗
║      AGREGAR UNA FIGURA                ║
╠═══════════════════════════════════════╣
║ 1. Rectángulo                          ║
║ 2. Circunferencia                      ║
║ 3. Línea                               ║
║ 4. Cancelar                            ║
╚═══════════════════════════════════════╝
Selecciona el tipo de figura: 1

Ingresa la base: 5
Ingresa la altura: 3
Ingresa el color de fondo: Rojo
Ingresa el color de borde: Negro
✓ Figura agregada: Rectángulo [Fondo: Rojo, Borde: Negro] 
                   [Base: 5.0, Altura: 3.0, Perímetro: 16.00, Superficie: 15.00]
```

## 🔍 Conceptos POO Demostrados

- **Herencia:** Clases específicas heredan de Figura
- **Polimorfismo:** Cada figura implementa sus propios métodos
- **Encapsulamiento:** Atributos privados/protegidos con acceso controlado
- **Abstracción:** Clase Figura define interfaces sin implementación
- **Composición:** Pizarra contiene colecciones de Figuras

## 📚 Para Más Información

Ver los archivos de documentación:
- `GUIA_USUARIO.md` - Manual completo de usuario
- `enunciado_resolucion.md` - Explicación del ejercicio y justificaciones
- `teoria_conceptos_POO.md` - Conceptos de POO aplicados
- `RESUMEN_FINAL.md` - Resumen y conclusión del proyecto

## ✅ Estado del Proyecto

- ✓ Compilación exitosa
- ✓ Todas las funciones implementadas
- ✓ Pruebas automatizadas pasadas
- ✓ Documentación completa
- ✓ Código limpio y bien estructurado

---

*Ejercicio N°9 - Completado* ✓
