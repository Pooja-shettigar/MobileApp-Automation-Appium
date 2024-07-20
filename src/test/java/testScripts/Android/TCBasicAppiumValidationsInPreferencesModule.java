package testScripts.Android;

import org.testng.annotations.Test;
import testScripts.BaseTestScript;

public class TCBasicAppiumValidationsInPreferencesModule extends BaseTestScript {
    @Test(priority = 1,description = "Basic appium comands executions")
    public static void basicAppiumValidationsInPreferencesPage(){
        preferencePage.clickOnPreferences();
        preferencePage.validateWifiSettingsFunctions();
    }
}
