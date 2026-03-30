# Diagrama de flujo — Caso TuException

```mermaid
flowchart TD
    A1[Inicio metodoA] --> S1[Sentencia 1]
    S1 --> S2[Sentencia 2]
    S2 --> T1{try}
    T1 --> S3[Sentencia 3]
    S3 --> S4[Sentencia 4]
    S4 --> S5[Sentencia 5]
    T1 -->|TuException en S3 o S4| E1[Excepción no capturada]
    E1 --> F[Fin abrupto]
```

**Orden si ocurre TuException en sentencia_3 o sentencia_4:**
1. sentencia_1
2. sentencia_2
3. sentencia_3 (lanza excepción)
4. método termina abruptamente (no se ejecuta catch ni sentencia_5)
