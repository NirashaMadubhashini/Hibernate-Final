package lk.sipsewanainstitute.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.sipsewanainstitute.hibernate.entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class registerFormController {
    public AnchorPane registerFormContext;
    public TextField txtRegisterDate;
    public TextField txtRegisterTime;
    public TextField txtRegisterStudentID;
    public ComboBox cmdRegisterNIC;
    public TextField txtRegisterFullName;
    public TextField txtRegisterBirthDay;
    public TextField txtRegisterAddress;
    public TextField txtRegisterAge;
    public TextField txtRegisterGender;
    public TextField txtRegisterMobile;
    public ComboBox cmdRegisterProgramID;
    public TextField txtRegisterProgramName;
    public TextField txtRegisterProgramDuration;
    public TextField txtRegisterProgramFee;
    public TableView tblRegistration;
    public TableColumn colRegisterID;
    public TableColumn colRegisterNIC;
    public TableColumn colRegisterName;
    public TableColumn colRegisterAge;
    public TableColumn colRegisterGender;
    public TableColumn colRegisterProgramID;
    public TableColumn colRegisterProgramName;
    public TableColumn colRegisterProgramFee;
    public Label lblTotalPayment;
    public JFXButton btnAddRegistration;
    public JFXButton btnConformRegister;
    public JFXButton btnCancelRegister;

    public void initialize() throws IOException, SQLException, ClassNotFoundException {

        loadDateAndTime();

    }

    private void loadDateAndTime() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        txtRegisterDate.setText(f.format(date));

        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            txtRegisterTime.setText(
                    currentTime.getHour() + " : " + currentTime.getMinute() +
                            " : " + currentTime.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void makeRegisterOnAction(ActionEvent actionEvent) {
    }

    public void cancelRegisterOnAction(ActionEvent actionEvent) {
    }

    public void addRegisterOnAction(ActionEvent actionEvent) {
    }

    public void backToRegisterDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) registerFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/sipsewanainstitute/hibernate/view/dashBoardForm.fxml"))));
    }
}
