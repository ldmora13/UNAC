package com.ParcialFX;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class escribirTxt {

    public static void escribirLogin(String ingreso) {
        String nombreArchivo = "login.log";
        try {
            FileWriter fileWriter = new FileWriter(nombreArchivo, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(ingreso);
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
