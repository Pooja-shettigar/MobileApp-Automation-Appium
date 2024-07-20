package testScripts;

import driverManager.AppiumServerManager;
import org.testng.annotations.*;
import pageobjectRepository.BaseObjectRepo;
import utils.ConfigReader;

import java.io.FileNotFoundException;
import java.io.IOException;
public class BaseTestScript extends BaseObjectRepo {
    public AppiumServerManager appiumServer = new AppiumServerManager();
    ConfigReader reader = new ConfigReader();
    @BeforeSuite(alwaysRun = true)
    public void baseSetup() throws IOException, InterruptedException {
        appiumServer.startServer();
        initialiseObjects();

    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() throws FileNotFoundException {
        mobileDriver.resetApp(); // required for Appium version <2

    }
    @AfterSuite(alwaysRun = true)
    public void stop() {
       appiumServer.stopServer();
    }


}
