package it.ijse.hibernet.controller;

import it.ijse.hibernet.bo.BOFactory;
import it.ijse.hibernet.bo.BOType;
import it.ijse.hibernet.bo.custom.impl.StudentBOImpl;
import it.ijse.hibernet.entty.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    private ObservableList<Student> obList = null;

    StudentBOImpl studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);

    public void initialize() throws Exception {
        tblID.setCellValueFactory(new PropertyValueFactory<>("student_ID"));
        tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblAddres.setCellValueFactory(new PropertyValueFactory<>("address"));
        tblContactNu.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        tblDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        loadAllStudents();
    }

    private void loadAllStudents() {
        List<Student> allStudents = null;
            try {
                allStudents = studentBO.findAll();
                obList = FXCollections.observableArrayList(allStudents);
                tblStudent.setItems(obList);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
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
