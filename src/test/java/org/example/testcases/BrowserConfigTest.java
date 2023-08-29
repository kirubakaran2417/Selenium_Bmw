package org.example.testcases;

import org.example.base.BrowserConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserConfigTest {
    public WebDriver driver;

    @Test
    public void Testcase1(){//whenever a method is annotated with @Test, it is a test case,we are testng framework
        driver = BrowserConfiguration.getChromeBrowser();
    }

}
