package com.quiz.Controller;

import com.quiz.SQL.DataBaseConnect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
    public Rectangle btnGuardar, btnLimpiar, btnRegresar;
    @FXML
    public Label lblTxt;
    @FXML
    public TextField nombreTxt, apellidoTxt, userTxt;
    @FXML
    public PasswordField passTxt;

    public void guardar() {
        String nombre = nombreTxt.getText();
        String apellido = apellidoTxt.getText();
        String user = userTxt.getText();
        String pass = passTxt.getText();
        if (nombre.isEmpty() || apellido.isEmpty() || user.isEmpty() || pass.isEmpty()){
            lblTxt.setText("Complete los campos");
        } else {
            try (Connection conn = DataBaseConnect.getConnection()){
                String sql = "INSERT INTO usuarios(nombre, apellido, username, password) VALUES ('" + nombre + "', '" + apellido + "', '" + user + "', '" + pass + "')";
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
    }

    public void limpiar() {
        nombreTxt.setText("");
        apellidoTxt.setText("");
        userTxt.setText("");
        passTxt.setText("");
    }

    public void regresar() throws IOException {
        btnRegresar.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/com/quiz/login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
