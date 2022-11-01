import core.OpenBrowsers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.AboutWebPage;



public class AboutUsPageTest {
    @Test
    public void workWithComboBox() throws InterruptedException {
            WebDriver driver = OpenBrowsers.openBrowser("chrome");
            driver.get("https://myjobs-1956b.web.app/login");
            driver.manage().window().maximize();
            Thread.sleep(5000);
        AboutWebPage aboutUs = new AboutWebPage(driver);
            aboutUs.getAboutUsPage();
    }
}