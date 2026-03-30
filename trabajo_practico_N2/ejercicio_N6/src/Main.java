import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SistemaDeArchivo sistema = new SistemaDeArchivo("DISK1", 1000000);

        // Archivos de prueba
        sistema.agregarArchivo(new ArchivoTexto("documento", "txt", 1200, new Date(), true, true));
        sistema.agregarArchivo(new ArchivoBinario("imagen", "jpg", 500000, new Date(), true, false));
        sistema.agregarArchivo(new ArchivoTexto("notas", "md", 800, new Date(), true, true));
        sistema.agregarArchivo(new ArchivoBinario("video", "mp4", 200000, new Date(), false, false));
        sistema.agregarArchivo(new ArchivoTexto("error2_test", "log", 100, new Date(), true, true)); // Provoca Error2

        System.out.println("--- Listado de archivos ---");
        sistema.listarArchivo();
    }
}
