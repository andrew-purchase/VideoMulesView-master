package CONTROLLERS;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class OpponentScreenController {
    String name;
    @FXML ListView<String> oppoTeamView;

    public void goBack() throws Exception {
        MainScreenController mainController = MainScreenController.getInstance();
        mainController.openFrontScreen();
    }
    //works:
//    public void findPlayer() throws Exception{
//        oppoTeamView.getItems().clear();
//        Models.DbConnection.FillList("Offensive",oppoTeamView);
//    }
public void findPlayer() throws Exception{
    oppoTeamView.getItems().clear();
    Models.DbConnection.FillTeamList(oppoTeamView);
}
}
