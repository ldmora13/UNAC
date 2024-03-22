import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Calculadora 1945");
        System.out.println("Digite un primer valor");
        int a = scn.nextInt();
        System.out.println("Digite un segundo valor");
        int b = scn.nextInt();

        int S = Sumar.calcular(a, b);
        System.out.println("Resultado de sumar es " + S);

        int R = Restar.calcular(a, b);
        System.out.println("Resultado de restar es " + R);

        int M = Multiplicar.calcular(a, b);
        System.out.println("Resultado de sumar es " + M);

        if(b == 0){
            System.out.println("No se puede dividir por 0" );
        }else {
            double D = Dividir.calcular(a, b);
            System.out.println("Resultado de dividir es " + D);
        }
    }
}