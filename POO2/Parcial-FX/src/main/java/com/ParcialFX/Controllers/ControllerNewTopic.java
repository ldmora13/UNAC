package com.ParcialFX.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class ControllerNewTopic {
    @FXML
    public Rectangle btnGuardar, btnLimpiar, btnRegresar;
    @FXML
    public TextField usuarioTxt, tituloTxt;
    @FXML
    public TextArea discusionTxt;
    @FXML
    public Label lblTxt;



    public void guardar() {
        if (tituloTxt.getText().isEmpty() || usuarioTxt.getText().isEmpty() || discusionTxt.getText().isEmpty()) {
            lblTxt.setText("Complete todos los campos");
        }else {
            String archivo = "foro.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
                writer.write(usuarioTxt.getText()+ "-");
                writer.write(tituloTxt.getText() + "-");
                writer.write(discusionTxt.getText() + "\n");
                lblTxt.setText("Datos guardados con éxito!");
            } catch (IOException e) {
                lblTxt.setText("Error al guardar datos");
            }
        }
    }

    public void limpiar(){
        lblTxt.setText("Ingrese un nuevo tema");
        usuarioTxt.setText("");
        tituloTxt.setText("");
        discusionTxt.setText("");
    }

    public void regresar() throws IOException {
        btnRegresar.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/com/ParcialFX/topics.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
