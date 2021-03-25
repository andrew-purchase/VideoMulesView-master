package CONTROLLERS;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    // variables
    public Stage loginStage = new Stage();
    Parent root;
    MainScreenController mainController= MainScreenController.getInstance();

    @FXML public TextField textFieldUsername;
    @FXML public TextField textFieldPassword;
    @FXML public Button buttonLogin;

    public void attemptLogin() throws Exception {
        mainController.openFrontScreen();
        loginStage.close();
    }

}
