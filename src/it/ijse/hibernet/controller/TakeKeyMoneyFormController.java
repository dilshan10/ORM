package it.ijse.hibernet.controller;

import it.ijse.hibernet.bo.BOFactory;
import it.ijse.hibernet.bo.BOType;
import it.ijse.hibernet.bo.custom.impl.ReservationBOImpl;
import it.ijse.hibernet.bo.custom.impl.RoomBOImpl;
import it.ijse.hibernet.bo.custom.impl.StudentBOImpl;
import it.ijse.hibernet.dto.ReservationDTO;
import it.ijse.hibernet.entty.Room;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

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
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalDate currentDate = LocalDate.now();

            String month = "";
            switch (currentDate.getMonthValue()) {
                case 1:
                    month = "Jan";
                    break;
                case 2:
                    month = "Feb";
                    break;
                case 3:
                    month = "March";
                    break;
                case 4:
                    month = "April";
                    break;
                case 5:
                    month = "May";
                    break;
                case 6:
                    month = "June";
                    break;
                case 7:
                    month = "July";
                    break;
                case 8:
                    month = "August";
                    break;
                case 9:
                    month = "Sep";
                    break;
                case 10:
                    month = "Oct";
                    break;
                case 11:
                    month = "Nov";
                    break;
                case 12:
                    month = "Dec";
                    break;
            }
            txtREDate.setText(currentDate.getYear() + "-" + month + "-" + currentDate.getDayOfMonth());


        }),
                 new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
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
        int qty = Integer.parseInt(lblQty.getText());

        int newQty = qty - 1;

        if (qty != 0) {
            try {
                if (reservationBO.add(new ReservationDTO(Rid, date, sid, rid, ststus))) {
                    roomBO.updateRoomQty(newQty, rid);
                    new Alert(Alert.AlertType.CONFIRMATION, "Saved.!").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Something Happened").show();
                    //clearFields();
                }
            } catch (Exception e) {
                System.out.println(e);
                new Alert(Alert.AlertType.ERROR, "Something Happened").show();
            }
            setDefualVal();
        }else {
            new Alert(Alert.AlertType.ERROR,"Room Not Available In This Type, Sorry..!").show();
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

    public void setQtyOnAction(ActionEvent actionEvent) {
        setAvaQty();
    }
}
