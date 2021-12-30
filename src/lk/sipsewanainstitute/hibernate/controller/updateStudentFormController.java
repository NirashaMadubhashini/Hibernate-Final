package lk.sipsewanainstitute.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.sipsewanainstitute.hibernate.business.BOFactory;
import lk.sipsewanainstitute.hibernate.business.custom.StudentBO;
import lk.sipsewanainstitute.hibernate.dto.StudentDTO;
import lk.sipsewanainstitute.hibernate.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

import static lk.sipsewanainstitute.hibernate.business.BOFactory.getBOFactory;

public class updateStudentFormController {
    public static AnchorPane studentFormContext;
    public AnchorPane updateStudentFormContext;
    public TextField txtUpdateName;
    public TextField txtUpdateBirthDay;
    public TextField txtUpdateAddress;
    public TextField txtUpdateAge;
    public TextField txtUpdateMobile;
    public TextField txtUpdateGender;
    public JFXButton btnUpdateStudent;
    public String nic;
    public String date;
    public String time;

    private final StudentBO studentBO = (StudentBO) getBOFactory().getBO(BOFactory.BoTypes.STUDENT);

    public void UpdateStudentOnAction(ActionEvent actionEvent) {
        try {
            if (studentBO.update(new StudentDTO(
                    nic,
                    txtUpdateName.getText(),
                    txtUpdateBirthDay.getText(),
                    txtUpdateAddress.getText(),
                    Integer.parseInt(txtUpdateAge.getText()),
                    txtUpdateGender.getText(),
                    txtUpdateMobile.getText(),
                    date,
                    time
            ))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated").showAndWait();
                Stage stage = (Stage) btnUpdateStudent.getScene().getWindow();
                stage.close();

                refreshStudentUpdate();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something Happened").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void refreshStudentUpdate() throws IOException {
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Updated..", yes, no);
        Optional<ButtonType> result = alert.showAndWait();

            if (result.orElse(no) == yes) {
                Stage window = (Stage) studentFormContext.getScene().getWindow();
                window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/studentForm.fxml"))));
            }
    }
}
