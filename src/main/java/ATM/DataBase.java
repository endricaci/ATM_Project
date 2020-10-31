package ATM;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataBase {

    private final static String path = "/Users/ray/Documents/git/ATM_Project/src/main/DataBase/ClientDataBase.xlsx";

    public static String readExcelFile(int row, int column) {

        String value = "";
        try {
            File src = new File(path);
            FileInputStream fis = new FileInputStream(src);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sh1 = wb.getSheetAt(0);
            Cell cell = sh1.getRow(row).getCell(column);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            value = cell.getStringCellValue();
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }























    public static int lengthOfList() {

        int length = 0;
        try {
            File src = new File(path);
            FileInputStream fis = new FileInputStream(src);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sh1 = wb.getSheetAt(0);
            length = sh1.getLastRowNum();
            //int test = sh1.getLengthOfRow
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return length;
    }


    public void writeExcelFile() {

    }
}
