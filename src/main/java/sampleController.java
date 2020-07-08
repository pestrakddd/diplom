import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

import Poi.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
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
    private TableView<?> tableReestr;
    @FXML
    private TableColumn<?, ?> columndolchnost;
    @FXML
    private TableColumn<?, ?> columnNumberPP;
    @FXML
    private TableColumn<?, ?> columnNameOrFIO;
    @FXML
    private TableColumn<?, ?> columnViewTruda;
    @FXML
    private TableColumn<?, ?> columnFZPDays;
    @FXML
    private TableColumn<?, ?> columnFZPSumma;
    @FXML
    private TableColumn<?, ?> columnSochStraxDays;
    @FXML
    private TableColumn<?, ?> columnSochStraxSumma;
    @FXML
    private TableColumn<?, ?> columnStatus;
    @FXML
    private TableColumn<?, ?> columnPeriod;

    @FXML
    private Label lblYear;
    @FXML
    private TextField TF_Year;

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

    @FXML
    private AnchorPane EGE;
    @FXML
    private TableView<?> EGEOt;

    @FXML
    private TableColumn<?, ?> NameSchool;

    @FXML
    private TableColumn<?, ?> RUssianLang;

    @FXML
    private TableColumn<?, ?> _2RussianL;

    @FXML
    private TableColumn<?, ?> _3RussianL;

    @FXML
    private TableColumn<?, ?> _4RussianL;

    @FXML
    private TableColumn<?, ?> _5RussianL;

    @FXML
    private TableColumn<?, ?> RussianLObsKOL;

    @FXML
    private TableColumn<?, ?> RussianLYspevaemosti;

    @FXML
    private TableColumn<?, ?> RussianLKatZN;

    @FXML
    private TableColumn<?, ?> MatemProfil;

    @FXML
    private TableColumn<?, ?> _2Matpr;

    @FXML
    private TableColumn<?, ?> _3Matpr;

    @FXML
    private TableColumn<?, ?> _4Matpr;

    @FXML
    private TableColumn<?, ?> _5Matpr;

    @FXML
    private TableColumn<?, ?> MatprObsee;

    @FXML
    private TableColumn<?, ?> _Matpryspevae;

    @FXML
    private TableColumn<?, ?> kazhZN_Matpr;

    @FXML
    private TableColumn<?, ?> MatemBas;

    @FXML
    private TableColumn<?, ?> MatBaz2;

    @FXML
    private TableColumn<?, ?> MatBaz3;

    @FXML
    private TableColumn<?, ?> MatBaz4;

    @FXML
    private TableColumn<?, ?> MatBaz5;

    @FXML
    private TableColumn<?, ?> MatBazObsee;

    @FXML
    private TableColumn<?, ?> MatBazyspev;

    @FXML
    private TableColumn<?, ?> MatBazkachZn;

    @FXML
    private TableColumn<?, ?> Physik;

    @FXML
    private TableColumn<?, ?> physik2;

    @FXML
    private TableColumn<?, ?> physik3;

    @FXML
    private TableColumn<?, ?> physik4;

    @FXML
    private TableColumn<?, ?> physik5;

    @FXML
    private TableColumn<?, ?> physikObsee;

    @FXML
    private TableColumn<?, ?> physikYspev;

    @FXML
    private TableColumn<?, ?> physikKatch;

    @FXML
    private TableColumn<?, ?> Xummi;

    @FXML
    private TableColumn<?, ?> Xiimia2;

    @FXML
    private TableColumn<?, ?> Xiimia3;

    @FXML
    private TableColumn<?, ?> Xiimia4;

    @FXML
    private TableColumn<?, ?> Xiimia5;

    @FXML
    private TableColumn<?, ?> Xiimiaobsee;

    @FXML
    private TableColumn<?, ?> Xiimiayspevaem;

    @FXML
    private TableColumn<?, ?> XiimiakachZn;

    @FXML
    private TableColumn<?, ?> informatika;

    @FXML
    private TableColumn<?, ?> unfa2;

    @FXML
    private TableColumn<?, ?> unfa3;

    @FXML
    private TableColumn<?, ?> unfa4;

    @FXML
    private TableColumn<?, ?> unfa5;

    @FXML
    private TableColumn<?, ?> unfaObsee;

    @FXML
    private TableColumn<?, ?> unfaYspevaem;

    @FXML
    private TableColumn<?, ?> unfakachest;

    @FXML
    private TableColumn<?, ?> biologia;

    @FXML
    private TableColumn<?, ?> biolog2;

    @FXML
    private TableColumn<?, ?> biolog3;

    @FXML
    private TableColumn<?, ?> biolog4;

    @FXML
    private TableColumn<?, ?> biolo5;

    @FXML
    private TableColumn<?, ?> biologObsee;

    @FXML
    private TableColumn<?, ?> biologYspevaemost;

    @FXML
    private TableColumn<?, ?> biologKach;

    @FXML
    private TableColumn<?, ?> History;

    @FXML
    private TableColumn<?, ?> histor2;

    @FXML
    private TableColumn<?, ?> histor3;

    @FXML
    private TableColumn<?, ?> histor4;

    @FXML
    private TableColumn<?, ?> histor5;

    @FXML
    private TableColumn<?, ?> historObsee;

    @FXML
    private TableColumn<?, ?> historYspevaemosti;

    @FXML
    private TableColumn<?, ?> historKachestvo;

    @FXML
    private TableColumn<?, ?> georafia;

    @FXML
    private TableColumn<?, ?> georaf2;

    @FXML
    private TableColumn<?, ?> georaf3;

    @FXML
    private TableColumn<?, ?> georaf4;

    @FXML
    private TableColumn<?, ?> georaf5;

    @FXML
    private TableColumn<?, ?> georafobsee;

    @FXML
    private TableColumn<?, ?> georafYspev;

    @FXML
    private TableColumn<?, ?> georafKache;

    @FXML
    private TableColumn<?, ?> Angliiskii;

    @FXML
    private TableColumn<?, ?> angl2;

    @FXML
    private TableColumn<?, ?> angl3;

    @FXML
    private TableColumn<?, ?> angl4;

    @FXML
    private TableColumn<?, ?> angl5;

    @FXML
    private TableColumn<?, ?> anglObsee;

    @FXML
    private TableColumn<?, ?> anglYspevae;

    @FXML
    private TableColumn<?, ?> anglkachestv;

    @FXML
    private TableColumn<?, ?> obshestvo;

    @FXML
    private TableColumn<?, ?> Obsestvo2;

    @FXML
    private TableColumn<?, ?> Obsestvo3;

    @FXML
    private TableColumn<?, ?> Obsestvo4;

    @FXML
    private TableColumn<?, ?> Obsestvo5;

    @FXML
    private TableColumn<?, ?> ObsestvoObsee;

    @FXML
    private TableColumn<?, ?> ObsestvoYspev;

    @FXML
    private TableColumn<?, ?> ObsestvoKatche;

    @FXML
    private TableColumn<?, ?> literatura;

    @FXML
    private TableColumn<?, ?> liter2;

    @FXML
    private TableColumn<?, ?> liter3;

    @FXML
    private TableColumn<?, ?> liter4;

    @FXML
    private TableColumn<?, ?> liter5;

    @FXML
    private TableColumn<?, ?> literObsee;

    @FXML
    private TableColumn<?, ?> literyspeva;

    @FXML
    private TableColumn<?, ?> literKat;

    //TODO Functioanal 299 line

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
        lblYear.setVisible(false);
        TF_Year.setVisible(false);

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
            switch (selectTyprOtchot.getValue()) {
                case "Выплата стипендии за месяц":
                    indexMount = index;
                    try {
                        Poi_read poi_read1 = new Poi_read();
                        zapolneniTablSoStipZaMesaz(poi_read1.readToStipZamesaz(pathToExelFile, index));

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "Реестр":
//                    счиывем данные из файла
//                    indexMount = index;
//                    try {
//                        Poi_read poi_read1 = new Poi_read();
//                        zapolneniTablSoStipZaMesaz(poi_read1.readToStipZamesaz(pathToExelFile, index));
//
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
                    break;
            }
        });

        addOtchot.setOnAction(e->{

            switch (selectTyprOtchot.getValue()) {
                case "Реестр" :
                    //считываем данные из файла
                    //
                    //
                    break;
                case "Выплата стипендии за месяц" :
                    try {
                        Poi_read poi_read1 = new Poi_read();
                        ArrayList<godovaiaStipendia> stipendia_zaMesaz = poi_read1.readToStipZamesaz(pathToExelFile, indexMount);
                        if (poi_read1.writeIntoExcelStipendiaMount(pathToNewFile, stipendia_zaMesaz, selectTimes.getValue())) {
                            System.out.println("Вы знаете что такое успех?..");
                            JFrame topFrame = (JFrame)SwingUtilities.getWindowAncestor(this);
                            JOptionPane.showMessageDialog(topFrame, "Файл успешно создан!");
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "Годовая выплата стипендии" :
                    try {
                        Poi_read poi_read = new Poi_read();
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
                case "ЕГЭ" :
                    Poi_read poi_read = new Poi_read();
                    try {
                        poi_read.readToEGE(pathToExelFile);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
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
        EGE.setVisible(false);
        tableEmpty.setVisible(true);

        ObservableList<String> typeOtchot = FXCollections.observableArrayList("Выплата стипендии за месяц", "Годовая выплата стипендии", "Реестр", "ЕГЭ");
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
            EGE.setVisible(false);
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
                        Poi_read poi_read1 = new Poi_read();
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

                        Poi_read poi_read = new Poi_read();
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
                case "Реестр":
                    otchot1.setVisible(true);
                    otchot2.setVisible(false);
                    otchot3.setVisible(false);
                    otchot4.setVisible(false);
                    tableEmpty.setVisible(false);
                    lab.setText("Месяц");
                    selectTimes.setValue("Январь");
                    selectTimes.setItems(mounts);
                    break;
                case "ЕГЭ":
                    EGE.setVisible(true);
                    otchot1.setVisible(false);
                    otchot2.setVisible(false);
                    otchot3.setVisible(false);
                    otchot4.setVisible(false);
                    tableEmpty.setVisible(false);
                    Poi_read poi_read = new Poi_read();
                    ArrayList <EGE> eges = new ArrayList<>();
                    try {
                        eges =  poi_read.readToEGE(pathToExelFile);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    ArrayList <EGEOtcot> egeOtcots = new ArrayList<>();
                    eges.forEach(el -> {
                        egeOtcots.add(new EGEOtcot());
                        ArrayList<Predmet> predmets = el.getPredmets();
                        egeOtcots.get(egeOtcots.size() - 1).setNameSchool(el.getNameSchool());
                        egeOtcots.get(egeOtcots.size() - 1).setRus2(predmets.get(0).getCount2());
                        egeOtcots.get(egeOtcots.size() - 1).setRus3(predmets.get(0).getCount3());
                        egeOtcots.get(egeOtcots.size() - 1).setRus4(predmets.get(0).getCount4());
                        egeOtcots.get(egeOtcots.size() - 1).setRus5(predmets.get(0).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setRusObs(predmets.get(0).getCount2() + predmets.get(0).getCount3() + predmets.get(0).getCount4() + predmets.get(0).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setRusYsp(((predmets.get(0).getCount3() + predmets.get(0).getCount4() + predmets.get(0).getCount5()) * 100) /
                                (predmets.get(0).getCount2() + predmets.get(0).getCount3() + predmets.get(0).getCount4() + predmets.get(0).getCount5()));

                        egeOtcots.get(egeOtcots.size() - 1).setRusKat(((predmets.get(0).getCount4() + predmets.get(0).getCount5()) * 100) /
                                (predmets.get(0).getCount2() + predmets.get(0).getCount3() + predmets.get(0).getCount4() + predmets.get(0).getCount5()));


                        egeOtcots.get(egeOtcots.size() - 1).setMatPr2(predmets.get(1).getCount2());
                        egeOtcots.get(egeOtcots.size() - 1).setMatPr3(predmets.get(1).getCount3());
                        egeOtcots.get(egeOtcots.size() - 1).setMatPr4(predmets.get(1).getCount4());
                        egeOtcots.get(egeOtcots.size() - 1).setMatPr5(predmets.get(1).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setMatPrObs(predmets.get(1).getCount2() + predmets.get(1).getCount3() + predmets.get(1).getCount4() + predmets.get(1).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setMatPrYsp(((predmets.get(1).getCount3() + predmets.get(1).getCount4() + predmets.get(1).getCount5()) * 100 )/
                                (predmets.get(1).getCount2() + predmets.get(1).getCount3() + predmets.get(1).getCount4() + predmets.get(1).getCount5()));
                        egeOtcots.get(egeOtcots.size() - 1).setRusKat(((predmets.get(1).getCount4() + predmets.get(1).getCount5()) * 100) /
                                (predmets.get(1).getCount2() + predmets.get(1).getCount3() + predmets.get(1).getCount4() + predmets.get(1).getCount5()));

                        egeOtcots.get(egeOtcots.size() - 1).setMatBas2(predmets.get(2).getCount2());
                        egeOtcots.get(egeOtcots.size() - 1).setMatBas3(predmets.get(2).getCount3());
                        egeOtcots.get(egeOtcots.size() - 1).setMatBas4(predmets.get(2).getCount4());
                        egeOtcots.get(egeOtcots.size() - 1).setMatBas5(predmets.get(2).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setMatBasObs(predmets.get(2).getCount2() + predmets.get(2).getCount3() + predmets.get(2).getCount4() + predmets.get(2).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setMatBasYsp(((predmets.get(2).getCount3() + predmets.get(2).getCount4() + predmets.get(2).getCount5()) * 100) /
                                (predmets.get(2).getCount2() + predmets.get(2).getCount3() + predmets.get(2).getCount4() + predmets.get(2).getCount5()));
                        egeOtcots.get(egeOtcots.size() - 1).setRusKat(((predmets.get(2).getCount4() + predmets.get(2).getCount5()) * 100 )/
                                (predmets.get(2).getCount2() + predmets.get(2).getCount3() + predmets.get(2).getCount4() + predmets.get(2).getCount5()));

                        egeOtcots.get(egeOtcots.size() - 1).setPhysik2(predmets.get(3).getCount2());
                        egeOtcots.get(egeOtcots.size() - 1).setPhysik3(predmets.get(3).getCount3());
                        egeOtcots.get(egeOtcots.size() - 1).setPhysik4(predmets.get(3).getCount4());
                        egeOtcots.get(egeOtcots.size() - 1).setPhysik5(predmets.get(3).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setPhysikObs(predmets.get(3).getCount2() + predmets.get(3).getCount3() + predmets.get(3).getCount4() + predmets.get(3).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setPhysikYsp(((predmets.get(3).getCount3() + predmets.get(3).getCount4() + predmets.get(3).getCount5()) * 100) /
                                (predmets.get(3).getCount2() + predmets.get(3).getCount3() + predmets.get(3).getCount4() + predmets.get(3).getCount5()));
                        egeOtcots.get(egeOtcots.size() - 1).setRusKat(((predmets.get(3).getCount4() + predmets.get(3).getCount5()) * 100) /
                                (predmets.get(3).getCount2() + predmets.get(3).getCount3() + predmets.get(3).getCount4() + predmets.get(3).getCount5()));

                        egeOtcots.get(egeOtcots.size() - 1).setXummi2(predmets.get(4).getCount2());
                        egeOtcots.get(egeOtcots.size() - 1).setXummi3(predmets.get(4).getCount3());
                        egeOtcots.get(egeOtcots.size() - 1).setXummi4(predmets.get(4).getCount4());
                        egeOtcots.get(egeOtcots.size() - 1).setXummi5(predmets.get(4).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setXummiObs(predmets.get(4).getCount2() + predmets.get(4).getCount3() + predmets.get(4).getCount4() + predmets.get(4).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setXummiYsp(((predmets.get(4).getCount3() + predmets.get(4).getCount4() + predmets.get(4).getCount5()) * 100 )/
                                (predmets.get(4).getCount2() + predmets.get(4).getCount3() + predmets.get(4).getCount4() + predmets.get(4).getCount5()));
                        egeOtcots.get(egeOtcots.size() - 1).setRusKat(((predmets.get(4).getCount4() + predmets.get(4).getCount5()) * 100) /
                                (predmets.get(4).getCount2() + predmets.get(4).getCount3() + predmets.get(4).getCount4() + predmets.get(4).getCount5()));

                        egeOtcots.get(egeOtcots.size() - 1).setInfa2(predmets.get(5).getCount2());
                        egeOtcots.get(egeOtcots.size() - 1).setInfa3(predmets.get(5).getCount3());
                        egeOtcots.get(egeOtcots.size() - 1).setInfa4(predmets.get(5).getCount4());
                        egeOtcots.get(egeOtcots.size() - 1).setInfa5(predmets.get(5).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setInfaObs(predmets.get(5).getCount2() + predmets.get(5).getCount3() + predmets.get(5).getCount4() + predmets.get(5).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setInfaYsp(((predmets.get(5).getCount3() + predmets.get(5).getCount4() + predmets.get(5).getCount5()) * 100) /
                                (predmets.get(5).getCount2() + predmets.get(5).getCount3() + predmets.get(5).getCount4() + predmets.get(5).getCount5()));
                        egeOtcots.get(egeOtcots.size() - 1).setRusKat(((predmets.get(5).getCount4() + predmets.get(5).getCount5()) * 100) /
                                (predmets.get(5).getCount2() + predmets.get(5).getCount3() + predmets.get(5).getCount4() + predmets.get(5).getCount5()));


                        egeOtcots.get(egeOtcots.size() - 1).setBio2(predmets.get(6).getCount2());
                        egeOtcots.get(egeOtcots.size() - 1).setBio3(predmets.get(6).getCount3());
                        egeOtcots.get(egeOtcots.size() - 1).setBio4(predmets.get(6).getCount4());
                        egeOtcots.get(egeOtcots.size() - 1).setBio5(predmets.get(6).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setBioObs(predmets.get(6).getCount2() + predmets.get(6).getCount3() + predmets.get(6).getCount4() + predmets.get(6).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setInfaYsp(((predmets.get(6).getCount3() + predmets.get(6).getCount4() + predmets.get(6).getCount5()) * 100) /
                                (predmets.get(6).getCount2() + predmets.get(6).getCount3() + predmets.get(6).getCount4() + predmets.get(6).getCount5()));
                        egeOtcots.get(egeOtcots.size() - 1).setRusKat(((predmets.get(6).getCount4() + predmets.get(6).getCount5()) * 100 )/
                                (predmets.get(6).getCount2() + predmets.get(6).getCount3() + predmets.get(6).getCount4() + predmets.get(6).getCount5()));

                        egeOtcots.get(egeOtcots.size() - 1).setGeo2(predmets.get(7).getCount2());
                        egeOtcots.get(egeOtcots.size() - 1).setGeo3(predmets.get(7).getCount3());
                        egeOtcots.get(egeOtcots.size() - 1).setGeo4(predmets.get(7).getCount4());
                        egeOtcots.get(egeOtcots.size() - 1).setGeo5(predmets.get(7).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setGeoObs(predmets.get(7).getCount2() + predmets.get(7).getCount3() + predmets.get(7).getCount4() + predmets.get(7).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setInfaYsp(((predmets.get(7).getCount3() + predmets.get(7).getCount4() + predmets.get(7).getCount5()) * 100 )/
                                (predmets.get(7).getCount2() + predmets.get(7).getCount3() + predmets.get(7).getCount4() + predmets.get(7).getCount5()));
                        egeOtcots.get(egeOtcots.size() - 1).setRusKat(((predmets.get(7).getCount4() + predmets.get(7).getCount5()) * 100 )/
                                (predmets.get(7).getCount2() + predmets.get(7).getCount3() + predmets.get(7).getCount4() + predmets.get(7).getCount5()));

                        egeOtcots.get(egeOtcots.size() - 1).setAngl2(predmets.get(8).getCount2());
                        egeOtcots.get(egeOtcots.size() - 1).setAngl3(predmets.get(8).getCount3());
                        egeOtcots.get(egeOtcots.size() - 1).setAngl4(predmets.get(8).getCount4());
                        egeOtcots.get(egeOtcots.size() - 1).setAngl5(predmets.get(8).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setAnglObs(predmets.get(8).getCount2() + predmets.get(8).getCount3() + predmets.get(8).getCount4() + predmets.get(8).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setInfaYsp(((predmets.get(8).getCount3() + predmets.get(8).getCount4() + predmets.get(8).getCount5()) * 100 )/
                                (predmets.get(8).getCount2() + predmets.get(8).getCount3() + predmets.get(8).getCount4() + predmets.get(8).getCount5()));
                        egeOtcots.get(egeOtcots.size() - 1).setRusKat(((predmets.get(8).getCount4() + predmets.get(8).getCount5()) * 100) /
                                (predmets.get(8).getCount2() + predmets.get(8).getCount3() + predmets.get(8).getCount4() + predmets.get(8).getCount5()));

                        egeOtcots.get(egeOtcots.size() - 1).setObsestv2(predmets.get(9).getCount2());
                        egeOtcots.get(egeOtcots.size() - 1).setObsestv3(predmets.get(9).getCount3());
                        egeOtcots.get(egeOtcots.size() - 1).setObsestv4(predmets.get(9).getCount4());
                        egeOtcots.get(egeOtcots.size() - 1).setObsestv5(predmets.get(9).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setObsestvObs(predmets.get(9).getCount2() + predmets.get(9).getCount3() + predmets.get(9).getCount4() + predmets.get(9).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setInfaYsp(((predmets.get(9).getCount3() + predmets.get(9).getCount4() + predmets.get(9).getCount5()) * 100) /
                                (predmets.get(9).getCount2() + predmets.get(9).getCount3() + predmets.get(9).getCount4() + predmets.get(9).getCount5()));
                        egeOtcots.get(egeOtcots.size() - 1).setRusKat(((predmets.get(9).getCount4() + predmets.get(9).getCount5()) * 100) /
                                (predmets.get(9).getCount2() + predmets.get(9).getCount3() + predmets.get(9).getCount4() + predmets.get(9).getCount5()));

                        egeOtcots.get(egeOtcots.size() - 1).setObsestv2(predmets.get(10).getCount2());
                        egeOtcots.get(egeOtcots.size() - 1).setObsestv3(predmets.get(10).getCount3());
                        egeOtcots.get(egeOtcots.size() - 1).setObsestv4(predmets.get(10).getCount4());
                        egeOtcots.get(egeOtcots.size() - 1).setObsestv5(predmets.get(10).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setObsestvObs(predmets.get(10).getCount2() + predmets.get(10).getCount3() + predmets.get(10).getCount4() + predmets.get(10).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setInfaYsp(((predmets.get(10).getCount3() + predmets.get(10).getCount4() + predmets.get(10).getCount5()) * 100) /
                                (predmets.get(10).getCount2() + predmets.get(10).getCount3() + predmets.get(10).getCount4() + predmets.get(10).getCount5()));
                        egeOtcots.get(egeOtcots.size() - 1).setRusKat(((predmets.get(10).getCount4() + predmets.get(10).getCount5()) * 100) /
                                (predmets.get(10).getCount2() + predmets.get(10).getCount3() + predmets.get(10).getCount4() + predmets.get(10).getCount5()));

                        egeOtcots.get(egeOtcots.size() - 1).setLiter2(predmets.get(11).getCount2());
                        egeOtcots.get(egeOtcots.size() - 1).setLiter3(predmets.get(11).getCount3());
                        egeOtcots.get(egeOtcots.size() - 1).setLiter4(predmets.get(11).getCount4());
                        egeOtcots.get(egeOtcots.size() - 1).setLiter5(predmets.get(11).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setLiterObs(predmets.get(11).getCount2() + predmets.get(11).getCount3() + predmets.get(11).getCount4() + predmets.get(11).getCount5());
                        egeOtcots.get(egeOtcots.size() - 1).setInfaYsp(((predmets.get(11).getCount3() + predmets.get(11).getCount4() + predmets.get(11).getCount5()) * 100) /
                                (predmets.get(11).getCount2() + predmets.get(11).getCount3() + predmets.get(11).getCount4() + predmets.get(11).getCount5()));
                        egeOtcots.get(egeOtcots.size() - 1).setRusKat(((predmets.get(11).getCount4() + predmets.get(11).getCount5()) * 100) /
                                (predmets.get(11).getCount2() + predmets.get(11).getCount3() + predmets.get(11).getCount4() + predmets.get(11).getCount5()));
                    });

//                    numberPP.setCellValueFactory(new PropertyValueFactory<Stipendia_zaMesaz, Integer>("numberPP"));
//                    statusStudent.setCellValueFactory(new PropertyValueFactory<Stipendia_zaMesaz, String>("statusStudent"));
//                    FIO.setCellValueFactory(new PropertyValueFactory<Stipendia_zaMesaz, String>("Fio"));
//                    summa.setCellValueFactory(new PropertyValueFactory<Stipendia_zaMesaz, Double>("summaR"));
//                    this.mounts.setCellValueFactory(new PropertyValueFactory<Stipendia_zaMesaz, String>("mounts"));
//                    stipMesaz.setItems(Stipendia_zaMesazData);
                    break;
            }
        });

        openFile.setOnAction(e -> {
            String pathToFile = openFileController.start();
        });

    }
}
