package AndroidApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.PreferenceDependencies;
import pageObjects.Preferences;


import java.net.MalformedURLException;


public class Basics extends Base {

    @Test
    public static void main() throws MalformedURLException {

        Logger logger = Logger.getLogger("Basics.java");
        Base.startServer();
        logger.info("Appium Server started");
        AndroidDriver<AndroidElement> driver = capabilities(); //call this in every test case, change is real or emulator

        HomePage h = new HomePage(driver);
        Preferences p = new Preferences(driver);
        PreferenceDependencies pd = new PreferenceDependencies(driver);

        // xpath syntax -> tagName[@attribute='value'] -> tagName = class

        //driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        try {
            h.preferences.click();
            logger.info("Preferences clicked");
        } catch (Exception e) {
            logger.error("Element not found");
        }
        //driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        p.dependencies.click();

        //driver.findElementById("android:id/checkbox").click();
        pd.prefCheckbox.click();

        //driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        pd.wifi.click();

        //driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
        pd.wifiText.sendKeys("hello");

        //click on the second element with the same classname, in this case, the second one, which is index 1 on uiautomator
        //driver.findElementsByClassName("android.widget.Button").get(1).click();
        pd.buttons.get(1).click();

        Base.stopServer();
        logger.info("Appium Server Stopped");


    }

}
