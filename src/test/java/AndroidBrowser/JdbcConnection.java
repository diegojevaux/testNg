package AndroidBrowser;


import AndroidApp.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.sql.*;

public class JdbcConnection extends BaseChrome {

    @Test
    public static void main() throws SQLException, MalformedURLException {

        Logger logger = Logger.getLogger("JdbcConnection.java");
        Base.startServer();
        logger.info("Appium Server started");
        AndroidDriver<AndroidElement> driver = capabilities(); //call this in every test case, change is real or emulator

        String host = "localhost";
        String port = "3306";

        Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qadbt", "root", "7u8i9o0p");
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("select * from employeeinfo where name = 'sam'");
        while (rs.next()) {
            driver.get("https://google.com");
            driver.findElementByName("q").sendKeys(rs.getString("name"));
            driver.findElementByXPath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/button[2]").click();


            // System.out.println(rs.getString("location"));

        }
        Base.stopServer();

    }
}
