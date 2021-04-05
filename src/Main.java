import CONTROLLERS.LoginController;
import CONTROLLERS.MainScreenController;
import CONTROLLERS.PlayerStageController;
import Models.DbConnection;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage)throws Exception{
        DbConnection.InitializeDB();
        MainScreenController mainscreen = new MainScreenController();
        mainscreen.openMainScreen();

    }
    public static void main(String[] args) {
        launch(args);
    } //testing

}
