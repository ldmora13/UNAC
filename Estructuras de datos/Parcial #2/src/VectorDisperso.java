public class VectorDisperso {
    public Nodo cabeza;

    public VectorDisperso() {
        this.cabeza = null;
    }
    public void insertar(int indice, int valor){
        if (valor == 0){
            return;
        }
        Nodo nuevoNodo = new Nodo(indice, valor);
        if (cabeza == null){
            cabeza = nuevoNodo;
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null){
            actual = actual.siguiente;
        }
        actual.siguiente = nuevoNodo;
    }

    public VectorDisperso sumar(VectorDisperso otro){
        VectorDisperso resultado = new VectorDisperso();
        Nodo actual1 = this.cabeza;
        Nodo actual2 = otro.cabeza;

        while (actual1 != null || actual2 != null){
            int indice;
            int valor;
            if (actual1 == null || (actual2 != null && actual2.indice < actual1.indice)){
                indice = actual2.indice;
                valor = actual2.valor;
                actual2 = actual2.siguiente;
            } else if (actual2 == null || (actual1 != null && actual1.indice < actual2.indice)){
                indice = actual1.indice;
                valor = actual1.valor;
                actual1 = actual1.siguiente;
            } else {
                indice = actual1.indice;
                valor = actual1.valor + actual2.valor;
                actual1 = actual1.siguiente;
                actual2 =  actual2.siguiente;
            }
            resultado.insertar(indice, valor);
        }
        return resultado;
    }
    public int productoPunto(VectorDisperso otro) {
        int producto = 0;
        Nodo actual1 = this.cabeza;
        Nodo actual2 = otro.cabeza;
        while (actual1 != null && actual2 != null) {
            if (actual1.indice == actual2.indice) {
                producto += actual1.valor * actual2.valor;
                actual1 = actual1.siguiente;
                actual2 = actual2.siguiente;
            } else if (actual1.indice < actual2.indice) {
                actual1 = actual1.siguiente;
            } else {
                actual2 = actual2.siguiente;
            }
        }
        return producto;
    }
}
