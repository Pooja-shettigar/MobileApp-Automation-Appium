package pageobjectRepository.iOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lables.IOSLABEL;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageobjectRepository.BaseObjectRepo;
import utils.TestdataReader;

public class AlertViewPage extends BaseObjectRepo {

    public AlertViewPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(this.mobileDriver), this);
    }
    @iOSXCUITFindBy(id="Alert Views")
    private MobileElement alertViews;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Text Entry']")
    private MobileElement textEntry;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
    private MobileElement alertInput;
    @iOSXCUITFindBy(id="OK")
    private MobileElement alertOK;
    @iOSXCUITFindBy(id="Cancel")
    private MobileElement alertCancel;
    @iOSXCUITFindBy(id="Confirm / Cancel")
    private MobileElement confirmCancel;
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'message')]")
    private MobileElement message;
    @iOSXCUITFindBy(id="Confirm")
    private MobileElement confirm;

    public MobileElement getAlertViews() {return alertViews;}

    public MobileElement getTextEntry() {return textEntry;}

    public MobileElement getAlertInput() {return alertInput;}

    public MobileElement getAlertOK() {return alertOK;}

    public MobileElement getAlertCancel() {return alertCancel;}

    public MobileElement getConfirmCancel() {return confirmCancel;}

    public MobileElement getMessage() {return message;}

    public MobileElement getConfirm() {return confirm;}

    public void validateAlters() throws InterruptedException {
        getAlertViews().click();
        getTextEntry().click();
        getAlertInput().sendKeys(TestdataReader.readTestdata("iOS","alertInput"));
        Thread.sleep(3000);
        //getAlertOK();
    }

    public void validateConfirmCancelPopup(){
        getAlertViews().click();
        getTextEntry().click();
        getConfirmCancel().click();
        Assert.assertTrue(getMessage().getText().equalsIgnoreCase(IOSLABEL.MESSAGE.getValue().toString()));
        System.out.println(getMessage().getText());
        getConfirmCancel().click();

    }


}