import core.Constants;
import core.ReadCsvFile;
import core.TakeScreenShot;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DeletePages.DeleteJobPage;
import pages.EditPages.EditJobFormatPage;
import pages.EditPages.EditJobPage;
import pages.GoToPages.GoToFeaturePage;
import pages.ViewPages.ViewJobPage;
import java.io.IOException;
import java.util.List;
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
        WebDriver driver = BaseTest.Login();
        takeScr = new TakeScreenShot(driver);
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step3: Go to Jobs page");
        GoToFeaturePage gotoWorker = new GoToFeaturePage(driver, "Jobs");
        gotoWorker.gotoFeaturePageMethod();
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"JobsBeforeEdit.png");
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step4: Click on edit job");
        EditJobPage editJob = new EditJobPage(driver, 2);
        editJob.editJobMethod();
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step5: fill the job information");
        EditJobFormatPage editJob1 = new EditJobFormatPage(driver);
        editJob1.editJobMethod(jobName, jobDiscription, jobPosition, jobPayPerHour, jobAddress, path);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();

        Thread.sleep(10000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"editJobs.png");
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step6:assertEquals between the job information from the csv file and the edited job");
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
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step7:View the new job profile");
        Thread.sleep(5000);
        ViewJobPage viewJob = new ViewJobPage(driver, 2);
        viewJob.viewJobMethod();
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step8: Go to Jobs page");
        Thread.sleep(5000);
        GoToFeaturePage gotoDeleteJob = new GoToFeaturePage(driver, "Jobs");
        gotoDeleteJob.gotoFeaturePageMethod();
        Thread.sleep(5000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"JobsBeforeDelete.png");
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step9: delete Job");
        DeleteJobPage deleteJob = new DeleteJobPage(driver, 2);
        deleteJob.deleteJobMethod();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }


}


