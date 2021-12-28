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

public class allRegisterFormController {
    public AnchorPane allRegisterFormContext;
    public TableView tblRegisterDetail;
    public TableColumn colRegisterDetailID;
    public TableColumn colRegisterDetailNIC;
    public TableColumn colRegisterDetailName;
    public TableColumn colRegisterDetailAge;
    public TableColumn colRegisterDetailGender;
    public TableColumn colRegisterDetailProgramID;
    public TableColumn colRegisterDetailProgramName;
    public TableColumn colRegisterDetailProgramFee;
    public TextField txtSearchRegisterID;

    public void backToRegisterDetailDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage)allRegisterFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/sipsewanainstitute/hibernate/view/dashBoardForm.fxml"))));
    }
}
