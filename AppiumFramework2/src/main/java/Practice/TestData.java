package Practice;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "InputData")
    public static Object[][] getDataForEditField() {
        //2sets of data , hello, "!@#$$"
        Object[][] obj = new Object[][] {
                {"hello"}, {"@#$%"}
        };
        return obj;
    }

    @DataProvider(name = "InputName")
    public static Object[][] getDataForNameField() {
        Object[][] name = new Object[][] {
                {"Mitko"}
        };
        return name;
    }

}
