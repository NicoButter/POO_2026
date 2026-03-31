public class TestPersonManager {
    public static void main(String[] args) {
        PersonManager manager = new PersonManager();
        manager.addPerson(new Persona("Ana", 123, 1.65));
        manager.addPerson(new Persona("Luis", 456, 1.72));
        manager.addPerson(new Persona("Marta", 789, 1.58));

        System.out.println("Personas actuales:");
        manager.printAll();

        System.out.println("\nBuscando a Luis:");
        System.out.println(manager.searchPerson("Luis"));

        System.out.println("\nEliminando a Ana:");
        manager.removePerson("Ana");
        manager.printAll();

        try {
            manager.savePersons("personas.dat");
            System.out.println("\nPersonas guardadas en archivo.");
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }

        // Limpiar y recuperar
        manager = new PersonManager();
        try {
            manager.retrievePersons("personas.dat");
            System.out.println("\nPersonas recuperadas del archivo:");
            manager.printAll();
        } catch (Exception e) {
            System.out.println("Error al recuperar: " + e.getMessage());
        }
    }
}
