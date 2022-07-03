package it.ijse.hibernet.controller;

import it.ijse.hibernet.bo.BOFactory;
import it.ijse.hibernet.bo.BOType;
import it.ijse.hibernet.bo.custom.impl.ReservationBOImpl;
import it.ijse.hibernet.dto.ReservationDTO;
import it.ijse.hibernet.entty.Reservation;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReservationUpdateDeleteFormController {
    public TextField txtSearch;
    public TextField txtreID;
    public TextField txtDate;
    public TextField txtsID;
    public TextField txtRid;
    public TextField txtStatus;
    public AnchorPane root;

    ReservationBOImpl reservationBO = BOFactory.getInstance().getBO(BOType.RESERVATION);

    public void navigate(MouseEvent mouseEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/main-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void ClickUpdateonAction(ActionEvent actionEvent) throws ParseException {
        String Rid = txtreID.getText();
        String date = txtDate.getText();
        String sid = txtsID.getText();
        String rid = txtRid.getText();
        String ststus = txtStatus.getText();

        try {
            if (reservationBO.update(new ReservationDTO(Rid,date,sid,rid,ststus))){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved.!").show();
                clearFields();
            }else {
                new Alert(Alert.AlertType.ERROR, "Something Happened").show();
            }
        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Something Happened").show();
        }
    }

    private void clearFields() {
    }

    public void ClickOnDeleteOnAction(ActionEvent actionEvent) throws Exception {
        reservationBO.delete(txtSearch.getText());
    }

    public void ClickSearchOnAction(ActionEvent actionEvent) throws Exception {
        Reservation reservation = reservationBO.find(txtSearch.getText());
        txtreID.setText(reservation.getRes_id());
        txtDate.setText(reservation.getDATE());
        txtsID.setText(reservation.getStudent_id());
        txtRid.setText(reservation.getRoom_type_id());
        txtStatus.setText(reservation.getStatus());
    }
}
