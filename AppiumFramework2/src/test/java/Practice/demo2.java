package Practice;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import pageObjects.Dependencies;
import pageObjects.HomePage;
import pageObjects.Preferences;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApiDemoTest extends base {

    @Test(dataProvider = "InputData", dataProviderClass = TestData.class)
    public void apiDemoTest(String input) throws IOException, InterruptedException {

        service = startServer();

        AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

/*        //Constructor of the class will be invoked when object in the class os created
         default constructor will be called
        constructor can be defined with arguments

        driver.findElementByXPath(
                "//android.widget.TextView[@content-desc='Preference']").click();
*/
        HomePage homePage = new HomePage(driver);
               homePage.Preferences.click();

/*               driver.findElementByXPath(
                "//android.widget.TextView[@content-desc='3. Preference dependencies']").click();
*/
        Preferences p = new Preferences(driver);
        p.dependencies.click();

        Dependencies d = new Dependencies(driver);
        d.checkbox.click();
        d.settings.click();
        d.editText.sendKeys(input);
        d.buttons.get(1).click();

/*      driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("Hello");
        driver.findElementsByClassName("android.widget.Button").get(1).click();
*/
        service.stop();
    }
    


}
