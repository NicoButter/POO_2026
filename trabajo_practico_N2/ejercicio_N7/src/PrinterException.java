// Excepción personalizada para errores de la impresora.
public class PrinterException extends Exception {
    public PrinterException(String mensaje) {
        super(mensaje);
    }
}
