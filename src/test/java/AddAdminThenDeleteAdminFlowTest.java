import core.Constants;
import core.ReadCsvFile;
import core.TakeScreenShot;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddPages.AddAdminPage;
import pages.DeletePages.DeleteAdminPage;
import pages.GoToPages.GoToAddFeatureFormat;
import pages.GoToPages.GoToFeaturePage;
import java.io.IOException;
import java.util.List;
import static org.testng.AssertJUnit.assertEquals;


public class AddAdminThenDeleteAdminFlowTest {
    WebElement Name,  Email;
    TakeScreenShot takeScr;
    @DataProvider
    public static Object[][] getData() throws Exception{

        List<String[]> lines = ReadCsvFile.readAllLines(Constants.ReadFolderPath+"AdminInformation.csv");
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
    public void addAdminTest( String adminName, String adminEmail, String adminID, String adminFirstPassWord, String adminSecPassWord ) throws InterruptedException, IOException {
        WebDriver driver = BaseTest.Login();
        takeScr = new TakeScreenShot(driver);
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step3: Go to admins page");
        GoToFeaturePage gotoAdmin = new GoToFeaturePage(driver, "Admins");
        gotoAdmin.gotoFeaturePageMethod();
        Thread.sleep(2000);
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"admins.png");
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step4: Click on create new admin");
        GoToAddFeatureFormat goToNewAdmin = new GoToAddFeatureFormat(driver, "Create New Admin");
        goToNewAdmin.goToAddFeatureFormatMethod();
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step5: fill the admin information");
        Thread.sleep(5000);
        AddAdminPage newAdmin = new AddAdminPage(driver);
        newAdmin.addAdminMethod( adminName,  adminEmail,  adminID,  adminFirstPassWord,  adminSecPassWord);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();
        //--------------------------------------------------------------------------------------------------------------
        GoToFeaturePage gotoAdmin2 = new GoToFeaturePage(driver, "Admins");
        gotoAdmin2.gotoFeaturePageMethod();
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step6:assertEquals between the admin information from the csv file and the added admin");
        Thread.sleep(5000);
        int adminNumber = 2;

        this.Name = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+adminNumber+"]/th"));
        this.Email = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+adminNumber+"]/td[1]"));

        assertEquals(adminName, this.Name.getText());
        assertEquals(adminEmail, this.Email.getText());
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step7:delete the new admin");
        Thread.sleep(5000);
        DeleteAdminPage deleteAdmin = new DeleteAdminPage(driver, 2);
        deleteAdmin.deleteAdminMethod();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }


}


