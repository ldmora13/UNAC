public class pares {
    static void start() throws InterruptedException {
        for (int i = 0; i < 10; i++){
            if (i % 2 == 0){
                System.out.println(i);
                Thread.sleep(500);
            }
        }
    }
}
