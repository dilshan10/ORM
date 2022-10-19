package it.ijse.hibernet.controller;

import it.ijse.hibernet.AppInitializer;
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
import javafx.scene.control.Label;
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
    public TextField txtREDate;
    public TextField txtStatus;
    public TextField txtSid;
    public TextField txtRid;
    public ComboBox cmdSID;
    public ComboBox cmdRid;
    public Label txtREID;
    public Label lblQty;

    ReservationBOImpl reservationBO = BOFactory.getInstance().getBO(BOType.RESERVATION);

    public void initialize(){
        setNewID();
        setAvaQty();
    }

    public void setNewID(){
        String newID = reservationBO.IdGenerator();
        txtREID.setText(newID);
    }

    public void setAvaQty(){
        //String id = txtREID.getText();
        //Integer qty = reservationBO.setAvailableByID(id);
        lblQty.setText(String.valueOf(10));
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
        String date = txtREDate.getText();
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
