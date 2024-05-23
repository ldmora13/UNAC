import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ArbolBB arbol = new ArbolBB();
        String archivo = "estudiantes.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine();

            while ((linea = br.readLine()) != null) {
                String carne = linea.substring(0, 12).trim();
                String nombre = linea.substring(12, 43).trim();
                String email = linea.substring(43).trim();
                Estudiante estudiante = new Estudiante(carne, nombre, email);
                arbol.insertar(estudiante);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("------- Luis David Mora -------");

        System.out.println();
        System.out.println("Árbol almacenado:");
        arbol.inorden();

        System.out.println();
        System.out.println("Recorrido por niveles:");
        arbol.recorridoPorNiveles();

        System.out.println();
        System.out.println("Mostrar árbol:");
        arbol.mostrarArbol();
    }
}