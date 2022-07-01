package it.ijse.hibernet.controller;

import it.ijse.hibernet.bo.BOFactory;
import it.ijse.hibernet.bo.BOType;
import it.ijse.hibernet.bo.custom.impl.UserBOImpl;
import it.ijse.hibernet.dto.UserDTO;
import it.ijse.hibernet.entty.User;
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

public class UpdateUserSubFormController {
    public Label lblUserID;
    public TextField txtUserName;
    public TextField txtPass;
    public TextField txtRePass;
    public AnchorPane root;
    public TextField txtSearch;

    UserBOImpl userBO = BOFactory.getInstance().getBO(BOType.USER);

    public void navigate(MouseEvent mouseEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/main-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void clickUpdateUserOnAction(ActionEvent actionEvent) {
        String User_ID = lblUserID.getText();
        String User_Name = txtUserName.getText();
        String Password = null;
        if (txtPass.getText().equals(txtRePass.getText())){
            Password = txtPass.getText();
        }else{
            new Alert(Alert.AlertType.ERROR,"Pass-word Not Match..").show();
        }

        try {
            if (userBO.update(new UserDTO(User_ID,User_Name,Password))){
                new Alert(Alert.AlertType.CONFIRMATION, "Updated.!").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Something Happened").show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void ClickCraeteNewLoginOnAction(ActionEvent actionEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("../view/updateUser-form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void SearchOnAction(ActionEvent actionEvent) {

        User user = null;
        try {
            user = userBO.find(txtSearch.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }

        lblUserID.setText(user.getUser_ID());
        txtUserName.setText(user.getUser_Name());

    }

    public void clickDeleteUserOnAction(ActionEvent actionEvent) {

        try {
            userBO.delete(txtSearch.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
