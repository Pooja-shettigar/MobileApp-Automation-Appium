package testScripts.Android;
import org.testng.annotations.Test;
import testScripts.BaseTestScript;
public class TCScrollDownDemo extends BaseTestScript {
    @Test(description = "demonstarte scroll down till we get targated Element")
    public void scrolldown(){
        dragAndDropViewsPage.clickOnViews();
       // Page scrolls till webView element
        dragAndDropViewsPage.clickOnWebViews();
    }
}
