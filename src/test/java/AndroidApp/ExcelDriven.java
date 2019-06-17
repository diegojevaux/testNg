package AndroidApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDriven extends Base {
    // use XSSF for MS-Office files - HSSF is for Open Office
    private static HSSFWorkbook wb;
    private static HSSFSheet sheet;
    private static HSSFRow row;
    private static HSSFCell cell;
    private static FileInputStream fis;


    public static void main(String[] args) throws IOException {

        Base.startServer();

        AndroidDriver<AndroidElement> driver = capabilities(); //call this in every test case, change is real or emulator

        String value = getCellData(2, 2);
        System.out.println(value);
        String value1 = getCellData(1, 2);
        System.out.println(value1);
        value = setCellData("automation", 2, 2);
        System.out.println(value);
        //driver.findElementById("teste").sendKeys(value1);
        Base.stopServer();


    }

    private static String getCellData(int rownum, int col) throws IOException {
        // use XSSF for MS-Office files - HSSF is for Open Office
        fis = new FileInputStream("C:\\Udemy\\Appium\\testNg\\src\\main\\resources\\data.xls");
        wb = new HSSFWorkbook(fis);
        sheet = wb.getSheet("script");
        row = sheet.getRow(2);
        cell = row.getCell(2);
        return cell.getStringCellValue();

    }

    private static String setCellData(String text, int rownum, int col) throws IOException {
        // use XSSF for MS-Office files - HSSF is for Open Office
        fis = new FileInputStream("C:\\Udemy\\Appium\\testNg\\src\\main\\resources\\data.xls");
        wb = new HSSFWorkbook(fis);
        sheet = wb.getSheet("script");
        row = sheet.getRow(2);
        cell = row.getCell(2);
        cell.setCellValue(text);
        return cell.getStringCellValue();

    }
}
