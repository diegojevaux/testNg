package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PreferenceDependencies {

    public PreferenceDependencies(AppiumDriver driver) {
        // PageFactory.initElements(driver, this); //use this only for selenium
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); //use this only for appium
    }

    @AndroidFindBy(id = "android:id/checkbox")
    public WebElement prefCheckbox;

    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
    public WebElement wifi;

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement wifiText;

    @AndroidFindBy(className = "android.widget.Button")
    public List<WebElement> buttons;

}

