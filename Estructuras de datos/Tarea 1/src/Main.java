public class Main {
    public static void main(String[] args) {
        System.out.println("----------Luis David Mora----------");
        int n = 12;
        int b = 2;
        String resultado = cambio(n, b);
        System.out.println("El número " + n
                + " en base " + b
                + " es: " + resultado);
    }
    public static String cambio(int n, int b) {
        if (n == 0) {
            return "";
        } else {
            int restante = n % b;
            return cambio(n / b, b) + letras(restante);
        }
    }
    public static String letras(int letra) {
        if (letra < 10) {
            return String.valueOf(letra);
        } else {
            return String.valueOf((char) ('A' + letra - 10));
        }
    }
}