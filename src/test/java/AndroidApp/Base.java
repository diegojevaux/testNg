package AndroidApp;// import java.io.File;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {

    public static AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

/*	public static void startServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
			Thread.sleep(10000);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void stopServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
			runtime.exec("taskkill /F /IM cmd.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

    public static void startServer() {
        service.start();

    }

    public static void stopServer() {
        service.stop();

    }


    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

        //File f = new File ("src");
        //File fs = new File (f, "ApiDemos-debug.apk");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        //cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
        cap.setCapability("clearSystemFiles", true);

        //cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        return driver;


    }

}
