package CONTROLLERS;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;

public class OpponentScreenController {
    @FXML ListView<String> oppoTeamView;
    @FXML ListView<String> oppoPlayerView;
    @FXML ListView<String> videoView;
    @FXML MediaView mediaView;
    @FXML Button  btnPause, btnReset;
    String video_name;
    String player_name;
    String team_name;
    String video_link;
    private Media media;
    private MediaPlayer mediaPlayer;
    boolean Playing=true;
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

    public void displayVideo() throws Exception{
        video_name = videoView.getSelectionModel().getSelectedItem();
        video_link=Models.DbConnection.ReturnVideoLink2(video_name);
        String path = new File("C:\\Users\\Alex\\IdeaProjects\\UCMVideoProject\\src\\" + video_link).getAbsolutePath();
        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);
    }

    public void pauseMedia(){
        if (Playing){
            mediaPlayer.pause();
            btnPause.setText("Play");
            Playing=false;
        }
        else {
            mediaPlayer.play();
            btnPause.setText("Pause");
            Playing=true;
        }


    }
    public void resetMedia(){
        mediaPlayer.seek(Duration.seconds(0.0));

    }

}
