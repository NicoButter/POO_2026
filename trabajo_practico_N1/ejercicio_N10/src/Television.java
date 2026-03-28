/**
 * Clase Television - subclase de Programa
 * Para televisión se mide en cantidad de comerciales por tanda y número de tandas
 */
public class Television extends Programa {
    private int comercialesPorTanda;
    private int numeroTandas;

    public Television(String titulo, String director, int codigo, int duracionMinutos, String horaInicio, String emisora, int comercialesPorTanda, int numeroTandas) {
        super(titulo, director, codigo, duracionMinutos, horaInicio, emisora);
        this.comercialesPorTanda = comercialesPorTanda;
        this.numeroTandas = numeroTandas;
    }

    public int getComercialesPorTanda() { return comercialesPorTanda; }
    public int getNumeroTandas() { return numeroTandas; }

    public int totalComerciales() { return comercialesPorTanda * numeroTandas; }

    @Override
    public String espacioComercial() {
        return totalComerciales() + " comerciales (" + comercialesPorTanda + " por tanda × " + numeroTandas + " tandas)";
    }

    @Override
    public String toString() {
        return super.toString() + " (comercialesPorTanda=" + comercialesPorTanda + ", numeroTandas=" + numeroTandas + ")";
    }
}
