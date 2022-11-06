import core.Constants;
import core.OpenBrowsers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.DeletePages.DeleteJobApplicationPage;
import pages.GoToPages.GoToFeaturePage;
import pages.LogIn.LoginPage;
import pages.SendEmail.EmailSenderPage;
import pages.SendEmail.SendAcceptEmailPage;
import pages.SendEmail.SendRejectEmailPage;
import pages.ViewPages.ViewJobApplicationPage;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class SendAcceptEmailThenRejectEmailThenDeleteJobAppFlowTest {


    @Test
    public void viewJobApplicationTest() throws InterruptedException, IOException {

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


        GoToFeaturePage gotoJobApp = new GoToFeaturePage(driver, "Check Jobs Forms");
        gotoJobApp.gotoFeaturePageMethod();

        Thread.sleep(10000);
        ViewJobApplicationPage viewJobApp = new ViewJobApplicationPage(driver , 1);
        viewJobApp.getJobsApplicationPageMethod();

        SendAcceptEmailPage sendAcceptEmail = new SendAcceptEmailPage(driver, 1);
        sendAcceptEmail.sendAcceptEmailPageMethod();
        Thread.sleep(5000);
        EmailSenderPage AcceptSender = new EmailSenderPage(driver);
        AcceptSender.emailSenderPageMethod();
        Thread.sleep(10000);

        GoToFeaturePage gotoJobApplication = new GoToFeaturePage(driver, "Check Jobs Forms");
        gotoJobApplication.gotoFeaturePageMethod();
        Thread.sleep(5000);

        SendRejectEmailPage sendRejectEmail = new SendRejectEmailPage(driver, 1);
        sendRejectEmail.SendRejectEmailPageMethod();
        Thread.sleep(5000);
        EmailSenderPage RejectSender = new EmailSenderPage(driver);
        RejectSender.emailSenderPageMethod();
        Thread.sleep(10000);

        DeleteJobApplicationPage deleteApplicationJob = new DeleteJobApplicationPage(driver, 1);
        deleteApplicationJob.deleteJobApplicationMethod();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();



    }


}


