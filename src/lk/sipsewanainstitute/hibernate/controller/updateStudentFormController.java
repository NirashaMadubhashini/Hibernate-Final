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

    private final StudentBO studentBO = (StudentBO) getBOFactory().getBO(BOFactory.BoTypes.STUDENT);
    public void initialize() throws IOException {
//        refreshStudentUpdate();
    }


    public void UpdateStudentOnAction(ActionEvent actionEvent) {
//        try {
//            StudentDTO studentDTO = new StudentDTO(nic,txtUpdateName.getText(),txtUpdateBirthDay.getText(),txtUpdateAddress.getText(),
//                    Integer.parseInt(txtUpdateAge.getText()),txtUpdateGender.getText(),txtUpdateMobile.getText());
//            boolean updateStudent = studentBO.update(studentDTO);
//
//            Stage stage = (Stage) btnUpdateStudent.getScene().getWindow();
//            stage.close();
//
//            refreshStudentUpdate(updateStudent);
//
//        } catch (SQLException e) {
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        String name = txtUpdateName.getText();
        String birthDay = txtUpdateBirthDay.getText();
        String address =txtUpdateAddress.getText();
        int age =Integer.parseInt(txtUpdateAge.getText());
        String gender =txtUpdateGender.getText();
        String mobile =txtUpdateMobile.getText();

        try {
            if(studentBO.update(new StudentDTO(
                    nic,
                    name,
                    birthDay,
                    address,
                    age,
                    gender,
                    mobile
            ))){
                studentBO.findAll();
                txtUpdateName.setText(null);
                txtUpdateBirthDay.setText(null);
                txtUpdateAddress.setText(null);
                txtUpdateAge.setText(null);
                txtUpdateGender.setText(null);
                txtUpdateMobile.setText(null);


                Stage stage = (Stage) btnUpdateStudent.getScene().getWindow();
                stage.close();


            }else {
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully Updated...").show();
                refreshStudentUpdate();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened").show();
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
      {
            new Alert(Alert.AlertType.ERROR, "Failed to update the Item ", ButtonType.CLOSE).show();
        }
    }

//    private void refreshStudentUpdate(boolean updateStudent) throws IOException {
//        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
//        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Updated..", yes, no);
//        Optional<ButtonType> result = alert.showAndWait();
//        if (updateStudent) {
//            if (result.orElse(no) == yes) {
//                Stage window = (Stage) studentFormContext.getScene().getWindow();
//                window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/studentForm.fxml"))));
//            }
//        } else {
//            new Alert(Alert.AlertType.ERROR, "Failed to update the Item ", ButtonType.CLOSE).show();
//        }
//    }
}
