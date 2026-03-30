public class PilaString extends Pila {
    private String[] datos;

    public PilaString(int capacidad) {
        super(capacidad);
        datos = new String[capacidad];
    }

    public void push(String valor) {
        if (!isFull()) datos[++tope] = valor;
        else throw new RuntimeException("Pila llena");
    }

    public String pop() {
        if (!isEmpty()) return datos[tope--];
        throw new RuntimeException("Pila vacía");
    }

    public String peek() {
        if (!isEmpty()) return datos[tope];
        throw new RuntimeException("Pila vacía");
    }
}
