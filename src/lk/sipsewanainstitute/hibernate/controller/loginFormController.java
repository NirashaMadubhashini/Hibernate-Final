package lk.sipsewanainstitute.hibernate.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class loginFormController {
    public AnchorPane loginFormContext;
    public JFXPasswordField txtPassword;
    public JFXTextField txtUserName;

    public void openDashBoardOnAction(ActionEvent actionEvent) {
        if (txtUserName.getText().equalsIgnoreCase("Admin") && txtPassword.getText().equals("1234")) {
            Stage window = (Stage) loginFormContext.getScene().getWindow();
            try {
                window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/sipsewanainstitute/hibernate/view/dashBoardForm.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Incorrect User Name, Password. Try again..", ButtonType.CLOSE).show();
        }
    }

    public void moveToPassword(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }
}
