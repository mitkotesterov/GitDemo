package resources;

import Practice.base;
import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.IOException;


public class Listeners implements ITestListener {

    @Override
//    public void onTestFailure(ITestResult result) {
//        //screenshot
//        String s = result.getName();
//        try {
//            base.getScreenshot(s);
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
    public void onTestFailure(ITestResult result) {
        String s = result.getName();
        try {
            base.getScreenshot(s);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
