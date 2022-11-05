import core.Constants;
import core.OpenBrowsers;
import core.ReadCsvFile;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EditPages.EditWorkerFormatPage;
import pages.EditPages.EditWorkerPage;
import pages.GoToPages.GoToFeaturePage;
import pages.LogIn.LoginPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import static org.testng.AssertJUnit.assertEquals;


public class EditWorkerTest {
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

        //jobs pagePath = Jobs
        //companies pagePath = Companies
        //admin pagePath = Admins
        //createSchedule pagePath = Create Weekly Schedule
        //jobForm pagePath = Check Jobs Forms
        GoToFeaturePage gotoWorker = new GoToFeaturePage(driver, "Workers");
        gotoWorker.gotoFeaturePageMethod();

        //linkTextPath of add company = Create New Copmany
        //linkTextPath of add job = Create New Job
        EditWorkerPage editWorker = new EditWorkerPage(driver, 2);
        editWorker.editWorkerMethod();


        EditWorkerFormatPage editWorker1 = new EditWorkerFormatPage(driver);
        editWorker1.editWorkerMethod(name, id, address, phoneNumber, email, company, dateOfFinishingJob, path);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();

        Thread.sleep(10000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"editWorkers.png");

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

    }


}


