import java.io.*;
import java.util.Vector;

public class PersonManager {
    private Vector<Persona> personas;

    public PersonManager() {
        personas = new Vector<>();
    }

    public void addPerson(Persona p) {
        personas.add(p);
    }

    public boolean removePerson(String n) {
        return personas.removeIf(p -> p.getNombre().equals(n));
    }

    public Persona searchPerson(String n) {
        for (Persona p : personas) {
            if (p.getNombre().equals(n)) {
                return p;
            }
        }
        return null;
    }

    public void savePersons(String file) throws IOException {
        if (personas.isEmpty()) return;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Persona p : personas) {
                oos.writeObject(p);
            }
        }
    }

    public void retrievePersons(String file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Persona p = (Persona) ois.readObject();
                    personas.add(p);
                } catch (EOFException e) {
                    break;
                }
            }
        }
    }

    public void printAll() {
        for (Persona p : personas) {
            System.out.println(p);
        }
    }
}
