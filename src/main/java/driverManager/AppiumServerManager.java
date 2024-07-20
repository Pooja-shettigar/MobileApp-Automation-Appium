package driverManager;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utils.ConfigReader;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class AppiumServerManager extends AppiumDriverManager {
    AppiumDriverLocalService appiumService;
    AppiumDriverManager mobileDriver = new AppiumDriverManager();
    ConfigReader reader = new ConfigReader();
    public void startServer() throws MalformedURLException, FileNotFoundException {
        appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(4723).withArgument(() -> "--base-path", "/wd/hub"));
        appiumService.start();
        mobileDriver.initialiseDriver();
    }

    public void stopServer() {
        System.out.println("Closing the server and Driver");
        mobileDriver.quitDriver();
        appiumService.stop();
    }
}
