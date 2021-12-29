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
import lk.sipsewanainstitute.hibernate.business.custom.StudentBO;
import lk.sipsewanainstitute.hibernate.dto.StudentDTO;
import lk.sipsewanainstitute.hibernate.view.tm.StudentDetailTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class allStudentFormController {
    private final StudentBO studentBO = (StudentBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.STUDENT);

    public AnchorPane allStudentFormContext;
    public TableView<StudentDetailTM> tblStudentDetail;
    public TableColumn colStudentDetailName;
    public TableColumn colStudentDetailNIC;
    public TableColumn colStudentDetailBirthDay;
    public TableColumn colStudentDetailAddress;
    public TableColumn colStudentDetailAge;
    public TableColumn colStudentDetailMobile;
    public TableColumn colStudentDetailGender;
    public TableColumn colStudentDetailDate;
    public TableColumn colStudentDetailTime;
    public TextField txtSearchStudentNIC;

    public void initialize() {
        colStudentDetailName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colStudentDetailNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colStudentDetailBirthDay.setCellValueFactory(new PropertyValueFactory<>("birthDay"));
        colStudentDetailAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colStudentDetailAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colStudentDetailMobile.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        colStudentDetailGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colStudentDetailDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colStudentDetailTime.setCellValueFactory(new PropertyValueFactory<>("time"));

        loadAllStudentDetails();

    }

    private void loadAllStudentDetails() {
        tblStudentDetail.getItems().clear();
        try {
            List<StudentDTO> allStudent= studentBO.findAll();
            for (StudentDTO allStudents : allStudent) {

                tblStudentDetail.getItems().add(new StudentDetailTM(allStudents.getName(), allStudents.getNic(), allStudents.getBirthDay(),
                         allStudents.getAddress(), allStudents.getAge(), allStudents.getMobileNumber(),allStudents.getGender(),
                        allStudents.getDate(), allStudents.getTime()));

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblStudentDetail.getItems();
    }

    public void backToStudentDetailDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) allStudentFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/sipsewanainstitute/hibernate/view/dashBoardForm.fxml"))));
    }
}
