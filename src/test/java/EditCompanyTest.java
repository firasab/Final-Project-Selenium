import core.Constants;
import core.OpenBrowsers;
import core.ReadCsvFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EditPages.EditCompanyFormatPage;
import pages.EditPages.EditCompanyPage;
import pages.EditPages.EditJobFormatPage;
import pages.EditPages.EditJobPage;
import pages.GoToPages.GoToFeaturePage;
import pages.LogIn.LoginPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


public class EditCompanyTest {
    @DataProvider
    public static Object[][] getData() throws Exception{

        List<String[]> lines = ReadCsvFile.readAllLines(Constants.ReadFolderPath+"editCompanyInformation.csv");
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
    public void editCompanyTest(String companyName, String companyField, String companyNumberOfWorker, String companyAddress, String path ) throws InterruptedException, IOException {

        FileReader readFile = new FileReader(Constants.ReadFolderPath+"props.properties");
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
        GoToFeaturePage gotoWorker = new GoToFeaturePage(driver, "Companies");
        gotoWorker.gotoFeaturePageMethod();

        //linkTextPath of add company = Create New Copmany
        //linkTextPath of add job = Create New Job

        EditCompanyPage editCompany = new EditCompanyPage(driver, 2);
        editCompany.editCompanyMethod();


        EditCompanyFormatPage editCompany1 = new EditCompanyFormatPage(driver);
        editCompany1.editCompanyMethod(companyName, companyField, companyNumberOfWorker, companyAddress, path);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();

    }


}


