package CONTROLLERS;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class OpponentScreenController {
    String query;
    @FXML ListView<String> oppoTeamView;
    @FXML ListView<String> oppoPlayerView;
    @FXML ListView<String> videoView;

    //script runs on startup; populates the Select Team List
    public void initialize() throws Exception {
//        oppoTeamView.getItems().clear();
        oppoPlayerView.getItems().clear();
        videoView.getItems().clear();
        Models.DbConnection.FillTeamList(oppoTeamView);
    }

    //populate Select Pitcher List
    public void findPitcher() throws Exception {
        oppoPlayerView.getItems().clear();
        videoView.getItems().clear();
        query = oppoTeamView.getSelectionModel().getSelectedItem();
        Models.DbConnection.FillPitcherList(query, oppoPlayerView);
    }

    //populate Select Video List
    public void findVideo() throws Exception {
        videoView.getItems().clear();
        query = oppoPlayerView.getSelectionModel().getSelectedItem();
        Models.DbConnection.FillVideoList(query, videoView);
    }

    public void goBack() throws Exception {
        MainScreenController mainController = MainScreenController.getInstance();
        mainController.openFrontScreen();
    }
}
