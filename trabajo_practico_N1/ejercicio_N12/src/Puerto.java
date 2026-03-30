public class Puerto {
    private Amarre[] amarres;

    public Puerto(int cantidadAmarres) {
        amarres = new Amarre[cantidadAmarres];
        for (int i = 0; i < cantidadAmarres; i++) {
            amarres[i] = new Amarre(i+1);
        }
    }

    public Amarre getAmarre(int posicion) {
        if (posicion > 0 && posicion <= amarres.length) {
            return amarres[posicion-1];
        }
        return null;
    }

    public Amarre[] getAmarres() { return amarres; }
}
