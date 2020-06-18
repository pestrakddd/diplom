import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class sampleController {

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
    private AnchorPane workPane;
    @FXML
    private AnchorPane Main;
    @FXML
    private ComboBox<String> selectTyprOtchot;
    @FXML
    private ComboBox<String> selectTimes;
    @FXML
    private Button addOtchot;
    @FXML
    private AnchorPane otchot1;
    @FXML
    private AnchorPane tableEmpty;
    @FXML
    private AnchorPane otchot2;
    @FXML
    private AnchorPane otchot3;
    @FXML
    private AnchorPane otchot4;
    @FXML
    private TableColumn<String, String> godST_mount;
    @FXML
    private TableColumn<?, ?> godST_kol_voStudent;
    @FXML
    private TableColumn<?, ?> godST_summaZaMesaz;
    @FXML
    private TableColumn<?, ?> godST_SummaItogo;
    @FXML
    void initialize() {
        ObservableList<String> mounts = FXCollections.observableArrayList("Январь", "Февраль", "Март", "Апрель",
                                                                                "Май", "Июнь", "Июль", "Август",
                                                                                "Сентябрь", "Октябрь", "Ноябрь", "Декабрь");
        selectTimes.setItems(mounts);

        otchot1.setVisible(false);
        otchot2.setVisible(false);
        otchot3.setVisible(false);
        otchot4.setVisible(false);
        tableEmpty.setVisible(true);

        ObservableList<String> typeOtchot = FXCollections.observableArrayList("?", "Годовая выплата стипендии", "Выплата стипендии за месяц", "Месячный отчет по фонду заработной платы");
        selectTyprOtchot.setItems(typeOtchot);

        newFile.setOnAction(e -> {
            String pathToFile = newFileController.start();
            workPane.setVisible(pathToFile == null);
        });

        selectTyprOtchot.setOnAction(e -> {
            switch (selectTyprOtchot.getValue()) {
                case "?" :
                    otchot1.setVisible(true);
                    otchot2.setVisible(false);
                    otchot3.setVisible(false);
                    otchot4.setVisible(false);
                    tableEmpty.setVisible(false);
                    break;
                case "Годовая выплата стипендии" :
                    otchot1.setVisible(false);
                    otchot2.setVisible(true);
                    otchot3.setVisible(false);
                    otchot4.setVisible(false);
                    tableEmpty.setVisible(false);

//                    godST_mount.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
//                        @Override
//                        public ObservableValue<String> call(TableColumn.CellDataFeatures<String, String> param) {
//                            return null;
//                        }
//                    });
//                    godST_mount.setText(new );
                    break;
                case "Выплата стипендии за месяц" :
                    otchot1.setVisible(false);
                    otchot2.setVisible(false);
                    otchot3.setVisible(true);
                    otchot4.setVisible(false);
                    tableEmpty.setVisible(false);
                    break;
                case "Месячный отчет по фонду заработной платы" :
                    otchot1.setVisible(false);
                    otchot2.setVisible(false);
                    otchot3.setVisible(false);
                    otchot4.setVisible(true);
                    tableEmpty.setVisible(false);
                    break;
            }
        });

        openFile.setOnAction(e -> {
            String pathToFile = openFileController.start();
        });

    }
}
