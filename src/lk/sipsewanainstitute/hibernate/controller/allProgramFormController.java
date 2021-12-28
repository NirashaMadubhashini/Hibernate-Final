package lk.sipsewanainstitute.hibernate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.sipsewanainstitute.hibernate.entity.Student;

import java.io.IOException;

public class allProgramFormController {
    public AnchorPane allProgramFormContext;
    public TableView tblProgramDetails;
    public TableColumn colProgramDetailID;
    public TableColumn colProgramDetailName;
    public TableColumn colProgramDetailDuration;
    public TableColumn colProgramDetailFee;
    public TableColumn colProgramDetailDate;
    public TableColumn colProgramDetailTime;
    public TextField txtSearchProgram;

    public void backToProgramaDetaisDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) allProgramFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/sipsewanainstitute/hibernate/view/dashBoardForm.fxml"))));



    }
}
