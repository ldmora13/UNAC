public class ArbolBB {
    Nodo raiz;

    public void insertar(Estudiante estudiante) {
        if (raiz == null) {
            raiz = new Nodo(estudiante);
        } else {
            insertarRecursivo(raiz, estudiante);
        }
    }

    private void insertarRecursivo(Nodo nodoActual, Estudiante estudiante) {
        if (estudiante.carnet.compareTo(nodoActual.estudiante.carnet) < 0) {
            if (nodoActual.izquierdo == null) {
                nodoActual.izquierdo = new Nodo(estudiante);
            } else {
                insertarRecursivo(nodoActual.izquierdo, estudiante);
            }
        } else {
            if (nodoActual.derecho == null) {
                nodoActual.derecho = new Nodo(estudiante);
            } else {
                insertarRecursivo(nodoActual.derecho, estudiante);
            }
        }
    }

    public void inorden() {
        inordenRecursivo(raiz);
    }

    private void inordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.izquierdo);
            System.out.println(nodo.estudiante.carnet);
            inordenRecursivo(nodo.derecho);
        }
    }

    public void recorridoPorNiveles() {
        if (raiz == null) {
            return;
        }

        int altura = altura(raiz);
        for (int i = 0; i <= altura; i++) {
            imprimirNivel(raiz, i);
        }
    }

    private int altura(Nodo nodo) {
        if (nodo == null) {
            return -1;
        }
        int alturaIzquierda = altura(nodo.izquierdo);
        int alturaDerecha = altura(nodo.derecho);
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    private void imprimirNivel(Nodo nodo, int nivel) {
        if (nodo == null) {
            return;
        }
        if (nivel == 0) {
            String primerApellido = nodo.estudiante.nombre.split(" ")[0];
            System.out.println(primerApellido);
        } else if (nivel > 0) {
            imprimirNivel(nodo.izquierdo, nivel - 1);
            imprimirNivel(nodo.derecho, nivel - 1);
        }
    }

    public void mostrar(String prefijo, boolean esCola, Nodo n) {
        if (n != null) {
            System.out.println(prefijo + (esCola ? "└── " : "├── ") + n.getDato());
            mostrar(prefijo + (esCola ? "    " : "│   "), false, n.getIzdo());
            mostrar(prefijo + (esCola ? "    " : "│   "), true, n.getDcho());
        }
    }

    public void mostrarArbol() {
        mostrar("", true, raiz);
    }
}
