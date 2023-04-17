package it.ijse.hibernet.controller;

import it.ijse.hibernet.bo.BOFactory;
import it.ijse.hibernet.bo.BOType;
import it.ijse.hibernet.bo.custom.impl.ReservationBOImpl;
import it.ijse.hibernet.bo.custom.impl.RoomBOImpl;
import it.ijse.hibernet.bo.custom.impl.StudentBOImpl;
import it.ijse.hibernet.dto.ReservationDTO;
import it.ijse.hibernet.entty.Room;
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
    StudentBOImpl studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);
    RoomBOImpl roomBO = BOFactory.getInstance().getBO(BOType.ROOM);

    public void initialize(){
        setNewID();
        loadAllStudentId();
        loadAllRoomId();
        setDate();
    }

    private void setNewID(){
        String newID = reservationBO.IdGenerator();
        txtREID.setText(newID);
    }

    private void setAvaQty(){
        String id = (String) cmdRid.getValue();

        try {
            Room room = roomBO.find(id);
            lblQty.setText(String.valueOf(room.getQTY()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Integer qty = reservationBO.setAvailableByID(id);

    }

    private void loadAllStudentId(){
        try {
            cmdSID.setItems(studentBO.getID());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAllRoomId(){
        try {
            cmdRid.setItems(roomBO.getID());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setDefualVal(){
        setNewID();
        txtStatus.clear();
        lblQty.setText("");
    }

    private void setDate(){
        txtREDate.setText("2022/11/06");
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
        String sid = String.valueOf(cmdSID.getValue());
        String rid = String.valueOf(cmdRid.getValue());
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
        setDefualVal();
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

    public void setQtyOnAction(ActionEvent actionEvent) {
        setAvaQty();
    }
}
