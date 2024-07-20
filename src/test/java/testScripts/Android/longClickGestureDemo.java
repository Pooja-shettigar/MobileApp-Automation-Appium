package testScripts.Android;

import org.testng.annotations.Test;
import testScripts.BaseTestScript;

public class longClickGestureDemo extends BaseTestScript {
    @Test(description = "demonstarte long press on element")
    public void longClickGestureDemo(){
        dragAndDropViewsPage.longClickGesture();
    }
}
