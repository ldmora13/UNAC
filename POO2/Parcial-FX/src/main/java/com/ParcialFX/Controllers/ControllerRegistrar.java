package com.ParcialFX.Controllers;

import com.ParcialFX.SQL.DatabaseConnectionEnfermedades;
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

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Component
public class ControllerRegistrar {
    @FXML
    public Rectangle btnRegistrar, btnLimpiar, btnRegresar;
    @FXML
    public TextField enfermedadTxt;
    @FXML
    public Label lblTxt;


    public void registrar() {
        String enfermedad = enfermedadTxt.getText();

        if (!enfermedad.isEmpty()) {

            try (Connection conn = DatabaseConnectionEnfermedades.getConnection()){
                String sql = "INSERT INTO enfermedades(enfermedad) VALUES ('" + enfermedad + "')";
                PreparedStatement ps = conn.prepareStatement(sql);
                int filas = ps.executeUpdate();

                if (filas > 0) {
                    lblTxt.setText("Registrado exitosamente");
                } else {
                    lblTxt.setText("Error al registrar");
                }

            } catch (Exception e) {
                lblTxt.setText("Error de conexión");
            }
        }
        else {
            lblTxt.setText("Ingrese un enfermedad");
        }
    }

    public void limpiar() {
        lblTxt.setText("Ingrese una nueva enfermedad");
        enfermedadTxt.setText("");
    }

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
