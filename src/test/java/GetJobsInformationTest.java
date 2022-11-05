import core.Constants;
import core.OpenBrowsers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.GetInformation.getJobInformationPage;


public class GetJobsInformationTest {
    @Test
    public void getJobInformationTest() throws InterruptedException {
            WebDriver driver = OpenBrowsers.openBrowser("chrome");
            driver.get(Constants.VIEW_URL);
            driver.manage().window().maximize();
            Thread.sleep(10000);
            getJobInformationPage aboutUs = new getJobInformationPage(driver,2);
            aboutUs.getJobsPage();
    }
}