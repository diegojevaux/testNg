package AndroidBrowser;

import AndroidApp.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Browser extends BaseChrome {

    @Test
    public static void main() throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = capabilities(); // call this in every test case

        Base.startServer();
        // Now you need Remote device in Chrome desktop enabled and enter the URL on
        // "new tab" then "inspect element" you want

        /*
         * driver.get("http://facebook.com");
         * driver.findElementByXPath("//*[@id=\"m_login_email\"]").sendKeys(
         * "camilibra@gmail.com");
         * driver.findElementByName("pass").sendKeys("CAmi150$");
         * //driver.findElementByXPath("//*[@id=\"u_0_5\"]").click();
         * driver.findElementByXPath("//button[@value='Log In']").click();
         */

        driver.get("http://cricbuzz.com");
        driver.findElementByXPath("//a[@href='#menu']").click();
        driver.findElementByCssSelector("a[title='Cricbuzz Home'").click();
        System.out.println(driver.getCurrentUrl());
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,480)", "");
        try {
            Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header"));
        } catch (AssertionError e) {
            System.out.println("False");
            throw e;
        }
        System.out.println("True");


        Base.stopServer();

    }

}
