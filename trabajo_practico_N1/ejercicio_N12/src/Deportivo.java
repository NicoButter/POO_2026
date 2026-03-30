public class Deportivo extends Barco {
    private int potenciaCV;

    public Deportivo(String matricula, double eslora, int anioFabricacion, int potenciaCV) {
        super(matricula, eslora, anioFabricacion);
        this.potenciaCV = potenciaCV;
    }

    @Override
    public double getModulo() {
        return super.getModulo() + potenciaCV;
    }
}
