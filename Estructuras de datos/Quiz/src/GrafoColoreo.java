public class GrafoColoreo {
    private int V;
    private int[][] grafo;
    private int[] colores;

    public GrafoColoreo(int[][] grafo) {
        this.V = grafo.length;
        this.grafo = grafo;
        this.colores = new int[V];
    }

    private boolean Seguro(int v, int color) {
        for (int i = 0; i < V; i++) {
            if (grafo[v][i] == 1 && color == colores[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean colorearGrafo(int v, int m) {
        if (v == V) return true;
        for (int c = 1; c <= m; c++) {
            if (Seguro(v, c)) {
                colores[v] = c;
                if (colorearGrafo(v + 1, m)) return true;
                colores[v] = 0;
            }
        }
        return false;
    }

    public boolean colorearGrafo(int m) {
        for (int i = 0; i < V; i++) colores[i] = 0;
        if (!colorearGrafo(0, m)) {
            return false;
        }
        return true;
    }

    public void encontrarMinimoColores() {
        int m = 1;
        while (!colorearGrafo(m)) {
            m++;
        }
        System.out.println("El número mínimo de colores necesarios para colorear el grafo es: " + m);
    }

    public static void main(String[] args) {
        System.out.println("------------ Luis David Mora ------------");
        int grafo[][] = {
                {0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 1, 0}
        };

        GrafoColoreo g = new GrafoColoreo(grafo);
        g.encontrarMinimoColores();
    }
}