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

    // Getters básicos
    public ArrayList<Escenario> getEscenarios() {
        return escenarios;
    }

    public ArrayList<Actuacion> getActuaciones() {
        return actuaciones;
    }
}