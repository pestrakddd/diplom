import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/sample.fxml"));
        primaryStage.setTitle("АвтоОтчет");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinHeight(650);
        primaryStage.setMinWidth(850);
        primaryStage.show();
    }

    public static void main(String [] args) throws IOException {
        Application.launch(Main.class, (java.lang.String[])null);
    }
}
