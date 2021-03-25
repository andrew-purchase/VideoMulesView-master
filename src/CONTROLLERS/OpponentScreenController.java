package CONTROLLERS;

public class OpponentScreenController {
    public void goBack() throws Exception {
        MainScreenController mainController= MainScreenController.getInstance();
        mainController.openFrontScreen();
    }
}
