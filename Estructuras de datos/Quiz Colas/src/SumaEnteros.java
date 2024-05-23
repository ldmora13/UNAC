import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumaEnteros {

    static class Stack {
        private Nodo top;

        private static class Nodo {
            int data;
            Nodo next;

            Nodo(int data) {
                this.data = data;
            }
        }

        void push(int data) {
            Nodo node = new Nodo(data);
            node.next = top;
            top = node;
        }

        int pop() {
            if (top == null) {
                throw new IllegalStateException("Pila vacia");
            }
            int data = top.data;
            top = top.next;
            return data;
        }

        boolean isEmpty() {
            return top == null;
        }
    }
    static class Cola {
        private Nodo cabeza;
        private Nodo cola;

        private static class Nodo {
            int data;
            Nodo next;

            Nodo(int data) {
                this.data = data;
            }
        }

        void poner(int data) {
            Nodo nodo = new Nodo(data);
            if (cola != null) {
                cola.next = nodo;
            }
            cola = nodo;
            if (cabeza == null) {
                cabeza = nodo;
            }
        }

        int sacar() {
            if (cabeza == null) {
                throw new IllegalStateException("Cola vacia");
            }
            int data = cabeza.data;
            cabeza = cabeza.next;
            if (cabeza == null) {
                cola = null;
            }
            return data;
        }

        boolean isEmpty() {
            return cabeza == null;
        }
    }

    public static void main(String[] args) {
        System.out.println("-------- Luis David Mora --------");
        String filePath = "entrada.txt";


        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            Stack NumActual = new Stack();
            Cola Resultado = new Cola();

            if ((line = reader.readLine()) != null ) {
                for (int i = line.length() - 1; i >= 0; i--) {
                    NumActual.push(line.charAt(i));
                }
                while (!NumActual.isEmpty()) {
                    Resultado.poner(NumActual.pop());
                }
            }
            while ((line = reader.readLine()) != null ) {
                Stack siguiente = new Stack();
                for (int i = line.length() - 1; i >= 0; i--) {
                    siguiente.push(line.charAt(i) - '0');
                }

                int carry = 0;
                Cola newResultado = new Cola();
                while (!siguiente.isEmpty() || !Resultado.isEmpty() || carry != 0) {
                    int digit1 = siguiente.isEmpty() ? 0 : siguiente.pop();
                    int digit2 = Resultado.isEmpty() ? 0 : Resultado.sacar();
                    int sum = digit1 + digit2 + carry;
                    carry = sum / 10;
                   newResultado.poner(sum);
                }
                Resultado = newResultado;
            }
            reader.close();

            //
            System.out.println("La suma de los enteros es: ");
            while (!Resultado.isEmpty()){
                System.out.println(Resultado.sacar());
            }
            System.out.println();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}