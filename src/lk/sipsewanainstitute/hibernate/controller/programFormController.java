package lk.sipsewanainstitute.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class programFormController {
    public AnchorPane programFormContext;
    public TextField txtProgramID;
    public TextField txtProgramName;
    public TextField txtProgramDuration;
    public TextField txtProgramFee;
    public TextField txtProgramDate;
    public TextField txtProgramTime;
    public TableView tblProgram;
    public TableColumn colProgramID;
    public TableColumn colProgramName;
    public TableColumn colProgramDuration;
    public TableColumn colProgramFee;
    public TableColumn colProgramDate;
    public TableColumn colProgramTime;
    public TableColumn colProgramUpdate;
    public TableColumn colProgramDelete;
    public JFXButton btnAddProgram;

    public void initialize() throws IOException, SQLException, ClassNotFoundException {

        loadDateAndTime();

    }

    private void loadDateAndTime() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        txtProgramDate.setText(f.format(date));

        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            txtProgramTime.setText(
                    currentTime.getHour() + " : " + currentTime.getMinute() +
                            " : " + currentTime.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }


    public void addNewProgramOnAction(ActionEvent actionEvent) {
    }

    public void backToProgramDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) programFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/sipsewanainstitute/hibernate/view/dashBoardForm.fxml"))));
    }
}
