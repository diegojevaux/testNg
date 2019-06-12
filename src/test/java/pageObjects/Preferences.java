package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Preferences {

    public Preferences(AppiumDriver driver) {
        // PageFactory.initElements(driver, this); //use this only for selenium
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); //use this only for appium
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='3. Preference dependencies']")
    public WebElement dependencies;


}
