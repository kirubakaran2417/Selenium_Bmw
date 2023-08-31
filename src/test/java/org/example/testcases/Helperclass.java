package org.example.testcases;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Helperclass {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
    public static String remote_url = "http://localhost:4446";
    public Capabilities capabilities;
    @Parameters({"browser"})
    @BeforeMethod
    public void setDriver(String browser) throws MalformedURLException {
        if (browser.equalsIgnoreCase("chrome")) {
            capabilities = new ChromeOptions();
        }else if (browser.equalsIgnoreCase("firefox")) {
            capabilities = new FirefoxOptions();
        }else if (browser.equalsIgnoreCase("edge")) {
            capabilities = new EdgeOptions();
        }
        driver.set(new RemoteWebDriver(new URL(remote_url), capabilities));
        driver.get().get("https://practicetestautomation.com/practice-test-login/");
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
    }
    public WebDriver getDriver() {
        return driver.get();
    }
    @AfterMethod
    public void tearDown(){
        driver.get().quit();
        driver.remove();
    }
}
