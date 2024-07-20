package pageobjectRepository.Android;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lables.ANDROIDLABEL;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SuiteRunner;
import pageobjectRepository.BaseObjectRepo;
import utils.GenericMethods;
import utils.TestdataReader;


public class PreferencePage extends BaseObjectRepo {
    public PreferencePage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(this.mobileDriver), this);
    }

    //UI Elements capture
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Preference']")
    private MobileElement preference;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='3. Preference dependencies']")
    private MobileElement preferenceDependencies;
    @AndroidFindBy( id= "android:id/checkbox")
    private MobileElement wifiCheckbox;
    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
    private MobileElement wifiSettingTitle;
    @AndroidFindBy(id = "android:id/alertTitle")
    private MobileElement wifiSettingAlertTitle;
    @AndroidFindBy(id = "android:id/edit")
    private MobileElement wifiSettingInput;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    private MobileElement okButton;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Cancel']")
    private MobileElement cancelButton;

    //getFunctions to access UI elements
    public MobileElement getPreference() {
        return preference;
    }

    public MobileElement getPreferenceDependencies() {
        return preferenceDependencies;
    }

    public MobileElement getWifiCheckbox() {
        return wifiCheckbox;
    }

    public MobileElement getWifiSettingTitle() {
        return wifiSettingTitle;
    }

    public MobileElement getWifiSettingAlertTitle() {
        GenericMethods.waitTillElementIsVisible(mobileDriver,wifiSettingAlertTitle);
        return wifiSettingAlertTitle;
    }

    public MobileElement getWifiSettingInput() {
        return wifiSettingInput;
    }

    public MobileElement getOkButton() {
        return okButton;
    }

    public MobileElement getCancelButton() {
        return cancelButton;
    }


    //Reusualble Functions
    public void clickOnPreferences(){
        getPreference().click();
        getPreferenceDependencies().click();
    }

    public void validateWifiSettingsFunctions(){
        getWifiCheckbox().click();
        Assert.assertTrue(getWifiCheckbox().getAttribute("checked").equalsIgnoreCase("true"));
        String wifiSettingsTitle = getWifiSettingTitle().getText();
        Assert.assertTrue(getWifiSettingTitle().isDisplayed());
        getWifiSettingTitle().click();
        Assert.assertTrue(getWifiSettingAlertTitle().getText().equals(ANDROIDLABEL.WifiSettings.getValue().toString()));
        getWifiSettingInput().sendKeys(TestdataReader.readTestdata("android","wifiSettingName"));
        getOkButton().click();
    }






}
