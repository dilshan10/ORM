package it.ijse.hibernet.controller;

import it.ijse.hibernet.bo.BOFactory;
import it.ijse.hibernet.bo.BOType;
import it.ijse.hibernet.bo.custom.impl.StudentBOImpl;
import it.ijse.hibernet.dto.StudentDTO;
import it.ijse.hibernet.entty.Student;
import it.ijse.hibernet.util.FactoryConfiguration;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class UpdateStudentFormController {
    public AnchorPane root;
    public TextField txtSearch;
    public Label lblStudentID;
    public TextField txtStudentName;
    public TextField txtDateOfBrith;
    public TextField txtGender;
    public TextField txtconNumber;
    public TextField txtStudentAddress;

    StudentBOImpl studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);

    private void clearFields() {
       txtSearch.clear();
       lblStudentID.setText("");
       txtStudentName.clear();
       txtStudentAddress.clear();
       txtconNumber.clear();
       txtDateOfBrith.clear();
       txtGender.clear();
    }

    public void navigate(MouseEvent mouseEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/main-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void SearchOnAction(ActionEvent actionEvent) throws Exception {
        Student student = studentBO.find(txtSearch.getText());

        lblStudentID.setText(student.getStudent_ID());
        txtStudentName.setText(student.getName());
        txtStudentAddress.setText(student.getAddress());
        txtconNumber.setText(student.getContact_no());
        txtDateOfBrith.setText(student.getDob());
        txtGender.setText(student.getGender());

    }

    public void ClickUpdateOnAction(ActionEvent actionEvent) {

        String Student_ID = lblStudentID.getText();
        String Name = txtStudentName.getText();
        String Address = txtStudentAddress.getText();
        String Contact_no = txtconNumber.getText();
        String DOB = txtDateOfBrith.getText();
        String Gender = txtGender.getText();

        try{
            if (studentBO.update(new StudentDTO(Student_ID,Name,Address,Contact_no,DOB,Gender))){
                new Alert(Alert.AlertType.CONFIRMATION, "Updated.!").show();
                //clearFields();
            }else {
                new Alert(Alert.AlertType.ERROR, "Something Happened").show();
            }
        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Something Happened").show();
        }

    }

    public void ClickDeleteOnAction(ActionEvent actionEvent) throws Exception {
        studentBO.delete(txtSearch.getText());
    }
}
