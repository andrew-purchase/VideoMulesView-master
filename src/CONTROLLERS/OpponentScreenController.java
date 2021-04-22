package CONTROLLERS;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class OpponentScreenController {
    @FXML ListView<String> oppoTeamView;
    @FXML ListView<String> oppoPlayerView;
    @FXML ListView<String> videoView;
    String video_name;
    String player_name;
    String team_name;
    String video_link;
    //script runs on startup; populates the Select Team List
    public void initialize() throws Exception {
        Models.DbConnection.FillTeamList(oppoTeamView);
    }

    //populate Select Pitcher List
    public void findPitcher() throws Exception {
        oppoPlayerView.getItems().clear();
        videoView.getItems().clear();
        team_name = oppoTeamView.getSelectionModel().getSelectedItem();
        Models.DbConnection.FillPitcherList(team_name, oppoPlayerView);
    }

    //populate Select Video List
    public void findVideo() throws Exception {
        videoView.getItems().clear();
        player_name = oppoPlayerView.getSelectionModel().getSelectedItem();

        Models.DbConnection.FillVideoList( player_name, videoView);
    }

    public void goBack() throws Exception {
        MainScreenController mainController = MainScreenController.getInstance();
        mainController.openFrontScreen();
    }

    public void openVideo() throws Exception{
        video_name = videoView.getSelectionModel().getSelectedItem();
        video_link=Models.DbConnection.ReturnVideoLink2(video_name);
        if (PlayerStageController.isValid(video_link)){
            Stage primaryStage = new Stage();
            primaryStage.setTitle("MULES VIDEO CONTROL");
            primaryStage.setResizable(false);

            WebView webView = new WebView();

            webView.getEngine().load(video_link);

            VBox vBox = new VBox(webView);
            Scene scene = new Scene(vBox, 960, 600);

            primaryStage.setScene(scene);
            primaryStage.show();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("INCORRECT Video Link for Player : " + player_name);
            alert.showAndWait();
        }


    }


}
