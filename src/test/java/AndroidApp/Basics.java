package AndroidApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.Test;


import java.net.MalformedURLException;


public class Basics extends Base {

    @Test
    public static void main() throws MalformedURLException {
        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        AndroidDriver<AndroidElement> driver = capabilities(); //call this in every test case, change is real or emulator
        /* xpath syntax
         * //tagName[@attribute='value']
         * tagName = class
         */

        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        driver.findElementById("android:id/checkbox").click();
        //when there's 2 or more elements with the same name, use xpath with the index provided in uiautomator, in this case [2]
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
        //click on the second element with the same classname, in this case, the second one, which is index 1 on uiautomator
        driver.findElementsByClassName("android.widget.Button").get(1).click();

        service.stop();


    }

}
