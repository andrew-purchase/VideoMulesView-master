package CONTROLLERS;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class AdminStageController {
    @FXML Button btnAddNewPlayer;
    
    Parent root;
    public Stage newPlayerStage = new Stage();

    MainScreenController mainController= MainScreenController.getInstance();

    public void openNewPlayerStage() throws Exception{
        root = FXMLLoader.load(getClass().getResource("/FXML_FILES/AddNewPlayerScreen.fxml"));
        Scene scene=new Scene(root,600,400);
        scene.getStylesheets().add(getClass().getResource("/FXML_FILES/styles.css").toExternalForm());

        newPlayerStage.setTitle("ADD NEW PLAYER");
        newPlayerStage.setScene(scene);
        newPlayerStage.show();
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


}
