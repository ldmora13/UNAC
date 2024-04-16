import java.util.Random;

public class Pila {

    static class pila {
        private int[] array;
        private int top;

        public pila(int capacity) {
            array = new int[capacity];
            top = -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == array.length - 1;
        }

        public void push(int value) {
            if (isFull()) {
                System.out.println("pila Overflow");
                return;
            }
            array[++top] = value;
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("pila Underflow");
                return -1;
            }
            return array[top--];
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("pila vacia");
                return -1;
            }
            return array[top];
        }
    }

    public static void main(String[] args) {
        System.out.println("-------- Luis David Mora --------");
        pila entrada = PilaEntrada();
        System.out.println("Números de entrada:");
        mostrarPila(entrada);
        pila salida = ordenarPila(entrada);
        System.out.println("Números ordenados de manera descendente:");
        mostrarPila(salida);
    }

    private static pila PilaEntrada() {
        Random random = new Random();
        int n = random.nextInt(11) + 10;
        pila pila = new pila(n);

        for (int i = 0; i < n; i++) {
            int num = random.nextInt(99) + 1;
            pila.push(num);
        }
        return pila;
    }

    private static pila ordenarPila(pila entrada) {
        pila salida = new pila(entrada.array.length);

        while (!entrada.isEmpty()) {
            int temp = entrada.pop();
            while (!salida.isEmpty() && salida.peek() < temp) {
                entrada.push(salida.pop());
            }
            salida.push(temp);
        }
        return salida;
    }

    private static void mostrarPila(pila pila) {
        Pila.pila temp = new pila(pila.array.length);
        while (!pila.isEmpty()) {
            int num = pila.pop();
            System.out.print(num + " ");
            temp.push(num);
        }
        System.out.println();
        while (!temp.isEmpty()) {
            pila.push(temp.pop());
        }
    }
}
