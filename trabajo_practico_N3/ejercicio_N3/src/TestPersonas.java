public class TestPersonas {
    public static void main(String[] args) {
        ArchivoPersonas archPers = new ArchivoPersonas("datos.dat");
        MenuArchivoPersonas menu = new MenuArchivoPersonas(archPers);
        menu.mostrar();
    }
}
