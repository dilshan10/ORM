package it.ijse.hibernet.controller;

import it.ijse.hibernet.bo.BOFactory;
import it.ijse.hibernet.bo.BOType;
import it.ijse.hibernet.bo.custom.impl.StudentBOImpl;
import it.ijse.hibernet.entty.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class StudentListFormController {
    public AnchorPane root;
    public TableView<Student> tblStudent;
    public TableColumn tblID;
    public TableColumn tblName;
    public TableColumn tblAddres;
    public TableColumn tblContactNu;
    public TableColumn tblDOB;
    public TableColumn tblGender;

    StudentBOImpl studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);

    public void initialize() throws Exception {
        tblID.setCellValueFactory(new PropertyValueFactory<Student, Long>("student_ID"));
        tblName.setCellValueFactory(new PropertyValueFactory<Student, Long>("name"));
        tblAddres.setCellValueFactory(new PropertyValueFactory<Student, Long>("address"));
        tblContactNu.setCellValueFactory(new PropertyValueFactory<Student, Long>("contact_no"));
        tblDOB.setCellValueFactory(new PropertyValueFactory<Student, Long>("dob"));
        tblGender.setCellValueFactory(new PropertyValueFactory<Student, Long>("gender"));

        tblStudent.getItems().addAll(studentBO.findAll());
    }

        public void navigate(MouseEvent mouseEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/main-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void clickOnUpdateDeletAction(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/updateStudent-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
