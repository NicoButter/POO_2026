import java.io.*;
import java.util.*;

public class ArchivoDeEnteros {
    private String nombreArchivo;

    public ArchivoDeEnteros(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void almacenarSecuencia(List<Integer> numeros) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "rw")) {
            raf.setLength(0); // Borra el archivo antes de escribir
            for (int n : numeros) {
                raf.writeInt(n);
            }
        }
    }

    public List<Integer> recuperarSecuencia() throws IOException {
        List<Integer> lista = new ArrayList<>();
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "r")) {
            while (raf.getFilePointer() < raf.length()) {
                lista.add(raf.readInt());
            }
        }
        return lista;
    }

    public boolean buscar(int valor) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "r")) {
            while (raf.getFilePointer() < raf.length()) {
                if (raf.readInt() == valor) return true;
            }
        }
        return false;
    }

    public double promedio() throws IOException {
        List<Integer> lista = recuperarSecuencia();
        if (lista.isEmpty()) return 0;
        int suma = 0;
        for (int n : lista) suma += n;
        return suma / (double) lista.size();
    }

    public void ordenar() throws IOException {
        List<Integer> lista = recuperarSecuencia();
        Collections.sort(lista);
        almacenarSecuencia(lista);
    }

    public void agregarElementos(List<Integer> nuevos) throws IOException {
        List<Integer> lista = recuperarSecuencia();
        lista.addAll(nuevos);
        almacenarSecuencia(lista);
    }

    public void separarParesImpares(String archivoPares, String archivoImpares) throws IOException {
        List<Integer> lista = recuperarSecuencia();
        try (RandomAccessFile rafP = new RandomAccessFile(archivoPares, "rw")) {
            rafP.setLength(0);
            for (int n : lista) {
                if (n % 2 == 0) rafP.writeInt(n);
            }
        }
        try (RandomAccessFile rafI = new RandomAccessFile(archivoImpares, "rw")) {
            rafI.setLength(0);
            for (int n : lista) {
                if (n % 2 != 0) rafI.writeInt(n);
            }
        }
    }
}
