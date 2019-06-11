package AndroidApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HybridApps {

    @Test
    public static void main() throws MalformedURLException {
        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        //cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.rapoporras_webview_test");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.webview_test.MainActivity");
        cap.setCapability("clearSystemFiles", true);

        //cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println(driver.getContext());
        driver.findElementById("com.rapoporras_webview_test:id/editText").clear();
        driver.findElementById("com.rapoporras_webview_test:id/editText").sendKeys("google.com");
        driver.findElementById("com.rapoporras_webview_test:id/button").click();

        Set<String> s = driver.getContextHandles(); //1 native - 1 web
        for (String handle : s) {
            System.out.println(handle);
        }
        //to enable WebView debugging, call the static method setWebContentsDebuggingEnabled on the WebView class
        driver.context("WEBVIEW_chrome"); //use the for loop to ger the webview name, in this case WEBVIEW_chrome. In this case, it's not enabled on the application and will fail.
        driver.findElementByName("q").sendKeys("Handling hybrid apps");

        service.stop();


    }

}
