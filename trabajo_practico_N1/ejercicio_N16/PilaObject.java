public class PilaObject {
    private Object[] datos;
    private int tope;
    private int capacidad;

    public PilaObject(int capacidad) {
        this.capacidad = capacidad;
        this.tope = -1;
        datos = new Object[capacidad];
    }

    public void push(Object valor) {
        if (!isFull()) datos[++tope] = valor;
        else throw new RuntimeException("Pila llena");
    }

    public Object pop() {
        if (!isEmpty()) return datos[tope--];
        throw new RuntimeException("Pila vacía");
    }

    public Object peek() {
        if (!isEmpty()) return datos[tope];
        throw new RuntimeException("Pila vacía");
    }

    public boolean isEmpty() {
        return tope == -1;
    }

    public boolean isFull() {
        return tope == capacidad - 1;
    }

    public int size() {
        return tope + 1;
    }
}
