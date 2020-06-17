import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class sampleController {

//    private Stage stage;

    @FXML
    private ResourceBundle resources;
    @FXML
    private MenuItem newFile;
    @FXML
    private MenuItem openFile;
    @FXML
    private MenuItem saveFile;
    @FXML
    private MenuItem exportFile;
    @FXML
    private MenuItem importFile;
    @FXML
    private Menu mainPage;
    @FXML
    private MenuItem about;
    @FXML
    private MenuItem exit;
    @FXML
    private MenuItem toFullScreen;
    @FXML
    private CheckBox isFullScreen;
    @FXML
    void initialize() {
//        Stage stage = (Stage) isFullScreen.getScene().getWindow();

        exit.setOnAction(e -> {
//            Stage stage = (Stage) isFullScreen.getScene().getWindow();
//            stage.close();
        });

//        toFullScreen.setOnAction(e-> {
//            isFullScreen.setSelected(!isFullScreen.isSelected());
//            Stage stage = (Stage) isFullScreen.getScene().getWindow();
//            stage.setFullScreen(isFullScreen.isSelected());
//        });

        isFullScreen.setOnAction(e-> {
//            Stage stage = (Stage) isFullScreen.getScene().get .getScene().getWindow();
//            stage.setFullScreen(isFullScreen.isSelected());
        });

        newFile.setOnAction(e -> {
            String pathToFile = newFileController.start();
            System.out.println(pathToFile);
        });

        openFile.setOnAction(e -> {
            String pathToFile = openFileController.start();
            System.out.println(pathToFile);
        });

    }
}
