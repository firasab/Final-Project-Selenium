import core.Constants;
import core.OpenBrowsers;
import core.ReadCsvFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EditPages.EditJobFormatPage;
import pages.EditPages.EditJobPage;
import pages.EditPages.EditWorkerFormatPage;
import pages.EditPages.EditWorkerPage;
import pages.GoToPages.GoToFeaturePage;
import pages.LogIn.LoginPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


public class EditJobTest {

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

        FileReader readFile = new FileReader("props.properties");
        Properties prop = new Properties();
        prop.load(readFile);
        String Email = prop.getProperty("email");
        String Password = prop.getProperty("password");

        WebDriver driver = OpenBrowsers.openBrowser("chrome");
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
        GoToFeaturePage gotoWorker = new GoToFeaturePage(driver, "Jobs");
        gotoWorker.gotoFeaturePageMethod();

        //linkTextPath of add company = Create New Copmany
        //linkTextPath of add job = Create New Job

        EditJobPage editJob = new EditJobPage(driver, 2);
        editJob.editJobMethod();


        EditJobFormatPage editJob1 = new EditJobFormatPage(driver);
        editJob1.editJobMethod(jobName, jobDiscription, jobPosition, jobPayPerHour, jobAddress, path);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();

    }


}


