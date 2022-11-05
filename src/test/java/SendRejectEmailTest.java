import core.Constants;
import core.OpenBrowsers;
import core.ReadCsvFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GoToPages.GoToFeaturePage;
import pages.LogIn.LoginPage;
import pages.SendEmail.EmailSenderPage;
import pages.SendEmail.SendRejectEmailPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


public class SendRejectEmailTest {


    @Test
    public void sendRejectEmailTest( ) throws InterruptedException, IOException {

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
        GoToFeaturePage gotoWorker = new GoToFeaturePage(driver, "Check Jobs Forms");
        gotoWorker.gotoFeaturePageMethod();

        SendRejectEmailPage sendEmail = new SendRejectEmailPage(driver, 1);
        sendEmail.SendRejectEmailPageMethod();
        Thread.sleep(5000);
        EmailSenderPage sender = new EmailSenderPage(driver);
        sender.emailSenderPageMethod();
        Thread.sleep(10000);

    }


}


