public class InterfazGrafica {
    public static void mostrar(Archivo f) throws Error1, Error2 {
        // Simulación: lanzar Error1 si es binario, Error2 si nombre contiene "error2"
        if (f instanceof ArchivoBinario) {
            throw new Error1("No se puede mostrar un archivo binario: " + f.getNombre());
        }
        if (f.getNombre().toLowerCase().contains("error2")) {
            throw new Error2("No se puede seguir mostrando archivos: " + f.getNombre());
        }
        System.out.println(f);
    }

    public static void mensajeError(String s) {
        System.err.println("[ERROR] " + s);
    }
}
