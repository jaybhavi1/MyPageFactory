package com.nopcommerce;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @ author Jay Vaghani on 22/04/2017.
 */
public class BrowserFectory extends Basepage
{
    // This is object of LoadProp class
    LoadProp loadProp = new LoadProp();

    // This is object of DesiredCaps class
    DesireCaps desireCaps = new DesireCaps();

    // This is for passing key to Browser run from config.properties
    String  browser = loadProp.getProperty("browser");

    // This is use for run test from Jenkins
//    String browser = System.getProperty("browser");

    public void selectBrowser()
    {
        String runWith = loadProp.getProperty("runWith");

        System.out.println("Selected browser is "+browser);

        if (browser.equalsIgnoreCase("Chrome"))
        {
            if (runWith.equalsIgnoreCase("saucelab")){
                // Run test on Sauce lab
                desireCaps.chromeCaps();
            }else {
                //Run Test on System
                   System.setProperty("webdriver.chrome.driver","src\\test\\Resources\\BrowserDriver\\chromedriver.exe");
                   driver = new ChromeDriver();
            }

        }else if(browser.equalsIgnoreCase("IE"))
            {
                if(runWith.equalsIgnoreCase("saucelab")){
                    //Run Test on Sauce lab
                    desireCaps.ieCaps();
                }else {
                    //Run Test on System
                    DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                    caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
                    caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
                    caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
                    caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                    caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
                    caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

//                    System.setProperty("webdriver.ie.driver","src\\test\\Resources\\BrowserDriver\\IEDriverServer.exe");
                    driver = new InternetExplorerDriver(caps);
                }

            }else if(browser.equalsIgnoreCase("FireFox"))
                {
                    if (runWith.equalsIgnoreCase("saucelab")){
                        //Run Test on Sauce lab
                        desireCaps.fireFoxCaps();
                    }else if (runWith.equalsIgnoreCase("laptop")){
                        //Run Test on System
                        driver = new FirefoxDriver();
                    }
                }else {
                    System.out.println(" Browser name is Wrong ");
                }
    }

}

