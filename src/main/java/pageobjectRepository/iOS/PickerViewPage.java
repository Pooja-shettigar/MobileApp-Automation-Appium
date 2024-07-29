package pageobjectRepository.iOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageobjectRepository.BaseObjectRepo;
import utils.TestdataReader;

public class PickerViewPage extends BaseObjectRepo {
    public PickerViewPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(this.mobileDriver), this);
    }
    @iOSXCUITFindBy(id="Picker View")
    private MobileElement pickerView;
    @iOSXCUITFindBy(id="Red color component value")
    private MobileElement redColour;
    @iOSXCUITFindBy(id="Green color component value")
    private MobileElement greenColour;
    @iOSXCUITFindBy(id="Blue color component value")
    private MobileElement blueColour;

    public MobileElement getPickerView() {return pickerView;}

    public MobileElement getRedColour() {return redColour;}

    public MobileElement getGreenColour() {return greenColour;}

    public MobileElement getBlueColour() {return blueColour;}

    public void validatePicker()
    {
        getPickerView().click();
        getRedColour().sendKeys(TestdataReader.readTestdata("iOS","redComponentValue"));
        getGreenColour().sendKeys(TestdataReader.readTestdata("iOS","greenComponentValue"));
        getBlueColour().sendKeys(TestdataReader.readTestdata("iOS","blueComponentValue"));

        Assert.assertTrue(getRedColour().getText().equalsIgnoreCase(TestdataReader.readTestdata("iOS","redComponentValue")));
    }
}
