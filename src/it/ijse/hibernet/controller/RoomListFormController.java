package it.ijse.hibernet.controller;

import it.ijse.hibernet.bo.BOFactory;
import it.ijse.hibernet.bo.BOType;
import it.ijse.hibernet.bo.custom.impl.RoomBOImpl;
import it.ijse.hibernet.dto.RoomDTO;
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

public class RoomListFormController {
    public AnchorPane root;
    public TableView tblRoom;
    public TableColumn tblRoomTypeID;
    public TableColumn tblRoomType;
    public TableColumn tblKeyMoney;
    public TableColumn tblRoomQTY;

    RoomBOImpl roomBO = BOFactory.getInstance().getBO(BOType.ROOM);
    RoomDTO roomDTO = new RoomDTO();

    public void initialize() throws Exception {
        tblRoomTypeID.setCellValueFactory(new PropertyValueFactory<Student, Long>(roomDTO.getRoom_type_ID()));
        tblRoomType.setCellValueFactory(new PropertyValueFactory<Student, Long>("type"));
        tblKeyMoney.setCellValueFactory(new PropertyValueFactory<Student, Long>("keyMoney"));
        tblRoomQTY.setCellValueFactory(new PropertyValueFactory<Student, Long>("QTY"));

        tblRoom.getItems().addAll(roomBO.findAll());
    }

    public void navigate(MouseEvent mouseEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/main-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void ClickOnBackAction(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/manageRoom-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
