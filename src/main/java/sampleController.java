import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Poi.Poi_read;
import Poi.Stipendia_zaMesaz;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.swing.*;

public class sampleController extends Component {

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
    private TableColumn<Stipendia_zaMesaz, Integer> numberPP;
    @FXML
    private TableColumn<Stipendia_zaMesaz, String> statusStudent;
    @FXML
    private TableColumn<Stipendia_zaMesaz, String> FIO;
    @FXML
    private TableColumn<Stipendia_zaMesaz, Double> summa;
    @FXML
    private TableColumn<Stipendia_zaMesaz, String> mounts;
    @FXML
    private TableView<Stipendia_zaMesaz> stipMesaz;
    @FXML
    private Label lab;

    String pathToNewFile = null;
    String pathToOpenFile = null;
    String pathToExelFile = null;

    @FXML
    void initialize() {
        ObservableList<String> mounts = FXCollections.observableArrayList("Январь", "Февраль", "Март", "Апрель",
                                                                                "Май", "Июнь", "Июль", "Август",
                                                                                "Сентябрь", "Октябрь", "Ноябрь", "Декабрь");
        selectTimes.setItems(mounts);
        lab.setVisible(false);
        selectTimes.setVisible(false);

        addOtchot.setOnAction(e->{

            switch (selectTyprOtchot.getValue()) {
                case "?" :
                    break;
                case "Годовая выплата стипендииwew" :
                    break;
                case "Годовая выплата стипендии" :
                    try {
                        ObservableList<Stipendia_zaMesaz> Stipendia_zaMesazData = FXCollections.observableArrayList();

                        Poi_read poi_read = new Poi_read(null);
                        ArrayList <Stipendia_zaMesaz> stipendia_zaMesaz = poi_read.readToStipZaGod(pathToExelFile);
                        if (selectTimes.getValue() == null) {
                            JFrame topFrame = (JFrame)SwingUtilities.getWindowAncestor(this);
                            JOptionPane.showMessageDialog(topFrame, "Год не выбран!!!");
                            return;
                        }
                        if (poi_read.writeIntoExcelStipendiaYear(pathToNewFile, stipendia_zaMesaz, selectTimes.getValue())) {
                            System.out.println("Вы знаете что такое успех?..");
                            JFrame topFrame = (JFrame)SwingUtilities.getWindowAncestor(this);
                            JOptionPane.showMessageDialog(topFrame, "Файл успешно создан!");
                        } else {
                            System.out.println("Вы уволены на 60%?..");
                            JFrame topFrame = (JFrame)SwingUtilities.getWindowAncestor(this);
                            JOptionPane.showMessageDialog(topFrame, "Файл успешно не создан!");
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "Месячный отчет по фонду заработной платы" :
                    break;
                default:
                    JFrame topFrame = (JFrame)SwingUtilities.getWindowAncestor(this);
                    JOptionPane.showMessageDialog(topFrame, "не выбран тип отчета!");
                    break;
            }

        });


        otchot1.setVisible(false);
        otchot2.setVisible(false);
        otchot3.setVisible(false);
        otchot4.setVisible(false);
        tableEmpty.setVisible(true);

        ObservableList<String> typeOtchot = FXCollections.observableArrayList("Выплата стипендии за месяц", "Годовая выплата стипендии");
        selectTyprOtchot.setItems(typeOtchot);

        newFile.setOnAction(e -> {
            String [] pathToFile = newFileController.start();
            pathToNewFile = pathToFile[0];
            pathToExelFile = pathToFile[1];
            workPane.setVisible(pathToFile[0] == null);
            otchot1.setVisible(false);
            otchot2.setVisible(false);
            otchot3.setVisible(false);
            otchot4.setVisible(false);
            tableEmpty.setVisible(true);
            stipMesaz.setItems(null);
        });

        selectTyprOtchot.setOnAction(e -> {
            lab.setVisible(true);
            selectTimes.setVisible(true);
            switch (selectTyprOtchot.getValue()) {
                case "Выплата стипендии за месяц" :
                    otchot1.setVisible(true);
                    otchot2.setVisible(false);
                    otchot3.setVisible(false);
                    otchot4.setVisible(false);
                    tableEmpty.setVisible(false);
                    selectTimes.setItems(mounts);

                    break;
                case "Годовая выплата стипендии" :
                    otchot1.setVisible(false);
                    otchot2.setVisible(false);
                    otchot3.setVisible(true);
                    otchot4.setVisible(false);
                    tableEmpty.setVisible(false);

                    lab.setText("Год");
                    ObservableList<String> year = FXCollections.observableArrayList("1980");
                    for (int i = 1981; i < 2021; i++) {
                        year.add(String.valueOf(i));
                    }
                    selectTimes.setItems(year);

                    try {
                        ObservableList<Stipendia_zaMesaz> Stipendia_zaMesazData = FXCollections.observableArrayList();

                        Poi_read poi_read = new Poi_read(null);
                        ArrayList <Stipendia_zaMesaz> stipendia_zaMesaz = poi_read.readToStipZaGod(pathToExelFile);
                        Stipendia_zaMesazData.addAll(stipendia_zaMesaz);

                        numberPP.setCellValueFactory(new PropertyValueFactory<Stipendia_zaMesaz, Integer>("numberPP"));
                        statusStudent.setCellValueFactory(new PropertyValueFactory<Stipendia_zaMesaz, String>("statusStudent"));
                        FIO.setCellValueFactory(new PropertyValueFactory<Stipendia_zaMesaz, String>("Fio"));
                        summa.setCellValueFactory(new PropertyValueFactory<Stipendia_zaMesaz, Double>("summaR"));
                        this.mounts.setCellValueFactory(new PropertyValueFactory<Stipendia_zaMesaz, String>("mounts"));
                        stipMesaz.setItems(Stipendia_zaMesazData);

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
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
