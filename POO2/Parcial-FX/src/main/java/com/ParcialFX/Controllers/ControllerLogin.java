package com.ParcialFX.Controllers;

import com.ParcialFX.SQL.DatabaseConnectionUsers;
import com.ParcialFX.escribirTxt;
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
import java.sql.ResultSet;
import java.sql.Statement;


@Component
public class ControllerLogin {
    @FXML
    public Rectangle btnSalir, btnIngresar;
    @FXML
    public TextField txtUser;
    @FXML
    public PasswordField txtPass;
    @FXML
    public Label loginTxt;

    private boolean comprobar(){
        boolean bnd = false;
        DatabaseConnectionUsers connectionNow = new DatabaseConnectionUsers();
        Connection connectDB = connectionNow.getConnection();
        String verificar = "SELECT count(1) from usuarios where username = '" + txtUser.getText() + "' AND password = '" + txtPass.getText() + "'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(verificar);
            while (resultSet.next()) {
                if (resultSet.getInt(1) == 1){
                    bnd = true;
                } else {
                    bnd = false;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        } return bnd;
    }

    public void validarUsuario() throws IOException {

        if (txtUser.getText().isEmpty() || txtPass.getText().isEmpty()) {
            loginTxt.setText("Ingrese credenciales");
        }
        else if(comprobar() == true) {
            escribirTxt.escribirLogin(txtUser.getText());
            btnIngresar.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/com/ParcialFX/main.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } else {
            loginTxt.setText("Ingrese credenciales validas");
            txtUser.setText("");
            txtPass.setText("");
        }
    }

    public void salir() {
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }
}
