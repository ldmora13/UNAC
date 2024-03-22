public class Alfabeto {
    public static void main(String[] args) {
        metA('Z');

    }
    static void metA(char c){
        if (c == 'A'){
            System.out.print(c);
        } else {
            metB(c);
            System.out.print(c);

        }
    }
    static void metB(char c){
        metA((char) (c-1));
    }
}
