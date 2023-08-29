package org.example.testcases;

import org.example.base.BrowserConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Testcases {
    public WebDriver driver;

    @BeforeTest
    public void setup(){//whenever a method is annotated with @Test, it is a test case,we are testng framework
        driver = BrowserConfiguration.getChromeBrowser();
    }
    @Test(priority = 0)
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
    @Test(priority = 1)
    public void locators(){
    //using linktext
    driver.findElement(By.linkText("Sample Forms")).click();
    //how to handle textbox elements using id
    driver.findElement(By.id("subject")).sendKeys("AZOLA");
    driver.findElement(By.name("q5")).click();
    driver.findElement(By.xpath("//input[@name='email_to[]'][@value='1']")).click();

    WebElement ele=driver.findElement(By.xpath("//input[@id='q4'][@value='Third Option']"));
    ele.click();
    //how to handle dropdown
    WebElement ele1=driver.findElement(By.id("q3"));
        Select s=new Select(ele1);
        s.selectByVisibleText("Second Option");
    List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
    System.out.println("Total number of checkboxes: "+checkboxes.size());
}

@Test(priority = 2)
public void findelementss(){
    //find how many links in this page
    driver.navigate().to("https://www.bmw.in/en/index.html");
    List<WebElement> links=driver.findElements(By.tagName("a"));
    System.out.println("Total number of links: "+links.size());
    //print all the href values
    for(int i=0;i<links.size();i++){
        System.out.println(links.get(i).getAttribute("href"));
    }

}
//    @AfterTest
//    public void tearDown(){
//        driver.quit();
//    }

}
