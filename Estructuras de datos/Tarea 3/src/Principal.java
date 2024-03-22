import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Luis David Mora
public class Principal {
    public static void main(String[] args) {
        ListaEnlazada lista1 = new ListaEnlazada();
        ListaEnlazada lista2 = new ListaEnlazada();

        try {
            BufferedReader lector1 = new BufferedReader(new FileReader("archivo1.txt"));
            BufferedReader lector2 = new BufferedReader(new FileReader("archivo2.txt"));

            String linea;

            while ((linea = lector1.readLine()) != null) {
                String[] palabras = linea.split("\\s+");
                for (String palabra : palabras) {
                    lista1.insertar(palabra, lista1.cabeza == null ? 1 : lista1.cabeza.frecuencia + 1);
                }
            }

            while ((linea = lector2.readLine()) != null) {
                String[] palabras = linea.split("\\s+");
                for (String palabra : palabras) {
                    lista2.insertar(palabra, lista2.cabeza == null ? 1 : lista2.cabeza.frecuencia + 1);
                }
            }

            lector1.close();
            lector2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-----Luis David Mora-----");

        System.out.println("Lista 1:");
        lista1.mostrar();
        System.out.println();

        System.out.println("Lista 2:");
        lista2.mostrar();
        System.out.println();

        lista1.encontrarComunes(lista2);
        System.out.println();

        ListaEnlazada listaUnida = ListaEnlazada.unirListas(lista1, lista2);
        System.out.println("Unión de listas:");
        listaUnida.mostrar();
    }
}