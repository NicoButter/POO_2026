// Clase Printer: representa una impresora con gestión de tinta, papel, conexión y estado en línea.
public class Printer {
    private double tinta; // cantidad de cargas de tinta
    private int papel; // cantidad de hojas
    private boolean conectada;
    private boolean enLinea;

    public Printer() {
        this.tinta = 0;
        this.papel = 0;
        this.conectada = false;
        this.enLinea = false;
    }

    public void cargarTinta(double cantidad) {
        this.tinta += cantidad;
    }

    public void cargarPapel(int cantidad) {
        this.papel += cantidad;
    }

    public void conectar() {
        this.conectada = true;
    }

    public void desconectar() {
        this.conectada = false;
    }

    public void on_line() {
        this.enLinea = true;
    }

    public void of_line() {
        this.enLinea = false;
    }

    public void print(Document doc) throws PrinterException {
        if (!conectada) throw new PrinterException("Impresora no conectada.");
        if (!enLinea) throw new PrinterException("Impresora fuera de línea.");
        if (papel == 0) throw new PrinterException("Falta papel.");
        if (tinta == 0) throw new PrinterException("Falta tinta.");
        int hojasAImprimir = doc.getCantidadHojas();
        int maxPorTinta = (int) Math.floor(tinta * 125);
        int maxImprimibles = Math.min(papel, maxPorTinta);
        if (maxImprimibles == 0) throw new PrinterException("No hay recursos para imprimir ninguna hoja.");
        int hojasRealmenteImpresas = Math.min(hojasAImprimir, maxImprimibles);
        papel -= hojasRealmenteImpresas;
        tinta -= ((double) hojasRealmenteImpresas) / 125.0;
        doc.setCantidadHojas(hojasAImprimir - hojasRealmenteImpresas);
        if (hojasRealmenteImpresas < hojasAImprimir) {
            throw new PrinterException("Solo se imprimieron " + hojasRealmenteImpresas + " hojas. Faltan recursos para completar el documento.");
        }
    }

    public double getTinta() {
        return tinta;
    }

    public int getPapel() {
        return papel;
    }

    public boolean isConectada() {
        return conectada;
    }

    public boolean isEnLinea() {
        return enLinea;
    }
}
