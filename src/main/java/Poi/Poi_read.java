package Poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Poi_read {
    String path;

    public boolean writeIntoExcelStipendiaYear(String path, ArrayList<Stipendia_zaMesaz> stipendia_zaMesaz, String year) throws FileNotFoundException, IOException {

        try {
            HSSFWorkbook book = new HSSFWorkbook();
            HSSFSheet sheet = book.createSheet("Стипендия");

            HSSFFont font = book.createFont();

            HSSFCellStyle style = book.createCellStyle();

            HSSFCellStyle style2 = book.createCellStyle();
            HSSFCellStyle style3 = book.createCellStyle();


            style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
            style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
            style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
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

            HSSFRow row = sheet.createRow((short) 0);
            style2.setWrapText(true);
            row.setRowStyle(style2);

            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 4));
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
            cell2.setCellValue(year + " год");
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
                row = sheet.createRow(i + 3);
                Cell cell4_1 = row.createCell(0);
                row.getCell(0).setCellStyle(style2);
                cell4_1.setCellValue(stipendia_zaMesaz.get(i).getNumberPP());
                Cell cell4_2 = row.createCell(1);
                row.getCell(1).setCellStyle(style2);
                cell4_2.setCellValue(stipendia_zaMesaz.get(i).getStatusStudent());
                if (stipendia_zaMesaz.get(i).getStatusStudent().equals("ц"))
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
                row.getCell(4).setCellStyle(style2);
                cell4_5.setCellValue(stipendia_zaMesaz.get(i).getMounts());

            }
            row = sheet.createRow(i + 3);
            Cell cell5_1 = row.createCell(0);
            row.getCell(0).setCellStyle(style2);
            Cell cell5_2 = row.createCell(1);
            row.getCell(1).setCellStyle(style2);
            Cell cell5_3 = row.createCell(2);
            row.getCell(2).setCellStyle(style);
            cell5_3.setCellValue("Ц = " + cE + " чел.,   О = " + oD + " чел.,   ИТОГО:");
            Cell cell5_4 = row.createCell(3);
            row.getCell(3).setCellStyle(style);
            cell5_4.setCellValue(summ);
            Cell cell5_5 = row.createCell(4);
            row.getCell(4).setCellStyle(style2);

            row = sheet.createRow(i + 4);
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

            row = sheet.createRow(i + 6);
            Cell cell7_4 = row.createCell(3);
            cell7_4.setCellValue("              Дата");
            Cell cell8_5 = row.createCell(4);
            cell8_5.setCellValue("______________");



            FileOutputStream fin = new FileOutputStream(path);
            book.write(fin);
            book.close();
            fin.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean writeIntoExcelStipendiaMount(String path, ArrayList<godovaiaStipendia> list, String mount) {

        try {
            System.out.println("5");
            HSSFWorkbook book = new HSSFWorkbook();
            HSSFSheet sheet = book.createSheet("Стипендия_за_месяц");

            HSSFFont font = book.createFont();

            HSSFCellStyle style = book.createCellStyle();
            HSSFCellStyle style2 = book.createCellStyle();
            HSSFCellStyle style3 = book.createCellStyle();

            style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
            style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
            style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
            style2.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
            style2.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
            style2.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
            style2.setAlignment(style.ALIGN_CENTER);
            style2.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
            style3.setBottomBorderColor(HSSFCellStyle.BORDER_MEDIUM);
            style3.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);


            style.setFont(font);
            font.setFontHeightInPoints((short) 12);
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            font.setFontName("Times New Roman");
            style.setAlignment(style.ALIGN_CENTER);

            HSSFRow row = sheet.createRow((short) 0);
            style2.setWrapText(true);
            row.setRowStyle(style2);

            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 3));
            sheet.autoSizeColumn(0);

            Cell cell1 = row.createCell(0);
            Cell cell1_1 = row.createCell(1);
            Cell cell1_2 = row.createCell(2);
            Cell cell1_3 = row.createCell(3);

            row.getCell(0).setCellStyle(style);
            row.getCell(1).setCellStyle(style);
            row.getCell(2).setCellStyle(style);
            row.getCell(3).setCellStyle(style);

            cell1.setCellValue("С Т И П Е Н Д И Я");
            row = sheet.createRow(1);
            Cell cell2 = row.createCell(0);
            Cell cell2_1 = row.createCell(1);
            Cell cell2_2 = row.createCell(2);
            Cell cell2_3 = row.createCell(3);

            row.getCell(0).setCellStyle(style);
            row.getCell(1).setCellStyle(style);
            row.getCell(2).setCellStyle(style);
            row.getCell(3).setCellStyle(style);

            cell2.setCellValue(" За " + mount.toLowerCase() + " месяц");
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


            double summ = 0;
            int oD = 0;
            int cE = 0;
            int i;
            for (i = 0; i < list.size(); i++) {
                row = sheet.createRow(i + 3);
                Cell cell4_1 = row.createCell(0);
                row.getCell(0).setCellStyle(style2);
                cell4_1.setCellValue(list.get(i).getNumberPP());
                Cell cell4_2 = row.createCell(1);
                row.getCell(1).setCellStyle(style2);
                cell4_2.setCellValue(list.get(i).getStatusSt());
                if (list.get(i).getStatusSt().equals("ц"))
                    cE++;
                else
                    oD++;
                Cell cell4_3 = row.createCell(2);
                row.getCell(2).setCellStyle(style2);
                cell4_3.setCellValue(list.get(i).getFIO());
                Cell cell4_4 = row.createCell(3);
                row.getCell(3).setCellStyle(style2);
                cell4_4.setCellValue(list.get(i).getSumma());
                summ = summ + list.get(i).getSumma();


            }
            sheet.addMergedRegion(new CellRangeAddress(i + 3, i + 3, 0, 2));
            row = sheet.createRow(i + 3);
            Cell cell5_1 = row.createCell(0);
            cell5_1.setCellValue("Ц = " + cE + " чел.,   О = " + oD + " чел., Всего = " + (cE + oD) + " чел.. ИТОГ:");
            row.getCell(0).setCellStyle(style);
            Cell cell5_2 = row.createCell(1);
            row.getCell(1).setCellStyle(style);
            Cell cell5_3 = row.createCell(2);
            row.getCell(2).setCellStyle(style);

            Cell cell5_4 = row.createCell(3);

            cell5_4.setCellValue(summ);

            row.getCell(3).setCellStyle(style);
            sheet.addMergedRegion(new CellRangeAddress(i + 4, i + 4, 0, 3));
            row = sheet.createRow(i + 4);
            Cell cell6_1 = row.createCell(0);
            row.getCell(0).setCellStyle(style3);
            Cell cell6_2 = row.createCell(1);
            row.getCell(1).setCellStyle(style3);
            Cell cell6_3 = row.createCell(2);
            row.getCell(2).setCellStyle(style3);
            cell6_1.setCellValue("Ответсвенное лицо _________________         Подпись ______________");
            Cell cell6_4 = row.createCell(3);
            row.getCell(3).setCellStyle(style3);

            Cell cell6_5 = row.createCell(4);


            sheet.addMergedRegion(new CellRangeAddress(i + 6, i + 6, 0, 3));
            row = sheet.createRow(i + 6);
            Cell cell7_1 = row.createCell(0);
            cell7_1.setCellValue("                                                                     Дата ______________");
            Cell cell8_5 = row.createCell(4);

            FileOutputStream fin = new FileOutputStream(path);
            book.write(fin);
            book.close();
            fin.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public ArrayList<Stipendia_zaMesaz> readToStipZaGod(String path) throws IOException {

        ArrayList<StipendiaZaGod> stipendiaZaGods = new ArrayList<>();
        ArrayList<Stipendia_zaMesaz> stipendia_zaMesazs = new ArrayList<>();

        FileInputStream fis = new FileInputStream(new File(path));
        HSSFRow row;
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        HSSFSheet spreadsheet = null;
        System.out.println(workbook.getNumberOfSheets());
        for (int i = 0; workbook.getNumberOfSheets() > i; i++) {
            spreadsheet = workbook.getSheetAt(i);
            Iterator<Row> rowIterator = spreadsheet.iterator();

            boolean start = workbook.getSheetAt(i).getPhysicalNumberOfRows() > 0;

            rowIterator.next();
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
                            switch (numColumn) {
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
                            switch (numColumn) {
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

                stipendia_zaMesazs.get(stipendia_zaMesazs.size() - 1).setStatusStudent(el.getStatusStudent().equals("целевик") ? "ц" : "о");
                stipendia_zaMesazs.get(stipendia_zaMesazs.size() - 1).setSummaR(el.getManyForAnvar() +
                        el.getManyForAprel() + el.getManyForaugust() + el.getManyForDekabr() + el.getManyForFevral() + el.getManyForiul() + el.getManyForiun() + el.getManyForMart() +
                        el.getManyForNoabr() + el.getManyForOkt() + el.getManyForSentabr() + el.getManyForMai());

                stipendia_zaMesazs.get(stipendia_zaMesazs.size() - 1).setMounts((el.getManyForAnvar() != 0 ? "январь\n" : "") + (el.getManyForFevral() != 0 ? "февраль\n" : "") + (el.getManyForMart() != 0 ? "март\n" : "") +
                        (el.getManyForAprel() != 0 ? "апрель\n" : "") + (el.getManyForMai() != 0 ? "май\n" : "") + (el.getManyForiun() != 0 ? "июнь\n" : "") + (el.getManyForiul() != 0 ? "июль\n" : "") + (el.getManyForaugust() != 0 ? "август\n" : "") +
                        (el.getManyForSentabr() != 0 ? "сентябрь\n" : "") + (el.getManyForOkt() != 0 ? "октябрь\n" : "") + (el.getManyForNoabr() != 0 ? "ноябрь\n" : "") + (el.getManyForDekabr() != 0 ? "декабрь" : ""));
            });

        }
        return stipendia_zaMesazs;
    }

    public  ArrayList<godovaiaStipendia> readToStipZamesaz(String path, int indexMount) throws IOException {

        ArrayList<StipendiaZaGod> stipendiaZaGods = new ArrayList<>();
        ArrayList<godovaiaStipendia> godovaiaStipendias = new ArrayList<>();

        FileInputStream fis = new FileInputStream(new File(path));
        HSSFRow row;
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        HSSFSheet spreadsheet = null;
        System.out.println(workbook.getNumberOfSheets());
        for (int i = 0; workbook.getNumberOfSheets() > i; i++) {
            spreadsheet = workbook.getSheetAt(i);
            Iterator<Row> rowIterator = spreadsheet.iterator();

            boolean start = workbook.getSheetAt(i).getPhysicalNumberOfRows() > 0;

            rowIterator.next();
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
                            switch (numColumn) {
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
                            switch (numColumn) {
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

        }
        stipendiaZaGods.remove(stipendiaZaGods.size() - 1);
        stipendiaZaGods.stream().forEach(el -> {
            godovaiaStipendias.add(new godovaiaStipendia());
            godovaiaStipendias.get(godovaiaStipendias.size() - 1).setFIO(el.getFIO());
            godovaiaStipendias.get(godovaiaStipendias.size() - 1).setNumberPP(el.getNumberPP());
            godovaiaStipendias.get(godovaiaStipendias.size() - 1).setStatusSt(el.getStatusStudent().equals("целевик") ? "ц" : "о");
            switch (indexMount) {
                case 0:
                    godovaiaStipendias.get(godovaiaStipendias.size() - 1).setSumma(el.getManyForAnvar());
                    break;
                case 1:
                    godovaiaStipendias.get(godovaiaStipendias.size() - 1).setSumma(el.getManyForFevral());
                    break;
                case 2:
                    godovaiaStipendias.get(godovaiaStipendias.size() - 1).setSumma(el.getManyForMart());
                    break;
                case 3:
                    godovaiaStipendias.get(godovaiaStipendias.size() - 1).setSumma(el.getManyForAprel());
                    break;
                case 4:
                    godovaiaStipendias.get(godovaiaStipendias.size() - 1).setSumma(el.getManyForMai());
                    break;
                case 5:
                    godovaiaStipendias.get(godovaiaStipendias.size() - 1).setSumma(el.getManyForiun());
                    break;
                case 6:
                    godovaiaStipendias.get(godovaiaStipendias.size() - 1).setSumma(el.getManyForiul());
                    break;
                case 7:
                    godovaiaStipendias.get(godovaiaStipendias.size() - 1).setSumma(el.getManyForaugust());
                    break;
                case 8:
                    godovaiaStipendias.get(godovaiaStipendias.size() - 1).setSumma(el.getManyForSentabr());
                    break;
                case 9:
                    godovaiaStipendias.get(godovaiaStipendias.size() - 1).setSumma(el.getManyForOkt());
                    break;
                case 10:
                    godovaiaStipendias.get(godovaiaStipendias.size() - 1).setSumma(el.getManyForNoabr());
                    break;
                case 11:
                    godovaiaStipendias.get(godovaiaStipendias.size() - 1).setSumma(el.getManyForDekabr());
                    break;
            }
        });

        ArrayList<godovaiaStipendia> position = new ArrayList<>();
        godovaiaStipendias.stream().forEach(el-> {
            if (el.getSumma() == 0) {
                position.add(el);
            }
        });
        godovaiaStipendias.removeAll(position);
        return godovaiaStipendias;
    }

    public  ArrayList<EGE> readToEGE(String path) throws IOException {

        ArrayList<EGE> ege = new ArrayList<>();

        FileInputStream fis = new FileInputStream(new File(path));
        XSSFRow row;
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet spreadsheet = null;
        for (int i = 0; workbook.getNumberOfSheets() > i; i++) {
            if (i > 0) break;
            spreadsheet = workbook.getSheetAt(i);
            Iterator<Row> rowIterator = spreadsheet.iterator();

            boolean start = workbook.getSheetAt(i).getPhysicalNumberOfRows() > 0;

            rowIterator.next();
            while (start) {
                ArrayList<Predmet> predmet = new ArrayList<>();
                ege.add(new EGE());
                start = rowIterator.hasNext();
                row = (XSSFRow) rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                int numColumn = 0;
                while (cellIterator.hasNext()) {

                    switch (numColumn) {
                        case 1:
                            predmet.add(new Predmet());
                            predmet.get(predmet.size() - 1).setNamePredmen("Русский язык");
                            break;
                        case 5:
                            predmet.add(new Predmet());
                            predmet.get(predmet.size() - 1).setNamePredmen("Математика профильная");
                            break;
                        case 9:
                            predmet.add(new Predmet());
                            predmet.get(predmet.size() - 1).setNamePredmen("Математика базовая");
                            break;
                        case 13:
                            predmet.add(new Predmet());
                            predmet.get(predmet.size() - 1).setNamePredmen("Физика");
                            break;
                        case 17:
                            predmet.add(new Predmet());
                            predmet.get(predmet.size() - 1).setNamePredmen("Химия");
                            break;
                        case 21:
                            predmet.add(new Predmet());
                            predmet.get(predmet.size() - 1).setNamePredmen("Информатика и ИТК");
                            break;
                        case 25:
                            predmet.add(new Predmet());
                            predmet.get(predmet.size() - 1).setNamePredmen("Биология");
                            break;
                        case 29:
                            predmet.add(new Predmet());
                            predmet.get(predmet.size() - 1).setNamePredmen("История");
                            break;
                        case 33:
                            predmet.add(new Predmet());
                            predmet.get(predmet.size() - 1).setNamePredmen("География");
                            break;
                        case 37:
                            predmet.add(new Predmet());
                            predmet.get(predmet.size() - 1).setNamePredmen("Английский язык");
                            break;
                        case 41:
                            predmet.add(new Predmet());
                            predmet.get(predmet.size() - 1).setNamePredmen("Обществознание");
                            break;
                        case 45:
                            predmet.add(new Predmet());
                            predmet.get(predmet.size() - 1).setNamePredmen("Литература");
                            break;
                    }
                    Cell cell = cellIterator.next();

                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            switch (numColumn) {
                                case 1:
                                case 5:
                                case 9:
                                case 13:
                                case 17:
                                case 21:
                                case 25:
                                case 29:
                                case 33:
                                case 37:
                                case 41:
                                case 45:
                                    predmet.get(predmet.size() - 1).setCount2(cell.getNumericCellValue());
                                    break;
                                case 2:
                                case 6:
                                case 10:
                                case 14:
                                case 18:
                                case 22:
                                case 26:
                                case 30:
                                case 34:
                                case 38:
                                case 42:
                                case 46:
                                    predmet.get(predmet.size() - 1).setCount3(cell.getNumericCellValue());
                                    break;
                                case 3:
                                case 7:
                                case 11:
                                case 15:
                                case 19:
                                case 23:
                                case 27:
                                case 31:
                                case 35:
                                case 39:
                                case 43:
                                case 47:
                                    predmet.get(predmet.size() - 1).setCount4(cell.getNumericCellValue());
                                    break;
                                case 4:
                                case 8:
                                case 12:
                                case 16:
                                case 20:
                                case 24:
                                case 28:
                                case 32:
                                case 36:
                                case 40:
                                case 44:
                                case 48:
                                    predmet.get(predmet.size() - 1).setCount5(cell.getNumericCellValue());
                                    break;
                            }
                            break;

                        case Cell.CELL_TYPE_STRING:
                            switch (numColumn) {
                                case 0:
                                    ege.get(ege.size() - 1).setNameSchool(cell.getStringCellValue());
                                    break;
                            }
                            break;
                        default:
                            start = false;
                            break;
                    }

                }
                ege.get(ege.size() - 1).setPredmets(predmet);
                numColumn++;
            }
            fis.close();

        }
        System.out.println(ege.size());
        return ege;
    }

    public void readToReestr (String path) {

    }
}

