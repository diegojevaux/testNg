package AndroidApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragDrop extends Base {
    @Test
    public static void main() throws MalformedURLException {


        Base.startServer();

        AndroidDriver<AndroidElement> driver = capabilities(); //call this in every test case
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();

        AndroidTouchAction touch = new AndroidTouchAction(driver);
        //longpress (source) -> move -> release(destination)
        WebElement source = driver.findElementsByClassName("android.view.View").get(0);
        WebElement destination = driver.findElementsByClassName("android.view.View").get(1);

        // touch.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();
        // if you have multiple actions like withDuration or withPosition you have to use longPressOptions
        touch.longPress(element(source)).moveTo(element(destination)).release().perform(); //if you have to use JUST longPress

        Base.stopServer();



    }

}
