# Diagrama UML (texto)

```plantuml
@startuml
class Persona {
  - nombre: String
  - dni: int
  - altura: double
  + Persona(nombre, dni, altura)
  + getNombre()
  + getDni()
  + getAltura()
  + toString()
}

class PersonManager {
  - personas: Vector<Persona>
  + PersonManager()
  + addPerson(p)
  + removePerson(n)
  + searchPerson(n)
  + savePersons(file)
  + retrievePersons(file)
  + printAll()
}

Persona <.. PersonManager
@enduml
```

Puedes copiar este diagrama en https://plantuml.com/es/ para visualizarlo gráficamente.
