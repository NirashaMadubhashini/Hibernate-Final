package lk.sipsewanainstitute.hibernate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.sipsewanainstitute.hibernate.business.BOFactory;
import lk.sipsewanainstitute.hibernate.business.custom.ProgramBO;
import lk.sipsewanainstitute.hibernate.business.custom.StudentBO;
import lk.sipsewanainstitute.hibernate.dto.ProgramDTO;
import lk.sipsewanainstitute.hibernate.dto.StudentDTO;
import lk.sipsewanainstitute.hibernate.entity.Student;
import lk.sipsewanainstitute.hibernate.view.tm.ProgramDetailTM;
import lk.sipsewanainstitute.hibernate.view.tm.StudentDetailTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static lk.sipsewanainstitute.hibernate.business.BOFactory.getBOFactory;

public class allProgramFormController {
    public AnchorPane allProgramFormContext;
    public TableView<ProgramDetailTM> tblProgramDetails;
    public TableColumn colProgramDetailID;
    public TableColumn colProgramDetailName;
    public TableColumn colProgramDetailDuration;
    public TableColumn colProgramDetailFee;
    public TableColumn colProgramDetailDate;
    public TableColumn colProgramDetailTime;

    private final ProgramBO programBO = (ProgramBO) getBOFactory().getBO(BOFactory.BoTypes.PROGRAM);

    public void initialize() {
        colProgramDetailID.setCellValueFactory(new PropertyValueFactory<>("programID"));
        colProgramDetailName.setCellValueFactory(new PropertyValueFactory<>("programName"));
        colProgramDetailDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colProgramDetailFee.setCellValueFactory(new PropertyValueFactory<>("fee"));
        colProgramDetailDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colProgramDetailTime.setCellValueFactory(new PropertyValueFactory<>("time"));

        loadAllProgramDetails();

    }

    private void loadAllProgramDetails() {
        tblProgramDetails.getItems().clear();
        try {
            List<ProgramDTO> allProgram= programBO.findAll();
            for (ProgramDTO allPrograms : allProgram) {

                tblProgramDetails.getItems().add(new ProgramDetailTM(allPrograms .getProgramID(), allPrograms .getProgramName(), allPrograms .getDuration(),
                        allPrograms.getFee(), allPrograms .getDate(), allPrograms.getTime()));

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblProgramDetails.getItems();
    }







    public void backToProgramaDetaisDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) allProgramFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/sipsewanainstitute/hibernate/view/dashBoardForm.fxml"))));
    }
}
