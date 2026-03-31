import java.io.*;
import java.util.*;

public class ArchivoPersonas {
    private String nombreArchivo;

    public ArchivoPersonas(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void almacenarPersonas(List<Persona> personas) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "rw")) {
            raf.setLength(0);
            for (Persona p : personas) {
                p.escribir(raf);
            }
        }
    }

    public List<Persona> recuperarPersonas() throws IOException {
        List<Persona> lista = new ArrayList<>();
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "r")) {
            long total = raf.length() / Persona.getTamanioRegistro();
            for (int i = 0; i < total; i++) {
                Persona p = new Persona();
                p.leer(raf);
                lista.add(p);
            }
        }
        return lista;
    }

    // Buscar persona por DNI
    public Persona buscarPorDni(int dni) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "r")) {
            long total = raf.length() / Persona.getTamanioRegistro();
            for (int i = 0; i < total; i++) {
                Persona p = new Persona();
                p.leer(raf);
                if (p.getDni() == dni) {
                    return p;
                }
            }
        }
        return null;
    }

    // Calcular altura promedio
    public double alturaPromedio() throws IOException {
        List<Persona> personas = recuperarPersonas();
        if (personas.isEmpty()) return 0;
        double suma = 0;
        for (Persona p : personas) {
            suma += p.getAltura();
        }
        return suma / personas.size();
    }

    // Generar archivo con personas de altura > 1.60
    public void generarArchivoAlturaMayorA(double alturaMin, String nombreAux) throws IOException {
        List<Persona> personas = recuperarPersonas();
        try (RandomAccessFile raf = new RandomAccessFile(nombreAux, "rw")) {
            raf.setLength(0);
            for (Persona p : personas) {
                if (p.getAltura() > alturaMin) {
                    p.escribir(raf);
                }
            }
        }
    }
}
