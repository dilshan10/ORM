package it.ijse.hibernet.controller;

import it.ijse.hibernet.bo.BOFactory;
import it.ijse.hibernet.bo.BOType;
import it.ijse.hibernet.bo.custom.impl.RoomBOImpl;
import it.ijse.hibernet.dto.RoomDTO;
import javafx.collections.FXCollections;
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

public class ManageRoomFormController {
    public AnchorPane root;
    public TextField txtRoomID;
    public TextField txtKeyMoney;
    public TextField txtRoomQty;
    public ComboBox cmdRoomType;

    RoomBOImpl roomBO = BOFactory.getInstance().getBO(BOType.ROOM);

    public void initialize(){
        setNewId();
        setRoomTypeValues();
    }

    private void setRoomTypeValues() {
        ObservableList<String> data = FXCollections.observableArrayList("AC","NON AC", "AC/FOOD", "NON AC /FOOD");
        cmdRoomType.setItems(data);
    }

    public void setNewId(){
        txtRoomID.setText(roomBO.IdGenerator());
    }

    public void navigate(MouseEvent mouseEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/main-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void ClickSaveOnAction(ActionEvent actionEvent) {

        String Room_type_ID = txtRoomID.getText();
        String Type = (String) cmdRoomType.getValue();
        double KeyMoney = Double.parseDouble(txtKeyMoney.getText());
        int QTY = Integer.parseInt(txtRoomQty.getText());

        try {
            if (roomBO.add(new RoomDTO(Room_type_ID,Type,KeyMoney,QTY))){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved.!").show();
                clearFields();
                setNewId();
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
        cmdRoomType.setValue("AC, NON AC, AC/FOOD, NON AC /FOOD");
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
