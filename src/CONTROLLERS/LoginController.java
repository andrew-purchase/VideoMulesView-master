package CONTROLLERS;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

    String username = "MulesBaseball";
    String passw = "MulesBall2021";
    public void attemptLogin() throws Exception {
        if (textFieldUsername.getText().equals(username) && textFieldPassword.getText().equals(passw)){
            mainController.openFrontScreen();
            loginStage.close();
        }
       else if (textFieldUsername.getText().isEmpty())
        textFieldUsername.setText("Username Required");
       else if (textFieldPassword.getText().isEmpty())
            textFieldPassword.setText("Password Required");
       else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("INCORRECT USERNAME OR PASSWORD, TRY AGAIN");
            alert.showAndWait();
        }
    }

}
