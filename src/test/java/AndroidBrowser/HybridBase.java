package AndroidBrowser;// import java.io.File;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HybridBase {

    public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException {

        //File f = new File ("src");
        //File fs = new File (f, "ApiDemos-debug.apk");
        //File fs = new File (f, "raaga.apk");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        //runs emulator device
        if (device.equals("emulator")) {
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        }
        //runs real device
        else if (device.equals("real")) {
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "HT6CP0202944");
        }
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");

        //cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;


    }

}
