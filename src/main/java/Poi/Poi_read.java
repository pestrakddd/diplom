package Poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
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
    private HSSFFont createCellFont(HSSFWorkbook book)
    {

        HSSFFont font = book.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("Times New Roman");
        return(font);
    }



    private HSSFCellStyle createCellStyle(HSSFWorkbook book)
    {
        BorderStyle thin  = BorderStyle.THIN;
        short       black = IndexedColors.BLACK.getIndex();

        HSSFCellStyle style = book.createCellStyle();

        style.setWrapText(true);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        style.setTopBorderColor   (black);
        style.setRightBorderColor (black);
        style.setBottomBorderColor(black);
        style.setLeftBorderColor  (black);

        return style;
    }
//String pathCreate, ArrayList<Stipendia_zaMesaz> listCreate
    @SuppressWarnings("deprecation")
    public void writeIntoExcelStipendiaYear(String path, ArrayList <Stipendia_zaMesaz> stipendia_zaMesaz) throws FileNotFoundException, IOException{

        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet("Стипендия");;
//        HSSFCellStyle style = (HSSFCellStyle) book.createCellStyle();
//        style.setFont(createCellFont(book));
        // Нумерация начинается с нуля

        HSSFFont font = book.createFont();

        HSSFCellStyle style = book.createCellStyle();
        HSSFCellStyle style1 = book.createCellStyle();
        HSSFCellStyle style2 = book.createCellStyle();
        HSSFCellStyle style3 = book.createCellStyle();


        style.setBottomBorderColor(HSSFCellStyle.BORDER_MEDIUM);
        style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        style1.setAlignment(style.ALIGN_CENTER);
        style1.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style1.setBottomBorderColor(HSSFCellStyle.BORDER_MEDIUM);
        style1.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        style1.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        style1.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        style2.setBottomBorderColor(HSSFCellStyle.BORDER_MEDIUM);
        style2.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        style2.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        style2.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        style2.setAlignment(style.ALIGN_CENTER);
        style2.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style3.setBottomBorderColor(HSSFCellStyle.BORDER_MEDIUM);
        style3.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);

        // и применяем к этому стилю жирный шрифт
        style.setFont(font);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("Times New Roman");
        style.setAlignment(style.ALIGN_CENTER);

        HSSFRow row = sheet.createRow((short)0);
        style1.setWrapText(true);
        row.setRowStyle(style1);

        sheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
        sheet.addMergedRegion(new CellRangeAddress(1,1,0,4));
        sheet.autoSizeColumn(0);

        Cell cell1 = row.createCell(0);
        Cell cell1_1 = row.createCell(1);
        Cell cell1_2 = row.createCell(2);
        Cell cell1_3 = row.createCell(3);
        Cell cell1_4 = row.createCell(4);
        row.getCell(0).setCellStyle(style);
        row.getCell(1).setCellStyle(style);
        row.getCell(2).setCellStyle(style);
        row.getCell(3).setCellStyle(style);
        row.getCell(4).setCellStyle(style);
        cell1.setCellValue("С Т И П Е Н Д И Я");
        row = sheet.createRow(1);
        Cell cell2 = row.createCell(0);
        Cell cell2_1 = row.createCell(1);
        Cell cell2_2 = row.createCell(2);
        Cell cell2_3 = row.createCell(3);
        Cell cell2_4 = row.createCell(4);
        row.getCell(0).setCellStyle(style);
        row.getCell(1).setCellStyle(style);
        row.getCell(2).setCellStyle(style);
        row.getCell(3).setCellStyle(style);
        row.getCell(4).setCellStyle(style);
        row.getCell(0).setCellStyle(style);
        cell2.setCellValue("Год");
        row = sheet.createRow(2);
        Cell cell3_1 = row.createCell(0);
        row.getCell(0).setCellStyle(style);
        cell3_1.setCellValue("№ п/п");
        sheet.autoSizeColumn(0);
        Cell cell3_2 = row.createCell(1);
        row.getCell(1).setCellStyle(style);
        cell3_2.setCellValue("Тип");
        sheet.autoSizeColumn(1);
        Cell cell3_3 = row.createCell(2);
        row.getCell(2).setCellStyle(style);
        cell3_3.setCellValue("    Фамилия     Имя     Отчество    ");
        sheet.autoSizeColumn(2);
        Cell cell3_4 = row.createCell(3);
        row.getCell(3).setCellStyle(style);
        cell3_4.setCellValue("Сумма, руб");
        sheet.autoSizeColumn(3);
        Cell cell3_5 = row.createCell(4);
        row.getCell(4).setCellStyle(style);
        cell3_5.setCellValue("Примечание");
        sheet.autoSizeColumn(4);

        double summ = 0;
        int oD = 0;
        int cE = 0;
        int i;
        for (i = 0; i < stipendia_zaMesaz.size(); i++) {
            row = sheet.createRow(i+3);
            Cell cell4_1 = row.createCell(0);
            row.getCell(0).setCellStyle(style2);
            cell4_1.setCellValue(stipendia_zaMesaz.get(i).getNumberPP());
            Cell cell4_2 = row.createCell(1);
            row.getCell(1).setCellStyle(style2);
            cell4_2.setCellValue( stipendia_zaMesaz.get(i).getStatusStudent());
            if(stipendia_zaMesaz.get(i).getStatusStudent().equals("ц"))
                cE++;
            else
                oD++;
            Cell cell4_3 = row.createCell(2);
            row.getCell(2).setCellStyle(style2);
            cell4_3.setCellValue(stipendia_zaMesaz.get(i).getFio());
            Cell cell4_4 = row.createCell(3);
            row.getCell(3).setCellStyle(style2);
            cell4_4.setCellValue(stipendia_zaMesaz.get(i).getSummaR());
            summ = summ + stipendia_zaMesaz.get(i).getSummaR();
            Cell cell4_5 = row.createCell(4);
            row.getCell(4).setCellStyle(style1);
            cell4_5.setCellValue(stipendia_zaMesaz.get(i).getMounts());

        }
        row = sheet.createRow(i+3);
        Cell cell5_1 = row.createCell(0);
        row.getCell(0).setCellStyle(style1);
        Cell cell5_2 = row.createCell(1);
        row.getCell(1).setCellStyle(style1);
        Cell cell5_3 = row.createCell(2);
        row.getCell(2).setCellStyle(style);
        cell5_3.setCellValue("Ц = " + cE + " чел.,   О = " + oD + " чел.,   ИТОГО:");
        Cell cell5_4 = row.createCell(3);
        row.getCell(3).setCellStyle(style);
        cell5_4.setCellValue(summ);
        Cell cell5_5 = row.createCell(4);
        row.getCell(4).setCellStyle(style1);

        row = sheet.createRow(i+4);
        Cell cell6_1 = row.createCell(0);
        row.getCell(0).setCellStyle(style3);
        Cell cell6_2 = row.createCell(1);
        row.getCell(1).setCellStyle(style3);
        Cell cell6_3 = row.createCell(2);
        row.getCell(2).setCellStyle(style3);
        cell6_3.setCellValue("Ответсвенное лицо _________________");
        Cell cell6_4 = row.createCell(3);
        row.getCell(3).setCellStyle(style3);
        cell6_4.setCellValue("         Подпись");
        Cell cell6_5 = row.createCell(4);
        cell6_5.setCellValue("______________");
        row.getCell(4).setCellStyle(style3);

        row = sheet.createRow(i+6);
        Cell cell7_4 = row.createCell(3);
        cell7_4.setCellValue("              Дата");
        Cell cell8_5 = row.createCell(4);
        cell8_5.setCellValue("______________");


        // Записываем всё в файл
        FileOutputStream fin = new FileOutputStream(path);
        book.write(fin);
        book.close();
        fin.close();
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
                        (el.getManyForSentabr() != 0? "сентябрь\n" : "" ) +  (el.getManyForOkt() != 0? "октябрь\n" : "") + (el.getManyForNoabr() != 0? "ноябрь\n" : "") + (el.getManyForDekabr() != 0? "декабрь" : "") );
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

