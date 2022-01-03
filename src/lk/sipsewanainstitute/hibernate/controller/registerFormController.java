package lk.sipsewanainstitute.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.sipsewanainstitute.hibernate.business.BOFactory;
import lk.sipsewanainstitute.hibernate.business.custom.RegisterBO;
import lk.sipsewanainstitute.hibernate.business.custom.impl.RegisterBOImpl;
import lk.sipsewanainstitute.hibernate.dto.*;
import lk.sipsewanainstitute.hibernate.entity.Register;
import lk.sipsewanainstitute.hibernate.view.tm.RegisterTM;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class registerFormController {
    public AnchorPane registerFormContext;
    public TextField txtRegisterDate;
    public TextField txtRegisterTime;
    public TextField txtRegisterStudentID;
    public ComboBox<String> cmdRegisterNIC;
    public TextField txtRegisterFullName;
    public TextField txtRegisterBirthDay;
    public TextField txtRegisterAddress;
    public TextField txtRegisterAge;
    public TextField txtRegisterGender;
    public TextField txtRegisterMobile;
    public ComboBox<String> cmdRegisterProgramID;
    public TextField txtRegisterProgramName;
    public TextField txtRegisterProgramDuration;
    public TextField txtRegisterProgramFee;
    public TableView<RegisterTM> tblRegistration;
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

    private String registerID;

    int cartSelectedRowForRemove = -1;

    private final RegisterBO registerBO = (RegisterBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.REGISTER);

    public void initialize() throws IOException, SQLException, ClassNotFoundException {

        colRegisterID.setCellValueFactory(new PropertyValueFactory<>("registerID"));
        colRegisterNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colRegisterName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRegisterAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colRegisterGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colRegisterProgramID.setCellValueFactory(new PropertyValueFactory<>("programID"));
        colRegisterProgramName.setCellValueFactory(new PropertyValueFactory<>("programName"));
        colRegisterProgramFee.setCellValueFactory(new PropertyValueFactory<>("fee"));

        cmdRegisterNIC.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                StudentDTO studentDTO = registerBO.findStudent(newValue + "");
                txtRegisterFullName.setText(studentDTO.getName());
                txtRegisterBirthDay.setText(studentDTO.getBirthDay());
                txtRegisterAddress.setText(studentDTO.getAddress());
                txtRegisterAge.setText(String.valueOf(studentDTO.getAge()));
                txtRegisterGender.setText(studentDTO.getGender());
                txtRegisterMobile.setText(studentDTO.getMobileNumber());

            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to find the Student " + newValue + "" + e).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        cmdRegisterProgramID.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                ProgramDTO programDTO = registerBO.findProgram(newValue + "");
                txtRegisterProgramName.setText(programDTO.getProgramName());
                txtRegisterProgramDuration.setText(programDTO.getDuration());
                txtRegisterProgramFee.setText(String.valueOf(programDTO.getFee()));
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to find the Program " + newValue + "" + e).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        tblRegistration.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            cartSelectedRowForRemove = (int) newValue;
        });

        registerID = generateRegisterId();
        txtRegisterStudentID.setText(registerID);


        loadStudentIds();
        loadProgramIds();
        loadDateAndTime();

    }

    private void loadProgramIds() {
        try {
            ArrayList<ProgramDTO> all = registerBO.getAllPrograms();
            for (ProgramDTO dto : all) {
                cmdRegisterProgramID.getItems().add(dto.getProgramID());
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to load Program ids").show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadStudentIds() {
        try {
            ArrayList<StudentDTO> all = registerBO.getAllStudents();
            for (StudentDTO studentDTO : all) {
                cmdRegisterNIC.getItems().add(studentDTO.getNic());
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to load Student nics").show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String generateRegisterId() {
        try {
            return registerBO.generateNewOrderId();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate a new Register ID").show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
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

    private int isExists(RegisterTM tm) {
        for (int i = 0; i < obList.size(); i++) {

            if (tm.getNic() == obList.get(i).getProgramID()) {
                return i;
            }
        }
        return -1;
    }

    ObservableList<RegisterTM> obList = FXCollections.observableArrayList();

    public void addRegisterOnAction(ActionEvent actionEvent) {
        try {
            String studentID = txtRegisterStudentID.getText();
            String nic = String.valueOf(cmdRegisterNIC.getValue());
            String name = txtRegisterFullName.getText();
            int age = Integer.parseInt(txtRegisterAge.getText());
            String gender = txtRegisterGender.getText();
            String programId = String.valueOf(cmdRegisterProgramID.getValue());
            String programName = txtRegisterProgramName.getText();
            double fee = Double.parseDouble(txtRegisterProgramFee.getText());


            RegisterTM tm = new RegisterTM(
                    studentID,
                    nic,
                    name,
                    age,
                    gender,
                    programId,
                    programName,
                    fee
            );
            int rowNumber = isExists(tm);

            if (rowNumber == -1) {
                obList.add(tm);
            } else {
                RegisterTM temp = obList.get(rowNumber);
                RegisterTM newTm = new RegisterTM(
                        temp.getRegisterID(),
                        temp.getNic(),
                        temp.getName(),
                        temp.getAge(),
                        temp.getGender(),
                        temp.getProgramID(),
                        temp.getProgramName(),
                        temp.getFee()
                );

                obList.remove(rowNumber);
                obList.add(newTm);
            }
            tblRegistration.setItems(obList);
            calculateCost();


        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
            e.printStackTrace();
        }
    }

    public void makeRegisterOnAction(ActionEvent actionEvent) throws Exception {
        RegistrationDTO registrationDTO= new RegistrationDTO(
                txtRegisterStudentID.getText(),
                String.valueOf(cmdRegisterNIC.getValue()),
                String.valueOf(cmdRegisterProgramID.getValue()),
                txtRegisterDate.getText(),
                txtRegisterTime.getText(),
                tblRegistration.getItems().stream().map(tm ->
                        new RegisterDetailDTO(tm.getProgramID(),tm.getNic())).collect(Collectors.toList())


        );

        if (registerBO.purchaseOrder(registrationDTO)) {
            new Alert(Alert.AlertType.INFORMATION, "Registered Successfully").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Try Again ").show();
        }

        registerID = generateRegisterId();
        txtRegisterStudentID.setText(generateRegisterId());
        tblRegistration.getItems().clear();
        clearText();
        calculateCost();
    }

    private void calculateCost() {
        double ttl = 0;
        for (RegisterTM tm : obList
        ) {
            ttl += tm.getFee();
        }
        lblTotalPayment.setText(ttl + " /=");
    }

    public void cancelRegisterOnAction(ActionEvent actionEvent) {
        if (cartSelectedRowForRemove == -1) {
            new Alert(Alert.AlertType.WARNING, "Please Select a row").show();
        } else {
            obList.remove(cartSelectedRowForRemove);
            calculateCost();
            tblRegistration.refresh();
        }
    }


    private void clearText() {
        txtRegisterFullName.setText("");
        txtRegisterBirthDay.setText("");
        txtRegisterAddress.setText("");
        txtRegisterAge.setText("");
        txtRegisterGender.setText("");
        txtRegisterMobile.setText("");
        txtRegisterProgramName.setText("");
        txtRegisterProgramDuration.setText("");
        txtRegisterProgramFee.setText("");
        lblTotalPayment.setText("");

        for (int i = 0; i < tblRegistration.getItems().size(); i++) {
            tblRegistration.getItems().clear();
        }
    }

    public void backToRegisterDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) registerFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/sipsewanainstitute/hibernate/view/dashBoardForm.fxml"))));
    }
}
