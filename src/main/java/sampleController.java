import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
    private TableView<EGEOtcot> EGEOt;

    @FXML
    private TableColumn<EGEOtcot, String> NameSchool;

    @FXML
    private TableColumn<?, ?> RUssianLang;

    @FXML
    private TableColumn<EGEOtcot, Integer> _2RussianL;

    @FXML
    private TableColumn<EGEOtcot, Integer> _3RussianL;

    @FXML
    private TableColumn<EGEOtcot, Integer> _4RussianL;

    @FXML
    private TableColumn<EGEOtcot, Integer> _5RussianL;

    @FXML
    private TableColumn<EGEOtcot, Integer> RussianLObsKOL;

    @FXML
    private TableColumn<EGEOtcot, Integer> RussianLYspevaemosti;

    @FXML
    private TableColumn<EGEOtcot, Integer> RussianLKatZN;

    @FXML
    private TableColumn<EGEOtcot, Integer> MatemProfil;

    @FXML
    private TableColumn<EGEOtcot, Integer> _2Matpr;

    @FXML
    private TableColumn<EGEOtcot, Integer> _3Matpr;

    @FXML
    private TableColumn<EGEOtcot, Integer> _4Matpr;

    @FXML
    private TableColumn<EGEOtcot, Integer> _5Matpr;

    @FXML
    private TableColumn<EGEOtcot, Integer> MatprObsee;

    @FXML
    private TableColumn<EGEOtcot, Integer> _Matpryspevae;

    @FXML
    private TableColumn<EGEOtcot, Integer> kazhZN_Matpr;

    @FXML
    private TableColumn<EGEOtcot, Integer> MatemBas;

    @FXML
    private TableColumn<EGEOtcot, Integer> MatBaz2;

    @FXML
    private TableColumn<EGEOtcot, Integer> MatBaz3;

    @FXML
    private TableColumn<EGEOtcot, Integer> MatBaz4;

    @FXML
    private TableColumn<EGEOtcot, Integer> MatBaz5;

    @FXML
    private TableColumn<EGEOtcot, Integer> MatBazObsee;

    @FXML
    private TableColumn<EGEOtcot, Integer> MatBazyspev;

    @FXML
    private TableColumn<EGEOtcot, Integer> MatBazkachZn;

    @FXML
    private TableColumn<EGEOtcot, Integer> Physik;

    @FXML
    private TableColumn<EGEOtcot, Integer> physik2;

    @FXML
    private TableColumn<EGEOtcot, Integer> physik3;

    @FXML
    private TableColumn<EGEOtcot, Integer> physik4;

    @FXML
    private TableColumn<EGEOtcot, Integer> physik5;

    @FXML
    private TableColumn<EGEOtcot, Integer> physikObsee;

    @FXML
    private TableColumn<EGEOtcot, Integer> physikYspev;

    @FXML
    private TableColumn<EGEOtcot, Integer> physikKatch;

    @FXML
    private TableColumn<EGEOtcot, Integer> Xummi;

    @FXML
    private TableColumn<EGEOtcot, Integer> Xiimia2;

    @FXML
    private TableColumn<EGEOtcot, Integer> Xiimia3;

    @FXML
    private TableColumn<EGEOtcot, Integer> Xiimia4;

    @FXML
    private TableColumn<EGEOtcot, Integer> Xiimia5;

    @FXML
    private TableColumn<EGEOtcot, Integer> Xiimiaobsee;

    @FXML
    private TableColumn<EGEOtcot, Integer> Xiimiayspevaem;

    @FXML
    private TableColumn<EGEOtcot, Integer> XiimiakachZn;

    @FXML
    private TableColumn<EGEOtcot, Integer> informatika;

    @FXML
    private TableColumn<EGEOtcot, Integer> unfa2;

    @FXML
    private TableColumn<EGEOtcot, Integer> unfa3;

    @FXML
    private TableColumn<EGEOtcot, Integer> unfa4;

    @FXML
    private TableColumn<EGEOtcot, Integer> unfa5;

    @FXML
    private TableColumn<EGEOtcot, Integer> unfaObsee;

    @FXML
    private TableColumn<EGEOtcot, Integer> unfaYspevaem;

    @FXML
    private TableColumn<EGEOtcot, Integer> unfakachest;

    @FXML
    private TableColumn<EGEOtcot, Integer> biologia;

    @FXML
    private TableColumn<EGEOtcot, Integer> biolog2;

    @FXML
    private TableColumn<EGEOtcot, Integer> biolog3;

    @FXML
    private TableColumn<EGEOtcot, Integer> biolog4;

    @FXML
    private TableColumn<EGEOtcot, Integer> biolo5;

    @FXML
    private TableColumn<EGEOtcot, Integer> biologObsee;

    @FXML
    private TableColumn<EGEOtcot, Integer> biologYspevaemost;

    @FXML
    private TableColumn<EGEOtcot, Integer> biologKach;

    @FXML
    private TableColumn<EGEOtcot, Integer> History;

    @FXML
    private TableColumn<EGEOtcot, Integer> histor2;

    @FXML
    private TableColumn<EGEOtcot, Integer> histor3;

    @FXML
    private TableColumn<EGEOtcot, Integer> histor4;

    @FXML
    private TableColumn<EGEOtcot, Integer> histor5;

    @FXML
    private TableColumn<EGEOtcot, Integer> historObsee;

    @FXML
    private TableColumn<EGEOtcot, Integer> historYspevaemosti;

    @FXML
    private TableColumn<EGEOtcot, Integer> historKachestvo;

    @FXML
    private TableColumn<EGEOtcot, Integer> georafia;

    @FXML
    private TableColumn<EGEOtcot, Integer> georaf2;

    @FXML
    private TableColumn<EGEOtcot, Integer> georaf3;

    @FXML
    private TableColumn<EGEOtcot, Integer> georaf4;

    @FXML
    private TableColumn<EGEOtcot, Integer> georaf5;

    @FXML
    private TableColumn<EGEOtcot, Integer> georafobsee;

    @FXML
    private TableColumn<EGEOtcot, Integer> georafYspev;

    @FXML
    private TableColumn<EGEOtcot, Integer> georafKache;

    @FXML
    private TableColumn<EGEOtcot, Integer> Angliiskii;

    @FXML
    private TableColumn<EGEOtcot, Integer> angl2;

    @FXML
    private TableColumn<EGEOtcot, Integer> angl3;

    @FXML
    private TableColumn<EGEOtcot, Integer> angl4;

    @FXML
    private TableColumn<EGEOtcot, Integer> angl5;

    @FXML
    private TableColumn<EGEOtcot, Integer> anglObsee;

    @FXML
    private TableColumn<EGEOtcot, Integer> anglYspevae;

    @FXML
    private TableColumn<EGEOtcot, Integer> anglkachestv;

    @FXML
    private TableColumn<EGEOtcot, Integer> obshestvo;

    @FXML
    private TableColumn<EGEOtcot, Integer> Obsestvo2;

    @FXML
    private TableColumn<EGEOtcot, Integer> Obsestvo3;

    @FXML
    private TableColumn<EGEOtcot, Integer> Obsestvo4;

    @FXML
    private TableColumn<EGEOtcot, Integer> Obsestvo5;

    @FXML
    private TableColumn<EGEOtcot, Integer> ObsestvoObsee;

    @FXML
    private TableColumn<EGEOtcot, Integer> ObsestvoYspev;

    @FXML
    private TableColumn<EGEOtcot, Integer> ObsestvoKatche;

    @FXML
    private TableColumn<EGEOtcot, Integer> literatura;

    @FXML
    private TableColumn<EGEOtcot, Integer> liter2;

    @FXML
    private TableColumn<EGEOtcot, Integer> liter3;

    @FXML
    private TableColumn<EGEOtcot, Integer> liter4;

    @FXML
    private TableColumn<EGEOtcot, Integer> liter5;

    @FXML
    private TableColumn<EGEOtcot, Integer> literObsee;

    @FXML
    private TableColumn<EGEOtcot, Integer> literyspeva;

    @FXML
    private TableColumn<EGEOtcot, Integer> literKat;

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

        workPane.toFront();

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
                        ArrayList <EGE> eges = poi_read.readToEGE(pathToExelFile);
                        ArrayList <EGEOtcot> egeOtcots = ConvertEGE(eges);
                        if (poi_read.writeIntoExcelEge(pathToNewFile, egeOtcots)) {
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

        ObservableList<String> typeOtchot = FXCollections.observableArrayList("Выплата стипендии за месяц", "Годовая выплата стипендии", "ЕГЭ");
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
                    EGE.setVisible(false);
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
                    EGE.setVisible(false);

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
                    EGE.setVisible(false);
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

                    ObservableList<EGEOtcot> egeOtcotstable = FXCollections.observableArrayList();
                    Poi_read poi_read = new Poi_read();
                    ArrayList <EGE> eges = new ArrayList<>();
                    try {
                        eges =  poi_read.readToEGE(pathToExelFile);
                        ArrayList <EGEOtcot> egeOtcots = ConvertEGE(eges);

                        egeOtcots.forEach(el -> {
                            System.out.print(el.getNameSchool() + " ");
                            System.out.print(el.getPhysik2() + " ");
                            System.out.print(el.getPhysik3() + " ");
                            System.out.print(el.getPhysik4() + " ");
                            System.out.print(el.getPhysik5() + " ");
                            System.out.print(el.getPhysikObs() + " ");
                            System.out.print(el.getPhysikKat() + " ");
                            System.out.print(el.getPhysikYsp() + "\n");
                        });

                        egeOtcotstable.addAll(egeOtcots);

                        NameSchool.setCellValueFactory(new PropertyValueFactory<EGEOtcot, String>("nameSchool"));
                        _2RussianL.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("Rus2"));
                        _3RussianL.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("Rus3"));
                        _4RussianL.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("Rus4"));
                        _5RussianL.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("Rus5"));
                        RussianLObsKOL.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("RusObs"));
                        RussianLYspevaemosti.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("RusYsp"));
                        RussianLKatZN.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("RusKat"));

                        _2Matpr.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("MatPr2"));
                        _3Matpr.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("MatPr3"));
                        _4Matpr.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("MatPr4"));
                        _5Matpr.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("MatPr5"));
                        MatprObsee.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("MatPrObs"));
                        _Matpryspevae.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("MatPrYsp"));
                        kazhZN_Matpr.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("MatPrKat"));

                        MatBaz2.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("MatBas2"));
                        MatBaz3.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("MatBas3"));
                        MatBaz4.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("MatBas4"));
                        MatBaz5.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("MatBas5"));
                        MatBazObsee.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("MatBasObs"));
                        MatBazyspev.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("MatBasYsp"));
                        MatBazkachZn.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("MatBasKat"));

                        physik2.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("physik2"));
                        physik3.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("physik3"));
                        physik4.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("physik4"));
                        physik5.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("physik5"));
                        physikObsee.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("physikObs"));
                        physikYspev.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("physikYsp"));
                        physikKatch.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("physikKat"));

                        Xiimia2.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("xummi2"));
                        Xiimia3.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("xummi3"));
                        Xiimia4.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("xummi4"));
                        Xiimia5.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("xummi5"));
                        Xiimiaobsee.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("xummiObs"));
                        Xiimiayspevaem.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("xummiYsp"));
                        XiimiakachZn.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("xummiKat"));

                        unfa2.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("infa2"));
                        unfa3.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("infa3"));
                        unfa4.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("infa4"));
                        unfa5.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("infa5"));
                        unfaObsee.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("infaObs"));
                        unfaYspevaem.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("infaYsp"));
                        unfakachest.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("infaKat"));

                        biolog2.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("bio2"));
                        biolog3.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("bio3"));
                        biolog4.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("bio4"));
                        biolo5.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("bio5"));
                        biologObsee.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("bioObs"));
                        biologYspevaemost.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("bioYsp"));
                        biologKach.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("bioKat"));

                        histor2.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("his2"));
                        histor3.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("his3"));
                        histor4.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("his4"));
                        histor5.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("his5"));
                        historObsee.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("hisObs"));
                        historYspevaemosti.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("hisYsp"));
                        historKachestvo.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("hisKat"));

                        georaf2.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("geo2"));
                        georaf3.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("geo3"));
                        georaf4.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("geo4"));
                        georaf5.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("geo5"));
                        georafobsee.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("geoObs"));
                        georafYspev.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("geoYsp"));
                        georafKache.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("geoKat"));

                        angl2.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("angl1"));
                        angl3.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("angl2"));
                        angl4.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("angl3"));
                        angl5.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("angl4"));
                        anglObsee.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("anglObs"));
                        anglYspevae.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("anglYsp"));
                        anglkachestv.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("anglKat"));

                        Obsestvo2.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("obsestv2"));
                        Obsestvo3.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("obsestv3"));
                        Obsestvo4.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("obsestv4"));
                        Obsestvo5.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("obsestv5"));
                        ObsestvoObsee.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("obsestvObs"));
                        ObsestvoYspev.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("obsestvYsp"));
                        ObsestvoKatche.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("obsestvKat"));

                        liter2.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("liter2"));
                        liter3.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("liter3"));
                        liter4.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("liter4"));
                        liter5.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("liter5"));
                        literObsee.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("literObs"));
                        literyspeva.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("literYsp"));
                        literKat.setCellValueFactory(new PropertyValueFactory<EGEOtcot, Integer>("literKat"));

                        EGEOt.setItems(egeOtcotstable);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    break;
            }
        });

        openFile.setOnAction(e -> {
            String pathToFile = openFileController.start();
        });

    }

    ArrayList <EGEOtcot> ConvertEGE (ArrayList <EGE> eges) {
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
            egeOtcots.get(egeOtcots.size() - 1).setRusYsp(((egeOtcots.get(egeOtcots.size() - 1).getRus3() + egeOtcots.get(egeOtcots.size() - 1).getRus4() + egeOtcots.get(egeOtcots.size() - 1).getRus5()) /
                    (egeOtcots.get(egeOtcots.size() - 1).getRusObs()) * 100));

            double a = egeOtcots.get(egeOtcots.size() - 1).getRus4() + egeOtcots.get(egeOtcots.size() - 1).getRus5();
            double b = egeOtcots.get(egeOtcots.size() - 1).getRusObs();
            egeOtcots.get(egeOtcots.size() - 1).setRusKat( a * 100 / b);


            egeOtcots.get(egeOtcots.size() - 1).setMatPr2(predmets.get(1).getCount2());
            egeOtcots.get(egeOtcots.size() - 1).setMatPr3(predmets.get(1).getCount3());
            egeOtcots.get(egeOtcots.size() - 1).setMatPr4(predmets.get(1).getCount4());
            egeOtcots.get(egeOtcots.size() - 1).setMatPr5(predmets.get(1).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setMatPrObs(predmets.get(1).getCount2() + predmets.get(1).getCount3() + predmets.get(1).getCount4() + predmets.get(1).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setMatPrYsp(((predmets.get(1).getCount3() + predmets.get(1).getCount4() + predmets.get(1).getCount5()) * 100 )/
                    (predmets.get(1).getCount2() + predmets.get(1).getCount3() + predmets.get(1).getCount4() + predmets.get(1).getCount5()));
            egeOtcots.get(egeOtcots.size() - 1).setMatPrKat(((predmets.get(1).getCount4() + predmets.get(1).getCount5()) * 100) /
                    (predmets.get(1).getCount2() + predmets.get(1).getCount3() + predmets.get(1).getCount4() + predmets.get(1).getCount5()));

            egeOtcots.get(egeOtcots.size() - 1).setMatBas2(predmets.get(2).getCount2());
            egeOtcots.get(egeOtcots.size() - 1).setMatBas3(predmets.get(2).getCount3());
            egeOtcots.get(egeOtcots.size() - 1).setMatBas4(predmets.get(2).getCount4());
            egeOtcots.get(egeOtcots.size() - 1).setMatBas5(predmets.get(2).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setMatBasObs(predmets.get(2).getCount2() + predmets.get(2).getCount3() + predmets.get(2).getCount4() + predmets.get(2).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setMatBasYsp(((predmets.get(2).getCount3() + predmets.get(2).getCount4() + predmets.get(2).getCount5()) * 100) /
                    (predmets.get(2).getCount2() + predmets.get(2).getCount3() + predmets.get(2).getCount4() + predmets.get(2).getCount5()));
            egeOtcots.get(egeOtcots.size() - 1).setMatBasKat(((predmets.get(2).getCount4() + predmets.get(2).getCount5()) * 100 )/
                    (predmets.get(2).getCount2() + predmets.get(2).getCount3() + predmets.get(2).getCount4() + predmets.get(2).getCount5()));

            egeOtcots.get(egeOtcots.size() - 1).setPhysik2(predmets.get(3).getCount2());
            egeOtcots.get(egeOtcots.size() - 1).setPhysik3(predmets.get(3).getCount3());
            egeOtcots.get(egeOtcots.size() - 1).setPhysik4(predmets.get(3).getCount4());
            egeOtcots.get(egeOtcots.size() - 1).setPhysik5(predmets.get(3).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setPhysikObs(predmets.get(3).getCount2() + predmets.get(3).getCount3() + predmets.get(3).getCount4() + predmets.get(3).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setPhysikYsp(((predmets.get(3).getCount3() + predmets.get(3).getCount4() + predmets.get(3).getCount5()) * 100) /
                    (predmets.get(3).getCount2() + predmets.get(3).getCount3() + predmets.get(3).getCount4() + predmets.get(3).getCount5()));
            egeOtcots.get(egeOtcots.size() - 1).setPhysikKat(((predmets.get(3).getCount4() + predmets.get(3).getCount5()) * 100) /
                    (predmets.get(3).getCount2() + predmets.get(3).getCount3() + predmets.get(3).getCount4() + predmets.get(3).getCount5()));

            egeOtcots.get(egeOtcots.size() - 1).setXummi2(predmets.get(4).getCount2());
            egeOtcots.get(egeOtcots.size() - 1).setXummi3(predmets.get(4).getCount3());
            egeOtcots.get(egeOtcots.size() - 1).setXummi4(predmets.get(4).getCount4());
            egeOtcots.get(egeOtcots.size() - 1).setXummi5(predmets.get(4).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setXummiObs(predmets.get(4).getCount2() + predmets.get(4).getCount3() + predmets.get(4).getCount4() + predmets.get(4).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setXummiYsp(((predmets.get(4).getCount3() + predmets.get(4).getCount4() + predmets.get(4).getCount5()) * 100 )/
                    (predmets.get(4).getCount2() + predmets.get(4).getCount3() + predmets.get(4).getCount4() + predmets.get(4).getCount5()));
            egeOtcots.get(egeOtcots.size() - 1).setXummiKat(((predmets.get(4).getCount4() + predmets.get(4).getCount5()) * 100) /
                    (predmets.get(4).getCount2() + predmets.get(4).getCount3() + predmets.get(4).getCount4() + predmets.get(4).getCount5()));

            egeOtcots.get(egeOtcots.size() - 1).setInfa2(predmets.get(5).getCount2());
            egeOtcots.get(egeOtcots.size() - 1).setInfa3(predmets.get(5).getCount3());
            egeOtcots.get(egeOtcots.size() - 1).setInfa4(predmets.get(5).getCount4());
            egeOtcots.get(egeOtcots.size() - 1).setInfa5(predmets.get(5).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setInfaObs(predmets.get(5).getCount2() + predmets.get(5).getCount3() + predmets.get(5).getCount4() + predmets.get(5).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setInfaYsp(((predmets.get(5).getCount3() + predmets.get(5).getCount4() + predmets.get(5).getCount5()) * 100) /
                    (predmets.get(5).getCount2() + predmets.get(5).getCount3() + predmets.get(5).getCount4() + predmets.get(5).getCount5()));
            egeOtcots.get(egeOtcots.size() - 1).setInfaKat(((predmets.get(5).getCount4() + predmets.get(5).getCount5()) * 100) /
                    (predmets.get(5).getCount2() + predmets.get(5).getCount3() + predmets.get(5).getCount4() + predmets.get(5).getCount5()));


            egeOtcots.get(egeOtcots.size() - 1).setBio2(predmets.get(6).getCount2());
            egeOtcots.get(egeOtcots.size() - 1).setBio3(predmets.get(6).getCount3());
            egeOtcots.get(egeOtcots.size() - 1).setBio4(predmets.get(6).getCount4());
            egeOtcots.get(egeOtcots.size() - 1).setBio5(predmets.get(6).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setBioObs(predmets.get(6).getCount2() + predmets.get(6).getCount3() + predmets.get(6).getCount4() + predmets.get(6).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setBioYsp(((predmets.get(6).getCount3() + predmets.get(6).getCount4() + predmets.get(6).getCount5()) * 100) /
                    (predmets.get(6).getCount2() + predmets.get(6).getCount3() + predmets.get(6).getCount4() + predmets.get(6).getCount5()));
            egeOtcots.get(egeOtcots.size() - 1).setBioKat(((predmets.get(6).getCount4() + predmets.get(6).getCount5()) * 100 )/
                    (predmets.get(6).getCount2() + predmets.get(6).getCount3() + predmets.get(6).getCount4() + predmets.get(6).getCount5()));

            egeOtcots.get(egeOtcots.size() - 1).setGeo2(predmets.get(8).getCount2());
            egeOtcots.get(egeOtcots.size() - 1).setGeo3(predmets.get(8).getCount3());
            egeOtcots.get(egeOtcots.size() - 1).setGeo4(predmets.get(8).getCount4());
            egeOtcots.get(egeOtcots.size() - 1).setGeo5(predmets.get(8).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setGeoObs(predmets.get(8).getCount2() + predmets.get(8).getCount3() + predmets.get(8).getCount4() + predmets.get(8).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setGeoYsp(((predmets.get(8).getCount3() + predmets.get(8).getCount4() + predmets.get(8).getCount5()) * 100 )/
                    (predmets.get(8).getCount2() + predmets.get(8).getCount3() + predmets.get(8).getCount4() + predmets.get(8).getCount5()));
            egeOtcots.get(egeOtcots.size() - 1).setGeoKat(((predmets.get(8).getCount4() + predmets.get(8).getCount5()) * 100 )/
                    (predmets.get(8).getCount2() + predmets.get(8).getCount3() + predmets.get(8).getCount4() + predmets.get(8).getCount5()));

            egeOtcots.get(egeOtcots.size() - 1).setAngl2(predmets.get(9).getCount2());
            egeOtcots.get(egeOtcots.size() - 1).setAngl3(predmets.get(9).getCount3());
            egeOtcots.get(egeOtcots.size() - 1).setAngl4(predmets.get(9).getCount4());
            egeOtcots.get(egeOtcots.size() - 1).setAngl5(predmets.get(9).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setAnglObs(predmets.get(9).getCount2() + predmets.get(9).getCount3() + predmets.get(9).getCount4() + predmets.get(9).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setAnglYsp(((predmets.get(9).getCount3() + predmets.get(9).getCount4() + predmets.get(9).getCount5()) * 100 )/
                    (predmets.get(9).getCount2() + predmets.get(9).getCount3() + predmets.get(9).getCount4() + predmets.get(9).getCount5()));
            egeOtcots.get(egeOtcots.size() - 1).setAnglKat(((predmets.get(9).getCount4() + predmets.get(9).getCount5()) * 100) /
                    (predmets.get(9).getCount2() + predmets.get(9).getCount3() + predmets.get(9).getCount4() + predmets.get(9).getCount5()));

            egeOtcots.get(egeOtcots.size() - 1).setHis2(predmets.get(7).getCount2());
            egeOtcots.get(egeOtcots.size() - 1).setHis3(predmets.get(7).getCount3());
            egeOtcots.get(egeOtcots.size() - 1).setHis4(predmets.get(7).getCount4());
            egeOtcots.get(egeOtcots.size() - 1).setHis5(predmets.get(7).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setHisObs(predmets.get(7).getCount2() + predmets.get(7).getCount3() + predmets.get(7).getCount4() + predmets.get(7).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setHisYsp(((predmets.get(7).getCount3() + predmets.get(7).getCount4() + predmets.get(7).getCount5()) * 100) /
                    (predmets.get(7).getCount2() + predmets.get(7).getCount3() + predmets.get(7).getCount4() + predmets.get(7).getCount5()));
            egeOtcots.get(egeOtcots.size() - 1).setHisKat(((predmets.get(7).getCount4() + predmets.get(7).getCount5()) * 100) /
                    (predmets.get(7).getCount2() + predmets.get(7).getCount3() + predmets.get(7).getCount4() + predmets.get(7).getCount5()));

            egeOtcots.get(egeOtcots.size() - 1).setObsestv2(predmets.get(10).getCount2());
            egeOtcots.get(egeOtcots.size() - 1).setObsestv3(predmets.get(10).getCount3());
            egeOtcots.get(egeOtcots.size() - 1).setObsestv4(predmets.get(10).getCount4());
            egeOtcots.get(egeOtcots.size() - 1).setObsestv5(predmets.get(10).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setObsestvObs(predmets.get(10).getCount2() + predmets.get(10).getCount3() + predmets.get(10).getCount4() + predmets.get(10).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setObsestvYsp(((predmets.get(10).getCount3() + predmets.get(10).getCount4() + predmets.get(10).getCount5()) * 100) /
                    (predmets.get(10).getCount2() + predmets.get(10).getCount3() + predmets.get(10).getCount4() + predmets.get(10).getCount5()));
            egeOtcots.get(egeOtcots.size() - 1).setObsestvKat(((predmets.get(10).getCount4() + predmets.get(10).getCount5()) * 100) /
                    (predmets.get(10).getCount2() + predmets.get(10).getCount3() + predmets.get(10).getCount4() + predmets.get(10).getCount5()));

            egeOtcots.get(egeOtcots.size() - 1).setLiter2(predmets.get(11).getCount2());
            egeOtcots.get(egeOtcots.size() - 1).setLiter3(predmets.get(11).getCount3());
            egeOtcots.get(egeOtcots.size() - 1).setLiter4(predmets.get(11).getCount4());
            egeOtcots.get(egeOtcots.size() - 1).setLiter5(predmets.get(11).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setLiterObs(predmets.get(11).getCount2() + predmets.get(11).getCount3() + predmets.get(11).getCount4() + predmets.get(11).getCount5());
            egeOtcots.get(egeOtcots.size() - 1).setLiterYsp(((predmets.get(11).getCount3() + predmets.get(11).getCount4() + predmets.get(11).getCount5()) * 100) /
                    (predmets.get(11).getCount2() + predmets.get(11).getCount3() + predmets.get(11).getCount4() + predmets.get(11).getCount5()));
            egeOtcots.get(egeOtcots.size() - 1).setLiterKat(((predmets.get(11).getCount4() + predmets.get(11).getCount5()) * 100) /
                    (predmets.get(11).getCount2() + predmets.get(11).getCount3() + predmets.get(11).getCount4() + predmets.get(11).getCount5()));
        });
        return egeOtcots;
    }
}
