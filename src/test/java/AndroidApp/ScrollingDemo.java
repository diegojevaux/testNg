package AndroidApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.MalformedURLException;

public class ScrollingDemo extends Base {

    public static void main() throws MalformedURLException {

        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        AndroidDriver<AndroidElement> driver = capabilities(); //call this in every test case
        driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"));");
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        //driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)");
        driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"));"); //it will scroll until 'view' text = WebView

        service.stop();


    }

}
