import java.io.*;

public class Escuela implements Serializable {
    private int numeroEscuela;
    private int cantidadAlumnos;
    private int cantidadDocentes;
    private int cantidadCursos;

    public static final int BYTES = 4 * Integer.BYTES; // 4 campos int

    public Escuela() {}

    public Escuela(int numeroEscuela, int cantidadAlumnos, int cantidadDocentes, int cantidadCursos) {
        this.numeroEscuela = numeroEscuela;
        this.cantidadAlumnos = cantidadAlumnos;
        this.cantidadDocentes = cantidadDocentes;
        this.cantidadCursos = cantidadCursos;
    }

    public void escribir(RandomAccessFile raf) throws IOException {
        raf.writeInt(numeroEscuela);
        raf.writeInt(cantidadAlumnos);
        raf.writeInt(cantidadDocentes);
        raf.writeInt(cantidadCursos);
    }

    public void leer(RandomAccessFile raf) throws IOException {
        numeroEscuela = raf.readInt();
        cantidadAlumnos = raf.readInt();
        cantidadDocentes = raf.readInt();
        cantidadCursos = raf.readInt();
    }

    public static int getTamanioRegistro() {
        return BYTES;
    }

    @Override
    public String toString() {
        return "Escuela N°" + numeroEscuela + " | Alumnos: " + cantidadAlumnos + " | Docentes: " + cantidadDocentes + " | Cursos: " + cantidadCursos;
    }
}
