public class ListaEnlazada {
    Nodo cabeza;
    public void insertar(String palabra, int frecuencia) {
        Nodo nuevoNodo = new Nodo(palabra, frecuencia);
        if (cabeza == null || palabra.compareTo(cabeza.palabra) < 0) {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null && palabra.compareTo(actual.siguiente.palabra) > 0) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }
    }

    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.palabra + ": " + actual.frecuencia);
            actual = actual.siguiente;
        }
    }

    public void encontrarComunes(ListaEnlazada lista2) {
        Nodo actual1 = this.cabeza;
        Nodo actual2 = lista2.cabeza;

        System.out.println("Palabras comunes:");

        while (actual1 != null && actual2 != null) {
            if (actual1.palabra.equals(actual2.palabra)) {
                System.out.println(actual1.palabra + ": " + Math.min(actual1.frecuencia, actual2.frecuencia));
                actual1 = actual1.siguiente;
                actual2 = actual2.siguiente;
            } else if (actual1.palabra.compareTo(actual2.palabra) < 0) {
                actual1 = actual1.siguiente;
            } else {
                actual2 = actual2.siguiente;
            }
        }
    }

    public static ListaEnlazada unirListas(ListaEnlazada lista1, ListaEnlazada lista2) {
        ListaEnlazada listaUnida = new ListaEnlazada();
        Nodo actual1 = lista1.cabeza;
        Nodo actual2 = lista2.cabeza;

        while (actual1 != null || actual2 != null) {
            if (actual1 == null) {
                listaUnida.insertar(actual2.palabra, actual2.frecuencia);
                actual2 = actual2.siguiente;
            } else if (actual2 == null) {
                listaUnida.insertar(actual1.palabra, actual1.frecuencia);
                actual1 = actual1.siguiente;
            } else if (actual1.palabra.equals(actual2.palabra)) {
                listaUnida.insertar(actual1.palabra, actual1.frecuencia + actual2.frecuencia);
                actual1 = actual1.siguiente;
                actual2 = actual2.siguiente;
            } else if (actual1.palabra.compareTo(actual2.palabra) < 0) {
                listaUnida.insertar(actual1.palabra, actual1.frecuencia);
                actual1 = actual1.siguiente;
            } else {
                listaUnida.insertar(actual2.palabra, actual2.frecuencia);
                actual2 = actual2.siguiente;
            }
        }

        return listaUnida;
    }
}
