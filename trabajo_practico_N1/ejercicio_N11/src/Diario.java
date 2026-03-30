/**
 * Clase Diario - publicación periódica diaria o quincenal
 */
public class Diario extends Escrita {
    private boolean quincenal; // false = semanal/diario, true = quincenal
    private double recargoInterior;
    private int semana; // número de semana (1-53)
    private int mes;    // número de mes (1-12)

    public Diario(int codigo, String titulo, String responsableDireccion, String editor, int paginas, double precio, int anioPublicacion,
                 boolean quincenal, double recargoInterior, int semana, int mes) {
        super(codigo, titulo, responsableDireccion, editor, paginas, precio, anioPublicacion);
        this.quincenal = quincenal;
        this.recargoInterior = recargoInterior;
        this.semana = semana;
        this.mes = mes;
    }

    public boolean isQuincenal() { return quincenal; }
    public double getRecargoInterior() { return recargoInterior; }
    public int getSemana() { return semana; }
    public int getMes() { return mes; }

    @Override
    public String detalle() {
        String tipo = quincenal ? "Quincenal" : "Semanal";
        return super.detalle() + " [Diario: tipo=" + tipo + ", recargoInterior=" + recargoInterior + ", semana=" + semana + ", mes=" + mes + "]";
    }
}
