package CONTROLLERS;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayerStageController {
    @FXML Pane MainPane;
    @FXML Button btnHitter;
    @FXML Button btnPitcher;
    @FXML Button btnDefense;
    @FXML ListView<String> PlayerView;
    @FXML ListView<String> LinkView;
    MainScreenController mainController= MainScreenController.getInstance();


    public void fillList(){
        PlayerView.getItems().add("Hola");
    }

    public void hittertype(){
        PlayerView.getItems().add("Hitter"); // this is testing to see button working.
    }

    public void pitchertype(){
        PlayerView.getItems().add("Pither"); // this is testing to see button working.
    }

    public void defensetype(){
        PlayerView.getItems().add("Defense"); // this is testing to see button working.
    }

    public void goBack() throws Exception {
        mainController.openFrontScreen();
    }

    
}
