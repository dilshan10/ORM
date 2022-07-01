package it.ijse.hibernet.controller;

import it.ijse.hibernet.bo.BOFactory;
import it.ijse.hibernet.bo.BOType;
import it.ijse.hibernet.bo.custom.impl.RoomBOImpl;
import it.ijse.hibernet.dto.RoomDTO;
import it.ijse.hibernet.entty.Room;
import it.ijse.hibernet.util.FactoryConfiguration;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class ManageRoomFormController {
    public AnchorPane root;
    public TextField txtRoomID;
    public TextField txtRoomType;
    public TextField txtKeyMoney;
    public TextField txtRoomQty;

    RoomBOImpl roomBO = BOFactory.getInstance().getBO(BOType.ROOM);

    public void navigate(MouseEvent mouseEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/main-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void ClickSaveOnAction(ActionEvent actionEvent) {

        String Room_type_ID = txtRoomID.getText();
        String Type = txtRoomType.getText();
        double KeyMoney = Double.parseDouble(txtKeyMoney.getText());
        int QTY = Integer.parseInt(txtRoomQty.getText());

        try {
            if (roomBO.add(new RoomDTO(Room_type_ID,Type,KeyMoney,QTY))){
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
        txtRoomID.clear();
        txtRoomType.clear();
        txtKeyMoney.clear();
        txtRoomQty.clear();
    }

    public void ClickRoomListOnAction(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/RoomList-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void ClickUpdateOrDeleteOnAction(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/RoomUpdateDelete-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
