package testScripts.iOS;

import org.testng.annotations.Test;
import testScripts.BaseTestScript;
import utils.GenericMethods;

public class TCScrollDownDemo extends BaseTestScript {
    @Test(description = "Scroll down demo")
    public void validateScrolldownFunctionlaity(){
        uiKitCatalog.clickWebView();
    }
}
