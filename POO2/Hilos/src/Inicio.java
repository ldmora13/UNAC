public class Inicio {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Inicia el proceso");
        /*
        pares.start();
        impares.start();
         */

        HiloPar hiloPar = new HiloPar();
        hiloPar.run();
        HiloImpar hiloImpar = new HiloImpar();
        hiloImpar.run();

        Thread.sleep(1000);
        System.out.println("Fin");
    }
}