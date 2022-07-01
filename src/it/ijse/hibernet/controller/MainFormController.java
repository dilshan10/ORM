package it.ijse.hibernet.controller;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Optional;


public class MainFormController {
    public ImageView imgSetting;
    public AnchorPane root;
    public ImageView imgNewStudent;
    public ImageView imgManageRoom;
    public ImageView imgKeyMoney;
    public ImageView imgUpUser;
    public Label lblMenu;
    public Label lblDescription;
    public Button btnLogOut;
    public ImageView imgLogOut;

    public void navigate(MouseEvent Event) throws IOException {
        if (Event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) Event.getSource();

            Parent root = null;

            switch (icon.getId()) {
                case "imgSetting":
                    root = FXMLLoader.load(this.getClass().getResource("../view/setting-form.fxml"));
                    break;
                case "imgNewStudent" :
                    root = FXMLLoader.load(this.getClass().getResource("../view/register-form.fxml"));;
                    break;
                case "imgManageRoom" :
                    root = FXMLLoader.load(this.getClass().getResource("../view/manageRoom-form.fxml"));;
                    break;
                case "imgKeyMoney" :
                    root = FXMLLoader.load(this.getClass().getResource("../view/takeKeyMoney-form.fxml"));;
                    break;
                case "imgUpUser" :
                    root = FXMLLoader.load(this.getClass().getResource("../view/updateUser-form.fxml"));
                    break;
            }
                if (root != null) {
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) this.root.getScene().getWindow();
                    stage.setScene(scene);
                    stage.centerOnScreen();

                    TranslateTransition tt = new TranslateTransition(Duration.millis(350), scene.getRoot());
                    tt.setFromX(-scene.getWidth());
                    tt.setToX(0);
                    tt.play();
                } }
    }

    public void ClickOnLogOut(ActionEvent actionEvent) throws IOException {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"If you want Logout", ButtonType.YES,ButtonType.NO);
        Optional<ButtonType>buttonType=alert.showAndWait();
        if (buttonType.get().equals(ButtonType.YES)){
            Parent parent = FXMLLoader.load(getClass().getResource("../view/login-form.fxml"));
            Scene subScene = new Scene(parent);
            Stage primaryStage = (Stage) this.root.getScene().getWindow();
            primaryStage.setScene(subScene);
            primaryStage.centerOnScreen();
        }
    }

    public void playMouseEnterAnimation(MouseEvent Event) {
        if (Event.getSource() instanceof ImageView){
            ImageView icon = (ImageView)Event.getSource();

            switch (icon.getId()){
                case "imgNewStudent" :
                    lblMenu.setText("REGISTER NEW STUDENTS");
                    lblDescription.setText("Click if you want to register new student");
                    break;
                case "imgManageRoom" :
                    lblMenu.setText("MANAGE ROOMS");
                    lblDescription.setText("Click if you want to manage rooms");
                    break;
                case "imgKeyMoney" :
                    lblMenu.setText("REMAIN KEY MONEY");
                    lblDescription.setText("Click if you want to remind key money ");
                    break;
                case "imgUpUser" :
                    lblMenu.setText("UPDATE USER LOGIN");
                    lblDescription.setText("Click if you want to change to username password");
                    break;
                case "imgLogOut" :
                    lblMenu.setText("LOG OUT");
                    lblDescription.setText("Click if you want to Log-out");
                    break;
                case "btnLogOut" :
                    lblMenu.setText("LOG OUT");
                    lblDescription.setText("Click if you want to Log-out");
                    break;
                case "imgSetting" :
                    lblMenu.setText("SETTING");
                    lblDescription.setText("Click if you want to change settings");
                    break;

            }
        }
    }

    public void playMouseExitAnimation(MouseEvent Event) {
        if (Event.getSource() instanceof ImageView){
            ImageView icon = (ImageView)Event.getSource();
            ScaleTransition scaleTransition=new ScaleTransition(Duration.millis(200),icon);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();

            icon.setEffect(null);
            lblMenu.setText("WEL-COME");
            lblDescription.setText("Please select one of above main operations to proceed");
        }
    }
}
