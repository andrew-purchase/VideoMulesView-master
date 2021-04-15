package CONTROLLERS;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import java.io.File;

public class PlayerStageController {
    String type;
    String name;
    @FXML Button btnHitter;
    @FXML Button btnPitcher;
    @FXML Button btnDefense;
    @FXML Button btnPause, btnReset;
    @FXML ListView<String> PlayerView;
    @FXML ListView<String> LinkView;
    @FXML MediaView mediaView;
    private Media media;
    private MediaPlayer mediaPlayer;
    String video_name;
    String video_link;
    boolean Playing = true;
    MainScreenController mainController= MainScreenController.getInstance();

    public void findVideo() throws Exception {
        LinkView.getItems().clear();
        name = PlayerView.getSelectionModel().getSelectedItem();
        Models.DbConnection.FillVideoList(name,LinkView);
    }

    public void hittertype() throws Exception{
        PlayerView.getItems().clear();
        LinkView.getItems().clear();
        type="Offensive";
        Models.DbConnection.FillList(type,PlayerView);


    }

    public void pitchertype()throws Exception{
        PlayerView.getItems().clear();
        LinkView.getItems().clear();
        type="Pitching";
        Models.DbConnection.FillList(type,PlayerView);
    }

    public void defensetype()throws Exception{
        PlayerView.getItems().clear();
        LinkView.getItems().clear();
        type="Defensive";
        Models.DbConnection.FillList(type,PlayerView);

    }

    public void goBack() throws Exception {
        mainController.openFrontScreen();
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


    public void displayVideo() throws Exception{
        video_name = LinkView.getSelectionModel().getSelectedItem();
        video_link=Models.DbConnection.ReturnVideoLink(video_name);
        String path = new File("C:\\Users\\Alex\\IdeaProjects\\UCMVideoProject\\src\\" + video_link).getAbsolutePath();
        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);
    }

}
