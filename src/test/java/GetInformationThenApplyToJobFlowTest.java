import core.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ApplyForJob.ApplyToJobFormatPage;
import pages.ApplyForJob.ApplyToJobPage;
import pages.GetInformation.getJobInformationPage;
import pages.GoToPages.GoToFeaturePage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetInformationThenApplyToJobFlowTest {
    TakeScreenShot takeScr;
    WebElement informationParagraph;
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

    @Test(dataProvider = "getData")
    public void getAboutUsTest(String name, String jobName, String id, String phone, String address, String email, String description, String path) throws InterruptedException, IOException {
        WebDriver driver = OpenBrowsers.openBrowser("chrome");
        takeScr = new TakeScreenShot(driver);
        driver.get(Constants.AboutUS_URL);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //---------------------------------------------------------------------------------------------------------------------------
        informationParagraph = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]"));
        String[] headers = new String[1];
        headers[0] = "Website Information";

        String[] website_data = new String[1];
        website_data[0] = informationParagraph.getText();
        List<String[]> data = new ArrayList<String[]>();
        data.add(website_data);
        WriteCsvFile.writeDataLineByLine(Constants.WriteFolderPath+"webInfo.csv", data, headers);

        takeScr.takeScreenShot(Constants.PicturesFolderPath+"AboutUS.png");
        Thread.sleep(5000);
        //---------------------------------------------------------------------------------------------------------------------------
        GoToFeaturePage gotoApplyToJob = new GoToFeaturePage(driver, "Jobs");
        gotoApplyToJob.gotoFeaturePageMethod();
        //---------------------------------------------------------------------------------------------------------------------------
        Thread.sleep(10000);
        getJobInformationPage aboutJob = new getJobInformationPage(driver,1);
        aboutJob.getJobsPage();
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"jobInformation.png");
        //---------------------------------------------------------------------------------------------------------------------------
        ApplyToJobPage apply = new ApplyToJobPage(driver,1);
        apply.getApplyJobsPage();
        //---------------------------------------------------------------------------------------------------------------------------
        ApplyToJobFormatPage sendApplication =  new ApplyToJobFormatPage(driver);
        sendApplication.applyToJobFormatPageMethod( name,  jobName,  id,  phone,  address,  email,  description,  path);
        Thread.sleep(5000);
        driver.switchTo().alert().accept();

    }

}