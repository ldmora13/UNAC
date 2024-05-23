package com.ParcialFX.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ControllerGrafico {
    @FXML
    public Rectangle btnRegresar;

    public void regresar() throws IOException {
        btnRegresar.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/com/ParcialFX/menu.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

}
