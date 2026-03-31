import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private int dni;
    private double altura;

    public Persona(String nombre, int dni, double altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
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
