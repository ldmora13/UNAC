package com.ParcialFX.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class ControllerUbi {
    @FXML
    public TextField municipioTxt;
    @FXML
    public Rectangle btnRegresar, btnBuscar;
    @FXML
    public Label lblTxt, lblRegion, lblMunicipio, lblDireccion, lblHospital, lblTelefono;

    public void buscar() {
        String municipio = municipioTxt.getText();
        String archivo = "BaseDeDatosHospitales.csv";
        String condicion = municipio;
        if (!condicion.isEmpty()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] fields = line.split(",");
                    String evaluationField = fields[3];
                    if (evaluationField.equalsIgnoreCase(condicion)) {
                        System.out.println("Busqueda de " + condicion + " realizada");
                        lblRegion.setText("Región: " + fields[1]);
                        lblMunicipio.setText("Municipio: " + fields[3]);
                        lblHospital.setText("Hospital: " + fields[5]);
                        lblDireccion.setText("Direccion: " + fields[8]);
                        lblTelefono.setText("Telefono: +" + fields[9]);
                    } else {
                        lblTxt.setText("Ingrese un municipio a buscar");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            lblTxt.setText("Ingrese un municipio");
        }
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
