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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;

public class ReservationUpdateDeleteFormController {
    public TextField txtreID;
    public TextField txtDate;
    public TextField txtsID;
    public TextField txtRid;
    public TextField txtStatus;
    public AnchorPane root;
    public ComboBox cmdSearch;

    ReservationBOImpl reservationBO = BOFactory.getInstance().getBO(BOType.RESERVATION);

    public void initialize(){
        setResId();
    }

    private void setResId(){
        cmdSearch.setItems(reservationBO.getAllID());
    }

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
        txtreID.clear();
        txtDate.clear();
        txtsID.clear();
        txtRid.clear();
        txtStatus.clear();
    }

    public void ClickOnDeleteOnAction(ActionEvent actionEvent) throws Exception {
        if(reservationBO.delete(String.valueOf(cmdSearch.getValue()))){
            new Alert(Alert.AlertType.INFORMATION,"Reservation Deleted...").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Something Happened").show();
        }
    }

    public void ClickSearchOnAction(ActionEvent actionEvent) throws Exception {
        String id = String.valueOf(cmdSearch.getValue());
        search(id);
    }
    private void search(String id) throws Exception {
        Reservation reservation = reservationBO.find(id);
        txtreID.setText(reservation.getRes_id());
        txtDate.setText(reservation.getDATE());
        txtsID.setText(reservation.getStudent_id());
        txtRid.setText(reservation.getRoom_type_id());
        txtStatus.setText(reservation.getStatus());
    }

    public void clickOnBack(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/takeKeyMoney-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
