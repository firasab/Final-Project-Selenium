import core.OpenBrowsers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.ApplyToJobFormatPage;
import pages.ApplyToJobPage;
import pages.GoToFeaturePage;
import pages.getJobInformationPage;


public class ApplyToJobTest {
    @Test
    public void workWithComboBox() throws InterruptedException {
            WebDriver driver = OpenBrowsers.openBrowser("chrome");
            driver.get("https://myjobs-1956b.web.app/view");
            driver.manage().window().maximize();
            Thread.sleep(10000);

            GoToFeaturePage gotoApplyToJob = new GoToFeaturePage(driver, "Jobs");
            gotoApplyToJob.gotoFeaturePageMethod();

            ApplyToJobPage apply = new ApplyToJobPage(driver,1);
            apply.getApplyJobsPage();

            ApplyToJobFormatPage sendApplication =  new ApplyToJobFormatPage(driver);
            sendApplication.applyToJobFormatPageMethod("mahmoud", "cleaner", "332532652","0545543624", "jerusalem", "mahmoud@hotmail.com", "nothing");
            Thread.sleep(5000);
            driver.switchTo().alert().accept();
    }
}