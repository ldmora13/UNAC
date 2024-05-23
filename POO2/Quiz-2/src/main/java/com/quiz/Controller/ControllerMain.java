package com.quiz.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ControllerMain {
    @FXML
    public Label lblTxt;
    @FXML
    public Rectangle btnCerrar;

    public void bienvenida() {
        String filePath = "login.log";
        leerLog leer = new leerLog(filePath);
        try {
            String lastLine = leer.usuarioLog();
            if (lastLine != null) {
                String[] elements = lastLine.split("\n");
                for (String element : elements) {
                    lblTxt.setText("Bienvenido, " + element.toUpperCase());
                }
            } else {
                System.out.println("Error al leer el archivo .log");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cerrar() throws IOException {
        btnCerrar.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/com/quiz/login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
