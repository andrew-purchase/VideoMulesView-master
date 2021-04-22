package CONTROLLERS;


import javafx.event.ActionEvent;
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
import java.net.URL;

public class PlayerStageController {
    String type;
    String name;
    @FXML Button btnHitter;
    @FXML Button btnPitcher;
    @FXML Button btnDefense;
    @FXML ListView<String> PlayerView;
    @FXML ListView<String> LinkView;
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

    public void openVideo() throws Exception{
        video_name = LinkView.getSelectionModel().getSelectedItem();
        video_link=Models.DbConnection.ReturnVideoLink(video_name);
        if(isValid(video_link)){
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
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("INCORRECT Video Link for Player : " + name);
            alert.showAndWait();
        }

    }
    public static boolean isValid(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
