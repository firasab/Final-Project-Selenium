import core.Constants;
import core.ReadCsvFile;
import core.TakeScreenShot;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddPages.AddCompanyPage;
import pages.GoToPages.GoToAddFeatureFormat;
import pages.GoToPages.GoToFeaturePage;
import pages.ViewPages.ViewCompanyPage;
import java.io.IOException;
import java.util.List;
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
        WebDriver driver = BaseTest.Login();
        takeScr = new TakeScreenShot(driver);
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step3: Go to company page");
        GoToFeaturePage gotoWorker = new GoToFeaturePage(driver, "Companies");
        gotoWorker.gotoFeaturePageMethod();
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"companiesBeforeAdd.png");
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step4: Click on create new company");
        GoToAddFeatureFormat newWorker = new GoToAddFeatureFormat(driver, "Create New Copmany");
        newWorker.goToAddFeatureFormatMethod();
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step5: fill the company information");
        AddCompanyPage newCompany = new AddCompanyPage(driver);
        newCompany.addNewCompanyMethod( companyName, companyField, companyNumberOfWorker, companyAddress, path);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();

        Thread.sleep(10000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"companies.png");
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step6:assertEquals between the company information from the csv file and the added company");
        int jobNumber = 2;

        this.Name = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/th"));
        this.Field = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/td[1]"));
        this.NumberOfWorker = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/td[2]"));
        this.Address = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/td[3]"));

        assertEquals(companyName, this.Name.getText());
        assertEquals(companyField, this.Field.getText());
        assertEquals(companyNumberOfWorker, this.NumberOfWorker.getText());
        assertEquals(companyAddress, this.Address.getText());
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step7:View the new company profile");
        Thread.sleep(5000);
        ViewCompanyPage viewCompany = new ViewCompanyPage(driver, 2);
        viewCompany.viewCompanyMethod();
    }


}


