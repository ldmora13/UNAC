public class Fibonacci {
    public static void main(String[] args) {
        int entrada = 5;
        System.out.println(fibonacci(entrada));
    }
    static int fibonacci(int n){
        if (n == 0 || n == 1){
            return n;
        }else return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
