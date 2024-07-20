package testScripts.Android;

import org.testng.annotations.Test;
import testScripts.BaseTestScript;

public class TCDragAndDropInViewsModule extends BaseTestScript {
    @Test(description = "Validating Drag and Drop")
    public void validateDragAndDrop(){
        dragAndDropViewsPage.performDragAndDrop();
    }
}
