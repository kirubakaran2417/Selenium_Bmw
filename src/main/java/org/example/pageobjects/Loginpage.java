package org.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

    //page factory -It is a class provided by selenium webdriver to support page object design patterns
    //in page factory testers use @findby annotation to find elements by respective locators
    //initmethods method is used to initialize it

    WebDriver driver;

    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "submit")
    WebElement submit;

    public Loginpage(WebDriver driver) {//constructor is used to initialize the elements
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setUsername(String data){
        username.sendKeys(data);
    }

    public void setPassword(String data){
        password.sendKeys(data);
    }
    public void clickSubmit(){
        submit.click();
    }
}
