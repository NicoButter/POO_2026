# 🎸 Sistema de Gestión Lollapalooza 2026

**Autor:** Nicolás Butterfield  
📧 nicobutter@gmail.com  
🔗 GitHub: [@nicobutter](https://github.com/nicobutter)

## 📋 Descripción General

Sistema de gestión desarrollado en Java para administrar el festival de música **Lollapalooza**. Este proyecto forma parte del **Diagnóstico de la materia Programación Orientada a Objetos (POO) 2026** de las carreras de Analista de Sistemas y Licenciatura en Sistemas de Información de la **Universidad Nacional de La Patagonia Austral - UARG**.

---

## 🎯 Objetivo del Sistema

El sistema permite a los organizadores del festival Lollapalooza:
- Registrar y gestionar múltiples escenarios
- Programar actuaciones de bandas en diferentes escenarios
- Consultar el cronograma por día, escenario o banda
- Obtener información completa sobre todas las actuaciones del festival

---

## 📝 Enunciado Original

El Lollapalooza es un festival de música que se hace en muchos países, entre ellos Argentina. La particularidad de este evento es que dura varios días y participan decenas de bandas de rock/pop. 

El programa del festival incluye por cada banda que toca:
- Nombre de la banda
- Duración de su participación
- Fecha de la participación
- Hora de inicio de la participación
- El escenario donde actúa

**Funcionalidades requeridas:**
- Los asistentes al festival pueden consultar en línea el programa
- Buscar los datos de actuación de una banda
- Ver las bandas que tocan un determinado día
- Ver las bandas que tocan en un determinado escenario

---

## 🏗️ Modelado del Sistema

### Diagrama de Clases

```
                                ┌────────────────────────────┐
                                │     LOLLAPALOOZA           │
                                │     (Gestor Principal)     │
                                ├────────────────────────────┤
                                │  - pais: String            │
                                │  - edicion: String         │
                                │  - sede: String            │
                                │  - cantidadDias: int       │
                                │  - escenarios: ArrayList   │
                                │  - actuaciones: ArrayList  │
                                ├────────────────────────────┤
                                │  + agregarEscenario()      │
                                │  + agregarActuacion()      │
                                │  + buscar...()             │
                                │  + cargarDatosEjemplo()    │
                                └────────────┬───────────────┘
                                             │
                                             │ gestiona
                                             │
                    ┌────────────────────────┼────────────────────────┐
                    │                        │                        │
                    │                        │                        │
                    ▼                        ▼                        ▼
          ┌──────────────────┐     ┌─────────────────┐     ┌─────────────────┐
          │      BANDA       │     │   ACTUACION     │     │   ESCENARIO     │
          ├──────────────────┤     ├─────────────────┤     ├─────────────────┤
          │ - nombre         │     │ - nombreBanda   │     │ - nombre        │
          │ - integrantes    │     │ - duracion      │     │ - ubicacion     │
          │ - estilo         │     │ - fecha         │     │ - capacidad     │
          │ - paisOrigen     │     │ - horaInicio    │     ├─────────────────┤
          │ - anioFormacion  │     │ - escenario     │     │ + getNombre()   │
          ├──────────────────┤     ├─────────────────┤     │ + equals()      │
          │ + getters()      │     │ + getters()     │     │ + hashCode()    │
          │ + setters()      │     │ + toString()    │     └─────────────────┘
          │ + toString()     │     └────────┬────────┘              ▲
          └─────────┬────────┘              ▲                       │
                    │                       │                       │
                    │      realiza          │        ocurre en      │
                    │                       │                       │
                    └───────────────────────┘───────────────────────┘


        ┌─────────────────────────────────────────────────────────────────┐
        │                   RELACIONES DEL MODELO                         │
        ├─────────────────────────────────────────────────────────────────┤
        │                                                                 │
        │  • Lollapalooza gestiona → Banda                                │
        │  • Lollapalooza gestiona → Actuacion                            │
        │  • Lollapalooza gestiona → Escenario                            │
        │  • Banda realiza → Actuacion                                    │
        │  • Actuacion ocurre en → Escenario                              │
        │                                                                 │
        └─────────────────────────────────────────────────────────────────┘
```

### 📦 Descripción de las Clases

#### 1. **Lollapalooza** (Clase Gestor)
**Responsabilidad:** Gestionar todo el festival, sus escenarios y actuaciones.

**Atributos:**
- `pais`: País donde se realiza el festival
- `edicion`: Año o edición del festival
- `sede`: Sede o recinto donde se realiza el evento
- `cantidadDias`: Número de días que dura el festival
- `escenarios`: Lista de escenarios disponibles
- `actuaciones`: Lista de todas las actuaciones programadas

**Métodos principales:**
- `agregarEscenario(Escenario)`: Registra un nuevo escenario
- `agregarActuacion(Actuacion)`: Programa una nueva actuación
- `getActuacionesPorDia(String fecha)`: Retorna actuaciones de una fecha específica
- `getActuacionesPorEscenario(Escenario)`: Retorna actuaciones de un escenario
- `buscarActuacionPorNombreBanda(String)`: Busca actuaciones por nombre de banda
- `cargarDatosEjemplo()`: Carga datos de prueba para demostración

#### 2. **Escenario** (Clase POJO)
**Responsabilidad:** Representar un escenario del festival.

**Atributos:**
- `nombre`: Nombre identificador del escenario (ej: "Escenario Principal")
- `ubicacion`: Ubicación dentro del festival (ej: "Zona Norte")
- `capacidad`: Cantidad máxima de espectadores

**Métodos destacados:**
- `equals()`: Compara escenarios por nombre (case-insensitive)
- `toString()`: Representación textual del escenario

#### 3. **Actuacion** (Clase POJO)
**Responsabilidad:** Representar una actuación de una banda en el festival.

**Atributos:**
- `nombreBanda`: Nombre de la banda que actúa
- `duracionMinutos`: Duración en minutos de la presentación
- `fecha`: Fecha de la actuación (formato: "YYYY-MM-DD")
- `horaInicio`: Hora de inicio (formato: "HH:MM")
- `escenario`: Referencia al escenario donde se presenta

**Métodos:**
- Getters para todos los atributos
- `toString()`: Representación completa de la actuación

#### 4. **Banda** (Clase POJO adicional)
**Responsabilidad:** Representar información detallada de una banda musical.

**Atributos:**
- `nombre`: Nombre de la banda
- `integrantes`: Lista de miembros
- `estiloMusical`: Género musical (Rock, Pop, Indie, etc.)
- `paisOrigen`: País de origen
- `anioFormacion`: Año de formación

**Métodos:**
- Getters y setters completos
- Múltiples constructores
- `toString()`: Representación completa

#### 5. **Main** (Clase de Interfaz)
**Responsabilidad:** Proveer interfaz de usuario mediante menú interactivo.

**Funcionalidades del menú:**
1. Agregar escenario
2. Agregar actuación
3. Buscar actuaciones por día
4. Buscar actuaciones por escenario
5. Buscar actuaciones por banda
6. Ver todas las actuaciones
7. Ver escenarios del festival
8. Salir

---

## 📁 Estructura del Proyecto

```
diagnostico_2026/
│
├── README.md                          ← Este archivo
│
├── enunciado/
│   ├── enunciado.md                   ← Enunciado en formato Markdown
│   └── enunciado.txt                  ← Enunciado en texto plano
│
├── documentacion_soporte/
│   ├── clase-pojo.md                  ← Documentación: Clase POJO
│   ├── modelado-clases.md             ← Documentación: Modelado de Clases
│   ├── gestor.md                      ← Documentación: Patrón Gestor
│   └── arraylist.md                   ← Documentación: ArrayList en Java
│
└── implementacion/
    ├── Main.java                      ← Interfaz de usuario (menú)
    ├── Lollapalooza.java              ← Clase gestor del festival
    ├── Escenario.java                 ← POJO: Escenario
    ├── Actuacion.java                 ← POJO: Actuación
    └── Banda.java                     ← POJO: Banda (adicional)
```

---

## ✨ Funcionalidades Implementadas

### 🎪 Gestión de Escenarios
- Crear escenarios con nombre, ubicación y capacidad
- Visualizar todos los escenarios registrados
- Validación de duplicados

### 🎵 Gestión de Actuaciones
- Programar actuaciones con:
  - Banda
  - Duración
  - Fecha y hora
  - Escenario asignado
- Validación de escenarios existentes

### 🔍 Consultas Avanzadas
- **Por día**: Ver todas las actuaciones de una fecha específica
- **Por escenario**: Ver la programación completa de un escenario
- **Por banda**: Buscar todas las actuaciones de una banda (búsqueda parcial)
- **Listado completo**: Ver todas las actuaciones del festival

### 🎁 Datos de Ejemplo
El sistema incluye un método `cargarDatosEjemplo()` que precarga:
- **4 escenarios**: Principal, Alternativo, Electrónico, Acústico
- **10 actuaciones** en 3 días (28-30 de marzo de 2026)
- Bandas incluidas: Foo Fighters, Metallica, Arctic Monkeys, Billie Eilish, Daft Punk, The Strokes, Tame Impala, Ed Sheeran, Calvin Harris, Bon Iver

---

## 🚀 Compilación y Ejecución

### Requisitos
- Java JDK 8 o superior
- Sistema operativo: Linux, Windows o macOS

### Compilar el proyecto

```bash
cd diagnostico_2026/implementacion
javac *.java
```

### Ejecutar el sistema

```bash
java diagnostico_2026.implementacion.Main
```

### Compilar y ejecutar en un solo paso

```bash
cd diagnostico_2026/implementacion
javac *.java && java diagnostico_2026.implementacion.Main
```

---

## 💡 Guía de Uso

### Inicio del Sistema

1. **Crear el festival**:
   ```
   Ingrese el país del festival: Argentina
   Ingrese la edición (ej: 2026): 2026
   Ingrese la sede/recinto del festival: Hipódromo de San Isidro
   Ingrese la cantidad de días: 3
   ```

2. **Cargar datos de ejemplo** (opcional):
   ```
   ¿Desea cargar datos de ejemplo para probar el sistema? (S/N): S
   ```
   - Responde **S** para cargar 4 escenarios y 10 actuaciones
   - Responde **N** para comenzar con el sistema vacío

### Ejemplos de Operaciones

#### ➕ Agregar un Escenario
```
Opción: 1
Ingrese el nombre del escenario: Escenario VIP
Ingrese la ubicación: Zona Premium
Ingrese la capacidad: 3000
```

#### 🎤 Agregar una Actuación
```
Opción: 2
Ingrese el nombre de la banda: The Beatles
Ingrese la duración en minutos: 90
Ingrese la fecha: 2026-03-28
Ingrese la hora de inicio: 21:00
Seleccione el escenario: 1 (Principal)
```

#### 📅 Buscar por Día
```
Opción: 3
Ingrese la fecha a buscar: 2026-03-28
```
**Resultado:**
```
=== Actuaciones del 2026-03-28 ===
  • Foo Fighters - 21:00 (90 min) - Escenario: Principal
  • Arctic Monkeys - 19:00 (75 min) - Escenario: Alternativo
  • Daft Punk - 22:30 (120 min) - Escenario: Electrónico
  • Ed Sheeran - 18:00 (60 min) - Escenario: Acústico
```

#### 🏟️ Buscar por Escenario
```
Opción: 4
Seleccione el escenario: 1 (Escenario Principal)
```

#### 🎸 Buscar por Banda
```
Opción: 5
Ingrese el nombre de la banda: Metallica
```

---

## 🎨 Características del Diseño

### Principios Aplicados

✅ **Encapsulamiento**: Atributos privados con getters públicos  
✅ **Responsabilidad Única**: Cada clase tiene una responsabilidad clara  
✅ **Composición**: Actuacion contiene una referencia a Escenario  
✅ **Colecciones**: Uso de ArrayList para gestionar listas dinámicas  
✅ **Validaciones**: Verificación de datos nulos y duplicados  
✅ **Robustez**: Manejo de excepciones con try-catch  
✅ **Usabilidad**: Interfaz de menú clara e intuitiva  

### Decisiones de Diseño

1. **Lollapalooza como Gestor Central**: Centraliza toda la lógica de negocio
2. **ArrayList para colecciones**: Flexibilidad para agregar elementos dinámicamente
3. **Búsqueda case-insensitive**: Mayor tolerancia en búsquedas de usuarios
4. **Separación de responsabilidades**: Main solo maneja UI, lógica en Lollapalooza
5. **Datos de ejemplo**: Facilita testing y demostración

---

## 📊 Datos de Ejemplo Precargados

### Escenarios
| Nombre | Ubicación | Capacidad |
|--------|-----------|-----------|
| Escenario Principal | Zona Norte | 50,000 |
| Escenario Alternativo | Zona Este | 20,000 |
| Escenario Electrónico | Zona Sur | 15,000 |
| Escenario Acústico | Zona Oeste | 5,000 |

### Actuaciones Programadas

**Día 1: 28 de marzo de 2026**
- 18:00 - Ed Sheeran (60 min) - Acústico
- 19:00 - Arctic Monkeys (75 min) - Alternativo
- 21:00 - Foo Fighters (90 min) - Principal
- 22:30 - Daft Punk (120 min) - Electrónico

**Día 2: 29 de marzo de 2026**
- 19:30 - The Strokes (80 min) - Alternativo
- 20:30 - Billie Eilish (85 min) - Principal
- 23:00 - Calvin Harris (90 min) - Electrónico

**Día 3: 30 de marzo de 2026**
- 17:30 - Bon Iver (70 min) - Acústico
- 19:00 - Tame Impala (75 min) - Alternativo
- 21:30 - Metallica (120 min) - Principal

---

## 🔧 Posibles Mejoras Futuras

- [ ] Persistencia de datos (archivos o base de datos)
- [ ] Validación de solapamiento de horarios en el mismo escenario
- [ ] Interfaz gráfica (Swing/JavaFX)
- [ ] Gestión completa de bandas como entidades
- [ ] Exportación de cronograma a PDF
- [ ] Sistema de tickets y control de aforo
- [ ] API REST para consultas remotas

---

## 👨‍💻 Autor

**Nicolás Butterfield**  
📧 nicobutter@gmail.com

Proyecto desarrollado como parte del **Diagnóstico de POO 2026**

---

## 🎓 Información Académica

**Materia:** Programación Orientada a Objetos (POO) 2026  
**Carreras:** 
- Analista de Sistemas
- Licenciatura en Sistemas de Información

**Universidad:** Universidad Nacional de la Patagonia Austral

---

## 📄 Licencia

Este proyecto es material académico para fines educativos.

---

## 📞 Soporte

Para consultas sobre el proyecto, revisar:
- 📂 Enunciado completo: `enunciado_documentacion_extra/enunciado.md`
- 💻 Código fuente: `implementacion/`

---

**¡Disfrutá del Lollapalooza 2026! 🎸🎵🎤**
