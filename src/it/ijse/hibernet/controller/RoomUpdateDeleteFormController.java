package it.ijse.hibernet.controller;

import it.ijse.hibernet.bo.BOFactory;
import it.ijse.hibernet.bo.BOType;
import it.ijse.hibernet.bo.custom.impl.RoomBOImpl;
import it.ijse.hibernet.dto.RoomDTO;
import it.ijse.hibernet.dto.StudentDTO;
import it.ijse.hibernet.entty.Room;
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

public class RoomUpdateDeleteFormController {
    public AnchorPane root;
    public TextField txtSearch;
    public TextField txtRoomType;
    public TextField txtkeyMoney;
    public TextField txtRoomQty;
    public Label lblRoomId;

    RoomBOImpl roomBO = BOFactory.getInstance().getBO(BOType.ROOM);

    public void navigate(MouseEvent mouseEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/main-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void ClickSearchOnAction(ActionEvent actionEvent) throws Exception {
        Room room = roomBO.find(txtSearch.getText());

        lblRoomId.setText(room.getRoom_type_ID());
        txtRoomType.setText(room.getType());
        txtkeyMoney.setText(String.valueOf(room.getKeyMoney()));
        txtRoomQty.setText(String.valueOf(room.getQTY()));
    }

    public void ClickOnDeleteAction(ActionEvent actionEvent) {
        try {
            roomBO.delete(txtSearch.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ClickOnUpdateAction(ActionEvent actionEvent) {

        String Room_type_ID = lblRoomId.getText();
        String Type = txtRoomType.getText();
        double KeyMoney = Double.parseDouble(txtkeyMoney.getText());
        int QTY = Integer.parseInt(txtRoomQty.getText());

        try{
            if (roomBO.update(new RoomDTO(Room_type_ID,Type,KeyMoney,QTY))){
                new Alert(Alert.AlertType.CONFIRMATION, "Updated.!").show();
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
        txtSearch.clear();
        lblRoomId.setText("");
        txtRoomType.clear();
        txtkeyMoney.clear();
        txtRoomQty.clear();
    }

    public void ClickOnBackAction(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/manageRoom-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
