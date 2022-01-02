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
import lk.sipsewanainstitute.hibernate.business.custom.RegisterBO;
import lk.sipsewanainstitute.hibernate.business.custom.StudentBO;
import lk.sipsewanainstitute.hibernate.dto.RegisterDTO;
import lk.sipsewanainstitute.hibernate.dto.StudentDTO;
import lk.sipsewanainstitute.hibernate.entity.Register;
import lk.sipsewanainstitute.hibernate.entity.Student;
import lk.sipsewanainstitute.hibernate.view.tm.ProgramDetailTM;
import lk.sipsewanainstitute.hibernate.view.tm.RegisterTM;
import lk.sipsewanainstitute.hibernate.view.tm.StudentDetailTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class allRegisterFormController {
    private final RegisterBO registerBO = (RegisterBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.REGISTER);

    public AnchorPane allRegisterFormContext;
    public TableView<RegisterTM> tblRegisterDetail;
    public TableColumn colRegisterDetailID;
    public TableColumn colRegisterDetailNIC;
    public TableColumn colRegisterDetailName;
    public TableColumn colRegisterDetailAge;
    public TableColumn colRegisterDetailGender;
    public TableColumn colRegisterDetailProgramID;
    public TableColumn colRegisterDetailProgramName;
    public TableColumn colRegisterDetailProgramFee;


    static ArrayList<Register> registerList = new ArrayList();

    public void initialize() {
        colRegisterDetailID.setCellValueFactory(new PropertyValueFactory<>("registerID"));
        colRegisterDetailNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colRegisterDetailName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRegisterDetailAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colRegisterDetailGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colRegisterDetailProgramID.setCellValueFactory(new PropertyValueFactory<>("programID"));
        colRegisterDetailProgramName.setCellValueFactory(new PropertyValueFactory<>("programName"));
        colRegisterDetailProgramFee.setCellValueFactory(new PropertyValueFactory<>("fee"));

        loadAllStudentDetails();

    }

    private void loadAllStudentDetails() {
        tblRegisterDetail.getItems().clear();
        try {
            List<RegisterDTO>allRegistrations = registerBO.findAll();
            for (RegisterDTO allRegistration : allRegistrations) {

//                tblRegisterDetail.getItems().add(new RegisterTM(allRegistration .getRegisterID(),allRegistration .getNic(),allRegistration.getName(),
//                        allRegistration.getAge(), allRegistration.getGender(), allRegistration.getProgramID(),allRegistration.getProgramName(),allRegistration.getFee()));


            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblRegisterDetail.getItems();
    }

    public void backToRegisterDetailDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) allRegisterFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/sipsewanainstitute/hibernate/view/dashBoardForm.fxml"))));
    }
}
