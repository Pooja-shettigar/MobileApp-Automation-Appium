package pageobjectRepository;

import driverManager.AppiumDriverManager;
import pageobjectRepository.Android.*;
import pageobjectRepository.iOS.AlertViewPage;

import java.io.IOException;

public class BaseObjectRepo extends AppiumDriverManager {
    public static PreferencePage preferencePage;
    public static ViewsPage dragAndDropViewsPage;
    public static AlertViewPage alertViewPage;
    public void initialiseObjects() throws IOException, InterruptedException {
        preferencePage = new PreferencePage(mobileDriver);
        dragAndDropViewsPage = new ViewsPage(mobileDriver);
        alertViewPage = new AlertViewPage(mobileDriver);




    }


}
