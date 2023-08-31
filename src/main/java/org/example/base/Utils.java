package org.example.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utils {

   public  WebDriver driver;
    public  Utils(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot(String filepath) {
        TakesScreenshot ts= (TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source,new File(System.getProperty("user.dir")+"/screenshots/"+filepath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
