package org.example.testcases;

import org.example.base.BrowserConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcases {
    public WebDriver driver;

    @BeforeTest
    public void setup(){//whenever a method is annotated with @Test, it is a test case,we are testng framework
        driver = BrowserConfiguration.getChromeBrowser();
    }
    @Test
    public void BrowserCommandsandMethods(){
        driver.get("https://www.mycontactform.com");
//        driver.navigate().to("http://www.google.com");//another way to navigate to webpage
        //navigational commands
//        driver.navigate().back();//back button
//        driver.navigate().forward();//forward button
//        driver.navigate().refresh();//refresh
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }
    @Test
    public void locators(){
    //using linktext
    driver.findElement(By.linkText("Sample Forms")).click();
}
//    @AfterTest
//    public void tearDown(){
//        driver.quit();
//    }

}
