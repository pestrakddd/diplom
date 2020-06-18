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

    public void readToStipZaGod(String path) throws IOException {

        ArrayList <StipendiaZaGod> stipendiaZaGods = new ArrayList<>();

        FileInputStream fis = new FileInputStream(new File(path));
        HSSFRow row;
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        HSSFSheet spreadsheet = null;
        System.out.println(workbook.getNumberOfSheets());
        for (int i = 0; workbook.getNumberOfSheets() > i; i++) {
            spreadsheet = workbook.getSheetAt(i);
            Iterator<Row> rowIterator = spreadsheet.iterator();

            while (rowIterator.hasNext()) {

//                rowIterator.
                stipendiaZaGods.add(new StipendiaZaGod());
                row = (HSSFRow) rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                int numColumn = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            switch(numColumn) {
                                case 5:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setNumberPP(cell.getNumericCellValue());
                                    break;
                                case 4:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setManyForMounts(cell.getNumericCellValue());
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
                                case 3:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setMount(cell.getStringCellValue());
                                    break;
                                case 6:
                                    stipendiaZaGods.get(stipendiaZaGods.size() - 1).setStatusStudent(cell.getStringCellValue().equals("целевик") ? "ц" : "о");
                                    break;
                            }
                            break;
                        case Cell.CELL_TYPE_FORMULA:
                            break;
                    }
                    numColumn++;
                }
                System.out.println();
            }
            fis.close();
            ArrayList <godovaiaStipendia> godovaiaStipendias = new ArrayList<>();

            stipendiaZaGods.stream().forEach(el -> {
                if (godovaiaStipendias.size() == 0) {
                    godovaiaStipendias.add(new godovaiaStipendia(el.getMount()));
                } else {
//                    godovaiaStipendias.stream().forEach(obj -> {
//                        if(!obj.getMount().equals(el.getMount())) {
//                            godovaiaStipendias.add(new godovaiaStipendia(el.getMount()));
//                        }
//                    });
//                    godovaiaStipendias.stream().forEach();
//                    godovaiaStipendias.forEach(l -> {
//                        if(!l.getMount().equals(el.getMount())) {
//                            godovaiaStipendias.add(new godovaiaStipendia(el.getMount()));
//                        }
//                    });
                }
            });
//                godovaiaStipendias.stream().forEach(ell -> {
//                    if (!ell.getMount().equals(el.getMount())) {
//                        ell.setMount(el.getMount());
//                    }
//
//                });
//                godovaiaStipendias.add(new godovaiaStipendia());
////                System.out.print(el.getFIO() + "\t");
////                System.out.print(el.getMount() + "\t");
////                System.out.print(el.getManyForMounts() + "\t");
////                System.out.print(el.getNumberPP() + "\t");
////                System.out.print(el.getStatusStudent() + "\t");
////                System.out.println();
//            });
            godovaiaStipendias.stream().forEach(ell -> {
                System.out.print(ell.getMount() + "\t");
            });
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        }

    }


}

