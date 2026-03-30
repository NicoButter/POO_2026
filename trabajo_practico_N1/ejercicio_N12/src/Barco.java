public abstract class Barco {
    protected String matricula;
    protected double eslora;
    protected int anioFabricacion;

    public Barco(String matricula, double eslora, int anioFabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anioFabricacion = anioFabricacion;
    }

    public double getEslora() { return eslora; }
    public String getMatricula() { return matricula; }
    public int getAnioFabricacion() { return anioFabricacion; }

    public double getModulo() {
        return eslora * 10;
    }
}
