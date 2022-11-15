import core.Constants;
import core.ReadCsvFile;
import core.TakeScreenShot;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DeletePages.DeleteCompanyPage;
import pages.EditPages.EditCompanyFormatPage;
import pages.EditPages.EditCompanyPage;
import pages.GoToPages.GoToFeaturePage;
import pages.ViewPages.ViewCompanyPage;
import java.io.IOException;
import java.util.List;
import static org.testng.AssertJUnit.assertEquals;


public class EditThenDeleteCompanyFlowTest {
    WebElement Name, Field, NumberOfWorker, Address;
    TakeScreenShot takeScr;
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
        WebDriver driver = BaseTest.Login();
        takeScr = new TakeScreenShot(driver);
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step3: Go to Companies page");
        GoToFeaturePage gotoWorker = new GoToFeaturePage(driver, "Companies");
        gotoWorker.gotoFeaturePageMethod();
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"CompaniesBeforeEdit.png");
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step4: Click on edit company");
        EditCompanyPage editCompany = new EditCompanyPage(driver, 2);
        editCompany.editCompanyMethod();
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step5: fill the company information");
        EditCompanyFormatPage editCompany1 = new EditCompanyFormatPage(driver);
        editCompany1.editCompanyMethod(companyName, companyField, companyNumberOfWorker, companyAddress, path);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();

        Thread.sleep(10000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"editCompanies.png");
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step6:assertEquals between the company information from the csv file and the edited company");
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
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step8: Go to Companies page");
        Thread.sleep(5000);
        GoToFeaturePage gotoDeleteCompany = new GoToFeaturePage(driver, "Companies");
        gotoDeleteCompany.gotoFeaturePageMethod();
        Thread.sleep(5000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"CompaniesBeforeDelete.png");
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step9: delete Company");
        DeleteCompanyPage deleteCompany = new DeleteCompanyPage(driver, 2);
        deleteCompany.deleteCompanyMethod();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }


}


