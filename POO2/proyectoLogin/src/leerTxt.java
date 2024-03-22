import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class leerTxt {
    public static String leer(String nombreArchivo) {
        String linea="";
        try {
            FileReader fileReader = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            linea = bufferedReader.readLine();
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Error en lectura");
        }
        return linea;
    }
}
