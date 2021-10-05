package utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {


    public static List<List<String>> getListData(String path, String sheetName, int columnCount) {
        List<List<String>> donenList = new ArrayList<>();

        Workbook workbook = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < rowCount; i++) {
            List<String> rowList = new ArrayList<>();
            Row row = sheet.getRow(i);

            int cellCount = row.getPhysicalNumberOfCells();
            if (cellCount < columnCount) columnCount = cellCount;

            for (int j = 0; j < columnCount; j++) {
                rowList.add(row.getCell(j).toString());
            }

            donenList.add(rowList);
        }
        return donenList;
    }

    public static void writeScenarioToExcel(Scenario scenario) {
        String path = "src/main/resources/RunnedScenarios.xlsx";
        String sheetName = "Results";
        String time = ParentClass.date();
        String browser = Driver.browsers.get();

        File f = new File(path);

        if (!f.exists()) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet(sheetName);

            Row row = sheet.createRow(0);

            Cell cell = row.createCell(0);
            cell.setCellValue("No");

            cell = row.createCell(1);
            cell.setCellValue("Scenario");

            cell = row.createCell(2);
            cell.setCellValue("Status of scenario");

            cell = row.createCell(3);
            cell.setCellValue("Date and Time");

            cell = row.createCell(4);
            cell.setCellValue("Browser");


            row = sheet.createRow(1);
            cell = row.createCell(0);
            cell.setCellValue(1);

            cell = row.createCell(1);
            cell.setCellValue(scenario.getName());

            cell = row.createCell(2);
            cell.setCellValue(scenario.getStatus().toString());

            cell = row.createCell(3);
            cell.setCellValue(time);

            cell = row.createCell(4);
            cell.setCellValue(browser);


            FileOutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(path);
                workbook.write(outputStream); // icine hafizadaki bilgileri yazdik...
                workbook.close(); // hafizayi bosalttik...
                outputStream.close(); // yazma islemi kapatildi...

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            Workbook workbook = null;
            Sheet sheet = null;
            try {
                FileInputStream inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheet(sheetName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int numberOfRow = sheet.getPhysicalNumberOfRows();
            Row row = sheet.createRow(numberOfRow);

            Cell cell = row.createCell(0);
            cell.setCellValue(numberOfRow);

            cell = row.createCell(1);
            cell.setCellValue(scenario.getId());

            cell = row.createCell(2);
            cell.setCellValue(scenario.getStatus().toString());

            cell = row.createCell(3);
            cell.setCellValue(time);

            cell = row.createCell(4);
            cell.setCellValue(browser);

            FileOutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(path);
                workbook.write(outputStream); // icine hafizadaki bilgileri yazdik...
                workbook.close(); // hafizayi bosalttik...
                outputStream.close(); // yazma islemi kapatildi...

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
