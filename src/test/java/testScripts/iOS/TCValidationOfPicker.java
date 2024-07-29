package testScripts.iOS;

import org.testng.annotations.Test;
import pageobjectRepository.BaseObjectRepo;
import testScripts.BaseTestScript;

public class TCValidationOfPicker extends BaseTestScript {
    @Test(description = "Validate Picker functionality")
    public void validatePickerFunctionality(){
        pickerView.validatePicker();
    }
}
