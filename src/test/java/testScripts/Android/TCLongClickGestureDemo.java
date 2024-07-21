package testScripts.Android;

import org.testng.annotations.Test;
import testScripts.BaseTestScript;

public class TCLongClickGestureDemo extends BaseTestScript {
    @Test(description = "demonstarte long press on element")
    public void longClickGestureDemo(){
        dragAndDropViewsPage.longClickGesture();
    }
}
