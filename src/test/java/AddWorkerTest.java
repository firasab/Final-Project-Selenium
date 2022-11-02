import core.OpenBrowsers;
import core.ReadCsvFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddWorkerPage;
import pages.GoToAddFeatureFormat;
import pages.GoToFeaturePage;
import pages.LoginPage;

import java.util.List;


public class AddWorkerTest {
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

        //linkTextPath of add company = Create New Copmany
        //linkTextPath of add job = Create New Job

        GoToAddFeatureFormat newWorker = new GoToAddFeatureFormat(driver, "Create New Wokrer");
        newWorker.goToAddFeatureFormatMethod();


        AddWorkerPage newWorkers = new AddWorkerPage(driver);
        newWorkers.addNewWorkerMethod("ahmad", "203256232", "jerusalem", "0545543624", "ahmad.abu.sneneh@hotail.com", "group", "12/02/2022", "18/02/2022");
        Thread.sleep(10000);
        driver.switchTo().alert().accept();

    }


}


