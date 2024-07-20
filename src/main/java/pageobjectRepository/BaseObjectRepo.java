package pageobjectRepository;

import driverManager.AppiumDriverManager;
import pageobjectRepository.Android.*;

import java.io.IOException;

public class BaseObjectRepo extends AppiumDriverManager {
    public static PreferencePage preferencePage;
    public static ViewsPage dragAndDropViewsPage;
    public void initialiseObjects() throws IOException, InterruptedException {
        preferencePage = new PreferencePage(mobileDriver);
        dragAndDropViewsPage = new ViewsPage(mobileDriver);



    }


}
