package com.nopcommerce;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


/**
 * Created by Jay Vaghani on 20/05/2017.
 */
public class BaseTest extends Basepage
{
    BrowserFectory browserFectory = new BrowserFectory();


    @BeforeClass
    public void openBrowser(){
        driver = new ChromeDriver();
//         driver = new FirefoxDriver();
        driver.get("http://demo.nopcommerce.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
