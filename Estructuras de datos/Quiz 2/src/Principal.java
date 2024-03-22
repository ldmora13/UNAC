import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        Conjunto conjunto1 = new Conjunto();
        Conjunto conjunto2 = new Conjunto();
        Random random = new Random();

        int tamañoConjunto1 = random.nextInt(50);
        int tamañoConjunto2 = random.nextInt(50);

        for (int i = 0; i < tamañoConjunto1; i++) {
            conjunto1.insertar(random.nextInt(1000));
        }

        for (int i = 0; i < tamañoConjunto2; i++) {
            conjunto2.insertar(random.nextInt(1000));
        }

        System.out.println("----------Luis David Mora----------");

        System.out.println("Conjunto 1:");
        conjunto1.mostrar();
        System.out.println("Conjunto 2:");
        conjunto2.mostrar();

        System.out.println("Cardinal del conjunto 1: " + conjunto1.cardinal());
        System.out.println("¿El elemento 123 pertenece al conjunto 1? " + conjunto1.pertenece(123));
        System.out.println("Unión de los conjuntos:");
        conjunto1.union(conjunto2).mostrar();
        System.out.println("Intersección de los conjuntos:");
        conjunto1.interseccion(conjunto2).mostrar();
        System.out.println("Diferencia entre el conjunto 1 y el conjunto 2:");
        conjunto1.diferencia(conjunto2).mostrar();
        System.out.println("¿El conjunto 1 está incluido en el conjunto 2? " + conjunto1.inclucion(conjunto2));
    }

}
