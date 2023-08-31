package org.example.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SeleniumGridTest extends Helperclass {
    @Test
    public void testwithValidCredentials(){
        getDriver().findElement(By.id("username")).sendKeys("student");
        getDriver().findElement(By.id("password")).sendKeys("Password123");
        getDriver().findElement(By.id("submit")).click();
    }
    @Test
    public void testwithinValidCredentials(){
        getDriver().findElement(By.id("username")).sendKeys("student123");
        getDriver().findElement(By.id("password")).sendKeys("Password123");
        getDriver().findElement(By.id("submit")).click();
    }
}
