package CONTROLLERS;

import Models.FillPlayersList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayerStageController {
    String type;
    String name;
    @FXML Pane MainPane;
    @FXML Button btnHitter;
    @FXML Button btnPitcher;
    @FXML Button btnDefense;
    @FXML ListView<String> PlayerView;
    @FXML ListView<String> LinkView;
    @FXML WebView VideoViewer;
    String video_name;
    String video_link;
    MainScreenController mainController= MainScreenController.getInstance();
    private static final String MEDIA_URL =
            "https://liveexample.pearsoncmg.com/common/sample.mp4";

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


    public void displayVideo() throws Exception{
        video_name = LinkView.getSelectionModel().getSelectedItem();
        System.out.println(video_name);
        video_link=Models.DbConnection.ReturnVideoLink(video_name);
        System.out.println(video_link);
        VideoViewer=new WebView();
        video_link= "https://www.youtube.com/watch?v=TmKh7lAwnBI";
        VideoViewer.getEngine().load(video_link);
    }
   /** public void displayVideo() throws Exception{
        Stage stage;
        Scene scene;
       BorderPane borderPane;
       HBox hBox;

       Media media;
       MediaPlayer mediaPlayer;
       MediaView mediaView;

       stage = new Stage();
       stage.setTitle("HOLA");
       borderPane=new BorderPane();

       media = new Media("https://www.youtube.com/watch?v=evd2mLwMjho");
       mediaPlayer = new MediaPlayer(media);
       mediaPlayer.setAutoPlay(true);
       mediaPlayer.setOnReady(()-> stage.sizeToScene());
       mediaView=new MediaView(mediaPlayer);

       borderPane.setCenter(mediaView);

       Button btnPlay = new Button(">");
       Button btnPause = new Button ("||");

       hBox = new HBox(10);
       hBox.getChildren().addAll(btnPlay,btnPause);
       hBox.setPadding(new Insets(10));

       scene = new Scene(borderPane);
       stage.setScene(scene);
       stage.show();
   } **/
   /** public void displayVideo() throws Exception{
       Stage primaryStage = new Stage();
       Media media = new Media(MEDIA_URL);
       MediaPlayer mediaPlayer = new MediaPlayer(media);
       MediaView mediaView = new MediaView(mediaPlayer);

       Button playButton = new Button(">");
       playButton.setOnAction(e -> {
           if (playButton.getText().equals(">")) {
               mediaPlayer.play();
               playButton.setText("||");
           } else {
               mediaPlayer.pause();
               playButton.setText(">");
           }
       });

       Button rewindButton = new Button("<<");
       rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));

       Slider slVolume = new Slider();
       slVolume.setPrefWidth(150);
       slVolume.setMaxWidth(Region.USE_PREF_SIZE);
       slVolume.setMinWidth(30);
       slVolume.setValue(50);
       mediaPlayer.volumeProperty().bind(
               slVolume.valueProperty().divide(100));

       HBox hBox = new HBox(10);
       hBox.setAlignment(Pos.CENTER);
       hBox.getChildren().addAll(playButton, rewindButton,
               new Label("Volume"), slVolume);

       BorderPane pane = new BorderPane();
       pane.setCenter(mediaView);
       pane.setBottom(hBox);

       // Create a scene and place it in the stage
       Scene scene = new Scene(pane, 650, 500);
       primaryStage.setTitle("MediaDemo"); // Set the stage title
       primaryStage.setScene(scene); // Place the scene in the stage
       primaryStage.show(); // Display the stage
   } **/




    
}
