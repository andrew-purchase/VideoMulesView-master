package CONTROLLERS;

import Models.FillPlayersList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

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
        final WebEngine web = VideoViewer.getEngine();
        video_link= "https://www.youtube.com/watch?v=1cGmWPI5TaI";
        web.load(video_link);
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



    
}
