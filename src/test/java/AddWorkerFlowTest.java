import core.Constants;
import core.OpenBrowsers;
import core.ReadCsvFile;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddPages.AddWorkerPage;
import pages.GoToPages.GoToAddFeatureFormat;
import pages.GoToPages.GoToFeaturePage;
import pages.LogIn.LoginPage;
import pages.ViewPages.ViewWorkerPage;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import static org.testng.AssertJUnit.assertEquals;


public class AddWorkerFlowTest {
    WebElement WorkerName, WorkerId, WorkerAddress, WorkerPhoneNumber, workerEmail, workerCompany;
    TakeScreenShot takeScr;


    @DataProvider
    public static Object[][] addWorkerData() throws Exception{

        List<String[]> lines = ReadCsvFile.readAllLines(Constants.ReadFolderPath+"workerInformation.csv");
        lines.remove(0);
        Object[][] data = new Object[lines.size()][lines.get(0).length];
        int index = 0;
        for(String[] line : lines) {
            data[index] = line;
            index++;
        }
        return data;
    }


    @Test (dataProvider = "addWorkerData")
    public void addWorkerTest(String name, String id, String address, String phoneNumber, String email, String company, String dateOfStartingJob, String dateOfFinishingJob , String path) throws InterruptedException, IOException {
        FileReader readFile = new FileReader(Constants.ReadFolderPath+"props.properties");
        Properties prop = new Properties();
        prop.load(readFile);
        String Email = prop.getProperty("email");
        String Password = prop.getProperty("password");
        //--------------------------------------------------------------------------------------------------------------
        WebDriver driver = OpenBrowsers.openBrowser("chrome");
        takeScr = new TakeScreenShot(driver);
        driver.get(Constants.LOGIN_URL);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //--------------------------------------------------------------------------------------------------------------
        LoginPage login = new LoginPage(driver);
        login.loginMethod(Email, Password);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        //--------------------------------------------------------------------------------------------------------------
        GoToFeaturePage gotoWorker = new GoToFeaturePage(driver, "Workers");
        gotoWorker.gotoFeaturePageMethod();
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"workersBeforeAdd.png");
        //--------------------------------------------------------------------------------------------------------------
        GoToAddFeatureFormat newWorker = new GoToAddFeatureFormat(driver, "Create New Wokrer");
        newWorker.goToAddFeatureFormatMethod();
        //--------------------------------------------------------------------------------------------------------------
        AddWorkerPage newWorkers = new AddWorkerPage(driver);
        newWorkers.addNewWorkerMethod(name, id, address, phoneNumber, email, company, dateOfStartingJob, dateOfFinishingJob, path);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();

        Thread.sleep(10000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"workersAfterAdd.png");
        //--------------------------------------------------------------------------------------------------------------
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
        Thread.sleep(5000);
        ViewWorkerPage viewWorker = new ViewWorkerPage(driver, 2);
        viewWorker.viewWorkerMethod();
    }


}


