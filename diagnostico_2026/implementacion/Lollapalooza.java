package diagnostico_2026.implementacion;

import java.util.ArrayList;

public class Lollapalooza {

    private String pais;                    // "Argentina"
    private String edicion;                 // "2026"
    private String lugar;                   // "Hipódromo de San Isidro"
    private int cantidadDias;               // 3
    private ArrayList<Escenario> escenarios;   // Lista de Escenarios (ArrayList)
    private ArrayList<Actuacion> actuaciones; // Almacena las actuaciones (ArrayList)

    public Lollapalooza(String pais, String edicion, String lugar, int cantidadDias) {
        this.pais = pais;
        this.edicion = edicion;
        this.lugar = lugar;
        this.cantidadDias = cantidadDias;
        this.escenarios = new ArrayList<>();
        this.actuaciones = new ArrayList<>();
    }

    // Agrega un escenario si no existe aún
    public void agregarEscenario(Escenario escenario) {
        if (escenario == null) return;
        if (!escenarios.contains(escenario)) {
            escenarios.add(escenario);
        }
    }

    // Agrega una actuación y asegura que su escenario esté registrado
    public void agregarActuacion(Actuacion actuacion) {
        if (actuacion == null) return;
        actuaciones.add(actuacion);
        try {
            Escenario esc = actuacion.getEscenario();
            if (esc != null && !escenarios.contains(esc)) {
                escenarios.add(esc);
            }
        } catch (NoSuchMethodError | RuntimeException e) {
            // Si la clase Actuacion no tiene getEscenario() o lanza, ignoramos la adición automática.
        }
    }

    // Devuelve las actuaciones que ocurren en la fecha dada (comparación por igualdad de cadena)
    public ArrayList<Actuacion> getActuacionesPorDia(String fecha) {
        ArrayList<Actuacion> resultado = new ArrayList<>();
        if (fecha == null) return resultado;
        for (Actuacion a : actuaciones) {
            if (a == null) continue;
            try {
                if (fecha.equals(a.getFecha())) {
                    resultado.add(a);
                }
            } catch (NoSuchMethodError | RuntimeException e) {
                // Si Actuacion no tiene getFecha(), omitimos esa comparación
            }
        }
        return resultado;
    }

    // Devuelve las actuaciones que ocurren en el escenario indicado
    public ArrayList<Actuacion> getActuacionesPorEscenario(Escenario escenario) {
        ArrayList<Actuacion> resultado = new ArrayList<>();
        if (escenario == null) return resultado;
        for (Actuacion a : actuaciones) {
            if (a == null) continue;
            try {
                if (escenario.equals(a.getEscenario())) {
                    resultado.add(a);
                }
            } catch (NoSuchMethodError | RuntimeException e) {
                // Ignorar si no existe el método
            }
        }
        return resultado;
    }

    // Busca actuaciones por nombre de banda (coincidencia parcial, case-insensitive)
    public ArrayList<Actuacion> buscarActuacionPorNombreBanda(String nombre) {
        ArrayList<Actuacion> resultado = new ArrayList<>();
        if (nombre == null) return resultado;
        String clave = nombre.toLowerCase();
        for (Actuacion a : actuaciones) {
            if (a == null) continue;
            try {
                String banda = a.getNombreBanda();
                if (banda != null && banda.toLowerCase().contains(clave)) {
                    resultado.add(a);
                }
            } catch (NoSuchMethodError | RuntimeException e) {
                // Ignorar si no existe getNombreBanda()
            }
        }
        return resultado;
    }

    // Método para cargar datos de ejemplo para demostración
    public void cargarDatosEjemplo() {
        // Crear escenarios
        Escenario principal = new Escenario("Escenario Principal", "Zona Norte", 50000);
        Escenario alternativo = new Escenario("Escenario Alternativo", "Zona Este", 20000);
        Escenario electronico = new Escenario("Escenario Electrónico", "Zona Sur", 15000);
        Escenario acustico = new Escenario("Escenario Acústico", "Zona Oeste", 5000);

        agregarEscenario(principal);
        agregarEscenario(alternativo);
        agregarEscenario(electronico);
        agregarEscenario(acustico);

        // Crear actuaciones - Día 1 (2026-03-28)
        Actuacion act1 = new Actuacion("Foo Fighters", 90, "2026-03-28", "21:00", principal);
        Actuacion act2 = new Actuacion("Arctic Monkeys", 75, "2026-03-28", "19:00", alternativo);
        Actuacion act3 = new Actuacion("Daft Punk", 120, "2026-03-28", "22:30", electronico);
        Actuacion act4 = new Actuacion("Ed Sheeran", 60, "2026-03-28", "18:00", acustico);

        // Crear actuaciones - Día 2 (2026-03-29)
        Actuacion act5 = new Actuacion("Billie Eilish", 85, "2026-03-29", "20:30", principal);
        Actuacion act6 = new Actuacion("The Strokes", 80, "2026-03-29", "19:30", alternativo);
        Actuacion act7 = new Actuacion("Calvin Harris", 90, "2026-03-29", "23:00", electronico);

        // Crear actuaciones - Día 3 (2026-03-30)
        Actuacion act8 = new Actuacion("Metallica", 120, "2026-03-30", "21:30", principal);
        Actuacion act9 = new Actuacion("Tame Impala", 75, "2026-03-30", "19:00", alternativo);
        Actuacion act10 = new Actuacion("Bon Iver", 70, "2026-03-30", "17:30", acustico);

        agregarActuacion(act1);
        agregarActuacion(act2);
        agregarActuacion(act3);
        agregarActuacion(act4);
        agregarActuacion(act5);
        agregarActuacion(act6);
        agregarActuacion(act7);
        agregarActuacion(act8);
        agregarActuacion(act9);
        agregarActuacion(act10);
    }

    // Getters básicos
    public ArrayList<Escenario> getEscenarios() {
        return escenarios;
    }

    public ArrayList<Actuacion> getActuaciones() {
        return actuaciones;
    }
}