import core.OpenBrowsers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.getJobInformationPage;


public class GetJobsInformationTest {
    @Test
    public void workWithComboBox() throws InterruptedException {
            WebDriver driver = OpenBrowsers.openBrowser("chrome");
            driver.get("https://myjobs-1956b.web.app/view");
            driver.manage().window().maximize();
            Thread.sleep(10000);
            getJobInformationPage aboutUs = new getJobInformationPage(driver , 3);
            aboutUs.getJobsPage();
    }
}