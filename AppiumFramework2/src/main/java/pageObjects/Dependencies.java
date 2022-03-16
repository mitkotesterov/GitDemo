package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Dependencies {
    public Dependencies(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "android:id/checkbox")
    public WebElement checkbox;

    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
    public WebElement settings;

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement editText;

    @AndroidFindBy(className = "android.widget.Button")
    public List<WebElement> buttons;

}
