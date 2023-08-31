package org.example.testcases;

import org.example.base.BrowserConfiguration;
import org.example.base.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Listeners(org.example.testcases.Listeners.class)
public class Testcases{
    public WebDriver driver;
    public Utils utils;
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
    @Test(priority = 3)
    public void mouseactions(){
        //find how many links in this page
        driver.navigate().to("https://jqueryui.com/");
       driver.findElement(By.linkText("Droppable")).click();
       //code to switch to frame
       WebElement frame = driver.findElement(By.className("demo-frame"));
       driver.switchTo().frame(frame);
       //code to drag and drop
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droppable"));
        Actions a=new Actions(driver);
       // a.dragAndDrop(source, target).build().perform();
        a.clickAndHold(source).moveToElement(target).release(target).build().perform();
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("Tooltip")).click();
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        //code to mouse hover
        WebElement element=driver.findElement(By.linkText("Tooltips"));
        a.moveToElement(element).build().perform();
    }
    @Test(priority = 4,groups = "regresion")
    public void alertsandWindows() throws InterruptedException {
        driver.navigate().to("https://nxtgenaiacademy.com/alertandpopup/");
        WebElement link=driver.findElement(By.name("confirmalertbox"));
        //link.click();
        //whenever element is not interactable with selenium locators use JavascriptExecutor
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", link);
        driver.switchTo().alert().accept();
        //simple alert,confirm and prompt alert

    }
    @Test(priority = 4,groups = "regression")
    public void WindowsHandling() throws InterruptedException {
        driver.navigate().to("https://nxtgenaiacademy.com/multiplewindows/");
        driver.findElement(By.name("123newmessagewindow321")).click();
        //to handle windows driver.switchTo().window() and getwindowhandles() method
        Set<String> ids=driver.getWindowHandles();//set is unoredered so we have to convert that to list then we can access
        System.out.println("Total number of windows: "+ids.size());
        List<String> windows=new ArrayList<>(ids);
        driver.switchTo().window(windows.get(1));//child window
        System.out.println(driver.getTitle());
        driver.switchTo().window(windows.get(0));//parent window
        System.out.println(driver.getTitle());

    }
    @Test(priority = 5)
    public void Screenshot() throws IOException {
        driver.navigate().to("https://www.fnb.co.za/");
        driver.findElement(By.xpath("//button[contains(@onclick,'acceptAllCookies')]")).click();

    }
    @Test(priority = 6)
    public void Screenshotdemo() throws IOException {
        driver.navigate().to("https://www.bmw.co.za/");
        utils=new Utils(driver);
        utils.takeScreenshot("BMW123.jpg");

    }
//    @AfterTest
//    public void tearDown(){
//        driver.quit();
//    }

}
