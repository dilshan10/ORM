package it.ijse.hibernet.controller;

import it.ijse.hibernet.bo.BOFactory;
import it.ijse.hibernet.bo.BOType;
import it.ijse.hibernet.bo.custom.impl.StudentBOImpl;
import it.ijse.hibernet.dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;

public class RegisterFormController {
    public AnchorPane root;
    public TextField txtSName;
    public TextField txtSAddress;
    public TextField txtNumber;
    public TextField txtDOB;
    public ComboBox cmdGendr;
    public Label lblSID;

    StudentBOImpl studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);

    public void initialize(){
        setGender();
        setID();
    }

    public void setID(){
        lblSID.setText(studentBO.IdGenerator());
    }
    public void setGender(){
        ObservableList<String> options = FXCollections.observableArrayList("Male","Female");
        cmdGendr.setItems(options);
    }

    public void navigate(MouseEvent mouseEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/main-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void ClickOnNewStudentRegister(ActionEvent actionEvent) throws ParseException {

        String Student_ID = lblSID.getText();
        String Name = txtSName.getText();
        String Address = txtSAddress.getText();
        String Contact_no = txtNumber.getText();
        String Dob = txtDOB.getText();
        String Gender = (String) cmdGendr.getValue();

        try {
            if (studentBO.add(new StudentDTO(Student_ID,Name,Address,Contact_no,Dob,Gender))){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved.!").show();
                //clearFields();
            }else {
                new Alert(Alert.AlertType.ERROR, "Something Happened").show();
            }
        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Something Happened").show();
        }
        clearFields();
    }

    private void clearFields() {
        txtSName.clear();
        txtSAddress.clear();
        txtNumber.clear();
        txtDOB.clear();
        cmdGendr.getItems().clear();
    }

    public void ClickOnStyudentList(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/student-list-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
