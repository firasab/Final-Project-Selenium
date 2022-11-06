import core.Constants;
import core.OpenBrowsers;
import core.ReadCsvFile;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddPages.AddCompanyPage;
import pages.GoToPages.GoToAddFeatureFormat;
import pages.GoToPages.GoToFeaturePage;
import pages.LogIn.LoginPage;
import pages.ViewPages.ViewCompanyPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static org.testng.AssertJUnit.assertEquals;


public class AddCompanyFlowTest {
    WebElement Name, Field, NumberOfWorker, Address;
    TakeScreenShot takeScr;
    @DataProvider
    public static Object[][] getData() throws Exception{

        List<String[]> lines = ReadCsvFile.readAllLines(Constants.ReadFolderPath+"companyInformation.csv");
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
    public void addCompanyTest( String companyName, String companyField, String companyNumberOfWorker, String companyAddress, String path) throws InterruptedException, IOException {

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
        GoToFeaturePage gotoWorker = new GoToFeaturePage(driver, "Companies");
        gotoWorker.gotoFeaturePageMethod();

        //linkTextPath of add company = Create New Copmany
        //linkTextPath of add job = Create New Job

        GoToAddFeatureFormat newWorker = new GoToAddFeatureFormat(driver, "Create New Copmany");
        newWorker.goToAddFeatureFormatMethod();


        AddCompanyPage newCompany = new AddCompanyPage(driver);
        newCompany.addNewCompanyMethod( companyName, companyField, companyNumberOfWorker, companyAddress, path);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();

        Thread.sleep(10000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"companies.png");

        int jobNumber = 2;

        this.Name = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/th"));
        this.Field = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/td[1]"));
        this.NumberOfWorker = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/td[2]"));
        this.Address = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/td[3]"));

        assertEquals(companyName, this.Name.getText());
        assertEquals(companyField, this.Field.getText());
        assertEquals(companyNumberOfWorker, this.NumberOfWorker.getText());
        assertEquals(companyAddress, this.Address.getText());

        Thread.sleep(5000);
        ViewCompanyPage viewCompany = new ViewCompanyPage(driver, 2);
        viewCompany.viewCompanyMethod();




    }


}

