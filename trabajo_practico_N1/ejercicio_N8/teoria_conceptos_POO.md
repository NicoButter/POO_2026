# Conceptos POO - Ejercicio N°8

## 📑 Tabla de Contenidos

1. **Conceptos Nuevos en Este Ejercicio**
2. **La Relación Semántica "Es Un/a"**
3. **Jerarquías de Clases Correctas**
4. **Distinción: Herencia vs Composición**
5. **Errores Semánticos Comunes**
6. **Jerarquías mal diseñadas**

---

## ⭐ Conceptos Nuevos en Este Ejercicio

Este ejercicio enfatiza el **aspecto semántico** de la herencia:

| Aspecto | Ejercicios 1-7 | Ejercicio 8 |
|---------|---|---|
| Sintaxis de herencia | ✅ | ✅ Repaso |
| Polimorfismo técnico | ✅ | ✅ Repaso |
| **Semántica correcta** | ❌ | ✅ **NEW** |
| **Cuándo usar herencia** | ❌ | ✅ **NEW** |
| **Relación válida "es un/a"** | ❌ | ✅ **NEW** |
| Jerarquías bien diseñadas | ❌ | ✅ **NEW** |

---

## 🔍 La Relación Semántica "Es Un/a"

### Definición

La herencia en POO **debe** modelar una relación **"es un/a"** entre clases:

```
Si B hereda de A:    B ES UN/A A
                     B es más específico
                     A es más general
```

### Por Qué Importa

La relación "es un/a" es el **criterio fundamental** para decidir si una clase debe heredar de otra:

```java
// ✅ VÁLIDO: "Un perro ES un animal"
class Perro extends Animal { }

// ❌ INVÁLIDO: "Una rueda ES un automóvil"
// (Una rueda no es un automóvil, es una PARTE de un automóvil)
class Rueda extends Automovil { }  // ❌ Mal diseño

// ✅ CORRECTO: Composición
class Automovil {
    private Rueda[] ruedas;  // Un automóvil TIENE ruedas
}
```

### Preguntas de Validación

Para validar si una relación "es un/a" es correcta, haz estas preguntas:

#### Pregunta 1: ¿Toda instancia de B es una instancia de A?

```
¿Una Novela ES un Libro?                → SÍ ✅
¿Un Libro ES una Novela?                → NO ❌
¿Un Trap ES un RitmoMusical?            → SÍ ✅
¿Un RitmoMusical ES un Trap?            → NO ❌
¿Un Lácteo ES un Alimento?              → SÍ ✅
¿Un Alimento ES un Lácteo?              → NO ❌
```

#### Pregunta 2: ¿B es una especialización de A?

```
Novela = especialización de Libro        → SÍ ✅
Libro = especialización de Novela        → NO ❌
Trap = especialización de RitmoMusical   → SÍ ✅
RitmoMusical = especialización de Trap   → NO ❌
```

#### Pregunta 3: ¿A es más general que B?

```
Libro es más general que Novela          → SÍ ✅
Novela es más general que Libro          → NO ❌
RitmoMusical es más general que Trap     → SÍ ✅
Trap es más general que RitmoMusical     → NO ❌
```

---

## 🏛️ Jerarquías de Clases Correctas

### Estructura General → Específico

```
                    General
                      △
                      │
            ┌──────────┴──────────┐
            │                     │
       Específico-1          Específico-2
            │                     │
        ┌───┴───┐             ┌───┴───┐
     Muy-Esp-1 Muy-Esp-2   Muy-Esp-3 Muy-Esp-4
```

### Ejemplo Real: Vehículos

```
           ┌─────────────────┐
           │    Vehículo     │ (Muy general)
           └────────┬────────┘
                    │
        ┌───────────┼───────────┐
        │           │           │
   ┌────▼───┐  ┌────▼───┐  ┌───▼────┐
   │ Terrestre │ │ Aéreo │  │ Acuático│
   └────┬───┘  └────┬───┘  └───┬────┘
        │           │           │
   ┌────▼────┐  ┌───▼────┐  ┌──▼──────┐
   │ Automóvil│  │ Avión  │  │ Barco   │
   └────┬────┘  └────────┘  └────────┘
        │
   ┌────┴────┬──────┬───────┐
   │          │      │       │
┌──▼──┐  ┌───▼──┐ ┌─▼────┐ ┌▼────┐
│ Auto│  │ Moto │ │Camión│ │ Bus │
└─────┘  └──────┘ └──────┘ └─────┘
```

### Validación de la Jerarquía

Para cada clase hija, verifica:

```
✅ ¿"Auto" ES un "Automóvil"?          → SÍ
✅ ¿"Automóvil" ES un "Terrestre"?     → SÍ
✅ ¿"Terrestre" ES un "Vehículo"?      → SÍ

❌ ¿"Auto" ES un "Avión"?              → NO ✓ (correcto, no hereda)
❌ ¿"Vehículo" ES un "Auto"?           → NO ✓ (correcto, no hereda)
```

---

## 🔀 Distinción: Herencia vs Composición

### Herencia (Relación "Es Un/a")

**Uso:** Cuando B **es un tipo específico** de A

```java
class Novela extends Libro {
    // Una novela ES un tipo de libro
    // Hereda propiedades y comportamientos de Libro
}

// Lectura conceptual:
// "Novela es una Libro"
// "Novela es un subtipo de Libro"
```

### Composición (Relación "Tiene Un/a")

**Uso:** Cuando B **contiene** o **usa** A

```java
class Biblioteca {
    private List<Libro> libros;  // Relación "tiene un"
    
    // Una Biblioteca NO es un Libro
    // Una Biblioteca CONTIENE Libros
}

// Lectura conceptual:
// "Biblioteca tiene Libros"
// "Biblioteca usa Libro"
```

### Tabla Comparativa

| Aspecto | Herencia | Composición |
|---------|----------|---|
| **Relación** | "Es un/a" | "Tiene un/a" |
| **Acceso** | Todo heredado | Solo necesario expose |
| **Polimorfismo** | ✅ Sí | ❌ No |
| **Flexibilidad** | ❌ Rígida | ✅ Flexible |
| **Cambio de padre** | ❌ Difícil | ✅ Fácil |
| **Ejemplo válido** | `Trap extends RitmoMusical` | `Biblioteca contiene Libro` |

### Ejemplo: Confusión Común

```java
// ❌ INCORRECTO - Herencia confundida
class Biblioteca extends Libro {
    private List<Libro> libros;
    // ??? Una Biblioteca NO es un Libro
    // Las Biblotecas CONTIENEN Libros
}

// ✅ CORRECTO - Composición
class Biblioteca {
    private List<Libro> libros;
    
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }
    
    public List<Libro> buscarPorAutor(String autor) {
        // ...
    }
}

// ✅ CORRECTO - Herencia (si fuera necesario)
class Novela extends Libro {
    // Una Novela ES un Libro
    private String genero;
}
```

---

## ❌ Errores Semánticos Comunes

### Error 1: Invertir la Jerarquía

```java
// ❌ INCORRECTO
class Alimento extends Lacteo {
    // "Un alimento ES un lácteo" ← FALSO
    // Hay alimentos que NO son lácteos
}

// ✅ CORRECTO
class Lacteo extends Alimento {
    // "Un lácteo ES un alimento" ← VERDADERO
    // Todo lácteo es un alimento
}
```

### Error 2: Usar Herencia para Reutilizar Código

```java
// ❌ INCORRECTO - Herencia por comodidad
class Usuario extends BaseDatos {
    // "Un Usuario ES una BaseDatos" ← FALSO
    // El Usuario NO es una BD, pero necesitaría métodos de BD
}

// ✅ CORRECTO - Composición o interfaz
class Usuario {
    private BaseDatos db;  // Composición
    
    public void guardar() {
        db.insertar(this);
    }
}

// ✅ CORRECTO - Interfaz (comportamiento)
interface Persistible {
    void guardar();
    void cargar();
}

class Usuario implements Persistible {
    // Usuario IMPLEMENTA Persistible, no hereda
}
```

### Error 3: Confundir Propiedades Comunes

```java
// ❌ INCORRECTO - Propiedades comunes no justifican herencia
class Pajaro extends SerVivo {
    public void volar() { }
}

class Avion extends SerVivo {
    // "Un Avión ES un SerVivo" ← FALSO
    // Ambos pueden "volar", pero eso NO es una relación "es un"
}

// ✅ CORRECTO - Solo si hay verdadera relación semántica
class Animal extends SerVivo { }
class Pajaro extends Animal {
    public void volar() { }
}

class Vehiculo {
    // Los vehículos son una categoría diferente
    public void volar() { }
}

class Avion extends Vehiculo {
    public void volar() { }
}
```

---

## 🚫 Jerarquías Mal Diseñadas

### Anti-patrón 1: Jerarquía muy profunda

```java
// ❌ Innecesarios y confuso
class SerVivo { }
class Animal extends SerVivo { }
class Mamifero extends Animal { }
class Carnivoro extends Mamifero { }
class Felino extends Carnivoro { }
class GatoGrande extends Felino { }
class LeonAfrican extends GatoGrande { }
class LeonAfricanMacho extends LeonAfrican { }

// Resultado: 8 niveles de jerarquía para un león
// Demasiada complejidad innecesaria
```

**Solución:** Usar solo los niveles semánticamente válidos

```java
// ✅ Más simple y claro
class Animal { }
class Felino extends Animal { }
class Leon extends Felino { }

// Características específicas en atributos o subclases puntuales
class Leon extends Felino {
    private String genero;  // "macho", "hembra"
    private String region;  // "Africa", etc.
}
```

### Anti-patrón 2: Hermanos que heredan de hermanos

```java
// ❌ Jerarquía confusa
class Pajaro { }
class Aguila extends Pajaro { }
class Halcon extends Aguila {
    // "Un Halcón ES un Águila" ← FALSO
    // Son tipos DIFERENTES de aves de presa
}

// ✅ Correcto
class Pajaro { }
class AveDePresaGrande extends Pajaro { }
class Aguila extends AveDePresaGrande { }
class Halcon extends AveDePresaGrande { }
```

### Anti-patrón 3: Múltiples niveles de especificidad sin valor

```java
// ❌ Demasiadas variantes sin semántica clara
class Empleado { }
class EmpleadoTiempoCompleto extends Empleado { }
class EmpleadoTiempoCompletoBasico extends EmpleadoTiempoCompleto { }
class EmpleadoTiempoCompletoBasicoTurnoMañana extends EmpleadoTiempoCompletoBasico { }

// Mejor: Usar atributos
class Empleado {
    private String tipoContrato;     // "completo", "parcial"
    private String nivel;             // "basico", "senior"
    private String turno;             // "mañana", "tarde", "noche"
}
```

---

## 🎯 Principios de Diseño

### Principio 1: Liskov Substitution (LSP)

Si `B extends A`, entonces **toda instancia de B debe poder usarse donde se espera A**.

```java
// ✅ Válido - Trap puede usarse donde se espera RitmoMusical
RitmoMusical musica = new Trap();
musica.reproducir();  // El polimorfismo funciona

// ❌ Inválido - Libro NO puede usarse donde se espera Novela
Novela novela = new Libro();  // Error: incompatible types
```

### Principio 2: Una responsabilidad por nivel

Cada nivel en la jerarquía debe agregar **una única responsabilidad** o especialización:

```java
// ✅ Bueno
class SerVivo { }                    // Responsabilidad: existir, reproducirse
class Animal extends SerVivo { }     // Responsabilidad: moverse, comer
class Pajaro extends Animal { }      // Responsabilidad: volar, construir nidos
class Aguila extends Pajaro { }      // Responsabilidad: cazar en vuelo

// ❌ Malo
class SerVivo { }
class AnimalQueVuelaYTieneAlas extends SerVivo { }
// Demasiadas responsabilidades en un nivel
```

---

## 📚 Referencia a Ejercicios Anteriores

| Ejercicio | Contenido | Relación con Ej. 8 |
|-----------|---|---|
| 1-2 | Herencia básica (sintaxis) | Base técnica |
| 3 | Constructores | Mantenimiento de jerarquía |
| 4 | Casting | Relacionado: válido solo con relación "es un/a" |
| 5 | Errores en herencia | Errores técnicos |
| 6-7 | Polimorfismo | Consecuencia de herencia válida |
| **8** | **Semántica de herencia** | **Cuándo usar herencia** |

