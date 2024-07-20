package listeners;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import driverManager.AppiumDriverManager;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import utils.GenericMethods;
import utils.SendMail;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


//  Generating extent reports after finishing the test execution

public class ExtentReportListener extends TestListenerAdapter {
    public ExtentReports extentReports;
    public ExtentTest extentTest;
    public static String repName;
    public static String screenshotPath;
    ExtentSparkReporter spark;


    public void onStart(ITestContext iTestContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //timestamp
        repName = iTestContext.getName() + " on " + AppiumDriverManager.mobileDriver.getPlatformName()+ " : " + timeStamp + ".html";
        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + repName);

        extentReports = new ExtentReports();

        extentReports.attachReporter(spark);
        extentReports.setSystemInfo("HostName", "Mobile Automation "+iTestContext.getName());
        extentReports.setSystemInfo("Environment", "Prod-Debug");



        spark.config()
                .setDocumentTitle("Mobile Automation "+iTestContext.getName()); //title of report
        spark.config()
                .setReportName("Mobile Automation Report : "+iTestContext.getName()+ " on " + AppiumDriverManager.mobileDriver.getPlatformName()); //name of the report
        spark.config()
                .setTheme(Theme.DARK);

    }

    public void onTestSuccess(ITestResult result) {

        extentTest = extentReports.createTest(result.getName() + " ( Test description : " + result.getMethod().getDescription() + ") ");
        extentTest.log(Status.PASS, MarkupHelper.createLabel("Test Passed : " + result.getName(), ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult result) {
        extentTest = extentReports.createTest(result.getName() + " ( Test description : " + result.getMethod().getDescription() + ") ");
        extentTest.log(Status.FAIL, MarkupHelper.createLabel("Test Failed : " + result.getName(), ExtentColor.RED));
        extentTest.log(Status.FAIL, MarkupHelper.createLabel("Failure Details :" + result.getThrowable(), ExtentColor.RED));
        extentTest.info(result.getThrowable());
        GenericMethods.captureScreenshot(AppiumDriverManager.mobileDriver, result);
        screenshotPath = System.getProperty("user.dir") + "/screenshots/" + GenericMethods.screenshotName;

        File file = new File(screenshotPath);
        if (file.exists()) {
            try {

                extentTest.info("screenshot is attached for reference");
                extentTest.addScreenCaptureFromPath(screenshotPath);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void onTestSkipped(ITestResult result) {
        extentTest = extentReports.createTest(result.getName() + " ( Test description : " + result.getMethod().getDescription() + ") ");
        extentTest.log(Status.SKIP, MarkupHelper.createLabel("Test Skipped : " + result.getName(), ExtentColor.ORANGE));
        extentTest.info(result.getThrowable());
    }

    public void onFinish(ITestContext iTestContext) {
        extentReports.flush();
        try {
            SendMail.sendMailReport();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
