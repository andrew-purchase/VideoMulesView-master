package CONTROLLERS;

import com.sun.javafx.iio.ios.IosDescriptor;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class FrontScreenController {
    @FXML Button btnMules;
    @FXML Button btnSubmit;
    @FXML Button btnOpponent;

    MainScreenController mainController= MainScreenController.getInstance();

    public void openMulesVideo() throws IOException {
        mainController.openPlayerScreen();
    }

    public void openSubmitVideo() throws IOException {
        mainController.openAdminScreen();
    }

    public void openOpponentVideo() throws IOException{
        mainController.openOpponentScreen();
    }
}
