import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        ListaDE l = new ListaDE();
        Random r = new Random(1);
        int n = r.nextInt(60) + 10;
        for (int i=0;i<n;i++) {
            l.insertarCabeza(r.nextInt(999));
        }
        l.mostrar();
    }
}
