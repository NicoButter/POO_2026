public class Velero extends Barco {
    private int numMastiles;

    public Velero(String matricula, double eslora, int anioFabricacion, int numMastiles) {
        super(matricula, eslora, anioFabricacion);
        this.numMastiles = numMastiles;
    }

    @Override
    public double getModulo() {
        return super.getModulo() + numMastiles;
    }
}
