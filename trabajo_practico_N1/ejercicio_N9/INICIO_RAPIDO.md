# 🚀 INICIO RÁPIDO - Ejercicio N°9

## ¿Qué hay aquí?

Este ejercicio implementa un **Sistema de Figuras Geométricas** en Java usando **Programación Orientada a Objetos** (POO).

---

## ⚡ 60 segundos para empezar

### Paso 1: Abre una terminal
```bash
cd /home/lordcommander/proyectos_2024/POO_2026/trabajo_practico_N1/ejercicio_N9
```

### Paso 2: Compila
```bash
javac src/*.java
```

### Paso 3: Ejecuta
```bash
java -cp src Main
```

### Paso 4: ¡Usa el menú!

---

## 📚 ¿Qué leer primero?

### 🔰 Si eres principiante:
1. Lee: [README.md](README.md) (2 min)
2. Ve: [GUIA_USUARIO.md](GUIA_USUARIO.md) (5 min)
3. Prueba: `java -cp src PruebaPrograma` (1 min)

### 👨‍💻 Si eres desarrollador:
1. Lee: [enunciado_resolucion.md](enunciado_resolucion.md) (5 min)
2. Revisa: `src/Figura.java` (código)
3. Lee: [teoria_conceptos_POO.md](teoria_conceptos_POO.md) (10 min)

### 📊 Si necesitas resumen:
Lee: [RESUMEN_FINAL.md](RESUMEN_FINAL.md) (5 min)

---

## 📂 Estructura de Archivos

```
ejercicio_N9/
│
├── 📄 README.md                  ← EMPEZAR AQUÍ (técnico)
├── 📄 GUIA_USUARIO.md            ← Manual completo
├── 📄 enunciado_resolucion.md    ← Explicación del ejercicio
├── 📄 teoria_conceptos_POO.md    ← Teoría y conceptos
├── 📄 RESUMEN_FINAL.md           ← Resumen del proyecto
├── 🚀 INICIO_RAPIDO.md           ← Este archivo
│
└── src/                          ← Código Java
    ├── Figura.java               ← Clase abstracta
    ├── Rectangulo.java           ← Subclase
    ├── Circunferencia.java       ← Subclase
    ├── Linea.java                ← Subclase
    ├── Pizarra.java              ← Gestor de figuras
    ├── Main.java                 ← Programa principal ⭐
    └── PruebaPrograma.java       ← Prueba automática
```

---

## 🎯 ¿Qué quiero hacer?

### Quiero probar el programa sin escribir nada
```bash
java -cp src PruebaPrograma
```
✓ Ejecuta un test automático

### Quiero usar el programa interactivamente
```bash
java -cp src Main
```
✓ Abre un menú para crear y manipular figuras

### Quiero entender el diseño
Lee: [enunciado_resolucion.md](enunciado_resolucion.md)
```
📌 Explica por qué se usó clase abstracta
📌 Compara alternativas (interface, clase simple)
📌 Justifica cada decisión de diseño
```

### Quiero aprender POO
Lee: [teoria_conceptos_POO.md](teoria_conceptos_POO.md)
```
📌 Herencia explicada paso a paso
📌 Polimorfismo con ejemplos reales
📌 Encapsulamiento y niveles de acceso
📌 Anti-patrones a evitar
```

### Quiero saber cómo usar todas las funciones
Lee: [GUIA_USUARIO.md](GUIA_USUARIO.md)
```
📌 Descripción de cada opción del menú
📌 Ejemplos de cómo usar cada función
📌 Consejos y trucos
📌 Preguntas frecuentes
```

### Quiero un resumen de todo
Lee: [RESUMEN_FINAL.md](RESUMEN_FINAL.md)
```
📌 Qué se implementó
📌 Cómo funciona
📌 Archivos creados
📌 Estados completados
```

---

## 🎓 Lo que aprenderás

✓ Cómo usar **herencia** correctamente  
✓ Por qué elegir **clase abstracta** vs interface  
✓ Cómo implementar **polimorfismo**  
✓ Cómo encapsular datos (**privado/protegido**)  
✓ Cómo usar **composición** de objetos  
✓ Cómo diseñar jerarquías de clases  

---

## ❓ Preguntas Frecuentes

**P: ¿Necesito compilar primero?**  
R: Sí, ejecuta `javac src/*.java` una vez antes de usar `java`.

**P: ¿Qué versión de Java necesito?**  
R: Java 8+ (compilable en cualquier versión moderna)

**P: ¿Puedo modificar el código?**  
R: ¡Claro! Experimenta, aprende, mejora.

**P: ¿Se guardan los cambios?**  
R: No. Los datos solo existen durante la sesión.

**P: ¿Puedo agregar más figuras?**  
R: Fácilmente. El diseño permite extender con nuevas subclases.

---

## 🏆 Checklist de Aprendizaje

Después de explorar:

- [ ] Entiendo por qué se usa clase abstracta
- [ ] Puedo enumerar las 3 subclases de Figura
- [ ] Comprendo qué métodos son abstractos vs concretos
- [ ] Sé cómo la Pizarra usa composición
- [ ] Entiendo qué es polimorfismo con un ejemplo real
- [ ] Puedo explicar la relación "es un/a" en herencia
- [ ] He ejecutado el programa interactivamente
- [ ] He visto cómo calcula perímetro y superficie
- [ ] Leí la documentación completa

---

## 🔗 Mapeo de Documentos

```
┌─ ¿Primero?  ──→ README.md 
│                        ↓
│              ¿Quiero usar? ──→ GUIA_USUARIO.md
│                        ↓
│              ¿Quiero entender? ──→ enunciado_resolucion.md
│                        ↓
│                  teoria_conceptos_POO.md
│
└─ ¿Resumen? ──→ RESUMEN_FINAL.md
```

---

## 💡 Recomendación Final

1. **Primero:** Ejecuta `java -cp src PruebaPrograma` (1 min)
2. **Segundo:** Juega con `java -cp src Main` (5 min)
3. **Tercero:** Lee [GUIA_USUARIO.md](GUIA_USUARIO.md) (5 min)
4. **Cuarto:** Lee [enunciado_resolucion.md](enunciado_resolucion.md) (5 min)
5. **Quinto:** Estudia [teoria_conceptos_POO.md](teoria_conceptos_POO.md) (15 min)

**Total: ~30 minutos para aprender POO con ejemplos prácticos**

---

## ✨ Lo Especial de Este Ejercicio

🎨 **Visualización ASCII** - Las figuras se dibujan  
📊 **Cálculos correctos** - Usa fórmulas matemáticas  
💾 **Gestión de colecciones** - Pizarra maneja múltiples figuras  
🎮 **Menú interactivo** - Interfaz user-friendly  
📚 **Documentación completa** - 5 archivos .md de ayuda  
✅ **Pruebas incluidas** - Código verificado  

---

## 🎊 ¡Listo para empezar!

```bash
# Tres comandos y listo:
cd /home/lordcommander/proyectos_2024/POO_2026/trabajo_practico_N1/ejercicio_N9
javac src/*.java
java -cp src Main

# O prueba automática:
java -cp src PruebaPrograma
```

---

**¿Preguntas?** Lee los archivos .md incluidos.  
**¿Listo?** ¡Empieza a jugar con figuras! 🎨

