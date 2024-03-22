public class Factorial {
    public static void main(String[] args) {
        int entrada = 48;
        System.out.println(factorial(entrada));
    }
    static long factorial(int n){
        if (n == 0 || n == 1){
            return 1;
        } else {
            return n * factorial(n -1);
        }
    }
}