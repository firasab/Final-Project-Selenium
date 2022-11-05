import core.Constants;
import core.OpenBrowsers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.SearchPages.GetSearchInformationPage;
import pages.GoToPages.GoToFeaturePage;
import pages.LogIn.LoginPage;
import pages.SearchPages.SearchPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class SearchTest {


    @Test
    public void searchTest( ) throws InterruptedException, IOException {

        FileReader readFile = new FileReader(Constants.ReadFolderPath+"props.properties");
        Properties prop = new Properties();
        prop.load(readFile);
        String Email = prop.getProperty("email");
        String Password = prop.getProperty("password");

        WebDriver driver = OpenBrowsers.openBrowser("chrome");
        driver.get(Constants.LOGIN_URL);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        LoginPage login = new LoginPage(driver);
        login.loginMethod(Email, Password);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);

        //jobs pagePath = Jobs
        //companies pagePath = Companies
        //admin pagePath = Admins
        //createSchedule pagePath = Create Weekly Schedule
        //jobForm pagePath = Check Jobs Forms
        GoToFeaturePage gotoWorker = new GoToFeaturePage(driver, "Workers");
        gotoWorker.gotoFeaturePageMethod();



        SearchPage searchWorkers = new SearchPage(driver);
        searchWorkers.searchMethod("Firas Abu Sneneh");
        Thread.sleep(10000);

        GetSearchInformationPage searchWorker = new GetSearchInformationPage(driver);
        searchWorker.getSearched();


    }


}


