package com.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Jay Vaghani on 20/05/2017.
 */
public class Basepage {
    public static WebDriver driver;

    Basepage()
    {
        PageFactory.initElements(driver, this);
    }
}
