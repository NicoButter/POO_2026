# Diagrama de flujo — Caso MioException

```mermaid
flowchart TD
    A1[Inicio metodoA] --> S1[Sentencia 1]
    S1 --> S2[Sentencia 2]
    S2 --> T1{try}
    T1 --> S3[Sentencia 3]
    S3 --> S4[Sentencia 4]
    S4 --> S5[Sentencia 5]
    T1 -->|MioException en S3 o S4| C1[catch MioException]
    C1 --> S6[Sentencia 6]
    S6 --> S5
    S5 --> F[Fin]
```

**Orden si ocurre MioException en sentencia_3 o sentencia_4:**
1. sentencia_1
2. sentencia_2
3. sentencia_3 (lanza excepción)
4. catch MioException → sentencia_6
5. sentencia_5
