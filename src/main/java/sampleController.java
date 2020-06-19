import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Poi.Poi_read;
import Poi.Stipendia_zaMesaz;
import Poi.godovaiaStipendia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

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

    @FXML
    private TableView<godovaiaStipendia> stipZaMesaz;
    @FXML
    private TableColumn<godovaiaStipendia, Integer> mesST_numberPP;
    @FXML
    private TableColumn<godovaiaStipendia, String> mesST_statusSt;
    @FXML
    private TableColumn<godovaiaStipendia, Integer> mesST_FIO;
    @FXML
    private TableColumn<godovaiaStipendia, String> mesST_summa;

    String pathToNewFile = null;
    String pathToOpenFile = null;
    String pathToExelFile = null;

    int indexMount;

    void zapolneniTablSoStipZaMesaz(ArrayList <godovaiaStipendia> list) {
        ObservableList<godovaiaStipendia> Stipendia_zaMesazData = FXCollections.observableArrayList();
        Stipendia_zaMesazData.addAll(list);

        mesST_numberPP.setCellValueFactory(new PropertyValueFactory<godovaiaStipendia, Integer>("numberPP"));
        mesST_statusSt.setCellValueFactory(new PropertyValueFactory<godovaiaStipendia, String>("statusSt"));
        mesST_FIO.setCellValueFactory(new PropertyValueFactory<godovaiaStipendia, Integer>("FIO"));
        mesST_summa.setCellValueFactory(new PropertyValueFactory<godovaiaStipendia, String>("summa"));
        stipZaMesaz.setItems(Stipendia_zaMesazData);
    }

    @FXML
    void initialize() {
        ObservableList<String> mounts = FXCollections.observableArrayList("Январь", "Февраль", "Март", "Апрель",
                                                                                "Май", "Июнь", "Июль", "Август",
                                                                                "Сентябрь", "Октябрь", "Ноябрь", "Декабрь");
        selectTimes.setItems(mounts);
        lab.setVisible(false);
        selectTimes.setVisible(false);

        selectTimes.setOnAction(e -> {
            int index = 0;
            switch(selectTimes.getValue()) {
                case "Январь":
                    index = 0;
                    break;
                case "Февраль":
                    index = 1;
                    break;
                case "Март":
                    index = 2;
                    break;
                case "Апрель":
                    index = 3;
                    break;
                case "Май":
                    index = 4;
                    break;
                case "Июнь":
                    index = 5;
                    break;
                case "Июль":
                    index = 6;
                    break;
                case "Август":
                    index = 7;
                    break;
                case "Сентябрь":
                    index = 8;
                    break;
                case "Октябрь":
                    index = 9;
                    break;
                case "Ноябрь":
                    index = 10;
                    break;
                case "Декабрь":
                    index = 11;
                    break;
            }
            if(selectTyprOtchot.getValue().equals("Выплата стипендии за месяц")) {
                indexMount = index;
                try {
                    Poi_read poi_read1 = new Poi_read(null);
                    zapolneniTablSoStipZaMesaz(poi_read1.readToStipZamesaz(pathToExelFile, index));

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        addOtchot.setOnAction(e->{

            switch (selectTyprOtchot.getValue()) {
                case "?" :
                    break;
                case "Выплата стипендии за месяц" :
                    try {
                        Poi_read poi_read1 = new Poi_read(null);
                        ArrayList<godovaiaStipendia> stipendia_zaMesaz = poi_read1.readToStipZamesaz(pathToExelFile, indexMount);
                        poi_read1.writeIntoExcelStipendiaMount(pathToNewFile, stipendia_zaMesaz, selectTimes.getValue());

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    break;
                case "Годовая выплата стипендии" :
                    try {
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
                    selectTimes.setValue("Январь");
                    lab.setText("Месяц");
                    otchot1.setVisible(false);
                    otchot2.setVisible(true);
                    otchot3.setVisible(false);
                    otchot4.setVisible(false);
                    tableEmpty.setVisible(false);
                    selectTimes.setItems(mounts);

                    try {
                        Poi_read poi_read1 = new Poi_read(null);
                        zapolneniTablSoStipZaMesaz(poi_read1.readToStipZamesaz(pathToExelFile, 0));

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }


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
