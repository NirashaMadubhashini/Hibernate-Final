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
import lk.sipsewanainstitute.hibernate.business.custom.impl.StudentBOImpl;
import lk.sipsewanainstitute.hibernate.dto.StudentDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

import static lk.sipsewanainstitute.hibernate.business.BOFactory.getBOFactory;

public class updateStudentFormController {
//    public AnchorPane updateStudentFormContext;
//    public TextField txtUpdateName;
//    public TextField txtUpdateAddress;
//    public TextField txtUpdateAge;
//    public TextField txtUpdateMobile;
//    public TextField txtUpdateGender;
//    public TextField txtUpdateBirthDay;
//    public JFXButton btnUpdateStudent;
//    public String nic;
//
//    private final StudentBO studentBO = (StudentBO) getBOFactory().getBO(BOFactory.BoTypes.STUDENT);
//
//
//    public void UpdateStudentOnAction(ActionEvent actionEvent) {
//        String name = txtUpdateName.getText();
//        String birthDay = txtUpdateBirthDay.getText();
//        String address = txtUpdateAddress.getText();
//        int age = Integer.parseInt(txtUpdateAge.getText());
//        String mobileNumber = txtUpdateMobile.getText();
//        String gender = txtUpdateGender.getText();
//
//        try {
//            if (studentBO.update(new StudentDTO(
//                    name,
//                    birthDay,
//                    address,
//                    age,
//                    mobileNumber,
//                    gender
//            )));{
//                boolean update = studentBO.update(customerDTO);
//
//                new Alert(Alert.AlertType.CONFIRMATION, "Do you wanna Update it?").showAndWait();
//                txtUpdateName.setText(null);
//                txtUpdateBirthDay.setText(null);
//                txtUpdateAddress.setText(null);
//                txtUpdateAge.setText(null);
//                txtUpdateMobile.setText(null);
//                txtUpdateGender.setText(null);
//            }
//            Stage stage = (Stage)btnUpdateStudent.getScene().getWindow();
//            stage.close();
//
//
//
//        } catch (Exception e) {
//            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
//        }
//
//    }
//
//    private void refreshCustomerUpdate(boolean update) throws IOException {
//        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
//        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Updated..", yes, no);
//        Optional<ButtonType> result = alert.showAndWait();
//        if (update) {
//            if (result.orElse(no) == yes) {
//                Stage window = (Stage) updateStudentFormContext.getScene().getWindow();
//                window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ManageCustomerForm.fxml"))));
//            }
//        } else {
//            new Alert(Alert.AlertType.ERROR, "Failed to update the Item ", ButtonType.CLOSE).show();
//        }
//    }
}
