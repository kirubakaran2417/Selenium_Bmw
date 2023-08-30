package org.example.testcases;

import org.example.base.BrowserConfiguration;
import org.example.pageobjects.Loginpage;
import org.example.utilities.Excelutilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLOutput;

public class Datadriventests {
    public WebDriver driver;
    public String[][] getalldata() throws Exception {
        String path="C:\\Users\\DELL AIO\\IdeaProjects\\SeleniumDemos\\testdata\\testdata.xlsx";
        Excelutilities e=new Excelutilities(path);
        int rowcount=e.getRowCount("Sheet1");
        int colcount=e.getColumnCount("Sheet1");
        System.out.println(rowcount);
        System.out.println(colcount);
        String sheetdata[][]=new String[rowcount][colcount];
        System.out.println(sheetdata.length);
        for(int i=1;i<rowcount;i++){
            for(int j=0;j<colcount;j++){
                sheetdata[i][j]=e.getCelldata("Sheet1",i,j);
            }
        }
        return sheetdata;
    }
    @DataProvider(name="logindetails")
    public String[][] dataproviderExample() throws Exception {
        String[][] data=getalldata();
//        for(int i=0;i<data.length-1;i++){
//            for(int j=0;j<data[i].length;j++){
//                System.out.println(data[i][j]);
//            }
//        }
        return data;
    }


    @Test(dataProvider = "logindetails")
    public void test1(String username,String password) throws Exception {
        Loginpage lp=new Loginpage(driver);
        lp.setUsername(username);
        lp.setPassword(password);
        lp.clickSubmit();

    }
    @BeforeMethod
    public void setup(){//whenever a method is annotated with @Test, it is a test case,we are testng framework
        driver = BrowserConfiguration.getChromeBrowser();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }
}
