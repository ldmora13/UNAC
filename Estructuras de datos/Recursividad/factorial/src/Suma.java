public class Suma {
    public static void main(String[] args) {
        int entrada = 453;
        System.out.println(suma(entrada));

    }
    static int suma(int n){
        if (n < 10){
            return n;
        } else {
            return n % 10 + suma(n / 10);
        }
    }
}
