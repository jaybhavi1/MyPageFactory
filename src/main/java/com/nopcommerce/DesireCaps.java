package com.nopcommerce;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jay Vaghani on 13/05/2017.
 * This is desired Capabilities class for Running Test in Sauce lab
 */
public class DesireCaps extends Basepage
{
    LoadProp loadProp = new LoadProp();

    // For sauce lab Select platform and version
    String platformValue = loadProp.getProperty("platformValue");
    String versionValue = loadProp.getProperty("versionValue");

    // For run test on sauce lab declare variable
    public static final String USERNAME = "aum123";
    public static final String ACCESS_KEY = "f3ae9916-d11d-4d99-aab9-95d5e3d1fcdd";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

    public void chromeCaps(){
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform",platformValue);
        caps.setCapability("version",versionValue);
        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
        }catch (MalformedURLException e){
            e.fillInStackTrace();
        }
    }

    public void fireFoxCaps(){
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("platform",platformValue);
        caps.setCapability("version",versionValue);
        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
        }catch (MalformedURLException e){
            e.fillInStackTrace();
        }
    }

    public void ieCaps(){
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        caps.setCapability("platform",platformValue);
        caps.setCapability("version",versionValue);
        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
        }catch (MalformedURLException e){
            e.fillInStackTrace();
        }
    }
}
