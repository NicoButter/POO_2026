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
}
