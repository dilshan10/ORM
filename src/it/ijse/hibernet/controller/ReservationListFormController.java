package it.ijse.hibernet.controller;

import it.ijse.hibernet.bo.BOFactory;
import it.ijse.hibernet.bo.BOType;
import it.ijse.hibernet.bo.custom.impl.ReservationBOImpl;
import it.ijse.hibernet.entty.Reservation;
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

public class ReservationListFormController {

    public AnchorPane root;
    public TableView<Reservation>tblReservation;
    public TableColumn tblRId;
    public TableColumn tblRDate;
    public TableColumn tblStudentId;
    public TableColumn tblRoomTypeId;
    public TableColumn tblStatus;

    ReservationBOImpl reservationBO = BOFactory.getInstance().getBO(BOType.RESERVATION);

    public void initialize() throws Exception {
        tblReservation.getItems().addAll(reservationBO.findAll());
        tblRId.setCellValueFactory(new PropertyValueFactory<Student, Long>("res_id"));
        tblRDate.setCellValueFactory(new PropertyValueFactory<Student, Long>("DATE"));
        tblStudentId.setCellValueFactory(new PropertyValueFactory<Student, Long>("student_id"));
        tblRoomTypeId.setCellValueFactory(new PropertyValueFactory<Student, Long>("room_type_id"));
        tblStatus.setCellValueFactory(new PropertyValueFactory<Student, Long>("status"));


    }

    public void navigate(MouseEvent mouseEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/main-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void ClickBackOnAction(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/takeKeyMoney-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
