package diagnostico_2026.implementacion;

import java.util.ArrayList;

/**
 * Lollapalooza - Capa de Servicio (Lógica de Negocio)
 * 
 * RESPONSABILIDAD: Gestionar la lógica de negocio del festival y los objetos de dominio.
 * 
 * Esta clase es responsable de:
 * - VALIDAR todas las reglas de negocio
 * - GESTIONAR las colecciones de datos (escenarios, actuaciones)
 * - RECIBIR objetos de dominio ya creados y agregarlos a las colecciones
 * - Realizar búsquedas y consultas
 * - Garantizar la integridad de los datos
 * 
 * Esta clase NO debe:
 * - CREAR objetos de dominio (eso es responsabilidad de Main)
 * - Interactuar directamente con el usuario (eso es responsabilidad de Main)
 * - Manejar Scanner o System.out directamente
 * - Conocer detalles de la presentación
 * 
 * Principio clave: La creación de objetos de dominio ocurre en Main.
 * Lollapalooza solo recibe objetos ya creados y los gestiona.
 * 
 * @author Nicolás Butterfield
 * @version 3.0 - Refactorizado siguiendo principios OOP estrictos
 * @see Escenario
 * @see Actuacion
 */
public class Lollapalooza {

    /** País donde se realiza el festival (ej: "Argentina") */
    private String pais;
    
    /** Edición o año del festival (ej: "2026") */
    private String edicion;
    
    /** Sede o recinto donde ocurre el festival (ej: "Hipódromo de San Isidro") */
    private String sede;
    
    /** Cantidad de días que dura el festival */
    private int cantidadDias;
    
    /** Lista de todos los escenarios disponibles en el festival */
    private ArrayList<Escenario> escenarios;
    
    /** Lista de todas las actuaciones programadas en el festival */
    private ArrayList<Actuacion> actuaciones;

    /**
     * Constructor por defecto. Inicializa las colecciones vacías.
     * El festival se configurará después mediante configurarFestival()
     */
    public Lollapalooza() {
        this.escenarios = new ArrayList<>();
        this.actuaciones = new ArrayList<>();
    }

    /**
     * Configura los datos básicos del festival
     * 
     * @param pais         País donde se realiza el festival
     * @param edicion      Año o edición del festival
     * @param sede         Sede o recinto donde se realiza el festival
     * @param cantidadDias Cantidad de días que durará el festival
     */
    public void configurarFestival(String pais, String edicion, String sede, int cantidadDias) {
        this.pais = pais;
        this.edicion = edicion;
        this.sede = sede;
        this.cantidadDias = cantidadDias;
    }

    // ==================== MÉTODOS DE ADICIÓN DE OBJETOS ====================
    // Main es responsable de crear los objetos. Estos métodos solo los validan y agregan.

    /**
     * Agrega un escenario ya creado al festival.
     * Valida que no exista un escenario con el mismo nombre (case-insensitive).
     * 
     * @param escenario El objeto Escenario a agregar (debe ser creado por Main)
     * @return true si se agregó exitosamente, false si ya existe un escenario con ese nombre
     */
    public boolean agregarEscenario(Escenario escenario) {
        // Validación básica
        if (escenario == null || escenario.getNombre() == null || 
            escenario.getNombre().trim().isEmpty()) {
            return false;
        }
        
        // Verificar duplicados por nombre
        for (Escenario e : escenarios) {
            if (e.getNombre().equalsIgnoreCase(escenario.getNombre())) {
                return false; // Ya existe un escenario con ese nombre
            }
        }
        
        // Agregar el escenario (ya fue creado por Main)
        escenarios.add(escenario);
        return true;
    }

    /**
     * Agrega una actuación ya creada al festival.
     * Valida que la actuación tenga datos válidos.
     * 
     * @param actuacion El objeto Actuacion a agregar (debe ser creado por Main)
     * @return true si se agregó exitosamente, false si hay datos inválidos
     */
    public boolean agregarActuacion(Actuacion actuacion) {
        // Validaciones básicas
        if (actuacion == null) {
            return false;
        }
        
        if (actuacion.getNombreBanda() == null || actuacion.getNombreBanda().trim().isEmpty()) {
            return false;
        }
        
        if (actuacion.getDuracionMinutos() <= 0) {
            return false;
        }
        
        if (actuacion.getEscenario() == null) {
            return false;
        }
        
        // Agregar la actuación (ya fue creada por Main)
        actuaciones.add(actuacion);
        return true;
    }

    // ==================== MÉTODOS DE BÚSQUEDA Y CONSULTA ====================

    /**
     * Obtiene todas las actuaciones que ocurren en una fecha específica.
     * 
     * @param fecha La fecha a buscar en formato "YYYY-MM-DD"
     * @return Lista de actuaciones que ocurren en esa fecha (vacía si no hay)
     */
    public ArrayList<Actuacion> obtenerActuacionesPorDia(String fecha) {
        ArrayList<Actuacion> resultado = new ArrayList<>();
        if (fecha == null) return resultado;
        
        for (Actuacion a : actuaciones) {
            if (a != null && fecha.equals(a.getFecha())) {
                resultado.add(a);
            }
        }
        return resultado;
    }

    /**
     * Obtiene todas las actuaciones de un escenario específico.
     * 
     * @param escenario El escenario del cual obtener actuaciones
     * @return Lista de actuaciones en ese escenario (vacía si no hay)
     */
    public ArrayList<Actuacion> obtenerActuacionesPorEscenario(Escenario escenario) {
        ArrayList<Actuacion> resultado = new ArrayList<>();
        if (escenario == null) return resultado;
        
        for (Actuacion a : actuaciones) {
            if (a != null && escenario.equals(a.getEscenario())) {
                resultado.add(a);
            }
        }
        return resultado;
    }

    /**
     * Busca actuaciones por nombre de banda (búsqueda parcial, case-insensitive).
     * 
     * @param nombre Nombre o parte del nombre de la banda a buscar
     * @return Lista de actuaciones que coinciden con la búsqueda (vacía si no hay)
     */
    public ArrayList<Actuacion> buscarActuacionesPorBanda(String nombre) {
        ArrayList<Actuacion> resultado = new ArrayList<>();
        if (nombre == null) return resultado;
        
        String claveBusqueda = nombre.toLowerCase();
        
        for (Actuacion a : actuaciones) {
            if (a != null) {
                String nombreBanda = a.getNombreBanda();
                if (nombreBanda != null && nombreBanda.toLowerCase().contains(claveBusqueda)) {
                    resultado.add(a);
                }
            }
        }
        return resultado;
    }

    /**
     * Obtiene la lista completa de actuaciones.
     * 
     * @return ArrayList con todas las actuaciones
     */
    public ArrayList<Actuacion> obtenerTodasActuaciones() {
        return actuaciones;
    }

    /**
     * Obtiene la lista completa de escenarios.
     * 
     * @return ArrayList con todos los escenarios
     */
    public ArrayList<Escenario> obtenerTodosEscenarios() {
        return escenarios;
    }

    /**
     * Obtiene solo los nombres de los escenarios (útil para mostrar en UI).
     * 
     * @return Lista de nombres de escenarios
     */
    public ArrayList<String> obtenerNombresEscenarios() {
        ArrayList<String> nombres = new ArrayList<>();
        for (Escenario e : escenarios) {
            if (e != null) {
                nombres.add(e.getNombre());
            }
        }
        return nombres;
    }

    // ==================== GETTERS ====================

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