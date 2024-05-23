class Nodo {
    Estudiante estudiante;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.izquierdo = null;
        this.derecho = null;
    }

    public String getDato() {
        return estudiante.carnet;
    }

    public Nodo getIzdo() {
        return izquierdo;
    }

    public Nodo getDcho() {
        return derecho;
    }
}