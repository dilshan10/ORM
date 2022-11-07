package it.ijse.hibernet.controller;

import it.ijse.hibernet.bo.BOFactory;
import it.ijse.hibernet.bo.BOType;
import it.ijse.hibernet.bo.custom.impl.UserBOImpl;
import it.ijse.hibernet.dto.UserDTO;
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

public class UpdateUserFormController {
    public AnchorPane root;
    public TextField txtUserID;
    public TextField txtUserName;
    public TextField txtPass;
    public TextField txtRePass;

    UserBOImpl userBO = BOFactory.getInstance().getBO(BOType.USER);

    public void initialize(){
        setNewId();
    }

    public void setNewId(){
        txtUserID.setText(userBO.IdGenerator());
    }

    public void navigate(MouseEvent mouseEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/main-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void ClickNewUsetOnAction(ActionEvent actionEvent) {


        String User_ID = txtUserID.getText();
        String User_Name = txtUserName.getText();
        String Password = null;
        if (txtPass.getText().equals(txtRePass.getText())){
             Password = txtPass.getText();
        }else{
            new Alert(Alert.AlertType.ERROR,"Pass-word Not Match..").show();
        }

        try {
            if (userBO.add(new UserDTO(User_ID,User_Name,Password))){
                new Alert(Alert.AlertType.CONFIRMATION, "Updated.!").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Something Happened").show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void ClickUpdateOnUserOnAction(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/updateUser-sub-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
