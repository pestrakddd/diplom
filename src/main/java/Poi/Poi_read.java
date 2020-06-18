package Poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Poi_read {
    String path;

    public Poi_read(String path) throws IOException {
        this.path=path;
    }

    @SuppressWarnings("deprecation")
    public static void writeIntoExcel() throws FileNotFoundException, IOException{
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("Birthdays");

        // Нумерация начинается с нуля
        Row row = sheet.createRow(0);

        // Мы запишем имя и дату в два столбца
        // имя будет String, а дата рождения --- Date,
        // формата dd.mm.yyyy
        Cell name = row.createCell(0);
        name.setCellValue("John");

        Cell birthdate = row.createCell(1);

        DataFormat format = book.createDataFormat();
        CellStyle dateStyle = book.createCellStyle();
        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
        birthdate.setCellStyle(dateStyle);


        // Нумерация лет начинается с 1900-го
        birthdate.setCellValue(new Date(110, 10, 10));

        // Меняем размер столбца
        sheet.autoSizeColumn(1);

        // Записываем всё в файл
        book.write(new FileOutputStream("D:\\tets2.xls"));
        book.close();
    }

    public void readFromExcel() throws IOException {

//        String s1;
//        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream("D:\\ter.xls"));
//        HSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
//        HSSFRow row ;
//        for (int i = 8; i < 22; i++){
//            row = myExcelSheet.getRow(i);
//            s1 = row.getCell(1).getStringCellValue();
//            System.out.println(s1 +"|"+ s2 +"|"+s3 +"|"+s4 +"|"+s5 +"|"+s6 +"|"+s7 +"|"+s8 +"|"+s9 +"|"+s10);
//        }
//        myExcelBook.close();
//        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream("D:\\ter.xls"));
//        HSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);

        FileInputStream fis = new FileInputStream(new File(path));

//            XSSFWorkbook workbook = new XSSFWorkbook(fis);
//            XSSFSheet spreadsheet = workbook.getSheetAt(0);
//            XSSFRow row;
        HSSFRow row;
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        HSSFSheet spreadsheet = null;
        System.out.println(workbook.getNumberOfSheets());
        for (int i = 0; workbook.getNumberOfSheets() > i; i++) {
            spreadsheet = workbook.getSheetAt(i);
            Iterator<Row> rowIterator = spreadsheet.iterator();

            while (rowIterator.hasNext()) {
//                row = (XSSFRow) rowIterator.next();
                row = (HSSFRow) rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() + " \t\t ");
                            break;

                        case Cell.CELL_TYPE_STRING:
                            System.out.print(
                                    cell.getStringCellValue() + " \t\t ");
                            break;
                        case Cell.CELL_TYPE_FORMULA:
                            System.out.print(cell.getNumericCellValue() + " \t\t ");
                            break;
                    }
                }
                System.out.println();
            }
            fis.close();
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        }

    }

    public ArrayList <Stipendia_zaMesaz> readToStipZaGod(String path) throws IOException {

        ArrayList <StipendiaZaGod> stipendiaZaGods = new ArrayList<>();
        ArrayList <Stipendia_zaMesaz> stipendia_zaMesazs = new ArrayList<>();

        FileInputStream fis = new FileInputStream(new File(path));
        HSSFRow row;
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        HSSFSheet spreadsheet = null;
        System.out.println(workbook.getNumberOfSheets());
        for (int i = 0; workbook.getNumberOfSheets() > i; i++) {
            spreadsheet = workbook.getSheetAt(i);
            Iterator<Row> rowIterator = spreadsheet.iterator();

            boolean start = workbook.getSheetAt(i).getPhysicalNumberOfRows() > 0;

            while (start) {
                start = rowIterator.hasNext();
                stipendiaZaGods.add(new StipendiaZaGod());
                row = (HSSFRow) rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                int numColumn = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            switch(numColumn) {
                                case 11:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setManyForSentabr(cell.getNumericCellValue());
                                    break;
                                case 12:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setManyForOkt(cell.getNumericCellValue());
                                    break;
                                case 13:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setManyForNoabr(cell.getNumericCellValue());
                                    break;
                                case 14:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setManyForDekabr(cell.getNumericCellValue());
                                    break;
                                case 15:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setNumberPP(cell.getNumericCellValue());
                                    break;
                                case 3:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setManyForAnvar(cell.getNumericCellValue());
                                    break;
                                case 4:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setManyForFevral(cell.getNumericCellValue());
                                    break;
                                case 5:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setManyForMart(cell.getNumericCellValue());
                                    break;
                                case 6:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setManyForAprel(cell.getNumericCellValue());
                                    break;
                                case 7:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setManyForMai(cell.getNumericCellValue());
                                    break;
                                case 8:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setManyForiun(cell.getNumericCellValue());
                                    break;
                                case 9:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setManyForiul(cell.getNumericCellValue());
                                    break;
                                case 10:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setManyForaugust(cell.getNumericCellValue());
                                    break;
                            }
                            break;

                        case Cell.CELL_TYPE_STRING:
                            switch(numColumn) {
                                case 0:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setFIO(cell.getStringCellValue());
                                    break;
                                case 1:
                                case 2:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setFIO(
                                            stipendiaZaGods.get(stipendiaZaGods.size() - 1).getFIO() + " " + cell.getStringCellValue()
                                    );
                                    break;
                                case 16:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setStatusStudent(cell.getStringCellValue());
                                    break;
                            }
                            break;
                        case Cell.CELL_TYPE_FORMULA:
                            break;
                        default:
                            start = false;
                            break;
                    }
                    numColumn++;
                }
            }
            fis.close();
            stipendiaZaGods.remove(stipendiaZaGods.size() - 1);
            stipendiaZaGods.stream().forEach(el -> {
                stipendia_zaMesazs.add(new Stipendia_zaMesaz());
                stipendia_zaMesazs.get(stipendia_zaMesazs.size() - 1).setNumberPP(el.getNumberPP());
                stipendia_zaMesazs.get(stipendia_zaMesazs.size() - 1).setFio(el.getFIO());

                stipendia_zaMesazs.get(stipendia_zaMesazs.size() - 1).setStatusStudent(el.getStatusStudent().equals("целевик")? "ц" : "о");
                stipendia_zaMesazs.get(stipendia_zaMesazs.size() - 1).setSummaR(el.getManyForAnvar() +
                        el.getManyForAprel() + el.getManyForaugust() + el.getManyForDekabr() + el.getManyForFevral() + el.getManyForiul() + el.getManyForiun() + el.getManyForMart() +
                        el.getManyForNoabr() + el.getManyForOkt() + el.getManyForSentabr() + el.getManyForMai());

                stipendia_zaMesazs.get(stipendia_zaMesazs.size() - 1).setMounts((el.getManyForAnvar() != 0? "январь\n" : "") + (el.getManyForFevral() != 0? "февраль\n" : "") + (el.getManyForMart() != 0? "март\n" : "") +
                        (el.getManyForAprel() != 0? "апрель\n" : "") + (el.getManyForMai() != 0? "май\n" : "") + (el.getManyForiun() != 0? "июнь\n" : "") +(el.getManyForiul() != 0? "июль\n" : "" )+ (el.getManyForaugust() != 0? "август\n" : "") +
                        (el.getManyForSentabr() != 0? "сентябрь\n" : "" ) +  (el.getManyForOkt() != 0? "октябрь\n" : "") + (el.getManyForNoabr() != 0? "ноябрь\n" : "") + (el.getManyForDekabr() != 0? "декабрь\n" : "") );
            });

//            stipendia_zaMesazs.stream().forEach(el -> {
//                System.out.print( el.getFio() + "\t");
//                System.out.print( el.getNumberPP() + "\t");
//                System.out.print( el.getStatusStudent() + "\t");
//                System.out.print( el.getSummaR() + "\t");
//                System.out.print( el.getMounts() + "\t");
//            });
//            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        }
        return stipendia_zaMesazs;
    }


}

