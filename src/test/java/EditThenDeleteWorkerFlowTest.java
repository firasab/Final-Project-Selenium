import core.Constants;
import core.ReadCsvFile;
import core.TakeScreenShot;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DeletePages.DeleteWorkerPage;
import pages.EditPages.EditWorkerFormatPage;
import pages.EditPages.EditWorkerPage;
import pages.GoToPages.GoToFeaturePage;
import pages.ViewPages.ViewWorkerPage;
import java.io.IOException;
import java.util.List;
import static org.testng.AssertJUnit.assertEquals;


public class EditThenDeleteWorkerFlowTest {
    WebElement WorkerName, WorkerId, WorkerAddress, WorkerPhoneNumber, workerEmail, workerCompany;
    TakeScreenShot takeScr;
    @DataProvider
    public static Object[][] getData() throws Exception{
        List<String[]> lines = ReadCsvFile.readAllLines(Constants.ReadFolderPath+"editWorkerInformation.csv");
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
    public void editWorkerTest( String name, String id, String address, String phoneNumber, String email, String company, String dateOfFinishingJob ,String path) throws InterruptedException, IOException {
        WebDriver driver = BaseTest.Login();
        takeScr = new TakeScreenShot(driver);
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step3: Go to Workers page");
        GoToFeaturePage gotoWorker = new GoToFeaturePage(driver, "Workers");
        gotoWorker.gotoFeaturePageMethod();
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"WorkersBeforeEdit.png");
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step4: Click on edit Worker");
        EditWorkerPage editWorker = new EditWorkerPage(driver, 2);
        editWorker.editWorkerMethod();
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step5: fill the job information");
        EditWorkerFormatPage editWorker1 = new EditWorkerFormatPage(driver);
        editWorker1.editWorkerMethod(name, id, address, phoneNumber, email, company, dateOfFinishingJob, path);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();

        Thread.sleep(10000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"editWorkers.png");
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step6:assertEquals between the worker information from the csv file and the edited worker");
        int workerNumber = 2;

        this.WorkerName = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+workerNumber+"]/th"));
        this.WorkerId = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+workerNumber+"]/td[1]"));
        this.WorkerAddress = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+workerNumber+"]/td[2]"));
        this.WorkerPhoneNumber = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+workerNumber+"]/td[3]"));
        this.workerEmail = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+workerNumber+"]/td[4]"));
        this.workerCompany = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+workerNumber+"]/td[5]"));

        assertEquals(name, this.WorkerName.getText());
        assertEquals(id, this.WorkerId.getText());
        assertEquals(address, this.WorkerAddress.getText());
        assertEquals(phoneNumber, this.WorkerPhoneNumber.getText());
        assertEquals(email, this.workerEmail.getText());
        assertEquals(company, this.workerCompany.getText());
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step7:View the new worker profile");
        Thread.sleep(5000);
        ViewWorkerPage viewWorker = new ViewWorkerPage(driver, 2);
        viewWorker.viewWorkerMethod();
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step8: Go to Workers page");
        Thread.sleep(5000);
        GoToFeaturePage gotoDeleteWorker = new GoToFeaturePage(driver, "Workers");
        gotoDeleteWorker.gotoFeaturePageMethod();
        Thread.sleep(5000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"WorkersBeforeDelete.png");
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step9: delete Worker");
        DeleteWorkerPage deleteWorker = new DeleteWorkerPage(driver, 2);
        deleteWorker.deleteWorkerMethod();
        Thread.sleep(5000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"WorkersAfterDelete.png");
        driver.switchTo().alert().accept();
    }


}


