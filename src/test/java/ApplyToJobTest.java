import core.Constants;
import core.OpenBrowsers;
import core.ReadCsvFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ApplyForJob.ApplyToJobFormatPage;
import pages.ApplyForJob.ApplyToJobPage;
import pages.GoToPages.GoToFeaturePage;

import java.util.List;


public class ApplyToJobTest {

    @DataProvider
    public static Object[][] getData() throws Exception{

        List<String[]> lines = ReadCsvFile.readAllLines(Constants.ReadFolderPath+"AdminInformation.csv");
        lines.remove(0);
        Object[][] data = new Object[lines.size()][lines.get(0).length];
        int index = 0;
        for(String[] line : lines) {
            data[index] = line;
            index++;
        }
        return data;
    }

    @Test
    public void applyToJobTest(String name, String jobName, String id, String phone, String address, String email, String description, String path) throws InterruptedException {
            WebDriver driver = OpenBrowsers.openBrowser("chrome");
            driver.get(Constants.VIEW_URL);
            driver.manage().window().maximize();
            Thread.sleep(10000);

            GoToFeaturePage gotoApplyToJob = new GoToFeaturePage(driver, "Jobs");
            gotoApplyToJob.gotoFeaturePageMethod();

            ApplyToJobPage apply = new ApplyToJobPage(driver,1);
            apply.getApplyJobsPage();

            ApplyToJobFormatPage sendApplication =  new ApplyToJobFormatPage(driver);
            sendApplication.applyToJobFormatPageMethod( name,  jobName,  id,  phone,  address,  email,  description,  path);
            Thread.sleep(5000);
            driver.switchTo().alert().accept();
    }
}