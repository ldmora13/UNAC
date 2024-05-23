package com.quiz.Controller;

import com.quiz.SQL.DataBaseConnect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
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
    public TextField txtUsername, txtPassword;
    @FXML
    public Rectangle btnIngresar, btnSalir;
    @FXML
    public Label lblTxt;
    public Text txtRegistrar;

    public void bienvenida(){
        lblTxt.setText("Bienvenido!");
    }

    public boolean comprobar(){
        boolean bnd = false;
        DataBaseConnect connectionNow = new DataBaseConnect();
        Connection connectDB = connectionNow.getConnection();
        String verify = "SELECT count(1) from usuarios where username = '" + txtUsername.getText() + "' AND password = '" + txtPassword.getText() + "'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(verify);
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

    public void ingresar() throws IOException {
        if (txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty()) {
            lblTxt.setText("Ingrese credenciales");
        }
        else if(comprobar() == true) {
            escribirLog.escribirLogin(txtUsername.getText());
            btnIngresar.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/com/quiz/main.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } else {
            lblTxt.setText("Ingrese credenciales validas");
            txtUsername.setText("");
            txtPassword.setText("");
        }
    }

    public void salir(){
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }

    public void registrar() throws IOException {
        txtRegistrar.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/com/quiz/registrar.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
