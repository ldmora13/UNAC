package com.ParcialFX.Controllers;

import com.ParcialFX.SQL.DatabaseConnectionEnfermedades;
import com.ParcialFX.SQL.Enfermedad;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.*;

@Component
public class ControllerEliminar {
    @FXML
    public Rectangle btnEliminar, btnRegresar;
    @FXML
    public Label lblTxt;
    @FXML
    public TextField enfermedadTxt;
    @FXML
    public TableView <Enfermedad> tableEnfermedades;
    @FXML
    public TableColumn <Enfermedad, String> colEnfermedades;

    public void cargar (){
        ObservableList<Enfermedad> enfermedades = FXCollections.observableArrayList();

        try (Connection conn = DatabaseConnectionEnfermedades.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT enfermedad FROM enfermedades");

            while (rs.next()) {
                Enfermedad name_enfermedad = new Enfermedad();
                name_enfermedad.setEnfermedad(rs.getString("enfermedad"));
                enfermedades.add(name_enfermedad);

            }
            tableEnfermedades.setItems(enfermedades);
            colEnfermedades.setCellValueFactory(new PropertyValueFactory<Enfermedad, String>("enfermedad"));

        } catch (SQLException e) {
            lblTxt.setText("Error de conexion");
        }
    }

    public void eliminar (){
        String enfermedad = enfermedadTxt.getText();
        if (!enfermedad.isEmpty()) {
            try (Connection conn = DatabaseConnectionEnfermedades.getConnection()) {
                String sql = "DELETE FROM enfermedades WHERE enfermedad = '" + enfermedadTxt.getText() + "'";
                PreparedStatement ps = conn.prepareStatement(sql);
                int fila = ps.executeUpdate();
                if (fila > 0) {
                    lblTxt.setText("Se ha eliminado exitosamente la enfermedad");
                } else {
                    lblTxt.setText("Error al eliminar la enfermedad");
                }
            } catch (Exception e) {
                lblTxt.setText("Error de conexion");
            }
        } else {
            lblTxt.setText("Ingrese un enfermedad");
        }
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
