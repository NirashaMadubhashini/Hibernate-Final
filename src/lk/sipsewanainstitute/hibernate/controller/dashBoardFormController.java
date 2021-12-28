package lk.sipsewanainstitute.hibernate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class dashBoardFormController {
    public AnchorPane dashBoardFormContext;

    public void addStudentOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) dashBoardFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/sipsewanainstitute/hibernate/view/studentForm.fxml"))));
    }

    public void studentDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) dashBoardFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/sipsewanainstitute/hibernate/view/allStudentForm.fxml"))));
    }

    public void addProgrameOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) dashBoardFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/sipsewanainstitute/hibernate/view/programForm.fxml"))));
    }

    public void projectDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) dashBoardFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/sipsewanainstitute/hibernate/view/allProgramForm.fxml"))));
    }

    public void RegisterOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) dashBoardFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/sipsewanainstitute/hibernate/view/registerForm.fxml"))));
    }

    public void registerDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) dashBoardFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/sipsewanainstitute/hibernate/view/allRegisterForm.fxml"))));
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) dashBoardFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/sipsewanainstitute/hibernate/view/loginForm.fxml"))));
    }
}
