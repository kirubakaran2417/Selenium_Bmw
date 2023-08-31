package org.example.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BrowserConfiguration {
    public static WebDriver driver;
    /**
     *This code snippet defines a static method named getChromeBrowser
     * that returns a WebDriver object.
     * It creates a new ChromeOptions object, sets some arguments,
     * creates a new ChromeDriver object, maximizes the browser window,
     * and returns the driver.
     *
     * @return         	description of return value
     */
    public static WebDriver getChromeBrowser() {
        //
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--headless");
        driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //to maximize the browser
        driver.manage().window().maximize();
        return driver;
    }
    public static WebDriver getEdgeBrowser() {
        driver=new EdgeDriver();
        return driver;
    }
}
