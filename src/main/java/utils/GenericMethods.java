package utils;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import static driverManager.AppiumDriverManager.mobileDriver;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;


public class GenericMethods {
    private static int TIME_OUT_SECONDS = 30;
    public static String screenshotName;

    public static void dragAndDropActivity(MobileElement source){
        ((JavascriptExecutor) mobileDriver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) source).getId(),
                "endX", 619,
                "endY", 560
        ));

    }

    public static void longClickGesture(MobileElement element){
        ((JavascriptExecutor) mobileDriver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),"duration",2000
        ));
    }

    //Wait until element is clickable
    public static void waitTillElementClickable(MobileDriver driver, MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_SECONDS);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
    }

    public static void waitTillElementIsInvisible(MobileDriver driver, MobileElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(element)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitTillTextIsVisible(MobileDriver driver, MobileElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.textToBePresentInElement(element, text)));
    }

    //Wait until element is visible if element takes more than 20 seconds to display
    public static void waitTillElementIsVisible(MobileDriver driver, MobileElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(locator)));
    }


    //Click using JavascriptExecutor
    public static void clickUsingJSE(MobileElement ele, MobileDriver driver) {
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].click();", ele);
    }

    // check if element is Selected
    public boolean isElementSelected(MobileElement element) {
        boolean isElementSelected = false;
        if (element.isSelected()) {
            isElementSelected = true;
        } else {
            isElementSelected = false;
        }
        return isElementSelected;
    }
    public static void scrollDownTillElementIsDisplayedAndEnabled(MobileDriver driver, MobileElement element, int maxScrollNum) {
        int retry = 0;
        for (int i = 0; i < 4; i++) {
            GenericMethods.swipeDown();
            if (retry <= maxScrollNum)
                try {
                    if (element.isDisplayed() && element.isEnabled()) {
                        break;
                    }
                } catch (Exception e) {
                    retry++;
                }
        }
    }
    public static void swipeUp() {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
        int startX, startY, endX, endY;
        startX = mobileDriver.manage().window().getSize().width / 2;
        startY = mobileDriver.manage().window().getSize().height / 4;
        endX = mobileDriver.manage().window().getSize().width / 2;
        endY = mobileDriver.manage().window().getSize().height * 3 / 4;
        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(0),
                PointerInput.Origin.viewport(), startX, startY));
        dragNDrop.addAction(finger.createPointerDown(LEFT.asArg()));
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700),
                PointerInput.Origin.viewport(), endX, endY));
        dragNDrop.addAction(finger.createPointerUp(LEFT.asArg()));
        mobileDriver.perform(Collections.singletonList(dragNDrop));
    }
    public static void swipeDown() {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
        int startX, startY, endX, endY;
        startX = mobileDriver.manage().window().getSize().width / 2;
        startY = mobileDriver.manage().window().getSize().height * 3 / 4;
        endX = mobileDriver.manage().window().getSize().width / 2;
        endY = mobileDriver.manage().window().getSize().height / 4;
        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(0),
                PointerInput.Origin.viewport(), startX, startY));
        dragNDrop.addAction(finger.createPointerDown(LEFT.asArg()));
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700),
                PointerInput.Origin.viewport(), endX, endY));
        dragNDrop.addAction(finger.createPointerUp(LEFT.asArg()));
        mobileDriver.perform(Collections.singletonList(dragNDrop));
    }

    public static List<String> convertMobileElementListToStringList(List<MobileElement> mobileElementList){
        List<String> stringsList = new ArrayList<String>();
        for(int s=0;s<mobileElementList.size();s++)
            stringsList.add(mobileElementList.get(s).getText());
        return stringsList;
    }
    public static void captureScreenshot(AppiumDriver driver, ITestResult result) {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //timestamp
        screenshotName = result.getName() + timeStamp + ".png";
        File target = new File(System.getProperty("user.dir") + "/screenshots/" + screenshotName);

        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
