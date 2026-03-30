public abstract class Pila {
    protected int tope;
    protected int capacidad;

    public Pila(int capacidad) {
        this.capacidad = capacidad;
        this.tope = -1;
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
