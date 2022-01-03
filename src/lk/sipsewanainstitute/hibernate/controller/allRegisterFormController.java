package lk.sipsewanainstitute.hibernate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.sipsewanainstitute.hibernate.business.BOFactory;
import lk.sipsewanainstitute.hibernate.business.custom.ProgramBO;
import lk.sipsewanainstitute.hibernate.business.custom.RegisterBO;
import lk.sipsewanainstitute.hibernate.business.custom.StudentBO;
import lk.sipsewanainstitute.hibernate.dto.RegisterDTO;
import lk.sipsewanainstitute.hibernate.dto.StudentDTO;
import lk.sipsewanainstitute.hibernate.view.tm.RegisterTM;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class allRegisterFormController {
    private final RegisterBO registerBO = (RegisterBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.REGISTER);
    private final StudentBO studentBO = (StudentBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.STUDENT);
    private final ProgramBO programBO = (ProgramBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.PROGRAM);

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
            List<RegisterDTO> allRegister= registerBO.findAll();
            for (RegisterDTO registerDTO :allRegister) {
                tblRegisterDetail.getItems().add(new RegisterTM(registerDTO.getRegisterID(),registerDTO.getNic(),registerDTO.getName(),registerDTO.getAge(),
                        registerDTO.getGender(),registerDTO.getProgramID(),registerDTO.getProgramName(),registerDTO.getFee()));
            }

//            List<StudentDTO> allStudents= studentBO.findAll();
//            for (StudentDTO studentDTO :allStudents) {
//                tblRegisterDetail.getItems().add(new RegisterTM(studentDTO.getNic(),studentDTO.getName(),studentDTO.getAge(),
//                        studentDTO.getGender()));
//            }
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
