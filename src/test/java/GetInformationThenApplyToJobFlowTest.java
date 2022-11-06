import core.Constants;
import core.OpenBrowsers;
import core.ReadCsvFile;
import core.TakeScreenShot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AboutWebPage.AboutWebPage;
import pages.ApplyForJob.ApplyToJobFormatPage;
import pages.ApplyForJob.ApplyToJobPage;
import pages.GetInformation.getJobInformationPage;
import pages.GoToPages.GoToFeaturePage;

import java.io.IOException;
import java.util.List;


public class GetInformationThenApplyToJobFlowTest {
    WebDriver driver;
    TakeScreenShot takeScr;
    @DataProvider
    public static Object[][] getData() throws Exception{

        List<String[]> lines = ReadCsvFile.readAllLines(Constants.ReadFolderPath+"applyToJobInformation.csv");
        lines.remove(0);
        Object[][] data = new Object[lines.size()][lines.get(0).length];
        int index = 0;
        for(String[] line : lines) {
            data[index] = line;
            index++;
        }
        return data;
    }

    @BeforeSuite
    public void beforeSuite() throws InterruptedException {
        driver = OpenBrowsers.openBrowser("chrome");
        takeScr = new TakeScreenShot(driver);
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @Test
    public void getAboutUsTest(String name, String jobName, String id, String phone, String address, String email, String description, String path) throws InterruptedException, IOException {
            AboutWebPage aboutUs = new AboutWebPage(driver);
            aboutUs.getAboutUsPage();
            Thread.sleep(5000);
            takeScr.takeScreenShot(Constants.PicturesFolderPath+"AboutUS.png");
            Thread.sleep(5000);

            GoToFeaturePage gotoApplyToJob = new GoToFeaturePage(driver, "Jobs");
            gotoApplyToJob.gotoFeaturePageMethod();

            Thread.sleep(10000);
            getJobInformationPage aboutJob = new getJobInformationPage(driver,2);
            aboutJob.getJobsPage();
            takeScr.takeScreenShot(Constants.PicturesFolderPath+"jobInformation.png");

            ApplyToJobPage apply = new ApplyToJobPage(driver,1);
            apply.getApplyJobsPage();

            ApplyToJobFormatPage sendApplication =  new ApplyToJobFormatPage(driver);
            sendApplication.applyToJobFormatPageMethod( name,  jobName,  id,  phone,  address,  email,  description,  path);
            Thread.sleep(5000);
            driver.switchTo().alert().accept();

    }


    @BeforeMethod
    public void beforeMethod() {
        driver.get(Constants.LOGIN_URL);
    }
}