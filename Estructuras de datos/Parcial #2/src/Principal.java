public class Principal {
    public static void main(String[] args) {
        System.out.println("----------Luis David Mora----------");
        VectorDisperso vector1 = new VectorDisperso();
        vector1.insertar(0, 1);
        vector1.insertar(2, 2);
        vector1.insertar(4, 3);

        VectorDisperso vector2 = new VectorDisperso();
        vector2.insertar(1, 4);
        vector2.insertar(2, 5);
        vector2.insertar(4, 6);

        VectorDisperso suma = vector1.sumar(vector2);
        System.out.println("Suma de vectores:");
        imprimir(suma);

        int productoPunto = vector1.productoPunto(vector2);
        System.out.println("Producto punto de los vectores: " + productoPunto);
    }
    public static void imprimir(VectorDisperso vector) {
        Nodo actual = vector.cabeza;
        while (actual != null) {
            System.out.println("Índice: " + actual.indice + ", Valor: " + actual.valor);
            actual = actual.siguiente;
        }
    }
}