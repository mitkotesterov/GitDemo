package Practice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CheckoutPage;
import pageObjects.FormPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ecommerce_tc_5_Cloud extends base {

    @Test(dataProvider = "InputName", dataProviderClass = TestData.class)
    public  void totalValidation(String input) throws IOException, InterruptedException {

        service = startServer();

        AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        FormPage formPage = new FormPage(driver);

        //formPage.nameField.sendKeys("Mitko");
        formPage.getNameField().sendKeys(input);
        driver.hideKeyboard();
        //driver.findElementById("com.androidsample.generalstore:id/radioMale").click();
        formPage.maleOption.click();
        //driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
        formPage.getCountrySelection().click();

        Utilities u = new Utilities(driver);
        u.scrollToText("Bulgaria");

        //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bulgaria\"));");
        //different command for scroll
        //driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + Bulgaria + "\").instance(0))"));
        driver.findElementByXPath("//*[@text='Bulgaria']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

        driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
        driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        Thread.sleep(4000);
        //driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);

        //get the amounts in the cart
        int count = driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").size();
        double sum = 0;
        CheckoutPage checkOutPage = new CheckoutPage(driver);

        for (int i=0;i<count;i++){
            String amount1 = checkOutPage.productList.get(i).getText();
            double amount = getAmount(amount1);
            sum = sum+amount;

        }

        System.out.println(sum + " Sum of the products");

        String total = checkOutPage.totalAmount.getText();
        total = total.substring(1);
        double totalValue = Double.parseDouble(total);
        System.out.println(totalValue + " Total in the cart");

        Assert.assertEquals(sum, totalValue);
        service.stop();
    }

    @BeforeTest
    public void killAllNodes() throws IOException, InterruptedException {
        //taskkil /F /IM node.exe
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(2000);

    }


    public static double getAmount(String value) {
        value = value.substring(1);
        double amount2Value = Double.parseDouble(value);
        return amount2Value;

    }

    @Test
    public void postJira() {
        System.out.println("postJira1");
        System.out.println("postJira2");
        System.out.println("postJira3");
    }
}
