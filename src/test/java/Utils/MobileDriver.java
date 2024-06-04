package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class MobileDriver {



    private MobileDriver() {

    }

    private static AppiumDriver driver;

    public static AppiumDriver get() {

        if (driver == null) {
            try {
                DesiredCapabilities desCaps = new DesiredCapabilities();
                desCaps.setCapability("platformName", "Android");
                desCaps.setCapability("platformVersion", ConfigurationReader.get("platformVersion"));
                desCaps.setCapability("deviceName", ConfigurationReader.get("deviceName"));
                desCaps.setCapability("automationName", "UiAutomator2");
                desCaps.setCapability("udid", ConfigurationReader.get("udId"));
                desCaps.setCapability("appPackage", ConfigurationReader.get("appPackage"));
                desCaps.setCapability("appActivity", ConfigurationReader.get("appActivity"));
                URL url = new URL("http://0.0.0.0:4723/");

                driver = new AndroidDriver(url, desCaps);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return driver;

    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
