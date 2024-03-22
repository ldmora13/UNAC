import java.util.Random;

public class Conjunto {
    private Nodo cabeza;

    public Conjunto() {
        this.cabeza = null;
    }

    public int cardinal() {
        int contador = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    public boolean pertenece(int elemento) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == elemento) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public void insertar(int elemento) {
        if (!pertenece(elemento)) {
            Nodo nuevoNodo = new Nodo(elemento);
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        }
    }

    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public Conjunto union(Conjunto otroConjunto) {
        Conjunto resultado = new Conjunto();
        Nodo actual = cabeza;
        while (actual != null) {
            resultado.insertar(actual.dato);
            actual = actual.siguiente;
        }
        actual = otroConjunto.cabeza;
        while (actual != null) {
            if (!resultado.pertenece(actual.dato)) {
                resultado.insertar(actual.dato);
            }
            actual = actual.siguiente;
        }
        return resultado;
    }

    public Conjunto interseccion(Conjunto otroConjunto) {
        Conjunto resultado = new Conjunto();
        Nodo actual = cabeza;
        while (actual != null) {
            if (otroConjunto.pertenece(actual.dato)) {
                resultado.insertar(actual.dato);
            }
            actual = actual.siguiente;
        }
        return resultado;
    }

    public Conjunto diferencia(Conjunto otroConjunto) {
        Conjunto resultado = new Conjunto();
        Nodo actual = cabeza;
        while (actual != null) {
            if (!otroConjunto.pertenece(actual.dato)) {
                resultado.insertar(actual.dato);
            }
            actual = actual.siguiente;
        }
        return resultado;
    }

    public boolean inclucion(Conjunto otroConjunto) {
        Conjunto resultado = new Conjunto();
        Nodo actual = cabeza;
        while (actual != null) {
            if (!pertenece(actual.dato)) {
                return false;
            }
            actual = actual.siguiente;
        }
        return true;
    }
}