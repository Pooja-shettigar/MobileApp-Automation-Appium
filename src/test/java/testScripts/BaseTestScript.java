package testScripts;

import driverManager.AppiumServerManager;
import org.testng.annotations.*;
import pageobjectRepository.BaseObjectRepo;
import utils.*;

import java.io.FileNotFoundException;
import java.io.IOException;
public class BaseTestScript extends BaseObjectRepo {
    public AppiumServerManager appiumServer = new AppiumServerManager();
    protected static String curDir = System.getProperty("user.dir");
    ConfigReader reader = new ConfigReader();
    @BeforeSuite(alwaysRun = true)
    public void baseSetup() throws IOException, InterruptedException {
        initializePropertyFiles();
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

    private static void initializePropertyFiles() throws FileNotFoundException, IOException {
        try {
            String configFilepath = curDir + "/environment.properties";
            PropertyReader.configPropertyMap = new PropertyReader()
                    .getProperties(configFilepath);

        } catch (Exception e) {

            //"Error while reading config properties.";
            throw e;
        }
    }

}
