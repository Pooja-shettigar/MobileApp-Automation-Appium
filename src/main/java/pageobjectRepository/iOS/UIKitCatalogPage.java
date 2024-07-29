package pageobjectRepository.iOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageobjectRepository.BaseObjectRepo;
import utils.GenericMethods;

public class UIKitCatalogPage extends BaseObjectRepo {
    public UIKitCatalogPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(this.mobileDriver), this);
    }

    @iOSXCUITFindBy(id="Web View")
    private MobileElement webView;
    @iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='UIKitCatalog']")
    private MobileElement uiKitCatalog;
    public MobileElement getWebView() {
        return webView;
    }
    public MobileElement getUIKitCatalog() {
        return uiKitCatalog;
    }
    public void clickWebView(){
        GenericMethods.scrollDownTillElementIsDisplayedAndEnabled(mobileDriver,getWebView(),2);
        getWebView().click();
        Assert.assertTrue(getUIKitCatalog().isDisplayed());
    }

}
