import java.util.*;

public class SistemaAlojamientos {
    private List<Alojamiento> alojamientos = new ArrayList<>();

    public void agregarAlojamiento(Alojamiento a) {
        alojamientos.add(a);
    }

    public List<Alojamiento> getTodos() {
        return new ArrayList<>(alojamientos);
    }

    public List<Hotel> getHotelesPorLocalidad(String localidad) {
        List<Hotel> res = new ArrayList<>();
        for (Alojamiento a : alojamientos) {
            if (a instanceof Hotel && a.getLocalidad().equalsIgnoreCase(localidad)) {
                res.add((Hotel)a);
            }
        }
        return res;
    }

    public List<Camping> getCampingsPorLocalidad(String localidad) {
        List<Camping> res = new ArrayList<>();
        for (Alojamiento a : alojamientos) {
            if (a instanceof Camping && a.getLocalidad().equalsIgnoreCase(localidad)) {
                res.add((Camping)a);
            }
        }
        return res;
    }
}
