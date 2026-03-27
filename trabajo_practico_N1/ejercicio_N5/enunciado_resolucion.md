# Ejercicio N°5: Errores en Jerarquía de Herencia - Análisis de Código Defectuoso

## 📋 Enunciado General

Explique claramente cuál es el error en la siguiente jerarquía de herencia implementada en Java:

```java
public class Uno
{
    public int f()
    { return k();}
    
    public class Dos extends Uno
    {
        public int f()
        { return super.f() + h();}
        
        public class Tres extends Dos
        {
            public int f()
            { return 80;}
            
            public int k()
            { return 50;}
        }
        
        public int h()
        { return 20;}
    }
    
    public int k()
    { return super.f() + 10;}
}
```

---

## ❌ Errores Identificados

### Error Principal: Clases Anidadas (Inner Classes) en lugar de Herencia

**El error más grave es que `Dos` y `Tres` están declaradas como CLASES ANIDADAS dentro de `Uno` y `Dos`, respectivamente, en lugar de ser clases independientes con herencia.**

#### ¿Qué significa esto?

```java
public class Uno {
    public class Dos extends Uno {  // ❌ Dos es inner class de Uno
        // Dos está DENTRO de Uno, no es una clase separada
    }
}
```

**Esto es fundamentalmente diferente a:**

```java
public class Uno {
    // Código de Uno
}

public class Dos extends Uno {  // ✅ Dos es una clase independiente que hereda de Uno
    // Código de Dos
}
```

---

### Problema 1: Clases Anidadas (Inner Classes)

**¿Qué es una inner class?**

Una inner class (clase interna) es una clase definida **dentro de otra clase**. Tiene características especiales:

```java
public class Externa {
    public class Interna {  // Esta es una inner class
        // Tiene acceso a miembros de Externa
    }
}
```

**Consecuencias de definir clases anidadas:**

1. **Acceso implícito a la clase exterior:**
   ```java
   public class Uno {
       private int x = 100;
       
       public class Dos extends Uno {  // Dos puede acceder a x
           void metodo() {
               System.out.println(x);  // ✅ Puede acceder a x de Uno
           }
       }
   }
   ```

2. **Instanciación más compleja:**
   ```java
   Uno uno = new Uno();
   Uno.Dos dos = uno.new Dos();  // Requiere instancia de Uno
   ```

3. **Confusión en la jerarquía:**
   - `Dos` está dentro de `Uno` Y hereda de `Uno`
   - `Tres` está dentro de `Dos` Y hereda de `Dos`
   - Esto crea una jerarquía confusa

---

### Problema 2: Redefinición Circular y Conflictiva

Dentro de la estructura defectuosa, hay conflictos serios:

```java
public class Uno {
    public int f() { return k(); }  // f() llama a k()
    
    public class Dos extends Uno {
        public int f() { return super.f() + h(); }  // Dos sobrescribe f()
        // ...
    }
    
    public int k() { return super.f() + 10; }  // ❌ PROBLEMA: Uno hereda implícitamente de Object
}
```

**¿Cuál es el problema?**

`super.f() + 10` en `Uno.k()`:
- `super` se refiere a la clase padre de `Uno`, que es `Object`
- `Object` **no tiene un método `f()`**
- Esto causaría un **error de compilación**

---

### Problema 3: Ubicación Física del Código

Las llaves y la estructura son confusas. El código está mal formateado:

```
Abre Uno {
    Abre Dos (en dentro de Uno) {
        Abre Tres (dentro de Dos) {
        Cierra Tres
        AQUÍ empieza h() de Dos
        }
    Cierra Dos (que también cierra Tres)
    AQUÍ empieza k() de Uno
}
Cierra Uno
```

Esto hace muy difícil entender la estructura real de las clases.

---

## ✅ Código Corregido

### Opción 1: Tres clases independientes con herencia

```java
public class Uno {
    public int f() {
        return k();
    }
    
    public int k() {
        return 10;  // Uno no puede llamar a super por que hereda de Object
    }
}

public class Dos extends Uno {
    @Override
    public int f() {
        return super.f() + h();
    }
    
    public int h() {
        return 20;
    }
}

public class Tres extends Dos {
    @Override
    public int f() {
        return 80;
    }
    
    @Override
    public int k() {
        return 50;
    }
}
```

**Ventajas:**
- ✅ Estructura clara
- ✅ Cada clase en su propio archivo
- ✅ Fácil de entender y mantener

### Opción 2: Con clases anidadas correctas (si es intencional)

Si el objetivo era usar inner classes de forma intencional:

```java
public class Uno {
    public int f() {
        return k();
    }
    
    public int k() {
        return 10;
    }
    
    public class Dos extends Uno {
        @Override
        public int f() {
            return super.f() + h();
        }
        
        public int h() {
            return 20;
        }
        
        public class Tres extends Dos {
            @Override
            public int f() {
                return 80;
            }
            
            @Override
            public int k() {
                return 50;
            }
        }
    }
}
```

**Pero esto sigue siendo problemático porque:**
- `Dos` hereda de `Uno` pero está dentro de `Uno` (confuso)
- Requiere instancias de `Uno` para instanciar `Dos`
- No es la práctica recomendada

---

## 🔍 Análisis Detallado de los Problemas

### Problema con `super.f()` en `Uno`

```java
public class Uno {  // Implícitamente: public class Uno extends Object
    public int k() { 
        return super.f() + 10;  // ❌ Object no tiene f()
    }
}
```

**Error:** `super` en `Uno` se refiere a `Object`, que no tiene método `f()`.

**Solución:** Remover el `super.f()` o cambiar la lógica:

```java
// ✅ Opción 1: Solo retornar constante
public int k() { return 10; }

// ✅ Opción 2: Llamar a f() directamente (sin super)
public int k() { return f() + 10; }  // Esto sería: f() + 10 = k() + 10 = RECURSIÓN
```

---

### Problema de Recursión Infinita

Incluso si compilara, habría un problema lógico:

```java
public int f() { return k(); }      // f llama a k
public int k() { return f() + 10; } // k llama a f
```

**Esto causa RECURSIÓN INFINITA:**

```
f() → k() → f() → k() → f() → ...
StackOverflowError
```

---

## 📊 Tabla Comparativa

| Aspecto | Código Defectuoso | Código Correcto |
|---------|-------------------|-----------------|
| Estructura | Inner classes anidadas | Clases independientes |
| Compilación | ❌ Error (super.f() en Uno) | ✅ Compila sin errores |
| Claridad | ❌ Confusa | ✅ Clara y legible |
| Instanciación | Compleja | Simple |
| Jerarquía | Circular/Confusa | Lineal (Uno → Dos → Tres) |
| `super.f()` en Uno | Ilegal | No aplicable |

---

## 🎓 Lecciones Clave

### 1. **No mezclar inner classes con herencia**
Si quieres una jerarquía de herencia, declara clases independientes.

### 2. **`super` tiene límites**
`super` siempre se refiere a la superclase directa. Si no hay una, va a `Object`, que podría no tener los métodos que esperas.

### 3. **Evitar recursión infinita**
Asegúrate de que no haya ciclos de llamadas entre métodos.

### 4. **Claridad en la estructura**
Las clases independientes son más fáciles de entender que las anidadas.

### 5. **Heredar de forma significativa**
Cada clase en la jerarquía debe tener un propósito claro y no crear confusión.

