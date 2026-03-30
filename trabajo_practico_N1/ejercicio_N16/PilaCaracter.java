public class PilaCaracter extends Pila {
    private char[] datos;

    public PilaCaracter(int capacidad) {
        super(capacidad);
        datos = new char[capacidad];
    }

    public void push(char valor) {
        if (!isFull()) datos[++tope] = valor;
        else throw new RuntimeException("Pila llena");
    }

    public char pop() {
        if (!isEmpty()) return datos[tope--];
        throw new RuntimeException("Pila vacía");
    }

    public char peek() {
        if (!isEmpty()) return datos[tope];
        throw new RuntimeException("Pila vacía");
    }
}
