import core.Constants;
import core.OpenBrowsers;
import core.ReadCsvFile;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DeletePages.DeleteJobPage;
import pages.EditPages.EditJobFormatPage;
import pages.EditPages.EditJobPage;
import pages.GoToPages.GoToFeaturePage;
import pages.LogIn.LoginPage;
import pages.ViewPages.ViewJobPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static org.testng.AssertJUnit.assertEquals;


public class EditThenDeleteJobFlowTest {
    WebElement Name, Description, Position, PayPerHour, Address;
    TakeScreenShot takeScr;

    @DataProvider
    public static Object[][] getData() throws Exception{

        List<String[]> lines = ReadCsvFile.readAllLines(Constants.ReadFolderPath+"editJobInformation.csv");
        lines.remove(0);
        Object[][] data = new Object[lines.size()][lines.get(0).length];
        int index = 0;
        for(String[] line : lines) {
            data[index] = line;
            index++;
        }
        return data;
    }


    @Test (dataProvider = "getData")
    public void editJobTest(String jobName, String jobDiscription, String jobPosition, String jobPayPerHour , String jobAddress, String path ) throws InterruptedException, IOException {

        FileReader readFile = new FileReader(Constants.ReadFolderPath+"props.properties");
        Properties prop = new Properties();
        prop.load(readFile);
        String Email = prop.getProperty("email");
        String Password = prop.getProperty("password");

        WebDriver driver = OpenBrowsers.openBrowser("chrome");
        takeScr = new TakeScreenShot(driver);
        driver.get(Constants.LOGIN_URL);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        LoginPage login = new LoginPage(driver);
        login.loginMethod(Email, Password);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);


        GoToFeaturePage gotoWorker = new GoToFeaturePage(driver, "Jobs");
        gotoWorker.gotoFeaturePageMethod();


        EditJobPage editJob = new EditJobPage(driver, 2);
        editJob.editJobMethod();


        EditJobFormatPage editJob1 = new EditJobFormatPage(driver);
        editJob1.editJobMethod(jobName, jobDiscription, jobPosition, jobPayPerHour, jobAddress, path);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();

        Thread.sleep(10000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"editJobs.png");

        int jobNumber = 2;

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

        Thread.sleep(5000);
        ViewJobPage viewJob = new ViewJobPage(driver, 2);
        viewJob.viewJobMethod();

        Thread.sleep(5000);
        GoToFeaturePage gotoDeleteJob = new GoToFeaturePage(driver, "Jobs");
        gotoDeleteJob.gotoFeaturePageMethod();

        DeleteJobPage deleteJob = new DeleteJobPage(driver, 2);
        deleteJob.deleteJobMethod();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();

    }


}

