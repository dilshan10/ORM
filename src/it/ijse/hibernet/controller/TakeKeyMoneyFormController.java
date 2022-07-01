package it.ijse.hibernet.controller;

import it.ijse.hibernet.bo.BOFactory;
import it.ijse.hibernet.bo.BOType;
import it.ijse.hibernet.bo.custom.impl.ReservationBOImpl;
import it.ijse.hibernet.bo.custom.impl.RoomBOImpl;
import it.ijse.hibernet.bo.custom.impl.StudentBOImpl;
import it.ijse.hibernet.dto.ReservationDTO;
import it.ijse.hibernet.dto.StudentDTO;
import it.ijse.hibernet.entty.Reservation;
import it.ijse.hibernet.entty.Room;
import it.ijse.hibernet.entty.Student;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TakeKeyMoneyFormController {
    public AnchorPane root;
    public TextField txtREID;
    public TextField txtREDate;
    public TextField txtStatus;
    public ComboBox cmdSID;
    public ComboBox cmdRid;
    public TextField txtSid;
    public TextField txtRid;

    ReservationBOImpl reservationBO = BOFactory.getInstance().getBO(BOType.RESERVATION);
    StudentBOImpl studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);
    RoomBOImpl roomBO = BOFactory.getInstance().getBO(BOType.ROOM);

    public void initialize() throws Exception {
       // setRID();
       // setSID();
     }
     public void setSID() throws Exception {
         List<Student> list = studentBO.getID();
         cmdSID.setItems((ObservableList) list);
     }
     public void setRID() throws Exception {
         List<Room> list = roomBO.getID();
         cmdRid.setItems((ObservableList) list);
     }

    public void navigate(MouseEvent mouseEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/main-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void ClickAddReservationOnAction(ActionEvent actionEvent) throws ParseException {
        String Rid = txtREID.getText();
        Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(txtREDate.getText());
        String sid = txtSid.getText();
        String rid = txtRid.getText();
        String ststus = txtStatus.getText();

        try {
            if (reservationBO.add(new ReservationDTO(Rid,date,sid,rid,ststus))){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved.!").show();
                //clearFields();
            }else {
                new Alert(Alert.AlertType.ERROR, "Something Happened").show();
            }
        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Something Happened").show();
        }
    }

    public void ClickOnList(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/reservation-list-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void ClickOnUpdateDeleteAction(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/reservation-update-delete-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
