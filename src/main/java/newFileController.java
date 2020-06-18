import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class newFileController {
    private static String path = null;
    private static Stage stage;

    @FXML
    private TextField workDirectory;
    @FXML
    private TextField nameFile;
    @FXML
    private Button newFile;
    @FXML
    private TextField pathFileForExel;
    @FXML
    private Button selectFile;
    @FXML
    private CheckBox isSelectFile;
    @FXML
    private Button close;

    @FXML
    void initialize() {
        workDirectory.setTooltip(new Tooltip("Директориия проекта"));
        nameFile.setTooltip(new Tooltip("Название файла"));

        newFile.setDisable(true);

        close.setOnAction(e -> {
            path = null;
            stage.close();
        });

        workDirectory.textProperty().addListener( (ov,oldV,newV) -> {
            Path path = Paths.get(workDirectory.getText());
            if (!Files.exists(path)) {
                workDirectory.setStyle("-fx-text-inner-color: red;");
                newFile.setDisable(true);
            } else {
                workDirectory.setStyle("-fx-text-inner-color: black;");
                newFile.setDisable(false);
            }
            workDirectory.setTooltip(new Tooltip(!newFile.isDisable()? "Директориия проекта" : "Такой директории не существует"));
        });

        nameFile.textProperty().addListener((ov,oldV,newV) -> {
            File file = new File(workDirectory.getText() + newV.toString());
            Path path = Paths.get(workDirectory.getText());
            if (!file.exists() && Files.exists(path)) {
                nameFile.setStyle("-fx-text-inner-color: black;");
                newFile.setDisable(false);
            } else {
                nameFile.setStyle("-fx-text-inner-color: red;");
                newFile.setDisable(true);
            }
            nameFile.setTooltip(new Tooltip(!newFile.isDisable()? "Название файла" : "Такой файл уже существует"));
        });

        isSelectFile.setOnAction(e -> {
            selectFile.setDisable(isSelectFile.isSelected());
        });

        newFile.setOnAction(e -> {
            path = workDirectory.getText() + nameFile.getText();
            stage.close();
        });
    }

    static String start() {
        try {
            stage = new Stage();
            stage.setTitle("Создать файл");
            stage.setScene(new Scene(FXMLLoader.load(newFileController.class.getResource("fxml/newFile.fxml"))));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(newFileController.class.getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
        return path;
    }
}

