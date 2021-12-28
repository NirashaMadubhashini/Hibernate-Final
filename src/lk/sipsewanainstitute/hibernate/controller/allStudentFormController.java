package lk.sipsewanainstitute.hibernate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class allStudentFormController {
    public AnchorPane allStudentFormContext;
    public TableView tblStudentDetail;
    public TableColumn colStudentDetailName;
    public TableColumn colStudentDetailNIC;
    public TableColumn colStudentDetailBirthDay;
    public TableColumn colStudentDetailAddress;
    public TableColumn colStudentDetailAge;
    public TableColumn colStudentDetailMobile;
    public TableColumn colStudentDetailGender;
    public TableColumn colStudentDetailDate;
    public TableColumn colStudentDetailTime;
    public TextField txtSearchStudentNIC;

    public void backToStudentDetailDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) allStudentFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/sipsewanainstitute/hibernate/view/dashBoardForm.fxml"))));
    }
}
