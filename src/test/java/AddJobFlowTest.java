import core.Constants;
import core.ReadCsvFile;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddPages.AddJobPage;
import pages.GoToPages.GoToAddFeatureFormat;
import pages.GoToPages.GoToFeaturePage;
import pages.ViewPages.ViewJobPage;
import java.io.IOException;
import java.util.List;
import static org.testng.AssertJUnit.assertEquals;


public class AddJobFlowTest {
    WebElement Name, Description, Position, PayPerHour, Address;
    TakeScreenShot takeScr;

    @DataProvider
    public static Object[][] getData() throws Exception{

        List<String[]> lines = ReadCsvFile.readAllLines(Constants.ReadFolderPath+"jobInformation.csv");
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
    public void addJobTest(String jobName, String jobDiscription, String jobPosition, String jobPayPerHour , String jobAddress, String path) throws InterruptedException, IOException {
        WebDriver driver = BaseTest.Login();
        takeScr = new TakeScreenShot(driver);
        //--------------------------------------------------------------------------------------------------------------
        GoToFeaturePage gotoWorker = new GoToFeaturePage(driver, "Jobs");
        gotoWorker.gotoFeaturePageMethod();
        //--------------------------------------------------------------------------------------------------------------
        GoToAddFeatureFormat newJob = new GoToAddFeatureFormat(driver, "Create New Job");
        newJob.goToAddFeatureFormatMethod();
        //--------------------------------------------------------------------------------------------------------------
        AddJobPage newWorkers = new AddJobPage(driver);
        newWorkers.addNewJobMethod(jobName, jobDiscription, jobPosition, jobPayPerHour, jobAddress, path);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();

        Thread.sleep(10000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"jobs.png");
        //--------------------------------------------------------------------------------------------------------------
        Thread.sleep(5000);
        int jobNumber = 3;

        this.Name = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/th"));
        this.Description = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/td[1]"));
        this.Position = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/td[2]"));
        this.PayPerHour = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/td[3]"));
        this.Address = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/td[4]"));

        assertEquals(jobName, this.Name.getText());
        assertEquals(jobDiscription, this.Description.getText());
        assertEquals(jobPosition, this.Position.getText());
        assertEquals(jobPayPerHour, this.PayPerHour.getText());
        assertEquals(jobAddress, this.Address.getText());
        //--------------------------------------------------------------------------------------------------------------
        Thread.sleep(5000);
        ViewJobPage viewJob = new ViewJobPage(driver, 2);
        viewJob.viewJobMethod();


    }


}


