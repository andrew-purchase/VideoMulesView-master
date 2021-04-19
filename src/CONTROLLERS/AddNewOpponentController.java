package CONTROLLERS;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class AddNewOpponentController {
    @FXML ChoiceBox<String> boxChoiceTeam, boxChoice;
    @FXML TextField playerName, playerLink, videoName, teamName;
    String player_name, player_link, video_name, player_type, team_name;

    //script runs on startup; populates the Select Team List
    public void initialize() throws Exception {
        Models.DbConnection.FillTeamList2(boxChoiceTeam);
        fillList();
    }
    public void fillList(){
        boxChoice.getItems().addAll("Offensive","Pitching","Defensive");
    }

    public void insertnewopponent() throws Exception {
        player_name = playerName.getText();
        player_link = playerLink.getText();
        video_name = videoName.getText();
        player_type = boxChoice.getSelectionModel().getSelectedItem();
        if(teamName.getText() == null || teamName.getText().trim().isEmpty())
            team_name = boxChoice.getSelectionModel().getSelectedItem();
        else
            team_name = teamName.getText();
        Models.DbConnection.addNewOpponentVideo(player_name, player_link, video_name, player_type, team_name);
        AdminStageController.closeNewOpponentStage();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("The Opponent " + player_name + " has been added");
        alert.showAndWait();
    }
}

