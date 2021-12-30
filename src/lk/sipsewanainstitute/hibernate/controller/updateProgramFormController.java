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
import lk.sipsewanainstitute.hibernate.business.custom.ProgramBO;
import lk.sipsewanainstitute.hibernate.business.custom.StudentBO;
import lk.sipsewanainstitute.hibernate.dto.ProgramDTO;
import lk.sipsewanainstitute.hibernate.dto.StudentDTO;

import java.io.IOException;
import java.util.Optional;

import static lk.sipsewanainstitute.hibernate.business.BOFactory.getBOFactory;

public class updateProgramFormController {
    public static AnchorPane programFormContext;
    public AnchorPane updateProgramFormContext;
    public TextField txtUpdateProgram;
    public TextField txtUpdateFee;
    public TextField txtUpdateDuration;
    public String programId;
    public String date;
    public String time;
    public JFXButton btnUpdateProgram;

    private final ProgramBO programBO = (ProgramBO) getBOFactory().getBO(BOFactory.BoTypes.PROGRAM);


    public void UpdateProgramOnAction(ActionEvent actionEvent) {
        try {
            if (programBO.update(new ProgramDTO(
                    programId,
                    txtUpdateProgram.getText(),
                    txtUpdateDuration.getText(),
                    Double.parseDouble(txtUpdateFee.getText()),
                    date,
                    time

            ))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated").showAndWait();

                Stage stage = (Stage) btnUpdateProgram.getScene().getWindow();
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
                Stage window = (Stage) programFormContext.getScene().getWindow();
                window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/programForm.fxml"))));
            }
    }

}
