package driverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.Setting;
import org.testng.Reporter;
import utils.ConfigReader;
import utils.PropertyReader;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverManager extends ConfigReader {
    public static AppiumDriver mobileDriver;
    ConfigReader reader = new ConfigReader();
    public void initialiseDriver() throws MalformedURLException, FileNotFoundException {
        mobileDriver = new AppiumDriver(new URL(PropertyReader.configPropertyMap.get("SERVERIURL")), reader.getConfigData());
        mobileDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        mobileDriver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 3000);
    }
    public void quitDriver() {
        if (mobileDriver != null)
            mobileDriver.quit();
        else
            Reporter.log("Mobile Driver is null");
    }
}
