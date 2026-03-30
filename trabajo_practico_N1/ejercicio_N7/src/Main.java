public class Main {
    public static void main(String[] args) {
        // Segmento (a)
        try {
            Uno a, b;
            Dos c, d;
            int n, m;
            a = new Uno();
            c = new Dos();
            b = c;
            // m = b.k(); // Error de compilación: Uno no tiene k()
        } catch (Exception e) {
            System.out.println("Error en segmento (a): " + e);
        }

        // Segmento (b)
        try {
            Uno a, b;
            Dos c, d;
            int n, m;
            a = new Uno();
            b = a;
            d = new Dos();
            n = d.f(); // d.f() -> d.g() + 10 -> (50 + 100) + 10 = 160
            a = d;
            m = a.g(); // a apunta a Dos, g() de Dos: 50 + 100 = 150
            System.out.println("(b) n = " + n + ", m = " + m);
        } catch (Exception e) {
            System.out.println("Error en segmento (b): " + e);
        }

        // Segmento (c)
        try {
            Uno a, b;
            Dos c, d;
            int n, m;
            a = new Uno();
            c = new Dos();
            b = c;
            d = c;
            m = d.g() + c.k() + a.f(); // d.g()=150, c.k()=100, a.f()=12 => m=262
            d = (Dos)a; // Error en runtime: ClassCastException
            n = m - d.k();
            System.out.println("(c) n = " + n + ", m = " + m);
        } catch (Exception e) {
            System.out.println("Error en segmento (c): " + e);
        }
    }
}
