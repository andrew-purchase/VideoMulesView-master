package CONTROLLERS;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController {
    @FXML Pane MainPane;

    Parent root;
    public Stage MainStage = new Stage();
    static MainScreenController instance = null;

    public static MainScreenController getInstance(){return instance;}

    public void initialize() throws IOException{
        instance=this;
        openLoginScreen();
    }
    public void openMainScreen() throws IOException{
        root = FXMLLoader.load(getClass().getResource("/FXML_FILES/MainScreen.fxml"));
        Scene scene=new Scene(root,1243,538);
        scene.getStylesheets().add(getClass().getResource("/FXML_FILES/styles.css").toExternalForm());

        MainStage.setTitle("Video MULES View");
        MainStage.setScene(scene);
        MainStage.show();
    }

    public void openPlayerScreen() throws IOException{
        Pane PanePlayer = FXMLLoader.load(getClass().getResource("/FXML_FILES/PlayerScreen.fxml"));
        MainPane.getChildren().clear();
        MainPane.getChildren().add(PanePlayer);
    }

    public void openAdminScreen() throws IOException{
        Pane PaneAdmin = FXMLLoader.load(getClass().getResource("/FXML_FILES/AdminScreen.fxml"));
        MainPane.getChildren().clear();
        MainPane.getChildren().add(PaneAdmin);
    }
    public void openNewPlayerScreen() throws IOException{
        Pane PaneNewPlayer = FXMLLoader.load(getClass().getResource("/FXML_FILES/AddNewPlayerScreen.fxml"));
        MainPane.getChildren().clear();
        MainPane.getChildren().add(PaneNewPlayer);
    }

    public void openLoginScreen() throws IOException{
        Pane PaneLogin = FXMLLoader.load(getClass().getResource("/FXML_FILES/LoginScreen.fxml"));
        MainPane.getChildren().clear();
        MainPane.getChildren().add(PaneLogin);
    }

    public void openFrontScreen() throws IOException{
        Pane PaneFront = FXMLLoader.load(getClass().getResource("/FXML_FILES/FrontScreen.fxml"));
        MainPane.getChildren().clear();
        MainPane.getChildren().add(PaneFront);
    }

    public void openOpponentScreen() throws IOException{
        Pane PaneOppo = FXMLLoader.load(getClass().getResource("/FXML_FILES/OpponentScreen.fxml"));
        MainPane.getChildren().clear();
        MainPane.getChildren().add(PaneOppo);
    }
    public void openNewOpponent() throws IOException{
        Pane PaneNewOppo = FXMLLoader.load(getClass().getResource("/FXML_FILES/AddNewOpponent.fxml"));
        MainPane.getChildren().clear();
        MainPane.getChildren().add(PaneNewOppo);
    }

}
