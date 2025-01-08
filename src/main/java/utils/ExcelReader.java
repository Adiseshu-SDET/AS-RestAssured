package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class ExcelReader {

    public static List<Map<String, String>> getTestData(String filePath, String sheetName) throws IOException {
        List<Map<String, String>> dataList = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();

        // Open the Excel file
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        // Read the header row (first row)
        Row headerRow = sheet.getRow(0);
        int numOfColumns = headerRow.getLastCellNum();

        // Iterate through the remaining rows
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row currentRow = sheet.getRow(i);
            Map<String, String> rowData = new LinkedHashMap<>();

            for (int j = 0; j < numOfColumns; j++) {
                String header = formatter.formatCellValue(headerRow.getCell(j));
                String value = formatter.formatCellValue(currentRow.getCell(j));
                rowData.put(header, value);
            }

            dataList.add(rowData);
        }

        workbook.close();
        fis.close();
        return dataList;
    }
}