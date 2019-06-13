package AndroidBrowser;// import java.io.File;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseChrome {

    public static void startServer() {
        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
        service.start();

    }

    public static void stopServer() {
        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
        service.stop();

    }

    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

        //File f = new File ("src");
        //File fs = new File (f, "ApiDemos-debug.apk");
        //File fs = new File (f, "raaga.apk");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        //cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");

        //cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;


    }

}
