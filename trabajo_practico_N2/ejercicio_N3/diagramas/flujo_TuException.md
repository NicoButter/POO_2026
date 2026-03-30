
# Diagrama de flujo — TuException (Pregunta c)

```mermaid
flowchart TD
    A1[Inicio metodoC] --> S1[Sentencia c1]
    S1 --> T1{try}
    T1 --> S2[Sentencia c2]
    S2 --> S3[Sentencia c3]
    S3 -->|TuException| C2[catch TuException]
    C2 --> S5[Sentencia c5]
    S5 --> TH[throw OtraException]
    TH --> F1[finally]
    F1 --> S6[Sentencia c6]
    S6 --> F[Fin (propaga OtraException)]
```

**Orden:**
1. sentencia_c1
2. sentencia_c2
3. sentencia_c3 (lanza TuException)
4. catch TuException → sentencia_c5
5. throw OtraException
6. finally → sentencia_c6
