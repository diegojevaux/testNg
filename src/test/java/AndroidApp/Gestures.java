package AndroidApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class Gestures extends Base {

    public static void main(String[] args) throws MalformedURLException {
        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
        service.start();

/*		Base appiumServer = new Base();
		appiumServer.startServer();*/  //Base class

        AndroidDriver<AndroidElement> driver = capabilities(); //call this in every test case
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

        //Tap command
        // TouchAction t = new TouchAction(driver); USE AndroidTouchAction OR IOSTouchAction

        AndroidTouchAction touch = new AndroidTouchAction(driver);
        WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
        touch.tap(tapOptions().withElement(element(expandList))).perform();
        driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
        WebElement peopleNames = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");

        touch.longPress(longPressOptions().withElement(element(peopleNames)).withDuration(ofSeconds(2))).release().perform();
        System.out.println(driver.findElementById("android:id/title").isDisplayed());

        //appiumServer.stopServer(); //Base class
        service.stop();


    }

}
