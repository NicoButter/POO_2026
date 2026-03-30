public class TestInt {
    public static void main(String args[]) {
        ArchivoDeEnteros archent = new ArchivoDeEnteros("enteros.dat");
        MenuArchivoDeEnteros menu = new MenuArchivoDeEnteros(archent);
        menu.mostrar();
    }
}
