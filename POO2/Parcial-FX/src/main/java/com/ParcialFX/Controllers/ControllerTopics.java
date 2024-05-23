package com.ParcialFX.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ControllerTopics {
    @FXML
    public Rectangle btnCrear, btnListar, btnRegresar;
    @FXML
    public Label lblTxt;

    public void bienvenida(){
        lblTxt.setText("Bienvenido");
    }

    public void crear() throws IOException {
        btnCrear.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/com/ParcialFX/newTopic.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public void listar() throws IOException {
        btnListar.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/com/ParcialFX/listarTopics.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public void regresar() throws IOException {
        btnRegresar.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/com/ParcialFX/main.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
