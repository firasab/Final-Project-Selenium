import core.OpenBrowsers;
import core.ReadCsvFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DeleteJobPage;
import pages.DeleteWorkerPage;
import pages.GoToFeaturePage;
import pages.LoginPage;

import java.util.List;


public class DeleteWorkerTest {
    @DataProvider
    public static Object[][] getData() throws Exception{

        List<String[]> lines = ReadCsvFile.readAllLines("loginInfo.csv");
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
    public void testExpediaLinks(String email, String password) throws InterruptedException {

        WebDriver driver = OpenBrowsers.openBrowser("chrome");
        driver.get("https://myjobs-1956b.web.app/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        LoginPage login = new LoginPage(driver);
        login.loginMethod(email, password);
        Thread.sleep(10000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);

        //jobs pagePath = Jobs
        //companies pagePath = Companies
        //admin pagePath = Admins
        //createSchedule pagePath = Create Weekly Schedule
        //jobForm pagePath = Check Jobs Forms
        GoToFeaturePage gotoWorker = new GoToFeaturePage(driver, "Workers");
        gotoWorker.gotoFeaturePageMethod();

        DeleteWorkerPage deleteWorker = new DeleteWorkerPage(driver, 2);
        deleteWorker.deleteWorkerMethod();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();

    }


}


