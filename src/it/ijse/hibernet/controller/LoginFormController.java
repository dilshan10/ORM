package it.ijse.hibernet.controller;

import it.ijse.hibernet.bo.BOFactory;
import it.ijse.hibernet.bo.BOType;
import it.ijse.hibernet.bo.custom.impl.UserBOImpl;
import it.ijse.hibernet.entty.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginFormController {

    public TextField username;
    public TextField password;
    public AnchorPane root;

    UserBOImpl userBO = BOFactory.getInstance().getBO(BOType.USER);

    public void LoginOnAction(ActionEvent actionEvent) throws Exception {

        User user = userBO.find("U00-001");

        if (user.getUser_Name().equals(username.getText()) && user.getPassword().equals(password.getText())) {
            Parent parent = FXMLLoader.load(getClass().getResource("../view/main-form.fxml"));
            Scene subScene = new Scene(parent);
            Stage primaryStage = (Stage) this.root.getScene().getWindow();
            primaryStage.setScene(subScene);
            primaryStage.centerOnScreen();
        }else{
            new Alert(Alert.AlertType.WARNING,"Please Double-Check The Username And Password").show();
        }
    }
}
