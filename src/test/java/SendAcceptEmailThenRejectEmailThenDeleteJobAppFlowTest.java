import core.Constants;
import core.TakeScreenShot;
import io.qameta.allure.Allure;
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
    TakeScreenShot takeScr;
    @Test
    public void viewJobApplicationTest() throws InterruptedException, IOException {
        WebDriver driver = BaseTest.Login();
        takeScr = new TakeScreenShot(driver);
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step3: Go to Check Jobs Forms page");
        GoToFeaturePage gotoJobApp = new GoToFeaturePage(driver, "Check Jobs Forms");
        gotoJobApp.gotoFeaturePageMethod();
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"jobForms.png");
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step4: get the applier information");
        Thread.sleep(10000);
        ViewJobApplicationPage viewJobApp = new ViewJobApplicationPage(driver , 1);
        viewJobApp.getJobsApplicationPageMethod();
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step5: send accept email");
        SendAcceptEmailPage sendAcceptEmail = new SendAcceptEmailPage(driver, 1);
        sendAcceptEmail.sendAcceptEmailPageMethod();
        Thread.sleep(5000);
        EmailSenderPage AcceptSender = new EmailSenderPage(driver);
        AcceptSender.emailSenderPageMethod();
        Thread.sleep(10000);
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step6: Go to Check Jobs Forms page");
        GoToFeaturePage gotoJobApplication = new GoToFeaturePage(driver, "Check Jobs Forms");
        gotoJobApplication.gotoFeaturePageMethod();
        Thread.sleep(5000);
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step7: send reject email");
        SendRejectEmailPage sendRejectEmail = new SendRejectEmailPage(driver, 1);
        sendRejectEmail.SendRejectEmailPageMethod();
        Thread.sleep(5000);
        EmailSenderPage RejectSender = new EmailSenderPage(driver);
        RejectSender.emailSenderPageMethod();
        Thread.sleep(10000);
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step8: Go to Check Jobs Forms page");
        GoToFeaturePage gotoJobApplications = new GoToFeaturePage(driver, "Check Jobs Forms");
        gotoJobApplications.gotoFeaturePageMethod();
        Thread.sleep(5000);
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step9: delete the application");
        DeleteJobApplicationPage deleteApplicationJob = new DeleteJobApplicationPage(driver, 1);
        deleteApplicationJob.deleteJobApplicationMethod();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }


}


