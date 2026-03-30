public class PilaEntero extends Pila {
    private int[] datos;

    public PilaEntero(int capacidad) {
        super(capacidad);
        datos = new int[capacidad];
    }

    public void push(int valor) {
        if (!isFull()) datos[++tope] = valor;
        else throw new RuntimeException("Pila llena");
    }

    public int pop() {
        if (!isEmpty()) return datos[tope--];
        throw new RuntimeException("Pila vacía");
    }

    public int peek() {
        if (!isEmpty()) return datos[tope];
        throw new RuntimeException("Pila vacía");
    }
}
