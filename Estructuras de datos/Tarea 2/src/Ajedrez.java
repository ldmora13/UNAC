public class Ajedrez {
    public static int contarSoluciones(int x0, int y0, int j) {
        if (y0 == j) {
            return 0;
        }
        if (x0 == 1 && Math.abs(y0 - j) == Math.abs(1 - x0)) {
            return 0;
        }
        if (x0 == 8) {
            return 1;
        }
        int soluciones = 0;
        soluciones += contarSoluciones(x0 + 1, j, j);

        if (j < 8) {
            soluciones += contarSoluciones(x0, j + 1, j);
        }

        if (j > 1) {
            soluciones += contarSoluciones(x0, j - 1, j);
        }
        return soluciones;
    }

    public static void main(String[] args) {
        int x0 = 2;
        int y0 = 2;
        int j = 5;

        int soluciones = contarSoluciones(x0, y0, j);
        System.out.println("-------- Luis David Mora --------");
        System.out.println("La cantidad de soluciones es: " + soluciones);
    }
}
