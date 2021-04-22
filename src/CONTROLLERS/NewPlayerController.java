package CONTROLLERS;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewPlayerController {
    @FXML ChoiceBox<String> boxChoicetype;
    @FXML Button btnAdd;
    @FXML TextField txtName, txtVideoName, txtVideoLink;
    String type;
    String player_name;
    String video_link;
    String video_name;


    public void initialize() throws Exception{
        fillList();
    }
    public void fillList(){
        boxChoicetype.getItems().addAll("Offensive","Pitching","Defensive");
    }

    public void insertNewPlayer() throws Exception {
        player_name = txtName.getText().toString();
        video_link = txtVideoLink.getText().toString();
        video_name=txtVideoName.getText().toString();
        type=boxChoicetype.getSelectionModel().getSelectedItem();
        if (PlayerStageController.isValid(video_link)) {
            Models.DbConnection.addNewPlayer(player_name,video_name,video_link,type);
            AdminStageController.closeNewPlayerStage();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("The Player " + player_name + " has been added");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("INCORRECT Video Link for Player : " + player_name + ", please provide a valid video link");
            alert.showAndWait();
        }

    }

}
