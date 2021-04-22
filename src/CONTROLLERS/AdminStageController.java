package CONTROLLERS;

import Models.DbConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminStageController {
    @FXML Button btnAddNewPlayer, btnAdd, btnDelete,btnAddNewOpponent;
    @FXML ListView<String> viewPlayer;
    @FXML TextField txtVideoName, txtVideoLink;

    String type;
    String video_name;
    String player_name;
    String video_link;
    
    Parent root;
    public static Stage newPlayerStage = new Stage();

    MainScreenController mainController= MainScreenController.getInstance();


    //script for hitter button; populate player list view with hitters
    public void hittertype() throws Exception{
        viewPlayer.getItems().clear();
       type="Offensive";
        DbConnection.FillList(type, viewPlayer);
    }

    public void pitchertype() throws Exception{
        viewPlayer.getItems().clear();
        type="Pitching";
        DbConnection.FillList(type, viewPlayer);
    }

    public void defensetype() throws Exception{
        viewPlayer.getItems().clear();
        type="Defensive";
        Models.DbConnection.FillList(type, viewPlayer);
    }

    public void openNewPlayerStage() throws Exception{
        root = FXMLLoader.load(getClass().getResource("/FXML_FILES/AddNewPlayerScreen.fxml"));
        Scene scene=new Scene(root,600,400);
        scene.getStylesheets().add(getClass().getResource("/FXML_FILES/styles.css").toExternalForm());

        newPlayerStage.setTitle("ADD NEW PLAYER");
        newPlayerStage.setScene(scene);
        newPlayerStage.show();
    }
    public static void closeNewPlayerStage() throws Exception{
        newPlayerStage.close();
    }

    public static void closeNewOpponentStage() throws Exception{
        newPlayerStage.close();
    }

    public void openNewOpponentVideo() throws Exception{
        root = FXMLLoader.load(getClass().getResource("/FXML_FILES/AddNewOpponent.fxml"));
        Scene scene=new Scene(root,620,500);
        scene.getStylesheets().add(getClass().getResource("/FXML_FILES/styles.css").toExternalForm());

        newPlayerStage.setTitle("ADD NEW OPPONENT VIDEO");
        newPlayerStage.setScene(scene);
        newPlayerStage.show();
    }

    public void goBack() throws Exception {
        mainController.openFrontScreen();
    }

    public void insertNewPlayer() throws Exception {
        player_name = viewPlayer.getSelectionModel().getSelectedItem();
        video_name = txtVideoName.getText().trim().toString();
        video_link= txtVideoLink.getText().trim().toString();
        if (PlayerStageController.isValid(video_link)){
            Models.DbConnection.addNewPlayer(player_name,video_name,video_link,type);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("a new video has been added to player " + player_name);
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("INCORRECT Video Link for Player : " + player_name + ", please provide a valid video link");
            alert.showAndWait();
        }

    }

    public void deletePlayer() throws Exception{
        player_name = viewPlayer.getSelectionModel().getSelectedItem();
        video_name = txtVideoName.getText().trim().toString();
        Models.DbConnection.DeletePlayer(player_name,video_name);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("the video with the name of " + video_name + " from Player " + player_name + " has been deleted");
        alert.showAndWait();
    }


}
