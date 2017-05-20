package com.nopcommerce;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Jay Vaghani on 20/05/2017.
 */
public class Ulils extends Basepage {
    // Click on Elements
    public static void clickOnElement(WebElement element) {
        element.click();
    }

    // Send or Type to field like name,username or password
    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    // Select Method
    // Select Dropdown By Visible Text
    public static void selectByText(WebElement element, String text) {
        new Select(element).selectByVisibleText(text); // name less Object of Select class
    }

    // Select Dropdown By Visible Value
    public static void selectByValue(WebElement element, String text) {
        Select select = new Select(element);  // named object of Select class
        new Select(element).selectByValue(text);
    }

    // Select Dropdown By Index
    public static void selectByIndex(WebElement element, int index) {
        new Select(element).selectByIndex(index);  // Name less object
    }

    // Get Text From Any Element
    public static String getText(WebElement element) {
        String text = element.getText();
        return text;
    }

    // Get Text By Attribute
    public static String getTextByAttribute(WebElement element, String attributeName) {
        String text = element.getAttribute(attributeName);
        return text;
    }

    // Get Text From Any Element
    public static String getText(By by) {
        String text = driver.findElement(by).getText();
        return text;
    }

    // Get Text By Attribute
    public static String getTextByAttribute(By by, String attributeName) {
        String text = driver.findElement(by).getAttribute(attributeName);
        return text;
    }


    // Method for Assert True for boolean condition
    public static void assertTrueContains(String locator, String type, String contains, String message) {
        type = type.toLowerCase();
        if (type.equals("id")) {
            Assert.assertTrue(getText(By.id(locator)).contains(contains), message);
        } else if (type.equals("xpath")) {
            Assert.assertTrue(getText(By.xpath(locator)).contains(contains), message);
        } else if (type.equals("css")) {
            Assert.assertTrue(getText(By.cssSelector(locator)).contains(contains), message);
        } else if (type.equals("linktext")) {
            Assert.assertTrue(getText(By.linkText(locator)).contains(contains), message);
        } else if (type.equals("partiallinktext")) {
            Assert.assertTrue(getText(By.partialLinkText(locator)).contains(contains), message);
        } else if (type.equals("tag")) {
            Assert.assertTrue(getText(By.tagName(locator)).contains(contains), message);
        } else if (type.equals("name")) {
            Assert.assertTrue(getText(By.name(locator)).contains(contains), message);
        } else if (type.equals("class")) {
            Assert.assertTrue(getText(By.className(locator)).contains(contains), message);
        } else {
            System.out.println("Locator type not supported");
        }
    }

    // Mouse hover any element
    public static void mouseHover(WebElement element) {
        Actions actions = new Actions(driver);
        WebElement mouse = element;
        actions.moveToElement(mouse).build().perform();
    }

    // Date Stamp Method
    public static String dateStamp() {
        DateFormat dateFormat = new SimpleDateFormat("ddmmhhss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        return date1;
    }

    // ScreenSHot Method
    // Browser screen shot
    public static void browserScreenShot(String filePath) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scr1, new File(filePath + "\\photo" + dateStamp() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Print Screen ScreenShot
    public static void printScreen(String filePath) {
        try {
            Robot robot = new Robot();
            BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(screenShot, "jpg", new File(filePath + "\\photo" + dateStamp() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    // Random Number Method
    public static int randomNumber(int range) {
        Random random = new Random();
        int number = random.nextInt(range);
        return number;
    }

}





