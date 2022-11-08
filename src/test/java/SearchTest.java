import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.SearchPages.GetSearchInformationPage;
import pages.GoToPages.GoToFeaturePage;
import pages.SearchPages.SearchPage;
import java.io.IOException;


public class SearchTest {
    @Test
    public void searchTest( ) throws InterruptedException, IOException {
        WebDriver driver = BaseTest.Login();
        //--------------------------------------------------------------------------------------------------------------
        GoToFeaturePage gotoWorker = new GoToFeaturePage(driver, "Workers");
        gotoWorker.gotoFeaturePageMethod();
        //--------------------------------------------------------------------------------------------------------------
        SearchPage searchWorkers = new SearchPage(driver);
        searchWorkers.searchMethod("Firas Abu Sneneh");
        Thread.sleep(10000);
        //--------------------------------------------------------------------------------------------------------------
        GetSearchInformationPage searchWorker = new GetSearchInformationPage(driver);
        searchWorker.getSearched();
    }


}


