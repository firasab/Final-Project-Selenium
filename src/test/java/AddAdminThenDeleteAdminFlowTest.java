import core.Constants;
import core.OpenBrowsers;
import core.ReadCsvFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddPages.AddAdminPage;
import pages.DeletePages.DeleteAdminPage;
import pages.GoToPages.GoToAddFeatureFormat;
import pages.GoToPages.GoToFeaturePage;
import pages.LogIn.LoginPage;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import static org.testng.AssertJUnit.assertEquals;


public class AddAdminThenDeleteAdminFlowTest {
    WebElement Name,  Email;

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
        FileReader readFile = new FileReader(Constants.ReadFolderPath+"props.properties");
        Properties prop = new Properties();
        prop.load(readFile);
        String Email = prop.getProperty("email");
        String Password = prop.getProperty("password");
        //--------------------------------------------------------------------------------------------------------------
        WebDriver driver = OpenBrowsers.openBrowser("chrome");
        driver.get(Constants.LOGIN_URL);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        LoginPage login = new LoginPage(driver);
        login.loginMethod(Email, Password);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        //--------------------------------------------------------------------------------------------------------------
        GoToFeaturePage gotoWorker = new GoToFeaturePage(driver, "Admins");
        gotoWorker.gotoFeaturePageMethod();
        //--------------------------------------------------------------------------------------------------------------
        GoToAddFeatureFormat goToNewAdmin = new GoToAddFeatureFormat(driver, "Create New Admin");
        goToNewAdmin.goToAddFeatureFormatMethod();
        //--------------------------------------------------------------------------------------------------------------
        AddAdminPage newAdmin = new AddAdminPage(driver);
        newAdmin.addAdminMethod( adminName,  adminEmail,  adminID,  adminFirstPassWord,  adminSecPassWord);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();
        //--------------------------------------------------------------------------------------------------------------
        Thread.sleep(5000);
        int adminNumber = 2;

        this.Name = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+adminNumber+"]/th"));
        this.Email = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+adminNumber+"]/td[1]"));

        assertEquals(adminName, this.Name.getText());
        assertEquals(adminEmail, this.Email.getText());
        //--------------------------------------------------------------------------------------------------------------
        Thread.sleep(5000);
        DeleteAdminPage deleteAdmin = new DeleteAdminPage(driver, 2);
        deleteAdmin.deleteAdminMethod();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }


}


