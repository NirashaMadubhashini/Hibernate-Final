package lk.sipsewanainstitute.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.sipsewanainstitute.hibernate.business.BOFactory;
import lk.sipsewanainstitute.hibernate.business.custom.StudentBO;
import lk.sipsewanainstitute.hibernate.dto.StudentDTO;
import lk.sipsewanainstitute.hibernate.view.tm.StudentTM;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static lk.sipsewanainstitute.hibernate.business.BOFactory.getBOFactory;

public class studentFormController {
    public AnchorPane studentFormContext;
    public TextField txtName;
    public TextField txtStudentDate;
    public TextField txtStudentTime;
    public TextField txtAddress;
    public TextField txtMobile;
    public TextField txtNIC;
    public TextField txtBirth;
    public TextField txtAge;
    public TableView<StudentTM> tblStudent;
    public TableColumn colName;
    public TableColumn colNIC;
    public TableColumn colBirthDay;
    public TableColumn colAddress;
    public TableColumn colAge;
    public TableColumn colMobile;
    public TableColumn colGender;
    public TableColumn colDate;
    public TableColumn colTime;
    public TableColumn colUpdate;
    public TableColumn colDelete;
    public ComboBox<String> cmdGender;
    public JFXButton btnAddStudent;

    private final StudentBO studentBO = (StudentBO) getBOFactory().getBO(BOFactory.BoTypes.STUDENT);


    public void initialize() throws Exception {

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colBirthDay.setCellValueFactory(new PropertyValueFactory<>("birthDay"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colUpdate.setCellValueFactory(new PropertyValueFactory<>("update"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));


        loadDateAndTime();
        tableListener();
        loadAllStudent();

        cmdGender.getItems().addAll("Male", "Female");

        updateStudentFormController.studentFormContext =studentFormContext;
    }

    private void tableListener() {
        tblStudent.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData(newValue);
                });
    }

    private void setData(StudentTM tm) {
        try {
            txtNIC.setText(tm.getNic());
            txtName.setText(tm.getName());
            txtBirth.setText(tm.getBirthDay());
            txtAddress.setText(tm.getAddress());
            txtAge.setText(String.valueOf(tm.getAge()));
            txtMobile.setText(tm.getMobileNumber());
            cmdGender.setValue(tm.getGender());
            txtStudentDate.setText(tm.getDate());
            txtStudentTime.setText(tm.getTime());
        } catch (Exception e) {

        }
    }

    private void loadDateAndTime() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        txtStudentDate.setText(f.format(date));

        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            txtStudentTime.setText(
                    currentTime.getHour() + " : " + currentTime.getMinute() +
                            " : " + currentTime.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    boolean existStudent(String nic) throws SQLException, ClassNotFoundException {
        return studentBO.ifStudentExist(nic);
    }

    public void addNewStudentOnAction(ActionEvent actionEvent) throws Exception {
        String nic = txtNIC.getText();
        String name = txtName.getText();
        String birthDay = txtBirth.getText();
        String address = txtAddress.getText();
        int age = Integer.parseInt(txtAge.getText());
        String mobileNumber = txtMobile.getText();
        String gender = cmdGender.getValue();
        String date = txtStudentDate.getText();
        String time = txtStudentTime.getText();

        try {
            if (existStudent(nic)) {
                new Alert(Alert.AlertType.ERROR, nic + " already exists").show();

            } else {

                StudentDTO studentDTO = new StudentDTO(nic,name, birthDay, address, age, mobileNumber, gender, date, time);
                studentBO.add(studentDTO);

                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to save the customer " + e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        loadAllStudent();
    }

    private void loadAllStudent() throws Exception {
        tblStudent.getItems().clear();
        try {
            List<StudentDTO> all = studentBO.findAll();
            for (StudentDTO allStudents: all) {

                Button btnUpdate = new Button("Update");
                Button btnDelete = new Button("Delete");

                tblStudent.getItems().add(new StudentTM(allStudents.getName(), allStudents.getNic(), allStudents.getBirthDay(),
                        allStudents.getAddress(), allStudents.getAge(), allStudents.getMobileNumber(), allStudents.getGender(), allStudents.getDate(), allStudents.getTime(),
                        btnUpdate, btnDelete));

                btnDelete.setOnAction((e) -> {
                    ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "Are you sure you want to delete this Supplier?", yes, no);
                    alert.setTitle("Conformation Alert");
                    Optional<ButtonType> result = alert.showAndWait();

                    if (result.orElse(no) == yes) {

                        try {
                            delete(allStudents);
                            all.remove(allStudents);
                            loadAllStudent();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }

                    }

                });

                btnUpdate.setOnAction((e) -> {
                    try {
                        showUpdateForm(allStudents);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                });

            }

        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    private void delete(StudentDTO dto) throws Exception {
        String name = tblStudent.getSelectionModel().getSelectedItem().getNic();
        try {
            if (!existStudent(name)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully Deleted.. " + name).show();
            }
            studentBO.delete(name);
            tblStudent.getItems().remove(tblStudent.getSelectionModel().getSelectedItem());
            tblStudent.getSelectionModel().clearSelection();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the customer " + name).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void showUpdateForm(StudentDTO table) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/lk/sipsewanainstitute/hibernate/view/updateStudentForm.fxml"));
        Parent parent = loader.load();
        updateStudentFormController controller= loader.<updateStudentFormController>getController();
        controller.txtUpdateName.setText(table.getName());
        controller.txtUpdateBirthDay.setText(table.getBirthDay());
        controller.txtUpdateAddress.setText(table.getAddress());
        controller.txtUpdateAge.setText(String.valueOf(table.getAge()));
        controller.txtUpdateGender.setText(table.getGender());
        controller.txtUpdateMobile.setText(table.getMobileNumber());
        controller.nic=table.getNic();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
    }
    public void backToStudentDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) studentFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/sipsewanainstitute/hibernate/view/dashBoardForm.fxml"))));
    }
}