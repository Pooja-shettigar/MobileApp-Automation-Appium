package listeners;
import driverManager.AppiumDriverManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utils.GenericMethods;
import utils.SendMail;

import javax.mail.MessagingException;
import java.io.IOException;
//  Generating TestNG reports after finishing the test execution.

public class TestNGListener extends AppiumDriverManager implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.log("Test execution failed " + result.getName());
        GenericMethods.captureScreenshot(AppiumDriverManager.mobileDriver, result);

    }


    @Override
    public void onTestSkipped(ITestResult result) {
        Reporter.log("Test execution skipped " + result.getName());
    }

    @Override
    public void onStart(ITestContext result) {
        Reporter.log("About to begin executing Test " + result.getName());
    }

    @Override
    public void onFinish(ITestContext result) {
        Reporter.log("Completed executing test " + result.getName());
        try {
            SendMail.sendMailReport();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
