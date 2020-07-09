package Poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
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

    public boolean writeIntoExcelEge(String path, ArrayList <EGEOtcot> egeOtcots) {
        try {
            HSSFWorkbook book = new HSSFWorkbook();
            HSSFSheet sheet = book.createSheet("ЕГЕ");

            HSSFFont font = book.createFont();

            HSSFCellStyle style = book.createCellStyle();
            HSSFCellStyle style2 = book.createCellStyle();
            HSSFCellStyle style3 = book.createCellStyle();

            style2.setWrapText(true);
            style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
            style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
            style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
            style2.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
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

            final HSSFRow[] row = {sheet.createRow((short) 0)};
            style2.setWrapText(true);
            row[0].setRowStyle(style2);

            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 84));
            sheet.addMergedRegion(new CellRangeAddress(2, 4, 0, 0));
            Cell cell1_1 = row[0].createCell(0);

            cell1_1.setCellValue("ПРЕДМЕТНЫЙ  ОТЧЕТ КАЧЕСТВО ЗНАНИЙ  -  ЕГЭ");
            row[0].getCell(0).setCellStyle(style);
            row[0] = sheet.createRow(2);
            Cell cell2_1 = row[0].createCell(0);
            row[0].getCell(0).setCellStyle(style2);
            cell2_1.setCellValue("Наименование школ");

            row[0] = sheet.createRow(3);
            row[0] = sheet.createRow(4);
            for (int i = 0; i<12;i++) {
                row[0] = sheet.getRow(2);
                sheet.addMergedRegion(new CellRangeAddress(2, 2, 1+i*7, 7+i*7));
                sheet.addMergedRegion(new CellRangeAddress(3, 3, 1+i*7, 4+i*7));
                sheet.addMergedRegion(new CellRangeAddress(3, 4, 5+i*7, 5+i*7));
                sheet.addMergedRegion(new CellRangeAddress(3, 4, 6+i*7, 6+i*7));
                sheet.addMergedRegion(new CellRangeAddress(3, 4, 7+i*7, 7+i*7));


                Cell cell2_2 = row[0].createCell(1+i*7);
                Cell cell2_21 = row[0].createCell(2+i*7);
                Cell cell2_22 = row[0].createCell(3+i*7);
                Cell cell2_23 = row[0].createCell(4+i*7);
                Cell cell2_24 = row[0].createCell(5+i*7);
                Cell cell2_25 = row[0].createCell(6+i*7);
                Cell cell2_26 = row[0].createCell(7+i*7);
                row[0].getCell(2+i*7).setCellStyle(style2);
                row[0].getCell(3+i*7).setCellStyle(style2);
                row[0].getCell(4+i*7).setCellStyle(style2);
                row[0].getCell(5+i*7).setCellStyle(style2);
                row[0].getCell(6+i*7).setCellStyle(style2);
                row[0].getCell(7+i*7).setCellStyle(style2);

                row[0].getCell(1+i*7).setCellStyle(style2);
                switch (i){
                    case 0:
                        cell2_2.setCellValue("Русский язык");
                        break;
                    case 1:
                        cell2_2.setCellValue("Математика профильная");
                        break;
                    case 2:
                        cell2_2.setCellValue("Математика базовая");
                        break;
                    case 3:
                        cell2_2.setCellValue("Физика");
                        break;
                    case 4:
                        cell2_2.setCellValue("Химия");
                        break;
                    case 5:
                        cell2_2.setCellValue("Информатика и ИКТ");
                        break;
                    case 6:
                        cell2_2.setCellValue("Биология");
                        break;
                    case 7:
                        cell2_2.setCellValue("История");
                        break;
                    case 8:
                        cell2_2.setCellValue("География");
                        break;
                    case 9:
                        cell2_2.setCellValue("Английский язык");
                        break;
                    case 10:
                        cell2_2.setCellValue("Обществознание");
                        break;
                    case 11:
                        cell2_2.setCellValue("Литература");
                        break;

                }

                row[0] = sheet.getRow(3);
                Cell cell3_1 = row[0].createCell(1+i*7);
                Cell cell3_12 = row[0].createCell(2+i*7);
                Cell cell3_13 = row[0].createCell(3+i*7);
                Cell cell3_14 = row[0].createCell(4+i*7);
                Cell cell3_2 = row[0].createCell(5+i*7);
                Cell cell3_3 = row[0].createCell(6+i*7);
                Cell cell3_4 = row[0].createCell(7+i*7);
                row[0].getCell(2+i*7).setCellStyle(style2);
                row[0].getCell(3+i*7).setCellStyle(style2);
                row[0].getCell(4+i*7).setCellStyle(style2);


                row[0].getCell(1+i*7).setCellStyle(style2);
                cell3_1.setCellValue("Кол-во учеников получивших оценки");
                sheet.autoSizeColumn(1+i*7);
                row[0].getCell(5+i*7).setCellStyle(style2);
                cell3_2.setCellValue("Общее кол-во");
                sheet.autoSizeColumn(5+i*7);
                row[0].getCell(6+i*7).setCellStyle(style2);
                cell3_3.setCellValue("% успеваемости");
                sheet.autoSizeColumn(6+i*7);
                row[0].getCell(7+i*7).setCellStyle(style2);
                cell3_4.setCellValue("% качество знаний");
                sheet.autoSizeColumn(7+i*7);

                row[0] = sheet.getRow(4);

                Cell cell4_1 = row[0].createCell(1+i*7);
                Cell cell4_2 = row[0].createCell(2+i*7);
                Cell cell4_3 = row[0].createCell(3+i*7);
                Cell cell4_4 = row[0].createCell(4+i*7);
                Cell cell4_41 = row[0].createCell(5+i*7);
                Cell cell4_42 = row[0].createCell(6+i*7);
                Cell cell4_43 = row[0].createCell(7+i*7);
                cell4_1.setCellValue("2");
                cell4_2.setCellValue("3");
                cell4_3.setCellValue("4");
                cell4_4.setCellValue("5");
                row[0].getCell(1+i*7).setCellStyle(style2);
                row[0].getCell(2+i*7).setCellStyle(style2);
                row[0].getCell(3+i*7).setCellStyle(style2);
                row[0].getCell(4+i*7).setCellStyle(style2);
                row[0].getCell(5+i*7).setCellStyle(style2);
                row[0].getCell(6+i*7).setCellStyle(style2);
                row[0].getCell(7+i*7).setCellStyle(style2);

            }

            final Integer[] i = {1};
            egeOtcots.stream().forEach(el->{

                row[0] = sheet.createRow(4+ i[0]);
                Cell cel5_1 = row[0].createCell(0);
                cel5_1.setCellValue(el.getNameSchool());
                int z = 1;
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getRus2());
                    
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getRus3());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getRus4());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getRus5());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getRusObs());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getRusYsp());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getRusKat());
                }
                
                
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getMatPr2());

                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getMatPr3());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getMatPr4());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getMatPr5());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getMatPrObs());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getMatPrYsp());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getMatPrKat());
                }


                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getMatBas2());

                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getMatBas3());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getMatBas4());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getMatBas5());
                }

                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getMatBasObs());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getMatBasYsp());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getMatBasKat());
                }


                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getPhysik2());

                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getPhysik3());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getPhysik4());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getPhysik5());
                }

                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getPhysikObs());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getPhysikYsp());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getPhysikKat());
                }



                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getXummi2());

                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getXummi3());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getXummi4());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getXummi5());
                }

                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getXummiObs());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getXummiYsp());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getXummiKat());
                }



                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getInfa2());

                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getInfa3());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getInfa4());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getInfa5());
                }

                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getInfaObs());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getInfaYsp());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getInfaKat());
                }



                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getBio2());

                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getBio3());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getBio4());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getBio5());
                }

                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getBioObs());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getBioYsp());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getBioKat());
                }



                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getHis2());

                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getHis3());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getHis4());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getHis5());
                }

                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getHisObs());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getHisYsp());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getHisKat());
                }



                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getLiter2());

                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getLiter3());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getLiter4());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getLiter5());
                }

                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getLiterObs());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getLiterYsp());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getLiterKat());
                }




                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getAngl2());

                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getAngl3());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getAngl4());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getAngl5());
                }

                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getAnglObs());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getAnglYsp());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getAnglKat());
                }



                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getObsestv2());

                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getObsestv3());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getObsestv4());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getObsestv5());
                }

                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getObsestvObs());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getObsestvYsp());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getObsestvKat());
                }



                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getGeo2());

                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getGeo3());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getGeo4());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getGeo5());
                }

                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getGeoObs());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getGeoYsp());
                }
                {
                    Cell cell1 = row[0].createCell(z++);
                    cell1.setCellValue(el.getGeoKat());
                }


                for( int g = 0; g<85 ; g++ ){
                    row[0].getCell(g).setCellStyle(style2);
                }
                i[0]++;
                sheet.autoSizeColumn(0);

            });
            row[0] = sheet.createRow(5+egeOtcots.size());
            int u = 0;
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellValue("И Т О Г О");
            }
            String diap = String.valueOf(egeOtcots.size() + 5);
            String diap2 = String.valueOf(egeOtcots.size() + 6);
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(B6:B"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(C6:C"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(D6:D"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(E6:E"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(F6:F"+diap+ ")");
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(C"+diap2+":E"+diap2+")*100/F"+diap2);
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(D"+diap2+":E"+diap2+")*100/F"+diap2);
            }



            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(I6:I"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(J6:J"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(K6:K"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(L6:L"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(M6:M"+diap+ ")");
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(J"+diap2+":L"+diap2+")*100/M"+diap2);
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(K"+diap2+":L"+diap2+")*100/M"+diap2);
            }





            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(P6:P"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(Q6:Q"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(R6:R"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(S6:S"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(T6:T"+diap+ ")");
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(Q"+diap2+":S"+diap2+")*100/T"+diap2);
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(R"+diap2+":S"+diap2+")*100/T"+diap2);
            }



            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(W6:W"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(X6:X"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(Y6:Y"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(Z6:Z"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AA6:AA"+diap+ ")");
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(X"+diap2+":Z"+diap2+")*100/AA"+diap2);
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(Y"+diap2+":Z"+diap2+")*100/AA"+diap2);
            }





            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AD6:AD"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AE6:AE"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AF6:AF"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AG6:AG"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AH6:AH"+diap+ ")");
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AE"+diap2+":AG"+diap2+")*100/AH"+diap2);
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AF"+diap2+":AG"+diap2+")*100/AH"+diap2);
            }




            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AK6:AK"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AL6:AL"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AM6:AM"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AN6:AN"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AO6:AO"+diap+ ")");
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AL"+diap2+":AN"+diap2+")*100/AO"+diap2);
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AM"+diap2+":AN"+diap2+")*100/AO"+diap2);
            }







            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AR6:AR"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AS6:AS"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AT6:AT"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AU6:AU"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AV6:AV"+diap+ ")");
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AS"+diap2+":AU"+diap2+")*100/AV"+diap2);
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AT"+diap2+":AU"+diap2+")*100/AV"+diap2);
            }






            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AY6:AY"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AZ6:AZ"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BA6:BA"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BB6:BB"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BC6:BC"+diap+ ")");
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(AZ"+diap2+":BB"+diap2+")*100/BC"+diap2);
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BA"+diap2+":BB"+diap2+")*100/BC"+diap2);
            }





            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BF6:BF"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BG6:BG"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BH6:BH"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BI6:BI"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BJ6:BJ"+diap+ ")");
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BG"+diap2+":BI"+diap2+")*100/BJ"+diap2);
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BH"+diap2+":BI"+diap2+")*100/BJ"+diap2);
            }




            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BM6:BM"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BN6:BN"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BO6:BO"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BP6:BP"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BQ6:BQ"+diap+ ")");
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BN"+diap2+":BP"+diap2+")*100/BQ"+diap2);
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BO"+diap2+":BP"+diap2+")*100/BQ"+diap2);
            }






            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BT6:BT"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BU6:BU"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BV6:BV"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BW6:BW"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BX6:BX"+diap+ ")");
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BU"+diap2+":BW"+diap2+")*100/BX"+diap2);
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(BV"+diap2+":BW"+diap2+")*100/BX"+diap2);
            }








            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(CA6:CA"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(CB6:CB"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(CC6:CC"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(CD6:CD"+diap+ ")");
            }
            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(CE6:CE"+diap+ ")");
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(CB"+diap2+":CD"+diap2+")*100/CE"+diap2);
            }

            {
                Cell cell1 = row[0].createCell(u++);
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula("SUM(CC"+diap2+":CD"+diap2+")*100/CE"+diap2);
            }
                for( int g = 0; g<85; g++ ){
                    row[0].getCell(g).setCellStyle(style2);
                }


//            for(int i = 0; i < egeOtcots.size(); i++){
//
//            }
//           ArrayList <Cell> cells = new ArrayList<>();
//            for (int i = 0; i < 87; i++) {
//                cells.add(row.createCell(i));
//                Cell cell1 = row.createCell(i);
//            }


//            CellUtil.setAlignment(cell1_1, book, CellStyle.ALIGN_CENTER);
//            row.getCell(0).setCellStyle(style2);

//            Cell cell1 = row.createCell(0);
//            Cell cell1_1 = row.createCell(1);
//            Cell cell1_2 = row.createCell(2);
//            Cell cell1_3 = row.createCell(3);

//            row.getCell(0).setCellStyle(style);
//            row.getCell(1).setCellStyle(style);
//            row.getCell(2).setCellStyle(style);
//            row.getCell(3).setCellStyle(style);



//            cell1.setCellValue("С Т И П Е Н Д И Я");
//            row = sheet.createRow(1);
//            Cell cell2 = row.createCell(0);
//            Cell cell2_1 = row.createCell(1);
//            Cell cell2_2 = row.createCell(2);
//            Cell cell2_3 = row.createCell(3);
//
//            row.getCell(0).setCellStyle(style);
//            row.getCell(1).setCellStyle(style);
//            row.getCell(2).setCellStyle(style);
//            row.getCell(3).setCellStyle(style);
//
//            cell2.setCellValue(" За " + mount.toLowerCase() + " месяц");
//            row = sheet.createRow(2);
//            Cell cell3_1 = row.createCell(0);
//            row.getCell(0).setCellStyle(style);
//            cell3_1.setCellValue("№ п/п");
//            sheet.autoSizeColumn(0);
//            Cell cell3_2 = row.createCell(1);
//            row.getCell(1).setCellStyle(style);
//            cell3_2.setCellValue("Тип");
//            sheet.autoSizeColumn(1);
//            Cell cell3_3 = row.createCell(2);
//            row.getCell(2).setCellStyle(style);
//            cell3_3.setCellValue("    Фамилия     Имя     Отчество    ");
//            sheet.autoSizeColumn(2);
//            Cell cell3_4 = row.createCell(3);
//            row.getCell(3).setCellStyle(style);
//            cell3_4.setCellValue("Сумма, руб");
//            sheet.autoSizeColumn(3);


//            double summ = 0;
//            int oD = 0;
//            int cE = 0;
//            int i;
//            for (i = 0; i < list.size(); i++) {
//                row = sheet.createRow(i + 3);
//                Cell cell4_1 = row.createCell(0);
//                row.getCell(0).setCellStyle(style2);
//                cell4_1.setCellValue(list.get(i).getNumberPP());
//                Cell cell4_2 = row.createCell(1);
//                row.getCell(1).setCellStyle(style2);
//                cell4_2.setCellValue(list.get(i).getStatusSt());
//                if (list.get(i).getStatusSt().equals("ц"))
//                    cE++;
//                else
//                    oD++;
//                Cell cell4_3 = row.createCell(2);
//                row.getCell(2).setCellStyle(style2);
//                cell4_3.setCellValue(list.get(i).getFIO());
//                Cell cell4_4 = row.createCell(3);
//                row.getCell(3).setCellStyle(style2);
//                cell4_4.setCellValue(list.get(i).getSumma());
//                summ = summ + list.get(i).getSumma();
//            }
//            sheet.addMergedRegion(new CellRangeAddress(i + 3, i + 3, 0, 2));
//            row = sheet.createRow(i + 3);
//            Cell cell5_1 = row.createCell(0);
//            cell5_1.setCellValue("Ц = " + cE + " чел.,   О = " + oD + " чел., Всего = " + (cE + oD) + " чел.. ИТОГ:");
//            row.getCell(0).setCellStyle(style);
//            Cell cell5_2 = row.createCell(1);
//            row.getCell(1).setCellStyle(style);
//            Cell cell5_3 = row.createCell(2);
//            row.getCell(2).setCellStyle(style);
//
//            Cell cell5_4 = row.createCell(3);
//
//            cell5_4.setCellValue(summ);
//
//            row.getCell(3).setCellStyle(style);
//            sheet.addMergedRegion(new CellRangeAddress(i + 4, i + 4, 0, 3));
//            row = sheet.createRow(i + 4);
//            Cell cell6_1 = row.createCell(0);
//            row.getCell(0).setCellStyle(style3);
//            Cell cell6_2 = row.createCell(1);
//            row.getCell(1).setCellStyle(style3);
//            Cell cell6_3 = row.createCell(2);
//            row.getCell(2).setCellStyle(style3);
//            cell6_1.setCellValue("Ответсвенное лицо _________________         Подпись ______________");
//            Cell cell6_4 = row.createCell(3);
//            row.getCell(3).setCellStyle(style3);
//
//            Cell cell6_5 = row.createCell(4);
//
//
//            sheet.addMergedRegion(new CellRangeAddress(i + 6, i + 6, 0, 3));
//            row = sheet.createRow(i + 6);
//            Cell cell7_1 = row.createCell(0);
//            cell7_1.setCellValue("                                                                     Дата ______________");
//            Cell cell8_5 = row.createCell(4);

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
        ArrayList <EGE> ege = new ArrayList<>();
        try {

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
                    ege.add(new EGE());
                    ArrayList <Predmet> predmet = new ArrayList<>();
                    start = rowIterator.hasNext();
                    row = (HSSFRow) rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();

                    int numColumn = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch(numColumn) {
                            case 1:
                                predmet.add(new Predmet());
                                predmet.get(predmet.size() - 1).setNamePredmen("Русский язык");
                                break;
                            case 5:
                                predmet.add(new Predmet());
                                predmet.get(predmet.size() - 1).setNamePredmen("Математика профиль");
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


                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:
                                switch(numColumn) {
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
                                    case 49:
                                        predmet.get(predmet.size() - 1).setCount5(cell.getNumericCellValue());
                                        break;
                                }
                                break;

                            case Cell.CELL_TYPE_STRING:
                                if (numColumn == 0);
                                ege.get(ege.size() - 1).setNameSchool(cell.getStringCellValue());
                                break;
                            case Cell.CELL_TYPE_FORMULA:
                                break;
                            default:
                                break;
                        }
                        numColumn++;
                    }
                    ege.get(ege.size() - 1).setPredmets(predmet);
                }
                fis.close();

            }
            ArrayList <EGE> ege1 = new ArrayList<>();


            ege.stream().forEach(el -> {
                if (el.getNameSchool() != null) {
                    ege1.add(el);
                }
            });
            ege1.forEach(el -> {
                System.out.println(el.nameSchool);
            });

            return ege1;
        } catch (Exception e) {
            ArrayList <EGE> ege1 = new ArrayList<>();


            ege.stream().forEach(el -> {
                if (el.getNameSchool() != null) {
                    ege1.add(el);
                }
            });
            return ege1;
        }



    }

    public void readToReestr (String path) {

    }
}

