package CONTROLLERS;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class AddNewOpponentController {
    @FXML ChoiceBox<String> boxChoiceTeam;

    //script runs on startup; populates the Select Team List
    public void initialize() throws Exception {
        Models.DbConnection.FillTeamList2(boxChoiceTeam);
    }
}
