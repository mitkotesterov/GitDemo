package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
    public FormPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //         driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Mitko");
    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    //driver.findElementById("com.androidsample.generalstore:id/radioMale").click();
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    public WebElement maleOption;

    //driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    private WebElement countrySelection;

    public WebElement getNameField() {
        System.out.println("trying to find the Name field");
        return nameField;
    }

    public WebElement getCountrySelection() {
        System.out.println("selecting the option from Country field");
        return countrySelection;
    }


}
