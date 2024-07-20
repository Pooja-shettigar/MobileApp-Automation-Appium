package pageobjectRepository.Android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lables.ANDROIDLABEL;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageobjectRepository.BaseObjectRepo;
import utils.GenericMethods;

public class ViewsPage extends BaseObjectRepo {
    public ViewsPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(this.mobileDriver), this);
    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Views']")
    private MobileElement views;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Drag and Drop']")
    private MobileElement dragAndDrop;
    @AndroidFindBy(id="io.appium.android.apis:id/drag_dot_1")
    private MobileElement dragsource;
    @AndroidFindBy(id="io.appium.android.apis:id/drag_result_text")
    private MobileElement dropConfirmationText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='WebView']")
    private MobileElement webView;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Expandable Lists']")
    private MobileElement expandableList;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='1. Custom Adapter1']")
    private MobileElement customAdapter;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='People Names']")
    private MobileElement peopleNames;
    @AndroidFindBy(id="android:id/title")
    private MobileElement sampleMenu;

    public MobileElement getViews() {return views;}

    public MobileElement getDragAndDrop() {
        return dragAndDrop;
    }

    public MobileElement getDragsource() {
        return dragsource;
    }

    public MobileElement getDropConfirmationText() {
        return dropConfirmationText;
    }
    public MobileElement getWebView() {return webView;}
    public MobileElement getExpandableList() {return expandableList;}
    public MobileElement getCustomAdapter() {return customAdapter;}
    public MobileElement getPeopleNames() {return peopleNames;}
    public MobileElement getSampleMenu() {return sampleMenu;}

    public void performDragAndDrop(){
        getViews().click();
        getDragAndDrop().click();
        GenericMethods.dragAndDropActivity(getDragsource());
        Assert.assertEquals(getDropConfirmationText().getText(), ANDROIDLABEL.Dropped.getValue().toString());
    }

    public void clickOnViews(){
        getViews().click();
    }

    public void clickOnWebViews(){
        GenericMethods.scrollDownTillElementIsDisplayedAndEnabled(mobileDriver,webView,5);
        getWebView().click();
    }

    public void longClickGesture(){
        getViews().click();
        getExpandableList().click();
        getCustomAdapter().click();

        //Long press
        GenericMethods.longClickGesture(getPeopleNames());


        Assert.assertTrue(getSampleMenu().isDisplayed());
        Assert.assertTrue(getSampleMenu().getText().equalsIgnoreCase(ANDROIDLABEL.SampleMenu.getValue().toString()));

    }
}
