package testScripts.iOS;

import org.testng.annotations.Test;
import testScripts.BaseTestScript;

public class TCBasicAppiumValidationsInAlterviewModule extends BaseTestScript {

    @Test(description = "Basic appium comands executions")
    public void validateAlters() throws InterruptedException {
        alertViewPage.validateAlters();
    }
    @Test(description = "Basic appium comands executions")
    public void validateConfirmCancelPopup(){
        alertViewPage.validateConfirmCancelPopup();
    }
}
