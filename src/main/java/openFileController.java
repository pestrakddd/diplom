import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class openFileController {

    private static String path = null;
    private static Stage stage;

    @FXML
    private Button fileOpen;

    @FXML
    private ListView<?> listFiles;

    @FXML
    private TextField pathToFileForOpen;

    @FXML
    private Button close;

    @FXML
    private Button open;

    @FXML
    void initialize() {
        close.setOnAction(e -> {
            path = null;
            stage.close();
        });

        fileOpen.setOnAction(e-> {
            final FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("exel files (*.xls)", "*.xls");
            FileChooser.ExtensionFilter extFilter1 = new FileChooser.ExtensionFilter("exel files (*.xlsx)", "*.xlsx");
            fileChooser.getExtensionFilters().add(extFilter);
            fileChooser.getExtensionFilters().add(extFilter1);
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                path = file.getPath();
                pathToFileForOpen.setText(path);
            }
        });

        open.setOnAction(e-> {
            File file = new File(pathToFileForOpen.getText());
            if (!file.exists()) {
                operationStatusWindow.start("Файл не существует", "Ошибка");
                return;
            }
            path = pathToFileForOpen.getText();
            stage.close();
        });

    }

    static String start() {
        try {
            stage = new Stage();
            stage.setTitle("Выберете файл");
            stage.setScene(new Scene(FXMLLoader.load(openFileController.class.getResource("fxml/fileOpen.fxml"))));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setMinHeight(400);
            stage.setMinWidth(500);
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(openFileController.class.getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
        return path;
    }
}
