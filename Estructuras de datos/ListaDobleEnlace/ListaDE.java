public class ListaDE {
    static Nodo primero;

    public static void insertarCabeza(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = primero;
        if (primero != null) {
            primero.anterior = nuevo;
        }
        primero = nuevo;
    }

    public static void mostrar () {
        int i = 1;
        for (Nodo p=primero; p!= null; p=p.siguiente) {
            System.out.printf("%3d%c", p.dato, (i++%15==0?'\n':' '));
        }
        System.out.println();
    }
}
