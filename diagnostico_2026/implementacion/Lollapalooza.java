package diagnostico_2026.implementacion;

import java.util.ArrayList;

/**
 * Clase gestor principal del festival Lollapalooza.
 * 
 * Esta es la clase más importante del sistema. Actúa como "gestor" o "controlador" 
 * del festival. Almacena y gestiona toda la información del evento:
 * - Los escenarios disponibles
 * - Todas las actuaciones programadas
 * - Los datos generales del festival
 * 
 * La clase Lollapalooza contiene toda la lógica de negocio: permite añadir escenarios
 * y actuaciones, y ejecutar búsquedas complejas (por día, por escenario, por banda).
 * 
 * Nota: Esta clase implementa el patrón de diseño SINGLETON (aunque en versión simplificada).
 * En un sistema real, solo habría una instancia del festival ejecutándose.
 * 
 * @author Nicolás Butterfield
 * @version 1.0
 * @see Escenario
 * @see Actuacion
 */
public class Lollapalooza {

    /** País donde se realiza el festival (ej: "Argentina") */
    private String pais;
    
    /** Edición o año del festival (ej: "2026") */
    private String edicion;
    
    /** Ubicación física donde ocurre el festival (ej: "Hipódromo de San Isidro") */
    private String lugar;
    
    /** Cantidad de días que dura el festival */
    private int cantidadDias;
    
    /** Lista de todos los escenarios disponibles en el festival */
    private ArrayList<Escenario> escenarios;
    
    /** Lista de todas las actuaciones programadas en el festival */
    private ArrayList<Actuacion> actuaciones;

    /**
     * Crea un nuevo festival Lollapalooza con sus datos básicos.
     * Se crean las listas de escenarios y actuaciones vacías, listas para recibir datos.
     * 
     * @param pais         País donde se realiza el festival
     * @param edicion      Año o edición del festival
     * @param lugar        Ubicación física del festival
     * @param cantidadDias Cantidad de días que durará el festival
     */
    public Lollapalooza(String pais, String edicion, String lugar, int cantidadDias) {
        this.pais = pais;
        this.edicion = edicion;
        this.lugar = lugar;
        this.cantidadDias = cantidadDias;
        this.escenarios = new ArrayList<>();
        this.actuaciones = new ArrayList<>();
    }

    /**
     * Agrega un nuevo escenario al festival.
     * 
     * Para evitar duplicados, verifica si el escenario ya existe antes de agregarlo.
     * Si el escenario es nulo (null), ignora la operación.
     * 
     * @param escenario El escenario a agregar
     */
    public void agregarEscenario(Escenario escenario) {
        if (escenario == null) return;
        if (!escenarios.contains(escenario)) {
            escenarios.add(escenario);
        }
    }

    /**
     * Agrega una nueva actuación al festival.
     * 
     * También intenta asegurar que el escenario de la actuación esté registrado
     * en el festival. Si no existe, lo agrega automáticamente.
     * 
     * @param actuacion La actuación a programar
     */
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

    /**
     * Busca todas las actuaciones que ocurren en una fecha específica.
     * 
     * Itera sobre todas las actuaciones del festival y compara sus fechas
     * con la fecha buscada. Retorna una lista con las coincidencias.
     * 
     * @param fecha La fecha a buscar en formato "YYYY-MM-DD"
     * @return Una lista de actuaciones que ocurren en esa fecha. 
     *         Si no hay coincidencias, retorna una lista vacía.
     */
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

    /**
     * Busca todas las actuaciones que ocurren en un escenario específico.
     * 
     * Itera sobre todas las actuaciones del festival y compara sus escenarios
     * con el escenario buscado. Retorna una lista con las coincidencias.
     * 
     * @param escenario El escenario donde buscar actuaciones
     * @return Una lista de actuaciones en ese escenario.
     *         Si no hay coincidencias, retorna una lista vacía.
     */
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

    /**
     * Busca actuaciones por nombre de banda.
     * 
     * Realiza una búsqueda que:
     * - NO es sensible a mayúsculas/minúsculas (ej: "The Strokes" = "the strokes")
     * - Permite búsqueda parcial (ej: buscar "metal" encontrará "Metallica")
     * 
     * Esto hacela búsqueda más amigable para el usuario.
     * 
     * @param nombre El nombre o parte del nombre de la banda a buscar
     * @return Una lista de actuaciones de bandas que coinciden con la búsqueda.
     *         Si no hay coincidencias, retorna una lista vacía.
     */
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

    /**
     * Carga datos de ejemplo en el festival para fines de demostración y testing.
     * 
     * Este método automáticamente crea:
     * - 4 escenarios diferentes (Principal, Alternativo, Electrónico, Acústico)
     * - 10 actuaciones distribuidas en 3 días
     * - Bandas conocidas como Foo Fighters, Metallica, Arctic Monkeys, etc.
     * 
     * Es muy útil para:
     * - Probar que el sistema funciona correctamente
     * - Ver ejemplos de cómo se estructura la información
     * - Demostrar las búsquedas sin escribir datos manualmente
     */
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

    /**
     * Obtiene la lista de todos los escenarios registrados en el festival.
     * 
     * @return ArrayList con todos los escenarios. Si no hay escenarios,
     *         retorna una lista vacía (nunca retorna null).
     */
    public ArrayList<Escenario> getEscenarios() {
        return escenarios;
    }

    /**
     * Obtiene la lista de todas las actuaciones programadas en el festival.
     * 
     * @return ArrayList con todas las actuaciones. Si no hay actuaciones,
     *         retorna una lista vacía (nunca retorna null).
     */
    public ArrayList<Actuacion> getActuaciones() {
        return actuaciones;
    }
}