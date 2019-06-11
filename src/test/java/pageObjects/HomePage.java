package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
// 1 - Call the driver object from testcase to pageObjects file

    //Concatenate driver
    public HomePage(AppiumDriver driver) {
        // PageFactory.initElements(driver, this); //use this only for selenium
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); //use this only for appium
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
    public WebElement Preferences;


}
