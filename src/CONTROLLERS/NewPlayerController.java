package CONTROLLERS;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class NewPlayerController {
    @FXML ChoiceBox<String> boxChoicetype;

    public void initialize() throws Exception{
        fillList();
    }

    public void fillList(){
        boxChoicetype.getItems().addAll("Hitter","Pitcher","Defense");
    }

}
