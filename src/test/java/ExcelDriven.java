import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDriven {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Udemy\\Appium\\testNg\\src\\main\\resources\\data.xls");

        // use XSSF for MS-Office files - HSSF is for Open Office
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheet = wb.getSheet("script");
        HSSFRow row = sheet.getRow(2);
        HSSFCell cell = row.getCell(2);
        String value = cell.getStringCellValue();

        System.out.println(value);


    }
}
