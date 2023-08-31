package org.example.testcases;

import org.example.base.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter {
    WebDriver driver;
    public void onTestSuccess(ITestResult result) {
        //return overall package name with testclass name

        //return the method name
        String testname = result.getName();
        String filepath =testname + "_passed.png";
        try {
            driver=((Testcases )result.getInstance()).driver;
            Utils utils=new Utils(driver);
            utils.takeScreenshot(filepath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}