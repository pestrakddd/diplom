import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class operationStatusWindow {
    @FXML
    private Button close;
    @FXML
    private ImageView statusImages;
    @FXML
    private Text textError;

    private String textErrors = null;
    private String status = null;
    private static Stage stage;

    @FXML
    void initialize() {
        System.out.println(textErrors);
        System.out.println(status);

        close.setOnAction(e -> stage.close());

    }

    void f() {}

    static void start(String error, String statusError) {
        try {
            stage = new Stage();
            stage.setTitle(statusError);
            stage.setScene(new Scene(FXMLLoader.load(openFileController.class.getResource("fxml/operationStatusWindow.fxml"))));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(openFileController.class.getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }
}
