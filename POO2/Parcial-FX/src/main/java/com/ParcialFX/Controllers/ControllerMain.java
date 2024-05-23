package com.ParcialFX.Controllers;

import com.ParcialFX.leerTxt;
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
    public Rectangle btnInicio, btnEstadisticas, btnForo, btnUbi, btnCerrar;
    @FXML
    public Label lblBienvenida;


    public void bienvenida() {
        String filePath = "login.log";
        leerTxt leer = new leerTxt(filePath);
        try {
            String lastLine = leer.usuarioLog();
            if (lastLine != null) {
                String[] elements = lastLine.split("\n");
                for (String element : elements) {
                   lblBienvenida.setText("Bienvenido, " + element.toUpperCase());
                }
            } else {
                System.out.println("Error al leer el archivo .log");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void estadisticas() throws IOException {
        btnEstadisticas.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/com/ParcialFX/menu.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    public void foro() throws IOException {
        btnForo.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/com/ParcialFX/topics.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    public void ubi() throws IOException {
        btnUbi.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/com/ParcialFX/ubicaciones.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    public void cerrar() throws IOException {
        btnCerrar.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/com/ParcialFX/login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
