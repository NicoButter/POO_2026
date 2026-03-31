import java.io.*;
import java.nio.charset.StandardCharsets;

public class Persona {
    private static final int NOMBRE_MAX = 40;
    private String nombre;
    private int dni;
    private double altura;

    public Persona() {}

    public Persona(String nombre, int dni, double altura) {
        if (nombre.length() > NOMBRE_MAX) {
            this.nombre = nombre.substring(0, NOMBRE_MAX);
        } else {
            this.nombre = nombre;
        }
        this.dni = dni;
        this.altura = altura;
    }

    public void escribir(RandomAccessFile raf) throws IOException {
        byte[] nombreBytes = new byte[NOMBRE_MAX];
        byte[] nombreSrc = nombre.getBytes(StandardCharsets.UTF_8);
        int len = Math.min(nombreSrc.length, NOMBRE_MAX);
        System.arraycopy(nombreSrc, 0, nombreBytes, 0, len);
        raf.write(nombreBytes);
        raf.writeInt(dni);
        raf.writeDouble(altura);
    }

    public void leer(RandomAccessFile raf) throws IOException {
        byte[] nombreBytes = new byte[NOMBRE_MAX];
        raf.readFully(nombreBytes);
        this.nombre = new String(nombreBytes, StandardCharsets.UTF_8).trim();
        this.dni = raf.readInt();
        this.altura = raf.readDouble();
    }

    public static int getTamanioRegistro() {
        return NOMBRE_MAX + 4 + 8;
    }

    public int getDni() {
        return dni;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", DNI: " + dni + ", Altura: " + altura;
    }
}
