package lk.sipsewanainstitute.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.sipsewanainstitute.hibernate.business.BOFactory;
import lk.sipsewanainstitute.hibernate.business.custom.ProgramBO;
import lk.sipsewanainstitute.hibernate.dto.ProgramDTO;
import lk.sipsewanainstitute.hibernate.view.tm.ProgramTM;


import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static lk.sipsewanainstitute.hibernate.business.BOFactory.getBOFactory;

public class programFormController {
    public AnchorPane programFormContext;
    public TextField txtProgramID;
    public TextField txtProgramName;
    public TextField txtProgramDuration;
    public TextField txtProgramFee;
    public TextField txtProgramDate;
    public TextField txtProgramTime;
    public TableView<ProgramTM> tblProgram;
    public TableColumn colProgramID;
    public TableColumn colProgramName;
    public TableColumn colProgramDuration;
    public TableColumn colProgramFee;
    public TableColumn colProgramDate;
    public TableColumn colProgramTime;
    public TableColumn colProgramUpdate;
    public TableColumn colProgramDelete;
    public JFXButton btnAddProgram;

    private final ProgramBO programBO = (ProgramBO) getBOFactory().getBO(BOFactory.BoTypes.PROGRAM);


    public void initialize() throws IOException, SQLException, ClassNotFoundException {
        colProgramID.setCellValueFactory(new PropertyValueFactory<>("programID"));
        colProgramName.setCellValueFactory(new PropertyValueFactory<>("programName"));
        colProgramDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colProgramFee.setCellValueFactory(new PropertyValueFactory<>("fee"));
        colProgramDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colProgramTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colProgramUpdate.setCellValueFactory(new PropertyValueFactory<>("update"));
        colProgramDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));

        loadDateAndTime();
        tableListener();
    }

    private void tableListener() {
        tblProgram.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData(newValue);
                });
    }

    private void setData(ProgramTM tm) {
        txtProgramID.setText(tm.getProgramID());
        txtProgramName.setText(tm.getProgramName());
        txtProgramDuration.setText(tm.getDuration());
        txtProgramFee.setText(String.valueOf(tm.getFee()));
        txtProgramDate.setText(tm.getDate());
        txtProgramTime.setText(tm.getTime());
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

    boolean existProgram(String id) throws SQLException, ClassNotFoundException {
        return programBO.ifProgramExist(id);
    }

    public void addNewProgramOnAction(ActionEvent actionEvent) {
        String programID = txtProgramID.getText();
        String programName = txtProgramName.getText();
        String programDuration = txtProgramDuration.getText();
        double parseFee = Double.parseDouble(txtProgramFee.getText());
        String programDate = txtProgramDate.getText();
        String programTime = txtProgramTime.getText();

        try {
            if (existProgram(programID)) {
                new Alert(Alert.AlertType.ERROR, programID + " already exists").show();

            } else {
                ProgramDTO programDTO= new ProgramDTO(programID, programName, programDuration, parseFee, programDate,programTime);
                programBO.add(programDTO);

                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to save the customer " + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        loadAllStudent();
    }

    private void loadAllStudent() {
        tblProgram.getItems().clear();
        try {
            List<ProgramDTO> all = programBO.findAll();
            for (ProgramDTO allPrograms : all) {

                Button btnUpdate = new Button("Update");
                Button btnDelete = new Button("Delete");

                tblProgram.getItems().add(new ProgramTM(allPrograms.getProgramID(), allPrograms.getProgramName(), allPrograms.getDuration(),
                        allPrograms.getFee(), allPrograms.getDate(),allPrograms.getTime(),btnUpdate, btnDelete));

                btnDelete.setOnAction((e) -> {
                    ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "Are you sure you want to delete this Supplier?", yes, no);
                    alert.setTitle("Conformation Alert");
                    Optional<ButtonType> result = alert.showAndWait();

                    if (result.orElse(no) == yes) {

                        try {
//                            delete(allPrograms);
                            all.remove(allPrograms);
                            loadAllStudent();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }

                    }

                });

                btnUpdate.setOnAction((e) -> {
                    try {
//                        showUpdateForm(allStudent);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                });

            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backToProgramDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) programFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/sipsewanainstitute/hibernate/view/dashBoardForm.fxml"))));
    }
}
