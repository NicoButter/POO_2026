// Clase Document: representa un documento con una cantidad de hojas a imprimir.
public class Document {
    private int cantidadHojas;

    public Document(int cantidadHojas) {
        this.cantidadHojas = cantidadHojas;
    }

    public int getCantidadHojas() {
        return cantidadHojas;
    }

    public void setCantidadHojas(int cantidadHojas) {
        this.cantidadHojas = cantidadHojas;
    }
}
