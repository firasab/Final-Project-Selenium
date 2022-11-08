import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.DeletePages.DeleteJobApplicationPage;
import pages.GoToPages.GoToFeaturePage;
import pages.SendEmail.EmailSenderPage;
import pages.SendEmail.SendAcceptEmailPage;
import pages.SendEmail.SendRejectEmailPage;
import pages.ViewPages.ViewJobApplicationPage;
import java.io.IOException;


public class SendAcceptEmailThenRejectEmailThenDeleteJobAppFlowTest {
    @Test
    public void viewJobApplicationTest() throws InterruptedException, IOException {
        WebDriver driver = BaseTest.Login();
        //--------------------------------------------------------------------------------------------------------------
        GoToFeaturePage gotoJobApp = new GoToFeaturePage(driver, "Check Jobs Forms");
        gotoJobApp.gotoFeaturePageMethod();
        //--------------------------------------------------------------------------------------------------------------
        Thread.sleep(10000);
        ViewJobApplicationPage viewJobApp = new ViewJobApplicationPage(driver , 1);
        viewJobApp.getJobsApplicationPageMethod();
        //--------------------------------------------------------------------------------------------------------------
        SendAcceptEmailPage sendAcceptEmail = new SendAcceptEmailPage(driver, 1);
        sendAcceptEmail.sendAcceptEmailPageMethod();
        Thread.sleep(5000);
        EmailSenderPage AcceptSender = new EmailSenderPage(driver);
        AcceptSender.emailSenderPageMethod();
        Thread.sleep(10000);
        //--------------------------------------------------------------------------------------------------------------
        GoToFeaturePage gotoJobApplication = new GoToFeaturePage(driver, "Check Jobs Forms");
        gotoJobApplication.gotoFeaturePageMethod();
        Thread.sleep(5000);
        //--------------------------------------------------------------------------------------------------------------
        SendRejectEmailPage sendRejectEmail = new SendRejectEmailPage(driver, 1);
        sendRejectEmail.SendRejectEmailPageMethod();
        Thread.sleep(5000);
        EmailSenderPage RejectSender = new EmailSenderPage(driver);
        RejectSender.emailSenderPageMethod();
        Thread.sleep(10000);
        //--------------------------------------------------------------------------------------------------------------
        GoToFeaturePage gotoJobApplications = new GoToFeaturePage(driver, "Check Jobs Forms");
        gotoJobApplications.gotoFeaturePageMethod();
        Thread.sleep(5000);
        //--------------------------------------------------------------------------------------------------------------
        DeleteJobApplicationPage deleteApplicationJob = new DeleteJobApplicationPage(driver, 1);
        deleteApplicationJob.deleteJobApplicationMethod();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }


}


